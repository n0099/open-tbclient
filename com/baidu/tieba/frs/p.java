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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class p extends g<com.baidu.tbadk.core.data.as, q> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.c {
    private com.baidu.tbadk.core.data.as dGP;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, q qVar) {
        super.onFillViewHolder(i, view, viewGroup, asVar, qVar);
        if (qVar.bfL != this.mSkinType) {
            com.baidu.tbadk.n.a.a(this.mPageContext, view);
            qVar.bfL = this.mSkinType;
        }
        this.dGP = asVar;
        qVar.dGQ.setOnClickListener(this);
        qVar.dGQ.setTag(asVar);
        qVar.dGR.setShowBottom(false);
        qVar.dGR.setShowContent(false);
        qVar.dGR.setShowRefreshTimeInHead(true);
        qVar.dGR.setShowLiveIcon(true);
        qVar.dGR.setHeadPaddingTop(0);
        qVar.dGR.setChooseStyle(asVar.yF().getShowStyle());
        qVar.dGR.setShowImage(com.baidu.tbadk.core.i.xo().xu());
        qVar.dGR.setData(asVar.yF());
        qVar.dGR.setPortraitClicklistener(this);
        qVar.dGS.setOnClickListener(this);
        qVar.dGS.setTag(asVar);
        if (asVar != null) {
            asVar.Ai();
        }
        com.baidu.tieba.frs.e.b.azR().a(dUq, asVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.as) {
            this.dEc.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.as) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void bg(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10178").ab(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.e.b.azR().a(dUq, this.dGP, 2);
    }

    public int awg() {
        return d.g.more_live_list;
    }

    public int awh() {
        return d.g.make_headlines;
    }
}
