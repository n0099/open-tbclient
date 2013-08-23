package com.baidu.tieba.guide;

import android.content.Context;
import android.support.v4.view.ae;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class TextPagerAdapter extends ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View.OnClickListener f1123a;

    @Override // android.support.v4.view.ae
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return obj.equals(view);
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View a2 = a(viewGroup.getContext(), viewGroup, i);
        viewGroup.addView(a2);
        return a2;
    }

    private View a(Context context, ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return LayoutInflater.from(context).inflate(R.layout.guide_page_1, viewGroup, false);
            case 1:
                return LayoutInflater.from(context).inflate(R.layout.guide_page_2, viewGroup, false);
            case 2:
                View inflate = LayoutInflater.from(context).inflate(R.layout.guide_page_3, viewGroup, false);
                inflate.findViewById(R.id.enter).setOnClickListener(this);
                return inflate;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.enter && this.f1123a != null) {
            this.f1123a.onClick(view);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f1123a = onClickListener;
    }
}
