package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ForumHeadSdkView extends LinearLayout {
    private TextView WM;
    private TbImageView aVj;
    private View bdJ;
    private com.baidu.tbadk.core.data.q buY;
    private Context context;

    public ForumHeadSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aq(context);
    }

    public ForumHeadSdkView(Context context) {
        super(context);
        this.context = context;
        aq(context);
    }

    private void aq(Context context) {
        LayoutInflater.from(context).inflate(t.h.frs_head_sdk_view, this);
        this.bdJ = findViewById(t.g.frs_head_sdk_container);
        this.aVj = (TbImageView) findViewById(t.g.frs_head_sdk_image);
        this.WM = (TextView) findViewById(t.g.frs_head_sdk_title);
    }

    public void setData(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            this.buY = qVar;
            this.aVj.c(this.buY.rG(), 10, false);
            this.WM.setText(this.buY.rH());
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.bdJ.setOnClickListener(onClickListener);
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        this.aVj.invalidate();
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }

    public void show() {
        this.bdJ.setVisibility(0);
    }
}
