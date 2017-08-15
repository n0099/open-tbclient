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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aSN;
    private List<b> aTb;
    private int aTc;
    private com.baidu.tbadk.widget.vote.a aTd;
    private List<com.baidu.tbadk.widget.vote.a> aTe;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aSN = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aTc = -1;
        this.aTd = null;
        this.aTe = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aTc = -1;
        this.aTd = null;
        this.aTe = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aTb = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aTe = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aTi = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aTj = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aTj.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.CE(), 15, false));
                    bVar.aTj.setChecked(aVar.isSelected());
                    bVar.aTi.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aTb.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            ai.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aTj.setButtonDrawable(ai.v(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aTf;
        private int aTg;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aTf = aVar;
            this.aTg = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aTb != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aTc == -1 && VoteTextGroupView.this.aTe != null) {
                        int size = VoteTextGroupView.this.aTe.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aTe.get(i);
                            if (aVar != null && this.aTg != i) {
                                ((b) VoteTextGroupView.this.aTb.get(i)).aTj.setChecked(false);
                                if (VoteTextGroupView.this.aSN != null) {
                                    VoteTextGroupView.this.aSN.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aTb.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aTb.get(i2);
                        if (this.aTg == i2) {
                            if (this.aTg != VoteTextGroupView.this.aTc && VoteTextGroupView.this.aTc >= 0 && VoteTextGroupView.this.aTc < VoteTextGroupView.this.aTb.size()) {
                                ((b) VoteTextGroupView.this.aTb.get(VoteTextGroupView.this.aTc)).aTj.setChecked(false);
                                if (VoteTextGroupView.this.aSN != null) {
                                    VoteTextGroupView.this.aSN.a(VoteTextGroupView.this.aTd, VoteTextGroupView.this.aTc, false);
                                }
                            }
                            VoteTextGroupView.this.aTc = this.aTg;
                            VoteTextGroupView.this.aTd = this.aTf;
                            boolean isChecked = bVar.aTj.isChecked();
                            bVar.aTj.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aSN != null) {
                                VoteTextGroupView.this.aSN.a(this.aTf, this.aTg, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aTb.size(); i3++) {
                        if (i3 == this.aTg) {
                            b bVar2 = (b) VoteTextGroupView.this.aTb.get(i3);
                            boolean isChecked2 = bVar2.aTj.isChecked();
                            bVar2.aTj.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aSN != null) {
                                VoteTextGroupView.this.aSN.a(this.aTf, this.aTg, isChecked2 ? false : true);
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
        if (this.aTb != null && !this.aTb.isEmpty()) {
            for (b bVar : this.aTb) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aTi;
        public CheckBox aTj;
        public TextView name;

        private b() {
        }
    }
}
