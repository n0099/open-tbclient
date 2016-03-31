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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aJK;
    private List<b> aJZ;
    private int aKa;
    private com.baidu.tbadk.widget.vote.a aKb;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aJK = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aKa = -1;
        this.aKb = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aKa = -1;
        this.aKb = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aJZ = new ArrayList();
    }

    public void B(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(t.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aKf = (RelativeLayout) inflate.findViewById(t.g.root);
                    bVar.aKg = (TextView) inflate.findViewById(t.g.tv_name);
                    bVar.aKh = (CheckBox) inflate.findViewById(t.g.cb_select);
                    bVar.aKi = inflate.findViewById(t.g.v_line);
                    bVar.aKh.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aKg.setText(UtilHelper.getFixedText(aVar.Je(), 15, false));
                    bVar.aKh.setChecked(aVar.isSelected());
                    bVar.aKf.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m411getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.aKi.setVisibility(8);
                    }
                    addView(inflate);
                    this.aJZ.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            at.b(bVar.aKg, t.d.cp_cont_b, 1);
            bVar.aKh.setButtonDrawable(at.o(i, t.f.vote_text_check_box));
            at.k(bVar.aKi, t.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aKc;
        private int aKd;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aKc = aVar;
            this.aKd = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aJZ != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aJZ.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aJZ.get(i);
                        if (this.aKd == i) {
                            if (this.aKd != VoteTextGroupView.this.aKa && VoteTextGroupView.this.aKa >= 0 && VoteTextGroupView.this.aKa < VoteTextGroupView.this.aJZ.size()) {
                                ((b) VoteTextGroupView.this.aJZ.get(VoteTextGroupView.this.aKa)).aKh.setChecked(false);
                                if (VoteTextGroupView.this.aJK != null) {
                                    VoteTextGroupView.this.aJK.a(VoteTextGroupView.this.aKb, VoteTextGroupView.this.aKa, false);
                                }
                            }
                            VoteTextGroupView.this.aKa = this.aKd;
                            VoteTextGroupView.this.aKb = this.aKc;
                            boolean isChecked = bVar.aKh.isChecked();
                            bVar.aKh.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aJK != null) {
                                VoteTextGroupView.this.aJK.a(this.aKc, this.aKd, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aJZ.size(); i2++) {
                        if (i2 == this.aKd) {
                            b bVar2 = (b) VoteTextGroupView.this.aJZ.get(i2);
                            boolean isChecked2 = bVar2.aKh.isChecked();
                            bVar2.aKh.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aJK != null) {
                                VoteTextGroupView.this.aJK.a(this.aKc, this.aKd, isChecked2 ? false : true);
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
        if (this.aJZ != null && !this.aJZ.isEmpty()) {
            for (b bVar : this.aJZ) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aKf;
        public TextView aKg;
        public CheckBox aKh;
        public View aKi;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
