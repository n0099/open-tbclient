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
    private List<c> aTE;
    private final int aTF;
    private LinkedList<c> aTG;
    private int aTH;
    private boolean aTI;
    private int aTJ;
    private int aTK;
    private int aTc;
    private int aTd;
    private List<c> aTe;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aTF = 3;
        this.aTI = false;
        this.aTc = -1;
        this.aTJ = -1;
        this.aTd = -1;
        this.aTK = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aTF = 3;
        this.aTI = false;
        this.aTc = -1;
        this.aTJ = -1;
        this.aTd = -1;
        this.aTK = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aTe = new ArrayList();
        this.aTG = new LinkedList<>();
        this.aTH = getResources().getDimensionPixelSize(d.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aTc = i;
    }

    public void setDescTextColorResId(int i) {
        this.aTd = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aTJ = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aTH = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fT(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Ju();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aTe.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aTH - i;
            for (c cVar : this.aTe) {
                if (cVar != null) {
                    cVar.fS(i2);
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
        if (!this.aTI) {
            Jt();
            this.aTI = true;
        }
        if (this.aTE != null && list != null && this.aTE.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.c(this.aTE, i);
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
                c cVar2 = (c) v.c(this.aTE, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fS(this.aTH - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Jt() {
        this.aTE = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Ju = Ju();
            this.aTE.add(Ju);
            addView(Ju.getView());
        }
    }

    private void fT(int i) {
        int size;
        this.aTG.addAll(this.aTe);
        this.aTe.clear();
        if (i > 0 && (size = this.aTG.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aTG.add(Ju());
            }
        }
    }

    private c Ju() {
        c cVar = this.aTd != -1 ? new c(getContext(), this.aTd) : new c(getContext());
        if (this.aTJ != -1) {
            cVar.setProgressBarTopMargin(this.aTJ);
        }
        if (this.aTc != -1) {
            cVar.setProgressBarHeight(this.aTc);
        }
        if (this.aTK != -1) {
            cVar.setDescTopMargin(this.aTK);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aTG.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aTe != null) {
            for (c cVar : this.aTe) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aTK = i;
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
        if (this.mSkinType != i && this.aTe != null) {
            this.mSkinType = i;
            for (c cVar : this.aTe) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aTE != null) {
                for (c cVar2 : this.aTE) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
