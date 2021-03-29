package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f15894e;

    /* renamed from: f  reason: collision with root package name */
    public View f15895f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15896g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15897h;
    public TextView i;

    public BawuManagerApplyInfoView(Context context) {
        super(context);
        this.f15894e = context;
        b();
    }

    public void a(String str, int i) {
        this.f15897h.setText(str);
        this.f15896g.setBackgroundDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_ba_add_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.i.setText(String.format(this.f15894e.getResources().getString(R.string.apply_left_num_tip), StringHelper.numberUniformFormat(i)));
            this.f15896g.setEnabled(true);
            this.f15896g.setClickable(true);
            SkinManager.setViewTextColor(this.f15897h, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0305, 1);
            return;
        }
        this.i.setText(this.f15894e.getResources().getString(R.string.apply_no_left_tip));
        this.f15896g.setEnabled(false);
        this.f15896g.setClickable(false);
        SkinManager.setViewTextColor(this.f15897h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f15894e).inflate(R.layout.bawu_manager_apply_layout, this);
        this.f15895f = inflate;
        this.f15896g = (TextView) inflate.findViewById(R.id.imageview_apply_btn);
        this.f15897h = (TextView) this.f15895f.findViewById(R.id.textview_manager_apply);
        this.i = (TextView) this.f15895f.findViewById(R.id.textview_manager_left_num);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f15896g.setOnClickListener(onClickListener);
    }

    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15894e = context;
        b();
    }

    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15894e = context;
        b();
    }
}
