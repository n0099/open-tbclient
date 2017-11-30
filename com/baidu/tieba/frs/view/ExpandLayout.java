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
    public RelativeLayout dbc;
    public AdapterLinearLayout dbd;
    public ImageView dbe;
    public boolean dbf;
    private Animation dbg;
    private Animation dbh;
    private a dbi;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void fD(boolean z);
    }

    public ExpandLayout(Context context) {
        super(context);
        this.dbf = false;
        this.mContext = context;
        initView();
    }

    public ExpandLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbf = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.h.frs_expand_layout, this);
        this.dbc = (RelativeLayout) findViewById(d.g.expandable_menu);
        this.dbd = (AdapterLinearLayout) findViewById(d.g.top_layout);
        this.dbe = (ImageView) findViewById(d.g.expandable_btn);
        this.dbe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandLayout.this.q(ExpandLayout.this.dbd, ExpandLayout.this.dbd.getVisibility() == 0 ? 1 : 0);
            }
        });
    }

    public void reset() {
        if (this.dbf) {
            if (this.dbe.getAnimation() != null) {
                this.dbe.getAnimation().cancel();
            }
            this.dbe.clearAnimation();
            this.dbe.setVisibility(8);
            this.dbd.setVisibility(8);
            this.dbf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.dbd != null) {
            int childCount = this.dbd.getChildCount();
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
                    if (ExpandLayout.this.dbi != null) {
                        ExpandLayout.this.dbi.fD(!z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.dbe != null) {
                if (this.dbe.getAnimation() == null || this.dbe.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.dbg == null) {
                            aqU();
                        }
                        if (this.dbh != null) {
                            this.dbh.cancel();
                        }
                        this.dbe.startAnimation(this.dbg);
                        return;
                    }
                    if (this.dbh == null) {
                        aqV();
                    }
                    if (this.dbg != null) {
                        this.dbg.cancel();
                    }
                    this.dbe.startAnimation(this.dbh);
                }
            }
        }
    }

    private void aqU() {
        this.dbg = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.dbg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandLayout.this.dbf = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void aqV() {
        this.dbh = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.dbh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.view.ExpandLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ExpandLayout.this.dbf = false;
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.dbi = aVar;
    }
}
