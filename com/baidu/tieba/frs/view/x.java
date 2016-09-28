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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter implements com.baidu.tieba.frs.g.e {
    private List<bi> aSU;
    private com.baidu.adp.widget.ListView.w chP;
    private com.baidu.adp.widget.ListView.x chR;
    private Context mContext;
    private boolean chQ = false;
    private View.OnClickListener aSj = new y(this);
    private View.OnLongClickListener chS = new z(this);

    public x(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.s(this.aSU);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.y.c(this.aSU, i);
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
            view = LayoutInflater.from(this.mContext).inflate(r.h.frs_header_top_item, (ViewGroup) null);
            aVar.chU = view;
            aVar.chV = (TextView) view.findViewById(r.g.top_item_type);
            aVar.bqy = (TextView) view.findViewById(r.g.top_item_title);
            aVar.WH = view.findViewById(r.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bi biVar = (bi) com.baidu.tbadk.core.util.y.c(this.aSU, i);
        if (biVar != null) {
            aVar.chV.setText(TbadkCoreApplication.m9getInst().getString(r.j.top));
            biVar.sw();
            SpannableStringBuilder sm = biVar.sm();
            aVar.bqy.setOnTouchListener(new com.baidu.tieba.view.y(sm));
            aVar.bqy.setText(sm);
            aVar.chU.setOnClickListener(this.aSj);
            aVar.chU.setOnLongClickListener(this.chS);
            if (this.chQ && i == 0) {
                aVar.WH.setVisibility(8);
            } else {
                aVar.WH.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ru(biVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.g.b.afl().a(cdl, biVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            av.j((View) aVar.chV, r.d.cp_link_tip_a);
            if (z) {
                av.j((View) aVar.bqy, r.d.cp_cont_c);
            } else {
                av.j((View) aVar.bqy, r.d.cp_cont_b);
            }
            av.k(aVar.chU, r.f.home_thread_card_item_bg);
            av.k(aVar.WH, r.d.cp_bg_line_c);
        }
    }

    public void c(com.baidu.adp.widget.ListView.w wVar) {
        this.chP = wVar;
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.chR = xVar;
    }

    public void setData(List<bi> list) {
        this.aSU = list;
    }

    public void eo(boolean z) {
        this.chQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View WH;
        TextView bqy;
        View chU;
        TextView chV;
        int position;

        private a() {
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }
    }
}
