package com.baidu.tbadk.widget.horizontalpullview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class RefreshView extends FrameLayout implements a {
    private int aho;
    private ImageView bCQ;
    private int status;
    private TextView textView;

    public RefreshView(@NonNull Context context) {
        this(context, null);
    }

    public RefreshView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefreshView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aho = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pull_left_item_view, (ViewGroup) this, true);
        this.bCQ = (ImageView) findViewById(R.id.arrow_icon);
        this.textView = (TextView) findViewById(R.id.text);
    }

    @Override // com.baidu.tbadk.widget.horizontalpullview.a
    public void bt(View view) {
        if (this.status != 1) {
            this.status = 1;
            this.textView.setText("查看更多");
            SvgManager.baR().a(this.bCQ, R.drawable.ic_icon_pure_jump_more24, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        }
    }

    @Override // com.baidu.tbadk.widget.horizontalpullview.a
    public void bu(View view) {
        if (this.status != 2) {
            this.status = 2;
            this.textView.setText("释放跳转");
            SvgManager.baR().a(this.bCQ, R.drawable.ic_icon_pure_jump24, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        }
    }

    @Override // com.baidu.tbadk.widget.horizontalpullview.a
    public View getView() {
        return this;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aho) {
            this.status = 0;
            this.aho = skinType;
            ao.setViewTextColor(this.textView, R.color.cp_cont_d);
        }
    }
}
