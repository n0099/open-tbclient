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
    private ArrayList<b> aIL;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.aIL = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIL == null) {
            return 0;
        }
        return this.aIL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL == null || i < 0 || i >= this.aIL.size()) {
            return null;
        }
        return this.aIL.get(i);
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
        C0327a c0327a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0327a c0327a2 = new C0327a();
            c0327a2.fQq = (RelativeLayout) view.findViewById(R.id.card);
            c0327a2.fQo = (HeadImageView) view.findViewById(R.id.portrait);
            c0327a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0327a2.fQp = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0327a2);
            c0327a = c0327a2;
        } else {
            c0327a = (C0327a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds136);
        c0327a.fQo.setIsRound(true);
        c0327a.fQo.startLoad(bVar.avatar, 10, g, g, false);
        c0327a.mTitle.setText(bVar.name);
        c0327a.fQp.setText(bVar.fQs);
        am.f(c0327a.mTitle, R.color.cp_cont_b, 1);
        am.f(c0327a.fQp, R.color.cp_cont_d, 1);
        am.k(c0327a.fQq, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0327a {
        HeadImageView fQo;
        TextView fQp;
        RelativeLayout fQq;
        TextView mTitle;

        public C0327a() {
        }
    }
}
