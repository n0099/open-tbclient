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
    private com.baidu.tbadk.widget.vote.b bKF;
    private List<b> bKT;
    private int bKU;
    private com.baidu.tbadk.widget.vote.a bKV;
    private List<com.baidu.tbadk.widget.vote.a> bKW;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.bKF = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.bKU = -1;
        this.bKV = null;
        this.bKW = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.bKU = -1;
        this.bKV = null;
        this.bKW = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.bKT = new ArrayList();
    }

    public void Q(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.bKW = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.bLa = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.bLb = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.bLc = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.bLc.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.bLb.setText(UtilHelper.getFixedText(aVar.Ka(), 15, false));
                    bVar.bLc.setChecked(aVar.isSelected());
                    bVar.bLa.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.bKT.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.e(bVar.bLb, d.C0108d.cp_cont_b, 1);
            bVar.bLc.setButtonDrawable(aj.au(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a bKX;
        private int bKY;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.bKX = aVar;
            this.bKY = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.bKT != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.bKU == -1 && VoteTextGroupView.this.bKW != null) {
                        int size = VoteTextGroupView.this.bKW.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.bKW.get(i);
                            if (aVar != null && this.bKY != i) {
                                ((b) VoteTextGroupView.this.bKT.get(i)).bLc.setChecked(false);
                                if (VoteTextGroupView.this.bKF != null) {
                                    VoteTextGroupView.this.bKF.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.bKT.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.bKT.get(i2);
                        if (this.bKY == i2) {
                            if (this.bKY != VoteTextGroupView.this.bKU && VoteTextGroupView.this.bKU >= 0 && VoteTextGroupView.this.bKU < VoteTextGroupView.this.bKT.size()) {
                                ((b) VoteTextGroupView.this.bKT.get(VoteTextGroupView.this.bKU)).bLc.setChecked(false);
                                if (VoteTextGroupView.this.bKF != null) {
                                    VoteTextGroupView.this.bKF.a(VoteTextGroupView.this.bKV, VoteTextGroupView.this.bKU, false);
                                }
                            }
                            VoteTextGroupView.this.bKU = this.bKY;
                            VoteTextGroupView.this.bKV = this.bKX;
                            boolean isChecked = bVar.bLc.isChecked();
                            bVar.bLc.setChecked(!isChecked);
                            if (VoteTextGroupView.this.bKF != null) {
                                VoteTextGroupView.this.bKF.a(this.bKX, this.bKY, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.bKT.size(); i3++) {
                        if (i3 == this.bKY) {
                            b bVar2 = (b) VoteTextGroupView.this.bKT.get(i3);
                            boolean isChecked2 = bVar2.bLc.isChecked();
                            bVar2.bLc.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.bKF != null) {
                                VoteTextGroupView.this.bKF.a(this.bKX, this.bKY, isChecked2 ? false : true);
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
        if (this.bKT != null && !this.bKT.isEmpty()) {
            for (b bVar : this.bKT) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout bLa;
        public TextView bLb;
        public CheckBox bLc;

        private b() {
        }
    }
}
