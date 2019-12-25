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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private TbPageContext cQU;
    private ArrayList<b> cRE;

    public a(TbPageContext tbPageContext) {
        this.cQU = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.cRE = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRE == null) {
            return 0;
        }
        return this.cRE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE == null || i < 0 || i >= this.cRE.size()) {
            return null;
        }
        return this.cRE.get(i);
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
        C0499a c0499a;
        if (view == null) {
            view = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0499a c0499a2 = new C0499a();
            c0499a2.gDf = (RelativeLayout) view.findViewById(R.id.card);
            c0499a2.gDe = (HeadImageView) view.findViewById(R.id.portrait);
            c0499a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0499a2.ais = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0499a2);
            c0499a = c0499a2;
        } else {
            c0499a = (C0499a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int dimens = l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds136);
        c0499a.gDe.setIsRound(true);
        c0499a.gDe.setPlaceHolder(2);
        c0499a.gDe.a(bVar.avatar, 10, dimens, dimens, false);
        c0499a.mTitle.setText(bVar.name);
        c0499a.ais.setText(bVar.gDh);
        am.setViewTextColor(c0499a.mTitle, R.color.cp_cont_b, 1);
        am.setViewTextColor(c0499a.ais, R.color.cp_cont_d, 1);
        am.setBackgroundResource(c0499a.gDf, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0499a {
        TextView ais;
        HeadImageView gDe;
        RelativeLayout gDf;
        TextView mTitle;

        public C0499a() {
        }
    }
}
