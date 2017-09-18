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
    public RelativeLayout cHO;
    public AdapterLinearLayout cHP;
    public ImageView cHQ;
    public boolean cHR;
    private Animation cHS;
    private Animation cHT;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cHR = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHR = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_expand_layout, this);
        this.cHO = (RelativeLayout) findViewById(d.h.expandable_menu);
        this.cHP = (AdapterLinearLayout) findViewById(d.h.top_layout);
        this.cHQ = (ImageView) findViewById(d.h.expandable_btn);
        this.cHQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.q(ExpandLayout.this.cHP, ExpandLayout.this.cHP.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cHR) {
            if (this.cHQ.getAnimation() != null) {
                this.cHQ.getAnimation().cancel();
            }
            this.cHQ.clearAnimation();
            this.cHQ.setVisibility(8);
            this.cHP.setVisibility(8);
            this.cHR = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cHP.getChildCount();
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
            if (this.cHQ != null) {
                if (this.cHQ.getAnimation() == null || this.cHQ.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cHS == null) {
                            amc();
                        }
                        if (this.cHT != null) {
                            this.cHT.cancel();
                        }
                        this.cHQ.startAnimation(this.cHS);
                        return;
                    }
                    if (this.cHT == null) {
                        amd();
                    }
                    if (this.cHS != null) {
                        this.cHS.cancel();
                    }
                    this.cHQ.startAnimation(this.cHT);
                }
            }
        }
    }

    private void amc() {
        this.cHS = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cHS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cHR = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void amd() {
        this.cHT = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cHT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cHR = false;
            }
        });
    }
}
