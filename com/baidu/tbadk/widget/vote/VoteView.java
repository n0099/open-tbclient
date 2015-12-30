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
    private List<c> aFS;
    private List<c> aGt;
    private final int aGu;
    private LinkedList<c> aGv;
    private int aGw;
    private boolean aGx;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aGu = 3;
        this.aGx = false;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aGu = 3;
        this.aGx = false;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aFS = new ArrayList();
        this.aGv = new LinkedList<>();
        this.aGw = getResources().getDimensionPixelSize(n.e.ds456);
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aGw = i;
        }
    }

    public void b(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            eT(list.size());
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
                    this.aFS.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aGw - i;
            for (c cVar : this.aFS) {
                if (cVar != null) {
                    cVar.eS(i2);
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
        if (!this.aGx) {
            Gp();
            this.aGx = true;
        }
        if (this.aGt != null && list != null && this.aGt.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) y.b(this.aGt, i);
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
                c cVar2 = (c) y.b(this.aGt, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) y.b(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.eS(this.aGw - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void Gp() {
        this.aGt = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c cVar = new c(getContext());
            this.aGt.add(cVar);
            addView(cVar.getView());
        }
    }

    private void eT(int i) {
        int size;
        this.aGv.addAll(this.aFS);
        this.aFS.clear();
        if (i > 0 && (size = this.aGv.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aGv.add(new c(getContext()));
            }
        }
    }

    private c getVoteItemView() {
        return this.aGv.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aFS != null) {
            for (c cVar : this.aFS) {
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
        if (this.mSkinType != i && this.aFS != null) {
            this.mSkinType = i;
            for (c cVar : this.aFS) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aGt != null) {
                for (c cVar2 : this.aGt) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
