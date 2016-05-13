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
    private com.baidu.tbadk.widget.vote.b aFT;
    private List<b> aGi;
    private int aGj;
    private com.baidu.tbadk.widget.vote.a aGk;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aFT = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aGj = -1;
        this.aGk = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aGj = -1;
        this.aGk = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aGi = new ArrayList();
    }

    public void D(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(t.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aGo = (RelativeLayout) inflate.findViewById(t.g.root);
                    bVar.aGp = (TextView) inflate.findViewById(t.g.tv_name);
                    bVar.aGq = (CheckBox) inflate.findViewById(t.g.cb_select);
                    bVar.aGr = inflate.findViewById(t.g.v_line);
                    bVar.aGq.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aGp.setText(UtilHelper.getFixedText(aVar.Hw(), 15, false));
                    bVar.aGq.setChecked(aVar.isSelected());
                    bVar.aGo.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m11getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.aGr.setVisibility(8);
                    }
                    addView(inflate);
                    this.aGi.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            at.c(bVar.aGp, t.d.cp_cont_b, 1);
            bVar.aGq.setButtonDrawable(at.o(i, t.f.vote_text_check_box));
            at.k(bVar.aGr, t.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aGl;
        private int aGm;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aGl = aVar;
            this.aGm = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aGi != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aGi.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aGi.get(i);
                        if (this.aGm == i) {
                            if (this.aGm != VoteTextGroupView.this.aGj && VoteTextGroupView.this.aGj >= 0 && VoteTextGroupView.this.aGj < VoteTextGroupView.this.aGi.size()) {
                                ((b) VoteTextGroupView.this.aGi.get(VoteTextGroupView.this.aGj)).aGq.setChecked(false);
                                if (VoteTextGroupView.this.aFT != null) {
                                    VoteTextGroupView.this.aFT.a(VoteTextGroupView.this.aGk, VoteTextGroupView.this.aGj, false);
                                }
                            }
                            VoteTextGroupView.this.aGj = this.aGm;
                            VoteTextGroupView.this.aGk = this.aGl;
                            boolean isChecked = bVar.aGq.isChecked();
                            bVar.aGq.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aFT != null) {
                                VoteTextGroupView.this.aFT.a(this.aGl, this.aGm, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aGi.size(); i2++) {
                        if (i2 == this.aGm) {
                            b bVar2 = (b) VoteTextGroupView.this.aGi.get(i2);
                            boolean isChecked2 = bVar2.aGq.isChecked();
                            bVar2.aGq.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aFT != null) {
                                VoteTextGroupView.this.aFT.a(this.aGl, this.aGm, isChecked2 ? false : true);
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
        if (this.aGi != null && !this.aGi.isEmpty()) {
            for (b bVar : this.aGi) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aGo;
        public TextView aGp;
        public CheckBox aGq;
        public View aGr;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
