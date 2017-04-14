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
    private List<bi> aVD;
    private com.baidu.adp.widget.ListView.x ceB;
    private com.baidu.adp.widget.ListView.w cey;
    private Context mContext;
    private boolean cez = false;
    private View.OnClickListener ceA = new x(this);
    private View.OnLongClickListener ceC = new y(this);

    public w(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.p(this.aVD);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.x.c(this.aVD, i);
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
            aVar.ceE = view;
            aVar.ceF = (TextView) view.findViewById(w.h.top_item_type);
            aVar.ceG = (TextView) view.findViewById(w.h.top_item_title);
            aVar.abr = view.findViewById(w.h.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bi biVar = (bi) com.baidu.tbadk.core.util.x.c(this.aVD, i);
        if (biVar != null) {
            aVar.ceF.setText(TbadkCoreApplication.m9getInst().getString(w.l.top));
            biVar.sY();
            SpannableStringBuilder sO = biVar.sO();
            aVar.ceG.setOnTouchListener(new com.baidu.tieba.view.x(sO));
            aVar.ceG.setText(sO);
            aVar.ceE.setOnClickListener(this.ceA);
            aVar.ceE.setOnLongClickListener(this.ceC);
            if (this.cez && i == 0) {
                aVar.abr.setVisibility(8);
            } else {
                aVar.abr.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qo(biVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.e.b.adp().a(bYW, biVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aq.i(aVar.ceF, w.e.cp_link_tip_a);
            if (z) {
                aq.i(aVar.ceG, w.e.cp_cont_c);
            } else {
                aq.i(aVar.ceG, w.e.cp_cont_b);
            }
            aq.j(aVar.ceE, w.g.home_thread_card_item_bg);
            aq.j(aVar.abr, w.e.cp_bg_line_c);
        }
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.cey = wVar;
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.ceB = xVar;
    }

    public void setData(List<bi> list) {
        this.aVD = list;
    }

    public void er(boolean z) {
        this.cez = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View abr;
        View ceE;
        TextView ceF;
        TextView ceG;
        int position;

        private a() {
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }
    }
}
