package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private int aOV;
    private int aOW;
    private List<c> aOX;
    private int aPA;
    private boolean aPB;
    private int aPC;
    private int aPD;
    private List<c> aPx;
    private final int aPy;
    private LinkedList<c> aPz;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aPy = 3;
        this.aPB = false;
        this.aOV = -1;
        this.aPC = -1;
        this.aOW = -1;
        this.aPD = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aPy = 3;
        this.aPB = false;
        this.aOV = -1;
        this.aPC = -1;
        this.aOW = -1;
        this.aPD = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aOX = new ArrayList();
        this.aPz = new LinkedList<>();
        this.aPA = getResources().getDimensionPixelSize(w.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aOV = i;
    }

    public void setDescTextColorResId(int i) {
        this.aOW = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aPC = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aPA = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fy(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Ix();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aOX.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aPA - i;
            for (c cVar : this.aOX) {
                if (cVar != null) {
                    cVar.fx(i2);
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
        if (!this.aPB) {
            Iw();
            this.aPB = true;
        }
        if (this.aPx != null && list != null && this.aPx.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) x.c(this.aPx, i);
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
                c cVar2 = (c) x.c(this.aPx, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) x.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fx(this.aPA - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Iw() {
        this.aPx = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Ix = Ix();
            this.aPx.add(Ix);
            addView(Ix.getView());
        }
    }

    private void fy(int i) {
        int size;
        this.aPz.addAll(this.aOX);
        this.aOX.clear();
        if (i > 0 && (size = this.aPz.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aPz.add(Ix());
            }
        }
    }

    private c Ix() {
        c cVar;
        if (this.aOW != -1) {
            cVar = new c(getContext(), this.aOW);
        } else {
            cVar = new c(getContext());
        }
        if (this.aPC != -1) {
            cVar.setProgressBarTopMargin(this.aPC);
        }
        if (this.aOV != -1) {
            cVar.setProgressBarHeight(this.aOV);
        }
        if (this.aPD != -1) {
            cVar.setDescTopMargin(this.aPD);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aPz.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aOX != null) {
            for (c cVar : this.aOX) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aPD = i;
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
        if (this.mSkinType != i && this.aOX != null) {
            this.mSkinType = i;
            for (c cVar : this.aOX) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aPx != null) {
                for (c cVar2 : this.aPx) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
