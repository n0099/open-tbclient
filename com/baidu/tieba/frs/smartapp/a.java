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
    private ArrayList<b> cVR;
    private TbPageContext cVh;

    public a(TbPageContext tbPageContext) {
        this.cVh = tbPageContext;
    }

    public void setData(ArrayList<b> arrayList) {
        this.cVR = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVR == null) {
            return 0;
        }
        return this.cVR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR == null || i < 0 || i >= this.cVR.size()) {
            return null;
        }
        return this.cVR.get(i);
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
            view = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.frs_lite_program_list_fragment_item, viewGroup, false);
            C0510a c0510a2 = new C0510a();
            c0510a2.gIv = (RelativeLayout) view.findViewById(R.id.card);
            c0510a2.gIu = (HeadImageView) view.findViewById(R.id.portrait);
            c0510a2.mTitle = (TextView) view.findViewById(R.id.title);
            c0510a2.alh = (TextView) view.findViewById(R.id.desc);
            view.setTag(c0510a2);
            c0510a = c0510a2;
        } else {
            c0510a = (C0510a) view.getTag();
        }
        b bVar = (b) getItem(i);
        int dimens = l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds136);
        c0510a.gIu.setIsRound(true);
        c0510a.gIu.setPlaceHolder(2);
        c0510a.gIu.a(bVar.avatar, 10, dimens, dimens, false);
        c0510a.mTitle.setText(bVar.name);
        c0510a.alh.setText(bVar.gIx);
        am.setViewTextColor(c0510a.mTitle, R.color.cp_cont_b, 1);
        am.setViewTextColor(c0510a.alh, R.color.cp_cont_d, 1);
        am.setBackgroundResource(c0510a.gIv, R.drawable.lite_progrom_icorner_bg);
        return view;
    }

    /* renamed from: com.baidu.tieba.frs.smartapp.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0510a {
        TextView alh;
        HeadImageView gIu;
        RelativeLayout gIv;
        TextView mTitle;

        public C0510a() {
        }
    }
}
