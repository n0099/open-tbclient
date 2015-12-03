package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private List<c> aET;
    private final int aEU;
    private LinkedList<c> aEV;
    private int aEW;
    private boolean aEX;
    private List<c> aEs;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aEU = 3;
        this.aEX = false;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aEU = 3;
        this.aEX = false;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aEs = new ArrayList();
        this.aEV = new LinkedList<>();
        this.aEW = getResources().getDimensionPixelSize(n.d.ds456);
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aEW = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            eZ(list.size());
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar : list) {
                if (aVar != null) {
                    c voteItemView = getVoteItemView();
                    if (voteItemView == null) {
                        voteItemView = new c(getContext());
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aEs.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aEW - i;
            for (c cVar : this.aEs) {
                if (cVar != null) {
                    cVar.eY(i2);
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
        if (!this.aEX) {
            GA();
            this.aEX = true;
        }
        if (this.aET != null && list != null && this.aET.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.b(this.aET, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) y.b(list, i);
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
                c cVar2 = (c) y.b(this.aET, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.b(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.eY(this.aEW - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void GA() {
        this.aET = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c cVar = new c(getContext());
            this.aET.add(cVar);
            addView(cVar.getView());
        }
    }

    private void eZ(int i) {
        int size;
        this.aEV.addAll(this.aEs);
        this.aEs.clear();
        if (i > 0 && (size = this.aEV.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aEV.add(new c(getContext()));
            }
        }
    }

    private c getVoteItemView() {
        return this.aEV.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aEs != null) {
            for (c cVar : this.aEs) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
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
        if (this.mSkinType != i && this.aEs != null) {
            this.mSkinType = i;
            for (c cVar : this.aEs) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aET != null) {
                for (c cVar2 : this.aET) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
