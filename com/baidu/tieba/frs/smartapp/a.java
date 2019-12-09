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
    private ArrayList<b> bbH;
    private TbPageContext ceu;

    public a(TbPageContext tbPageContext) {
        this.ceu = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.bbH = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH == null) {
            return 0;
        }
        return this.bbH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null || i < 0 || i >= this.bbH.size()) {
            return null;
        }
        return this.bbH.get(i);
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
        C0411a c0411a;
        if (view == null) {
            view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0411a c0411a2 = new C0411a();
            c0411a2.fOS = (RelativeLayout) view.findViewById(R.id.card);
            c0411a2.fOR = (HeadImageView) view.findViewById(R.id.portrait);
            c0411a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0411a2.aan = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0411a2);
            c0411a = c0411a2;
        } else {
            c0411a = (C0411a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int dimens = l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds136);
        c0411a.fOR.setIsRound(true);
        c0411a.fOR.a(bVar.avatar, 10, dimens, dimens, false);
        c0411a.mTitle.setText(bVar.name);
        c0411a.aan.setText(bVar.fOU);
        am.setViewTextColor(c0411a.mTitle, R.color.cp_cont_b, 1);
        am.setViewTextColor(c0411a.aan, R.color.cp_cont_d, 1);
        am.setBackgroundResource(c0411a.fOS, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0411a {
        TextView aan;
        HeadImageView fOR;
        RelativeLayout fOS;
        TextView mTitle;

        public C0411a() {
        }
    }
}
