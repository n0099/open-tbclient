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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aHF;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.aHF = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHF == null) {
            return 0;
        }
        return this.aHF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF == null || i < 0 || i >= this.aHF.size()) {
            return null;
        }
        return this.aHF.get(i);
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
        C0313a c0313a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0313a c0313a2 = new C0313a();
            c0313a2.fIO = (RelativeLayout) view.findViewById(R.id.card);
            c0313a2.fIM = (HeadImageView) view.findViewById(R.id.portrait);
            c0313a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0313a2.fIN = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0313a2);
            c0313a = c0313a2;
        } else {
            c0313a = (C0313a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds136);
        c0313a.fIM.setIsRound(true);
        c0313a.fIM.startLoad(bVar.avatar, 10, g, g, false);
        c0313a.mTitle.setText(bVar.name);
        c0313a.fIN.setText(bVar.fIQ);
        al.f(c0313a.mTitle, R.color.cp_cont_b, 1);
        al.f(c0313a.fIN, R.color.cp_cont_d, 1);
        al.k(c0313a.fIO, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0313a {
        HeadImageView fIM;
        TextView fIN;
        RelativeLayout fIO;
        TextView mTitle;

        public C0313a() {
        }
    }
}
