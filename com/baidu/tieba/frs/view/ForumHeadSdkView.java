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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ForumHeadSdkView extends LinearLayout {
    private TextView aaF;
    private View bGy;
    private TbImageView ccp;
    private TbImageView ccq;
    private com.baidu.tbadk.core.data.y ccr;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bm(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        bm(context);
    }

    private void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.frs_head_sdk_view, this);
        this.bGy = findViewById(w.h.frs_head_sdk_container);
        this.ccp = (TbImageView) findViewById(w.h.frs_head_sdk_image);
        this.ccq = (TbImageView) findViewById(w.h.frs_head_sdk_title_image);
        this.aaF = (TextView) findViewById(w.h.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.y yVar) {
        if (yVar != null) {
            this.ccr = yVar;
            this.ccp.c(this.ccr.qG(), 10, false);
            String qH = this.ccr.qH();
            if (StringUtils.isNull(qH)) {
                this.aaF.setVisibility(8);
                this.ccq.setVisibility(8);
            } else if (qH.startsWith("http")) {
                this.aaF.setVisibility(8);
                this.ccq.c(qH, 10, false);
            } else {
                this.ccq.setVisibility(8);
                this.aaF.setText(qH);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bGy.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.ccp.invalidate();
        tbPageContext.getLayoutMode().aj(i == 1);
        tbPageContext.getLayoutMode().t(this);
    }

    public void show() {
        this.bGy.setVisibility(0);
    }
}
