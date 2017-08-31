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
    private List<c> aSV;
    private final int aSW;
    private LinkedList<c> aSX;
    private int aSY;
    private boolean aSZ;
    private int aSt;
    private int aSu;
    private List<c> aSv;
    private int aTa;
    private int aTb;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aSW = 3;
        this.aSZ = false;
        this.aSt = -1;
        this.aTa = -1;
        this.aSu = -1;
        this.aTb = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aSW = 3;
        this.aSZ = false;
        this.aSt = -1;
        this.aTa = -1;
        this.aSu = -1;
        this.aTb = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aSv = new ArrayList();
        this.aSX = new LinkedList<>();
        this.aSY = getResources().getDimensionPixelSize(d.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aSt = i;
    }

    public void setDescTextColorResId(int i) {
        this.aSu = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aTa = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aSY = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fH(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Jr();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aSv.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aSY - i;
            for (c cVar : this.aSv) {
                if (cVar != null) {
                    cVar.fG(i2);
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
        if (!this.aSZ) {
            Jq();
            this.aSZ = true;
        }
        if (this.aSV != null && list != null && this.aSV.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.c(this.aSV, i);
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
                c cVar2 = (c) v.c(this.aSV, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fG(this.aSY - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Jq() {
        this.aSV = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Jr = Jr();
            this.aSV.add(Jr);
            addView(Jr.getView());
        }
    }

    private void fH(int i) {
        int size;
        this.aSX.addAll(this.aSv);
        this.aSv.clear();
        if (i > 0 && (size = this.aSX.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aSX.add(Jr());
            }
        }
    }

    private c Jr() {
        c cVar = this.aSu != -1 ? new c(getContext(), this.aSu) : new c(getContext());
        if (this.aTa != -1) {
            cVar.setProgressBarTopMargin(this.aTa);
        }
        if (this.aSt != -1) {
            cVar.setProgressBarHeight(this.aSt);
        }
        if (this.aTb != -1) {
            cVar.setDescTopMargin(this.aTb);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aSX.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aSv != null) {
            for (c cVar : this.aSv) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aTb = i;
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
        if (this.mSkinType != i && this.aSv != null) {
            this.mSkinType = i;
            for (c cVar : this.aSv) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aSV != null) {
                for (c cVar2 : this.aSV) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
