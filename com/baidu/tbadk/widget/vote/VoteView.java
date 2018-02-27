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
    private List<c> bMU;
    private final int bMV;
    private LinkedList<c> bMW;
    private int bMX;
    private boolean bMY;
    private int bMZ;
    private int bMr;
    private int bMs;
    private List<c> bMt;
    private int bNa;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bMV = 3;
        this.bMY = false;
        this.bMr = -1;
        this.bMZ = -1;
        this.bMs = -1;
        this.bNa = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bMV = 3;
        this.bMY = false;
        this.bMr = -1;
        this.bMZ = -1;
        this.bMs = -1;
        this.bNa = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.bMt = new ArrayList();
        this.bMW = new LinkedList<>();
        this.bMX = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.bMr = i;
    }

    public void setDescTextColorResId(int i) {
        this.bMs = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.bMZ = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.bMX = i;
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
                        voteItemView = Sf();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.bMt.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.bMX - i;
            for (c cVar : this.bMt) {
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
        if (!this.bMY) {
            Se();
            this.bMY = true;
        }
        if (this.bMU != null && list != null && this.bMU.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.f(this.bMU, i);
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
                c cVar2 = (c) v.f(this.bMU, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.f(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.iZ(this.bMX - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Se() {
        this.bMU = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Sf = Sf();
            this.bMU.add(Sf);
            addView(Sf.getView());
        }
    }

    private void ja(int i) {
        int size;
        this.bMW.addAll(this.bMt);
        this.bMt.clear();
        if (i > 0 && (size = this.bMW.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bMW.add(Sf());
            }
        }
    }

    private c Sf() {
        c cVar = this.bMs != -1 ? new c(getContext(), this.bMs) : new c(getContext());
        if (this.bMZ != -1) {
            cVar.setProgressBarTopMargin(this.bMZ);
        }
        if (this.bMr != -1) {
            cVar.setProgressBarHeight(this.bMr);
        }
        if (this.bNa != -1) {
            cVar.setDescTopMargin(this.bNa);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.bMW.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bMt != null) {
            for (c cVar : this.bMt) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.bNa = i;
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
        if (this.mSkinType != i && this.bMt != null) {
            this.mSkinType = i;
            for (c cVar : this.bMt) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.bMU != null) {
                for (c cVar2 : this.bMU) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
