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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ec extends bv<com.baidu.tbadk.core.data.ab, ed> implements View.OnClickListener, PhotoLiveCardView.b {
    /* JADX INFO: Access modifiers changed from: protected */
    public ec(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public ed b(ViewGroup viewGroup) {
        return new ed(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_single_photolivecard, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ab abVar, ed edVar) {
        super.a(i, view, viewGroup, (ViewGroup) abVar, (com.baidu.tbadk.core.data.ab) edVar);
        if (edVar.ahU != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), view);
            edVar.ahU = this.mSkinType;
        }
        PhotoLiveCardData sS = abVar.sS();
        if (2 == b(sS)) {
            edVar.blk.setShowContent(true);
            edVar.blk.setShowCover(false);
            edVar.blk.setShowExpression(false);
        } else {
            edVar.blk.setShowContent(false);
            edVar.blk.setShowCover(true);
            edVar.blk.setShowExpression(true);
        }
        edVar.blk.setChooseStyle(sS.getShowStyle());
        edVar.blk.setShowLiveIcon(true);
        edVar.blk.setHeadPaddingTop(t.e.ds24);
        edVar.blk.setPortraitClicklistener(this);
        edVar.blk.setShowImage(com.baidu.tbadk.core.l.rn().rt());
        if (sS.isShowDiffViewInSameAdapter()) {
            edVar.blk.setShowBottom(true);
            edVar.blk.setShowRefreshTimeInButtom(true);
            edVar.blk.setShowHeadLiveIcon(true);
            edVar.blk.setShowRefreshTimeInHead(false);
            edVar.blk.setContentPaddingBottom(0);
        } else {
            edVar.blk.setShowBottom(false);
            edVar.blk.setShowRefreshTimeInHead(true);
            edVar.blk.setShowHeadLiveIcon(false);
            edVar.blk.setShowRefreshTimeInButtom(false);
            edVar.blk.setContentPaddingBottom(t.e.ds36);
        }
        edVar.blk.setData(sS);
        return view;
    }

    private int b(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != t.g.live_card_layout || !this.bdK.checkUpIsLogin()) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10246").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }
}
