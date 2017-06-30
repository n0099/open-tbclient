package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private List<c> aQO;
    private final int aQP;
    private LinkedList<c> aQQ;
    private int aQR;
    private boolean aQS;
    private int aQT;
    private int aQU;
    private int aQm;
    private int aQn;
    private List<c> aQo;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aQP = 3;
        this.aQS = false;
        this.aQm = -1;
        this.aQT = -1;
        this.aQn = -1;
        this.aQU = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aQP = 3;
        this.aQS = false;
        this.aQm = -1;
        this.aQT = -1;
        this.aQn = -1;
        this.aQU = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aQo = new ArrayList();
        this.aQQ = new LinkedList<>();
        this.aQR = getResources().getDimensionPixelSize(w.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aQm = i;
    }

    public void setDescTextColorResId(int i) {
        this.aQn = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aQT = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aQR = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fB(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = IQ();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aQo.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aQR - i;
            for (c cVar : this.aQo) {
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
        if (!this.aQS) {
            IP();
            this.aQS = true;
        }
        if (this.aQO != null && list != null && this.aQO.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) z.c(this.aQO, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) z.c(list, i);
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
                c cVar2 = (c) z.c(this.aQO, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) z.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fA(this.aQR - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void IP() {
        this.aQO = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c IQ = IQ();
            this.aQO.add(IQ);
            addView(IQ.getView());
        }
    }

    private void fB(int i) {
        int size;
        this.aQQ.addAll(this.aQo);
        this.aQo.clear();
        if (i > 0 && (size = this.aQQ.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aQQ.add(IQ());
            }
        }
    }

    private c IQ() {
        c cVar;
        if (this.aQn != -1) {
            cVar = new c(getContext(), this.aQn);
        } else {
            cVar = new c(getContext());
        }
        if (this.aQT != -1) {
            cVar.setProgressBarTopMargin(this.aQT);
        }
        if (this.aQm != -1) {
            cVar.setProgressBarHeight(this.aQm);
        }
        if (this.aQU != -1) {
            cVar.setDescTopMargin(this.aQU);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aQQ.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aQo != null) {
            for (c cVar : this.aQo) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aQU = i;
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
        if (this.mSkinType != i && this.aQo != null) {
            this.mSkinType = i;
            for (c cVar : this.aQo) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aQO != null) {
                for (c cVar2 : this.aQO) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
