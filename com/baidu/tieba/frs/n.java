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
public class n extends d<com.baidu.tbadk.core.data.as, o> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.c {
    private com.baidu.tbadk.core.data.as cJt;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public o onCreateViewHolder(ViewGroup viewGroup) {
        return new o(LayoutInflater.from(this.mContext).inflate(d.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, o oVar) {
        super.onFillViewHolder(i, view, viewGroup, asVar, oVar);
        if (oVar.apA != this.mSkinType) {
            com.baidu.tbadk.n.a.a(this.mPageContext, view);
            oVar.apA = this.mSkinType;
        }
        this.cJt = asVar;
        oVar.cJu.setOnClickListener(this);
        oVar.cJu.setTag(asVar);
        oVar.cJv.setShowBottom(false);
        oVar.cJv.setShowContent(false);
        oVar.cJv.setShowRefreshTimeInHead(true);
        oVar.cJv.setShowLiveIcon(true);
        oVar.cJv.setHeadPaddingTop(0);
        oVar.cJv.setChooseStyle(asVar.qF().getShowStyle());
        oVar.cJv.setShowImage(com.baidu.tbadk.core.h.pa().pg());
        oVar.cJv.setData(asVar.qF());
        oVar.cJv.setPortraitClicklistener(this);
        oVar.cJw.setOnClickListener(this);
        oVar.cJw.setTag(asVar);
        if (asVar != null) {
            asVar.sw();
        }
        com.baidu.tieba.frs.e.b.aqn().a(cYM, asVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.as) {
            this.cGH.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.as) view.getTag());
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
        com.baidu.tieba.frs.e.b.aqn().a(cYM, this.cJt, 2);
    }

    public int amj() {
        return d.g.more_live_list;
    }

    public int amk() {
        return d.g.make_headlines;
    }
}
