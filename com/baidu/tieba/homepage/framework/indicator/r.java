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
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class r {
    private View aAV;
    private boolean avX = false;
    private View bLK;
    private Animation cCK;
    private Animation cCL;
    private ViewGroup cCR;
    private a cCS;
    private q cCT;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void alT();
    }

    public r(ViewGroup viewGroup) {
        this.cCR = viewGroup;
    }

    public void a(a aVar) {
        this.cCS = aVar;
    }

    public boolean isShowing() {
        return this.avX;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.avX) {
            this.avX = true;
            this.aAV = b(context, list, i);
            this.cCR.addView(this.aAV);
            av.l(this.aAV, t.d.common_color_10186);
            this.aAV.startAnimation(aL(context));
        }
    }

    public void aK(Context context) {
        if (this.aAV != null) {
            this.aAV.startAnimation(aM(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(t.h.scroll_fragment_more, (ViewGroup) null);
        this.bLK = inflate.findViewById(t.g.more_top_view);
        jT(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(t.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cCT = new q(context, i);
        this.cCT.bs(list);
        gridView.setAdapter((ListAdapter) this.cCT);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void jT(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLK.getLayoutParams();
        layoutParams.height = i;
        this.bLK.setLayoutParams(layoutParams);
    }

    private Animation aL(Context context) {
        if (this.cCK == null) {
            this.cCK = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_enter);
        }
        return this.cCK;
    }

    private Animation aM(Context context) {
        if (this.cCL == null) {
            this.cCL = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_exit);
        }
        this.cCL.setAnimationListener(new t(this));
        return this.cCL;
    }

    public void jU(int i) {
        this.topHeight = i;
    }

    public void dl(int i) {
        av.l(this.aAV, t.d.common_color_10186);
        if (this.cCT != null) {
            this.cCT.notifyDataSetChanged();
        }
    }
}
