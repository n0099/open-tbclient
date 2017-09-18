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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private List<b> aSJ;
    private int aSK;
    private com.baidu.tbadk.widget.vote.a aSL;
    private List<com.baidu.tbadk.widget.vote.a> aSM;
    private com.baidu.tbadk.widget.vote.b aSv;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aSv = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aSK = -1;
        this.aSL = null;
        this.aSM = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aSK = -1;
        this.aSL = null;
        this.aSM = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aSJ = new ArrayList();
    }

    public void I(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aSM = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aSQ = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aSR = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aSR.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.Cz(), 15, false));
                    bVar.aSR.setChecked(aVar.isSelected());
                    bVar.aSQ.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aSJ.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aSR.setButtonDrawable(aj.u(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aSN;
        private int aSO;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aSN = aVar;
            this.aSO = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aSJ != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aSK == -1 && VoteTextGroupView.this.aSM != null) {
                        int size = VoteTextGroupView.this.aSM.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aSM.get(i);
                            if (aVar != null && this.aSO != i) {
                                ((b) VoteTextGroupView.this.aSJ.get(i)).aSR.setChecked(false);
                                if (VoteTextGroupView.this.aSv != null) {
                                    VoteTextGroupView.this.aSv.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aSJ.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aSJ.get(i2);
                        if (this.aSO == i2) {
                            if (this.aSO != VoteTextGroupView.this.aSK && VoteTextGroupView.this.aSK >= 0 && VoteTextGroupView.this.aSK < VoteTextGroupView.this.aSJ.size()) {
                                ((b) VoteTextGroupView.this.aSJ.get(VoteTextGroupView.this.aSK)).aSR.setChecked(false);
                                if (VoteTextGroupView.this.aSv != null) {
                                    VoteTextGroupView.this.aSv.a(VoteTextGroupView.this.aSL, VoteTextGroupView.this.aSK, false);
                                }
                            }
                            VoteTextGroupView.this.aSK = this.aSO;
                            VoteTextGroupView.this.aSL = this.aSN;
                            boolean isChecked = bVar.aSR.isChecked();
                            bVar.aSR.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aSv != null) {
                                VoteTextGroupView.this.aSv.a(this.aSN, this.aSO, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aSJ.size(); i3++) {
                        if (i3 == this.aSO) {
                            b bVar2 = (b) VoteTextGroupView.this.aSJ.get(i3);
                            boolean isChecked2 = bVar2.aSR.isChecked();
                            bVar2.aSR.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aSv != null) {
                                VoteTextGroupView.this.aSv.a(this.aSN, this.aSO, isChecked2 ? false : true);
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
        if (this.aSJ != null && !this.aSJ.isEmpty()) {
            for (b bVar : this.aSJ) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aSQ;
        public CheckBox aSR;
        public TextView name;

        private b() {
        }
    }
}
