package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter implements com.baidu.tieba.frs.e.e {
    private List<bh> aPE;
    private com.baidu.adp.widget.ListView.w bYC;
    private com.baidu.adp.widget.ListView.x bYF;
    private Context mContext;
    private boolean bYD = false;
    private View.OnClickListener bYE = new x(this);
    private View.OnLongClickListener bYG = new y(this);

    public w(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.w.r(this.aPE);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.w.c(this.aPE, i);
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
            view = LayoutInflater.from(this.mContext).inflate(r.j.frs_header_top_item, (ViewGroup) null);
            aVar.bYI = view;
            aVar.bYJ = (TextView) view.findViewById(r.h.top_item_type);
            aVar.bYK = (TextView) view.findViewById(r.h.top_item_title);
            aVar.VP = view.findViewById(r.h.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bh bhVar = (bh) com.baidu.tbadk.core.util.w.c(this.aPE, i);
        if (bhVar != null) {
            aVar.bYJ.setText(TbadkCoreApplication.m9getInst().getString(r.l.top));
            bhVar.sf();
            SpannableStringBuilder rV = bhVar.rV();
            aVar.bYK.setOnTouchListener(new com.baidu.tieba.view.x(rV));
            aVar.bYK.setText(rV);
            aVar.bYI.setOnClickListener(this.bYE);
            aVar.bYI.setOnLongClickListener(this.bYG);
            if (this.bYD && i == 0) {
                aVar.VP.setVisibility(8);
            } else {
                aVar.VP.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qP(bhVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.e.b.acx().a(bTj, bhVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            ap.i((View) aVar.bYJ, r.e.cp_link_tip_a);
            if (z) {
                ap.i((View) aVar.bYK, r.e.cp_cont_c);
            } else {
                ap.i((View) aVar.bYK, r.e.cp_cont_b);
            }
            ap.j(aVar.bYI, r.g.home_thread_card_item_bg);
            ap.j(aVar.VP, r.e.cp_bg_line_c);
        }
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.bYC = wVar;
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.bYF = xVar;
    }

    public void setData(List<bh> list) {
        this.aPE = list;
    }

    public void er(boolean z) {
        this.bYD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View VP;
        View bYI;
        TextView bYJ;
        TextView bYK;
        int position;

        private a() {
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }
    }
}
