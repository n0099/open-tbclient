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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aCP;
    private List<b> aDe;
    private int aDf;
    private com.baidu.tbadk.widget.vote.a aDg;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aCP = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aDf = -1;
        this.aDg = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aDf = -1;
        this.aDg = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aDe = new ArrayList();
    }

    public void t(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(i.g.vote_text_select_item, (ViewGroup) null);
                    bVar.aDk = (RelativeLayout) inflate.findViewById(i.f.root);
                    bVar.aDl = (TextView) inflate.findViewById(i.f.tv_name);
                    bVar.aDm = (CheckBox) inflate.findViewById(i.f.cb_select);
                    bVar.line = inflate.findViewById(i.f.v_line);
                    bVar.aDm.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aDl.setText(UtilHelper.getFixedText(aVar.Fw(), 15, false));
                    bVar.aDm.setChecked(aVar.isSelected());
                    bVar.aDk.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m411getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.line.setVisibility(8);
                    }
                    addView(inflate);
                    this.aDe.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            an.b(bVar.aDl, i.c.cp_cont_b, 1);
            bVar.aDm.setButtonDrawable(an.x(i, i.e.vote_text_check_box));
            an.i(bVar.line, i.c.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aDh;
        private int aDi;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aDh = aVar;
            this.aDi = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aDe != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aDe.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aDe.get(i);
                        if (this.aDi == i) {
                            if (this.aDi != VoteTextGroupView.this.aDf && VoteTextGroupView.this.aDf >= 0 && VoteTextGroupView.this.aDf < VoteTextGroupView.this.aDe.size()) {
                                ((b) VoteTextGroupView.this.aDe.get(VoteTextGroupView.this.aDf)).aDm.setChecked(false);
                                if (VoteTextGroupView.this.aCP != null) {
                                    VoteTextGroupView.this.aCP.a(VoteTextGroupView.this.aDg, VoteTextGroupView.this.aDf, false);
                                }
                            }
                            VoteTextGroupView.this.aDf = this.aDi;
                            VoteTextGroupView.this.aDg = this.aDh;
                            boolean isChecked = bVar.aDm.isChecked();
                            bVar.aDm.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aCP != null) {
                                VoteTextGroupView.this.aCP.a(this.aDh, this.aDi, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aDe.size(); i2++) {
                        if (i2 == this.aDi) {
                            b bVar2 = (b) VoteTextGroupView.this.aDe.get(i2);
                            boolean isChecked2 = bVar2.aDm.isChecked();
                            bVar2.aDm.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aCP != null) {
                                VoteTextGroupView.this.aCP.a(this.aDh, this.aDi, isChecked2 ? false : true);
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
        if (this.aDe != null && !this.aDe.isEmpty()) {
            for (b bVar : this.aDe) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aDk;
        public TextView aDl;
        public CheckBox aDm;
        public View line;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
