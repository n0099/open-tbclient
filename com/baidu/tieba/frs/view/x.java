package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private List<az> aLB;
    private com.baidu.adp.widget.ListView.w bUH;
    private com.baidu.adp.widget.ListView.x bUJ;
    private Context mContext;
    private boolean bUI = false;
    private View.OnClickListener aKO = new y(this);
    private View.OnLongClickListener bUK = new z(this);

    public x(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.s(this.aLB);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.y.c(this.aLB, i);
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
            view = LayoutInflater.from(this.mContext).inflate(u.h.frs_header_top_item, (ViewGroup) null);
            aVar.bUM = view;
            aVar.bUN = (TextView) view.findViewById(u.g.top_item_type);
            aVar.bdG = (TextView) view.findViewById(u.g.top_item_title);
            aVar.SZ = view.findViewById(u.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        az azVar = (az) com.baidu.tbadk.core.util.y.c(this.aLB, i);
        if (azVar != null) {
            aVar.bUN.setText(TbadkCoreApplication.m9getInst().getString(u.j.top));
            aVar.bdG.setText(azVar.getTitle());
            aVar.bUM.setOnClickListener(this.aKO);
            aVar.bUM.setOnLongClickListener(this.bUK);
            if (this.bUI && i == 0) {
                aVar.SZ.setVisibility(8);
            } else {
                aVar.SZ.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.pL(azVar.getId()));
        }
        aVar.position = i;
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            av.j((View) aVar.bUN, u.d.cp_link_tip_a);
            if (z) {
                av.j((View) aVar.bdG, u.d.cp_cont_c);
            } else {
                av.j((View) aVar.bdG, u.d.cp_cont_b);
            }
            av.k(aVar.bUM, u.f.home_thread_card_item_bg);
            av.k(aVar.SZ, u.d.cp_bg_line_c);
        }
    }

    public void c(com.baidu.adp.widget.ListView.w wVar) {
        this.bUH = wVar;
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.bUJ = xVar;
    }

    public void setData(List<az> list) {
        this.aLB = list;
    }

    public void dR(boolean z) {
        this.bUI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View SZ;
        View bUM;
        TextView bUN;
        TextView bdG;
        int position;

        private a() {
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }
    }
}
