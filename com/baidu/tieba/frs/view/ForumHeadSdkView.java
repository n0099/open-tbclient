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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ForumHeadSdkView extends LinearLayout {
    private TextView Ve;
    private TbImageView bWt;
    private TbImageView bWu;
    private com.baidu.tbadk.core.data.x bWv;
    private View bzz;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aT(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        aT(context);
    }

    private void aT(Context context) {
        LayoutInflater.from(context).inflate(r.j.frs_head_sdk_view, this);
        this.bzz = findViewById(r.h.frs_head_sdk_container);
        this.bWt = (TbImageView) findViewById(r.h.frs_head_sdk_image);
        this.bWu = (TbImageView) findViewById(r.h.frs_head_sdk_title_image);
        this.Ve = (TextView) findViewById(r.h.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.x xVar) {
        if (xVar != null) {
            this.bWv = xVar;
            this.bWt.c(this.bWv.pQ(), 10, false);
            String pR = this.bWv.pR();
            if (StringUtils.isNull(pR)) {
                this.Ve.setVisibility(8);
                this.bWu.setVisibility(8);
            } else if (pR.startsWith("http")) {
                this.Ve.setVisibility(8);
                this.bWu.c(pR, 10, false);
            } else {
                this.bWu.setVisibility(8);
                this.Ve.setText(pR);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bzz.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.bWt.invalidate();
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().v(this);
    }

    public void show() {
        this.bzz.setVisibility(0);
    }
}
