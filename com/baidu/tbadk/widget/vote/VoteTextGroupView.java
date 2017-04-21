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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aOH;
    private List<b> aOV;
    private int aOW;
    private com.baidu.tbadk.widget.vote.a aOX;
    private List<com.baidu.tbadk.widget.vote.a> aOY;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aOH = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aOW = -1;
        this.aOX = null;
        this.aOY = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aOW = -1;
        this.aOX = null;
        this.aOY = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aOV = new ArrayList();
    }

    public void A(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aOY = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(w.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aPc = (RelativeLayout) inflate.findViewById(w.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(w.h.tv_name);
                    bVar.aPd = (CheckBox) inflate.findViewById(w.h.cb_select);
                    bVar.aPd.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.CR(), 15, false));
                    bVar.aPd.setChecked(aVar.isSelected());
                    bVar.aPc.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aOV.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aq.c(bVar.name, w.e.cp_cont_b, 1);
            bVar.aPd.setButtonDrawable(aq.x(i, w.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aOZ;
        private int aPa;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aOZ = aVar;
            this.aPa = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aOV != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aOV.size(); i++) {
                            if (i == this.aPa) {
                                b bVar = (b) VoteTextGroupView.this.aOV.get(i);
                                boolean isChecked = bVar.aPd.isChecked();
                                bVar.aPd.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aOH != null) {
                                    VoteTextGroupView.this.aOH.a(this.aOZ, this.aPa, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aOW == -1 && VoteTextGroupView.this.aOY != null) {
                    int size = VoteTextGroupView.this.aOY.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aOY.get(i2);
                        if (aVar != null && this.aPa != i2) {
                            ((b) VoteTextGroupView.this.aOV.get(i2)).aPd.setChecked(false);
                            if (VoteTextGroupView.this.aOH != null) {
                                VoteTextGroupView.this.aOH.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aOV.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aOV.get(i3);
                    if (this.aPa == i3) {
                        if (this.aPa != VoteTextGroupView.this.aOW && VoteTextGroupView.this.aOW >= 0 && VoteTextGroupView.this.aOW < VoteTextGroupView.this.aOV.size()) {
                            ((b) VoteTextGroupView.this.aOV.get(VoteTextGroupView.this.aOW)).aPd.setChecked(false);
                            if (VoteTextGroupView.this.aOH != null) {
                                VoteTextGroupView.this.aOH.a(VoteTextGroupView.this.aOX, VoteTextGroupView.this.aOW, false);
                            }
                        }
                        VoteTextGroupView.this.aOW = this.aPa;
                        VoteTextGroupView.this.aOX = this.aOZ;
                        boolean isChecked2 = bVar2.aPd.isChecked();
                        bVar2.aPd.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aOH != null) {
                            VoteTextGroupView.this.aOH.a(this.aOZ, this.aPa, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aOV != null && !this.aOV.isEmpty()) {
            for (b bVar : this.aOV) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aPc;
        public CheckBox aPd;
        public TextView name;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
