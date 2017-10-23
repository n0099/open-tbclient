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
    private com.baidu.tbadk.widget.vote.b aTh;
    private List<b> aTv;
    private int aTw;
    private com.baidu.tbadk.widget.vote.a aTx;
    private List<com.baidu.tbadk.widget.vote.a> aTy;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aTh = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aTw = -1;
        this.aTx = null;
        this.aTy = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aTw = -1;
        this.aTx = null;
        this.aTy = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aTv = new ArrayList();
    }

    public void H(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aTy = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b();
                    View inflate = from.inflate(d.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aTC = (RelativeLayout) inflate.findViewById(d.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(d.h.tv_name);
                    bVar.aTD = (CheckBox) inflate.findViewById(d.h.cb_select);
                    bVar.aTD.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.BX(), 15, false));
                    bVar.aTD.setChecked(aVar.isSelected());
                    bVar.aTC.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aTv.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            aj.c(bVar.name, d.e.cp_cont_b, 1);
            bVar.aTD.setButtonDrawable(aj.u(i, d.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private int aTA;
        private com.baidu.tbadk.widget.vote.a aTz;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aTz = aVar;
            this.aTA = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aTv != null) {
                if (VoteTextGroupView.this.mMode == 2) {
                    if (VoteTextGroupView.this.aTw == -1 && VoteTextGroupView.this.aTy != null) {
                        int size = VoteTextGroupView.this.aTy.size();
                        for (int i = 0; i < size; i++) {
                            com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aTy.get(i);
                            if (aVar != null && this.aTA != i) {
                                ((b) VoteTextGroupView.this.aTv.get(i)).aTD.setChecked(false);
                                if (VoteTextGroupView.this.aTh != null) {
                                    VoteTextGroupView.this.aTh.a(aVar, i, false);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < VoteTextGroupView.this.aTv.size(); i2++) {
                        b bVar = (b) VoteTextGroupView.this.aTv.get(i2);
                        if (this.aTA == i2) {
                            if (this.aTA != VoteTextGroupView.this.aTw && VoteTextGroupView.this.aTw >= 0 && VoteTextGroupView.this.aTw < VoteTextGroupView.this.aTv.size()) {
                                ((b) VoteTextGroupView.this.aTv.get(VoteTextGroupView.this.aTw)).aTD.setChecked(false);
                                if (VoteTextGroupView.this.aTh != null) {
                                    VoteTextGroupView.this.aTh.a(VoteTextGroupView.this.aTx, VoteTextGroupView.this.aTw, false);
                                }
                            }
                            VoteTextGroupView.this.aTw = this.aTA;
                            VoteTextGroupView.this.aTx = this.aTz;
                            boolean isChecked = bVar.aTD.isChecked();
                            bVar.aTD.setChecked(!isChecked);
                            if (VoteTextGroupView.this.aTh != null) {
                                VoteTextGroupView.this.aTh.a(this.aTz, this.aTA, !isChecked);
                            }
                        }
                    }
                } else if (VoteTextGroupView.this.mMode == 1) {
                    for (int i3 = 0; i3 < VoteTextGroupView.this.aTv.size(); i3++) {
                        if (i3 == this.aTA) {
                            b bVar2 = (b) VoteTextGroupView.this.aTv.get(i3);
                            boolean isChecked2 = bVar2.aTD.isChecked();
                            bVar2.aTD.setChecked(!isChecked2);
                            if (VoteTextGroupView.this.aTh != null) {
                                VoteTextGroupView.this.aTh.a(this.aTz, this.aTA, isChecked2 ? false : true);
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
        if (this.aTv != null && !this.aTv.isEmpty()) {
            for (b bVar : this.aTv) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aTC;
        public CheckBox aTD;
        public TextView name;

        private b() {
        }
    }
}
