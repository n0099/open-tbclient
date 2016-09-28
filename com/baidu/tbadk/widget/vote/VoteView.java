package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private int aJW;
    private int aJX;
    private List<c> aJY;
    private List<c> aKB;
    private final int aKC;
    private LinkedList<c> aKD;
    private int aKE;
    private boolean aKF;
    private int aKG;
    private int aKH;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aKC = 3;
        this.aKF = false;
        this.aJW = -1;
        this.aKG = -1;
        this.aJX = -1;
        this.aKH = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aKC = 3;
        this.aKF = false;
        this.aJW = -1;
        this.aKG = -1;
        this.aJX = -1;
        this.aKH = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aJY = new ArrayList();
        this.aKD = new LinkedList<>();
        this.aKE = getResources().getDimensionPixelSize(r.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aJW = i;
    }

    public void setDescTextColorResId(int i) {
        this.aJX = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aKG = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aKE = i;
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
                        voteItemView = IV();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aJY.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aKE - i;
            for (c cVar : this.aJY) {
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
        if (!this.aKF) {
            IU();
            this.aKF = true;
        }
        if (this.aKB != null && list != null && this.aKB.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.c(this.aKB, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) y.c(list, i);
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
                c cVar2 = (c) y.c(this.aKB, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fA(this.aKE - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void IU() {
        this.aKB = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c IV = IV();
            this.aKB.add(IV);
            addView(IV.getView());
        }
    }

    private void fB(int i) {
        int size;
        this.aKD.addAll(this.aJY);
        this.aJY.clear();
        if (i > 0 && (size = this.aKD.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aKD.add(IV());
            }
        }
    }

    private c IV() {
        c cVar;
        if (this.aJX != -1) {
            cVar = new c(getContext(), this.aJX);
        } else {
            cVar = new c(getContext());
        }
        if (this.aKG != -1) {
            cVar.setProgressBarTopMargin(this.aKG);
        }
        if (this.aJW != -1) {
            cVar.setProgressBarHeight(this.aJW);
        }
        if (this.aKH != -1) {
            cVar.setDescTopMargin(this.aKH);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aKD.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aJY != null) {
            for (c cVar : this.aJY) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aKH = i;
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
        if (this.mSkinType != i && this.aJY != null) {
            this.mSkinType = i;
            for (c cVar : this.aJY) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aKB != null) {
                for (c cVar2 : this.aKB) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
