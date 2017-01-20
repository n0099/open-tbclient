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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<h> {
    private TbImageView aVp;
    private TextView aVq;
    private RelativeLayout aVr;
    private FrameLayout aVu;
    private View aVv;
    private TextView aVx;
    private TextView aVy;
    private View.OnClickListener agO;
    private View.OnClickListener agt;
    private ThreadLiveAndRecordUserInfoLayout ctD;
    private h ctG;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.agO = new j(this);
        this.agt = new k(this);
        initView();
    }

    private void initView() {
        this.aVr = (RelativeLayout) getView().findViewById(r.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.aVr.getLayoutParams();
        layoutParams.height = (int) (com.baidu.adp.lib.util.k.I(this.mContext) * 0.5625f);
        this.aVr.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.aVu = (FrameLayout) getView().findViewById(r.h.flAlaLiveTitlePane);
        this.aVp = (TbImageView) getView().findViewById(r.h.imgAlaLiveView);
        this.aVp.setDefaultErrorResource(0);
        this.aVp.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.aVq = (TextView) getView().findViewById(r.h.tvAlaLiveTitle);
        this.ctD = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(r.h.layoutAlaUserCard);
        this.ctD.setForumAfterClickListener(this.agt);
        this.ctD.setUserAfterClickListener(this.agO);
        this.ctD.setBarNameClickEnabled(true);
        this.aVv = getView().findViewById(r.h.dividerBottom);
        this.aVx = (TextView) getView().findViewById(r.h.tvRecordThreadCreateTime);
        this.aVy = (TextView) getView().findViewById(r.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.ctD == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(h hVar) {
        if (hVar != null && hVar.aVi != null && hVar.aVi.rN() != null) {
            this.ctG = hVar;
            l(this.ctG.aVi);
            this.aVp.c(hVar.aVi.rN().thumbnail_url, 10, false);
            this.aVx.setText(at.r(hVar.aVi.getCreateTime()));
            this.aVy.setText(StringUtils.translateSecondsToString(hVar.aVi.rN().video_duration.intValue()));
            this.ctD.k(hVar.aVi);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void l(bh bhVar) {
        String str = "";
        if (bhVar.getAuthor() != null) {
            str = bhVar.getAuthor().getName_show();
        }
        String title = bhVar.getTitle();
        this.aVq.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(r.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(this.aVr, r.g.addresslist_item_bg);
            ap.i((View) this.aVq, r.e.cp_cont_i);
            ap.j(this.aVv, r.g.addresslist_item_bg);
            this.ctD.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (com.baidu.adp.lib.util.i.gk()) {
                l(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.m(this.mContext, this.mContext.getString(r.l.neterror));
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.ctG != null && this.ctG.aVi != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.ctG.aVi, null, "", 0, true, false, false)));
        }
    }
}
