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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aGO;
    private List<b> aHd;
    private int aHe;
    private com.baidu.tbadk.widget.vote.a aHf;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aGO = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aHe = -1;
        this.aHf = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aHe = -1;
        this.aHf = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aHd = new ArrayList();
    }

    public void y(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(t.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aHj = (RelativeLayout) inflate.findViewById(t.g.root);
                    bVar.aHk = (TextView) inflate.findViewById(t.g.tv_name);
                    bVar.aHl = (CheckBox) inflate.findViewById(t.g.cb_select);
                    bVar.aHm = inflate.findViewById(t.g.v_line);
                    bVar.aHl.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aHk.setText(UtilHelper.getFixedText(aVar.HI(), 15, false));
                    bVar.aHl.setChecked(aVar.isSelected());
                    bVar.aHj.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m411getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.aHm.setVisibility(8);
                    }
                    addView(inflate);
                    this.aHd.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            ar.b(bVar.aHk, t.d.cp_cont_b, 1);
            bVar.aHl.setButtonDrawable(ar.s(i, t.f.vote_text_check_box));
            ar.k(bVar.aHm, t.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aHg;
        private int aHh;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aHg = aVar;
            this.aHh = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aHd != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aHd.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aHd.get(i);
                        if (this.aHh == i) {
                            if (this.aHh != VoteTextGroupView.this.aHe && VoteTextGroupView.this.aHe >= 0 && VoteTextGroupView.this.aHe < VoteTextGroupView.this.aHd.size()) {
                                ((b) VoteTextGroupView.this.aHd.get(VoteTextGroupView.this.aHe)).aHl.setChecked(false);
                                if (VoteTextGroupView.this.aGO != null) {
                                    VoteTextGroupView.this.aGO.a(VoteTextGroupView.this.aHf, VoteTextGroupView.this.aHe, false);
                                }
                            }
                            VoteTextGroupView.this.aHe = this.aHh;
                            VoteTextGroupView.this.aHf = this.aHg;
                            boolean isChecked = bVar.aHl.isChecked();
                            bVar.aHl.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aGO != null) {
                                VoteTextGroupView.this.aGO.a(this.aHg, this.aHh, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aHd.size(); i2++) {
                        if (i2 == this.aHh) {
                            b bVar2 = (b) VoteTextGroupView.this.aHd.get(i2);
                            boolean isChecked2 = bVar2.aHl.isChecked();
                            bVar2.aHl.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aGO != null) {
                                VoteTextGroupView.this.aGO.a(this.aHg, this.aHh, isChecked2 ? false : true);
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
        if (this.aHd != null && !this.aHd.isEmpty()) {
            for (b bVar : this.aHd) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aHj;
        public TextView aHk;
        public CheckBox aHl;
        public View aHm;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
