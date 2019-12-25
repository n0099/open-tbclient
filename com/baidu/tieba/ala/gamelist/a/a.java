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
    private ArrayList<AlaSquareTabInfo> eyi;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.eyi)) {
            return 0;
        }
        return this.eyi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (v.isEmpty(this.eyi)) {
            return null;
        }
        return this.eyi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0419a c0419a;
        if (view == null) {
            c0419a = new C0419a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0419a.enx = (TbImageView) view.findViewById(R.id.cover);
            c0419a.enx.setDrawerType(1);
            c0419a.enx.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0419a.enx.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0419a.enx.setDefaultBgResource(R.color.transparent);
            c0419a.enx.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0419a.title = (TextView) view.findViewById(R.id.title);
            am.setViewTextColor(c0419a.title, (int) R.color.cp_cont_f);
            view.setTag(c0419a);
        } else {
            c0419a = (C0419a) view.getTag();
        }
        c0419a.enx.startLoad(this.eyi.get(i).iconUrl, 10, false);
        c0419a.title.setText(this.eyi.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.eyi = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.eyi;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0419a {
        TbImageView enx;
        TextView title;

        C0419a() {
        }
    }
}
