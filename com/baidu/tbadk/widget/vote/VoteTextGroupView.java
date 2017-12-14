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
    private List<b> aWK;
    private int aWL;
    private com.baidu.tbadk.widget.vote.a aWM;
    private List<com.baidu.tbadk.widget.vote.a> aWN;
    private com.baidu.tbadk.widget.vote.b aWw;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aWw = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aWL = -1;
        this.aWM = null;
        this.aWN = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aWL = -1;
        this.aWM = null;
        this.aWN = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aWK = new ArrayList();
    }

    public void J(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aWN = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aWR = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.aWS = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.aWT = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.aWT.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aWS.setText(UtilHelper.getFixedText(aVar.CI(), 15, false));
                    bVar.aWT.setChecked(aVar.isSelected());
                    bVar.aWR.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aWK.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.aWS, d.C0096d.cp_cont_b, 1);
            bVar.aWT.setButtonDrawable(aj.v(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aWO;
        private int aWP;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aWO = aVar;
            this.aWP = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aWK != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aWL == -1 && VoteTextGroupView.this.aWN != null) {
                        int size = VoteTextGroupView.this.aWN.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aWN.get(i);
                            if (aVar != null && this.aWP != i) {
                                ((b) VoteTextGroupView.this.aWK.get(i)).aWT.setChecked(false);
                                if (VoteTextGroupView.this.aWw != null) {
                                    VoteTextGroupView.this.aWw.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aWK.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aWK.get(i2);
                        if (this.aWP == i2) {
                            if (this.aWP != VoteTextGroupView.this.aWL && VoteTextGroupView.this.aWL >= 0 && VoteTextGroupView.this.aWL < VoteTextGroupView.this.aWK.size()) {
                                ((b) VoteTextGroupView.this.aWK.get(VoteTextGroupView.this.aWL)).aWT.setChecked(false);
                                if (VoteTextGroupView.this.aWw != null) {
                                    VoteTextGroupView.this.aWw.a(VoteTextGroupView.this.aWM, VoteTextGroupView.this.aWL, false);
                                }
                            }
                            VoteTextGroupView.this.aWL = this.aWP;
                            VoteTextGroupView.this.aWM = this.aWO;
                            boolean isChecked = bVar.aWT.isChecked();
                            bVar.aWT.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aWw != null) {
                                VoteTextGroupView.this.aWw.a(this.aWO, this.aWP, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aWK.size(); i3++) {
                        if (i3 == this.aWP) {
                            b bVar2 = (b) VoteTextGroupView.this.aWK.get(i3);
                            boolean isChecked2 = bVar2.aWT.isChecked();
                            bVar2.aWT.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aWw != null) {
                                VoteTextGroupView.this.aWw.a(this.aWO, this.aWP, isChecked2 ? false : true);
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
        if (this.aWK != null && !this.aWK.isEmpty()) {
            for (b bVar : this.aWK) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aWR;
        public TextView aWS;
        public CheckBox aWT;

        private b() {
        }
    }
}
