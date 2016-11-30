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
    private TextView Wu;
    private TbImageView bEA;
    private View bLK;
    private TbImageView ckF;
    private com.baidu.tbadk.core.data.x ckG;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aO(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        aO(context);
    }

    private void aO(Context context) {
        LayoutInflater.from(context).inflate(r.h.frs_head_sdk_view, this);
        this.bLK = findViewById(r.g.frs_head_sdk_container);
        this.bEA = (TbImageView) findViewById(r.g.frs_head_sdk_image);
        this.ckF = (TbImageView) findViewById(r.g.frs_head_sdk_title_image);
        this.Wu = (TextView) findViewById(r.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.x xVar) {
        if (xVar != null) {
            this.ckG = xVar;
            this.bEA.c(this.ckG.pW(), 10, false);
            String pX = this.ckG.pX();
            if (StringUtils.isNull(pX)) {
                this.Wu.setVisibility(8);
                this.ckF.setVisibility(8);
            } else if (pX.startsWith("http")) {
                this.Wu.setVisibility(8);
                this.ckF.c(pX, 10, false);
            } else {
                this.ckF.setVisibility(8);
                this.Wu.setText(pX);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bLK.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.bEA.invalidate();
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }

    public void show() {
        this.bLK.setVisibility(0);
    }
}
