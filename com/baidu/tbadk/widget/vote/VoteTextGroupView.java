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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private List<b> aTI;
    private int aTJ;
    private com.baidu.tbadk.widget.vote.a aTK;
    private List<com.baidu.tbadk.widget.vote.a> aTL;
    private com.baidu.tbadk.widget.vote.b aTu;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aTu = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aTJ = -1;
        this.aTK = null;
        this.aTL = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aTJ = -1;
        this.aTK = null;
        this.aTL = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aTI = new ArrayList();
    }

    public void H(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aTL = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aTP = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aTQ = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aTQ.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.Cd(), 15, false));
                    bVar.aTQ.setChecked(aVar.isSelected());
                    bVar.aTP.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aTI.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aTQ.setButtonDrawable(aj.u(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aTM;
        private int aTN;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aTM = aVar;
            this.aTN = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aTI != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aTJ == -1 && VoteTextGroupView.this.aTL != null) {
                        int size = VoteTextGroupView.this.aTL.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aTL.get(i);
                            if (aVar != null && this.aTN != i) {
                                ((b) VoteTextGroupView.this.aTI.get(i)).aTQ.setChecked(false);
                                if (VoteTextGroupView.this.aTu != null) {
                                    VoteTextGroupView.this.aTu.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aTI.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aTI.get(i2);
                        if (this.aTN == i2) {
                            if (this.aTN != VoteTextGroupView.this.aTJ && VoteTextGroupView.this.aTJ >= 0 && VoteTextGroupView.this.aTJ < VoteTextGroupView.this.aTI.size()) {
                                ((b) VoteTextGroupView.this.aTI.get(VoteTextGroupView.this.aTJ)).aTQ.setChecked(false);
                                if (VoteTextGroupView.this.aTu != null) {
                                    VoteTextGroupView.this.aTu.a(VoteTextGroupView.this.aTK, VoteTextGroupView.this.aTJ, false);
                                }
                            }
                            VoteTextGroupView.this.aTJ = this.aTN;
                            VoteTextGroupView.this.aTK = this.aTM;
                            boolean isChecked = bVar.aTQ.isChecked();
                            bVar.aTQ.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aTu != null) {
                                VoteTextGroupView.this.aTu.a(this.aTM, this.aTN, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aTI.size(); i3++) {
                        if (i3 == this.aTN) {
                            b bVar2 = (b) VoteTextGroupView.this.aTI.get(i3);
                            boolean isChecked2 = bVar2.aTQ.isChecked();
                            bVar2.aTQ.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aTu != null) {
                                VoteTextGroupView.this.aTu.a(this.aTM, this.aTN, isChecked2 ? false : true);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aTI != null && !this.aTI.isEmpty()) {
            for (b bVar : this.aTI) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aTP;
        public CheckBox aTQ;
        public TextView name;

        private b() {
        }
    }
}
