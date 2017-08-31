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
    private View.OnClickListener aoe;
    private View.OnClickListener aow;
    private TextView bgA;
    private TbImageView bgq;
    private TextView bgr;
    private RelativeLayout bgt;
    private FrameLayout bgw;
    private View bgx;
    private TextView bgz;
    private ThreadLiveAndRecordUserInfoLayout cXO;
    private d cXR;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XA() != null) {
                    e.this.XA().a(view, e.this.cXR);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XA() != null) {
                    e.this.XA().a(view, e.this.cXR);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgt = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgt.getLayoutParams();
        layoutParams.height = (int) (k.ad(this.mContext) * 0.5625f);
        this.bgt.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgw = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgq = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgq.setDefaultErrorResource(0);
        this.bgq.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgr = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cXO = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cXO.setForumAfterClickListener(this.aoe);
        this.cXO.setUserAfterClickListener(this.aow);
        this.cXO.setBarNameClickEnabled(true);
        this.bgx = getView().findViewById(d.h.dividerBottom);
        this.bgz = (TextView) getView().findViewById(d.h.tvRecordThreadCreateTime);
        this.bgA = (TextView) getView().findViewById(d.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cXO == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bcJ != null && dVar.bcJ.rS() != null) {
            this.cXR = dVar;
            z(this.cXR.bcJ);
            this.bgq.c(dVar.bcJ.rS().thumbnail_url, 10, false);
            this.bgz.setText(am.r(dVar.bcJ.getCreateTime()));
            this.bgA.setText(StringUtils.translateSecondsToString(dVar.bcJ.rS().video_duration.intValue()));
            this.cXO.A(dVar.bcJ);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void z(bj bjVar) {
        String str = "";
        if (bjVar.getAuthor() != null) {
            str = bjVar.getAuthor().getName_show();
        }
        String title = bjVar.getTitle();
        this.bgr.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(d.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bgt, d.g.addresslist_item_bg);
            aj.i(this.bgr, d.e.cp_cont_i);
            aj.j(this.bgx, d.g.addresslist_item_bg);
            this.cXO.d(tbPageContext, i);
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
        if (tbPageContext != null && this.cXR != null && this.cXR.bcJ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cXR.bcJ, null, "", 0, true, false, false)));
        }
    }
}
