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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dh extends bn<com.baidu.tbadk.core.data.s, di> implements View.OnClickListener, PhotoLiveCardView.b {
    /* JADX INFO: Access modifiers changed from: protected */
    public dh(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public di a(ViewGroup viewGroup) {
        return new di(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_single_photolivecard, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.s sVar, di diVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tbadk.core.data.s) diVar);
        com.baidu.tbadk.h.a.a(this.aRT.getPageContext(), view);
        PhotoLiveCardData sc = sVar.sc();
        if (2 == b(sc)) {
            diVar.aYh.setShowContent(true);
            diVar.aYh.setShowCover(false);
            diVar.aYh.setShowExpression(false);
        } else {
            diVar.aYh.setShowContent(false);
            diVar.aYh.setShowCover(true);
            diVar.aYh.setShowExpression(true);
        }
        diVar.aYh.setContentPaddingBottom(i.d.ds36);
        diVar.aYh.setShowBottom(false);
        diVar.aYh.setChooseStyle(sc.getShowStyle());
        diVar.aYh.setShowRefreshTimeInHead(true);
        diVar.aYh.setShowLiveIcon(true);
        diVar.aYh.setHeadPaddingTop(i.d.ds24);
        diVar.aYh.setPortraitClicklistener(this);
        diVar.aYh.setShowImage(com.baidu.tbadk.core.m.qX().rb());
        diVar.aYh.setData(sc);
        return view;
    }

    private int b(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != i.f.live_card_layout || !this.aRT.checkUpIsLogin()) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10246").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }
}
