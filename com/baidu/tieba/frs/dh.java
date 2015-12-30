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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dh extends bp<com.baidu.tbadk.core.data.t, di> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public dh(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mPageContext = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public di a(ViewGroup viewGroup) {
        return new di(LayoutInflater.from(this.mContext).inflate(n.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.t tVar, di diVar) {
        super.a(i, view, viewGroup, (ViewGroup) tVar, (com.baidu.tbadk.core.data.t) diVar);
        if (diVar.ahf != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.bbA.getPageContext(), view);
            diVar.ahf = this.mSkinType;
        }
        diVar.bhK.setOnClickListener(this);
        diVar.bhK.setTag(tVar);
        diVar.bhL.setShowBottom(false);
        diVar.bhL.setShowContent(false);
        diVar.bhL.setShowRefreshTimeInHead(true);
        diVar.bhL.setShowLiveIcon(true);
        diVar.bhL.setHeadPaddingTop(0);
        diVar.bhL.setChooseStyle(tVar.rT().getShowStyle());
        diVar.bhL.setShowImage(com.baidu.tbadk.core.m.qQ().qW());
        diVar.bhL.setData(tVar.rT());
        diVar.bhL.setPortraitClicklistener(this);
        diVar.bhM.setOnClickListener(this);
        diVar.bhM.setTag(tVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.t) {
            this.bfE.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.t) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10178").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
    }

    public int Os() {
        return n.g.more_live_list;
    }

    public int NF() {
        return n.g.make_headlines;
    }
}
