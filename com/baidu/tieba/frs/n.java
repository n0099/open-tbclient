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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class n extends d<ay, o> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.c {
    private ay clp;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public o onCreateViewHolder(ViewGroup viewGroup) {
        return new o(LayoutInflater.from(this.mContext).inflate(d.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ay ayVar, o oVar) {
        super.onFillViewHolder(i, view, viewGroup, ayVar, oVar);
        if (oVar.aql != this.mSkinType) {
            com.baidu.tbadk.o.a.a(this.alI, view);
            oVar.aql = this.mSkinType;
        }
        this.clp = ayVar;
        oVar.clq.setOnClickListener(this);
        oVar.clq.setTag(ayVar);
        oVar.clr.setShowBottom(false);
        oVar.clr.setShowContent(false);
        oVar.clr.setShowRefreshTimeInHead(true);
        oVar.clr.setShowLiveIcon(true);
        oVar.clr.setHeadPaddingTop(0);
        oVar.clr.setChooseStyle(ayVar.qM().getShowStyle());
        oVar.clr.setShowImage(com.baidu.tbadk.core.h.oX().pd());
        oVar.clr.setData(ayVar.qM());
        oVar.clr.setPortraitClicklistener(this);
        oVar.cls.setOnClickListener(this);
        oVar.cls.setTag(ayVar);
        if (ayVar != null) {
            ayVar.sD();
        }
        com.baidu.tieba.frs.e.b.aiY().a(cvL, ayVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ay) {
            this.ciC.a(view.getId(), 0, view, null, (ay) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.alI.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10178").aa("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.e.b.aiY().a(cvL, this.clp, 2);
    }

    public int agc() {
        return d.h.more_live_list;
    }

    public int agd() {
        return d.h.make_headlines;
    }
}
