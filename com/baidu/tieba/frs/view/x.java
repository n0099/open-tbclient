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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter implements com.baidu.tieba.frs.g.e {
    private List<bg> aRP;
    private com.baidu.adp.widget.ListView.w chR;
    private com.baidu.adp.widget.ListView.x chT;
    private Context mContext;
    private boolean chS = false;
    private View.OnClickListener aRb = new y(this);
    private View.OnLongClickListener chU = new z(this);

    public x(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.s(this.aRP);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.y.c(this.aRP, i);
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
            view = LayoutInflater.from(this.mContext).inflate(t.h.frs_header_top_item, (ViewGroup) null);
            aVar.chW = view;
            aVar.chX = (TextView) view.findViewById(t.g.top_item_type);
            aVar.bqm = (TextView) view.findViewById(t.g.top_item_title);
            aVar.Wx = view.findViewById(t.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bg bgVar = (bg) com.baidu.tbadk.core.util.y.c(this.aRP, i);
        if (bgVar != null) {
            aVar.chX.setText(TbadkCoreApplication.m9getInst().getString(t.j.top));
            bgVar.sk();
            SpannableStringBuilder sa = bgVar.sa();
            aVar.bqm.setOnTouchListener(new com.baidu.tieba.view.y(sa));
            aVar.bqm.setText(sa);
            aVar.chW.setOnClickListener(this.aRb);
            aVar.chW.setOnLongClickListener(this.chU);
            if (this.chS && i == 0) {
                aVar.Wx.setVisibility(8);
            } else {
                aVar.Wx.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rf(bgVar.getId())) {
                z = true;
            }
            a(aVar, z);
        }
        aVar.position = i;
        com.baidu.tieba.frs.g.b.aeX().a(cdn, bgVar);
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            av.j((View) aVar.chX, t.d.cp_link_tip_a);
            if (z) {
                av.j((View) aVar.bqm, t.d.cp_cont_c);
            } else {
                av.j((View) aVar.bqm, t.d.cp_cont_b);
            }
            av.k(aVar.chW, t.f.home_thread_card_item_bg);
            av.k(aVar.Wx, t.d.cp_bg_line_c);
        }
    }

    public void c(com.baidu.adp.widget.ListView.w wVar) {
        this.chR = wVar;
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.chT = xVar;
    }

    public void setData(List<bg> list) {
        this.aRP = list;
    }

    public void en(boolean z) {
        this.chS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View Wx;
        TextView bqm;
        View chW;
        TextView chX;
        int position;

        private a() {
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }
    }
}
