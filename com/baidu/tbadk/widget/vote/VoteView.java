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
    private List<c> aWY;
    private final int aWZ;
    private int aWv;
    private int aWw;
    private List<c> aWx;
    private LinkedList<c> aXa;
    private int aXb;
    private boolean aXc;
    private int aXd;
    private int aXe;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aWZ = 3;
        this.aXc = false;
        this.aWv = -1;
        this.aXd = -1;
        this.aWw = -1;
        this.aXe = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aWZ = 3;
        this.aXc = false;
        this.aWv = -1;
        this.aXd = -1;
        this.aWw = -1;
        this.aXe = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aWx = new ArrayList();
        this.aXa = new LinkedList<>();
        this.aXb = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aWv = i;
    }

    public void setDescTextColorResId(int i) {
        this.aWw = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aXd = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aXb = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            gj(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Kn();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aWx.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aXb - i;
            for (c cVar : this.aWx) {
                if (cVar != null) {
                    cVar.gi(i2);
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
        if (!this.aXc) {
            Km();
            this.aXc = true;
        }
        if (this.aWY != null && list != null && this.aWY.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.c(this.aWY, i);
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
                c cVar2 = (c) v.c(this.aWY, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.gi(this.aXb - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Km() {
        this.aWY = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Kn = Kn();
            this.aWY.add(Kn);
            addView(Kn.getView());
        }
    }

    private void gj(int i) {
        int size;
        this.aXa.addAll(this.aWx);
        this.aWx.clear();
        if (i > 0 && (size = this.aXa.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aXa.add(Kn());
            }
        }
    }

    private c Kn() {
        c cVar = this.aWw != -1 ? new c(getContext(), this.aWw) : new c(getContext());
        if (this.aXd != -1) {
            cVar.setProgressBarTopMargin(this.aXd);
        }
        if (this.aWv != -1) {
            cVar.setProgressBarHeight(this.aWv);
        }
        if (this.aXe != -1) {
            cVar.setDescTopMargin(this.aXe);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aXa.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aWx != null) {
            for (c cVar : this.aWx) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aXe = i;
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
        if (this.mSkinType != i && this.aWx != null) {
            this.mSkinType = i;
            for (c cVar : this.aWx) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aWY != null) {
                for (c cVar2 : this.aWY) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
