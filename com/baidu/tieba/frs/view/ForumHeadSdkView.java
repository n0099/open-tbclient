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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ForumHeadSdkView extends LinearLayout {
    private TextView SW;
    private TbImageView bUx;
    private com.baidu.tbadk.core.data.t bUy;
    private TbImageView bqh;
    private View bxB;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ar(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.frs_head_sdk_view, this);
        this.bxB = findViewById(u.g.frs_head_sdk_container);
        this.bqh = (TbImageView) findViewById(u.g.frs_head_sdk_image);
        this.bUx = (TbImageView) findViewById(u.g.frs_head_sdk_title_image);
        this.SW = (TextView) findViewById(u.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.t tVar) {
        if (tVar != null) {
            this.bUy = tVar;
            this.bqh.c(this.bUy.oF(), 10, false);
            String oG = this.bUy.oG();
            if (StringUtils.isNull(oG)) {
                this.SW.setVisibility(8);
                this.bUx.setVisibility(8);
            } else if (oG.startsWith("http")) {
                this.SW.setVisibility(8);
                this.bUx.c(oG, 10, false);
            } else {
                this.bUx.setVisibility(8);
                this.SW.setText(oG);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bxB.setOnClickListener(onClickListener);
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        this.bqh.invalidate();
        tbPageContext.getLayoutMode().af(i == 1);
        tbPageContext.getLayoutMode().w(this);
    }

    public void show() {
        this.bxB.setVisibility(0);
    }
}
