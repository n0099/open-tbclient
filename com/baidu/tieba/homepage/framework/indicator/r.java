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
    private boolean aAr = false;
    private View bJx;
    private ViewGroup cwF;
    private a cwG;
    private q cwH;
    private Animation cwy;
    private Animation cwz;
    private View rootView;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aiW();
    }

    public r(ViewGroup viewGroup) {
        this.cwF = viewGroup;
    }

    public void a(a aVar) {
        this.cwG = aVar;
    }

    public boolean isShowing() {
        return this.aAr;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.aAr) {
            this.aAr = true;
            this.rootView = b(context, list, i);
            this.cwF.addView(this.rootView);
            aq.k(this.rootView, w.e.common_color_10186);
            this.rootView.startAnimation(bw(context));
        }
    }

    public void bv(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(bx(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(w.j.scroll_fragment_more, (ViewGroup) null);
        this.bJx = inflate.findViewById(w.h.more_top_view);
        jJ(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(w.h.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cwH = new q(context, i);
        this.cwH.aZ(list);
        gridView.setAdapter((ListAdapter) this.cwH);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void jJ(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJx.getLayoutParams();
        layoutParams.height = i;
        this.bJx.setLayoutParams(layoutParams);
    }

    private Animation bw(Context context) {
        if (this.cwy == null) {
            this.cwy = AnimationUtils.loadAnimation(context, w.a.dialog_ani_t2b_enter);
        }
        return this.cwy;
    }

    private Animation bx(Context context) {
        if (this.cwz == null) {
            this.cwz = AnimationUtils.loadAnimation(context, w.a.dialog_ani_t2b_exit);
        }
        this.cwz.setAnimationListener(new t(this));
        return this.cwz;
    }

    public void jK(int i) {
        this.topHeight = i;
    }

    public void dl(int i) {
        aq.k(this.rootView, w.e.common_color_10186);
        if (this.cwH != null) {
            this.cwH.notifyDataSetChanged();
        }
    }
}
