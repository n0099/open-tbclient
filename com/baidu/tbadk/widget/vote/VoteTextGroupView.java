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
    private List<b> bMK;
    private int bML;
    private com.baidu.tbadk.widget.vote.a bMM;
    private List<com.baidu.tbadk.widget.vote.a> bMN;
    private com.baidu.tbadk.widget.vote.b bMw;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.bMw = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.bML = -1;
        this.bMM = null;
        this.bMN = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.bML = -1;
        this.bMM = null;
        this.bMN = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.bMK = new ArrayList();
    }

    public void S(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.bMN = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.bMR = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.bMS = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.bMT = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.bMT.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.bMS.setText(UtilHelper.getFixedText(aVar.KF(), 15, false));
                    bVar.bMT.setChecked(aVar.isSelected());
                    bVar.bMR.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.bMK.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.e(bVar.bMS, d.C0141d.cp_cont_b, 1);
            bVar.bMT.setButtonDrawable(aj.au(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a bMO;
        private int bMP;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.bMO = aVar;
            this.bMP = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.bMK != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.bML == -1 && VoteTextGroupView.this.bMN != null) {
                        int size = VoteTextGroupView.this.bMN.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.bMN.get(i);
                            if (aVar != null && this.bMP != i) {
                                ((b) VoteTextGroupView.this.bMK.get(i)).bMT.setChecked(false);
                                if (VoteTextGroupView.this.bMw != null) {
                                    VoteTextGroupView.this.bMw.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.bMK.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.bMK.get(i2);
                        if (this.bMP == i2) {
                            if (this.bMP != VoteTextGroupView.this.bML && VoteTextGroupView.this.bML >= 0 && VoteTextGroupView.this.bML < VoteTextGroupView.this.bMK.size()) {
                                ((b) VoteTextGroupView.this.bMK.get(VoteTextGroupView.this.bML)).bMT.setChecked(false);
                                if (VoteTextGroupView.this.bMw != null) {
                                    VoteTextGroupView.this.bMw.a(VoteTextGroupView.this.bMM, VoteTextGroupView.this.bML, false);
                                }
                            }
                            VoteTextGroupView.this.bML = this.bMP;
                            VoteTextGroupView.this.bMM = this.bMO;
                            boolean isChecked = bVar.bMT.isChecked();
                            bVar.bMT.setChecked(!isChecked);
                            if (VoteTextGroupView.this.bMw != null) {
                                VoteTextGroupView.this.bMw.a(this.bMO, this.bMP, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.bMK.size(); i3++) {
                        if (i3 == this.bMP) {
                            b bVar2 = (b) VoteTextGroupView.this.bMK.get(i3);
                            boolean isChecked2 = bVar2.bMT.isChecked();
                            bVar2.bMT.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.bMw != null) {
                                VoteTextGroupView.this.bMw.a(this.bMO, this.bMP, isChecked2 ? false : true);
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
        if (this.bMK != null && !this.bMK.isEmpty()) {
            for (b bVar : this.bMK) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout bMR;
        public TextView bMS;
        public CheckBox bMT;

        private b() {
        }
    }
}
