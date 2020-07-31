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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> fNi;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.fNi)) {
            return 0;
        }
        return this.fNi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (x.isEmpty(this.fNi)) {
            return null;
        }
        return this.fNi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0557a c0557a;
        if (view == null) {
            c0557a = new C0557a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0557a.fAv = (TbImageView) view.findViewById(R.id.cover);
            c0557a.fAv.setDrawerType(1);
            c0557a.fAv.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0557a.fAv.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0557a.fAv.setDefaultBgResource(R.color.transparent);
            c0557a.fAv.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0557a.title = (TextView) view.findViewById(R.id.title);
            ao.setViewTextColor(c0557a.title, R.color.cp_cont_f);
            view.setTag(c0557a);
        } else {
            c0557a = (C0557a) view.getTag();
        }
        c0557a.fAv.startLoad(this.fNi.get(i).iconUrl, 10, false);
        c0557a.title.setText(this.fNi.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.fNi = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.fNi;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0557a {
        TbImageView fAv;
        TextView title;

        C0557a() {
        }
    }
}
