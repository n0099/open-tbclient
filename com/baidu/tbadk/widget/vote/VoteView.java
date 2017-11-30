package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private List<c> aWS;
    private final int aWT;
    private LinkedList<c> aWU;
    private int aWV;
    private boolean aWW;
    private int aWX;
    private int aWY;
    private int aWp;
    private int aWq;
    private List<c> aWr;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aWT = 3;
        this.aWW = false;
        this.aWp = -1;
        this.aWX = -1;
        this.aWq = -1;
        this.aWY = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aWT = 3;
        this.aWW = false;
        this.aWp = -1;
        this.aWX = -1;
        this.aWq = -1;
        this.aWY = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aWr = new ArrayList();
        this.aWU = new LinkedList<>();
        this.aWV = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aWp = i;
    }

    public void setDescTextColorResId(int i) {
        this.aWq = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aWX = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aWV = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            gj(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Km();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aWr.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aWV - i;
            for (c cVar : this.aWr) {
                if (cVar != null) {
                    cVar.gi(i2);
                    addView(cVar.getView());
                }
            }
            if (z) {
                a aVar2 = new a();
                aVar2.setDuration(300L);
                startAnimation(aVar2);
                return;
            }
            setProgress(1.0f);
        }
    }

    public void setBoallotsForListView(List<com.baidu.tbadk.widget.vote.a> list) {
        int a2;
        if (!this.aWW) {
            Kl();
            this.aWW = true;
        }
        if (this.aWS != null && list != null && this.aWS.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.c(this.aWS, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) v.c(list, i);
                    if (aVar == null) {
                        a2 = i2;
                    } else {
                        a2 = cVar.a(aVar);
                        if (a2 <= i2) {
                            a2 = i2;
                        }
                    }
                    i++;
                    i2 = a2;
                } else {
                    return;
                }
            }
            for (int i3 = 0; i3 < 3; i3++) {
                c cVar2 = (c) v.c(this.aWS, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.gi(this.aWV - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Kl() {
        this.aWS = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Km = Km();
            this.aWS.add(Km);
            addView(Km.getView());
        }
    }

    private void gj(int i) {
        int size;
        this.aWU.addAll(this.aWr);
        this.aWr.clear();
        if (i > 0 && (size = this.aWU.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aWU.add(Km());
            }
        }
    }

    private c Km() {
        c cVar = this.aWq != -1 ? new c(getContext(), this.aWq) : new c(getContext());
        if (this.aWX != -1) {
            cVar.setProgressBarTopMargin(this.aWX);
        }
        if (this.aWp != -1) {
            cVar.setProgressBarHeight(this.aWp);
        }
        if (this.aWY != -1) {
            cVar.setDescTopMargin(this.aWY);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aWU.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aWr != null) {
            for (c cVar : this.aWr) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aWY = i;
    }

    /* loaded from: classes.dex */
    private class a extends Animation {
        private a() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            VoteView.this.setProgress(f);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i && this.aWr != null) {
            this.mSkinType = i;
            for (c cVar : this.aWr) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aWS != null) {
                for (c cVar2 : this.aWS) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
