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
import com.baidu.tbadk.m.a;
import com.baidu.tieba.frs.e.b;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bj extends av<com.baidu.tbadk.core.data.aw, bk> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajU;
    private com.baidu.tbadk.core.data.aw bRF;

    public bj(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.ajU = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public bk onCreateViewHolder(ViewGroup viewGroup) {
        return new bk(LayoutInflater.from(this.mContext).inflate(w.j.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aw awVar, bk bkVar) {
        super.onFillViewHolder(i, view, viewGroup, awVar, bkVar);
        if (bkVar.amZ != this.mSkinType) {
            a.a(this.bdG.getPageContext(), view);
            bkVar.amZ = this.mSkinType;
        }
        this.bRF = awVar;
        bkVar.bRG.setOnClickListener(this);
        bkVar.bRG.setTag(awVar);
        bkVar.bRH.setShowBottom(false);
        bkVar.bRH.setShowContent(false);
        bkVar.bRH.setShowRefreshTimeInHead(true);
        bkVar.bRH.setShowLiveIcon(true);
        bkVar.bRH.setHeadPaddingTop(0);
        bkVar.bRH.setChooseStyle(awVar.rw().getShowStyle());
        bkVar.bRH.setShowImage(com.baidu.tbadk.core.q.po().pu());
        bkVar.bRH.setData(awVar.rw());
        bkVar.bRH.setPortraitClicklistener(this);
        bkVar.bRI.setOnClickListener(this);
        bkVar.bRI.setTag(awVar);
        if (awVar != null) {
            awVar.tm();
        }
        b.aeq().a(cbn, awVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.aw) {
            this.bQo.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.aw) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ajU.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10178").aa("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.aeq().a(cbn, this.bRF, 2);
    }

    public int abw() {
        return w.h.more_live_list;
    }

    public int abx() {
        return w.h.make_headlines;
    }
}
