package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.o0.r0.v;
/* loaded from: classes4.dex */
public class ReadProgressViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: d  reason: collision with root package name */
    public static final int f15472d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f15473e;

    /* renamed from: a  reason: collision with root package name */
    public View f15474a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15475b;

    /* renamed from: c  reason: collision with root package name */
    public Context f15476c;

    static {
        UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        f15472d = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        f15473e = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
    }

    public ReadProgressViewHolder(View view, Context context) {
        super(view);
        this.f15474a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.f15475b = textView;
        int i2 = f15473e;
        textView.setPadding(0, i2, 0, i2 - f15472d);
        this.f15476c = context;
    }

    public void b() {
        SkinManager.setViewTextColor(this.f15475b, R.color.CAM_X0304);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_card_refresh16, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
        pureDrawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
        this.f15475b.setCompoundDrawables(pureDrawable, null, null, null);
    }

    public void c(v vVar) {
        if (vVar == null) {
            return;
        }
        this.f15475b.setText(R.string.read_here);
        b();
    }
}
