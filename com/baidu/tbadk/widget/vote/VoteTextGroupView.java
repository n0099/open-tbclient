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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aKC;
    private List<b> aKR;
    private int aKS;
    private com.baidu.tbadk.widget.vote.a aKT;
    private List<com.baidu.tbadk.widget.vote.a> aKU;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aKC = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aKS = -1;
        this.aKT = null;
        this.aKU = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aKS = -1;
        this.aKT = null;
        this.aKU = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aKR = new ArrayList();
    }

    public void E(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aKU = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(t.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aKY = (RelativeLayout) inflate.findViewById(t.g.root);
                    bVar.aKZ = (TextView) inflate.findViewById(t.g.tv_name);
                    bVar.aLa = (CheckBox) inflate.findViewById(t.g.cb_select);
                    bVar.aLb = inflate.findViewById(t.g.v_line);
                    bVar.aLa.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aKZ.setText(UtilHelper.getFixedText(aVar.Cg(), 15, false));
                    bVar.aLa.setChecked(aVar.isSelected());
                    bVar.aKY.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.aLb.setVisibility(8);
                    }
                    addView(inflate);
                    this.aKR.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            av.c(bVar.aKZ, t.d.cp_cont_b, 1);
            bVar.aLa.setButtonDrawable(av.q(i, t.f.vote_text_check_box));
            av.k(bVar.aLb, t.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aKV;
        private int aKW;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aKV = aVar;
            this.aKW = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aKR != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aKR.size(); i++) {
                            if (i == this.aKW) {
                                b bVar = (b) VoteTextGroupView.this.aKR.get(i);
                                boolean isChecked = bVar.aLa.isChecked();
                                bVar.aLa.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aKC != null) {
                                    VoteTextGroupView.this.aKC.a(this.aKV, this.aKW, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aKS == -1 && VoteTextGroupView.this.aKU != null) {
                    int size = VoteTextGroupView.this.aKU.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aKU.get(i2);
                        if (aVar != null && this.aKW != i2) {
                            ((b) VoteTextGroupView.this.aKR.get(i2)).aLa.setChecked(false);
                            if (VoteTextGroupView.this.aKC != null) {
                                VoteTextGroupView.this.aKC.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aKR.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aKR.get(i3);
                    if (this.aKW == i3) {
                        if (this.aKW != VoteTextGroupView.this.aKS && VoteTextGroupView.this.aKS >= 0 && VoteTextGroupView.this.aKS < VoteTextGroupView.this.aKR.size()) {
                            ((b) VoteTextGroupView.this.aKR.get(VoteTextGroupView.this.aKS)).aLa.setChecked(false);
                            if (VoteTextGroupView.this.aKC != null) {
                                VoteTextGroupView.this.aKC.a(VoteTextGroupView.this.aKT, VoteTextGroupView.this.aKS, false);
                            }
                        }
                        VoteTextGroupView.this.aKS = this.aKW;
                        VoteTextGroupView.this.aKT = this.aKV;
                        boolean isChecked2 = bVar2.aLa.isChecked();
                        bVar2.aLa.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aKC != null) {
                            VoteTextGroupView.this.aKC.a(this.aKV, this.aKW, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aKR != null && !this.aKR.isEmpty()) {
            for (b bVar : this.aKR) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aKY;
        public TextView aKZ;
        public CheckBox aLa;
        public View aLb;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
