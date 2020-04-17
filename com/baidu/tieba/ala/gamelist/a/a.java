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
    private ArrayList<AlaSquareTabInfo> fiG;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fiG)) {
            return 0;
        }
        return this.fiG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (v.isEmpty(this.fiG)) {
            return null;
        }
        return this.fiG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0468a c0468a;
        if (view == null) {
            c0468a = new C0468a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0468a.eXb = (TbImageView) view.findViewById(R.id.cover);
            c0468a.eXb.setDrawerType(1);
            c0468a.eXb.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0468a.eXb.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0468a.eXb.setDefaultBgResource(R.color.transparent);
            c0468a.eXb.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0468a.title = (TextView) view.findViewById(R.id.title);
            am.setViewTextColor(c0468a.title, (int) R.color.cp_cont_f);
            view.setTag(c0468a);
        } else {
            c0468a = (C0468a) view.getTag();
        }
        c0468a.eXb.startLoad(this.fiG.get(i).iconUrl, 10, false);
        c0468a.title.setText(this.fiG.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.fiG = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.fiG;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0468a {
        TbImageView eXb;
        TextView title;

        C0468a() {
        }
    }
}
