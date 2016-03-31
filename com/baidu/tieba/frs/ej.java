package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ej extends bx<com.baidu.tbadk.core.data.am, el> implements View.OnClickListener, PhotoLiveCardView.b {
    private int bpo;
    private int bpq;

    /* JADX INFO: Access modifiers changed from: protected */
    public ej(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bpo = 0;
        this.bpq = 0;
        this.bpq = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds38);
        this.bpo = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public el b(ViewGroup viewGroup) {
        return new el(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_single_photolivecard, viewGroup, false));
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.am amVar, el elVar) {
        MetaData author;
        if (amVar != null && elVar != null && (author = amVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                elVar.bpB.setVisibility(8);
                elVar.bqC.setHeadPaddingTop(t.e.ds24);
            } else {
                elVar.bpB.setVisibility(0);
                elVar.bpB.setImageBitmap(null);
                elVar.bpB.c(themeCard.getCardImageUrlAndroid(), 10, false);
                elVar.bqC.setHeadPaddingTop(t.e.ds38);
            }
            elVar.bpB.setOnClickListener(new ek(this, themeCard));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.am amVar, el elVar) {
        super.a(i, view, viewGroup, (ViewGroup) amVar, (com.baidu.tbadk.core.data.am) elVar);
        a(i, view, amVar, elVar);
        if (elVar.aik != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.bix.getPageContext(), view);
            elVar.aik = this.mSkinType;
        }
        PhotoLiveCardData sT = amVar.sT();
        if (2 == b(sT)) {
            elVar.bqC.setShowContent(true);
            elVar.bqC.setShowCover(false);
            elVar.bqC.setShowExpression(false);
        } else {
            elVar.bqC.setShowContent(false);
            elVar.bqC.setShowCover(true);
            elVar.bqC.setShowExpression(true);
        }
        elVar.bqC.setChooseStyle(sT.getShowStyle());
        elVar.bqC.setShowLiveIcon(true);
        elVar.bqC.setPortraitClicklistener(this);
        elVar.bqC.setShowImage(com.baidu.tbadk.core.l.qE().qK());
        if (sT.isShowDiffViewInSameAdapter()) {
            elVar.bqC.setShowBottom(true);
            elVar.bqC.setShowRefreshTimeInButtom(true);
            elVar.bqC.setShowHeadLiveIcon(true);
            elVar.bqC.setShowRefreshTimeInHead(false);
            elVar.bqC.setContentPaddingBottom(0);
        } else {
            elVar.bqC.setShowBottom(false);
            elVar.bqC.setShowRefreshTimeInHead(true);
            elVar.bqC.setShowHeadLiveIcon(false);
            elVar.bqC.setShowRefreshTimeInButtom(false);
            elVar.bqC.setContentPaddingBottom(t.e.ds36);
        }
        elVar.bqC.setData(sT);
        return view;
    }

    private int b(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != t.g.live_card_layout || !this.bix.checkUpIsLogin()) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10246").ac("fid", String.valueOf(photoLiveCardData.getForumId())));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }
}
