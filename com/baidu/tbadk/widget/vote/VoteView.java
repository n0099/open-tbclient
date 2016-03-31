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
    private List<c> aJH;
    private List<c> aKj;
    private final int aKk;
    private LinkedList<c> aKl;
    private int aKm;
    private boolean aKn;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aKk = 3;
        this.aKn = false;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aKk = 3;
        this.aKn = false;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aJH = new ArrayList();
        this.aKl = new LinkedList<>();
        this.aKm = getResources().getDimensionPixelSize(t.e.ds456);
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aKm = i;
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
                        voteItemView = new c(getContext());
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aJH.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aKm - i;
            for (c cVar : this.aJH) {
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
        if (!this.aKn) {
            Jk();
            this.aKn = true;
        }
        if (this.aKj != null && list != null && this.aKj.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.b(this.aKj, i);
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
                c cVar2 = (c) y.b(this.aKj, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.b(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fB(this.aKm - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Jk() {
        this.aKj = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c cVar = new c(getContext());
            this.aKj.add(cVar);
            addView(cVar.getView());
        }
    }

    private void fC(int i) {
        int size;
        this.aKl.addAll(this.aJH);
        this.aJH.clear();
        if (i > 0 && (size = this.aKl.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aKl.add(new c(getContext()));
            }
        }
    }

    private c getVoteItemView() {
        return this.aKl.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aJH != null) {
            for (c cVar : this.aJH) {
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
        if (this.mSkinType != i && this.aJH != null) {
            this.mSkinType = i;
            for (c cVar : this.aJH) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aKj != null) {
                for (c cVar2 : this.aKj) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
