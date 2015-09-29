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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aCE;
    private List<b> aCT;
    private int aCU;
    private com.baidu.tbadk.widget.vote.a aCV;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aCE = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aCU = -1;
        this.aCV = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aCU = -1;
        this.aCV = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aCT = new ArrayList();
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
                    bVar.aCZ = (RelativeLayout) inflate.findViewById(i.f.root);
                    bVar.aDa = (TextView) inflate.findViewById(i.f.tv_name);
                    bVar.aDb = (CheckBox) inflate.findViewById(i.f.cb_select);
                    bVar.line = inflate.findViewById(i.f.v_line);
                    bVar.aDb.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aDa.setText(UtilHelper.getFixedText(aVar.Fw(), 15, false));
                    bVar.aDb.setChecked(aVar.isSelected());
                    bVar.aCZ.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m411getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.line.setVisibility(8);
                    }
                    addView(inflate);
                    this.aCT.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            am.b(bVar.aDa, i.c.cp_cont_b, 1);
            bVar.aDb.setButtonDrawable(am.x(i, i.e.vote_text_check_box));
            am.i(bVar.line, i.c.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aCW;
        private int aCX;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aCW = aVar;
            this.aCX = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aCT != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aCT.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aCT.get(i);
                        if (this.aCX == i) {
                            if (this.aCX != VoteTextGroupView.this.aCU && VoteTextGroupView.this.aCU >= 0 && VoteTextGroupView.this.aCU < VoteTextGroupView.this.aCT.size()) {
                                ((b) VoteTextGroupView.this.aCT.get(VoteTextGroupView.this.aCU)).aDb.setChecked(false);
                                if (VoteTextGroupView.this.aCE != null) {
                                    VoteTextGroupView.this.aCE.a(VoteTextGroupView.this.aCV, VoteTextGroupView.this.aCU, false);
                                }
                            }
                            VoteTextGroupView.this.aCU = this.aCX;
                            VoteTextGroupView.this.aCV = this.aCW;
                            boolean isChecked = bVar.aDb.isChecked();
                            bVar.aDb.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aCE != null) {
                                VoteTextGroupView.this.aCE.a(this.aCW, this.aCX, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aCT.size(); i2++) {
                        if (i2 == this.aCX) {
                            b bVar2 = (b) VoteTextGroupView.this.aCT.get(i2);
                            boolean isChecked2 = bVar2.aDb.isChecked();
                            bVar2.aDb.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aCE != null) {
                                VoteTextGroupView.this.aCE.a(this.aCW, this.aCX, isChecked2 ? false : true);
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
        if (this.aCT != null && !this.aCT.isEmpty()) {
            for (b bVar : this.aCT) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aCZ;
        public TextView aDa;
        public CheckBox aDb;
        public View line;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
