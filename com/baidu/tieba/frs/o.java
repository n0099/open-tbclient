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
/* loaded from: classes.dex */
public class o extends e<com.baidu.tbadk.core.data.as, p> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.c {
    private com.baidu.tbadk.core.data.as cJD;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        return new p(LayoutInflater.from(this.mContext).inflate(d.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, p pVar) {
        super.onFillViewHolder(i, view, viewGroup, asVar, pVar);
        if (pVar.apD != this.mSkinType) {
            com.baidu.tbadk.n.a.a(this.mPageContext, view);
            pVar.apD = this.mSkinType;
        }
        this.cJD = asVar;
        pVar.cJE.setOnClickListener(this);
        pVar.cJE.setTag(asVar);
        pVar.cJF.setShowBottom(false);
        pVar.cJF.setShowContent(false);
        pVar.cJF.setShowRefreshTimeInHead(true);
        pVar.cJF.setShowLiveIcon(true);
        pVar.cJF.setHeadPaddingTop(0);
        pVar.cJF.setChooseStyle(asVar.qD().getShowStyle());
        pVar.cJF.setShowImage(com.baidu.tbadk.core.h.oY().pe());
        pVar.cJF.setData(asVar.qD());
        pVar.cJF.setPortraitClicklistener(this);
        pVar.cJG.setOnClickListener(this);
        pVar.cJG.setTag(asVar);
        if (asVar != null) {
            asVar.su();
        }
        com.baidu.tieba.frs.e.b.aqw().a(cYY, asVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.as) {
            this.cGP.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.as) view.getTag());
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10178").ac(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.e.b.aqw().a(cYY, this.cJD, 2);
    }

    public int ams() {
        return d.g.more_live_list;
    }

    public int amt() {
        return d.g.make_headlines;
    }
}
