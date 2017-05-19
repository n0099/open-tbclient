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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.m.a;
import com.baidu.tieba.frs.c.b;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bd extends p<com.baidu.tbadk.core.data.ax, be> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.c.e {
    private com.baidu.tbadk.core.data.ax bQw;

    public bd(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public be onCreateViewHolder(ViewGroup viewGroup) {
        return new be(LayoutInflater.from(this.mContext).inflate(w.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, be beVar) {
        super.onFillViewHolder(i, view, viewGroup, axVar, beVar);
        if (beVar.ane != this.mSkinType) {
            a.a(this.ajr, view);
            beVar.ane = this.mSkinType;
        }
        this.bQw = axVar;
        beVar.bQx.setOnClickListener(this);
        beVar.bQx.setTag(axVar);
        beVar.bQy.setShowBottom(false);
        beVar.bQy.setShowContent(false);
        beVar.bQy.setShowRefreshTimeInHead(true);
        beVar.bQy.setShowLiveIcon(true);
        beVar.bQy.setHeadPaddingTop(0);
        beVar.bQy.setChooseStyle(axVar.qG().getShowStyle());
        beVar.bQy.setShowImage(com.baidu.tbadk.core.r.oV().pb());
        beVar.bQy.setData(axVar.qG());
        beVar.bQy.setPortraitClicklistener(this);
        beVar.bQz.setOnClickListener(this);
        beVar.bQz.setTag(axVar);
        if (axVar != null) {
            axVar.sw();
        }
        b.acs().a(bZb, axVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ax) {
            this.bNU.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.ax) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ajr.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10178").aa("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.acs().a(bZb, this.bQw, 2);
    }

    public int ZY() {
        return w.h.more_live_list;
    }

    public int ZZ() {
        return w.h.make_headlines;
    }
}
