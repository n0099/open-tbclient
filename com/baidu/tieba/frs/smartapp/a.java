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
    private ArrayList<b> aFM;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.aFM = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFM == null) {
            return 0;
        }
        return this.aFM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFM == null || i < 0 || i >= this.aFM.size()) {
            return null;
        }
        return this.aFM.get(i);
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
        C0295a c0295a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.frs_lite_program_list_fragment_item, viewGroup, false);
            C0295a c0295a2 = new C0295a();
            c0295a2.fsq = (RelativeLayout) view.findViewById(d.g.card);
            c0295a2.fso = (HeadImageView) view.findViewById(d.g.portrait);
            c0295a2.mTitle = (TextView) view.findViewById(d.g.title);
            c0295a2.fsp = (TextView) view.findViewById(d.g.desc);
            view.setTag(c0295a2);
            c0295a = c0295a2;
        } else {
            c0295a = (C0295a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds136);
        c0295a.fso.setIsRound(true);
        c0295a.fso.startLoad(bVar.avatar, 10, h, h, false);
        c0295a.mTitle.setText(bVar.name);
        c0295a.fsp.setText(bVar.fss);
        al.d(c0295a.mTitle, d.C0277d.cp_cont_b, 1);
        al.d(c0295a.fsp, d.C0277d.cp_cont_d, 1);
        al.k(c0295a.fsq, d.f.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0295a {
        HeadImageView fso;
        TextView fsp;
        RelativeLayout fsq;
        TextView mTitle;

        public C0295a() {
        }
    }
}
