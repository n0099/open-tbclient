package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private int aOA;
    private int aOB;
    private List<c> aOC;
    private List<c> aPc;
    private final int aPd;
    private LinkedList<c> aPe;
    private int aPf;
    private boolean aPg;
    private int aPh;
    private int aPi;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aPd = 3;
        this.aPg = false;
        this.aOA = -1;
        this.aPh = -1;
        this.aOB = -1;
        this.aPi = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aPd = 3;
        this.aPg = false;
        this.aOA = -1;
        this.aPh = -1;
        this.aOB = -1;
        this.aPi = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aOC = new ArrayList();
        this.aPe = new LinkedList<>();
        this.aPf = getResources().getDimensionPixelSize(w.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aOA = i;
    }

    public void setDescTextColorResId(int i) {
        this.aOB = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aPh = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aPf = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fB(list.size());
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
                    this.aOC.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aPf - i;
            for (c cVar : this.aOC) {
                if (cVar != null) {
                    cVar.fA(i2);
                    addView(cVar.getView());
                }
            }
            if (z) {
                a aVar2 = new a(this, null);
                aVar2.setDuration(300L);
                startAnimation(aVar2);
                return;
            }
            setProgress(1.0f);
        }
    }

    public void setBoallotsForListView(List<com.baidu.tbadk.widget.vote.a> list) {
        int a2;
        if (!this.aPg) {
            Ji();
            this.aPg = true;
        }
        if (this.aPc != null && list != null && this.aPc.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) x.c(this.aPc, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) x.c(list, i);
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
                c cVar2 = (c) x.c(this.aPc, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) x.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fA(this.aPf - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Ji() {
        this.aPc = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Jj = Jj();
            this.aPc.add(Jj);
            addView(Jj.getView());
        }
    }

    private void fB(int i) {
        int size;
        this.aPe.addAll(this.aOC);
        this.aOC.clear();
        if (i > 0 && (size = this.aPe.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aPe.add(Jj());
            }
        }
    }

    private c Jj() {
        c cVar;
        if (this.aOB != -1) {
            cVar = new c(getContext(), this.aOB);
        } else {
            cVar = new c(getContext());
        }
        if (this.aPh != -1) {
            cVar.setProgressBarTopMargin(this.aPh);
        }
        if (this.aOA != -1) {
            cVar.setProgressBarHeight(this.aOA);
        }
        if (this.aPi != -1) {
            cVar.setDescTopMargin(this.aPi);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aPe.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aOC != null) {
            for (c cVar : this.aOC) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aPi = i;
    }

    /* loaded from: classes.dex */
    private class a extends Animation {
        private a() {
        }

        /* synthetic */ a(VoteView voteView, a aVar) {
            this();
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            VoteView.this.setProgress(f);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i && this.aOC != null) {
            this.mSkinType = i;
            for (c cVar : this.aOC) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aPc != null) {
                for (c cVar2 : this.aPc) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
