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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> dJT;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.dJT)) {
            return 0;
        }
        return this.dJT.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (v.isEmpty(this.dJT)) {
            return null;
        }
        return this.dJT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0345a c0345a;
        if (view == null) {
            c0345a = new C0345a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0345a.dCx = (TbImageView) view.findViewById(R.id.cover);
            c0345a.dCx.setDrawerType(1);
            c0345a.dCx.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0345a.dCx.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0345a.dCx.setDefaultBgResource(R.color.transparent);
            c0345a.dCx.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0345a.title = (TextView) view.findViewById(R.id.title);
            am.setViewTextColor(c0345a.title, (int) R.color.cp_cont_f);
            view.setTag(c0345a);
        } else {
            c0345a = (C0345a) view.getTag();
        }
        c0345a.dCx.startLoad(this.dJT.get(i).iconUrl, 10, false);
        c0345a.title.setText(this.dJT.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.dJT = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.dJT;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0345a {
        TbImageView dCx;
        TextView title;

        C0345a() {
        }
    }
}
