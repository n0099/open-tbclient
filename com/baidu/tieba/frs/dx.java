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
public class dx extends bm<com.baidu.tbadk.core.data.w, dy> implements View.OnClickListener, PhotoLiveCardView.b {
    /* JADX INFO: Access modifiers changed from: protected */
    public dx(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public dy a(ViewGroup viewGroup) {
        return new dy(LayoutInflater.from(this.mContext).inflate(n.g.frs_item_single_photolivecard, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dy dyVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) dyVar);
        if (dyVar.afY != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.aXA.getPageContext(), view);
            dyVar.afY = this.mSkinType;
        }
        PhotoLiveCardData sy = wVar.sy();
        if (2 == b(sy)) {
            dyVar.beA.setShowContent(true);
            dyVar.beA.setShowCover(false);
            dyVar.beA.setShowExpression(false);
        } else {
            dyVar.beA.setShowContent(false);
            dyVar.beA.setShowCover(true);
            dyVar.beA.setShowExpression(true);
        }
        dyVar.beA.setChooseStyle(sy.getShowStyle());
        dyVar.beA.setShowLiveIcon(true);
        dyVar.beA.setHeadPaddingTop(n.d.ds24);
        dyVar.beA.setPortraitClicklistener(this);
        dyVar.beA.setShowImage(com.baidu.tbadk.core.m.rh().rn());
        if (sy.isShowDiffViewInSameAdapter()) {
            dyVar.beA.setShowBottom(true);
            dyVar.beA.setShowRefreshTimeInButtom(true);
            dyVar.beA.setShowHeadLiveIcon(true);
            dyVar.beA.setShowRefreshTimeInHead(false);
            dyVar.beA.setContentPaddingBottom(0);
        } else {
            dyVar.beA.setShowBottom(false);
            dyVar.beA.setShowRefreshTimeInHead(true);
            dyVar.beA.setShowHeadLiveIcon(false);
            dyVar.beA.setShowRefreshTimeInButtom(false);
            dyVar.beA.setContentPaddingBottom(n.d.ds36);
        }
        dyVar.beA.setData(sy);
        return view;
    }

    private int b(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != n.f.live_card_layout || !this.aXA.checkUpIsLogin()) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10246").ab(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }
}
