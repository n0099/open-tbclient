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
public class r {
    private boolean asQ = false;
    private View axO;
    private View bAi;
    private Animation crC;
    private Animation crD;
    private ViewGroup crJ;
    private a crK;
    private q crL;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void ahi();
    }

    public r(ViewGroup viewGroup) {
        this.crJ = viewGroup;
    }

    public void a(a aVar) {
        this.crK = aVar;
    }

    public boolean isShowing() {
        return this.asQ;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.asQ) {
            this.asQ = true;
            this.axO = b(context, list, i);
            this.crJ.addView(this.axO);
            av.l(this.axO, u.d.common_color_10186);
            this.axO.startAnimation(az(context));
        }
    }

    public void ay(Context context) {
        if (this.axO != null) {
            this.axO.startAnimation(aA(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(u.h.scroll_fragment_more, (ViewGroup) null);
        this.bAi = inflate.findViewById(u.g.more_top_view);
        jr(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(u.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.crL = new q(context, i);
        this.crL.bq(list);
        gridView.setAdapter((ListAdapter) this.crL);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void jr(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bAi.getLayoutParams();
        layoutParams.height = i;
        this.bAi.setLayoutParams(layoutParams);
    }

    private Animation az(Context context) {
        if (this.crC == null) {
            this.crC = AnimationUtils.loadAnimation(context, u.a.dialog_ani_t2b_enter);
        }
        return this.crC;
    }

    private Animation aA(Context context) {
        if (this.crD == null) {
            this.crD = AnimationUtils.loadAnimation(context, u.a.dialog_ani_t2b_exit);
        }
        this.crD.setAnimationListener(new t(this));
        return this.crD;
    }

    public void js(int i) {
        this.topHeight = i;
    }

    public void cX(int i) {
        av.l(this.axO, u.d.common_color_10186);
        if (this.crL != null) {
            this.crL.notifyDataSetChanged();
        }
    }
}
