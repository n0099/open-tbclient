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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class n extends d<aw, o> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.c {
    private aw czW;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public o onCreateViewHolder(ViewGroup viewGroup) {
        return new o(LayoutInflater.from(this.mContext).inflate(d.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, aw awVar, o oVar) {
        super.onFillViewHolder(i, view, viewGroup, awVar, oVar);
        if (oVar.api != this.mSkinType) {
            com.baidu.tbadk.o.a.a(this.mPageContext, view);
            oVar.api = this.mSkinType;
        }
        this.czW = awVar;
        oVar.czX.setOnClickListener(this);
        oVar.czX.setTag(awVar);
        oVar.czY.setShowBottom(false);
        oVar.czY.setShowContent(false);
        oVar.czY.setShowRefreshTimeInHead(true);
        oVar.czY.setShowLiveIcon(true);
        oVar.czY.setHeadPaddingTop(0);
        oVar.czY.setChooseStyle(awVar.qA().getShowStyle());
        oVar.czY.setShowImage(com.baidu.tbadk.core.h.oT().oZ());
        oVar.czY.setData(awVar.qA());
        oVar.czY.setPortraitClicklistener(this);
        oVar.czZ.setOnClickListener(this);
        oVar.czZ.setTag(awVar);
        if (awVar != null) {
            awVar.st();
        }
        com.baidu.tieba.frs.e.b.aoe().a(cPd, awVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof aw) {
            this.cxi.a(view.getId(), 0, view, null, (aw) view.getTag());
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
        com.baidu.tieba.frs.e.b.aoe().a(cPd, this.czW, 2);
    }

    public int ajZ() {
        return d.g.more_live_list;
    }

    public int aka() {
        return d.g.make_headlines;
    }
}
