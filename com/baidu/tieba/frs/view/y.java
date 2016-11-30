package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BaseAdapter implements com.baidu.tieba.frs.h.e {
    private List<bk> aUV;
    private com.baidu.adp.widget.ListView.w cmW;
    private com.baidu.adp.widget.ListView.x cmY;
    private Context mContext;
    private boolean cmX = false;
    private View.OnClickListener aUk = new z(this);
    private View.OnLongClickListener cmZ = new aa(this);

    public y(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.s(this.aUV);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.x.c(this.aUV, i);
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
            aVar.cnb = view;
            aVar.cnc = (TextView) view.findViewById(r.g.top_item_type);
            aVar.btu = (TextView) view.findViewById(r.g.top_item_title);
            aVar.Xf = view.findViewById(r.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bk bkVar = (bk) com.baidu.tbadk.core.util.x.c(this.aUV, i);
        if (bkVar != null) {
            aVar.cnc.setText(TbadkCoreApplication.m9getInst().getString(r.j.top));
            bkVar.sy();
            SpannableStringBuilder so = bkVar.so();
            aVar.btu.setOnTouchListener(new com.baidu.tieba.view.x(so));
            aVar.btu.setText(so);
            aVar.cnb.setOnClickListener(this.aUk);
            aVar.cnb.setOnLongClickListener(this.cmZ);
            if (this.cmX && i == 0) {
                aVar.Xf.setVisibility(8);
            } else {
                aVar.Xf.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rP(bkVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.h.b.agV().a(chm, bkVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            at.j((View) aVar.cnc, r.d.cp_link_tip_a);
            if (z) {
                at.j((View) aVar.btu, r.d.cp_cont_c);
            } else {
                at.j((View) aVar.btu, r.d.cp_cont_b);
            }
            at.k(aVar.cnb, r.f.home_thread_card_item_bg);
            at.k(aVar.Xf, r.d.cp_bg_line_c);
        }
    }

    public void c(com.baidu.adp.widget.ListView.w wVar) {
        this.cmW = wVar;
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.cmY = xVar;
    }

    public void setData(List<bk> list) {
        this.aUV = list;
    }

    public void eD(boolean z) {
        this.cmX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View Xf;
        TextView btu;
        View cnb;
        TextView cnc;
        int position;

        private a() {
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }
    }
}
