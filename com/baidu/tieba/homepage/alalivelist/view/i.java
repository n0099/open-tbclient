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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<h> {
    private View.OnClickListener alO;
    private View.OnClickListener ama;
    private TbImageView bbo;
    private TextView bbp;
    private RelativeLayout bbq;
    private FrameLayout bbt;
    private View bbu;
    private TextView bbw;
    private TextView bbx;
    private ThreadLiveAndRecordUserInfoLayout czi;
    private h czl;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ama = new j(this);
        this.alO = new k(this);
        initView();
    }

    private void initView() {
        this.bbq = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bbq.getLayoutParams();
        layoutParams.height = (int) (com.baidu.adp.lib.util.k.af(this.mContext) * 0.5625f);
        this.bbq.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bbt = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bbo = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bbo.setDefaultErrorResource(0);
        this.bbo.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bbp = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.czi = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.czi.setForumAfterClickListener(this.alO);
        this.czi.setUserAfterClickListener(this.ama);
        this.czi.setBarNameClickEnabled(true);
        this.bbu = getView().findViewById(w.h.dividerBottom);
        this.bbw = (TextView) getView().findViewById(w.h.tvRecordThreadCreateTime);
        this.bbx = (TextView) getView().findViewById(w.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.czi == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.aYA != null && hVar.aYA.rL() != null) {
            this.czl = hVar;
            q(this.czl.aYA);
            this.bbo.c(hVar.aYA.rL().thumbnail_url, 10, false);
            this.bbw.setText(au.q(hVar.aYA.getCreateTime()));
            this.bbx.setText(StringUtils.translateSecondsToString(hVar.aYA.rL().video_duration.intValue()));
            this.czi.r(hVar.aYA);
            d(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void q(bl blVar) {
        String str = "";
        if (blVar.getAuthor() != null) {
            str = blVar.getAuthor().getName_show();
        }
        String title = blVar.getTitle();
        this.bbp.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(w.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bbq, w.g.addresslist_item_bg);
            aq.i(this.bbp, w.e.cp_cont_i);
            aq.j(this.bbu, w.g.addresslist_item_bg);
            this.czi.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (com.baidu.adp.lib.util.i.hk()) {
                i(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    private void i(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.czl != null && this.czl.aYA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.czl.aYA, null, "", 0, true, false, false)));
        }
    }
}
