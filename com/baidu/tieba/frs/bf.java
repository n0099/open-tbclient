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
import com.baidu.tieba.frs.d.b;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bf extends p<com.baidu.tbadk.core.data.az, bg> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.d.e {
    private com.baidu.tbadk.core.data.az cev;

    public bf(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public bg onCreateViewHolder(ViewGroup viewGroup) {
        return new bg(LayoutInflater.from(this.mContext).inflate(w.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.az azVar, bg bgVar) {
        super.onFillViewHolder(i, view, viewGroup, azVar, bgVar);
        if (bgVar.aoa != this.mSkinType) {
            a.a(this.ajP, view);
            bgVar.aoa = this.mSkinType;
        }
        this.cev = azVar;
        bgVar.cew.setOnClickListener(this);
        bgVar.cew.setTag(azVar);
        bgVar.cex.setShowBottom(false);
        bgVar.cex.setShowContent(false);
        bgVar.cex.setShowRefreshTimeInHead(true);
        bgVar.cex.setShowLiveIcon(true);
        bgVar.cex.setHeadPaddingTop(0);
        bgVar.cex.setChooseStyle(azVar.qz().getShowStyle());
        bgVar.cex.setShowImage(com.baidu.tbadk.core.r.oK().oQ());
        bgVar.cex.setData(azVar.qz());
        bgVar.cex.setPortraitClicklistener(this);
        bgVar.cey.setOnClickListener(this);
        bgVar.cey.setTag(azVar);
        if (azVar != null) {
            azVar.sp();
        }
        b.aho().a(cnC, azVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.az) {
            this.cbO.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.az) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ajP.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10178").Z("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.aho().a(cnC, this.cev, 2);
    }

    public int aeR() {
        return w.h.more_live_list;
    }

    public int aeS() {
        return w.h.make_headlines;
    }
}
