package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.g.e;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bj extends au<com.baidu.tbadk.core.data.au, bk> implements View.OnClickListener, PhotoLiveCardView.b, e {
    private TbPageContext<?> GO;
    private com.baidu.tbadk.core.data.au bAW;

    public bj(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.GO = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bk a(ViewGroup viewGroup) {
        return new bk(LayoutInflater.from(this.mContext).inflate(r.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.au, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.au auVar, bk bkVar) {
        super.a(i, view, viewGroup, (ViewGroup) auVar, (com.baidu.tbadk.core.data.au) bkVar);
        if (bkVar.aib != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.aSs.getPageContext(), view);
            bkVar.aib = this.mSkinType;
        }
        this.bAW = auVar;
        bkVar.bAX.setOnClickListener(this);
        bkVar.bAX.setTag(auVar);
        bkVar.bAY.setShowBottom(false);
        bkVar.bAY.setShowContent(false);
        bkVar.bAY.setShowRefreshTimeInHead(true);
        bkVar.bAY.setShowLiveIcon(true);
        bkVar.bAY.setHeadPaddingTop(0);
        bkVar.bAY.setChooseStyle(auVar.qM().getShowStyle());
        bkVar.bAY.setShowImage(com.baidu.tbadk.core.l.oJ().oP());
        bkVar.bAY.setData(auVar.qM());
        bkVar.bAY.setPortraitClicklistener(this);
        bkVar.bAZ.setOnClickListener(this);
        bkVar.bAZ.setTag(auVar);
        if (auVar != null) {
            auVar.sB();
        }
        com.baidu.tieba.frs.g.b.abq().a(bMV, auVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.au) {
            this.bzz.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.au) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.GO.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10178").ab("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.g.b.abq().a(bMV, this.bAW, 2);
    }

    public int XR() {
        return r.g.more_live_list;
    }

    public int XS() {
        return r.g.make_headlines;
    }
}
