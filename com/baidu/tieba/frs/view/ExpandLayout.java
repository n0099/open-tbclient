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
    public RelativeLayout dbY;
    public AdapterLinearLayout dbZ;
    public ImageView dca;
    public boolean dcb;
    private Animation dcc;
    private Animation dcd;
    private a dce;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void fE(boolean z);
    }

    public ExpandLayout(Context context) {
        super(context);
        this.dcb = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcb = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_expand_layout, this);
        this.dbY = (RelativeLayout) findViewById(d.g.expandable_menu);
        this.dbZ = (AdapterLinearLayout) findViewById(d.g.top_layout);
        this.dca = (ImageView) findViewById(d.g.expandable_btn);
        this.dca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.q(ExpandLayout.this.dbZ, ExpandLayout.this.dbZ.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.dcb) {
            if (this.dca.getAnimation() != null) {
                this.dca.getAnimation().cancel();
            }
            this.dca.clearAnimation();
            this.dca.setVisibility(8);
            this.dbZ.setVisibility(8);
            this.dcb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.dbZ != null) {
            int childCount = this.dbZ.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(d.e.tbds114)) + ((int) this.mContext.getResources().getDimension(d.e.ds1))));
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
                    boolean z = i == 0;
                    if (z && view != null && (view.getParent() instanceof ListView)) {
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
                    if (ExpandLayout.this.dce != null) {
                        ExpandLayout.this.dce.fE(!z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.dca != null) {
                if (this.dca.getAnimation() == null || this.dca.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.dcc == null) {
                            are();
                        }
                        if (this.dcd != null) {
                            this.dcd.cancel();
                        }
                        this.dca.startAnimation(this.dcc);
                        return;
                    }
                    if (this.dcd == null) {
                        arf();
                    }
                    if (this.dcc != null) {
                        this.dcc.cancel();
                    }
                    this.dca.startAnimation(this.dcd);
                }
            }
        }
    }

    private void are() {
        this.dcc = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.dcc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.dcb = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void arf() {
        this.dcd = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.dcd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.dcb = false;
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.dce = aVar;
    }
}
