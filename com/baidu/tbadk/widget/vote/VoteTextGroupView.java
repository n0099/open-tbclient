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
    private List<b> aGK;
    private int aGL;
    private com.baidu.tbadk.widget.vote.a aGM;
    private com.baidu.tbadk.widget.vote.b aGv;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aGv = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aGL = -1;
        this.aGM = null;
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aGL = -1;
        this.aGM = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aGK = new ArrayList();
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
                    bVar.aGQ = (RelativeLayout) inflate.findViewById(u.g.root);
                    bVar.aGR = (TextView) inflate.findViewById(u.g.tv_name);
                    bVar.aGS = (CheckBox) inflate.findViewById(u.g.cb_select);
                    bVar.aGT = inflate.findViewById(u.g.v_line);
                    bVar.aGS.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aGR.setText(UtilHelper.getFixedText(aVar.Hx(), 15, false));
                    bVar.aGS.setChecked(aVar.isSelected());
                    bVar.aGQ.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.aGT.setVisibility(8);
                    }
                    addView(inflate);
                    this.aGK.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            av.c(bVar.aGR, u.d.cp_cont_b, 1);
            bVar.aGS.setButtonDrawable(av.o(i, u.f.vote_text_check_box));
            av.k(bVar.aGT, u.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aGN;
        private int aGO;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aGN = aVar;
            this.aGO = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aGK != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    for (int i = 0; i < VoteTextGroupView.this.aGK.size(); i++) {
                        b bVar = (b) VoteTextGroupView.this.aGK.get(i);
                        if (this.aGO == i) {
                            if (this.aGO != VoteTextGroupView.this.aGL && VoteTextGroupView.this.aGL >= 0 && VoteTextGroupView.this.aGL < VoteTextGroupView.this.aGK.size()) {
                                ((b) VoteTextGroupView.this.aGK.get(VoteTextGroupView.this.aGL)).aGS.setChecked(false);
                                if (VoteTextGroupView.this.aGv != null) {
                                    VoteTextGroupView.this.aGv.a(VoteTextGroupView.this.aGM, VoteTextGroupView.this.aGL, false);
                                }
                            }
                            VoteTextGroupView.this.aGL = this.aGO;
                            VoteTextGroupView.this.aGM = this.aGN;
                            boolean isChecked = bVar.aGS.isChecked();
                            bVar.aGS.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aGv != null) {
                                VoteTextGroupView.this.aGv.a(this.aGN, this.aGO, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aGK.size(); i2++) {
                        if (i2 == this.aGO) {
                            b bVar2 = (b) VoteTextGroupView.this.aGK.get(i2);
                            boolean isChecked2 = bVar2.aGS.isChecked();
                            bVar2.aGS.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aGv != null) {
                                VoteTextGroupView.this.aGv.a(this.aGN, this.aGO, isChecked2 ? false : true);
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
        if (this.aGK != null && !this.aGK.isEmpty()) {
            for (b bVar : this.aGK) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aGQ;
        public TextView aGR;
        public CheckBox aGS;
        public View aGT;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
