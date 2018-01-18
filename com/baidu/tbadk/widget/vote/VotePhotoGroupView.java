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
    private d.a bKA;
    private List<d> bKu;
    private LinearLayout bKv;
    private LinearLayout bKw;
    private b bKx;
    private int bKy;
    private com.baidu.tbadk.widget.vote.a bKz;
    private int mode;

    public VotePhotoGroupView(Context context) {
        super(context);
        this.mode = 1;
        this.bKy = -1;
        this.bKz = null;
        this.bKA = new d.a() { // from class: com.baidu.tbadk.widget.vote.VotePhotoGroupView.1
            @Override // com.baidu.tbadk.widget.vote.d.a
            public void b(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (VotePhotoGroupView.this.mode == 3) {
                    if (z) {
                        VotePhotoGroupView.this.u(i, false);
                    }
                    if (VotePhotoGroupView.this.bKy != i) {
                        if (VotePhotoGroupView.this.bKx != null) {
                            VotePhotoGroupView.this.bKx.a(VotePhotoGroupView.this.bKz, VotePhotoGroupView.this.bKy, false);
                        }
                        VotePhotoGroupView.this.bKz = aVar;
                        VotePhotoGroupView.this.bKy = i;
                    }
                }
                if (VotePhotoGroupView.this.bKx != null) {
                    VotePhotoGroupView.this.bKx.a(aVar, i, z);
                }
            }
        };
        init(context);
    }

    public VotePhotoGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mode = 1;
        this.bKy = -1;
        this.bKz = null;
        this.bKA = new d.a() { // from class: com.baidu.tbadk.widget.vote.VotePhotoGroupView.1
            @Override // com.baidu.tbadk.widget.vote.d.a
            public void b(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (VotePhotoGroupView.this.mode == 3) {
                    if (z) {
                        VotePhotoGroupView.this.u(i, false);
                    }
                    if (VotePhotoGroupView.this.bKy != i) {
                        if (VotePhotoGroupView.this.bKx != null) {
                            VotePhotoGroupView.this.bKx.a(VotePhotoGroupView.this.bKz, VotePhotoGroupView.this.bKy, false);
                        }
                        VotePhotoGroupView.this.bKz = aVar;
                        VotePhotoGroupView.this.bKy = i;
                    }
                }
                if (VotePhotoGroupView.this.bKx != null) {
                    VotePhotoGroupView.this.bKx.a(aVar, i, z);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(1);
        LayoutInflater.from(context).inflate(d.h.vote_photo_layout, this);
        this.bKv = (LinearLayout) findViewById(d.g.vote_select_pic_left);
        this.bKw = (LinearLayout) findViewById(d.g.vote_select_pic_right);
        this.bKu = new ArrayList();
    }

    public void setOnVoteCheckedChangedListener(b bVar) {
        this.bKx = bVar;
    }

    public void setMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            this.mode = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z, boolean z2) {
        d dVar;
        this.bKv.removeAllViews();
        this.bKw.removeAllViews();
        this.bKu.clear();
        if (list != null && !list.isEmpty()) {
            int i = 0;
            com.baidu.tbadk.widget.vote.a aVar = null;
            d dVar2 = null;
            for (com.baidu.tbadk.widget.vote.a aVar2 : list) {
                if (aVar2 != null) {
                    int i2 = (i % 2) + 1;
                    boolean isSelected = aVar2.isSelected();
                    d dVar3 = new d(getContext());
                    dVar3.setOnItemCheckChangeListener(this.bKA);
                    dVar3.a(aVar2, i, this.mode, isSelected, z2);
                    if (i2 == 1) {
                        this.bKv.addView(dVar3);
                        dVar = dVar3;
                    } else {
                        this.bKw.addView(dVar3);
                        if (aVar != null && dVar2 != null) {
                            boolean isNull = StringUtils.isNull(aVar.JY());
                            boolean isNull2 = StringUtils.isNull(aVar2.JY());
                            if (isNull && isNull2) {
                                dVar2.setNameVisibility(8);
                                dVar3.setNameVisibility(8);
                            }
                        }
                        aVar2 = aVar;
                        dVar = dVar2;
                    }
                    this.bKu.add(dVar3);
                    i++;
                    aVar = aVar2;
                    dVar2 = dVar;
                }
            }
            if (i % 2 != 0 && aVar != null && dVar2 != null && StringUtils.isNull(aVar.JY())) {
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
    public void u(int i, boolean z) {
        if (this.bKu != null) {
            int size = this.bKu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bKu.get(i2) != null) {
                    if (z || i == i2) {
                        this.bKu.get(i2).setSelected(true);
                    } else {
                        this.bKu.get(i2).setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.bKu != null) {
            for (d dVar : this.bKu) {
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
