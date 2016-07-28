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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private List<b> aHB;
    private int aHC;
    private com.baidu.tbadk.widget.vote.a aHD;
    private com.baidu.tbadk.widget.vote.b aHm;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aHm = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aHC = -1;
        this.aHD = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aHC = -1;
        this.aHD = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aHB = new ArrayList();
    }

    public void E(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(u.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aHH = (RelativeLayout) inflate.findViewById(u.g.root);
                    bVar.aHI = (TextView) inflate.findViewById(u.g.tv_name);
                    bVar.aHJ = (CheckBox) inflate.findViewById(u.g.cb_select);
                    bVar.aHK = inflate.findViewById(u.g.v_line);
                    bVar.aHJ.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aHI.setText(UtilHelper.getFixedText(aVar.Hv(), 15, false));
                    bVar.aHJ.setChecked(aVar.isSelected());
                    bVar.aHH.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m10getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.aHK.setVisibility(8);
                    }
                    addView(inflate);
                    this.aHB.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            av.c(bVar.aHI, u.d.cp_cont_b, 1);
            bVar.aHJ.setButtonDrawable(av.o(i, u.f.vote_text_check_box));
            av.k(bVar.aHK, u.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aHE;
        private int aHF;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aHE = aVar;
            this.aHF = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aHB != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aHB.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aHB.get(i);
                        if (this.aHF == i) {
                            if (this.aHF != VoteTextGroupView.this.aHC && VoteTextGroupView.this.aHC >= 0 && VoteTextGroupView.this.aHC < VoteTextGroupView.this.aHB.size()) {
                                ((b) VoteTextGroupView.this.aHB.get(VoteTextGroupView.this.aHC)).aHJ.setChecked(false);
                                if (VoteTextGroupView.this.aHm != null) {
                                    VoteTextGroupView.this.aHm.a(VoteTextGroupView.this.aHD, VoteTextGroupView.this.aHC, false);
                                }
                            }
                            VoteTextGroupView.this.aHC = this.aHF;
                            VoteTextGroupView.this.aHD = this.aHE;
                            boolean isChecked = bVar.aHJ.isChecked();
                            bVar.aHJ.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aHm != null) {
                                VoteTextGroupView.this.aHm.a(this.aHE, this.aHF, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aHB.size(); i2++) {
                        if (i2 == this.aHF) {
                            b bVar2 = (b) VoteTextGroupView.this.aHB.get(i2);
                            boolean isChecked2 = bVar2.aHJ.isChecked();
                            bVar2.aHJ.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aHm != null) {
                                VoteTextGroupView.this.aHm.a(this.aHE, this.aHF, isChecked2 ? false : true);
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
        if (this.aHB != null && !this.aHB.isEmpty()) {
            for (b bVar : this.aHB) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aHH;
        public TextView aHI;
        public CheckBox aHJ;
        public View aHK;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
