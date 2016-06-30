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
    private TextView So;
    private TbImageView bSx;
    private com.baidu.tbadk.core.data.s bSy;
    private TbImageView bnX;
    private View bvn;

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
        this.bvn = findViewById(u.g.frs_head_sdk_container);
        this.bnX = (TbImageView) findViewById(u.g.frs_head_sdk_image);
        this.bSx = (TbImageView) findViewById(u.g.frs_head_sdk_title_image);
        this.So = (TextView) findViewById(u.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            this.bSy = sVar;
            this.bnX.c(this.bSy.oQ(), 10, false);
            String oR = this.bSy.oR();
            if (StringUtils.isNull(oR)) {
                this.So.setVisibility(8);
                this.bSx.setVisibility(8);
            } else if (oR.startsWith("http")) {
                this.So.setVisibility(8);
                this.bSx.c(oR, 10, false);
            } else {
                this.bSx.setVisibility(8);
                this.So.setText(oR);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bvn.setOnClickListener(onClickListener);
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        this.bnX.invalidate();
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().w(this);
    }

    public void show() {
        this.bvn.setVisibility(0);
    }
}
