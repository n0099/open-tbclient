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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<d> {
    private View.OnClickListener aoG;
    private View.OnClickListener aoW;
    private TbImageView bgn;
    private TextView bgo;
    private RelativeLayout bgp;
    private FrameLayout bgt;
    private View bgu;
    private TextView bgw;
    private TextView bgx;
    private d cPC;
    private ThreadLiveAndRecordUserInfoLayout cPz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.We() != null) {
                    e.this.We().a(view, e.this.cPC);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.We() != null) {
                    e.this.We().a(view, e.this.cPC);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgp = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgp.getLayoutParams();
        layoutParams.height = (int) (k.ag(this.mContext) * 0.5625f);
        this.bgp.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgt = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgn = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgo = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cPz = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cPz.setForumAfterClickListener(this.aoG);
        this.cPz.setUserAfterClickListener(this.aoW);
        this.cPz.setBarNameClickEnabled(true);
        this.bgu = getView().findViewById(d.h.dividerBottom);
        this.bgw = (TextView) getView().findViewById(d.h.tvRecordThreadCreateTime);
        this.bgx = (TextView) getView().findViewById(d.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cPz == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bcL != null && dVar.bcL.rW() != null) {
            this.cPC = dVar;
            w(this.cPC.bcL);
            this.bgn.c(dVar.bcL.rW().thumbnail_url, 10, false);
            this.bgw.setText(al.r(dVar.bcL.getCreateTime()));
            this.bgx.setText(StringUtils.translateSecondsToString(dVar.bcL.rW().video_duration.intValue()));
            this.cPz.x(dVar.bcL);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void w(bl blVar) {
        String str = "";
        if (blVar.getAuthor() != null) {
            str = blVar.getAuthor().getName_show();
        }
        String title = blVar.getTitle();
        this.bgo.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(d.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bgp, d.g.addresslist_item_bg);
            ai.i(this.bgo, d.e.cp_cont_i);
            ai.j(this.bgu, d.g.addresslist_item_bg);
            this.cPz.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (i.hr()) {
                j(this.mTbPageContext);
            } else {
                k.F(this.mContext, this.mContext.getString(d.l.neterror));
            }
        }
    }

    private void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cPC != null && this.cPC.bcL != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cPC.bcL, null, "", 0, true, false, false)));
        }
    }
}
