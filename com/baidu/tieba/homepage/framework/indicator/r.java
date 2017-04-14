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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class r {
    private boolean aAH = false;
    private View bJq;
    private Animation cuY;
    private Animation cuZ;
    private ViewGroup cvf;
    private a cvg;
    private q cvh;
    private View rootView;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aiQ();
    }

    public r(ViewGroup viewGroup) {
        this.cvf = viewGroup;
    }

    public void a(a aVar) {
        this.cvg = aVar;
    }

    public boolean isShowing() {
        return this.aAH;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.aAH) {
            this.aAH = true;
            this.rootView = b(context, list, i);
            this.cvf.addView(this.rootView);
            aq.k(this.rootView, w.e.common_color_10186);
            this.rootView.startAnimation(bp(context));
        }
    }

    public void bo(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(bq(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(w.j.scroll_fragment_more, (ViewGroup) null);
        this.bJq = inflate.findViewById(w.h.more_top_view);
        jK(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(w.h.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cvh = new q(context, i);
        this.cvh.aY(list);
        gridView.setAdapter((ListAdapter) this.cvh);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void jK(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJq.getLayoutParams();
        layoutParams.height = i;
        this.bJq.setLayoutParams(layoutParams);
    }

    private Animation bp(Context context) {
        if (this.cuY == null) {
            this.cuY = AnimationUtils.loadAnimation(context, w.a.dialog_ani_t2b_enter);
        }
        return this.cuY;
    }

    private Animation bq(Context context) {
        if (this.cuZ == null) {
            this.cuZ = AnimationUtils.loadAnimation(context, w.a.dialog_ani_t2b_exit);
        }
        this.cuZ.setAnimationListener(new t(this));
        return this.cuZ;
    }

    public void jL(int i) {
        this.topHeight = i;
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(int i) {
        aq.k(this.rootView, w.e.common_color_10186);
        if (this.cvh != null) {
            this.cvh.notifyDataSetChanged();
        }
    }
}
