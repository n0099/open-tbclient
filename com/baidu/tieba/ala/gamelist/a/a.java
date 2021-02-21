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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> gXq;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.gXq)) {
            return 0;
        }
        return this.gXq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (y.isEmpty(this.gXq)) {
            return null;
        }
        return this.gXq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0633a c0633a;
        if (view == null) {
            c0633a = new C0633a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0633a.gIB = (TbImageView) view.findViewById(R.id.cover);
            c0633a.gIB.setDrawerType(1);
            c0633a.gIB.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0633a.gIB.setDefaultBgResource(R.color.transparent);
            c0633a.gIB.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0633a.title = (TextView) view.findViewById(R.id.title);
            ap.setViewTextColor(c0633a.title, R.color.CAM_X0106);
            view.setTag(c0633a);
        } else {
            c0633a = (C0633a) view.getTag();
        }
        c0633a.gIB.startLoad(this.gXq.get(i).iconUrl, 10, false);
        c0633a.title.setText(this.gXq.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gXq = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gXq;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0633a {
        TbImageView gIB;
        TextView title;

        C0633a() {
        }
    }
}
