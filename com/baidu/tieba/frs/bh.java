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
import com.baidu.tieba.frs.e.b;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bh extends at<com.baidu.tbadk.core.data.av, bi> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> FY;
    private com.baidu.tbadk.core.data.av bIq;

    public bh(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.FY = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public bi onCreateViewHolder(ViewGroup viewGroup) {
        return new bi(LayoutInflater.from(this.mContext).inflate(r.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.av avVar, bi biVar) {
        super.onFillViewHolder(i, view, viewGroup, avVar, biVar);
        if (biVar.ahp != this.mSkinType) {
            a.a(this.aWr.getPageContext(), view);
            biVar.ahp = this.mSkinType;
        }
        this.bIq = avVar;
        biVar.bIr.setOnClickListener(this);
        biVar.bIr.setTag(avVar);
        biVar.bIs.setShowBottom(false);
        biVar.bIs.setShowContent(false);
        biVar.bIs.setShowRefreshTimeInHead(true);
        biVar.bIs.setShowLiveIcon(true);
        biVar.bIs.setHeadPaddingTop(0);
        biVar.bIs.setChooseStyle(avVar.qF().getShowStyle());
        biVar.bIs.setShowImage(com.baidu.tbadk.core.l.oC().oI());
        biVar.bIs.setData(avVar.qF());
        biVar.bIs.setPortraitClicklistener(this);
        biVar.bIt.setOnClickListener(this);
        biVar.bIt.setTag(avVar);
        if (avVar != null) {
            avVar.st();
        }
        b.acx().a(bTj, avVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.av) {
            this.bGZ.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.av) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.FY.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10178").ab("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.acx().a(bTj, this.bIq, 2);
    }

    public int YY() {
        return r.h.more_live_list;
    }

    public int YZ() {
        return r.h.make_headlines;
    }
}
