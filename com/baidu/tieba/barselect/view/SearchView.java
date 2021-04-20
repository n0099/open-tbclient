package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class SearchView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f14870e;

    /* renamed from: f  reason: collision with root package name */
    public View f14871f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14872g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14873h;
    public View i;
    public ImageView j;
    public TextView k;
    public View.OnClickListener l;

    public SearchView(Context context) {
        this(context, null);
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.l == null) {
            this.l = onClickListener;
            this.i.setOnClickListener(onClickListener);
        }
    }

    public final void b() {
        this.f14871f = findViewById(R.id.search_view_title_container);
        this.f14872g = (TextView) findViewById(R.id.search_view_title);
        this.f14873h = (TextView) findViewById(R.id.search_view_rank);
        this.i = findViewById(R.id.search_container);
        this.j = (ImageView) findViewById(R.id.search_bar_icon);
        this.k = (TextView) findViewById(R.id.search_text);
    }

    public final void c() {
        this.f14870e = getContext();
        setOrientation(1);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_search_layout, (ViewGroup) this, true);
        b();
    }

    public void d(int i) {
        int g2 = l.g(getContext(), R.dimen.tbds100);
        View view = this.i;
        int i2 = R.color.CAM_X0204;
        SkinManager.setBackgroundShapeDrawable(view, g2, i2, i2, i);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f14872g, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f14873h, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i);
    }

    public void setRank(int i) {
        this.f14871f.setVisibility(0);
        this.f14873h.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }
}
