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
    private com.baidu.tbadk.widget.vote.b aSM;
    private List<b> aTa;
    private int aTb;
    private com.baidu.tbadk.widget.vote.a aTc;
    private List<com.baidu.tbadk.widget.vote.a> aTd;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aSM = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aTb = -1;
        this.aTc = null;
        this.aTd = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aTb = -1;
        this.aTc = null;
        this.aTd = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aTa = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aTd = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aTh = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aTi = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aTi.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.CE(), 15, false));
                    bVar.aTi.setChecked(aVar.isSelected());
                    bVar.aTh.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aTa.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            ai.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aTi.setButtonDrawable(ai.v(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aTe;
        private int aTf;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aTe = aVar;
            this.aTf = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aTa != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aTb == -1 && VoteTextGroupView.this.aTd != null) {
                        int size = VoteTextGroupView.this.aTd.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aTd.get(i);
                            if (aVar != null && this.aTf != i) {
                                ((b) VoteTextGroupView.this.aTa.get(i)).aTi.setChecked(false);
                                if (VoteTextGroupView.this.aSM != null) {
                                    VoteTextGroupView.this.aSM.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aTa.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aTa.get(i2);
                        if (this.aTf == i2) {
                            if (this.aTf != VoteTextGroupView.this.aTb && VoteTextGroupView.this.aTb >= 0 && VoteTextGroupView.this.aTb < VoteTextGroupView.this.aTa.size()) {
                                ((b) VoteTextGroupView.this.aTa.get(VoteTextGroupView.this.aTb)).aTi.setChecked(false);
                                if (VoteTextGroupView.this.aSM != null) {
                                    VoteTextGroupView.this.aSM.a(VoteTextGroupView.this.aTc, VoteTextGroupView.this.aTb, false);
                                }
                            }
                            VoteTextGroupView.this.aTb = this.aTf;
                            VoteTextGroupView.this.aTc = this.aTe;
                            boolean isChecked = bVar.aTi.isChecked();
                            bVar.aTi.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aSM != null) {
                                VoteTextGroupView.this.aSM.a(this.aTe, this.aTf, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aTa.size(); i3++) {
                        if (i3 == this.aTf) {
                            b bVar2 = (b) VoteTextGroupView.this.aTa.get(i3);
                            boolean isChecked2 = bVar2.aTi.isChecked();
                            bVar2.aTi.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aSM != null) {
                                VoteTextGroupView.this.aSM.a(this.aTe, this.aTf, isChecked2 ? false : true);
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
        if (this.aTa != null && !this.aTa.isEmpty()) {
            for (b bVar : this.aTa) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aTh;
        public CheckBox aTi;
        public TextView name;

        private b() {
        }
    }
}
