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
    private List<b> aWI;
    private int aWJ;
    private com.baidu.tbadk.widget.vote.a aWK;
    private List<com.baidu.tbadk.widget.vote.a> aWL;
    private com.baidu.tbadk.widget.vote.b aWu;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aWu = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aWJ = -1;
        this.aWK = null;
        this.aWL = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aWJ = -1;
        this.aWK = null;
        this.aWL = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aWI = new ArrayList();
    }

    public void J(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aWL = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aWP = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.aWQ = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.aWR = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.aWR.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aWQ.setText(UtilHelper.getFixedText(aVar.CH(), 15, false));
                    bVar.aWR.setChecked(aVar.isSelected());
                    bVar.aWP.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aWI.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.aWQ, d.C0082d.cp_cont_b, 1);
            bVar.aWR.setButtonDrawable(aj.u(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aWM;
        private int aWN;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aWM = aVar;
            this.aWN = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aWI != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aWJ == -1 && VoteTextGroupView.this.aWL != null) {
                        int size = VoteTextGroupView.this.aWL.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aWL.get(i);
                            if (aVar != null && this.aWN != i) {
                                ((b) VoteTextGroupView.this.aWI.get(i)).aWR.setChecked(false);
                                if (VoteTextGroupView.this.aWu != null) {
                                    VoteTextGroupView.this.aWu.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aWI.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aWI.get(i2);
                        if (this.aWN == i2) {
                            if (this.aWN != VoteTextGroupView.this.aWJ && VoteTextGroupView.this.aWJ >= 0 && VoteTextGroupView.this.aWJ < VoteTextGroupView.this.aWI.size()) {
                                ((b) VoteTextGroupView.this.aWI.get(VoteTextGroupView.this.aWJ)).aWR.setChecked(false);
                                if (VoteTextGroupView.this.aWu != null) {
                                    VoteTextGroupView.this.aWu.a(VoteTextGroupView.this.aWK, VoteTextGroupView.this.aWJ, false);
                                }
                            }
                            VoteTextGroupView.this.aWJ = this.aWN;
                            VoteTextGroupView.this.aWK = this.aWM;
                            boolean isChecked = bVar.aWR.isChecked();
                            bVar.aWR.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aWu != null) {
                                VoteTextGroupView.this.aWu.a(this.aWM, this.aWN, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aWI.size(); i3++) {
                        if (i3 == this.aWN) {
                            b bVar2 = (b) VoteTextGroupView.this.aWI.get(i3);
                            boolean isChecked2 = bVar2.aWR.isChecked();
                            bVar2.aWR.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aWu != null) {
                                VoteTextGroupView.this.aWu.a(this.aWM, this.aWN, isChecked2 ? false : true);
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
        if (this.aWI != null && !this.aWI.isEmpty()) {
            for (b bVar : this.aWI) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aWP;
        public TextView aWQ;
        public CheckBox aWR;

        private b() {
        }
    }
}
