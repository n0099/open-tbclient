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
    private List<b> aTH;
    private int aTI;
    private com.baidu.tbadk.widget.vote.a aTJ;
    private List<com.baidu.tbadk.widget.vote.a> aTK;
    private com.baidu.tbadk.widget.vote.b aTt;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aTt = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aTI = -1;
        this.aTJ = null;
        this.aTK = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aTI = -1;
        this.aTJ = null;
        this.aTK = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aTH = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aTK = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aTO = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.aTP = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.aTQ = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.aTQ.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aTP.setText(UtilHelper.getFixedText(aVar.Cy(), 15, false));
                    bVar.aTQ.setChecked(aVar.isSelected());
                    bVar.aTO.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aTH.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.aTP, d.C0080d.cp_cont_b, 1);
            bVar.aTQ.setButtonDrawable(aj.u(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aTL;
        private int aTM;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aTL = aVar;
            this.aTM = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aTH != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aTI == -1 && VoteTextGroupView.this.aTK != null) {
                        int size = VoteTextGroupView.this.aTK.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aTK.get(i);
                            if (aVar != null && this.aTM != i) {
                                ((b) VoteTextGroupView.this.aTH.get(i)).aTQ.setChecked(false);
                                if (VoteTextGroupView.this.aTt != null) {
                                    VoteTextGroupView.this.aTt.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aTH.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aTH.get(i2);
                        if (this.aTM == i2) {
                            if (this.aTM != VoteTextGroupView.this.aTI && VoteTextGroupView.this.aTI >= 0 && VoteTextGroupView.this.aTI < VoteTextGroupView.this.aTH.size()) {
                                ((b) VoteTextGroupView.this.aTH.get(VoteTextGroupView.this.aTI)).aTQ.setChecked(false);
                                if (VoteTextGroupView.this.aTt != null) {
                                    VoteTextGroupView.this.aTt.a(VoteTextGroupView.this.aTJ, VoteTextGroupView.this.aTI, false);
                                }
                            }
                            VoteTextGroupView.this.aTI = this.aTM;
                            VoteTextGroupView.this.aTJ = this.aTL;
                            boolean isChecked = bVar.aTQ.isChecked();
                            bVar.aTQ.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aTt != null) {
                                VoteTextGroupView.this.aTt.a(this.aTL, this.aTM, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aTH.size(); i3++) {
                        if (i3 == this.aTM) {
                            b bVar2 = (b) VoteTextGroupView.this.aTH.get(i3);
                            boolean isChecked2 = bVar2.aTQ.isChecked();
                            bVar2.aTQ.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aTt != null) {
                                VoteTextGroupView.this.aTt.a(this.aTL, this.aTM, isChecked2 ? false : true);
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
        if (this.aTH != null && !this.aTH.isEmpty()) {
            for (b bVar : this.aTH) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aTO;
        public TextView aTP;
        public CheckBox aTQ;

        private b() {
        }
    }
}
