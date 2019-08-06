package com.baidu.tieba.frs.smartapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aIn;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.aIn = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIn == null) {
            return 0;
        }
        return this.aIn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn == null || i < 0 || i >= this.aIn.size()) {
            return null;
        }
        return this.aIn.get(i);
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
        C0316a c0316a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0316a c0316a2 = new C0316a();
            c0316a2.fOA = (RelativeLayout) view.findViewById(R.id.card);
            c0316a2.fOy = (HeadImageView) view.findViewById(R.id.portrait);
            c0316a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0316a2.fOz = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0316a2);
            c0316a = c0316a2;
        } else {
            c0316a = (C0316a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds136);
        c0316a.fOy.setIsRound(true);
        c0316a.fOy.startLoad(bVar.avatar, 10, g, g, false);
        c0316a.mTitle.setText(bVar.name);
        c0316a.fOz.setText(bVar.fOC);
        am.f(c0316a.mTitle, R.color.cp_cont_b, 1);
        am.f(c0316a.fOz, R.color.cp_cont_d, 1);
        am.k(c0316a.fOA, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0316a {
        RelativeLayout fOA;
        HeadImageView fOy;
        TextView fOz;
        TextView mTitle;

        public C0316a() {
        }
    }
}
