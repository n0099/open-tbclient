package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class af extends BaseAdapter {
    private List<ax> aIe;
    private com.baidu.adp.widget.ListView.w bxb;
    private com.baidu.adp.widget.ListView.x bxe;
    private Context mContext;
    private boolean bxc = false;
    private View.OnClickListener bxd = new ag(this);
    private View.OnLongClickListener bxf = new ah(this);

    public af(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.r(this.aIe);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.y.c(this.aIe, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this, null);
            view = LayoutInflater.from(this.mContext).inflate(t.h.frs_header_top_item, (ViewGroup) null);
            aVar.bxh = view;
            aVar.bxi = (TextView) view.findViewById(t.g.top_item_type);
            aVar.bxj = (TextView) view.findViewById(t.g.top_item_title);
            aVar.SI = view.findViewById(t.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        ax axVar = (ax) com.baidu.tbadk.core.util.y.c(this.aIe, i);
        if (axVar != null) {
            aVar.bxi.setText(TbadkCoreApplication.m11getInst().getString(t.j.top));
            aVar.bxj.setText(axVar.getTitle());
            aVar.bxh.setOnClickListener(this.bxd);
            aVar.bxh.setOnLongClickListener(this.bxf);
            if (this.bxc && i == 0) {
                aVar.SI.setVisibility(8);
            } else {
                aVar.SI.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.od(axVar.getId()));
        }
        aVar.position = i;
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            at.j((View) aVar.bxi, t.d.cp_link_tip_a);
            if (z) {
                at.j((View) aVar.bxj, t.d.cp_cont_c);
            } else {
                at.j((View) aVar.bxj, t.d.cp_cont_b);
            }
            at.k(aVar.bxh, t.f.home_thread_card_item_bg);
            at.k(aVar.SI, t.d.cp_bg_line_c);
        }
    }

    public void c(com.baidu.adp.widget.ListView.w wVar) {
        this.bxb = wVar;
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.bxe = xVar;
    }

    public void setData(List<ax> list) {
        this.aIe = list;
    }

    public void dr(boolean z) {
        this.bxc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View SI;
        View bxh;
        TextView bxi;
        TextView bxj;
        int position;

        private a() {
        }

        /* synthetic */ a(af afVar, a aVar) {
            this();
        }
    }
}
