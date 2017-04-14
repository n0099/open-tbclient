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
    private com.baidu.tbadk.widget.vote.b aOF;
    private List<b> aOT;
    private int aOU;
    private com.baidu.tbadk.widget.vote.a aOV;
    private List<com.baidu.tbadk.widget.vote.a> aOW;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aOF = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aOU = -1;
        this.aOV = null;
        this.aOW = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aOU = -1;
        this.aOV = null;
        this.aOW = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aOT = new ArrayList();
    }

    public void A(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aOW = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(w.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aPa = (RelativeLayout) inflate.findViewById(w.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(w.h.tv_name);
                    bVar.aPb = (CheckBox) inflate.findViewById(w.h.cb_select);
                    bVar.aPb.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.CR(), 15, false));
                    bVar.aPb.setChecked(aVar.isSelected());
                    bVar.aPa.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aOT.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aq.c(bVar.name, w.e.cp_cont_b, 1);
            bVar.aPb.setButtonDrawable(aq.x(i, w.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aOX;
        private int aOY;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aOX = aVar;
            this.aOY = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aOT != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aOT.size(); i++) {
                            if (i == this.aOY) {
                                b bVar = (b) VoteTextGroupView.this.aOT.get(i);
                                boolean isChecked = bVar.aPb.isChecked();
                                bVar.aPb.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aOF != null) {
                                    VoteTextGroupView.this.aOF.a(this.aOX, this.aOY, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aOU == -1 && VoteTextGroupView.this.aOW != null) {
                    int size = VoteTextGroupView.this.aOW.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aOW.get(i2);
                        if (aVar != null && this.aOY != i2) {
                            ((b) VoteTextGroupView.this.aOT.get(i2)).aPb.setChecked(false);
                            if (VoteTextGroupView.this.aOF != null) {
                                VoteTextGroupView.this.aOF.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aOT.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aOT.get(i3);
                    if (this.aOY == i3) {
                        if (this.aOY != VoteTextGroupView.this.aOU && VoteTextGroupView.this.aOU >= 0 && VoteTextGroupView.this.aOU < VoteTextGroupView.this.aOT.size()) {
                            ((b) VoteTextGroupView.this.aOT.get(VoteTextGroupView.this.aOU)).aPb.setChecked(false);
                            if (VoteTextGroupView.this.aOF != null) {
                                VoteTextGroupView.this.aOF.a(VoteTextGroupView.this.aOV, VoteTextGroupView.this.aOU, false);
                            }
                        }
                        VoteTextGroupView.this.aOU = this.aOY;
                        VoteTextGroupView.this.aOV = this.aOX;
                        boolean isChecked2 = bVar2.aPb.isChecked();
                        bVar2.aPb.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aOF != null) {
                            VoteTextGroupView.this.aOF.a(this.aOX, this.aOY, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aOT != null && !this.aOT.isEmpty()) {
            for (b bVar : this.aOT) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aPa;
        public CheckBox aPb;
        public TextView name;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
