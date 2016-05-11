package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ar extends w {
    private View.OnClickListener Fn;
    private TbImageView bqb;
    private TbImageView bqc;

    public ar(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.bqb = (TbImageView) view.findViewById(t.g.frs_list_star_interview_topimage);
        this.bqc = (TbImageView) view.findViewById(t.g.abstract_imge);
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w, com.baidu.tieba.card.a
    public int JN() {
        return t.h.frs_interview_live_item;
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w
    public void h(ax axVar) {
        int i;
        if (axVar != null) {
            super.h(axVar);
            getView().setOnClickListener(this);
            this.aQr.setVisibility(8);
            com.baidu.tbadk.core.data.av qF = axVar.qF();
            if (qF != null) {
                if (com.baidu.tbadk.core.l.ob().oh()) {
                    int B = com.baidu.adp.lib.util.k.B(getContext());
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bqb.getLayoutParams();
                    layoutParams.width = B;
                    layoutParams.height = (int) (B / 9.0f);
                    this.bqb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.bqb.setLayoutParams(layoutParams);
                    String qA = qF.qA();
                    if (!StringUtils.isNull(qA)) {
                        TbImageView tbImageView = this.bqb;
                        this.bqb.setImageDrawable(null);
                        this.bqb.reset();
                        this.bqb.setEvent(new as(this, tbImageView));
                        this.bqb.c(qA, this.Zv ? 13 : 14, false);
                    } else {
                        this.bqb.reset();
                        this.bqb.setImageResource(t.f.pic_interview_top);
                    }
                    this.bqb.setVisibility(0);
                    ((RelativeLayout.LayoutParams) this.aQn.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds30);
                } else {
                    ((RelativeLayout.LayoutParams) this.aQn.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds32);
                    this.bqb.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.ob().oh() && qF != null && !StringUtils.isNull(qF.qB())) {
                    this.bqc.setVisibility(0);
                    this.bqc.setSupportNoImage(true);
                    this.bqc.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.bqc.c(qF.qB(), this.Zv ? 13 : 14, false);
                    int B2 = com.baidu.adp.lib.util.k.B(getContext()) - com.baidu.adp.lib.util.k.c(getContext(), t.e.ds160);
                    float qD = qF.qD() / qF.qC();
                    if (qD > 1.0f) {
                        i = (int) (1.0f * B2);
                    } else if (qD < 0.2f) {
                        i = (int) (B2 * 0.2f);
                    } else {
                        i = (int) (B2 * qD);
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bqc.getLayoutParams();
                    layoutParams2.height = i;
                    layoutParams2.width = B2;
                    this.bqc.setLayoutParams(layoutParams2);
                    return;
                }
                this.bqc.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Fn != null) {
            this.Fn.onClick(view);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.Fn = onClickListener;
    }
}
