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
import com.baidu.tbadk.i.a;
import com.baidu.tieba.frs.g.b;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cb extends bf<com.baidu.tbadk.core.data.at, cc> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private com.baidu.tbadk.core.data.at bSx;

    public cb(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.GM = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public cc a(ViewGroup viewGroup) {
        return new cc(LayoutInflater.from(this.mContext).inflate(r.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.at atVar, cc ccVar) {
        super.a(i, view, viewGroup, (ViewGroup) atVar, (com.baidu.tbadk.core.data.at) ccVar);
        if (ccVar.ahV != this.mSkinType) {
            a.a(this.aRd.getPageContext(), view);
            ccVar.ahV = this.mSkinType;
        }
        this.bSx = atVar;
        ccVar.bSy.setOnClickListener(this);
        ccVar.bSy.setTag(atVar);
        ccVar.bSz.setShowBottom(false);
        ccVar.bSz.setShowContent(false);
        ccVar.bSz.setShowRefreshTimeInHead(true);
        ccVar.bSz.setShowLiveIcon(true);
        ccVar.bSz.setHeadPaddingTop(0);
        ccVar.bSz.setChooseStyle(atVar.qJ().getShowStyle());
        ccVar.bSz.setShowImage(com.baidu.tbadk.core.l.oH().oN());
        ccVar.bSz.setData(atVar.qJ());
        ccVar.bSz.setPortraitClicklistener(this);
        ccVar.bSA.setOnClickListener(this);
        ccVar.bSA.setTag(atVar);
        if (atVar != null) {
            atVar.sL();
        }
        b.afl().a(cdl, atVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.at) {
            this.bQG.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.at) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.GM.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10178").ab("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.afl().a(cdl, this.bSx, 2);
    }

    public int act() {
        return r.g.more_live_list;
    }

    public int acu() {
        return r.g.make_headlines;
    }
}
