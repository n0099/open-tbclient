package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.view.aa;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements com.baidu.tieba.frs.d.e {
    private List<bl> aTD;
    private x cjZ;
    private y ckc;
    private Context mContext;
    private boolean cka = false;
    private View.OnClickListener ckb = new q(this);
    private View.OnLongClickListener ckd = new r(this);

    public p(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.q(this.aTD);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.x.c(this.aTD, i);
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
            aVar.ckf = view;
            aVar.ckg = (TextView) view.findViewById(w.h.top_item_type);
            aVar.ckh = (TextView) view.findViewById(w.h.top_item_title);
            aVar.aaM = view.findViewById(w.h.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bl blVar = (bl) com.baidu.tbadk.core.util.x.c(this.aTD, i);
        if (blVar != null) {
            aVar.ckg.setText(TbadkCoreApplication.m9getInst().getString(w.l.top));
            blVar.se();
            SpannableStringBuilder rU = blVar.rU();
            aVar.ckh.setOnTouchListener(new aa(rU));
            aVar.ckh.setText(rU);
            aVar.ckf.setOnClickListener(this.ckb);
            aVar.ckf.setOnLongClickListener(this.ckd);
            if (this.cka && i == 0) {
                aVar.aaM.setVisibility(8);
            } else {
                aVar.aaM.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qw(blVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.d.b.adw().a(cfm, blVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aq.i(aVar.ckg, w.e.cp_link_tip_c);
            if (z) {
                aq.i(aVar.ckh, w.e.cp_cont_c);
            } else {
                aq.i(aVar.ckh, w.e.cp_cont_b);
            }
            aq.j(aVar.ckf, w.g.home_thread_card_item_bg);
            aq.j(aVar.aaM, w.e.cp_bg_line_c);
        }
    }

    public void b(x xVar) {
        this.cjZ = xVar;
    }

    public void setData(List<bl> list) {
        this.aTD = list;
    }

    public void eD(boolean z) {
        this.cka = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aaM;
        View ckf;
        TextView ckg;
        TextView ckh;
        int position;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }
    }
}
