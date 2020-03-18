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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private TbPageContext cVv;
    private ArrayList<b> cWf;

    public a(TbPageContext tbPageContext) {
        this.cVv = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.cWf = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWf == null) {
            return 0;
        }
        return this.cWf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf == null || i < 0 || i >= this.cWf.size()) {
            return null;
        }
        return this.cWf.get(i);
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
        C0510a c0510a;
        if (view == null) {
            view = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0510a c0510a2 = new C0510a();
            c0510a2.gJM = (RelativeLayout) view.findViewById(R.id.card);
            c0510a2.gJL = (HeadImageView) view.findViewById(R.id.portrait);
            c0510a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0510a2.alt = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0510a2);
            c0510a = c0510a2;
        } else {
            c0510a = (C0510a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int dimens = l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds136);
        c0510a.gJL.setIsRound(true);
        c0510a.gJL.setPlaceHolder(2);
        c0510a.gJL.a(bVar.avatar, 10, dimens, dimens, false);
        c0510a.mTitle.setText(bVar.name);
        c0510a.alt.setText(bVar.gJO);
        am.setViewTextColor(c0510a.mTitle, R.color.cp_cont_b, 1);
        am.setViewTextColor(c0510a.alt, R.color.cp_cont_d, 1);
        am.setBackgroundResource(c0510a.gJM, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0510a {
        TextView alt;
        HeadImageView gJL;
        RelativeLayout gJM;
        TextView mTitle;

        public C0510a() {
        }
    }
}
