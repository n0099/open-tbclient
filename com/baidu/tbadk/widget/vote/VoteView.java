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
    private List<c> aWU;
    private final int aWV;
    private LinkedList<c> aWW;
    private int aWX;
    private boolean aWY;
    private int aWZ;
    private int aWr;
    private int aWs;
    private List<c> aWt;
    private int aXa;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aWV = 3;
        this.aWY = false;
        this.aWr = -1;
        this.aWZ = -1;
        this.aWs = -1;
        this.aXa = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aWV = 3;
        this.aWY = false;
        this.aWr = -1;
        this.aWZ = -1;
        this.aWs = -1;
        this.aXa = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aWt = new ArrayList();
        this.aWW = new LinkedList<>();
        this.aWX = getResources().getDimensionPixelSize(d.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aWr = i;
    }

    public void setDescTextColorResId(int i) {
        this.aWs = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aWZ = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aWX = i;
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
                    this.aWt.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aWX - i;
            for (c cVar : this.aWt) {
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
        if (!this.aWY) {
            Km();
            this.aWY = true;
        }
        if (this.aWU != null && list != null && this.aWU.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) v.c(this.aWU, i);
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
                c cVar2 = (c) v.c(this.aWU, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) v.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.gi(this.aWX - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Km() {
        this.aWU = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Kn = Kn();
            this.aWU.add(Kn);
            addView(Kn.getView());
        }
    }

    private void gj(int i) {
        int size;
        this.aWW.addAll(this.aWt);
        this.aWt.clear();
        if (i > 0 && (size = this.aWW.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aWW.add(Kn());
            }
        }
    }

    private c Kn() {
        c cVar = this.aWs != -1 ? new c(getContext(), this.aWs) : new c(getContext());
        if (this.aWZ != -1) {
            cVar.setProgressBarTopMargin(this.aWZ);
        }
        if (this.aWr != -1) {
            cVar.setProgressBarHeight(this.aWr);
        }
        if (this.aXa != -1) {
            cVar.setDescTopMargin(this.aXa);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aWW.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aWt != null) {
            for (c cVar : this.aWt) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aXa = i;
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
        if (this.mSkinType != i && this.aWt != null) {
            this.mSkinType = i;
            for (c cVar : this.aWt) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aWU != null) {
                for (c cVar2 : this.aWU) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
