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
    private List<c> bKV;
    private final int bKW;
    private LinkedList<c> bKX;
    private int bKY;
    private boolean bKZ;
    private int bKs;
    private int bKt;
    private List<c> bKu;
    private int bLa;
    private int bLb;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bKW = 3;
        this.bKZ = false;
        this.bKs = -1;
        this.bLa = -1;
        this.bKt = -1;
        this.bLb = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bKW = 3;
        this.bKZ = false;
        this.bKs = -1;
        this.bLa = -1;
        this.bKt = -1;
        this.bLb = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.bKu = new ArrayList();
        this.bKX = new LinkedList<>();
        this.bKY = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.bKs = i;
    }

    public void setDescTextColorResId(int i) {
        this.bKt = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.bLa = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.bKY = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            je(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = RA();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.bKu.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.bKY - i;
            for (c cVar : this.bKu) {
                if (cVar != null) {
                    cVar.jd(i2);
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
        if (!this.bKZ) {
            Rz();
            this.bKZ = true;
        }
        if (this.bKV != null && list != null && this.bKV.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.f(this.bKV, i);
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
                c cVar2 = (c) v.f(this.bKV, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.f(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.jd(this.bKY - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Rz() {
        this.bKV = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c RA = RA();
            this.bKV.add(RA);
            addView(RA.getView());
        }
    }

    private void je(int i) {
        int size;
        this.bKX.addAll(this.bKu);
        this.bKu.clear();
        if (i > 0 && (size = this.bKX.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bKX.add(RA());
            }
        }
    }

    private c RA() {
        c cVar = this.bKt != -1 ? new c(getContext(), this.bKt) : new c(getContext());
        if (this.bLa != -1) {
            cVar.setProgressBarTopMargin(this.bLa);
        }
        if (this.bKs != -1) {
            cVar.setProgressBarHeight(this.bKs);
        }
        if (this.bLb != -1) {
            cVar.setDescTopMargin(this.bLb);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.bKX.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bKu != null) {
            for (c cVar : this.bKu) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.bLb = i;
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
        if (this.mSkinType != i && this.bKu != null) {
            this.mSkinType = i;
            for (c cVar : this.bKu) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.bKV != null) {
                for (c cVar2 : this.bKV) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
