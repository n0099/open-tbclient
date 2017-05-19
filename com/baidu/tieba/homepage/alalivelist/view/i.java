package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<h> {
    private View.OnClickListener alY;
    private View.OnClickListener amk;
    private TbImageView bcI;
    private TextView bcJ;
    private RelativeLayout bcK;
    private FrameLayout bcN;
    private View bcO;
    private TextView bcQ;
    private TextView bcR;
    private ThreadLiveAndRecordUserInfoLayout csQ;
    private h csT;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amk = new j(this);
        this.alY = new k(this);
        initView();
    }

    private void initView() {
        this.bcK = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bcK.getLayoutParams();
        layoutParams.height = (int) (com.baidu.adp.lib.util.k.af(this.mContext) * 0.5625f);
        this.bcK.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bcN = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bcI = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bcI.setDefaultErrorResource(0);
        this.bcI.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bcJ = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.csQ = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.csQ.setForumAfterClickListener(this.alY);
        this.csQ.setUserAfterClickListener(this.amk);
        this.csQ.setBarNameClickEnabled(true);
        this.bcO = getView().findViewById(w.h.dividerBottom);
        this.bcQ = (TextView) getView().findViewById(w.h.tvRecordThreadCreateTime);
        this.bcR = (TextView) getView().findViewById(w.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.csQ == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(h hVar) {
        if (hVar != null && hVar.bcB != null && hVar.bcB.rP() != null) {
            this.csT = hVar;
            q(this.csT.bcB);
            this.bcI.c(hVar.bcB.rP().thumbnail_url, 10, false);
            this.bcQ.setText(au.q(hVar.bcB.getCreateTime()));
            this.bcR.setText(StringUtils.translateSecondsToString(hVar.bcB.rP().video_duration.intValue()));
            this.csQ.p(hVar.bcB);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void q(bk bkVar) {
        String str = "";
        if (bkVar.getAuthor() != null) {
            str = bkVar.getAuthor().getName_show();
        }
        String title = bkVar.getTitle();
        this.bcJ.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(w.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bcK, w.g.addresslist_item_bg);
            aq.i(this.bcJ, w.e.cp_cont_i);
            aq.j(this.bcO, w.g.addresslist_item_bg);
            this.csQ.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (com.baidu.adp.lib.util.i.hk()) {
                l(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.csT != null && this.csT.bcB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.csT.bcB, null, "", 0, true, false, false)));
        }
    }
}
