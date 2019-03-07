package com.baidu.tieba.frs.smartapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aFH;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.aFH = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFH == null) {
            return 0;
        }
        return this.aFH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFH == null || i < 0 || i >= this.aFH.size()) {
            return null;
        }
        return this.aFH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0246a c0246a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.frs_lite_program_list_fragment_item, viewGroup, false);
            C0246a c0246a2 = new C0246a();
            c0246a2.fsF = (RelativeLayout) view.findViewById(d.g.card);
            c0246a2.fsD = (HeadImageView) view.findViewById(d.g.portrait);
            c0246a2.mTitle = (TextView) view.findViewById(d.g.title);
            c0246a2.fsE = (TextView) view.findViewById(d.g.desc);
            view.setTag(c0246a2);
            c0246a = c0246a2;
        } else {
            c0246a = (C0246a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds136);
        c0246a.fsD.setIsRound(true);
        c0246a.fsD.startLoad(bVar.avatar, 10, h, h, false);
        c0246a.mTitle.setText(bVar.name);
        c0246a.fsE.setText(bVar.fsH);
        al.d(c0246a.mTitle, d.C0236d.cp_cont_b, 1);
        al.d(c0246a.fsE, d.C0236d.cp_cont_d, 1);
        al.k(c0246a.fsF, d.f.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0246a {
        HeadImageView fsD;
        TextView fsE;
        RelativeLayout fsF;
        TextView mTitle;

        public C0246a() {
        }
    }
}
