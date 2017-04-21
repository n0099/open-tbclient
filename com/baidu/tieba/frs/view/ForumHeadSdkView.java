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
    private TextView aaG;
    private View bIP;
    private TbImageView ceG;
    private TbImageView ceH;
    private com.baidu.tbadk.core.data.y ceI;

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
        this.bIP = findViewById(w.h.frs_head_sdk_container);
        this.ceG = (TbImageView) findViewById(w.h.frs_head_sdk_image);
        this.ceH = (TbImageView) findViewById(w.h.frs_head_sdk_title_image);
        this.aaG = (TextView) findViewById(w.h.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.y yVar) {
        if (yVar != null) {
            this.ceI = yVar;
            this.ceG.c(this.ceI.qG(), 10, false);
            String qH = this.ceI.qH();
            if (StringUtils.isNull(qH)) {
                this.aaG.setVisibility(8);
                this.ceH.setVisibility(8);
            } else if (qH.startsWith("http")) {
                this.aaG.setVisibility(8);
                this.ceH.c(qH, 10, false);
            } else {
                this.ceH.setVisibility(8);
                this.aaG.setText(qH);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bIP.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.ceG.invalidate();
        tbPageContext.getLayoutMode().aj(i == 1);
        tbPageContext.getLayoutMode().t(this);
    }

    public void show() {
        this.bIP.setVisibility(0);
    }
}
