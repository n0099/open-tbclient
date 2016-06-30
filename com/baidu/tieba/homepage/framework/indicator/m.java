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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class m {
    private boolean asb = false;
    private View axa;
    private View bxU;
    private Animation cph;
    private Animation cpi;
    private ViewGroup cpo;
    private a cpp;
    private l cpq;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void agC();
    }

    public m(ViewGroup viewGroup) {
        this.cpo = viewGroup;
    }

    public void a(a aVar) {
        this.cpp = aVar;
    }

    public boolean isShowing() {
        return this.asb;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.asb) {
            this.asb = true;
            this.axa = b(context, list, i);
            this.cpo.addView(this.axa);
            av.l(this.axa, u.d.common_color_10186);
            this.axa.startAnimation(az(context));
        }
    }

    public void ay(Context context) {
        if (this.axa != null) {
            this.axa.startAnimation(aA(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(u.h.scroll_fragment_more, (ViewGroup) null);
        this.bxU = inflate.findViewById(u.g.more_top_view);
        jm(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(u.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cpq = new l(context, i);
        this.cpq.bm(list);
        gridView.setAdapter((ListAdapter) this.cpq);
        gridView.setOnItemClickListener(new n(this, context));
        return inflate;
    }

    public void jm(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxU.getLayoutParams();
        layoutParams.height = i;
        this.bxU.setLayoutParams(layoutParams);
    }

    private Animation az(Context context) {
        if (this.cph == null) {
            this.cph = AnimationUtils.loadAnimation(context, u.a.dialog_ani_t2b_enter);
        }
        return this.cph;
    }

    private Animation aA(Context context) {
        if (this.cpi == null) {
            this.cpi = AnimationUtils.loadAnimation(context, u.a.dialog_ani_t2b_exit);
        }
        this.cpi.setAnimationListener(new o(this));
        return this.cpi;
    }

    public void jn(int i) {
        this.topHeight = i;
    }

    public void cX(int i) {
        av.l(this.axa, u.d.common_color_10186);
        if (this.cpq != null) {
            this.cpq.notifyDataSetChanged();
        }
    }
}
