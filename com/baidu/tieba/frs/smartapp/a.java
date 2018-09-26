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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<b> anX;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.anX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anX == null) {
            return 0;
        }
        return this.anX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX == null || i < 0 || i >= this.anX.size()) {
            return null;
        }
        return this.anX.get(i);
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
        C0157a c0157a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.frs_lite_program_list_fragment_item, viewGroup, false);
            C0157a c0157a2 = new C0157a();
            c0157a2.dLl = (RelativeLayout) view.findViewById(e.g.card);
            c0157a2.dLj = (HeadImageView) view.findViewById(e.g.portrait);
            c0157a2.mTitle = (TextView) view.findViewById(e.g.title);
            c0157a2.dLk = (TextView) view.findViewById(e.g.desc);
            view.setTag(c0157a2);
            c0157a = c0157a2;
        } else {
            c0157a = (C0157a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int h = l.h(this.mContext.getPageActivity(), e.C0141e.tbds136);
        c0157a.dLj.setIsRound(true);
        c0157a.dLj.startLoad(bVar.avatar, 10, h, h, false);
        c0157a.mTitle.setText(bVar.name);
        c0157a.dLk.setText(bVar.dLn);
        al.c(c0157a.mTitle, e.d.cp_cont_b, 1);
        al.c(c0157a.dLk, e.d.cp_cont_d, 1);
        al.i(c0157a.dLl, e.f.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0157a {
        HeadImageView dLj;
        TextView dLk;
        RelativeLayout dLl;
        TextView mTitle;

        public C0157a() {
        }
    }
}
