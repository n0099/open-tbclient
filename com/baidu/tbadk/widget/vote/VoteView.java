package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private int aFO;
    private int aFP;
    private List<c> aFQ;
    private List<c> aGs;
    private final int aGt;
    private LinkedList<c> aGu;
    private int aGv;
    private boolean aGw;
    private int aGx;
    private int aGy;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aGt = 3;
        this.aGw = false;
        this.aFO = -1;
        this.aGx = -1;
        this.aFP = -1;
        this.aGy = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aGt = 3;
        this.aGw = false;
        this.aFO = -1;
        this.aGx = -1;
        this.aFP = -1;
        this.aGy = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aFQ = new ArrayList();
        this.aGu = new LinkedList<>();
        this.aGv = getResources().getDimensionPixelSize(t.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aFO = i;
    }

    public void setDescTextColorResId(int i) {
        this.aFP = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aGx = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aGv = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fi(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = HB();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aFQ.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aGv - i;
            for (c cVar : this.aFQ) {
                if (cVar != null) {
                    cVar.fh(i2);
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
        if (!this.aGw) {
            HA();
            this.aGw = true;
        }
        if (this.aGs != null && list != null && this.aGs.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.c(this.aGs, i);
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
                c cVar2 = (c) y.c(this.aGs, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fh(this.aGv - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void HA() {
        this.aGs = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c HB = HB();
            this.aGs.add(HB);
            addView(HB.getView());
        }
    }

    private void fi(int i) {
        int size;
        this.aGu.addAll(this.aFQ);
        this.aFQ.clear();
        if (i > 0 && (size = this.aGu.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aGu.add(HB());
            }
        }
    }

    private c HB() {
        c cVar;
        if (this.aFP != -1) {
            cVar = new c(getContext(), this.aFP);
        } else {
            cVar = new c(getContext());
        }
        if (this.aGx != -1) {
            cVar.setProgressBarTopMargin(this.aGx);
        }
        if (this.aFO != -1) {
            cVar.setProgressBarHeight(this.aFO);
        }
        if (this.aGy != -1) {
            cVar.setDescTopMargin(this.aGy);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aGu.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aFQ != null) {
            for (c cVar : this.aFQ) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aGy = i;
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
        if (this.mSkinType != i && this.aFQ != null) {
            this.mSkinType = i;
            for (c cVar : this.aFQ) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aGs != null) {
                for (c cVar2 : this.aGs) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
