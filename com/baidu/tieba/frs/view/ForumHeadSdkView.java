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
    private TextView VM;
    private TbImageView bBu;
    private View bIQ;
    private TbImageView cfF;
    private com.baidu.tbadk.core.data.u cfG;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aE(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        aE(context);
    }

    private void aE(Context context) {
        LayoutInflater.from(context).inflate(t.h.frs_head_sdk_view, this);
        this.bIQ = findViewById(t.g.frs_head_sdk_container);
        this.bBu = (TbImageView) findViewById(t.g.frs_head_sdk_image);
        this.cfF = (TbImageView) findViewById(t.g.frs_head_sdk_title_image);
        this.VM = (TextView) findViewById(t.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.u uVar) {
        if (uVar != null) {
            this.cfG = uVar;
            this.bBu.c(this.cfG.pI(), 10, false);
            String pJ = this.cfG.pJ();
            if (StringUtils.isNull(pJ)) {
                this.VM.setVisibility(8);
                this.cfF.setVisibility(8);
            } else if (pJ.startsWith("http")) {
                this.VM.setVisibility(8);
                this.cfF.c(pJ, 10, false);
            } else {
                this.cfF.setVisibility(8);
                this.VM.setText(pJ);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bIQ.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.bBu.invalidate();
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }

    public void show() {
        this.bIQ.setVisibility(0);
    }
}
