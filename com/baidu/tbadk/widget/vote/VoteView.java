package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private List<c> aHL;
    private final int aHM;
    private LinkedList<c> aHN;
    private int aHO;
    private boolean aHP;
    private int aHQ;
    private int aHR;
    private int aHh;
    private int aHi;
    private List<c> aHj;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aHM = 3;
        this.aHP = false;
        this.aHh = -1;
        this.aHQ = -1;
        this.aHi = -1;
        this.aHR = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aHM = 3;
        this.aHP = false;
        this.aHh = -1;
        this.aHQ = -1;
        this.aHi = -1;
        this.aHR = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aHj = new ArrayList();
        this.aHN = new LinkedList<>();
        this.aHO = getResources().getDimensionPixelSize(u.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aHh = i;
    }

    public void setDescTextColorResId(int i) {
        this.aHi = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aHQ = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aHO = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fm(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = HC();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aHj.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aHO - i;
            for (c cVar : this.aHj) {
                if (cVar != null) {
                    cVar.fl(i2);
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
        if (!this.aHP) {
            HB();
            this.aHP = true;
        }
        if (this.aHL != null && list != null && this.aHL.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.c(this.aHL, i);
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
                c cVar2 = (c) y.c(this.aHL, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fl(this.aHO - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void HB() {
        this.aHL = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c HC = HC();
            this.aHL.add(HC);
            addView(HC.getView());
        }
    }

    private void fm(int i) {
        int size;
        this.aHN.addAll(this.aHj);
        this.aHj.clear();
        if (i > 0 && (size = this.aHN.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aHN.add(HC());
            }
        }
    }

    private c HC() {
        c cVar;
        if (this.aHi != -1) {
            cVar = new c(getContext(), this.aHi);
        } else {
            cVar = new c(getContext());
        }
        if (this.aHQ != -1) {
            cVar.setProgressBarTopMargin(this.aHQ);
        }
        if (this.aHh != -1) {
            cVar.setProgressBarHeight(this.aHh);
        }
        if (this.aHR != -1) {
            cVar.setDescTopMargin(this.aHR);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aHN.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aHj != null) {
            for (c cVar : this.aHj) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aHR = i;
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
        if (this.mSkinType != i && this.aHj != null) {
            this.mSkinType = i;
            for (c cVar : this.aHj) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aHL != null) {
                for (c cVar2 : this.aHL) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
