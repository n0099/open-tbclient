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
    public RelativeLayout cIE;
    public AdapterLinearLayout cIF;
    public ImageView cIG;
    public boolean cIH;
    private Animation cII;
    private Animation cIJ;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cIH = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cIH = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_expand_layout, this);
        this.cIE = (RelativeLayout) findViewById(d.h.expandable_menu);
        this.cIF = (AdapterLinearLayout) findViewById(d.h.top_layout);
        this.cIG = (ImageView) findViewById(d.h.expandable_btn);
        this.cIG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.p(ExpandLayout.this.cIF, ExpandLayout.this.cIF.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cIH) {
            if (this.cIG.getAnimation() != null) {
                this.cIG.getAnimation().cancel();
            }
            this.cIG.clearAnimation();
            this.cIG.setVisibility(8);
            this.cIF.setVisibility(8);
            this.cIH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cIF.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(d.f.ds80)) + ((int) this.mContext.getResources().getDimension(d.f.ds1))));
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
                    if (i == 0 && view != null && (view.getParent() instanceof ListView)) {
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
            if (this.cIG != null) {
                if (this.cIG.getAnimation() == null || this.cIG.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cII == null) {
                            amg();
                        }
                        if (this.cIJ != null) {
                            this.cIJ.cancel();
                        }
                        this.cIG.startAnimation(this.cII);
                        return;
                    }
                    if (this.cIJ == null) {
                        amh();
                    }
                    if (this.cII != null) {
                        this.cII.cancel();
                    }
                    this.cIG.startAnimation(this.cIJ);
                }
            }
        }
    }

    private void amg() {
        this.cII = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cII.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cIH = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void amh() {
        this.cIJ = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cIJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cIH = false;
            }
        });
    }
}
