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
    private com.baidu.tbadk.widget.vote.b bMJ;
    private List<b> bMX;
    private int bMY;
    private com.baidu.tbadk.widget.vote.a bMZ;
    private List<com.baidu.tbadk.widget.vote.a> bNa;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.bMJ = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.bMY = -1;
        this.bMZ = null;
        this.bNa = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.bMY = -1;
        this.bMZ = null;
        this.bNa = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.bMX = new ArrayList();
    }

    public void S(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.bNa = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.h.vote_text_select_item, (ViewGroup) null);
                    bVar.bNe = (RelativeLayout) inflate.findViewById(d.g.root_pb_vote);
                    bVar.bNf = (TextView) inflate.findViewById(d.g.tv_name);
                    bVar.bNg = (CheckBox) inflate.findViewById(d.g.cb_select);
                    bVar.bNg.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.bNf.setText(UtilHelper.getFixedText(aVar.KG(), 15, false));
                    bVar.bNg.setChecked(aVar.isSelected());
                    bVar.bNe.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.bMX.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.e(bVar.bNf, d.C0140d.cp_cont_b, 1);
            bVar.bNg.setButtonDrawable(aj.au(i, d.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a bNb;
        private int bNc;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.bNb = aVar;
            this.bNc = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.bMX != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.bMY == -1 && VoteTextGroupView.this.bNa != null) {
                        int size = VoteTextGroupView.this.bNa.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.bNa.get(i);
                            if (aVar != null && this.bNc != i) {
                                ((b) VoteTextGroupView.this.bMX.get(i)).bNg.setChecked(false);
                                if (VoteTextGroupView.this.bMJ != null) {
                                    VoteTextGroupView.this.bMJ.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.bMX.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.bMX.get(i2);
                        if (this.bNc == i2) {
                            if (this.bNc != VoteTextGroupView.this.bMY && VoteTextGroupView.this.bMY >= 0 && VoteTextGroupView.this.bMY < VoteTextGroupView.this.bMX.size()) {
                                ((b) VoteTextGroupView.this.bMX.get(VoteTextGroupView.this.bMY)).bNg.setChecked(false);
                                if (VoteTextGroupView.this.bMJ != null) {
                                    VoteTextGroupView.this.bMJ.a(VoteTextGroupView.this.bMZ, VoteTextGroupView.this.bMY, false);
                                }
                            }
                            VoteTextGroupView.this.bMY = this.bNc;
                            VoteTextGroupView.this.bMZ = this.bNb;
                            boolean isChecked = bVar.bNg.isChecked();
                            bVar.bNg.setChecked(!isChecked);
                            if (VoteTextGroupView.this.bMJ != null) {
                                VoteTextGroupView.this.bMJ.a(this.bNb, this.bNc, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.bMX.size(); i3++) {
                        if (i3 == this.bNc) {
                            b bVar2 = (b) VoteTextGroupView.this.bMX.get(i3);
                            boolean isChecked2 = bVar2.bNg.isChecked();
                            bVar2.bNg.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.bMJ != null) {
                                VoteTextGroupView.this.bMJ.a(this.bNb, this.bNc, isChecked2 ? false : true);
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
        if (this.bMX != null && !this.bMX.isEmpty()) {
            for (b bVar : this.bMX) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout bNe;
        public TextView bNf;
        public CheckBox bNg;

        private b() {
        }
    }
}
