package com.baidu.tieba.ala.gamelist.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> fZk;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.fZk)) {
            return 0;
        }
        return this.fZk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (y.isEmpty(this.fZk)) {
            return null;
        }
        return this.fZk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0604a c0604a;
        if (view == null) {
            c0604a = new C0604a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0604a.fLR = (TbImageView) view.findViewById(R.id.cover);
            c0604a.fLR.setDrawerType(1);
            c0604a.fLR.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0604a.fLR.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0604a.fLR.setDefaultBgResource(R.color.transparent);
            c0604a.fLR.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0604a.title = (TextView) view.findViewById(R.id.title);
            ap.setViewTextColor(c0604a.title, (int) R.color.cp_cont_f);
            view.setTag(c0604a);
        } else {
            c0604a = (C0604a) view.getTag();
        }
        c0604a.fLR.startLoad(this.fZk.get(i).iconUrl, 10, false);
        c0604a.title.setText(this.fZk.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.fZk = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.fZk;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0604a {
        TbImageView fLR;
        TextView title;

        C0604a() {
        }
    }
}
