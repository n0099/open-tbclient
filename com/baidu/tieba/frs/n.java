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
public class n extends d<ay, o> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.f.c {
    private ay crw;

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
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ay ayVar, o oVar) {
        super.onFillViewHolder(i, view, viewGroup, ayVar, oVar);
        if (oVar.apS != this.mSkinType) {
            com.baidu.tbadk.o.a.a(this.mF, view);
            oVar.apS = this.mSkinType;
        }
        this.crw = ayVar;
        oVar.crx.setOnClickListener(this);
        oVar.crx.setTag(ayVar);
        oVar.cry.setShowBottom(false);
        oVar.cry.setShowContent(false);
        oVar.cry.setShowRefreshTimeInHead(true);
        oVar.cry.setShowLiveIcon(true);
        oVar.cry.setHeadPaddingTop(0);
        oVar.cry.setChooseStyle(ayVar.qI().getShowStyle());
        oVar.cry.setShowImage(com.baidu.tbadk.core.h.oS().oY());
        oVar.cry.setData(ayVar.qI());
        oVar.cry.setPortraitClicklistener(this);
        oVar.crz.setOnClickListener(this);
        oVar.crz.setTag(ayVar);
        if (ayVar != null) {
            ayVar.sz();
        }
        com.baidu.tieba.frs.f.b.alj().a(cEr, ayVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ay) {
            this.coJ.a(view.getId(), 0, view, null, (ay) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mF.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10178").ad("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.f.b.alj().a(cEr, this.crw, 2);
    }

    public int ahP() {
        return d.h.more_live_list;
    }

    public int ahQ() {
        return d.h.make_headlines;
    }
}
