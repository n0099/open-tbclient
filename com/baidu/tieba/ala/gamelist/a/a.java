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
    private ArrayList<AlaSquareTabInfo> gcy;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.gcy)) {
            return 0;
        }
        return this.gcy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (y.isEmpty(this.gcy)) {
            return null;
        }
        return this.gcy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0600a c0600a;
        if (view == null) {
            c0600a = new C0600a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0600a.fPf = (TbImageView) view.findViewById(R.id.cover);
            c0600a.fPf.setDrawerType(1);
            c0600a.fPf.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0600a.fPf.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0600a.fPf.setDefaultBgResource(R.color.transparent);
            c0600a.fPf.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0600a.title = (TextView) view.findViewById(R.id.title);
            ap.setViewTextColor(c0600a.title, R.color.cp_cont_f);
            view.setTag(c0600a);
        } else {
            c0600a = (C0600a) view.getTag();
        }
        c0600a.fPf.startLoad(this.gcy.get(i).iconUrl, 10, false);
        c0600a.title.setText(this.gcy.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gcy = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gcy;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0600a {
        TbImageView fPf;
        TextView title;

        C0600a() {
        }
    }
}
