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
    private List<b> aEK;
    private int aEL;
    private com.baidu.tbadk.widget.vote.a aEM;
    private com.baidu.tbadk.widget.vote.b aEv;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aEv = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aEL = -1;
        this.aEM = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aEL = -1;
        this.aEM = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aEK = new ArrayList();
    }

    public void t(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(n.g.vote_text_select_item, (ViewGroup) null);
                    bVar.aEQ = (RelativeLayout) inflate.findViewById(n.f.root);
                    bVar.aER = (TextView) inflate.findViewById(n.f.tv_name);
                    bVar.aES = (CheckBox) inflate.findViewById(n.f.cb_select);
                    bVar.line = inflate.findViewById(n.f.v_line);
                    bVar.aES.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aER.setText(UtilHelper.getFixedText(aVar.Gu(), 15, false));
                    bVar.aES.setChecked(aVar.isSelected());
                    bVar.aEQ.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m411getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.line.setVisibility(8);
                    }
                    addView(inflate);
                    this.aEK.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            as.b(bVar.aER, n.c.cp_cont_b, 1);
            bVar.aES.setButtonDrawable(as.x(i, n.e.vote_text_check_box));
            as.i(bVar.line, n.c.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aEN;
        private int aEO;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aEN = aVar;
            this.aEO = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aEK != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aEK.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aEK.get(i);
                        if (this.aEO == i) {
                            if (this.aEO != VoteTextGroupView.this.aEL && VoteTextGroupView.this.aEL >= 0 && VoteTextGroupView.this.aEL < VoteTextGroupView.this.aEK.size()) {
                                ((b) VoteTextGroupView.this.aEK.get(VoteTextGroupView.this.aEL)).aES.setChecked(false);
                                if (VoteTextGroupView.this.aEv != null) {
                                    VoteTextGroupView.this.aEv.a(VoteTextGroupView.this.aEM, VoteTextGroupView.this.aEL, false);
                                }
                            }
                            VoteTextGroupView.this.aEL = this.aEO;
                            VoteTextGroupView.this.aEM = this.aEN;
                            boolean isChecked = bVar.aES.isChecked();
                            bVar.aES.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aEv != null) {
                                VoteTextGroupView.this.aEv.a(this.aEN, this.aEO, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aEK.size(); i2++) {
                        if (i2 == this.aEO) {
                            b bVar2 = (b) VoteTextGroupView.this.aEK.get(i2);
                            boolean isChecked2 = bVar2.aES.isChecked();
                            bVar2.aES.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aEv != null) {
                                VoteTextGroupView.this.aEv.a(this.aEN, this.aEO, isChecked2 ? false : true);
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
        if (this.aEK != null && !this.aEK.isEmpty()) {
            for (b bVar : this.aEK) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aEQ;
        public TextView aER;
        public CheckBox aES;
        public View line;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
