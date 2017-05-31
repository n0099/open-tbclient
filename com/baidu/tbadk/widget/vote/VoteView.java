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
    private int aOU;
    private int aOV;
    private List<c> aOW;
    private boolean aPA;
    private int aPB;
    private int aPC;
    private List<c> aPw;
    private final int aPx;
    private LinkedList<c> aPy;
    private int aPz;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aPx = 3;
        this.aPA = false;
        this.aOU = -1;
        this.aPB = -1;
        this.aOV = -1;
        this.aPC = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aPx = 3;
        this.aPA = false;
        this.aOU = -1;
        this.aPB = -1;
        this.aOV = -1;
        this.aPC = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aOW = new ArrayList();
        this.aPy = new LinkedList<>();
        this.aPz = getResources().getDimensionPixelSize(w.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aOU = i;
    }

    public void setDescTextColorResId(int i) {
        this.aOV = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aPB = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aPz = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fz(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Is();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aOW.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aPz - i;
            for (c cVar : this.aOW) {
                if (cVar != null) {
                    cVar.fy(i2);
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
        if (!this.aPA) {
            Ir();
            this.aPA = true;
        }
        if (this.aPw != null && list != null && this.aPw.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) x.c(this.aPw, i);
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
                c cVar2 = (c) x.c(this.aPw, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) x.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fy(this.aPz - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Ir() {
        this.aPw = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Is = Is();
            this.aPw.add(Is);
            addView(Is.getView());
        }
    }

    private void fz(int i) {
        int size;
        this.aPy.addAll(this.aOW);
        this.aOW.clear();
        if (i > 0 && (size = this.aPy.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aPy.add(Is());
            }
        }
    }

    private c Is() {
        c cVar;
        if (this.aOV != -1) {
            cVar = new c(getContext(), this.aOV);
        } else {
            cVar = new c(getContext());
        }
        if (this.aPB != -1) {
            cVar.setProgressBarTopMargin(this.aPB);
        }
        if (this.aOU != -1) {
            cVar.setProgressBarHeight(this.aOU);
        }
        if (this.aPC != -1) {
            cVar.setDescTopMargin(this.aPC);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aPy.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aOW != null) {
            for (c cVar : this.aOW) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aPC = i;
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
        if (this.mSkinType != i && this.aOW != null) {
            this.mSkinType = i;
            for (c cVar : this.aOW) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aPw != null) {
                for (c cVar2 : this.aPw) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
