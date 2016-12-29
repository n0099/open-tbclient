package com.baidu.tbadk.widget.vote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private int aKA;
    private com.baidu.tbadk.widget.vote.a aKB;
    private List<com.baidu.tbadk.widget.vote.a> aKC;
    private com.baidu.tbadk.widget.vote.b aKl;
    private List<b> aKz;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aKl = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aKA = -1;
        this.aKB = null;
        this.aKC = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aKA = -1;
        this.aKB = null;
        this.aKC = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aKz = new ArrayList();
    }

    public void E(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aKC = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(r.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aKG = (RelativeLayout) inflate.findViewById(r.g.root_pb_vote);
                    bVar.aKH = (TextView) inflate.findViewById(r.g.tv_name);
                    bVar.aKI = (CheckBox) inflate.findViewById(r.g.cb_select);
                    bVar.aKI.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aKH.setText(UtilHelper.getFixedText(aVar.Ce(), 15, false));
                    bVar.aKI.setChecked(aVar.isSelected());
                    bVar.aKG.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aKz.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            ar.c(bVar.aKH, r.d.cp_cont_b, 1);
            bVar.aKI.setButtonDrawable(ar.q(i, r.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aKD;
        private int aKE;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aKD = aVar;
            this.aKE = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aKz != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aKz.size(); i++) {
                            if (i == this.aKE) {
                                b bVar = (b) VoteTextGroupView.this.aKz.get(i);
                                boolean isChecked = bVar.aKI.isChecked();
                                bVar.aKI.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aKl != null) {
                                    VoteTextGroupView.this.aKl.a(this.aKD, this.aKE, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aKA == -1 && VoteTextGroupView.this.aKC != null) {
                    int size = VoteTextGroupView.this.aKC.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aKC.get(i2);
                        if (aVar != null && this.aKE != i2) {
                            ((b) VoteTextGroupView.this.aKz.get(i2)).aKI.setChecked(false);
                            if (VoteTextGroupView.this.aKl != null) {
                                VoteTextGroupView.this.aKl.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aKz.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aKz.get(i3);
                    if (this.aKE == i3) {
                        if (this.aKE != VoteTextGroupView.this.aKA && VoteTextGroupView.this.aKA >= 0 && VoteTextGroupView.this.aKA < VoteTextGroupView.this.aKz.size()) {
                            ((b) VoteTextGroupView.this.aKz.get(VoteTextGroupView.this.aKA)).aKI.setChecked(false);
                            if (VoteTextGroupView.this.aKl != null) {
                                VoteTextGroupView.this.aKl.a(VoteTextGroupView.this.aKB, VoteTextGroupView.this.aKA, false);
                            }
                        }
                        VoteTextGroupView.this.aKA = this.aKE;
                        VoteTextGroupView.this.aKB = this.aKD;
                        boolean isChecked2 = bVar2.aKI.isChecked();
                        bVar2.aKI.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aKl != null) {
                            VoteTextGroupView.this.aKl.a(this.aKD, this.aKE, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aKz != null && !this.aKz.isEmpty()) {
            for (b bVar : this.aKz) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aKG;
        public TextView aKH;
        public CheckBox aKI;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
