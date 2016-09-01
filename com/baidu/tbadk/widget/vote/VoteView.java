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
    private int aKx;
    private int aKy;
    private List<c> aKz;
    private List<c> aLc;
    private final int aLd;
    private LinkedList<c> aLe;
    private int aLf;
    private boolean aLg;
    private int aLh;
    private int aLi;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aLd = 3;
        this.aLg = false;
        this.aKx = -1;
        this.aLh = -1;
        this.aKy = -1;
        this.aLi = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aLd = 3;
        this.aLg = false;
        this.aKx = -1;
        this.aLh = -1;
        this.aKy = -1;
        this.aLi = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aKz = new ArrayList();
        this.aLe = new LinkedList<>();
        this.aLf = getResources().getDimensionPixelSize(t.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aKx = i;
    }

    public void setDescTextColorResId(int i) {
        this.aKy = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aLh = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aLf = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fC(list.size());
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
                    this.aKz.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aLf - i;
            for (c cVar : this.aKz) {
                if (cVar != null) {
                    cVar.fB(i2);
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
        if (!this.aLg) {
            IU();
            this.aLg = true;
        }
        if (this.aLc != null && list != null && this.aLc.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.c(this.aLc, i);
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
                c cVar2 = (c) y.c(this.aLc, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fB(this.aLf - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void IU() {
        this.aLc = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c IV = IV();
            this.aLc.add(IV);
            addView(IV.getView());
        }
    }

    private void fC(int i) {
        int size;
        this.aLe.addAll(this.aKz);
        this.aKz.clear();
        if (i > 0 && (size = this.aLe.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aLe.add(IV());
            }
        }
    }

    private c IV() {
        c cVar;
        if (this.aKy != -1) {
            cVar = new c(getContext(), this.aKy);
        } else {
            cVar = new c(getContext());
        }
        if (this.aLh != -1) {
            cVar.setProgressBarTopMargin(this.aLh);
        }
        if (this.aKx != -1) {
            cVar.setProgressBarHeight(this.aKx);
        }
        if (this.aLi != -1) {
            cVar.setDescTopMargin(this.aLi);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aLe.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aKz != null) {
            for (c cVar : this.aKz) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aLi = i;
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
        if (this.mSkinType != i && this.aKz != null) {
            this.mSkinType = i;
            for (c cVar : this.aKz) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aLc != null) {
                for (c cVar2 : this.aLc) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
