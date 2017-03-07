package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.i.a;
import com.baidu.tieba.frs.e.b;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bh extends at<com.baidu.tbadk.core.data.ax, bi> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajF;
    private com.baidu.tbadk.core.data.ax bPz;

    public bh(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.ajF = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public bi onCreateViewHolder(ViewGroup viewGroup) {
        return new bi(LayoutInflater.from(this.mContext).inflate(w.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, bi biVar) {
        super.onFillViewHolder(i, view, viewGroup, axVar, biVar);
        if (biVar.amL != this.mSkinType) {
            a.a(this.bcF.getPageContext(), view);
            biVar.amL = this.mSkinType;
        }
        this.bPz = axVar;
        biVar.bPA.setOnClickListener(this);
        biVar.bPA.setTag(axVar);
        biVar.bPB.setShowBottom(false);
        biVar.bPB.setShowContent(false);
        biVar.bPB.setShowRefreshTimeInHead(true);
        biVar.bPB.setShowLiveIcon(true);
        biVar.bPB.setHeadPaddingTop(0);
        biVar.bPB.setChooseStyle(axVar.qY().getShowStyle());
        biVar.bPB.setShowImage(com.baidu.tbadk.core.l.oQ().oW());
        biVar.bPB.setData(axVar.qY());
        biVar.bPB.setPortraitClicklistener(this);
        biVar.bPC.setOnClickListener(this);
        biVar.bPC.setTag(axVar);
        if (axVar != null) {
            axVar.sO();
        }
        b.adv().a(cav, axVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ax) {
            this.bOi.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.ax) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ajF.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10178").Z("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.adv().a(cav, this.bPz, 2);
    }

    public int ZX() {
        return w.h.more_live_list;
    }

    public int ZY() {
        return w.h.make_headlines;
    }
}
