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
    private List<b> bKL;
    private int bKM;
    private com.baidu.tbadk.widget.vote.a bKN;
    private List<com.baidu.tbadk.widget.vote.a> bKO;
    private com.baidu.tbadk.widget.vote.b bKx;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.bKx = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.bKM = -1;
        this.bKN = null;
        this.bKO = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.bKM = -1;
        this.bKN = null;
        this.bKO = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.bKL = new ArrayList();
    }

    public void Q(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.bKO = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.bKS = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.bKT = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.bKU = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.bKU.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.bKT.setText(UtilHelper.getFixedText(aVar.JY(), 15, false));
                    bVar.bKU.setChecked(aVar.isSelected());
                    bVar.bKS.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.bKL.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.e(bVar.bKT, d.C0107d.cp_cont_b, 1);
            bVar.bKU.setButtonDrawable(aj.au(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a bKP;
        private int bKQ;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.bKP = aVar;
            this.bKQ = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.bKL != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.bKM == -1 && VoteTextGroupView.this.bKO != null) {
                        int size = VoteTextGroupView.this.bKO.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.bKO.get(i);
                            if (aVar != null && this.bKQ != i) {
                                ((b) VoteTextGroupView.this.bKL.get(i)).bKU.setChecked(false);
                                if (VoteTextGroupView.this.bKx != null) {
                                    VoteTextGroupView.this.bKx.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.bKL.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.bKL.get(i2);
                        if (this.bKQ == i2) {
                            if (this.bKQ != VoteTextGroupView.this.bKM && VoteTextGroupView.this.bKM >= 0 && VoteTextGroupView.this.bKM < VoteTextGroupView.this.bKL.size()) {
                                ((b) VoteTextGroupView.this.bKL.get(VoteTextGroupView.this.bKM)).bKU.setChecked(false);
                                if (VoteTextGroupView.this.bKx != null) {
                                    VoteTextGroupView.this.bKx.a(VoteTextGroupView.this.bKN, VoteTextGroupView.this.bKM, false);
                                }
                            }
                            VoteTextGroupView.this.bKM = this.bKQ;
                            VoteTextGroupView.this.bKN = this.bKP;
                            boolean isChecked = bVar.bKU.isChecked();
                            bVar.bKU.setChecked(!isChecked);
                            if (VoteTextGroupView.this.bKx != null) {
                                VoteTextGroupView.this.bKx.a(this.bKP, this.bKQ, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.bKL.size(); i3++) {
                        if (i3 == this.bKQ) {
                            b bVar2 = (b) VoteTextGroupView.this.bKL.get(i3);
                            boolean isChecked2 = bVar2.bKU.isChecked();
                            bVar2.bKU.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.bKx != null) {
                                VoteTextGroupView.this.bKx.a(this.bKP, this.bKQ, isChecked2 ? false : true);
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
        if (this.bKL != null && !this.bKL.isEmpty()) {
            for (b bVar : this.bKL) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout bKS;
        public TextView bKT;
        public CheckBox bKU;

        private b() {
        }
    }
}
