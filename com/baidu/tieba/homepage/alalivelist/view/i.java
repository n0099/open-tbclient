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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<h> {
    private View.OnClickListener ama;
    private View.OnClickListener amx;
    private FrameLayout bbA;
    private View bbB;
    private TextView bbD;
    private TextView bbE;
    private TbImageView bbv;
    private TextView bbw;
    private RelativeLayout bbx;
    private ThreadLiveAndRecordUserInfoLayout ctC;
    private h ctF;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amx = new j(this);
        this.ama = new k(this);
        initView();
    }

    private void initView() {
        this.bbx = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bbx.getLayoutParams();
        layoutParams.height = (int) (com.baidu.adp.lib.util.k.af(this.mContext) * 0.5625f);
        this.bbx.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bbA = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bbv = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bbv.setDefaultErrorResource(0);
        this.bbv.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bbw = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.ctC = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.ctC.setForumAfterClickListener(this.ama);
        this.ctC.setUserAfterClickListener(this.amx);
        this.ctC.setBarNameClickEnabled(true);
        this.bbB = getView().findViewById(w.h.dividerBottom);
        this.bbD = (TextView) getView().findViewById(w.h.tvRecordThreadCreateTime);
        this.bbE = (TextView) getView().findViewById(w.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.ctC == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(h hVar) {
        if (hVar != null && hVar.bbo != null && hVar.bbo.sF() != null) {
            this.ctF = hVar;
            l(this.ctF.bbo);
            this.bbv.c(hVar.bbo.sF().thumbnail_url, 10, false);
            this.bbD.setText(au.q(hVar.bbo.getCreateTime()));
            this.bbE.setText(StringUtils.translateSecondsToString(hVar.bbo.sF().video_duration.intValue()));
            this.ctC.k(hVar.bbo);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void l(bi biVar) {
        String str = "";
        if (biVar.getAuthor() != null) {
            str = biVar.getAuthor().getName_show();
        }
        String title = biVar.getTitle();
        this.bbw.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(w.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bbx, w.g.addresslist_item_bg);
            aq.i(this.bbw, w.e.cp_cont_i);
            aq.j(this.bbB, w.g.addresslist_item_bg);
            this.ctC.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (com.baidu.adp.lib.util.i.hj()) {
                l(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.ctF != null && this.ctF.bbo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.ctF.bbo, null, "", 0, true, false, false)));
        }
    }
}
