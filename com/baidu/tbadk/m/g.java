package com.baidu.tbadk.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g extends a {
    private TextView ajd;
    private int currentIndex;
    private ContinuousAnimationView cyh;
    private String[] cyi;
    private TextView cyj;
    private final int cyk;
    private Runnable cyl;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int atY() {
        this.currentIndex++;
        if (this.currentIndex >= this.cyk) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public g(Context context) {
        this(context, context.getResources().getDimensionPixelSize(R.dimen.ds484));
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.cyl = new Runnable() { // from class: com.baidu.tbadk.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.cyl);
                    return;
                }
                g.this.ajd.setText(g.this.cyi[g.this.atY()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.cyl, 200L);
            }
        };
        this.cyh = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cyh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cyh.setLayoutParams(marginLayoutParams);
            }
        }
        this.ajd = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.cyj = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.cyi = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.cyk = this.cyi.length;
    }

    private void atZ() {
        if (this.cyh != null) {
            this.cyh.br();
        }
    }

    private void aua() {
        if (this.cyh != null) {
            this.cyh.bt();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewAttached() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        atZ();
        am.d(this.ajd, R.color.cp_cont_c, 1, this.mSkinType);
        am.d(this.cyj, R.color.cp_cont_c, 1, this.mSkinType);
        am.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        this.ajd.setText(this.cyi[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cyl);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cyl, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        aua();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cyl);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            atZ();
            am.d(this.ajd, R.color.cp_cont_c, 1, this.mSkinType);
            am.d(this.cyj, R.color.cp_cont_c, 1, this.mSkinType);
            am.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        }
    }

    public View atX() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.m.a
    public void dettachView(View view) {
        if (this.cyh != null) {
            this.cyh.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cyl);
        super.dettachView(view);
    }

    public void iV(int i) {
        if (this.attachedView != null) {
            this.attachedView.setBackgroundColor(i);
        }
    }

    public void setTopMargin(int i) {
        if (this.cyh != null) {
            ViewGroup.LayoutParams layoutParams = this.cyh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cyh.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public TextView aub() {
        return this.cyj;
    }
}
