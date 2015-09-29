package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private List<c> aCB;
    private LinkedList<c> aDc;
    private int aDd;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aCB = new ArrayList();
        this.aDc = new LinkedList<>();
        this.aDd = getResources().getDimensionPixelSize(i.d.ds456);
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aDd = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            eM(list.size());
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
                    this.aCB.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aDd - i;
            for (c cVar : this.aCB) {
                if (cVar != null) {
                    cVar.eL(i2);
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

    private void eM(int i) {
        int size;
        this.aDc.addAll(this.aCB);
        this.aCB.clear();
        if (i > 0 && (size = this.aDc.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aDc.add(new c(getContext()));
            }
        }
    }

    private c getVoteItemView() {
        return this.aDc.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aCB != null) {
            for (c cVar : this.aCB) {
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
        if (this.mSkinType != i && this.aCB != null) {
            this.mSkinType = i;
            for (c cVar : this.aCB) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
        }
    }
}
