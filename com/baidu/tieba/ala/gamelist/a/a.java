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
    private ArrayList<AlaSquareTabInfo> eDC;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.eDC)) {
            return 0;
        }
        return this.eDC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (v.isEmpty(this.eDC)) {
            return null;
        }
        return this.eDC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0433a c0433a;
        if (view == null) {
            c0433a = new C0433a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0433a.esW = (TbImageView) view.findViewById(R.id.cover);
            c0433a.esW.setDrawerType(1);
            c0433a.esW.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0433a.esW.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0433a.esW.setDefaultBgResource(R.color.transparent);
            c0433a.esW.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0433a.title = (TextView) view.findViewById(R.id.title);
            am.setViewTextColor(c0433a.title, (int) R.color.cp_cont_f);
            view.setTag(c0433a);
        } else {
            c0433a = (C0433a) view.getTag();
        }
        c0433a.esW.startLoad(this.eDC.get(i).iconUrl, 10, false);
        c0433a.title.setText(this.eDC.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.eDC = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.eDC;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0433a {
        TbImageView esW;
        TextView title;

        C0433a() {
        }
    }
}
