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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aIS;
    private List<b> aJg;
    private int aJh;
    private com.baidu.tbadk.widget.vote.a aJi;
    private List<com.baidu.tbadk.widget.vote.a> aJj;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aIS = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aJh = -1;
        this.aJi = null;
        this.aJj = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aJh = -1;
        this.aJi = null;
        this.aJj = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aJg = new ArrayList();
    }

    public void C(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aJj = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(r.j.vote_text_select_item, (ViewGroup) null);
                    bVar.aJn = (RelativeLayout) inflate.findViewById(r.h.root_pb_vote);
                    bVar.name = (TextView) inflate.findViewById(r.h.tv_name);
                    bVar.aJo = (CheckBox) inflate.findViewById(r.h.cb_select);
                    bVar.aJo.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.name.setText(UtilHelper.getFixedText(aVar.Ca(), 15, false));
                    bVar.aJo.setChecked(aVar.isSelected());
                    bVar.aJn.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aJg.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            ap.c(bVar.name, r.e.cp_cont_b, 1);
            bVar.aJo.setButtonDrawable(ap.r(i, r.g.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aJk;
        private int aJl;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aJk = aVar;
            this.aJl = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aJg != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aJg.size(); i++) {
                            if (i == this.aJl) {
                                b bVar = (b) VoteTextGroupView.this.aJg.get(i);
                                boolean isChecked = bVar.aJo.isChecked();
                                bVar.aJo.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aIS != null) {
                                    VoteTextGroupView.this.aIS.a(this.aJk, this.aJl, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aJh == -1 && VoteTextGroupView.this.aJj != null) {
                    int size = VoteTextGroupView.this.aJj.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aJj.get(i2);
                        if (aVar != null && this.aJl != i2) {
                            ((b) VoteTextGroupView.this.aJg.get(i2)).aJo.setChecked(false);
                            if (VoteTextGroupView.this.aIS != null) {
                                VoteTextGroupView.this.aIS.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aJg.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aJg.get(i3);
                    if (this.aJl == i3) {
                        if (this.aJl != VoteTextGroupView.this.aJh && VoteTextGroupView.this.aJh >= 0 && VoteTextGroupView.this.aJh < VoteTextGroupView.this.aJg.size()) {
                            ((b) VoteTextGroupView.this.aJg.get(VoteTextGroupView.this.aJh)).aJo.setChecked(false);
                            if (VoteTextGroupView.this.aIS != null) {
                                VoteTextGroupView.this.aIS.a(VoteTextGroupView.this.aJi, VoteTextGroupView.this.aJh, false);
                            }
                        }
                        VoteTextGroupView.this.aJh = this.aJl;
                        VoteTextGroupView.this.aJi = this.aJk;
                        boolean isChecked2 = bVar2.aJo.isChecked();
                        bVar2.aJo.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aIS != null) {
                            VoteTextGroupView.this.aIS.a(this.aJk, this.aJl, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aJg != null && !this.aJg.isEmpty()) {
            for (b bVar : this.aJg) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aJn;
        public CheckBox aJo;
        public TextView name;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
