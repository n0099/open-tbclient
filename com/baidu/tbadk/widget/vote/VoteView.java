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
    private List<c> aTR;
    private final int aTS;
    private LinkedList<c> aTT;
    private int aTU;
    private boolean aTV;
    private int aTW;
    private int aTX;
    private int aTo;
    private int aTp;
    private List<c> aTq;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aTS = 3;
        this.aTV = false;
        this.aTo = -1;
        this.aTW = -1;
        this.aTp = -1;
        this.aTX = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aTS = 3;
        this.aTV = false;
        this.aTo = -1;
        this.aTW = -1;
        this.aTp = -1;
        this.aTX = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aTq = new ArrayList();
        this.aTT = new LinkedList<>();
        this.aTU = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aTo = i;
    }

    public void setDescTextColorResId(int i) {
        this.aTp = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aTW = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aTU = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            gb(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = JP();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aTq.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aTU - i;
            for (c cVar : this.aTq) {
                if (cVar != null) {
                    cVar.ga(i2);
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
        if (!this.aTV) {
            JO();
            this.aTV = true;
        }
        if (this.aTR != null && list != null && this.aTR.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.c(this.aTR, i);
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
                c cVar2 = (c) v.c(this.aTR, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.ga(this.aTU - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void JO() {
        this.aTR = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c JP = JP();
            this.aTR.add(JP);
            addView(JP.getView());
        }
    }

    private void gb(int i) {
        int size;
        this.aTT.addAll(this.aTq);
        this.aTq.clear();
        if (i > 0 && (size = this.aTT.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aTT.add(JP());
            }
        }
    }

    private c JP() {
        c cVar = this.aTp != -1 ? new c(getContext(), this.aTp) : new c(getContext());
        if (this.aTW != -1) {
            cVar.setProgressBarTopMargin(this.aTW);
        }
        if (this.aTo != -1) {
            cVar.setProgressBarHeight(this.aTo);
        }
        if (this.aTX != -1) {
            cVar.setDescTopMargin(this.aTX);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aTT.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aTq != null) {
            for (c cVar : this.aTq) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aTX = i;
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
        if (this.mSkinType != i && this.aTq != null) {
            this.mSkinType = i;
            for (c cVar : this.aTq) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aTR != null) {
                for (c cVar2 : this.aTR) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
