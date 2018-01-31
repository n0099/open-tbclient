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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class p extends g<as, q> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.d.c {
    private as dDM;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(d.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, as asVar, q qVar) {
        super.onFillViewHolder(i, view, viewGroup, asVar, qVar);
        if (qVar.bdS != this.mSkinType) {
            com.baidu.tbadk.n.a.a(this.mPageContext, view);
            qVar.bdS = this.mSkinType;
        }
        this.dDM = asVar;
        qVar.dDN.setOnClickListener(this);
        qVar.dDN.setTag(asVar);
        qVar.dDO.setShowBottom(false);
        qVar.dDO.setShowContent(false);
        qVar.dDO.setShowRefreshTimeInHead(true);
        qVar.dDO.setShowLiveIcon(true);
        qVar.dDO.setHeadPaddingTop(0);
        qVar.dDO.setChooseStyle(asVar.ye().getShowStyle());
        qVar.dDO.setShowImage(com.baidu.tbadk.core.i.wB().wH());
        qVar.dDO.setData(asVar.ye());
        qVar.dDO.setPortraitClicklistener(this);
        qVar.dDP.setOnClickListener(this);
        qVar.dDP.setTag(asVar);
        if (asVar != null) {
            asVar.zP();
        }
        com.baidu.tieba.frs.d.b.ayP().a(dRe, asVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof as) {
            this.dBj.a(view.getId(), 0, view, null, (as) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void bg(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10178").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
        com.baidu.tieba.frs.d.b.ayP().a(dRe, this.dDM, 2);
    }

    public int avi() {
        return d.g.more_live_list;
    }

    public int avj() {
        return d.g.make_headlines;
    }
}
