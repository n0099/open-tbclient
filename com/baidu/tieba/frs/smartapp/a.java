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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private TbPageContext mContext;
    private ArrayList<b> mData;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
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
        C0216a c0216a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.frs_lite_program_list_fragment_item, viewGroup, false);
            C0216a c0216a2 = new C0216a();
            c0216a2.dUo = (RelativeLayout) view.findViewById(e.g.card);
            c0216a2.dUm = (HeadImageView) view.findViewById(e.g.portrait);
            c0216a2.mTitle = (TextView) view.findViewById(e.g.title);
            c0216a2.dUn = (TextView) view.findViewById(e.g.desc);
            view.setTag(c0216a2);
            c0216a = c0216a2;
        } else {
            c0216a = (C0216a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int h = l.h(this.mContext.getPageActivity(), e.C0200e.tbds136);
        c0216a.dUm.setIsRound(true);
        c0216a.dUm.startLoad(bVar.avatar, 10, h, h, false);
        c0216a.mTitle.setText(bVar.name);
        c0216a.dUn.setText(bVar.dUq);
        al.c(c0216a.mTitle, e.d.cp_cont_b, 1);
        al.c(c0216a.dUn, e.d.cp_cont_d, 1);
        al.i(c0216a.dUo, e.f.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0216a {
        HeadImageView dUm;
        TextView dUn;
        RelativeLayout dUo;
        TextView mTitle;

        public C0216a() {
        }
    }
}
