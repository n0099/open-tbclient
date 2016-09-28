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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VoteTextGroupView extends LinearLayout {
    private com.baidu.tbadk.widget.vote.b aKb;
    private List<b> aKq;
    private int aKr;
    private com.baidu.tbadk.widget.vote.a aKs;
    private List<com.baidu.tbadk.widget.vote.a> aKt;
    private int mMode;

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setOnVoteCheckedChangedListener(com.baidu.tbadk.widget.vote.b bVar) {
        this.aKb = bVar;
    }

    public VoteTextGroupView(Context context) {
        super(context);
        this.mMode = 2;
        this.aKr = -1;
        this.aKs = null;
        this.aKt = new ArrayList();
        init(context);
    }

    public VoteTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 2;
        this.aKr = -1;
        this.aKs = null;
        this.aKt = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setGravity(1);
        this.aKq = new ArrayList();
    }

    public void E(List<com.baidu.tbadk.widget.vote.a> list) {
        if (list != null && !list.isEmpty()) {
            this.aKt = list;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(getContext());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.widget.vote.a aVar = list.get(i);
                if (aVar != null) {
                    b bVar = new b(null);
                    View inflate = from.inflate(r.h.vote_text_select_item, (ViewGroup) null);
                    bVar.aKx = (RelativeLayout) inflate.findViewById(r.g.root);
                    bVar.aKy = (TextView) inflate.findViewById(r.g.tv_name);
                    bVar.aKz = (CheckBox) inflate.findViewById(r.g.cb_select);
                    bVar.aKA = inflate.findViewById(r.g.v_line);
                    bVar.aKz.setClickable(false);
                    inflate.setTag(bVar);
                    bVar.aKy.setText(UtilHelper.getFixedText(aVar.Cj(), 15, false));
                    bVar.aKz.setChecked(aVar.isSelected());
                    bVar.aKx.setOnClickListener(new a(aVar, i));
                    a(TbadkCoreApplication.m9getInst().getSkinType(), bVar);
                    if (i == list.size() - 1) {
                        bVar.aKA.setVisibility(8);
                    }
                    addView(inflate);
                    this.aKq.add(bVar);
                }
            }
        }
    }

    private void a(int i, b bVar) {
        if (bVar != null) {
            av.c(bVar.aKy, r.d.cp_cont_b, 1);
            bVar.aKz.setButtonDrawable(av.q(i, r.f.vote_text_check_box));
            av.k(bVar.aKA, r.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private com.baidu.tbadk.widget.vote.a aKu;
        private int aKv;

        public a(com.baidu.tbadk.widget.vote.a aVar, int i) {
            this.aKu = aVar;
            this.aKv = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoteTextGroupView.this.aKq != null) {
                if (VoteTextGroupView.this.mMode != 2) {
                    if (VoteTextGroupView.this.mMode == 1) {
                        for (int i = 0; i < VoteTextGroupView.this.aKq.size(); i++) {
                            if (i == this.aKv) {
                                b bVar = (b) VoteTextGroupView.this.aKq.get(i);
                                boolean isChecked = bVar.aKz.isChecked();
                                bVar.aKz.setChecked(!isChecked);
                                if (VoteTextGroupView.this.aKb != null) {
                                    VoteTextGroupView.this.aKb.a(this.aKu, this.aKv, isChecked ? false : true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (VoteTextGroupView.this.aKr == -1 && VoteTextGroupView.this.aKt != null) {
                    int size = VoteTextGroupView.this.aKt.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tbadk.widget.vote.a aVar = (com.baidu.tbadk.widget.vote.a) VoteTextGroupView.this.aKt.get(i2);
                        if (aVar != null && this.aKv != i2) {
                            ((b) VoteTextGroupView.this.aKq.get(i2)).aKz.setChecked(false);
                            if (VoteTextGroupView.this.aKb != null) {
                                VoteTextGroupView.this.aKb.a(aVar, i2, false);
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < VoteTextGroupView.this.aKq.size(); i3++) {
                    b bVar2 = (b) VoteTextGroupView.this.aKq.get(i3);
                    if (this.aKv == i3) {
                        if (this.aKv != VoteTextGroupView.this.aKr && VoteTextGroupView.this.aKr >= 0 && VoteTextGroupView.this.aKr < VoteTextGroupView.this.aKq.size()) {
                            ((b) VoteTextGroupView.this.aKq.get(VoteTextGroupView.this.aKr)).aKz.setChecked(false);
                            if (VoteTextGroupView.this.aKb != null) {
                                VoteTextGroupView.this.aKb.a(VoteTextGroupView.this.aKs, VoteTextGroupView.this.aKr, false);
                            }
                        }
                        VoteTextGroupView.this.aKr = this.aKv;
                        VoteTextGroupView.this.aKs = this.aKu;
                        boolean isChecked2 = bVar2.aKz.isChecked();
                        bVar2.aKz.setChecked(!isChecked2);
                        if (VoteTextGroupView.this.aKb != null) {
                            VoteTextGroupView.this.aKb.a(this.aKu, this.aKv, !isChecked2);
                        }
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aKq != null && !this.aKq.isEmpty()) {
            for (b bVar : this.aKq) {
                if (bVar != null) {
                    a(i, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public View aKA;
        public RelativeLayout aKx;
        public TextView aKy;
        public CheckBox aKz;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
