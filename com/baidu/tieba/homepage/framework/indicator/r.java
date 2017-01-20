package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class r {
    private boolean auW = false;
    private View bCq;
    private Animation cuZ;
    private Animation cva;
    private ViewGroup cvg;
    private a cvh;
    private q cvi;
    private View rootView;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void ajK();
    }

    public r(ViewGroup viewGroup) {
        this.cvg = viewGroup;
    }

    public void a(a aVar) {
        this.cvh = aVar;
    }

    public boolean isShowing() {
        return this.auW;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.auW) {
            this.auW = true;
            this.rootView = b(context, list, i);
            this.cvg.addView(this.rootView);
            ap.k(this.rootView, r.e.common_color_10186);
            this.rootView.startAnimation(aX(context));
        }
    }

    public void aW(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(aY(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(r.j.scroll_fragment_more, (ViewGroup) null);
        this.bCq = inflate.findViewById(r.h.more_top_view);
        ke(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(r.h.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cvi = new q(context, i);
        this.cvi.bs(list);
        gridView.setAdapter((ListAdapter) this.cvi);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void ke(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCq.getLayoutParams();
        layoutParams.height = i;
        this.bCq.setLayoutParams(layoutParams);
    }

    private Animation aX(Context context) {
        if (this.cuZ == null) {
            this.cuZ = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_enter);
        }
        return this.cuZ;
    }

    private Animation aY(Context context) {
        if (this.cva == null) {
            this.cva = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_exit);
        }
        this.cva.setAnimationListener(new t(this));
        return this.cva;
    }

    public void kf(int i) {
        this.topHeight = i;
    }

    public void dp(int i) {
        ap.k(this.rootView, r.e.common_color_10186);
        if (this.cvi != null) {
            this.cvi.notifyDataSetChanged();
        }
    }
}
