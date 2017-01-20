package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private int aIN;
    private int aIO;
    private List<c> aIP;
    private List<c> aJp;
    private final int aJq;
    private LinkedList<c> aJr;
    private int aJs;
    private boolean aJt;
    private int aJu;
    private int aJv;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aJq = 3;
        this.aJt = false;
        this.aIN = -1;
        this.aJu = -1;
        this.aIO = -1;
        this.aJv = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aJq = 3;
        this.aJt = false;
        this.aIN = -1;
        this.aJu = -1;
        this.aIO = -1;
        this.aJv = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aIP = new ArrayList();
        this.aJr = new LinkedList<>();
        this.aJs = getResources().getDimensionPixelSize(r.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aIN = i;
    }

    public void setDescTextColorResId(int i) {
        this.aIO = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aJu = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aJs = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fE(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = Ik();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aIP.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aJs - i;
            for (c cVar : this.aIP) {
                if (cVar != null) {
                    cVar.fD(i2);
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
        if (!this.aJt) {
            Ij();
            this.aJt = true;
        }
        if (this.aJp != null && list != null && this.aJp.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) w.c(this.aJp, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) w.c(list, i);
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
                c cVar2 = (c) w.c(this.aJp, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) w.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fD(this.aJs - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Ij() {
        this.aJp = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c Ik = Ik();
            this.aJp.add(Ik);
            addView(Ik.getView());
        }
    }

    private void fE(int i) {
        int size;
        this.aJr.addAll(this.aIP);
        this.aIP.clear();
        if (i > 0 && (size = this.aJr.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aJr.add(Ik());
            }
        }
    }

    private c Ik() {
        c cVar;
        if (this.aIO != -1) {
            cVar = new c(getContext(), this.aIO);
        } else {
            cVar = new c(getContext());
        }
        if (this.aJu != -1) {
            cVar.setProgressBarTopMargin(this.aJu);
        }
        if (this.aIN != -1) {
            cVar.setProgressBarHeight(this.aIN);
        }
        if (this.aJv != -1) {
            cVar.setDescTopMargin(this.aJv);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aJr.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aIP != null) {
            for (c cVar : this.aIP) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aJv = i;
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
        if (this.mSkinType != i && this.aIP != null) {
            this.mSkinType = i;
            for (c cVar : this.aIP) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aJp != null) {
                for (c cVar2 : this.aJp) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
