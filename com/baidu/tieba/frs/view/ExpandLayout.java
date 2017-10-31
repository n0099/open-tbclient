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
    public RelativeLayout cRE;
    public AdapterLinearLayout cRF;
    public ImageView cRG;
    public boolean cRH;
    private Animation cRI;
    private Animation cRJ;
    private Context mContext;

    public ExpandLayout(Context context) {
        super(context);
        this.cRH = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRH = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_expand_layout, this);
        this.cRE = (RelativeLayout) findViewById(d.g.expandable_menu);
        this.cRF = (AdapterLinearLayout) findViewById(d.g.top_layout);
        this.cRG = (ImageView) findViewById(d.g.expandable_btn);
        this.cRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.q(ExpandLayout.this.cRF, ExpandLayout.this.cRF.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.cRH) {
            if (this.cRG.getAnimation() != null) {
                this.cRG.getAnimation().cancel();
            }
            this.cRG.clearAnimation();
            this.cRG.setVisibility(8);
            this.cRF.setVisibility(8);
            this.cRH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final View view, final int i) {
        if (view == null || view.getAnimation() == null) {
            int childCount = this.cRF.getChildCount();
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
            if (this.cRG != null) {
                if (this.cRG.getAnimation() == null || this.cRG.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.cRI == null) {
                            aoM();
                        }
                        if (this.cRJ != null) {
                            this.cRJ.cancel();
                        }
                        this.cRG.startAnimation(this.cRI);
                        return;
                    }
                    if (this.cRJ == null) {
                        aoN();
                    }
                    if (this.cRI != null) {
                        this.cRI.cancel();
                    }
                    this.cRG.startAnimation(this.cRJ);
                }
            }
        }
    }

    private void aoM() {
        this.cRI = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.cRI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.cRH = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void aoN() {
        this.cRJ = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.cRJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.cRH = false;
            }
        });
    }
}
