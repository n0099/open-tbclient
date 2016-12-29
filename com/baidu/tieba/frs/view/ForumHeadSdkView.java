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
    private TextView VO;
    private TbImageView bPO;
    private TbImageView bPP;
    private com.baidu.tbadk.core.data.w bPQ;
    private View brO;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aN(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        aN(context);
    }

    private void aN(Context context) {
        LayoutInflater.from(context).inflate(r.h.frs_head_sdk_view, this);
        this.brO = findViewById(r.g.frs_head_sdk_container);
        this.bPO = (TbImageView) findViewById(r.g.frs_head_sdk_image);
        this.bPP = (TbImageView) findViewById(r.g.frs_head_sdk_title_image);
        this.VO = (TextView) findViewById(r.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.w wVar) {
        if (wVar != null) {
            this.bPQ = wVar;
            this.bPO.c(this.bPQ.pX(), 10, false);
            String pY = this.bPQ.pY();
            if (StringUtils.isNull(pY)) {
                this.VO.setVisibility(8);
                this.bPP.setVisibility(8);
            } else if (pY.startsWith("http")) {
                this.VO.setVisibility(8);
                this.bPP.c(pY, 10, false);
            } else {
                this.bPP.setVisibility(8);
                this.VO.setText(pY);
            }
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.brO.setOnClickListener(onClickListener);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        this.bPO.invalidate();
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }

    public void show() {
        this.brO.setVisibility(0);
    }
}
