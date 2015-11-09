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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class co extends bn<com.baidu.tbadk.core.data.q, cp> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public co(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mPageContext = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public cp a(ViewGroup viewGroup) {
        return new cp(LayoutInflater.from(this.mContext).inflate(i.g.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.q qVar, cp cpVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tbadk.core.data.q) cpVar);
        com.baidu.tbadk.h.a.a(this.mPageContext, view);
        cpVar.aXM.setOnClickListener(this);
        cpVar.aXM.setTag(qVar);
        cpVar.aXN.setShowBottom(false);
        cpVar.aXN.setShowContent(false);
        cpVar.aXN.setShowRefreshTimeInHead(true);
        cpVar.aXN.setShowLiveIcon(true);
        cpVar.aXN.setHeadPaddingTop(0);
        cpVar.aXN.setChooseStyle(qVar.rN().getShowStyle());
        cpVar.aXN.setShowImage(com.baidu.tbadk.core.m.qV().qZ());
        cpVar.aXN.setData(qVar.rN());
        cpVar.aXN.setPortraitClicklistener(this);
        cpVar.aXO.setOnClickListener(this);
        cpVar.aXO.setTag(qVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.q) {
            this.aWo.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.q) view.getTag());
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10178").ae(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
    }

    public int Mx() {
        return i.f.more_live_list;
    }

    public int LO() {
        return i.f.make_headlines;
    }
}
