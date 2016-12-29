package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BaseAdapter implements com.baidu.tieba.frs.g.e {
    private List<bg> aUm;
    private com.baidu.adp.widget.ListView.w bSg;
    private com.baidu.adp.widget.ListView.x bSi;
    private Context mContext;
    private boolean bSh = false;
    private View.OnClickListener aTB = new z(this);
    private View.OnLongClickListener bSj = new aa(this);

    public y(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.s(this.aUm);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.x.c(this.aUm, i);
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
            aVar.bSl = view;
            aVar.bSm = (TextView) view.findViewById(r.g.top_item_type);
            aVar.bSn = (TextView) view.findViewById(r.g.top_item_title);
            aVar.Wz = view.findViewById(r.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bg bgVar = (bg) com.baidu.tbadk.core.util.x.c(this.aUm, i);
        if (bgVar != null) {
            aVar.bSm.setText(TbadkCoreApplication.m9getInst().getString(r.j.top));
            bgVar.sn();
            SpannableStringBuilder sd = bgVar.sd();
            aVar.bSn.setOnTouchListener(new com.baidu.tieba.view.x(sd));
            aVar.bSn.setText(sd);
            aVar.bSl.setOnClickListener(this.aTB);
            aVar.bSl.setOnLongClickListener(this.bSj);
            if (this.bSh && i == 0) {
                aVar.Wz.setVisibility(8);
            } else {
                aVar.Wz.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(bgVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.g.b.abq().a(bMV, bgVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            ar.j((View) aVar.bSm, r.d.cp_link_tip_a);
            if (z) {
                ar.j((View) aVar.bSn, r.d.cp_cont_c);
            } else {
                ar.j((View) aVar.bSn, r.d.cp_cont_b);
            }
            ar.k(aVar.bSl, r.f.home_thread_card_item_bg);
            ar.k(aVar.Wz, r.d.cp_bg_line_c);
        }
    }

    public void c(com.baidu.adp.widget.ListView.w wVar) {
        this.bSg = wVar;
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.bSi = xVar;
    }

    public void setData(List<bg> list) {
        this.aUm = list;
    }

    public void en(boolean z) {
        this.bSh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View Wz;
        View bSl;
        TextView bSm;
        TextView bSn;
        int position;

        private a() {
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }
    }
}
