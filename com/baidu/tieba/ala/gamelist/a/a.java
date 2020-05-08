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
    private ArrayList<AlaSquareTabInfo> fiL;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fiL)) {
            return 0;
        }
        return this.fiL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (v.isEmpty(this.fiL)) {
            return null;
        }
        return this.fiL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0489a c0489a;
        if (view == null) {
            c0489a = new C0489a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0489a.eXg = (TbImageView) view.findViewById(R.id.cover);
            c0489a.eXg.setDrawerType(1);
            c0489a.eXg.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0489a.eXg.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0489a.eXg.setDefaultBgResource(R.color.transparent);
            c0489a.eXg.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0489a.title = (TextView) view.findViewById(R.id.title);
            am.setViewTextColor(c0489a.title, (int) R.color.cp_cont_f);
            view.setTag(c0489a);
        } else {
            c0489a = (C0489a) view.getTag();
        }
        c0489a.eXg.startLoad(this.fiL.get(i).iconUrl, 10, false);
        c0489a.title.setText(this.fiL.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.fiL = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.fiL;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0489a {
        TbImageView eXg;
        TextView title;

        C0489a() {
        }
    }
}
