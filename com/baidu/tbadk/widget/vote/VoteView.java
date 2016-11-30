package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private int aKP;
    private int aKQ;
    private List<c> aKR;
    private List<c> aLs;
    private final int aLt;
    private LinkedList<c> aLu;
    private int aLv;
    private boolean aLw;
    private int aLx;
    private int aLy;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aLt = 3;
        this.aLw = false;
        this.aKP = -1;
        this.aLx = -1;
        this.aKQ = -1;
        this.aLy = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aLt = 3;
        this.aLw = false;
        this.aKP = -1;
        this.aLx = -1;
        this.aKQ = -1;
        this.aLy = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aKR = new ArrayList();
        this.aLu = new LinkedList<>();
        this.aLv = getResources().getDimensionPixelSize(r.e.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aKP = i;
    }

    public void setDescTextColorResId(int i) {
        this.aKQ = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aLx = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aLv = i;
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
                        voteItemView = IY();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aKR.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aLv - i;
            for (c cVar : this.aKR) {
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
        if (!this.aLw) {
            IX();
            this.aLw = true;
        }
        if (this.aLs != null && list != null && this.aLs.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) x.c(this.aLs, i);
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
                c cVar2 = (c) x.c(this.aLs, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) x.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fD(this.aLv - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void IX() {
        this.aLs = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c IY = IY();
            this.aLs.add(IY);
            addView(IY.getView());
        }
    }

    private void fE(int i) {
        int size;
        this.aLu.addAll(this.aKR);
        this.aKR.clear();
        if (i > 0 && (size = this.aLu.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aLu.add(IY());
            }
        }
    }

    private c IY() {
        c cVar;
        if (this.aKQ != -1) {
            cVar = new c(getContext(), this.aKQ);
        } else {
            cVar = new c(getContext());
        }
        if (this.aLx != -1) {
            cVar.setProgressBarTopMargin(this.aLx);
        }
        if (this.aKP != -1) {
            cVar.setProgressBarHeight(this.aKP);
        }
        if (this.aLy != -1) {
            cVar.setDescTopMargin(this.aLy);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aLu.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aKR != null) {
            for (c cVar : this.aKR) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aLy = i;
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
        if (this.mSkinType != i && this.aKR != null) {
            this.mSkinType = i;
            for (c cVar : this.aKR) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aLs != null) {
                for (c cVar2 : this.aLs) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
