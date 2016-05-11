package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ForumHeadSdkView extends LinearLayout {
    private TextView RX;
    private View aZr;
    private TbImageView buL;
    private TbImageView buM;
    private com.baidu.tbadk.core.data.q buN;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ar(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(t.h.frs_head_sdk_view, this);
        this.aZr = findViewById(t.g.frs_head_sdk_container);
        this.buL = (TbImageView) findViewById(t.g.frs_head_sdk_image);
        this.buM = (TbImageView) findViewById(t.g.frs_head_sdk_title_image);
        this.RX = (TextView) findViewById(t.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            this.buN = qVar;
            this.buL.c(this.buN.oZ(), 10, false);
            String pa = this.buN.pa();
            if (StringUtils.isNull(pa)) {
                this.RX.setVisibility(8);
                this.buM.setVisibility(8);
            } else if (pa.startsWith("http")) {
                this.RX.setVisibility(8);
                this.buM.c(pa, 10, false);
            } else {
                this.buM.setVisibility(8);
                this.RX.setText(pa);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.aZr.setOnClickListener(onClickListener);
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        this.buL.invalidate();
        tbPageContext.getLayoutMode().ae(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }

    public void show() {
        this.aZr.setVisibility(0);
    }
}
