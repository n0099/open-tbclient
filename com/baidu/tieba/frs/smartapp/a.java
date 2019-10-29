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
    private ArrayList<b> bbZ;
    private TbPageContext cfl;

    public a(TbPageContext tbPageContext) {
        this.cfl = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.bbZ = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null || i < 0 || i >= this.bbZ.size()) {
            return null;
        }
        return this.bbZ.get(i);
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
        C0416a c0416a;
        if (view == null) {
            view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0416a c0416a2 = new C0416a();
            c0416a2.fPJ = (RelativeLayout) view.findViewById(R.id.card);
            c0416a2.fPI = (HeadImageView) view.findViewById(R.id.portrait);
            c0416a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0416a2.aaF = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0416a2);
            c0416a = c0416a2;
        } else {
            c0416a = (C0416a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int dimens = l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds136);
        c0416a.fPI.setIsRound(true);
        c0416a.fPI.a(bVar.avatar, 10, dimens, dimens, false);
        c0416a.mTitle.setText(bVar.name);
        c0416a.aaF.setText(bVar.fPL);
        am.setViewTextColor(c0416a.mTitle, R.color.cp_cont_b, 1);
        am.setViewTextColor(c0416a.aaF, R.color.cp_cont_d, 1);
        am.setBackgroundResource(c0416a.fPJ, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0416a {
        TextView aaF;
        HeadImageView fPI;
        RelativeLayout fPJ;
        TextView mTitle;

        public C0416a() {
        }
    }
}
