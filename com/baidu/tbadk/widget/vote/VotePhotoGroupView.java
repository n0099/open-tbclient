package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.vote.e;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VotePhotoGroupView extends LinearLayout {
    private List<e> aQo;
    private LinearLayout aQp;
    private LinearLayout aQq;
    private b aQr;
    private int aQs;
    private com.baidu.tbadk.widget.vote.a aQt;
    private e.a aQu;
    private int mode;

    public VotePhotoGroupView(Context context) {
        super(context);
        this.mode = 1;
        this.aQs = -1;
        this.aQt = null;
        this.aQu = new d(this);
        init(context);
    }

    public VotePhotoGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mode = 1;
        this.aQs = -1;
        this.aQt = null;
        this.aQu = new d(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(1);
        LayoutInflater.from(context).inflate(w.j.vote_photo_layout, this);
        this.aQp = (LinearLayout) findViewById(w.h.vote_select_pic_left);
        this.aQq = (LinearLayout) findViewById(w.h.vote_select_pic_right);
        this.aQo = new ArrayList();
    }

    public void setOnVoteCheckedChangedListener(b bVar) {
        this.aQr = bVar;
    }

    public void setMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            this.mode = i;
        }
    }

    public void a(List<com.baidu.tbadk.widget.vote.a> list, boolean z, boolean z2) {
        e eVar;
        this.aQp.removeAllViews();
        this.aQq.removeAllViews();
        this.aQo.clear();
        if (list != null && !list.isEmpty()) {
            int i = 0;
            com.baidu.tbadk.widget.vote.a aVar = null;
            e eVar2 = null;
            for (com.baidu.tbadk.widget.vote.a aVar2 : list) {
                if (aVar2 != null) {
                    int i2 = (i % 2) + 1;
                    boolean isSelected = aVar2.isSelected();
                    e eVar3 = new e(getContext());
                    eVar3.setOnItemCheckChangeListener(this.aQu);
                    eVar3.a(aVar2, i, this.mode, isSelected, z2);
                    if (i2 == 1) {
                        this.aQp.addView(eVar3);
                        eVar = eVar3;
                    } else {
                        this.aQq.addView(eVar3);
                        if (aVar != null && eVar2 != null) {
                            boolean isNull = StringUtils.isNull(aVar.Ck());
                            boolean isNull2 = StringUtils.isNull(aVar2.Ck());
                            if (isNull && isNull2) {
                                eVar2.setNameVisibility(8);
                                eVar3.setNameVisibility(8);
                            }
                        }
                        aVar2 = aVar;
                        eVar = eVar2;
                    }
                    this.aQo.add(eVar3);
                    i++;
                    aVar = aVar2;
                    eVar2 = eVar;
                }
            }
            if (i % 2 != 0 && aVar != null && eVar2 != null && StringUtils.isNull(aVar.Ck())) {
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
    public void j(int i, boolean z) {
        if (this.aQo != null) {
            int size = this.aQo.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aQo.get(i2) != null) {
                    if (z || i == i2) {
                        this.aQo.get(i2).setSelected(true);
                    } else {
                        this.aQo.get(i2).setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        if (f >= 0.0f && this.aQo != null) {
            for (e eVar : this.aQo) {
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
