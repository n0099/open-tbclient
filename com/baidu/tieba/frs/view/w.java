package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter implements com.baidu.tieba.frs.e.e {
    private List<bj> aVq;
    private com.baidu.adp.widget.ListView.w cfY;
    private com.baidu.adp.widget.ListView.x cgb;
    private Context mContext;
    private boolean cfZ = false;
    private View.OnClickListener cga = new x(this);
    private View.OnLongClickListener cgc = new y(this);

    public w(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.p(this.aVq);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.x.c(this.aVq, i);
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
            aVar.cge = view;
            aVar.cgf = (TextView) view.findViewById(w.h.top_item_type);
            aVar.cgg = (TextView) view.findViewById(w.h.top_item_title);
            aVar.abc = view.findViewById(w.h.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bj bjVar = (bj) com.baidu.tbadk.core.util.x.c(this.aVq, i);
        if (bjVar != null) {
            aVar.cgf.setText(TbadkCoreApplication.m9getInst().getString(w.l.top));
            bjVar.sA();
            SpannableStringBuilder sq = bjVar.sq();
            aVar.cgg.setOnTouchListener(new com.baidu.tieba.view.x(sq));
            aVar.cgg.setText(sq);
            aVar.cge.setOnClickListener(this.cga);
            aVar.cge.setOnLongClickListener(this.cgc);
            if (this.cfZ && i == 0) {
                aVar.abc.setVisibility(8);
            } else {
                aVar.abc.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pX(bjVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.e.b.adv().a(cav, bjVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aq.i((View) aVar.cgf, w.e.cp_link_tip_a);
            if (z) {
                aq.i((View) aVar.cgg, w.e.cp_cont_c);
            } else {
                aq.i((View) aVar.cgg, w.e.cp_cont_b);
            }
            aq.j(aVar.cge, w.g.home_thread_card_item_bg);
            aq.j(aVar.abc, w.e.cp_bg_line_c);
        }
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.cfY = wVar;
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.cgb = xVar;
    }

    public void setData(List<bj> list) {
        this.aVq = list;
    }

    public void er(boolean z) {
        this.cfZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View abc;
        View cge;
        TextView cgf;
        TextView cgg;
        int position;

        private a() {
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }
    }
}
