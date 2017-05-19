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
    private com.baidu.tbadk.widget.vote.b aPa;
    private List<b> aPo;
    private int aPp;
    private com.baidu.tbadk.widget.vote.a aPq;
    private List<com.baidu.tbadk.widget.vote.a> aPr;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aPa = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aPp = -1;
        this.aPq = null;
        this.aPr = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aPp = -1;
        this.aPq = null;
        this.aPr = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aPo = new ArrayList();
    }

    public void C(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aPr = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(w.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aPv = (RelativeLayout) inflate.findViewById(w.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(w.h.tv_name);
                    bVar.aPw = (CheckBox) inflate.findViewById(w.h.cb_select);
                    bVar.aPw.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.BW(), 15, false));
                    bVar.aPw.setChecked(aVar.isSelected());
                    bVar.aPv.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aPo.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aq.c(bVar.name, w.e.cp_cont_b, 1);
            bVar.aPw.setButtonDrawable(aq.v(i, w.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aPs;
        private int aPt;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aPs = aVar;
            this.aPt = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aPo != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aPo.size(); i++) {
                            if (i == this.aPt) {
                                b bVar = (b) VoteTextGroupView.this.aPo.get(i);
                                boolean isChecked = bVar.aPw.isChecked();
                                bVar.aPw.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aPa != null) {
                                    VoteTextGroupView.this.aPa.a(this.aPs, this.aPt, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aPp == -1 && VoteTextGroupView.this.aPr != null) {
                    int size = VoteTextGroupView.this.aPr.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aPr.get(i2);
                        if (aVar != null && this.aPt != i2) {
                            ((b) VoteTextGroupView.this.aPo.get(i2)).aPw.setChecked(false);
                            if (VoteTextGroupView.this.aPa != null) {
                                VoteTextGroupView.this.aPa.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aPo.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aPo.get(i3);
                    if (this.aPt == i3) {
                        if (this.aPt != VoteTextGroupView.this.aPp && VoteTextGroupView.this.aPp >= 0 && VoteTextGroupView.this.aPp < VoteTextGroupView.this.aPo.size()) {
                            ((b) VoteTextGroupView.this.aPo.get(VoteTextGroupView.this.aPp)).aPw.setChecked(false);
                            if (VoteTextGroupView.this.aPa != null) {
                                VoteTextGroupView.this.aPa.a(VoteTextGroupView.this.aPq, VoteTextGroupView.this.aPp, false);
                            }
                        }
                        VoteTextGroupView.this.aPp = this.aPt;
                        VoteTextGroupView.this.aPq = this.aPs;
                        boolean isChecked2 = bVar2.aPw.isChecked();
                        bVar2.aPw.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aPa != null) {
                            VoteTextGroupView.this.aPa.a(this.aPs, this.aPt, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aPo != null && !this.aPo.isEmpty()) {
            for (b bVar : this.aPo) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aPv;
        public CheckBox aPw;
        public TextView name;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
