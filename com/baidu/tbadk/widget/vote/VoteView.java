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
    private List<c> aGU;
    private final int aGV;
    private LinkedList<c> aGW;
    private int aGX;
    private boolean aGY;
    private int aGZ;
    private int aGq;
    private int aGr;
    private List<c> aGs;
    private int aHa;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aGV = 3;
        this.aGY = false;
        this.aGq = -1;
        this.aGZ = -1;
        this.aGr = -1;
        this.aHa = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aGV = 3;
        this.aGY = false;
        this.aGq = -1;
        this.aGZ = -1;
        this.aGr = -1;
        this.aHa = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aGs = new ArrayList();
        this.aGW = new LinkedList<>();
        this.aGX = getResources().getDimensionPixelSize(u.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aGq = i;
    }

    public void setDescTextColorResId(int i) {
        this.aGr = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aGZ = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aGX = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fn(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = HE();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aGs.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aGX - i;
            for (c cVar : this.aGs) {
                if (cVar != null) {
                    cVar.fm(i2);
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
        if (!this.aGY) {
            HD();
            this.aGY = true;
        }
        if (this.aGU != null && list != null && this.aGU.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.c(this.aGU, i);
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
                c cVar2 = (c) y.c(this.aGU, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fm(this.aGX - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void HD() {
        this.aGU = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c HE = HE();
            this.aGU.add(HE);
            addView(HE.getView());
        }
    }

    private void fn(int i) {
        int size;
        this.aGW.addAll(this.aGs);
        this.aGs.clear();
        if (i > 0 && (size = this.aGW.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aGW.add(HE());
            }
        }
    }

    private c HE() {
        c cVar;
        if (this.aGr != -1) {
            cVar = new c(getContext(), this.aGr);
        } else {
            cVar = new c(getContext());
        }
        if (this.aGZ != -1) {
            cVar.setProgressBarTopMargin(this.aGZ);
        }
        if (this.aGq != -1) {
            cVar.setProgressBarHeight(this.aGq);
        }
        if (this.aHa != -1) {
            cVar.setDescTopMargin(this.aHa);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aGW.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aGs != null) {
            for (c cVar : this.aGs) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aHa = i;
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
        if (this.mSkinType != i && this.aGs != null) {
            this.mSkinType = i;
            for (c cVar : this.aGs) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aGU != null) {
                for (c cVar2 : this.aGU) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
