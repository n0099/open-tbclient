package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.i.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ee extends bw<com.baidu.tbadk.core.data.ar, eg> implements View.OnClickListener, PhotoLiveCardView.b {
    private int bkF;
    private int bkG;
    private int blL;
    private int blM;
    private boolean blN;
    private boolean blO;

    public ee(BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(baseActivity, bdUniqueId);
        this.bkF = 0;
        this.bkG = 0;
        this.blL = 0;
        this.blM = 0;
        this.blN = true;
        this.blO = false;
        this.bkG = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds38);
        this.bkF = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds24);
        this.blL = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds1);
        this.blM = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds16);
        this.blN = z;
        this.blO = z2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public eg b(ViewGroup viewGroup) {
        return new eg(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_single_photolivecard, viewGroup, false));
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.ar arVar, eg egVar) {
        MetaData author;
        if (arVar != null && egVar != null && (author = arVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                egVar.bkR.setVisibility(8);
                egVar.blR.setHeadPaddingTop(t.e.ds24);
            } else {
                egVar.bkR.setVisibility(0);
                egVar.bkR.setImageBitmap(null);
                egVar.bkR.c(themeCard.getCardImageUrlAndroid(), 10, false);
                egVar.blR.setHeadPaddingTop(t.e.ds38);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) egVar.blR.getLayoutParams();
            if (layoutParams != null) {
                if (this.blN) {
                    layoutParams.setMargins(0, this.blM, 0, 0);
                } else {
                    layoutParams.setMargins(0, this.blL, 0, 0);
                }
            }
            egVar.bkR.setOnClickListener(new ef(this, themeCard));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ar arVar, eg egVar) {
        super.a(i, view, viewGroup, (ViewGroup) arVar, (com.baidu.tbadk.core.data.ar) egVar);
        a(i, view, arVar, egVar);
        if (egVar.aej != this.mSkinType) {
            a.a(this.bek.getPageContext(), view);
            egVar.aej = this.mSkinType;
        }
        PhotoLiveCardData qs = arVar.qs();
        if (2 == a(qs)) {
            egVar.blR.setShowContent(true);
            egVar.blR.setShowCover(false);
            egVar.blR.setShowExpression(false);
        } else {
            egVar.blR.setShowContent(false);
            egVar.blR.setShowCover(true);
            egVar.blR.setShowExpression(true);
        }
        egVar.blR.setChooseStyle(qs.getShowStyle());
        egVar.blR.setShowLiveIcon(true);
        egVar.blR.setPortraitClicklistener(this);
        egVar.blR.setShowImage(com.baidu.tbadk.core.l.ob().oh());
        if (qs.isShowDiffViewInSameAdapter()) {
            egVar.blR.setShowBottom(true);
            egVar.blR.setShowRefreshTimeInButtom(true);
            egVar.blR.setShowHeadLiveIcon(true);
            egVar.blR.setShowRefreshTimeInHead(false);
            egVar.blR.setContentPaddingBottom(0);
        } else {
            egVar.blR.setShowBottom(false);
            egVar.blR.setShowRefreshTimeInHead(true);
            egVar.blR.setShowHeadLiveIcon(false);
            egVar.blR.setShowRefreshTimeInButtom(false);
            egVar.blR.setContentPaddingBottom(t.e.ds36);
        }
        egVar.blR.bj(this.blO);
        egVar.blR.setData(qs);
        return view;
    }

    private int a(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != t.g.live_card_layout || !this.bek.checkUpIsLogin()) {
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
