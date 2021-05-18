package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r.f0.m.b;
/* loaded from: classes3.dex */
public class LocationInfoView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f12851e;

    /* renamed from: f  reason: collision with root package name */
    public a f12852f;

    /* renamed from: g  reason: collision with root package name */
    public int f12853g;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public LocationInfoView(Context context) {
        this(context, null);
    }

    public final void a() {
        setOrientation(0);
        setGravity(16);
        b bVar = new b();
        bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.i(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.h(R.color.CAM_X0110);
        bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
        bVar.m(l.g(getContext(), R.dimen.M_H_X002));
        bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
        this.f12851e = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f12851e.setTextSize(R.dimen.T_X09);
        this.f12851e.setOnClickListener(this);
        this.f12851e.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.f12851e, new LinearLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62)));
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(int i2) {
        if (this.f12853g != i2) {
            this.f12851e.k();
            this.f12853g = i2;
        }
    }

    public TBSpecificationBtn getLocationBtn() {
        return this.f12851e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f12852f;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public void setLocationClickListener(a aVar) {
        this.f12852f = aVar;
    }

    public void setState(int i2, String str) {
        if (!StringUtils.isNull(str)) {
            if (str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.f12851e.setText(StringHelper.cutChineseAndEnglishWithSuffix(str, 8, StringHelper.STRING_MORE));
        } else if (i2 == 1) {
            this.f12851e.setText(getContext().getString(R.string.location_loading));
        } else {
            this.f12851e.setText(getContext().getString(R.string.location_where_are_you));
        }
        this.f12851e.f12565e = Integer.valueOf(i2);
    }

    public LocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12853g = 3;
        a();
    }
}
