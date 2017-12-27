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
    private List<c> bKN;
    private final int bKO;
    private LinkedList<c> bKP;
    private int bKQ;
    private boolean bKR;
    private int bKS;
    private int bKT;
    private int bKk;
    private int bKl;
    private List<c> bKm;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bKO = 3;
        this.bKR = false;
        this.bKk = -1;
        this.bKS = -1;
        this.bKl = -1;
        this.bKT = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bKO = 3;
        this.bKR = false;
        this.bKk = -1;
        this.bKS = -1;
        this.bKl = -1;
        this.bKT = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.bKm = new ArrayList();
        this.bKP = new LinkedList<>();
        this.bKQ = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.bKk = i;
    }

    public void setDescTextColorResId(int i) {
        this.bKl = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.bKS = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.bKQ = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            ji(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = RM();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.bKm.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.bKQ - i;
            for (c cVar : this.bKm) {
                if (cVar != null) {
                    cVar.jh(i2);
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
        if (!this.bKR) {
            RL();
            this.bKR = true;
        }
        if (this.bKN != null && list != null && this.bKN.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.f(this.bKN, i);
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
                c cVar2 = (c) v.f(this.bKN, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.f(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.jh(this.bKQ - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void RL() {
        this.bKN = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c RM = RM();
            this.bKN.add(RM);
            addView(RM.getView());
        }
    }

    private void ji(int i) {
        int size;
        this.bKP.addAll(this.bKm);
        this.bKm.clear();
        if (i > 0 && (size = this.bKP.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bKP.add(RM());
            }
        }
    }

    private c RM() {
        c cVar = this.bKl != -1 ? new c(getContext(), this.bKl) : new c(getContext());
        if (this.bKS != -1) {
            cVar.setProgressBarTopMargin(this.bKS);
        }
        if (this.bKk != -1) {
            cVar.setProgressBarHeight(this.bKk);
        }
        if (this.bKT != -1) {
            cVar.setDescTopMargin(this.bKT);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.bKP.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bKm != null) {
            for (c cVar : this.bKm) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.bKT = i;
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
        if (this.mSkinType != i && this.bKm != null) {
            this.mSkinType = i;
            for (c cVar : this.bKm) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.bKN != null) {
                for (c cVar2 : this.bKN) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
