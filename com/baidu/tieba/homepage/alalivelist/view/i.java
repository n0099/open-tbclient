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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<h> {
    private View.OnClickListener alM;
    private View.OnClickListener amj;
    private TbImageView bbC;
    private TextView bbD;
    private RelativeLayout bbE;
    private FrameLayout bbH;
    private View bbI;
    private TextView bbK;
    private TextView bbL;
    private ThreadLiveAndRecordUserInfoLayout cvc;
    private h cvf;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amj = new j(this);
        this.alM = new k(this);
        initView();
    }

    private void initView() {
        this.bbE = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bbE.getLayoutParams();
        layoutParams.height = (int) (com.baidu.adp.lib.util.k.ag(this.mContext) * 0.5625f);
        this.bbE.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bbH = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bbC = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bbC.setDefaultErrorResource(0);
        this.bbC.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bbD = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.cvc = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.cvc.setForumAfterClickListener(this.alM);
        this.cvc.setUserAfterClickListener(this.amj);
        this.cvc.setBarNameClickEnabled(true);
        this.bbI = getView().findViewById(w.h.dividerBottom);
        this.bbK = (TextView) getView().findViewById(w.h.tvRecordThreadCreateTime);
        this.bbL = (TextView) getView().findViewById(w.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cvc == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(h hVar) {
        if (hVar != null && hVar.bbv != null && hVar.bbv.sh() != null) {
            this.cvf = hVar;
            l(this.cvf.bbv);
            this.bbC.c(hVar.bbv.sh().thumbnail_url, 10, false);
            this.bbK.setText(au.q(hVar.bbv.getCreateTime()));
            this.bbL.setText(StringUtils.translateSecondsToString(hVar.bbv.sh().video_duration.intValue()));
            this.cvc.k(hVar.bbv);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void l(bj bjVar) {
        String str = "";
        if (bjVar.getAuthor() != null) {
            str = bjVar.getAuthor().getName_show();
        }
        String title = bjVar.getTitle();
        this.bbD.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(w.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bbE, w.g.addresslist_item_bg);
            aq.i((View) this.bbD, w.e.cp_cont_i);
            aq.j(this.bbI, w.g.addresslist_item_bg);
            this.cvc.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (com.baidu.adp.lib.util.i.he()) {
                l(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.G(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cvf != null && this.cvf.bbv != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cvf.bbv, null, "", 0, true, false, false)));
        }
    }
}
