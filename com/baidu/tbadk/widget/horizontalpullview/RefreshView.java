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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class RefreshView extends FrameLayout implements a {
    private int aku;
    private ImageView ckh;
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
        this.aku = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pull_left_item_view, (ViewGroup) this, true);
        this.ckh = (ImageView) findViewById(R.id.arrow_icon);
        this.textView = (TextView) findViewById(R.id.text);
    }

    @Override // com.baidu.tbadk.widget.horizontalpullview.a
    public void bS(View view) {
        if (this.status != 1) {
            this.status = 1;
            this.textView.setText("查看更多");
            SvgManager.btW().a(this.ckh, R.drawable.ic_icon_pure_jump_more24, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        }
    }

    @Override // com.baidu.tbadk.widget.horizontalpullview.a
    public void bT(View view) {
        if (this.status != 2) {
            this.status = 2;
            this.textView.setText("释放跳转");
            SvgManager.btW().a(this.ckh, R.drawable.ic_icon_pure_jump24, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        }
    }

    @Override // com.baidu.tbadk.widget.horizontalpullview.a
    public View getView() {
        return this;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aku) {
            this.status = 0;
            this.aku = skinType;
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
        }
    }
}
