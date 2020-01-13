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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> ezu;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.ezu)) {
            return 0;
        }
        return this.ezu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (v.isEmpty(this.ezu)) {
            return null;
        }
        return this.ezu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0422a c0422a;
        if (view == null) {
            c0422a = new C0422a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0422a.eoL = (TbImageView) view.findViewById(R.id.cover);
            c0422a.eoL.setDrawerType(1);
            c0422a.eoL.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0422a.eoL.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0422a.eoL.setDefaultBgResource(R.color.transparent);
            c0422a.eoL.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0422a.title = (TextView) view.findViewById(R.id.title);
            am.setViewTextColor(c0422a.title, (int) R.color.cp_cont_f);
            view.setTag(c0422a);
        } else {
            c0422a = (C0422a) view.getTag();
        }
        c0422a.eoL.startLoad(this.ezu.get(i).iconUrl, 10, false);
        c0422a.title.setText(this.ezu.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.ezu = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.ezu;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0422a {
        TbImageView eoL;
        TextView title;

        C0422a() {
        }
    }
}
