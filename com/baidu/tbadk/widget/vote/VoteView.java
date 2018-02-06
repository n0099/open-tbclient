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
    private int bME;
    private int bMF;
    private List<c> bMG;
    private List<c> bNh;
    private final int bNi;
    private LinkedList<c> bNj;
    private int bNk;
    private boolean bNl;
    private int bNm;
    private int bNn;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bNi = 3;
        this.bNl = false;
        this.bME = -1;
        this.bNm = -1;
        this.bMF = -1;
        this.bNn = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bNi = 3;
        this.bNl = false;
        this.bME = -1;
        this.bNm = -1;
        this.bMF = -1;
        this.bNn = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.bMG = new ArrayList();
        this.bNj = new LinkedList<>();
        this.bNk = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.bME = i;
    }

    public void setDescTextColorResId(int i) {
        this.bMF = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.bNm = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.bNk = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            ja(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Sg();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.bMG.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.bNk - i;
            for (c cVar : this.bMG) {
                if (cVar != null) {
                    cVar.iZ(i2);
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
        if (!this.bNl) {
            Sf();
            this.bNl = true;
        }
        if (this.bNh != null && list != null && this.bNh.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.f(this.bNh, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) v.f(list, i);
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
                c cVar2 = (c) v.f(this.bNh, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.f(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.iZ(this.bNk - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Sf() {
        this.bNh = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Sg = Sg();
            this.bNh.add(Sg);
            addView(Sg.getView());
        }
    }

    private void ja(int i) {
        int size;
        this.bNj.addAll(this.bMG);
        this.bMG.clear();
        if (i > 0 && (size = this.bNj.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bNj.add(Sg());
            }
        }
    }

    private c Sg() {
        c cVar = this.bMF != -1 ? new c(getContext(), this.bMF) : new c(getContext());
        if (this.bNm != -1) {
            cVar.setProgressBarTopMargin(this.bNm);
        }
        if (this.bME != -1) {
            cVar.setProgressBarHeight(this.bME);
        }
        if (this.bNn != -1) {
            cVar.setDescTopMargin(this.bNn);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.bNj.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bMG != null) {
            for (c cVar : this.bMG) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.bNn = i;
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
        if (this.mSkinType != i && this.bMG != null) {
            this.mSkinType = i;
            for (c cVar : this.bMG) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.bNh != null) {
                for (c cVar2 : this.bNh) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
