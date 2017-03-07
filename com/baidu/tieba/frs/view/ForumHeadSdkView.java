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
    private TextView aap;
    private View bGF;
    private TbImageView cdO;
    private TbImageView cdP;
    private com.baidu.tbadk.core.data.y cdQ;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bs(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(w.j.frs_head_sdk_view, this);
        this.bGF = findViewById(w.h.frs_head_sdk_container);
        this.cdO = (TbImageView) findViewById(w.h.frs_head_sdk_image);
        this.cdP = (TbImageView) findViewById(w.h.frs_head_sdk_title_image);
        this.aap = (TextView) findViewById(w.h.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.y yVar) {
        if (yVar != null) {
            this.cdQ = yVar;
            this.cdO.c(this.cdQ.qi(), 10, false);
            String qj = this.cdQ.qj();
            if (StringUtils.isNull(qj)) {
                this.aap.setVisibility(8);
                this.cdP.setVisibility(8);
            } else if (qj.startsWith("http")) {
                this.aap.setVisibility(8);
                this.cdP.c(qj, 10, false);
            } else {
                this.cdP.setVisibility(8);
                this.aap.setText(qj);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bGF.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cdO.invalidate();
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this);
    }

    public void show() {
        this.bGF.setVisibility(0);
    }
}
