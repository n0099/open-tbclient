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
    private List<b> bKD;
    private int bKE;
    private com.baidu.tbadk.widget.vote.a bKF;
    private List<com.baidu.tbadk.widget.vote.a> bKG;
    private com.baidu.tbadk.widget.vote.b bKp;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.bKp = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.bKE = -1;
        this.bKF = null;
        this.bKG = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.bKE = -1;
        this.bKF = null;
        this.bKG = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.bKD = new ArrayList();
    }

    public void S(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.bKG = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.bKK = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.bKL = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.bKM = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.bKM.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.bKL.setText(UtilHelper.getFixedText(aVar.Kj(), 15, false));
                    bVar.bKM.setChecked(aVar.isSelected());
                    bVar.bKK.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.bKD.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.e(bVar.bKL, d.C0108d.cp_cont_b, 1);
            bVar.bKM.setButtonDrawable(aj.au(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a bKH;
        private int bKI;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.bKH = aVar;
            this.bKI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.bKD != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.bKE == -1 && VoteTextGroupView.this.bKG != null) {
                        int size = VoteTextGroupView.this.bKG.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.bKG.get(i);
                            if (aVar != null && this.bKI != i) {
                                ((b) VoteTextGroupView.this.bKD.get(i)).bKM.setChecked(false);
                                if (VoteTextGroupView.this.bKp != null) {
                                    VoteTextGroupView.this.bKp.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.bKD.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.bKD.get(i2);
                        if (this.bKI == i2) {
                            if (this.bKI != VoteTextGroupView.this.bKE && VoteTextGroupView.this.bKE >= 0 && VoteTextGroupView.this.bKE < VoteTextGroupView.this.bKD.size()) {
                                ((b) VoteTextGroupView.this.bKD.get(VoteTextGroupView.this.bKE)).bKM.setChecked(false);
                                if (VoteTextGroupView.this.bKp != null) {
                                    VoteTextGroupView.this.bKp.a(VoteTextGroupView.this.bKF, VoteTextGroupView.this.bKE, false);
                                }
                            }
                            VoteTextGroupView.this.bKE = this.bKI;
                            VoteTextGroupView.this.bKF = this.bKH;
                            boolean isChecked = bVar.bKM.isChecked();
                            bVar.bKM.setChecked(!isChecked);
                            if (VoteTextGroupView.this.bKp != null) {
                                VoteTextGroupView.this.bKp.a(this.bKH, this.bKI, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.bKD.size(); i3++) {
                        if (i3 == this.bKI) {
                            b bVar2 = (b) VoteTextGroupView.this.bKD.get(i3);
                            boolean isChecked2 = bVar2.bKM.isChecked();
                            bVar2.bKM.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.bKp != null) {
                                VoteTextGroupView.this.bKp.a(this.bKH, this.bKI, isChecked2 ? false : true);
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
        if (this.bKD != null && !this.bKD.isEmpty()) {
            for (b bVar : this.bKD) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout bKK;
        public TextView bKL;
        public CheckBox bKM;

        private b() {
        }
    }
}
