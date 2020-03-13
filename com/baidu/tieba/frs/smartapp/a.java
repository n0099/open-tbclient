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
    private ArrayList<b> cVS;
    private TbPageContext cVi;

    public a(TbPageContext tbPageContext) {
        this.cVi = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.cVS = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVS == null) {
            return 0;
        }
        return this.cVS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVS == null || i < 0 || i >= this.cVS.size()) {
            return null;
        }
        return this.cVS.get(i);
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
            view = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0510a c0510a2 = new C0510a();
            c0510a2.gIH = (RelativeLayout) view.findViewById(R.id.card);
            c0510a2.gIG = (HeadImageView) view.findViewById(R.id.portrait);
            c0510a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0510a2.ali = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0510a2);
            c0510a = c0510a2;
        } else {
            c0510a = (C0510a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int dimens = l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds136);
        c0510a.gIG.setIsRound(true);
        c0510a.gIG.setPlaceHolder(2);
        c0510a.gIG.a(bVar.avatar, 10, dimens, dimens, false);
        c0510a.mTitle.setText(bVar.name);
        c0510a.ali.setText(bVar.gIJ);
        am.setViewTextColor(c0510a.mTitle, R.color.cp_cont_b, 1);
        am.setViewTextColor(c0510a.ali, R.color.cp_cont_d, 1);
        am.setBackgroundResource(c0510a.gIH, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0510a {
        TextView ali;
        HeadImageView gIG;
        RelativeLayout gIH;
        TextView mTitle;

        public C0510a() {
        }
    }
}
