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
    public RelativeLayout cIs;
    public AdapterLinearLayout cIt;
    public ImageView cIu;
    public boolean cIv;
    private Animation cIw;
    private Animation cIx;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cIv = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cIv = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_expand_layout, this);
        this.cIs = (RelativeLayout) findViewById(d.h.expandable_menu);
        this.cIt = (AdapterLinearLayout) findViewById(d.h.top_layout);
        this.cIu = (ImageView) findViewById(d.h.expandable_btn);
        this.cIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.p(ExpandLayout.this.cIt, ExpandLayout.this.cIt.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cIv) {
            if (this.cIu.getAnimation() != null) {
                this.cIu.getAnimation().cancel();
            }
            this.cIu.clearAnimation();
            this.cIu.setVisibility(8);
            this.cIt.setVisibility(8);
            this.cIv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cIt.getChildCount();
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
            if (this.cIu != null) {
                if (this.cIu.getAnimation() == null || this.cIu.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cIw == null) {
                            amb();
                        }
                        if (this.cIx != null) {
                            this.cIx.cancel();
                        }
                        this.cIu.startAnimation(this.cIw);
                        return;
                    }
                    if (this.cIx == null) {
                        amc();
                    }
                    if (this.cIw != null) {
                        this.cIw.cancel();
                    }
                    this.cIu.startAnimation(this.cIx);
                }
            }
        }
    }

    private void amb() {
        this.cIw = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cIw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cIv = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void amc() {
        this.cIx = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cIx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cIv = false;
            }
        });
    }
}
