package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class n extends d<aw, o> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.f.c {
    private aw csz;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public o onCreateViewHolder(ViewGroup viewGroup) {
        return new o(LayoutInflater.from(this.mContext).inflate(d.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, aw awVar, o oVar) {
        super.onFillViewHolder(i, view, viewGroup, awVar, oVar);
        if (oVar.aoN != this.mSkinType) {
            com.baidu.tbadk.n.a.a(this.mH, view);
            oVar.aoN = this.mSkinType;
        }
        this.csz = awVar;
        oVar.csA.setOnClickListener(this);
        oVar.csA.setTag(awVar);
        oVar.csB.setShowBottom(false);
        oVar.csB.setShowContent(false);
        oVar.csB.setShowRefreshTimeInHead(true);
        oVar.csB.setShowLiveIcon(true);
        oVar.csB.setHeadPaddingTop(0);
        oVar.csB.setChooseStyle(awVar.qv().getShowStyle());
        oVar.csB.setShowImage(com.baidu.tbadk.core.h.oM().oS());
        oVar.csB.setData(awVar.qv());
        oVar.csB.setPortraitClicklistener(this);
        oVar.csC.setOnClickListener(this);
        oVar.csC.setTag(awVar);
        if (awVar != null) {
            awVar.sm();
        }
        com.baidu.tieba.frs.f.b.alt().a(cFQ, awVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof aw) {
            this.cpO.a(view.getId(), 0, view, null, (aw) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mH.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10178").ac("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.f.b.alt().a(cFQ, this.csz, 2);
    }

    public int ahR() {
        return d.h.more_live_list;
    }

    public int ahS() {
        return d.h.make_headlines;
    }
}
