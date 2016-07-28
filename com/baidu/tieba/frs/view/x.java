package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter implements com.baidu.tieba.frs.h.e {
    private List<be> aMv;
    private com.baidu.adp.widget.ListView.w bWH;
    private com.baidu.adp.widget.ListView.x bWJ;
    private Context mContext;
    private boolean bWI = false;
    private View.OnClickListener aLH = new y(this);
    private View.OnLongClickListener bWK = new z(this);

    public x(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.s(this.aMv);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.y.c(this.aMv, i);
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
            view = LayoutInflater.from(this.mContext).inflate(u.h.frs_header_top_item, (ViewGroup) null);
            aVar.bWM = view;
            aVar.bWN = (TextView) view.findViewById(u.g.top_item_type);
            aVar.beS = (TextView) view.findViewById(u.g.top_item_title);
            aVar.TH = view.findViewById(u.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        be beVar = (be) com.baidu.tbadk.core.util.y.c(this.aMv, i);
        if (beVar != null) {
            aVar.bWN.setText(TbadkCoreApplication.m10getInst().getString(u.j.top));
            aVar.beS.setText(beVar.getTitle());
            aVar.bWM.setOnClickListener(this.aLH);
            aVar.bWM.setOnLongClickListener(this.bWK);
            if (this.bWI && i == 0) {
                aVar.TH.setVisibility(8);
            } else {
                aVar.TH.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(beVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.h.b.aam().a(bSh, beVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            av.j((View) aVar.bWN, u.d.cp_link_tip_a);
            if (z) {
                av.j((View) aVar.beS, u.d.cp_cont_c);
            } else {
                av.j((View) aVar.beS, u.d.cp_cont_b);
            }
            av.k(aVar.bWM, u.f.home_thread_card_item_bg);
            av.k(aVar.TH, u.d.cp_bg_line_c);
        }
    }

    public void c(com.baidu.adp.widget.ListView.w wVar) {
        this.bWH = wVar;
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.bWJ = xVar;
    }

    public void setData(List<be> list) {
        this.aMv = list;
    }

    public void dR(boolean z) {
        this.bWI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View TH;
        View bWM;
        TextView bWN;
        TextView beS;
        int position;

        private a() {
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }
    }
}
