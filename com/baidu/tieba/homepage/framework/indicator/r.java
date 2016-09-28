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
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class r {
    private View aAy;
    private boolean avA = false;
    private View bLL;
    private Animation cDp;
    private Animation cDq;
    private ViewGroup cDw;
    private a cDx;
    private q cDy;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void amh();
    }

    public r(ViewGroup viewGroup) {
        this.cDw = viewGroup;
    }

    public void a(a aVar) {
        this.cDx = aVar;
    }

    public boolean isShowing() {
        return this.avA;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.avA) {
            this.avA = true;
            this.aAy = b(context, list, i);
            this.cDw.addView(this.aAy);
            av.l(this.aAy, r.d.common_color_10186);
            this.aAy.startAnimation(aJ(context));
        }
    }

    public void aI(Context context) {
        if (this.aAy != null) {
            this.aAy.startAnimation(aK(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(r.h.scroll_fragment_more, (ViewGroup) null);
        this.bLL = inflate.findViewById(r.g.more_top_view);
        jZ(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(r.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cDy = new q(context, i);
        this.cDy.bs(list);
        gridView.setAdapter((ListAdapter) this.cDy);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void jZ(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLL.getLayoutParams();
        layoutParams.height = i;
        this.bLL.setLayoutParams(layoutParams);
    }

    private Animation aJ(Context context) {
        if (this.cDp == null) {
            this.cDp = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_enter);
        }
        return this.cDp;
    }

    private Animation aK(Context context) {
        if (this.cDq == null) {
            this.cDq = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_exit);
        }
        this.cDq.setAnimationListener(new t(this));
        return this.cDq;
    }

    public void ka(int i) {
        this.topHeight = i;
    }

    public void dl(int i) {
        av.l(this.aAy, r.d.common_color_10186);
        if (this.cDy != null) {
            this.cDy.notifyDataSetChanged();
        }
    }
}
