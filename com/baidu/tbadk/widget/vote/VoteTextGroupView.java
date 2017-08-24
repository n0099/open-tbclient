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
    private com.baidu.tbadk.widget.vote.b aSO;
    private List<b> aTc;
    private int aTd;
    private com.baidu.tbadk.widget.vote.a aTe;
    private List<com.baidu.tbadk.widget.vote.a> aTf;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aSO = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aTd = -1;
        this.aTe = null;
        this.aTf = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aTd = -1;
        this.aTe = null;
        this.aTf = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aTc = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aTf = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aTj = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aTk = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aTk.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.CE(), 15, false));
                    bVar.aTk.setChecked(aVar.isSelected());
                    bVar.aTj.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aTc.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            ai.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aTk.setButtonDrawable(ai.v(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aTg;
        private int aTh;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aTg = aVar;
            this.aTh = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aTc != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aTd == -1 && VoteTextGroupView.this.aTf != null) {
                        int size = VoteTextGroupView.this.aTf.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aTf.get(i);
                            if (aVar != null && this.aTh != i) {
                                ((b) VoteTextGroupView.this.aTc.get(i)).aTk.setChecked(false);
                                if (VoteTextGroupView.this.aSO != null) {
                                    VoteTextGroupView.this.aSO.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aTc.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aTc.get(i2);
                        if (this.aTh == i2) {
                            if (this.aTh != VoteTextGroupView.this.aTd && VoteTextGroupView.this.aTd >= 0 && VoteTextGroupView.this.aTd < VoteTextGroupView.this.aTc.size()) {
                                ((b) VoteTextGroupView.this.aTc.get(VoteTextGroupView.this.aTd)).aTk.setChecked(false);
                                if (VoteTextGroupView.this.aSO != null) {
                                    VoteTextGroupView.this.aSO.a(VoteTextGroupView.this.aTe, VoteTextGroupView.this.aTd, false);
                                }
                            }
                            VoteTextGroupView.this.aTd = this.aTh;
                            VoteTextGroupView.this.aTe = this.aTg;
                            boolean isChecked = bVar.aTk.isChecked();
                            bVar.aTk.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aSO != null) {
                                VoteTextGroupView.this.aSO.a(this.aTg, this.aTh, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aTc.size(); i3++) {
                        if (i3 == this.aTh) {
                            b bVar2 = (b) VoteTextGroupView.this.aTc.get(i3);
                            boolean isChecked2 = bVar2.aTk.isChecked();
                            bVar2.aTk.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aSO != null) {
                                VoteTextGroupView.this.aSO.a(this.aTg, this.aTh, isChecked2 ? false : true);
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
        if (this.aTc != null && !this.aTc.isEmpty()) {
            for (b bVar : this.aTc) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aTj;
        public CheckBox aTk;
        public TextView name;

        private b() {
        }
    }
}
