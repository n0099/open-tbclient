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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<d> {
    private View.OnClickListener anf;
    private View.OnClickListener anx;
    private TbImageView bhM;
    private TextView bhN;
    private RelativeLayout bhO;
    private FrameLayout bhR;
    private View bhS;
    private TextView bhU;
    private TextView bhV;
    private ThreadLiveAndRecordUserInfoLayout cUP;
    private d cUS;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xn() != null) {
                    e.this.Xn().a(view, e.this.cUS);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xn() != null) {
                    e.this.Xn().a(view, e.this.cUS);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bhO = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bhO.getLayoutParams();
        layoutParams.height = (int) (l.ad(this.mContext) * 0.5625f);
        this.bhO.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bhR = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bhM = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bhM.setDefaultErrorResource(0);
        this.bhM.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bhN = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cUP = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cUP.setForumAfterClickListener(this.anf);
        this.cUP.setUserAfterClickListener(this.anx);
        this.cUP.setBarNameClickEnabled(true);
        this.bhS = getView().findViewById(d.h.dividerBottom);
        this.bhU = (TextView) getView().findViewById(d.h.tvRecordThreadCreateTime);
        this.bhV = (TextView) getView().findViewById(d.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_record_feed_view;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cUP == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bee != null && dVar.bee.rF() != null) {
            this.cUS = dVar;
            v(this.cUS.bee);
            this.bhM.c(dVar.bee.rF().thumbnail_url, 10, false);
            this.bhU.setText(am.r(dVar.bee.getCreateTime()));
            this.bhV.setText(StringUtils.translateSecondsToString(dVar.bee.rF().video_duration.intValue()));
            this.cUP.w(dVar.bee);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void v(bh bhVar) {
        String str = "";
        if (bhVar.getAuthor() != null) {
            str = bhVar.getAuthor().getName_show();
        }
        String title = bhVar.getTitle();
        this.bhN.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(d.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bhO, d.g.addresslist_item_bg);
            aj.i(this.bhN, d.e.cp_cont_i);
            aj.j(this.bhS, d.g.addresslist_item_bg);
            this.cUP.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (j.hh()) {
                i(this.mTbPageContext);
            } else {
                l.F(this.mContext, this.mContext.getString(d.l.neterror));
            }
        }
    }

    private void i(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cUS != null && this.cUS.bee != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cUS.bee, null, "", 0, true, false, false)));
        }
    }
}
