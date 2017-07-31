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
    private int aSH;
    private int aSI;
    private List<c> aSJ;
    private List<c> aTj;
    private final int aTk;
    private LinkedList<c> aTl;
    private int aTm;
    private boolean aTn;
    private int aTo;
    private int aTp;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aTk = 3;
        this.aTn = false;
        this.aSH = -1;
        this.aTo = -1;
        this.aSI = -1;
        this.aTp = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aTk = 3;
        this.aTn = false;
        this.aSH = -1;
        this.aTo = -1;
        this.aSI = -1;
        this.aTp = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aSJ = new ArrayList();
        this.aTl = new LinkedList<>();
        this.aTm = getResources().getDimensionPixelSize(d.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aSH = i;
    }

    public void setDescTextColorResId(int i) {
        this.aSI = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aTo = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aTm = i;
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
                    this.aSJ.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aTm - i;
            for (c cVar : this.aSJ) {
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
        if (!this.aTn) {
            Ji();
            this.aTn = true;
        }
        if (this.aTj != null && list != null && this.aTj.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) u.c(this.aTj, i);
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
                c cVar2 = (c) u.c(this.aTj, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) u.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fF(this.aTm - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Ji() {
        this.aTj = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Jj = Jj();
            this.aTj.add(Jj);
            addView(Jj.getView());
        }
    }

    private void fG(int i) {
        int size;
        this.aTl.addAll(this.aSJ);
        this.aSJ.clear();
        if (i > 0 && (size = this.aTl.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aTl.add(Jj());
            }
        }
    }

    private c Jj() {
        c cVar = this.aSI != -1 ? new c(getContext(), this.aSI) : new c(getContext());
        if (this.aTo != -1) {
            cVar.setProgressBarTopMargin(this.aTo);
        }
        if (this.aSH != -1) {
            cVar.setProgressBarHeight(this.aSH);
        }
        if (this.aTp != -1) {
            cVar.setDescTopMargin(this.aTp);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aTl.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aSJ != null) {
            for (c cVar : this.aSJ) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aTp = i;
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
        if (this.mSkinType != i && this.aSJ != null) {
            this.mSkinType = i;
            for (c cVar : this.aSJ) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aTj != null) {
                for (c cVar2 : this.aTj) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
