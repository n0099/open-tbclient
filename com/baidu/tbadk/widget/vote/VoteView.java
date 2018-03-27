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
    private List<c> bMX;
    private final int bMY;
    private LinkedList<c> bMZ;
    private int bMu;
    private int bMv;
    private List<c> bMw;
    private int bNa;
    private boolean bNb;
    private int bNc;
    private int bNd;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bMY = 3;
        this.bNb = false;
        this.bMu = -1;
        this.bNc = -1;
        this.bMv = -1;
        this.bNd = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bMY = 3;
        this.bNb = false;
        this.bMu = -1;
        this.bNc = -1;
        this.bMv = -1;
        this.bNd = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.bMw = new ArrayList();
        this.bMZ = new LinkedList<>();
        this.bNa = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.bMu = i;
    }

    public void setDescTextColorResId(int i) {
        this.bMv = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.bNc = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.bNa = i;
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
                    this.bMw.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.bNa - i;
            for (c cVar : this.bMw) {
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
        if (!this.bNb) {
            Sf();
            this.bNb = true;
        }
        if (this.bMX != null && list != null && this.bMX.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.f(this.bMX, i);
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
                c cVar2 = (c) v.f(this.bMX, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.f(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.iZ(this.bNa - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Sf() {
        this.bMX = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Sg = Sg();
            this.bMX.add(Sg);
            addView(Sg.getView());
        }
    }

    private void ja(int i) {
        int size;
        this.bMZ.addAll(this.bMw);
        this.bMw.clear();
        if (i > 0 && (size = this.bMZ.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bMZ.add(Sg());
            }
        }
    }

    private c Sg() {
        c cVar = this.bMv != -1 ? new c(getContext(), this.bMv) : new c(getContext());
        if (this.bNc != -1) {
            cVar.setProgressBarTopMargin(this.bNc);
        }
        if (this.bMu != -1) {
            cVar.setProgressBarHeight(this.bMu);
        }
        if (this.bNd != -1) {
            cVar.setDescTopMargin(this.bNd);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.bMZ.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bMw != null) {
            for (c cVar : this.bMw) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.bNd = i;
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
        if (this.mSkinType != i && this.bMw != null) {
            this.mSkinType = i;
            for (c cVar : this.bMw) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.bMX != null) {
                for (c cVar2 : this.bMX) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
