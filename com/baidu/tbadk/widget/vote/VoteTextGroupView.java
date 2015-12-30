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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aFV;
    private List<b> aGk;
    private int aGl;
    private com.baidu.tbadk.widget.vote.a aGm;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aFV = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aGl = -1;
        this.aGm = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aGl = -1;
        this.aGm = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aGk = new ArrayList();
    }

    public void u(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(n.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aGq = (RelativeLayout) inflate.findViewById(n.g.root);
                    bVar.aGr = (TextView) inflate.findViewById(n.g.tv_name);
                    bVar.aGs = (CheckBox) inflate.findViewById(n.g.cb_select);
                    bVar.line = inflate.findViewById(n.g.v_line);
                    bVar.aGs.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aGr.setText(UtilHelper.getFixedText(aVar.Gj(), 15, false));
                    bVar.aGs.setChecked(aVar.isSelected());
                    bVar.aGq.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m411getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.line.setVisibility(8);
                    }
                    addView(inflate);
                    this.aGk.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            as.b(bVar.aGr, n.d.cp_cont_b, 1);
            bVar.aGs.setButtonDrawable(as.w(i, n.f.vote_text_check_box));
            as.i(bVar.line, n.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aGn;
        private int aGo;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aGn = aVar;
            this.aGo = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aGk != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aGk.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aGk.get(i);
                        if (this.aGo == i) {
                            if (this.aGo != VoteTextGroupView.this.aGl && VoteTextGroupView.this.aGl >= 0 && VoteTextGroupView.this.aGl < VoteTextGroupView.this.aGk.size()) {
                                ((b) VoteTextGroupView.this.aGk.get(VoteTextGroupView.this.aGl)).aGs.setChecked(false);
                                if (VoteTextGroupView.this.aFV != null) {
                                    VoteTextGroupView.this.aFV.a(VoteTextGroupView.this.aGm, VoteTextGroupView.this.aGl, false);
                                }
                            }
                            VoteTextGroupView.this.aGl = this.aGo;
                            VoteTextGroupView.this.aGm = this.aGn;
                            boolean isChecked = bVar.aGs.isChecked();
                            bVar.aGs.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aFV != null) {
                                VoteTextGroupView.this.aFV.a(this.aGn, this.aGo, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aGk.size(); i2++) {
                        if (i2 == this.aGo) {
                            b bVar2 = (b) VoteTextGroupView.this.aGk.get(i2);
                            boolean isChecked2 = bVar2.aGs.isChecked();
                            bVar2.aGs.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aFV != null) {
                                VoteTextGroupView.this.aFV.a(this.aGn, this.aGo, isChecked2 ? false : true);
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
        if (this.aGk != null && !this.aGk.isEmpty()) {
            for (b bVar : this.aGk) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aGq;
        public TextView aGr;
        public CheckBox aGs;
        public View line;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
