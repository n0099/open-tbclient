package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ExpandLayout extends LinearLayout {
    public RelativeLayout cAE;
    public AdapterLinearLayout cAF;
    public ImageView cAG;
    public boolean cAH;
    private Animation cAI;
    private Animation cAJ;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cAH = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAH = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_expand_layout, this);
        this.cAE = (RelativeLayout) findViewById(d.h.expandable_menu);
        this.cAF = (AdapterLinearLayout) findViewById(d.h.top_layout);
        this.cAG = (ImageView) findViewById(d.h.expandable_btn);
        this.cAG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.p(ExpandLayout.this.cAF, ExpandLayout.this.cAF.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cAH) {
            if (this.cAG.getAnimation() != null) {
                this.cAG.getAnimation().cancel();
            }
            this.cAG.clearAnimation();
            this.cAG.setVisibility(8);
            this.cAF.setVisibility(8);
            this.cAH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cAF.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(d.f.ds80)) + ((int) this.mContext.getResources().getDimension(d.f.ds1))));
            if (i == 0 && view.getVisibility() != 0) {
                view.setVisibility(0);
            }
            aVar.setDuration(260L);
            aVar.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (i == 0 && (view.getParent() instanceof ListView)) {
                        ListView listView = (ListView) view.getParent();
                        int bottom = view.getBottom();
                        Rect rect = new Rect();
                        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        listView.getGlobalVisibleRect(rect2);
                        if (!globalVisibleRect) {
                            listView.smoothScrollBy(bottom, 260);
                        } else if (rect2.bottom == rect.bottom) {
                            listView.smoothScrollBy(bottom, 260);
                        }
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.cAG != null) {
                if (this.cAG.getAnimation() == null || this.cAG.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cAI == null) {
                            akj();
                        }
                        if (this.cAJ != null) {
                            this.cAJ.cancel();
                        }
                        this.cAG.startAnimation(this.cAI);
                        return;
                    }
                    if (this.cAJ == null) {
                        akk();
                    }
                    if (this.cAI != null) {
                        this.cAI.cancel();
                    }
                    this.cAG.startAnimation(this.cAJ);
                }
            }
        }
    }

    private void akj() {
        this.cAI = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cAI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cAH = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void akk() {
        this.cAJ = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cAJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cAH = false;
            }
        });
    }
}
