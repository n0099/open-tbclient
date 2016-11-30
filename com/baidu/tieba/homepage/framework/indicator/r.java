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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class r {
    private View aBq;
    private boolean awu = false;
    private View bOE;
    private Animation cIC;
    private Animation cID;
    private ViewGroup cIJ;
    private a cIK;
    private q cIL;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aoc();
    }

    public r(ViewGroup viewGroup) {
        this.cIJ = viewGroup;
    }

    public void a(a aVar) {
        this.cIK = aVar;
    }

    public boolean isShowing() {
        return this.awu;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.awu) {
            this.awu = true;
            this.aBq = b(context, list, i);
            this.cIJ.addView(this.aBq);
            at.l(this.aBq, r.d.common_color_10186);
            this.aBq.startAnimation(aV(context));
        }
    }

    public void aU(Context context) {
        if (this.aBq != null) {
            this.aBq.startAnimation(aW(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(r.h.scroll_fragment_more, (ViewGroup) null);
        this.bOE = inflate.findViewById(r.g.more_top_view);
        kg(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(r.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cIL = new q(context, i);
        this.cIL.bu(list);
        gridView.setAdapter((ListAdapter) this.cIL);
        gridView.setOnItemClickListener(new s(this, context));
        return inflate;
    }

    public void kg(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bOE.getLayoutParams();
        layoutParams.height = i;
        this.bOE.setLayoutParams(layoutParams);
    }

    private Animation aV(Context context) {
        if (this.cIC == null) {
            this.cIC = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_enter);
        }
        return this.cIC;
    }

    private Animation aW(Context context) {
        if (this.cID == null) {
            this.cID = AnimationUtils.loadAnimation(context, r.a.dialog_ani_t2b_exit);
        }
        this.cID.setAnimationListener(new t(this));
        return this.cID;
    }

    public void kh(int i) {
        this.topHeight = i;
    }

    public void dm(int i) {
        at.l(this.aBq, r.d.common_color_10186);
        if (this.cIL != null) {
            this.cIL.notifyDataSetChanged();
        }
    }
}
