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
    private com.baidu.tbadk.widget.vote.b aBJ;
    private List<b> aBY;
    private int aBZ;
    private com.baidu.tbadk.widget.vote.a aCa;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aBJ = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aBZ = -1;
        this.aCa = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aBZ = -1;
        this.aCa = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aBY = new ArrayList();
    }

    public void u(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            for (int i = 0; i < list.size(); i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(i.g.vote_text_select_item, (ViewGroup) null);
                    bVar.aCe = (RelativeLayout) inflate.findViewById(i.f.root);
                    bVar.aCf = (TextView) inflate.findViewById(i.f.tv_name);
                    bVar.aCg = (CheckBox) inflate.findViewById(i.f.cb_select);
                    bVar.line = inflate.findViewById(i.f.v_line);
                    bVar.aCg.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aCf.setText(UtilHelper.getFixedText(aVar.Fp(), 15, false));
                    bVar.aCg.setChecked(aVar.isSelected());
                    bVar.aCe.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m411getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.line.setVisibility(8);
                    }
                    addView(inflate);
                    this.aBY.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            an.b(bVar.aCf, i.c.cp_cont_b, 1);
            bVar.aCg.setButtonDrawable(an.x(i, i.e.vote_text_check_box));
            an.i(bVar.line, i.c.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aCb;
        private int aCc;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aCb = aVar;
            this.aCc = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aBY != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aBY.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aBY.get(i);
                        if (this.aCc == i) {
                            if (this.aCc != VoteTextGroupView.this.aBZ && VoteTextGroupView.this.aBZ >= 0 && VoteTextGroupView.this.aBZ < VoteTextGroupView.this.aBY.size()) {
                                ((b) VoteTextGroupView.this.aBY.get(VoteTextGroupView.this.aBZ)).aCg.setChecked(false);
                                if (VoteTextGroupView.this.aBJ != null) {
                                    VoteTextGroupView.this.aBJ.a(VoteTextGroupView.this.aCa, VoteTextGroupView.this.aBZ, false);
                                }
                            }
                            VoteTextGroupView.this.aBZ = this.aCc;
                            VoteTextGroupView.this.aCa = this.aCb;
                            boolean isChecked = bVar.aCg.isChecked();
                            bVar.aCg.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aBJ != null) {
                                VoteTextGroupView.this.aBJ.a(this.aCb, this.aCc, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aBY.size(); i2++) {
                        if (i2 == this.aCc) {
                            b bVar2 = (b) VoteTextGroupView.this.aBY.get(i2);
                            boolean isChecked2 = bVar2.aCg.isChecked();
                            bVar2.aCg.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aBJ != null) {
                                VoteTextGroupView.this.aBJ.a(this.aCb, this.aCc, isChecked2 ? false : true);
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
        if (this.aBY != null && !this.aBY.isEmpty()) {
            for (b bVar : this.aBY) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aCe;
        public TextView aCf;
        public CheckBox aCg;
        public View line;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
