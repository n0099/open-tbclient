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
    private int aTA;
    private com.baidu.tbadk.widget.vote.a aTB;
    private List<com.baidu.tbadk.widget.vote.a> aTC;
    private com.baidu.tbadk.widget.vote.b aTl;
    private List<b> aTz;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aTl = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aTA = -1;
        this.aTB = null;
        this.aTC = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aTA = -1;
        this.aTB = null;
        this.aTC = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aTz = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aTC = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aTG = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.aTH = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.aTI = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.aTI.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aTH.setText(UtilHelper.getFixedText(aVar.Cm(), 15, false));
                    bVar.aTI.setChecked(aVar.isSelected());
                    bVar.aTG.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aTz.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.aTH, d.C0080d.cp_cont_b, 1);
            bVar.aTI.setButtonDrawable(aj.u(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aTD;
        private int aTE;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aTD = aVar;
            this.aTE = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aTz != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aTA == -1 && VoteTextGroupView.this.aTC != null) {
                        int size = VoteTextGroupView.this.aTC.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aTC.get(i);
                            if (aVar != null && this.aTE != i) {
                                ((b) VoteTextGroupView.this.aTz.get(i)).aTI.setChecked(false);
                                if (VoteTextGroupView.this.aTl != null) {
                                    VoteTextGroupView.this.aTl.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aTz.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aTz.get(i2);
                        if (this.aTE == i2) {
                            if (this.aTE != VoteTextGroupView.this.aTA && VoteTextGroupView.this.aTA >= 0 && VoteTextGroupView.this.aTA < VoteTextGroupView.this.aTz.size()) {
                                ((b) VoteTextGroupView.this.aTz.get(VoteTextGroupView.this.aTA)).aTI.setChecked(false);
                                if (VoteTextGroupView.this.aTl != null) {
                                    VoteTextGroupView.this.aTl.a(VoteTextGroupView.this.aTB, VoteTextGroupView.this.aTA, false);
                                }
                            }
                            VoteTextGroupView.this.aTA = this.aTE;
                            VoteTextGroupView.this.aTB = this.aTD;
                            boolean isChecked = bVar.aTI.isChecked();
                            bVar.aTI.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aTl != null) {
                                VoteTextGroupView.this.aTl.a(this.aTD, this.aTE, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aTz.size(); i3++) {
                        if (i3 == this.aTE) {
                            b bVar2 = (b) VoteTextGroupView.this.aTz.get(i3);
                            boolean isChecked2 = bVar2.aTI.isChecked();
                            bVar2.aTI.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aTl != null) {
                                VoteTextGroupView.this.aTl.a(this.aTD, this.aTE, isChecked2 ? false : true);
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
        if (this.aTz != null && !this.aTz.isEmpty()) {
            for (b bVar : this.aTz) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aTG;
        public TextView aTH;
        public CheckBox aTI;

        private b() {
        }
    }
}
