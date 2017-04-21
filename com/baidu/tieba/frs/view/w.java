package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter implements com.baidu.tieba.frs.e.e {
    private List<bi> aVF;
    private com.baidu.adp.widget.ListView.w cgP;
    private com.baidu.adp.widget.ListView.x cgS;
    private Context mContext;
    private boolean cgQ = false;
    private View.OnClickListener cgR = new x(this);
    private View.OnLongClickListener cgT = new y(this);

    public w(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.p(this.aVF);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.x.c(this.aVF, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        boolean z = false;
        if (view == null) {
            aVar = new a(this, null);
            view = LayoutInflater.from(this.mContext).inflate(w.j.frs_header_top_item, (ViewGroup) null);
            aVar.cgV = view;
            aVar.cgW = (TextView) view.findViewById(w.h.top_item_type);
            aVar.cgX = (TextView) view.findViewById(w.h.top_item_title);
            aVar.abt = view.findViewById(w.h.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bi biVar = (bi) com.baidu.tbadk.core.util.x.c(this.aVF, i);
        if (biVar != null) {
            aVar.cgW.setText(TbadkCoreApplication.m9getInst().getString(w.l.top));
            biVar.sY();
            SpannableStringBuilder sO = biVar.sO();
            aVar.cgX.setOnTouchListener(new com.baidu.tieba.view.x(sO));
            aVar.cgX.setText(sO);
            aVar.cgV.setOnClickListener(this.cgR);
            aVar.cgV.setOnLongClickListener(this.cgT);
            if (this.cgQ && i == 0) {
                aVar.abt.setVisibility(8);
            } else {
                aVar.abt.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qp(biVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.e.b.aeq().a(cbn, biVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aq.i(aVar.cgW, w.e.cp_link_tip_a);
            if (z) {
                aq.i(aVar.cgX, w.e.cp_cont_c);
            } else {
                aq.i(aVar.cgX, w.e.cp_cont_b);
            }
            aq.j(aVar.cgV, w.g.home_thread_card_item_bg);
            aq.j(aVar.abt, w.e.cp_bg_line_c);
        }
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.cgP = wVar;
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.cgS = xVar;
    }

    public void setData(List<bi> list) {
        this.aVF = list;
    }

    public void eB(boolean z) {
        this.cgQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View abt;
        View cgV;
        TextView cgW;
        TextView cgX;
        int position;

        private a() {
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }
    }
}
