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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class r {
    private View aAK;
    private boolean avR = false;
    private View buJ;
    private Animation cnX;
    private Animation cnY;
    private ViewGroup coe;
    private a cof;
    private q cog;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aiC();
    }

    public r(ViewGroup viewGroup) {
        this.coe = viewGroup;
    }

    public void a(a aVar) {
        this.cof = aVar;
    }

    public boolean isShowing() {
        return this.avR;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.avR) {
            this.avR = true;
            this.aAK = b(context, list, i);
            this.coe.addView(this.aAK);
            ar.l(this.aAK, r.d.common_color_10186);
            this.aAK.startAnimation(aU(context));
        }
    }

    public void aT(Context context) {
        if (this.aAK != null) {
            this.aAK.startAnimation(aV(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(r.h.scroll_fragment_more, (ViewGroup) null);
        this.buJ = inflate.findViewById(r.g.more_top_view);
        jr(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(r.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cog = new q(context, i);
        this.cog.bm(list);
        gridView.setAdapter((ListAdapter) this.cog);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void jr(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.buJ.getLayoutParams();
        layoutParams.height = i;
        this.buJ.setLayoutParams(layoutParams);
    }

    private Animation aU(Context context) {
        if (this.cnX == null) {
            this.cnX = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_enter);
        }
        return this.cnX;
    }

    private Animation aV(Context context) {
        if (this.cnY == null) {
            this.cnY = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_exit);
        }
        this.cnY.setAnimationListener(new t(this));
        return this.cnY;
    }

    public void js(int i) {
        this.topHeight = i;
    }

    /* renamed from: do  reason: not valid java name */
    public void m19do(int i) {
        ar.l(this.aAK, r.d.common_color_10186);
        if (this.cog != null) {
            this.cog.notifyDataSetChanged();
        }
    }
}
