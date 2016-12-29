package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private List<c> aKJ;
    private final int aKK;
    private LinkedList<c> aKL;
    private int aKM;
    private boolean aKN;
    private int aKO;
    private int aKP;
    private int aKg;
    private int aKh;
    private List<c> aKi;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aKK = 3;
        this.aKN = false;
        this.aKg = -1;
        this.aKO = -1;
        this.aKh = -1;
        this.aKP = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aKK = 3;
        this.aKN = false;
        this.aKg = -1;
        this.aKO = -1;
        this.aKh = -1;
        this.aKP = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aKi = new ArrayList();
        this.aKL = new LinkedList<>();
        this.aKM = getResources().getDimensionPixelSize(r.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aKg = i;
    }

    public void setDescTextColorResId(int i) {
        this.aKh = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aKO = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aKM = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fD(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = It();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aKi.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aKM - i;
            for (c cVar : this.aKi) {
                if (cVar != null) {
                    cVar.fC(i2);
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
        if (!this.aKN) {
            Is();
            this.aKN = true;
        }
        if (this.aKJ != null && list != null && this.aKJ.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) x.c(this.aKJ, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) x.c(list, i);
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
                c cVar2 = (c) x.c(this.aKJ, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) x.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fC(this.aKM - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Is() {
        this.aKJ = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c It = It();
            this.aKJ.add(It);
            addView(It.getView());
        }
    }

    private void fD(int i) {
        int size;
        this.aKL.addAll(this.aKi);
        this.aKi.clear();
        if (i > 0 && (size = this.aKL.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aKL.add(It());
            }
        }
    }

    private c It() {
        c cVar;
        if (this.aKh != -1) {
            cVar = new c(getContext(), this.aKh);
        } else {
            cVar = new c(getContext());
        }
        if (this.aKO != -1) {
            cVar.setProgressBarTopMargin(this.aKO);
        }
        if (this.aKg != -1) {
            cVar.setProgressBarHeight(this.aKg);
        }
        if (this.aKP != -1) {
            cVar.setDescTopMargin(this.aKP);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aKL.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aKi != null) {
            for (c cVar : this.aKi) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aKP = i;
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
        if (this.mSkinType != i && this.aKi != null) {
            this.mSkinType = i;
            for (c cVar : this.aKi) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aKJ != null) {
                for (c cVar2 : this.aKJ) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
