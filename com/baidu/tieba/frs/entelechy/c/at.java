package com.baidu.tieba.frs.entelechy.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsLotteryCountDownView;
import com.baidu.tieba.frs.VerticalScrollNumberView;
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class at extends w {
    private TbImageView bqf;
    private TbImageView bqg;
    private TextView bqh;
    private TextView bqi;
    private ViewStub bqj;
    private ViewStub bqk;
    private TextView bql;
    private LinearLayout bqm;
    private VerticalScrollNumberView bqn;
    private FrsLotteryCountDownView bqo;
    private RelativeLayout bqp;

    public at(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bqn = null;
        this.bqo = null;
        View view = getView();
        this.bqf = (TbImageView) view.findViewById(t.g.lottery_banner);
        this.bqf.setScaleType(ImageView.ScaleType.FIT_XY);
        this.bqg = (TbImageView) view.findViewById(t.g.lottery_page);
        this.bqh = (TextView) view.findViewById(t.g.lottery_description);
        this.bqi = (TextView) view.findViewById(t.g.lottery_status_txt);
        this.bqj = (ViewStub) view.findViewById(t.g.view_count_down);
        this.bqk = (ViewStub) view.findViewById(t.g.view_join_num);
        this.bqm = (LinearLayout) view.findViewById(t.g.click_wrapper);
        this.bql = (TextView) view.findViewById(t.g.lottery_click);
        this.bqp = (RelativeLayout) view.findViewById(t.g.lottery_info_container);
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w, com.baidu.tieba.card.a
    public int JN() {
        return t.h.frs_item_lottery;
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w
    public void h(ax axVar) {
        int rf;
        if (axVar != null && axVar.qU() != null && axVar.qU().size() > 0 && axVar.qU().get(0) != null && (rf = axVar.rf()) != -1) {
            super.h(axVar);
            this.aOM.setVisibility(8);
            com.baidu.tbadk.core.data.a aVar = axVar.qU().get(0);
            if (!StringUtils.isNull(aVar.ox())) {
                if (com.baidu.adp.lib.g.c.dF().V(10)) {
                    this.bqf.c(aVar.ox(), 10, false);
                    this.bqf.setVisibility(0);
                } else {
                    this.bqf.setVisibility(8);
                }
            } else {
                this.bqf.setVisibility(8);
            }
            if (axVar.getMedias() != null && axVar.getMedias().get(0) != null) {
                if (com.baidu.adp.lib.g.c.dF().V(10)) {
                    this.bqg.c(axVar.getMedias().get(0).getPicUrl(), 10, false);
                    this.bqg.setVisibility(0);
                } else {
                    this.bqg.setVisibility(8);
                }
            } else {
                this.bqg.setVisibility(8);
            }
            if (rf == 4) {
                if (this.bqn != null) {
                    this.bqn.setVisibility(8);
                }
                if (StringUtils.isNull(axVar.qS())) {
                    this.bqh.setText("【】");
                } else {
                    this.bqh.setText(axVar.qS());
                }
                this.bqi.setText(getContext().getResources().getString(t.j.time_before_lottery));
                long millis = TimeUnit.SECONDS.toMillis(aVar.os()) - System.currentTimeMillis();
                if (this.bqo == null) {
                    this.bqo = (FrsLotteryCountDownView) this.bqj.inflate();
                }
                this.bqo.setVisibility(0);
                this.bqo.setData(millis);
            } else {
                if (this.bqo != null) {
                    this.bqo.setVisibility(8);
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.bqh.setText(StringUtils.string(getContext().getResources().getString(t.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.os()))), "-", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.ot())))));
                this.bqi.setText(getContext().getResources().getString(t.j.lottery_join_num));
                if (this.bqn == null) {
                    this.bqn = (VerticalScrollNumberView) this.bqk.inflate();
                }
                this.bqn.setVisibility(0);
                this.bqn.setData(aVar.oy());
            }
            if (rf == 1) {
                this.bql.setText(TbadkCoreApplication.m11getInst().getResources().getString(t.j.join_immediately));
            } else {
                this.bql.setText(TbadkCoreApplication.m11getInst().getResources().getString(t.j.check_detail));
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.bqp, t.f.bg_frs_item_cp_bg_line_e_selector);
            com.baidu.tbadk.core.util.at.j((View) this.bqh, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.j((View) this.bqi, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.j((View) this.bql, t.d.cp_cont_h);
            Drawable drawable = com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_lottery_gift);
            int c = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds32);
            drawable.setBounds(0, 0, c, c);
            this.bql.setCompoundDrawables(drawable, null, null, null);
            this.bql.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.c(getContext(), t.e.ds6));
            com.baidu.tbadk.core.util.at.k(this.bqm, t.f.lottery_click_bg);
        }
        super.d(tbPageContext, i);
    }
}
