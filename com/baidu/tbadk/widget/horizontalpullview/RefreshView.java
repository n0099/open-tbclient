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
import d.b.h0.b1.h.a;
/* loaded from: classes3.dex */
public class RefreshView extends FrameLayout implements a {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f14164e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14165f;

    /* renamed from: g  reason: collision with root package name */
    public int f14166g;

    /* renamed from: h  reason: collision with root package name */
    public int f14167h;

    public RefreshView(@NonNull Context context) {
        this(context, null);
    }

    @Override // d.b.h0.b1.h.a
    public void a(View view) {
        if (this.f14167h != 2) {
            this.f14167h = 2;
            this.f14165f.setText("释放跳转");
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14164e, R.drawable.ic_icon_pure_jump24, R.color.CAM_X0109, null);
        }
    }

    @Override // d.b.h0.b1.h.a
    public void b(View view) {
        if (this.f14167h != 1) {
            this.f14167h = 1;
            this.f14165f.setText("查看更多");
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14164e, R.drawable.ic_icon_pure_jump_more24, R.color.CAM_X0109, null);
        }
    }

    public final void c(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pull_left_item_view, (ViewGroup) this, true);
        this.f14164e = (ImageView) findViewById(R.id.arrow_icon);
        this.f14165f = (TextView) findViewById(R.id.text);
    }

    public void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.f14166g) {
            this.f14167h = 0;
            this.f14166g = skinType;
            SkinManager.setViewTextColor(this.f14165f, R.color.CAM_X0109);
        }
    }

    @Override // d.b.h0.b1.h.a
    public View getView() {
        return this;
    }

    public RefreshView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefreshView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14166g = 3;
        c(context);
    }
}
