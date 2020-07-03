package com.baidu.tieba.ala.gamelist.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> fHN;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.fHN)) {
            return 0;
        }
        return this.fHN.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (w.isEmpty(this.fHN)) {
            return null;
        }
        return this.fHN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0546a c0546a;
        if (view == null) {
            c0546a = new C0546a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0546a.fvo = (TbImageView) view.findViewById(R.id.cover);
            c0546a.fvo.setDrawerType(1);
            c0546a.fvo.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0546a.fvo.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0546a.fvo.setDefaultBgResource(R.color.transparent);
            c0546a.fvo.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0546a.title = (TextView) view.findViewById(R.id.title);
            an.setViewTextColor(c0546a.title, (int) R.color.cp_cont_f);
            view.setTag(c0546a);
        } else {
            c0546a = (C0546a) view.getTag();
        }
        c0546a.fvo.startLoad(this.fHN.get(i).iconUrl, 10, false);
        c0546a.title.setText(this.fHN.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.fHN = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.fHN;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0546a {
        TbImageView fvo;
        TextView title;

        C0546a() {
        }
    }
}
