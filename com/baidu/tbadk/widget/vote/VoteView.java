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
    private List<c> aRX;
    private final int aRY;
    private LinkedList<c> aRZ;
    private int aRv;
    private int aRw;
    private List<c> aRx;
    private int aSa;
    private boolean aSb;
    private int aSc;
    private int aSd;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aRY = 3;
        this.aSb = false;
        this.aRv = -1;
        this.aSc = -1;
        this.aRw = -1;
        this.aSd = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aRY = 3;
        this.aSb = false;
        this.aRv = -1;
        this.aSc = -1;
        this.aRw = -1;
        this.aSd = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aRx = new ArrayList();
        this.aRZ = new LinkedList<>();
        this.aSa = getResources().getDimensionPixelSize(d.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aRv = i;
    }

    public void setDescTextColorResId(int i) {
        this.aRw = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aSc = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aSa = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fE(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Jc();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aRx.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aSa - i;
            for (c cVar : this.aRx) {
                if (cVar != null) {
                    cVar.fD(i2);
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
        if (!this.aSb) {
            Jb();
            this.aSb = true;
        }
        if (this.aRX != null && list != null && this.aRX.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) u.c(this.aRX, i);
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
                c cVar2 = (c) u.c(this.aRX, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) u.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fD(this.aSa - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Jb() {
        this.aRX = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Jc = Jc();
            this.aRX.add(Jc);
            addView(Jc.getView());
        }
    }

    private void fE(int i) {
        int size;
        this.aRZ.addAll(this.aRx);
        this.aRx.clear();
        if (i > 0 && (size = this.aRZ.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aRZ.add(Jc());
            }
        }
    }

    private c Jc() {
        c cVar = this.aRw != -1 ? new c(getContext(), this.aRw) : new c(getContext());
        if (this.aSc != -1) {
            cVar.setProgressBarTopMargin(this.aSc);
        }
        if (this.aRv != -1) {
            cVar.setProgressBarHeight(this.aRv);
        }
        if (this.aSd != -1) {
            cVar.setDescTopMargin(this.aSd);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aRZ.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aRx != null) {
            for (c cVar : this.aRx) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aSd = i;
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
        if (this.mSkinType != i && this.aRx != null) {
            this.mSkinType = i;
            for (c cVar : this.aRx) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aRX != null) {
                for (c cVar2 : this.aRX) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
