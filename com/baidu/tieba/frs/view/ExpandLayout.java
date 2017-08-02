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
    public RelativeLayout cxm;
    public AdapterLinearLayout cxn;
    public ImageView cxo;
    public boolean cxp;
    private Animation cxq;
    private Animation cxr;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cxp = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxp = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.j.frs_expand_layout, this);
        this.cxm = (RelativeLayout) findViewById(d.h.expandable_menu);
        this.cxn = (AdapterLinearLayout) findViewById(d.h.top_layout);
        this.cxo = (ImageView) findViewById(d.h.expandable_btn);
        this.cxo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.p(ExpandLayout.this.cxn, ExpandLayout.this.cxn.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cxp) {
            if (this.cxo.getAnimation() != null) {
                this.cxo.getAnimation().cancel();
            }
            this.cxo.clearAnimation();
            this.cxo.setVisibility(8);
            this.cxn.setVisibility(8);
            this.cxp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cxn.getChildCount();
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
            if (this.cxo != null) {
                if (this.cxo.getAnimation() == null || this.cxo.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cxq == null) {
                            ajw();
                        }
                        if (this.cxr != null) {
                            this.cxr.cancel();
                        }
                        this.cxo.startAnimation(this.cxq);
                        return;
                    }
                    if (this.cxr == null) {
                        ajx();
                    }
                    if (this.cxq != null) {
                        this.cxq.cancel();
                    }
                    this.cxo.startAnimation(this.cxr);
                }
            }
        }
    }

    private void ajw() {
        this.cxq = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cxq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cxp = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void ajx() {
        this.cxr = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cxr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cxp = false;
            }
        });
    }
}
