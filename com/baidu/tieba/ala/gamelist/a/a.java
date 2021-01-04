package com.baidu.tieba.ala.gamelist.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> gYY;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.gYY)) {
            return 0;
        }
        return this.gYY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (x.isEmpty(this.gYY)) {
            return null;
        }
        return this.gYY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0649a c0649a;
        if (view == null) {
            c0649a = new C0649a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0649a.gKj = (TbImageView) view.findViewById(R.id.cover);
            c0649a.gKj.setDrawerType(1);
            c0649a.gKj.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0649a.gKj.setDefaultBgResource(R.color.transparent);
            c0649a.gKj.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0649a.title = (TextView) view.findViewById(R.id.title);
            ao.setViewTextColor(c0649a.title, R.color.CAM_X0106);
            view.setTag(c0649a);
        } else {
            c0649a = (C0649a) view.getTag();
        }
        c0649a.gKj.startLoad(this.gYY.get(i).iconUrl, 10, false);
        c0649a.title.setText(this.gYY.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gYY = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gYY;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0649a {
        TbImageView gKj;
        TextView title;

        C0649a() {
        }
    }
}
