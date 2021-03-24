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
import d.b.i0.p0.v;
/* loaded from: classes4.dex */
public class ReadProgressViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: d  reason: collision with root package name */
    public static final int f16249d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f16250e;

    /* renamed from: a  reason: collision with root package name */
    public View f16251a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16252b;

    /* renamed from: c  reason: collision with root package name */
    public Context f16253c;

    static {
        UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        f16249d = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        f16250e = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
    }

    public ReadProgressViewHolder(View view, Context context) {
        super(view);
        this.f16251a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.f16252b = textView;
        int i = f16250e;
        textView.setPadding(0, i, 0, i - f16249d);
        this.f16253c = context;
    }

    public void b() {
        SkinManager.setViewTextColor(this.f16252b, R.color.CAM_X0304);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_card_refresh16, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
        pureDrawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
        this.f16252b.setCompoundDrawables(pureDrawable, null, null, null);
    }

    public void c(v vVar) {
        if (vVar == null) {
            return;
        }
        this.f16252b.setText(R.string.read_here);
        b();
    }
}
