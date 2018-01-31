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
    private int bKA;
    private int bKB;
    private List<c> bKC;
    private List<c> bLd;
    private final int bLe;
    private LinkedList<c> bLf;
    private int bLg;
    private boolean bLh;
    private int bLi;
    private int bLj;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bLe = 3;
        this.bLh = false;
        this.bKA = -1;
        this.bLi = -1;
        this.bKB = -1;
        this.bLj = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bLe = 3;
        this.bLh = false;
        this.bKA = -1;
        this.bLi = -1;
        this.bKB = -1;
        this.bLj = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.bKC = new ArrayList();
        this.bLf = new LinkedList<>();
        this.bLg = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.bKA = i;
    }

    public void setDescTextColorResId(int i) {
        this.bKB = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.bLi = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.bLg = i;
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
                        voteItemView = RC();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.bKC.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.bLg - i;
            for (c cVar : this.bKC) {
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
        if (!this.bLh) {
            RB();
            this.bLh = true;
        }
        if (this.bLd != null && list != null && this.bLd.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.f(this.bLd, i);
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
                c cVar2 = (c) v.f(this.bLd, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.f(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.jd(this.bLg - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void RB() {
        this.bLd = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c RC = RC();
            this.bLd.add(RC);
            addView(RC.getView());
        }
    }

    private void je(int i) {
        int size;
        this.bLf.addAll(this.bKC);
        this.bKC.clear();
        if (i > 0 && (size = this.bLf.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bLf.add(RC());
            }
        }
    }

    private c RC() {
        c cVar = this.bKB != -1 ? new c(getContext(), this.bKB) : new c(getContext());
        if (this.bLi != -1) {
            cVar.setProgressBarTopMargin(this.bLi);
        }
        if (this.bKA != -1) {
            cVar.setProgressBarHeight(this.bKA);
        }
        if (this.bLj != -1) {
            cVar.setDescTopMargin(this.bLj);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.bLf.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bKC != null) {
            for (c cVar : this.bKC) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.bLj = i;
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
        if (this.mSkinType != i && this.bKC != null) {
            this.mSkinType = i;
            for (c cVar : this.bKC) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.bLd != null) {
                for (c cVar2 : this.bLd) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
