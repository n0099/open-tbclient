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
    private List<c> aTJ;
    private final int aTK;
    private LinkedList<c> aTL;
    private int aTM;
    private boolean aTN;
    private int aTO;
    private int aTP;
    private int aTg;
    private int aTh;
    private List<c> aTi;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aTK = 3;
        this.aTN = false;
        this.aTg = -1;
        this.aTO = -1;
        this.aTh = -1;
        this.aTP = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aTK = 3;
        this.aTN = false;
        this.aTg = -1;
        this.aTO = -1;
        this.aTh = -1;
        this.aTP = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aTi = new ArrayList();
        this.aTL = new LinkedList<>();
        this.aTM = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aTg = i;
    }

    public void setDescTextColorResId(int i) {
        this.aTh = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aTO = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aTM = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            gc(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = JE();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aTi.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aTM - i;
            for (c cVar : this.aTi) {
                if (cVar != null) {
                    cVar.gb(i2);
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
        if (!this.aTN) {
            JD();
            this.aTN = true;
        }
        if (this.aTJ != null && list != null && this.aTJ.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.c(this.aTJ, i);
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
                c cVar2 = (c) v.c(this.aTJ, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.gb(this.aTM - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void JD() {
        this.aTJ = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c JE = JE();
            this.aTJ.add(JE);
            addView(JE.getView());
        }
    }

    private void gc(int i) {
        int size;
        this.aTL.addAll(this.aTi);
        this.aTi.clear();
        if (i > 0 && (size = this.aTL.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aTL.add(JE());
            }
        }
    }

    private c JE() {
        c cVar = this.aTh != -1 ? new c(getContext(), this.aTh) : new c(getContext());
        if (this.aTO != -1) {
            cVar.setProgressBarTopMargin(this.aTO);
        }
        if (this.aTg != -1) {
            cVar.setProgressBarHeight(this.aTg);
        }
        if (this.aTP != -1) {
            cVar.setDescTopMargin(this.aTP);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aTL.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aTi != null) {
            for (c cVar : this.aTi) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aTP = i;
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
        if (this.mSkinType != i && this.aTi != null) {
            this.mSkinType = i;
            for (c cVar : this.aTi) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aTJ != null) {
                for (c cVar2 : this.aTJ) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
