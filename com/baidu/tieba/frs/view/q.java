package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.view.aa;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements com.baidu.tieba.frs.c.e {
    private List<bk> aWb;
    private w cdL;
    private x cdO;
    private Context mContext;
    private boolean cdM = false;
    private View.OnClickListener cdN = new r(this);
    private View.OnLongClickListener cdP = new s(this);

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.q(this.aWb);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.x.c(this.aWb, i);
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
            aVar.cdR = view;
            aVar.cdS = (TextView) view.findViewById(w.h.top_item_type);
            aVar.cdT = (TextView) view.findViewById(w.h.top_item_title);
            aVar.aaN = view.findViewById(w.h.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bk bkVar = (bk) com.baidu.tbadk.core.util.x.c(this.aWb, i);
        if (bkVar != null) {
            aVar.cdS.setText(TbadkCoreApplication.m9getInst().getString(w.l.top));
            bkVar.si();
            SpannableStringBuilder rY = bkVar.rY();
            aVar.cdT.setOnTouchListener(new aa(rY));
            aVar.cdT.setText(rY);
            aVar.cdR.setOnClickListener(this.cdN);
            aVar.cdR.setOnLongClickListener(this.cdP);
            if (this.cdM && i == 0) {
                aVar.aaN.setVisibility(8);
            } else {
                aVar.aaN.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qi(bkVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.c.b.acs().a(bZb, bkVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aq.i(aVar.cdS, w.e.cp_link_tip_c);
            if (z) {
                aq.i(aVar.cdT, w.e.cp_cont_c);
            } else {
                aq.i(aVar.cdT, w.e.cp_cont_b);
            }
            aq.j(aVar.cdR, w.g.home_thread_card_item_bg);
            aq.j(aVar.aaN, w.e.cp_bg_line_c);
        }
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.cdL = wVar;
    }

    public void setData(List<bk> list) {
        this.aWb = list;
    }

    public void en(boolean z) {
        this.cdM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aaN;
        View cdR;
        TextView cdS;
        TextView cdT;
        int position;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }
}
