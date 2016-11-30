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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aKU;
    private List<b> aLi;
    private int aLj;
    private com.baidu.tbadk.widget.vote.a aLk;
    private List<com.baidu.tbadk.widget.vote.a> aLl;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aKU = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aLj = -1;
        this.aLk = null;
        this.aLl = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aLj = -1;
        this.aLk = null;
        this.aLl = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aLi = new ArrayList();
    }

    public void E(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aLl = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(r.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aLp = (RelativeLayout) inflate.findViewById(r.g.root_pb_vote);
                    bVar.aLq = (TextView) inflate.findViewById(r.g.tv_name);
                    bVar.aLr = (CheckBox) inflate.findViewById(r.g.cb_select);
                    bVar.aLr.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aLq.setText(UtilHelper.getFixedText(aVar.Cr(), 15, false));
                    bVar.aLr.setChecked(aVar.isSelected());
                    bVar.aLp.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    addView(inflate);
                    this.aLi.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            at.c(bVar.aLq, r.d.cp_cont_b, 1);
            bVar.aLr.setButtonDrawable(at.q(i, r.f.vote_text_check_box));
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aLm;
        private int aLn;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aLm = aVar;
            this.aLn = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aLi != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aLi.size(); i++) {
                            if (i == this.aLn) {
                                b bVar = (b) VoteTextGroupView.this.aLi.get(i);
                                boolean isChecked = bVar.aLr.isChecked();
                                bVar.aLr.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aKU != null) {
                                    VoteTextGroupView.this.aKU.a(this.aLm, this.aLn, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aLj == -1 && VoteTextGroupView.this.aLl != null) {
                    int size = VoteTextGroupView.this.aLl.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aLl.get(i2);
                        if (aVar != null && this.aLn != i2) {
                            ((b) VoteTextGroupView.this.aLi.get(i2)).aLr.setChecked(false);
                            if (VoteTextGroupView.this.aKU != null) {
                                VoteTextGroupView.this.aKU.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aLi.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aLi.get(i3);
                    if (this.aLn == i3) {
                        if (this.aLn != VoteTextGroupView.this.aLj && VoteTextGroupView.this.aLj >= 0 && VoteTextGroupView.this.aLj < VoteTextGroupView.this.aLi.size()) {
                            ((b) VoteTextGroupView.this.aLi.get(VoteTextGroupView.this.aLj)).aLr.setChecked(false);
                            if (VoteTextGroupView.this.aKU != null) {
                                VoteTextGroupView.this.aKU.a(VoteTextGroupView.this.aLk, VoteTextGroupView.this.aLj, false);
                            }
                        }
                        VoteTextGroupView.this.aLj = this.aLn;
                        VoteTextGroupView.this.aLk = this.aLm;
                        boolean isChecked2 = bVar2.aLr.isChecked();
                        bVar2.aLr.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aKU != null) {
                            VoteTextGroupView.this.aKU.a(this.aLm, this.aLn, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aLi != null && !this.aLi.isEmpty()) {
            for (b bVar : this.aLi) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public RelativeLayout aLp;
        public TextView aLq;
        public CheckBox aLr;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
