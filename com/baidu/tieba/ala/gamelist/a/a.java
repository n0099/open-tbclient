package com.baidu.tieba.ala.gamelist.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> fws;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fws)) {
            return 0;
        }
        return this.fws.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (v.isEmpty(this.fws)) {
            return null;
        }
        return this.fws.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0538a c0538a;
        if (view == null) {
            c0538a = new C0538a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0538a.fjQ = (TbImageView) view.findViewById(R.id.cover);
            c0538a.fjQ.setDrawerType(1);
            c0538a.fjQ.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0538a.fjQ.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0538a.fjQ.setDefaultBgResource(R.color.transparent);
            c0538a.fjQ.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0538a.title = (TextView) view.findViewById(R.id.title);
            am.setViewTextColor(c0538a.title, (int) R.color.cp_cont_f);
            view.setTag(c0538a);
        } else {
            c0538a = (C0538a) view.getTag();
        }
        c0538a.fjQ.startLoad(this.fws.get(i).iconUrl, 10, false);
        c0538a.title.setText(this.fws.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.fws = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.fws;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0538a {
        TbImageView fjQ;
        TextView title;

        C0538a() {
        }
    }
}
