package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.vote.d;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VotePhotoGroupView extends LinearLayout {
    private List<d> bMt;
    private LinearLayout bMu;
    private LinearLayout bMv;
    private b bMw;
    private int bMx;
    private com.baidu.tbadk.widget.vote.a bMy;
    private d.a bMz;
    private int mode;

    public VotePhotoGroupView(Context context) {
        super(context);
        this.mode = 1;
        this.bMx = -1;
        this.bMy = null;
        this.bMz = new d.a() { // from class: com.baidu.tbadk.widget.vote.VotePhotoGroupView.1
            @Override // com.baidu.tbadk.widget.vote.d.a
            public void b(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (VotePhotoGroupView.this.mode == 3) {
                    if (z) {
                        VotePhotoGroupView.this.y(i, false);
                    }
                    if (VotePhotoGroupView.this.bMx != i) {
                        if (VotePhotoGroupView.this.bMw != null) {
                            VotePhotoGroupView.this.bMw.a(VotePhotoGroupView.this.bMy, VotePhotoGroupView.this.bMx, false);
                        }
                        VotePhotoGroupView.this.bMy = aVar;
                        VotePhotoGroupView.this.bMx = i;
                    }
                }
                if (VotePhotoGroupView.this.bMw != null) {
                    VotePhotoGroupView.this.bMw.a(aVar, i, z);
                }
            }
        };
        init(context);
    }

    public VotePhotoGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mode = 1;
        this.bMx = -1;
        this.bMy = null;
        this.bMz = new d.a() { // from class: com.baidu.tbadk.widget.vote.VotePhotoGroupView.1
            @Override // com.baidu.tbadk.widget.vote.d.a
            public void b(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (VotePhotoGroupView.this.mode == 3) {
                    if (z) {
                        VotePhotoGroupView.this.y(i, false);
                    }
                    if (VotePhotoGroupView.this.bMx != i) {
                        if (VotePhotoGroupView.this.bMw != null) {
                            VotePhotoGroupView.this.bMw.a(VotePhotoGroupView.this.bMy, VotePhotoGroupView.this.bMx, false);
                        }
                        VotePhotoGroupView.this.bMy = aVar;
                        VotePhotoGroupView.this.bMx = i;
                    }
                }
                if (VotePhotoGroupView.this.bMw != null) {
                    VotePhotoGroupView.this.bMw.a(aVar, i, z);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(1);
        LayoutInflater.from(context).inflate(d.h.vote_photo_layout, this);
        this.bMu = (LinearLayout) findViewById(d.g.vote_select_pic_left);
        this.bMv = (LinearLayout) findViewById(d.g.vote_select_pic_right);
        this.bMt = new ArrayList();
    }

    public void setOnVoteCheckedChangedListener(b bVar) {
        this.bMw = bVar;
    }

    public void setMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            this.mode = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z, boolean z2) {
        d dVar;
        this.bMu.removeAllViews();
        this.bMv.removeAllViews();
        this.bMt.clear();
        if (list != null && !list.isEmpty()) {
            int i = 0;
            com.baidu.tbadk.widget.vote.a aVar = null;
            d dVar2 = null;
            for (com.baidu.tbadk.widget.vote.a aVar2 : list) {
                if (aVar2 != null) {
                    int i2 = (i % 2) + 1;
                    boolean isSelected = aVar2.isSelected();
                    d dVar3 = new d(getContext());
                    dVar3.setOnItemCheckChangeListener(this.bMz);
                    dVar3.a(aVar2, i, this.mode, isSelected, z2);
                    if (i2 == 1) {
                        this.bMu.addView(dVar3);
                        dVar = dVar3;
                    } else {
                        this.bMv.addView(dVar3);
                        if (aVar != null && dVar2 != null) {
                            boolean isNull = StringUtils.isNull(aVar.KF());
                            boolean isNull2 = StringUtils.isNull(aVar2.KF());
                            if (isNull && isNull2) {
                                dVar2.setNameVisibility(8);
                                dVar3.setNameVisibility(8);
                            }
                        }
                        aVar2 = aVar;
                        dVar = dVar2;
                    }
                    this.bMt.add(dVar3);
                    i++;
                    aVar = aVar2;
                    dVar2 = dVar;
                }
            }
            if (i % 2 != 0 && aVar != null && dVar2 != null && StringUtils.isNull(aVar.KF())) {
                dVar2.setNameVisibility(8);
            }
            if (z) {
                a aVar3 = new a();
                aVar3.setDuration(300L);
                startAnimation(aVar3);
                return;
            }
            setProgress(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, boolean z) {
        if (this.bMt != null) {
            int size = this.bMt.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bMt.get(i2) != null) {
                    if (z || i == i2) {
                        this.bMt.get(i2).setSelected(true);
                    } else {
                        this.bMt.get(i2).setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bMt != null) {
            for (d dVar : this.bMt) {
                if (dVar != null) {
                    dVar.setProgress(f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends Animation {
        private a() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            VotePhotoGroupView.this.setProgress(f);
        }
    }
}
