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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.view.aa;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter implements com.baidu.tieba.frs.d.e {
    private List<bm> aUW;
    private x crQ;
    private y crT;
    private Context mContext;
    private boolean crR = false;
    private View.OnClickListener crS = new l(this);
    private View.OnLongClickListener crU = new m(this);

    public k(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return z.s(this.aUW);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return z.c(this.aUW, i);
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
            aVar.crW = view;
            aVar.crX = (TextView) view.findViewById(w.h.top_item_type);
            aVar.crY = (TextView) view.findViewById(w.h.top_item_title);
            aVar.aaN = view.findViewById(w.h.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bm bmVar = (bm) z.c(this.aUW, i);
        if (bmVar != null) {
            aVar.crX.setText(TbadkCoreApplication.m9getInst().getString(w.l.top));
            bmVar.sb();
            SpannableStringBuilder rR = bmVar.rR();
            aVar.crY.setOnTouchListener(new aa(rR));
            aVar.crY.setText(rR);
            aVar.crW.setOnClickListener(this.crS);
            aVar.crW.setOnLongClickListener(this.crU);
            if (this.crR && i == 0) {
                aVar.aaN.setVisibility(8);
            } else {
                aVar.aaN.setVisibility(0);
            }
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ru(bmVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.d.b.aho().a(cnC, bmVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            as.i(aVar.crX, w.e.cp_link_tip_c);
            if (z) {
                as.i(aVar.crY, w.e.cp_cont_c);
            } else {
                as.i(aVar.crY, w.e.cp_cont_b);
            }
            as.j(aVar.crW, w.g.home_thread_card_item_bg);
            as.j(aVar.aaN, w.e.cp_bg_line_c);
        }
    }

    public void b(x xVar) {
        this.crQ = xVar;
    }

    public void setData(List<bm> list) {
        this.aUW = list;
    }

    public void eU(boolean z) {
        this.crR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aaN;
        View crW;
        TextView crX;
        TextView crY;
        int position;

        private a() {
        }

        /* synthetic */ a(k kVar, a aVar) {
            this();
        }
    }
}
