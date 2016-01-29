package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private List<c> aGL;
    private List<c> aHn;
    private final int aHo;
    private LinkedList<c> aHp;
    private int aHq;
    private boolean aHr;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aHo = 3;
        this.aHr = false;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aHo = 3;
        this.aHr = false;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aGL = new ArrayList();
        this.aHp = new LinkedList<>();
        this.aHq = getResources().getDimensionPixelSize(t.e.ds456);
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aHq = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() > 0) {
            fp(list.size());
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
                    this.aGL.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aHq - i;
            for (c cVar : this.aGL) {
                if (cVar != null) {
                    cVar.fo(i2);
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
        if (!this.aHr) {
            HO();
            this.aHr = true;
        }
        if (this.aHn != null && list != null && this.aHn.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) x.b(this.aHn, i);
                if (cVar != null && cVar.getView() != null) {
                    com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) x.b(list, i);
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
                c cVar2 = (c) x.b(this.aHn, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) x.b(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fo(this.aHq - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void HO() {
        this.aHn = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c cVar = new c(getContext());
            this.aHn.add(cVar);
            addView(cVar.getView());
        }
    }

    private void fp(int i) {
        int size;
        this.aHp.addAll(this.aGL);
        this.aGL.clear();
        if (i > 0 && (size = this.aHp.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aHp.add(new c(getContext()));
            }
        }
    }

    private c getVoteItemView() {
        return this.aHp.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aGL != null) {
            for (c cVar : this.aGL) {
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
        if (this.mSkinType != i && this.aGL != null) {
            this.mSkinType = i;
            for (c cVar : this.aGL) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aHn != null) {
                for (c cVar2 : this.aHn) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
