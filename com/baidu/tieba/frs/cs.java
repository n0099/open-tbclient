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
public class cs extends bd<com.baidu.tbadk.core.data.t, ct> implements View.OnClickListener, PhotoLiveCardView.b {
    /* JADX INFO: Access modifiers changed from: protected */
    public cs(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public ct a(ViewGroup viewGroup) {
        return new ct(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_single_photolivecard, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.t tVar, ct ctVar) {
        super.a(i, view, viewGroup, (ViewGroup) tVar, (com.baidu.tbadk.core.data.t) ctVar);
        com.baidu.tbadk.h.a.a(this.aSX.getPageContext(), view);
        PhotoLiveCardData sh = tVar.sh();
        if (2 == c(sh)) {
            ctVar.aYF.setShowContent(true);
            ctVar.aYF.setShowCover(false);
            ctVar.aYF.setShowExpression(false);
        } else {
            ctVar.aYF.setShowContent(false);
            ctVar.aYF.setShowCover(true);
            ctVar.aYF.setShowExpression(true);
        }
        ctVar.aYF.setContentPaddingBottom(i.d.ds36);
        ctVar.aYF.setShowBottom(false);
        ctVar.aYF.setChooseStyle(sh.getShowStyle());
        ctVar.aYF.setShowRefreshTimeInHead(true);
        ctVar.aYF.setShowLiveIcon(true);
        ctVar.aYF.setHeadPaddingTop(i.d.ds24);
        ctVar.aYF.setPortraitClicklistener(this);
        ctVar.aYF.setShowImage(com.baidu.tbadk.core.m.rb().rf());
        ctVar.aYF.setData(sh);
        return view;
    }

    private int c(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != i.f.live_card_layout || !this.aSX.checkUpIsLogin()) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10246").af(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }
}
