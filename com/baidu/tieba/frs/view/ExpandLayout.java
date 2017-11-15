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
    public RelativeLayout cRY;
    public AdapterLinearLayout cRZ;
    public ImageView cSa;
    public boolean cSb;
    private Animation cSc;
    private Animation cSd;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cSb = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSb = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_expand_layout, this);
        this.cRY = (RelativeLayout) findViewById(d.g.expandable_menu);
        this.cRZ = (AdapterLinearLayout) findViewById(d.g.top_layout);
        this.cSa = (ImageView) findViewById(d.g.expandable_btn);
        this.cSa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.q(ExpandLayout.this.cRZ, ExpandLayout.this.cRZ.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cSb) {
            if (this.cSa.getAnimation() != null) {
                this.cSa.getAnimation().cancel();
            }
            this.cSa.clearAnimation();
            this.cSa.setVisibility(8);
            this.cRZ.setVisibility(8);
            this.cSb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cRZ.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(d.e.ds80)) + ((int) this.mContext.getResources().getDimension(d.e.ds1))));
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
            if (this.cSa != null) {
                if (this.cSa.getAnimation() == null || this.cSa.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cSc == null) {
                            apb();
                        }
                        if (this.cSd != null) {
                            this.cSd.cancel();
                        }
                        this.cSa.startAnimation(this.cSc);
                        return;
                    }
                    if (this.cSd == null) {
                        apc();
                    }
                    if (this.cSc != null) {
                        this.cSc.cancel();
                    }
                    this.cSa.startAnimation(this.cSd);
                }
            }
        }
    }

    private void apb() {
        this.cSc = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cSc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cSb = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void apc() {
        this.cSd = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cSd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cSb = false;
            }
        });
    }
}
