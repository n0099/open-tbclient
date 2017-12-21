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
    private com.baidu.tbadk.widget.vote.b aWA;
    private List<b> aWO;
    private int aWP;
    private com.baidu.tbadk.widget.vote.a aWQ;
    private List<com.baidu.tbadk.widget.vote.a> aWR;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aWA = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aWP = -1;
        this.aWQ = null;
        this.aWR = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aWP = -1;
        this.aWQ = null;
        this.aWR = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aWO = new ArrayList();
    }

    public void J(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aWR = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aWV = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.aWW = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.aWX = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.aWX.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aWW.setText(UtilHelper.getFixedText(aVar.CI(), 15, false));
                    bVar.aWX.setChecked(aVar.isSelected());
                    bVar.aWV.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aWO.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.aWW, d.C0095d.cp_cont_b, 1);
            bVar.aWX.setButtonDrawable(aj.v(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aWS;
        private int aWT;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aWS = aVar;
            this.aWT = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aWO != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aWP == -1 && VoteTextGroupView.this.aWR != null) {
                        int size = VoteTextGroupView.this.aWR.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aWR.get(i);
                            if (aVar != null && this.aWT != i) {
                                ((b) VoteTextGroupView.this.aWO.get(i)).aWX.setChecked(false);
                                if (VoteTextGroupView.this.aWA != null) {
                                    VoteTextGroupView.this.aWA.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aWO.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aWO.get(i2);
                        if (this.aWT == i2) {
                            if (this.aWT != VoteTextGroupView.this.aWP && VoteTextGroupView.this.aWP >= 0 && VoteTextGroupView.this.aWP < VoteTextGroupView.this.aWO.size()) {
                                ((b) VoteTextGroupView.this.aWO.get(VoteTextGroupView.this.aWP)).aWX.setChecked(false);
                                if (VoteTextGroupView.this.aWA != null) {
                                    VoteTextGroupView.this.aWA.a(VoteTextGroupView.this.aWQ, VoteTextGroupView.this.aWP, false);
                                }
                            }
                            VoteTextGroupView.this.aWP = this.aWT;
                            VoteTextGroupView.this.aWQ = this.aWS;
                            boolean isChecked = bVar.aWX.isChecked();
                            bVar.aWX.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aWA != null) {
                                VoteTextGroupView.this.aWA.a(this.aWS, this.aWT, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aWO.size(); i3++) {
                        if (i3 == this.aWT) {
                            b bVar2 = (b) VoteTextGroupView.this.aWO.get(i3);
                            boolean isChecked2 = bVar2.aWX.isChecked();
                            bVar2.aWX.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aWA != null) {
                                VoteTextGroupView.this.aWA.a(this.aWS, this.aWT, isChecked2 ? false : true);
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
        if (this.aWO != null && !this.aWO.isEmpty()) {
            for (b bVar : this.aWO) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aWV;
        public TextView aWW;
        public CheckBox aWX;

        private b() {
        }
    }
}
