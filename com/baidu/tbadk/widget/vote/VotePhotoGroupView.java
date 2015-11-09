package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.vote.e;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VotePhotoGroupView extends LinearLayout {
    private List<e> aBG;
    private LinearLayout aBH;
    private LinearLayout aBI;
    private b aBJ;
    private int aBK;
    private com.baidu.tbadk.widget.vote.a aBL;
    private e.a aBM;
    private int mode;

    public VotePhotoGroupView(Context context) {
        super(context);
        this.mode = 1;
        this.aBK = -1;
        this.aBL = null;
        this.aBM = new d(this);
        init(context);
    }

    public VotePhotoGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mode = 1;
        this.aBK = -1;
        this.aBL = null;
        this.aBM = new d(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(1);
        LayoutInflater.from(context).inflate(i.g.vote_photo_layout, this);
        this.aBH = (LinearLayout) findViewById(i.f.vote_select_pic_left);
        this.aBI = (LinearLayout) findViewById(i.f.vote_select_pic_right);
        this.aBG = new ArrayList();
    }

    public void setOnVoteCheckedChangedListener(b bVar) {
        this.aBJ = bVar;
    }

    public void setMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            this.mode = i;
        }
    }

    public void setData(List<com.baidu.tbadk.widget.vote.a> list, boolean z) {
        e eVar;
        this.aBH.removeAllViews();
        this.aBI.removeAllViews();
        this.aBG.clear();
        if (list != null && !list.isEmpty()) {
            com.baidu.tbadk.widget.vote.a aVar = null;
            e eVar2 = null;
            int i = 0;
            for (com.baidu.tbadk.widget.vote.a aVar2 : list) {
                if (aVar2 != null) {
                    int i2 = (i % 2) + 1;
                    boolean isSelected = aVar2.isSelected();
                    e eVar3 = new e(getContext());
                    eVar3.setOnItemCheckChangeListener(this.aBM);
                    eVar3.a(aVar2, i, this.mode, isSelected);
                    if (i2 == 1) {
                        this.aBH.addView(eVar3);
                        eVar = eVar3;
                    } else {
                        this.aBI.addView(eVar3);
                        if (aVar != null && eVar2 != null) {
                            boolean isNull = StringUtils.isNull(aVar.Fp());
                            boolean isNull2 = StringUtils.isNull(aVar2.Fp());
                            if (isNull && isNull2) {
                                eVar2.setNameVisibility(8);
                                eVar3.setNameVisibility(8);
                            }
                        }
                        aVar2 = aVar;
                        eVar = eVar2;
                    }
                    this.aBG.add(eVar3);
                    eVar2 = eVar;
                    i++;
                    aVar = aVar2;
                }
            }
            if (i % 2 != 0 && aVar != null && eVar2 != null && StringUtils.isNull(aVar.Fp())) {
                eVar2.setNameVisibility(8);
            }
            if (z) {
                a aVar3 = new a(this, null);
                aVar3.setDuration(300L);
                startAnimation(aVar3);
                return;
            }
            setProgress(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, boolean z) {
        if (this.aBG != null) {
            int size = this.aBG.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aBG.get(i2) != null) {
                    if (z || i == i2) {
                        this.aBG.get(i2).setSelected(true);
                    } else {
                        this.aBG.get(i2).setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aBG != null) {
            for (e eVar : this.aBG) {
                if (eVar != null) {
                    eVar.setProgress(f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends Animation {
        private a() {
        }

        /* synthetic */ a(VotePhotoGroupView votePhotoGroupView, a aVar) {
            this();
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            VotePhotoGroupView.this.setProgress(f);
        }
    }
}
