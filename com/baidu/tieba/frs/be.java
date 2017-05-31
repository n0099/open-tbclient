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
public class be extends p<com.baidu.tbadk.core.data.ay, bf> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.d.e {
    private com.baidu.tbadk.core.data.ay bWn;

    public be(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public bf onCreateViewHolder(ViewGroup viewGroup) {
        return new bf(LayoutInflater.from(this.mContext).inflate(w.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ay ayVar, bf bfVar) {
        super.onFillViewHolder(i, view, viewGroup, ayVar, bfVar);
        if (bfVar.ana != this.mSkinType) {
            a.a(this.ajh, view);
            bfVar.ana = this.mSkinType;
        }
        this.bWn = ayVar;
        bfVar.bWo.setOnClickListener(this);
        bfVar.bWo.setTag(ayVar);
        bfVar.bWp.setShowBottom(false);
        bfVar.bWp.setShowContent(false);
        bfVar.bWp.setShowRefreshTimeInHead(true);
        bfVar.bWp.setShowLiveIcon(true);
        bfVar.bWp.setHeadPaddingTop(0);
        bfVar.bWp.setChooseStyle(ayVar.qC().getShowStyle());
        bfVar.bWp.setShowImage(com.baidu.tbadk.core.r.oN().oT());
        bfVar.bWp.setData(ayVar.qC());
        bfVar.bWp.setPortraitClicklistener(this);
        bfVar.bWq.setOnClickListener(this);
        bfVar.bWq.setTag(ayVar);
        if (ayVar != null) {
            ayVar.ss();
        }
        b.adw().a(cfm, ayVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ay) {
            this.bTG.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.ay) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ajh.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10178").Z("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.adw().a(cfm, this.bWn, 2);
    }

    public int aba() {
        return w.h.more_live_list;
    }

    public int abb() {
        return w.h.make_headlines;
    }
}
