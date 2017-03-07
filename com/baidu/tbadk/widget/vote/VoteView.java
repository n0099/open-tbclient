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
    private List<c> aOM;
    private final int aON;
    private LinkedList<c> aOO;
    private int aOP;
    private boolean aOQ;
    private int aOR;
    private int aOS;
    private int aOk;
    private int aOl;
    private List<c> aOm;
    private int mSkinType;

    public VoteView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aON = 3;
        this.aOQ = false;
        this.aOk = -1;
        this.aOR = -1;
        this.aOl = -1;
        this.aOS = -1;
        init();
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aON = 3;
        this.aOQ = false;
        this.aOk = -1;
        this.aOR = -1;
        this.aOl = -1;
        this.aOS = -1;
        init();
    }

    private void init() {
        setOrientation(1);
        this.aOm = new ArrayList();
        this.aOO = new LinkedList<>();
        this.aOP = getResources().getDimensionPixelSize(w.f.ds456);
    }

    public void setProgressBarHeight(int i) {
        this.aOk = i;
    }

    public void setDescTextColorResId(int i) {
        this.aOl = i;
    }

    public void setProgressBarTopMargin(int i) {
        this.aOR = i;
    }

    public void setWidth(int i) {
        if (i >= 0) {
            this.aOP = i;
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
                        voteItemView = IK();
                    }
                    int a2 = voteItemView.a(aVar);
                    if (a2 <= i) {
                        a2 = i;
                    }
                    this.aOm.add(voteItemView);
                    i = a2;
                }
            }
            int i2 = this.aOP - i;
            for (c cVar : this.aOm) {
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
        if (!this.aOQ) {
            IJ();
            this.aOQ = true;
        }
        if (this.aOM != null && list != null && this.aOM.size() == 3) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                c cVar = (c) x.c(this.aOM, i);
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
                c cVar2 = (c) x.c(this.aOM, i3);
                if (cVar2 != null && cVar2.getView() != null) {
                    if (((com.baidu.tbadk.widget.vote.a) x.c(list, i3)) == null) {
                        cVar2.getView().setVisibility(8);
                    } else {
                        cVar2.getView().setVisibility(0);
                        cVar2.fx(this.aOP - i2);
                        cVar2.setProgress(1.0f);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void IJ() {
        this.aOM = new ArrayList();
        for (int i = 0; i < 3; i++) {
            c IK = IK();
            this.aOM.add(IK);
            addView(IK.getView());
        }
    }

    private void fy(int i) {
        int size;
        this.aOO.addAll(this.aOm);
        this.aOm.clear();
        if (i > 0 && (size = this.aOO.size()) < i) {
            int i2 = i - size;
            for (int i3 = 0; i3 < i2; i3++) {
                this.aOO.add(IK());
            }
        }
    }

    private c IK() {
        c cVar;
        if (this.aOl != -1) {
            cVar = new c(getContext(), this.aOl);
        } else {
            cVar = new c(getContext());
        }
        if (this.aOR != -1) {
            cVar.setProgressBarTopMargin(this.aOR);
        }
        if (this.aOk != -1) {
            cVar.setProgressBarHeight(this.aOk);
        }
        if (this.aOS != -1) {
            cVar.setDescTopMargin(this.aOS);
        }
        return cVar;
    }

    private c getVoteItemView() {
        return this.aOO.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aOm != null) {
            for (c cVar : this.aOm) {
                if (cVar != null) {
                    cVar.setProgress(f);
                }
            }
        }
    }

    public void setDescTopMargin(int i) {
        this.aOS = i;
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
        if (this.mSkinType != i && this.aOm != null) {
            this.mSkinType = i;
            for (c cVar : this.aOm) {
                if (cVar != null) {
                    cVar.onChangeSkinType(i);
                }
            }
            if (this.aOM != null) {
                for (c cVar2 : this.aOM) {
                    if (cVar2 != null) {
                        cVar2.onChangeSkinType(i);
                    }
                }
            }
        }
    }
}
