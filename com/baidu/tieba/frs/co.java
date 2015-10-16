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
        cpVar.aXD.setOnClickListener(this);
        cpVar.aXD.setTag(qVar);
        cpVar.aXE.setShowBottom(false);
        cpVar.aXE.setShowContent(false);
        cpVar.aXE.setShowRefreshTimeInHead(true);
        cpVar.aXE.setShowLiveIcon(true);
        cpVar.aXE.setHeadPaddingTop(0);
        cpVar.aXE.setChooseStyle(qVar.rO().getShowStyle());
        cpVar.aXE.setShowImage(com.baidu.tbadk.core.m.qX().rb());
        cpVar.aXE.setData(qVar.rO());
        cpVar.aXE.setPortraitClicklistener(this);
        cpVar.aXF.setOnClickListener(this);
        cpVar.aXF.setTag(qVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.q) {
            this.aWg.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.q) view.getTag());
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

    public int Ml() {
        return i.f.more_live_list;
    }

    public int LC() {
        return i.f.make_headlines;
    }
}
