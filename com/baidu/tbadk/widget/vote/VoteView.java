package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private int aSJ;
    private int aSK;
    private List<c> aSL;
    private List<c> aTl;
    private final int aTm;
    private LinkedList<c> aTn;
    private int aTo;
    private boolean aTp;
    private int aTq;
    private int aTr;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aTm = 3;
        this.aTp = false;
        this.aSJ = -1;
        this.aTq = -1;
        this.aSK = -1;
        this.aTr = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aTm = 3;
        this.aTp = false;
        this.aSJ = -1;
        this.aTq = -1;
        this.aSK = -1;
        this.aTr = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aSL = new ArrayList();
        this.aTn = new LinkedList<>();
        this.aTo = getResources().getDimensionPixelSize(d.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aSJ = i;
    }

    public void setDescTextColorResId(int i) {
        this.aSK = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aTq = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aTo = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fG(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Jj();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aSL.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aTo - i;
            for (c cVar : this.aSL) {
                if (cVar != null) {
                    cVar.fF(i2);
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
        if (!this.aTp) {
            Ji();
            this.aTp = true;
        }
        if (this.aTl != null && list != null && this.aTl.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) u.c(this.aTl, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) u.c(list, i);
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
                c cVar2 = (c) u.c(this.aTl, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) u.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fF(this.aTo - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Ji() {
        this.aTl = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Jj = Jj();
            this.aTl.add(Jj);
            addView(Jj.getView());
        }
    }

    private void fG(int i) {
        int size;
        this.aTn.addAll(this.aSL);
        this.aSL.clear();
        if (i > 0 && (size = this.aTn.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aTn.add(Jj());
            }
        }
    }

    private c Jj() {
        c cVar = this.aSK != -1 ? new c(getContext(), this.aSK) : new c(getContext());
        if (this.aTq != -1) {
            cVar.setProgressBarTopMargin(this.aTq);
        }
        if (this.aSJ != -1) {
            cVar.setProgressBarHeight(this.aSJ);
        }
        if (this.aTr != -1) {
            cVar.setDescTopMargin(this.aTr);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aTn.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aSL != null) {
            for (c cVar : this.aSL) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aTr = i;
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
        if (this.mSkinType != i && this.aSL != null) {
            this.mSkinType = i;
            for (c cVar : this.aSL) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aTl != null) {
                for (c cVar2 : this.aTl) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
