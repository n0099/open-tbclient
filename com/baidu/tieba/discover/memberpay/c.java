package com.baidu.tieba.discover.memberpay;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private List<View> UK;
    private MemberPayActivity aor;

    public c(MemberPayActivity memberPayActivity, List<View> list) {
        this.aor = memberPayActivity;
        this.UK = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.UK == null) {
            return 0;
        }
        return this.UK.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        viewGroup.removeAllViews();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.UK.get(i));
        return this.UK.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        for (View view : this.UK) {
            this.aor.getLayoutMode().L(i == 1);
            this.aor.getLayoutMode().h(view);
        }
    }
}
