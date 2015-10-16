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
public class dh extends bn<com.baidu.tbadk.core.data.t, di> implements View.OnClickListener, PhotoLiveCardView.b {
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.t tVar, di diVar) {
        super.a(i, view, viewGroup, (ViewGroup) tVar, (com.baidu.tbadk.core.data.t) diVar);
        com.baidu.tbadk.h.a.a(this.aSe.getPageContext(), view);
        PhotoLiveCardData sc = tVar.sc();
        if (2 == b(sc)) {
            diVar.aYs.setShowContent(true);
            diVar.aYs.setShowCover(false);
            diVar.aYs.setShowExpression(false);
        } else {
            diVar.aYs.setShowContent(false);
            diVar.aYs.setShowCover(true);
            diVar.aYs.setShowExpression(true);
        }
        diVar.aYs.setContentPaddingBottom(i.d.ds36);
        diVar.aYs.setShowBottom(false);
        diVar.aYs.setChooseStyle(sc.getShowStyle());
        diVar.aYs.setShowRefreshTimeInHead(true);
        diVar.aYs.setShowLiveIcon(true);
        diVar.aYs.setHeadPaddingTop(i.d.ds24);
        diVar.aYs.setPortraitClicklistener(this);
        diVar.aYs.setShowImage(com.baidu.tbadk.core.m.qX().rb());
        diVar.aYs.setData(sc);
        return view;
    }

    private int b(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != i.f.live_card_layout || !this.aSe.checkUpIsLogin()) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10246").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }
}
