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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aRA;
    private List<b> aRO;
    private int aRP;
    private com.baidu.tbadk.widget.vote.a aRQ;
    private List<com.baidu.tbadk.widget.vote.a> aRR;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aRA = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aRP = -1;
        this.aRQ = null;
        this.aRR = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aRP = -1;
        this.aRQ = null;
        this.aRR = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aRO = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aRR = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aRV = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aRW = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aRW.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.Cw(), 15, false));
                    bVar.aRW.setChecked(aVar.isSelected());
                    bVar.aRV.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aRO.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            ai.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aRW.setButtonDrawable(ai.u(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aRS;
        private int aRT;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aRS = aVar;
            this.aRT = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aRO != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aRP == -1 && VoteTextGroupView.this.aRR != null) {
                        int size = VoteTextGroupView.this.aRR.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aRR.get(i);
                            if (aVar != null && this.aRT != i) {
                                ((b) VoteTextGroupView.this.aRO.get(i)).aRW.setChecked(false);
                                if (VoteTextGroupView.this.aRA != null) {
                                    VoteTextGroupView.this.aRA.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aRO.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aRO.get(i2);
                        if (this.aRT == i2) {
                            if (this.aRT != VoteTextGroupView.this.aRP && VoteTextGroupView.this.aRP >= 0 && VoteTextGroupView.this.aRP < VoteTextGroupView.this.aRO.size()) {
                                ((b) VoteTextGroupView.this.aRO.get(VoteTextGroupView.this.aRP)).aRW.setChecked(false);
                                if (VoteTextGroupView.this.aRA != null) {
                                    VoteTextGroupView.this.aRA.a(VoteTextGroupView.this.aRQ, VoteTextGroupView.this.aRP, false);
                                }
                            }
                            VoteTextGroupView.this.aRP = this.aRT;
                            VoteTextGroupView.this.aRQ = this.aRS;
                            boolean isChecked = bVar.aRW.isChecked();
                            bVar.aRW.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aRA != null) {
                                VoteTextGroupView.this.aRA.a(this.aRS, this.aRT, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aRO.size(); i3++) {
                        if (i3 == this.aRT) {
                            b bVar2 = (b) VoteTextGroupView.this.aRO.get(i3);
                            boolean isChecked2 = bVar2.aRW.isChecked();
                            bVar2.aRW.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aRA != null) {
                                VoteTextGroupView.this.aRA.a(this.aRS, this.aRT, isChecked2 ? false : true);
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
        if (this.aRO != null && !this.aRO.isEmpty()) {
            for (b bVar : this.aRO) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aRV;
        public CheckBox aRW;
        public TextView name;

        private b() {
        }
    }
}
