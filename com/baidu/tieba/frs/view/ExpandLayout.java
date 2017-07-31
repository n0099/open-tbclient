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
    public RelativeLayout cyE;
    public AdapterLinearLayout cyF;
    public ImageView cyG;
    public boolean cyH;
    private Animation cyI;
    private Animation cyJ;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cyH = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyH = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_expand_layout, this);
        this.cyE = (RelativeLayout) findViewById(d.h.expandable_menu);
        this.cyF = (AdapterLinearLayout) findViewById(d.h.top_layout);
        this.cyG = (ImageView) findViewById(d.h.expandable_btn);
        this.cyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.p(ExpandLayout.this.cyF, ExpandLayout.this.cyF.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cyH) {
            if (this.cyG.getAnimation() != null) {
                this.cyG.getAnimation().cancel();
            }
            this.cyG.clearAnimation();
            this.cyG.setVisibility(8);
            this.cyF.setVisibility(8);
            this.cyH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cyF.getChildCount();
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
            if (this.cyG != null) {
                if (this.cyG.getAnimation() == null || this.cyG.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cyI == null) {
                            ajK();
                        }
                        if (this.cyJ != null) {
                            this.cyJ.cancel();
                        }
                        this.cyG.startAnimation(this.cyI);
                        return;
                    }
                    if (this.cyJ == null) {
                        ajL();
                    }
                    if (this.cyI != null) {
                        this.cyI.cancel();
                    }
                    this.cyG.startAnimation(this.cyJ);
                }
            }
        }
    }

    private void ajK() {
        this.cyI = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cyI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cyH = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void ajL() {
        this.cyJ = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cyJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cyH = false;
            }
        });
    }
}
