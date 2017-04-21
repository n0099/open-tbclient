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
    private boolean aAJ = false;
    private View bLH;
    private Animation cxp;
    private Animation cxq;
    private ViewGroup cxw;
    private a cxx;
    private q cxy;
    private View rootView;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void ajR();
    }

    public r(ViewGroup viewGroup) {
        this.cxw = viewGroup;
    }

    public void a(a aVar) {
        this.cxx = aVar;
    }

    public boolean isShowing() {
        return this.aAJ;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.aAJ) {
            this.aAJ = true;
            this.rootView = b(context, list, i);
            this.cxw.addView(this.rootView);
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
        this.bLH = inflate.findViewById(w.h.more_top_view);
        jQ(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(w.h.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cxy = new q(context, i);
        this.cxy.aZ(list);
        gridView.setAdapter((ListAdapter) this.cxy);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void jQ(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLH.getLayoutParams();
        layoutParams.height = i;
        this.bLH.setLayoutParams(layoutParams);
    }

    private Animation bp(Context context) {
        if (this.cxp == null) {
            this.cxp = AnimationUtils.loadAnimation(context, w.a.dialog_ani_t2b_enter);
        }
        return this.cxp;
    }

    private Animation bq(Context context) {
        if (this.cxq == null) {
            this.cxq = AnimationUtils.loadAnimation(context, w.a.dialog_ani_t2b_exit);
        }
        this.cxq.setAnimationListener(new t(this));
        return this.cxq;
    }

    public void jR(int i) {
        this.topHeight = i;
    }

    /* renamed from: do  reason: not valid java name */
    public void m21do(int i) {
        aq.k(this.rootView, w.e.common_color_10186);
        if (this.cxy != null) {
            this.cxy.notifyDataSetChanged();
        }
    }
}
