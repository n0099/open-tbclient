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
    private List<b> bMN;
    private int bMO;
    private com.baidu.tbadk.widget.vote.a bMP;
    private List<com.baidu.tbadk.widget.vote.a> bMQ;
    private com.baidu.tbadk.widget.vote.b bMz;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.bMz = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.bMO = -1;
        this.bMP = null;
        this.bMQ = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.bMO = -1;
        this.bMP = null;
        this.bMQ = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.bMN = new ArrayList();
    }

    public void S(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.bMQ = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.bMU = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.bMV = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.bMW = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.bMW.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.bMV.setText(UtilHelper.getFixedText(aVar.KG(), 15, false));
                    bVar.bMW.setChecked(aVar.isSelected());
                    bVar.bMU.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.bMN.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.e(bVar.bMV, d.C0141d.cp_cont_b, 1);
            bVar.bMW.setButtonDrawable(aj.au(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a bMR;
        private int bMS;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.bMR = aVar;
            this.bMS = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.bMN != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.bMO == -1 && VoteTextGroupView.this.bMQ != null) {
                        int size = VoteTextGroupView.this.bMQ.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.bMQ.get(i);
                            if (aVar != null && this.bMS != i) {
                                ((b) VoteTextGroupView.this.bMN.get(i)).bMW.setChecked(false);
                                if (VoteTextGroupView.this.bMz != null) {
                                    VoteTextGroupView.this.bMz.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.bMN.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.bMN.get(i2);
                        if (this.bMS == i2) {
                            if (this.bMS != VoteTextGroupView.this.bMO && VoteTextGroupView.this.bMO >= 0 && VoteTextGroupView.this.bMO < VoteTextGroupView.this.bMN.size()) {
                                ((b) VoteTextGroupView.this.bMN.get(VoteTextGroupView.this.bMO)).bMW.setChecked(false);
                                if (VoteTextGroupView.this.bMz != null) {
                                    VoteTextGroupView.this.bMz.a(VoteTextGroupView.this.bMP, VoteTextGroupView.this.bMO, false);
                                }
                            }
                            VoteTextGroupView.this.bMO = this.bMS;
                            VoteTextGroupView.this.bMP = this.bMR;
                            boolean isChecked = bVar.bMW.isChecked();
                            bVar.bMW.setChecked(!isChecked);
                            if (VoteTextGroupView.this.bMz != null) {
                                VoteTextGroupView.this.bMz.a(this.bMR, this.bMS, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.bMN.size(); i3++) {
                        if (i3 == this.bMS) {
                            b bVar2 = (b) VoteTextGroupView.this.bMN.get(i3);
                            boolean isChecked2 = bVar2.bMW.isChecked();
                            bVar2.bMW.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.bMz != null) {
                                VoteTextGroupView.this.bMz.a(this.bMR, this.bMS, isChecked2 ? false : true);
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
        if (this.bMN != null && !this.bMN.isEmpty()) {
            for (b bVar : this.bMN) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout bMU;
        public TextView bMV;
        public CheckBox bMW;

        private b() {
        }
    }
}
