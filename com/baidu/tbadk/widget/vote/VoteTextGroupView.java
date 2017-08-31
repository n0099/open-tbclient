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
    private List<b> aSM;
    private int aSN;
    private com.baidu.tbadk.widget.vote.a aSO;
    private List<com.baidu.tbadk.widget.vote.a> aSP;
    private com.baidu.tbadk.widget.vote.b aSy;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aSy = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aSN = -1;
        this.aSO = null;
        this.aSP = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aSN = -1;
        this.aSO = null;
        this.aSP = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aSM = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aSP = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aST = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aSU = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aSU.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.Cz(), 15, false));
                    bVar.aSU.setChecked(aVar.isSelected());
                    bVar.aST.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aSM.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aSU.setButtonDrawable(aj.u(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aSQ;
        private int aSR;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aSQ = aVar;
            this.aSR = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aSM != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aSN == -1 && VoteTextGroupView.this.aSP != null) {
                        int size = VoteTextGroupView.this.aSP.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aSP.get(i);
                            if (aVar != null && this.aSR != i) {
                                ((b) VoteTextGroupView.this.aSM.get(i)).aSU.setChecked(false);
                                if (VoteTextGroupView.this.aSy != null) {
                                    VoteTextGroupView.this.aSy.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aSM.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aSM.get(i2);
                        if (this.aSR == i2) {
                            if (this.aSR != VoteTextGroupView.this.aSN && VoteTextGroupView.this.aSN >= 0 && VoteTextGroupView.this.aSN < VoteTextGroupView.this.aSM.size()) {
                                ((b) VoteTextGroupView.this.aSM.get(VoteTextGroupView.this.aSN)).aSU.setChecked(false);
                                if (VoteTextGroupView.this.aSy != null) {
                                    VoteTextGroupView.this.aSy.a(VoteTextGroupView.this.aSO, VoteTextGroupView.this.aSN, false);
                                }
                            }
                            VoteTextGroupView.this.aSN = this.aSR;
                            VoteTextGroupView.this.aSO = this.aSQ;
                            boolean isChecked = bVar.aSU.isChecked();
                            bVar.aSU.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aSy != null) {
                                VoteTextGroupView.this.aSy.a(this.aSQ, this.aSR, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aSM.size(); i3++) {
                        if (i3 == this.aSR) {
                            b bVar2 = (b) VoteTextGroupView.this.aSM.get(i3);
                            boolean isChecked2 = bVar2.aSU.isChecked();
                            bVar2.aSU.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aSy != null) {
                                VoteTextGroupView.this.aSy.a(this.aSQ, this.aSR, isChecked2 ? false : true);
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
        if (this.aSM != null && !this.aSM.isEmpty()) {
            for (b bVar : this.aSM) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aST;
        public CheckBox aSU;
        public TextView name;

        private b() {
        }
    }
}
