package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class p extends g<com.baidu.tbadk.core.data.at, q> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.d.c {
    private com.baidu.tbadk.core.data.at dyQ;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.at atVar, q qVar) {
        super.onFillViewHolder(i, view, viewGroup, atVar, qVar);
        if (qVar.bdE != this.mSkinType) {
            com.baidu.tbadk.n.a.a(this.mPageContext, view);
            qVar.bdE = this.mSkinType;
        }
        this.dyQ = atVar;
        qVar.dyR.setOnClickListener(this);
        qVar.dyR.setTag(atVar);
        qVar.dyS.setShowBottom(false);
        qVar.dyS.setShowContent(false);
        qVar.dyS.setShowRefreshTimeInHead(true);
        qVar.dyS.setShowLiveIcon(true);
        qVar.dyS.setHeadPaddingTop(0);
        qVar.dyS.setChooseStyle(atVar.yg().getShowStyle());
        qVar.dyS.setShowImage(com.baidu.tbadk.core.i.wB().wH());
        qVar.dyS.setData(atVar.yg());
        qVar.dyS.setPortraitClicklistener(this);
        qVar.dyT.setOnClickListener(this);
        qVar.dyT.setTag(atVar);
        if (atVar != null) {
            atVar.zW();
        }
        com.baidu.tieba.frs.d.b.axH().a(dMh, atVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.at) {
            this.dwn.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.at) view.getTag());
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10178").ab(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.d.b.axH().a(dMh, this.dyQ, 2);
    }

    public int aua() {
        return d.g.more_live_list;
    }

    public int aub() {
        return d.g.make_headlines;
    }
}
