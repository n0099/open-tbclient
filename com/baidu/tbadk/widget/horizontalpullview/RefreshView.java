package com.baidu.tbadk.widget.horizontalpullview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.i0.b1.h.a;
/* loaded from: classes3.dex */
public class RefreshView extends FrameLayout implements a {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13848e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13849f;

    /* renamed from: g  reason: collision with root package name */
    public int f13850g;

    /* renamed from: h  reason: collision with root package name */
    public int f13851h;

    public RefreshView(@NonNull Context context) {
        this(context, null);
    }

    @Override // d.b.i0.b1.h.a
    public void a(View view) {
        if (this.f13851h != 2) {
            this.f13851h = 2;
            this.f13849f.setText("释放跳转");
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13848e, R.drawable.ic_icon_pure_jump24, R.color.CAM_X0109, null);
        }
    }

    @Override // d.b.i0.b1.h.a
    public void b(View view) {
        if (this.f13851h != 1) {
            this.f13851h = 1;
            this.f13849f.setText("查看更多");
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13848e, R.drawable.ic_icon_pure_jump_more24, R.color.CAM_X0109, null);
        }
    }

    public final void c(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pull_left_item_view, (ViewGroup) this, true);
        this.f13848e = (ImageView) findViewById(R.id.arrow_icon);
        this.f13849f = (TextView) findViewById(R.id.text);
    }

    public void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.f13850g) {
            this.f13851h = 0;
            this.f13850g = skinType;
            SkinManager.setViewTextColor(this.f13849f, R.color.CAM_X0109);
        }
    }

    @Override // d.b.i0.b1.h.a
    public View getView() {
        return this;
    }

    public RefreshView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefreshView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13850g = 3;
        c(context);
    }
}
