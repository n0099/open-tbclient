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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private List<b> aOD;
    private int aOE;
    private com.baidu.tbadk.widget.vote.a aOF;
    private List<com.baidu.tbadk.widget.vote.a> aOG;
    private com.baidu.tbadk.widget.vote.b aOp;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aOp = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aOE = -1;
        this.aOF = null;
        this.aOG = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aOE = -1;
        this.aOF = null;
        this.aOG = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aOD = new ArrayList();
    }

    public void A(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aOG = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(w.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aOK = (RelativeLayout) inflate.findViewById(w.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(w.h.tv_name);
                    bVar.aOL = (CheckBox) inflate.findViewById(w.h.cb_select);
                    bVar.aOL.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.Ct(), 15, false));
                    bVar.aOL.setChecked(aVar.isSelected());
                    bVar.aOK.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aOD.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aq.c(bVar.name, w.e.cp_cont_b, 1);
            bVar.aOL.setButtonDrawable(aq.x(i, w.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aOH;
        private int aOI;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aOH = aVar;
            this.aOI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aOD != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aOD.size(); i++) {
                            if (i == this.aOI) {
                                b bVar = (b) VoteTextGroupView.this.aOD.get(i);
                                boolean isChecked = bVar.aOL.isChecked();
                                bVar.aOL.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aOp != null) {
                                    VoteTextGroupView.this.aOp.a(this.aOH, this.aOI, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aOE == -1 && VoteTextGroupView.this.aOG != null) {
                    int size = VoteTextGroupView.this.aOG.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aOG.get(i2);
                        if (aVar != null && this.aOI != i2) {
                            ((b) VoteTextGroupView.this.aOD.get(i2)).aOL.setChecked(false);
                            if (VoteTextGroupView.this.aOp != null) {
                                VoteTextGroupView.this.aOp.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aOD.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aOD.get(i3);
                    if (this.aOI == i3) {
                        if (this.aOI != VoteTextGroupView.this.aOE && VoteTextGroupView.this.aOE >= 0 && VoteTextGroupView.this.aOE < VoteTextGroupView.this.aOD.size()) {
                            ((b) VoteTextGroupView.this.aOD.get(VoteTextGroupView.this.aOE)).aOL.setChecked(false);
                            if (VoteTextGroupView.this.aOp != null) {
                                VoteTextGroupView.this.aOp.a(VoteTextGroupView.this.aOF, VoteTextGroupView.this.aOE, false);
                            }
                        }
                        VoteTextGroupView.this.aOE = this.aOI;
                        VoteTextGroupView.this.aOF = this.aOH;
                        boolean isChecked2 = bVar2.aOL.isChecked();
                        bVar2.aOL.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aOp != null) {
                            VoteTextGroupView.this.aOp.a(this.aOH, this.aOI, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aOD != null && !this.aOD.isEmpty()) {
            for (b bVar : this.aOD) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aOK;
        public CheckBox aOL;
        public TextView name;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
