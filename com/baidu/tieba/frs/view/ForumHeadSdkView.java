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
    private TextView VW;
    private TbImageView bBF;
    private View bIR;
    private TbImageView cfC;
    private com.baidu.tbadk.core.data.v cfD;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aC(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        aC(context);
    }

    private void aC(Context context) {
        LayoutInflater.from(context).inflate(r.h.frs_head_sdk_view, this);
        this.bIR = findViewById(r.g.frs_head_sdk_container);
        this.bBF = (TbImageView) findViewById(r.g.frs_head_sdk_image);
        this.cfC = (TbImageView) findViewById(r.g.frs_head_sdk_title_image);
        this.VW = (TextView) findViewById(r.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.v vVar) {
        if (vVar != null) {
            this.cfD = vVar;
            this.bBF.c(this.cfD.pT(), 10, false);
            String pU = this.cfD.pU();
            if (StringUtils.isNull(pU)) {
                this.VW.setVisibility(8);
                this.cfC.setVisibility(8);
            } else if (pU.startsWith("http")) {
                this.VW.setVisibility(8);
                this.cfC.c(pU, 10, false);
            } else {
                this.cfC.setVisibility(8);
                this.VW.setText(pU);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bIR.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.bBF.invalidate();
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }

    public void show() {
        this.bIR.setVisibility(0);
    }
}
