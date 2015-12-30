package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dx extends bp<com.baidu.tbadk.core.data.w, dy> implements View.OnClickListener, PhotoLiveCardView.b {
    /* JADX INFO: Access modifiers changed from: protected */
    public dx(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public dy a(ViewGroup viewGroup) {
        return new dy(LayoutInflater.from(this.mContext).inflate(n.h.frs_item_single_photolivecard, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dy dyVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) dyVar);
        if (dyVar.ahf != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.bbA.getPageContext(), view);
            dyVar.ahf = this.mSkinType;
        }
        PhotoLiveCardData sh = wVar.sh();
        if (2 == b(sh)) {
            dyVar.biu.setShowContent(true);
            dyVar.biu.setShowCover(false);
            dyVar.biu.setShowExpression(false);
        } else {
            dyVar.biu.setShowContent(false);
            dyVar.biu.setShowCover(true);
            dyVar.biu.setShowExpression(true);
        }
        dyVar.biu.setChooseStyle(sh.getShowStyle());
        dyVar.biu.setShowLiveIcon(true);
        dyVar.biu.setHeadPaddingTop(n.e.ds24);
        dyVar.biu.setPortraitClicklistener(this);
        dyVar.biu.setShowImage(com.baidu.tbadk.core.m.qQ().qW());
        if (sh.isShowDiffViewInSameAdapter()) {
            dyVar.biu.setShowBottom(true);
            dyVar.biu.setShowRefreshTimeInButtom(true);
            dyVar.biu.setShowHeadLiveIcon(true);
            dyVar.biu.setShowRefreshTimeInHead(false);
            dyVar.biu.setContentPaddingBottom(0);
        } else {
            dyVar.biu.setShowBottom(false);
            dyVar.biu.setShowRefreshTimeInHead(true);
            dyVar.biu.setShowHeadLiveIcon(false);
            dyVar.biu.setShowRefreshTimeInButtom(false);
            dyVar.biu.setContentPaddingBottom(n.e.ds36);
        }
        dyVar.biu.setData(sh);
        return view;
    }

    private int b(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != n.g.live_card_layout || !this.bbA.checkUpIsLogin()) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10246").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }
}
