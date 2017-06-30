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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private List<b> aQF;
    private int aQG;
    private com.baidu.tbadk.widget.vote.a aQH;
    private List<com.baidu.tbadk.widget.vote.a> aQI;
    private com.baidu.tbadk.widget.vote.b aQr;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aQr = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aQG = -1;
        this.aQH = null;
        this.aQI = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aQG = -1;
        this.aQH = null;
        this.aQI = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aQF = new ArrayList();
    }

    public void E(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aQI = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(w.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aQM = (RelativeLayout) inflate.findViewById(w.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(w.h.tv_name);
                    bVar.aQN = (CheckBox) inflate.findViewById(w.h.cb_select);
                    bVar.aQN.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.Ck(), 15, false));
                    bVar.aQN.setChecked(aVar.isSelected());
                    bVar.aQM.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aQF.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            as.c(bVar.name, w.e.cp_cont_b, 1);
            bVar.aQN.setButtonDrawable(as.u(i, w.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aQJ;
        private int aQK;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aQJ = aVar;
            this.aQK = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aQF != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aQF.size(); i++) {
                            if (i == this.aQK) {
                                b bVar = (b) VoteTextGroupView.this.aQF.get(i);
                                boolean isChecked = bVar.aQN.isChecked();
                                bVar.aQN.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aQr != null) {
                                    VoteTextGroupView.this.aQr.a(this.aQJ, this.aQK, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aQG == -1 && VoteTextGroupView.this.aQI != null) {
                    int size = VoteTextGroupView.this.aQI.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aQI.get(i2);
                        if (aVar != null && this.aQK != i2) {
                            ((b) VoteTextGroupView.this.aQF.get(i2)).aQN.setChecked(false);
                            if (VoteTextGroupView.this.aQr != null) {
                                VoteTextGroupView.this.aQr.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aQF.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aQF.get(i3);
                    if (this.aQK == i3) {
                        if (this.aQK != VoteTextGroupView.this.aQG && VoteTextGroupView.this.aQG >= 0 && VoteTextGroupView.this.aQG < VoteTextGroupView.this.aQF.size()) {
                            ((b) VoteTextGroupView.this.aQF.get(VoteTextGroupView.this.aQG)).aQN.setChecked(false);
                            if (VoteTextGroupView.this.aQr != null) {
                                VoteTextGroupView.this.aQr.a(VoteTextGroupView.this.aQH, VoteTextGroupView.this.aQG, false);
                            }
                        }
                        VoteTextGroupView.this.aQG = this.aQK;
                        VoteTextGroupView.this.aQH = this.aQJ;
                        boolean isChecked2 = bVar2.aQN.isChecked();
                        bVar2.aQN.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aQr != null) {
                            VoteTextGroupView.this.aQr.a(this.aQJ, this.aQK, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aQF != null && !this.aQF.isEmpty()) {
            for (b bVar : this.aQF) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aQM;
        public CheckBox aQN;
        public TextView name;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
