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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<d> {
    private View.OnClickListener aoc;
    private View.OnClickListener aou;
    private TbImageView bgn;
    private TextView bgo;
    private RelativeLayout bgp;
    private FrameLayout bgt;
    private View bgu;
    private TextView bgw;
    private TextView bgx;
    private ThreadLiveAndRecordUserInfoLayout cYI;
    private d cYL;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XL() != null) {
                    e.this.XL().a(view, e.this.cYL);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XL() != null) {
                    e.this.XL().a(view, e.this.cYL);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgp = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgp.getLayoutParams();
        layoutParams.height = (int) (k.ae(this.mContext) * 0.5625f);
        this.bgp.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgt = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgn = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgo = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cYI = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cYI.setForumAfterClickListener(this.aoc);
        this.cYI.setUserAfterClickListener(this.aou);
        this.cYI.setBarNameClickEnabled(true);
        this.bgu = getView().findViewById(d.h.dividerBottom);
        this.bgw = (TextView) getView().findViewById(d.h.tvRecordThreadCreateTime);
        this.bgx = (TextView) getView().findViewById(d.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cYI == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bcG != null && dVar.bcG.rS() != null) {
            this.cYL = dVar;
            z(this.cYL.bcG);
            this.bgn.c(dVar.bcG.rS().thumbnail_url, 10, false);
            this.bgw.setText(am.r(dVar.bcG.getCreateTime()));
            this.bgx.setText(StringUtils.translateSecondsToString(dVar.bcG.rS().video_duration.intValue()));
            this.cYI.A(dVar.bcG);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void z(bj bjVar) {
        String str = "";
        if (bjVar.getAuthor() != null) {
            str = bjVar.getAuthor().getName_show();
        }
        String title = bjVar.getTitle();
        this.bgo.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(d.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bgp, d.g.addresslist_item_bg);
            aj.i(this.bgo, d.e.cp_cont_i);
            aj.j(this.bgu, d.g.addresslist_item_bg);
            this.cYI.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (i.hi()) {
                j(this.mTbPageContext);
            } else {
                k.F(this.mContext, this.mContext.getString(d.l.neterror));
            }
        }
    }

    private void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cYL != null && this.cYL.bcG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cYL.bcG, null, "", 0, true, false, false)));
        }
    }
}
