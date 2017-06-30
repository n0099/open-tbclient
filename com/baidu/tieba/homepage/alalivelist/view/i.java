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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<h> {
    private View.OnClickListener amF;
    private View.OnClickListener amS;
    private TextView bdA;
    private TbImageView bdr;
    private TextView bds;
    private RelativeLayout bdt;
    private FrameLayout bdw;
    private View bdx;
    private TextView bdz;
    private ThreadLiveAndRecordUserInfoLayout cGU;
    private h cGX;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amS = new j(this);
        this.amF = new k(this);
        initView();
    }

    private void initView() {
        this.bdt = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bdt.getLayoutParams();
        layoutParams.height = (int) (com.baidu.adp.lib.util.k.af(this.mContext) * 0.5625f);
        this.bdt.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bdw = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bdr = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bdr.setDefaultErrorResource(0);
        this.bdr.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bds = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.cGU = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.cGU.setForumAfterClickListener(this.amF);
        this.cGU.setUserAfterClickListener(this.amS);
        this.cGU.setBarNameClickEnabled(true);
        this.bdx = getView().findViewById(w.h.dividerBottom);
        this.bdz = (TextView) getView().findViewById(w.h.tvRecordThreadCreateTime);
        this.bdA = (TextView) getView().findViewById(w.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cGU == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.bai != null && hVar.bai.rI() != null) {
            this.cGX = hVar;
            s(this.cGX.bai);
            this.bdr.c(hVar.bai.rI().thumbnail_url, 10, false);
            this.bdz.setText(aw.q(hVar.bai.getCreateTime()));
            this.bdA.setText(StringUtils.translateSecondsToString(hVar.bai.rI().video_duration.intValue()));
            this.cGU.t(hVar.bai);
            d(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void s(bm bmVar) {
        String str = "";
        if (bmVar.getAuthor() != null) {
            str = bmVar.getAuthor().getName_show();
        }
        String title = bmVar.getTitle();
        this.bds.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(w.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.j(this.bdt, w.g.addresslist_item_bg);
            as.i(this.bds, w.e.cp_cont_i);
            as.j(this.bdx, w.g.addresslist_item_bg);
            this.cGU.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (com.baidu.adp.lib.util.i.hj()) {
                i(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.F(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    private void i(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cGX != null && this.cGX.bai != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cGX.bai, null, "", 0, true, false, false)));
        }
    }
}
