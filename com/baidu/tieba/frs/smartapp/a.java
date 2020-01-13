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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<b> cRO;
    private TbPageContext cRe;

    public a(TbPageContext tbPageContext) {
        this.cRe = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.cRO = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO == null || i < 0 || i >= this.cRO.size()) {
            return null;
        }
        return this.cRO.get(i);
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
        C0503a c0503a;
        if (view == null) {
            view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0503a c0503a2 = new C0503a();
            c0503a2.gGu = (RelativeLayout) view.findViewById(R.id.card);
            c0503a2.gGt = (HeadImageView) view.findViewById(R.id.portrait);
            c0503a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0503a2.aja = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0503a2);
            c0503a = c0503a2;
        } else {
            c0503a = (C0503a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int dimens = l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds136);
        c0503a.gGt.setIsRound(true);
        c0503a.gGt.setPlaceHolder(2);
        c0503a.gGt.a(bVar.avatar, 10, dimens, dimens, false);
        c0503a.mTitle.setText(bVar.name);
        c0503a.aja.setText(bVar.gGw);
        am.setViewTextColor(c0503a.mTitle, R.color.cp_cont_b, 1);
        am.setViewTextColor(c0503a.aja, R.color.cp_cont_d, 1);
        am.setBackgroundResource(c0503a.gGu, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0503a {
        TextView aja;
        HeadImageView gGt;
        RelativeLayout gGu;
        TextView mTitle;

        public C0503a() {
        }
    }
}
