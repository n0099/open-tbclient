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
    private View.OnClickListener anJ;
    private View.OnClickListener anr;
    private TbImageView bia;
    private TextView bib;
    private RelativeLayout bic;
    private FrameLayout bih;
    private View bii;
    private TextView bik;
    private TextView bil;
    private ThreadLiveAndRecordUserInfoLayout cVb;
    private d cVe;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xr() != null) {
                    e.this.Xr().a(view, e.this.cVe);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xr() != null) {
                    e.this.Xr().a(view, e.this.cVe);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bic = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bic.getLayoutParams();
        layoutParams.height = (int) (l.ad(this.mContext) * 0.5625f);
        this.bic.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bih = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bia = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bia.setDefaultErrorResource(0);
        this.bia.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bib = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cVb = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cVb.setForumAfterClickListener(this.anr);
        this.cVb.setUserAfterClickListener(this.anJ);
        this.cVb.setBarNameClickEnabled(true);
        this.bii = getView().findViewById(d.h.dividerBottom);
        this.bik = (TextView) getView().findViewById(d.h.tvRecordThreadCreateTime);
        this.bil = (TextView) getView().findViewById(d.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_record_feed_view;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cVb == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bes != null && dVar.bes.rM() != null) {
            this.cVe = dVar;
            v(this.cVe.bes);
            this.bia.c(dVar.bes.rM().thumbnail_url, 10, false);
            this.bik.setText(am.q(dVar.bes.getCreateTime()));
            this.bil.setText(StringUtils.translateSecondsToString(dVar.bes.rM().video_duration.intValue()));
            this.cVb.w(dVar.bes);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void v(bh bhVar) {
        String str = "";
        if (bhVar.getAuthor() != null) {
            str = bhVar.getAuthor().getName_show();
        }
        String title = bhVar.getTitle();
        this.bib.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(d.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bic, d.g.addresslist_item_bg);
            aj.i(this.bib, d.e.cp_cont_i);
            aj.j(this.bii, d.g.addresslist_item_bg);
            this.cVb.d(tbPageContext, i);
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
        if (tbPageContext != null && this.cVe != null && this.cVe.bes != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cVe.bes, null, "", 0, true, false, false)));
        }
    }
}
