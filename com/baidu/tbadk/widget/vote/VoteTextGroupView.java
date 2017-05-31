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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aOZ;
    private List<b> aPn;
    private int aPo;
    private com.baidu.tbadk.widget.vote.a aPp;
    private List<com.baidu.tbadk.widget.vote.a> aPq;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aOZ = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aPo = -1;
        this.aPp = null;
        this.aPq = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aPo = -1;
        this.aPp = null;
        this.aPq = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aPn = new ArrayList();
    }

    public void C(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aPq = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(w.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aPu = (RelativeLayout) inflate.findViewById(w.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(w.h.tv_name);
                    bVar.aPv = (CheckBox) inflate.findViewById(w.h.cb_select);
                    bVar.aPv.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.BQ(), 15, false));
                    bVar.aPv.setChecked(aVar.isSelected());
                    bVar.aPu.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aPn.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aq.c(bVar.name, w.e.cp_cont_b, 1);
            bVar.aPv.setButtonDrawable(aq.u(i, w.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aPr;
        private int aPs;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aPr = aVar;
            this.aPs = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aPn != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aPn.size(); i++) {
                            if (i == this.aPs) {
                                b bVar = (b) VoteTextGroupView.this.aPn.get(i);
                                boolean isChecked = bVar.aPv.isChecked();
                                bVar.aPv.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aOZ != null) {
                                    VoteTextGroupView.this.aOZ.a(this.aPr, this.aPs, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aPo == -1 && VoteTextGroupView.this.aPq != null) {
                    int size = VoteTextGroupView.this.aPq.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aPq.get(i2);
                        if (aVar != null && this.aPs != i2) {
                            ((b) VoteTextGroupView.this.aPn.get(i2)).aPv.setChecked(false);
                            if (VoteTextGroupView.this.aOZ != null) {
                                VoteTextGroupView.this.aOZ.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aPn.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aPn.get(i3);
                    if (this.aPs == i3) {
                        if (this.aPs != VoteTextGroupView.this.aPo && VoteTextGroupView.this.aPo >= 0 && VoteTextGroupView.this.aPo < VoteTextGroupView.this.aPn.size()) {
                            ((b) VoteTextGroupView.this.aPn.get(VoteTextGroupView.this.aPo)).aPv.setChecked(false);
                            if (VoteTextGroupView.this.aOZ != null) {
                                VoteTextGroupView.this.aOZ.a(VoteTextGroupView.this.aPp, VoteTextGroupView.this.aPo, false);
                            }
                        }
                        VoteTextGroupView.this.aPo = this.aPs;
                        VoteTextGroupView.this.aPp = this.aPr;
                        boolean isChecked2 = bVar2.aPv.isChecked();
                        bVar2.aPv.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aOZ != null) {
                            VoteTextGroupView.this.aOZ.a(this.aPr, this.aPs, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aPn != null && !this.aPn.isEmpty()) {
            for (b bVar : this.aPn) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aPu;
        public CheckBox aPv;
        public TextView name;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
