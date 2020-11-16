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
    private ArrayList<AlaSquareTabInfo> gEp;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.gEp)) {
            return 0;
        }
        return this.gEp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (y.isEmpty(this.gEp)) {
            return null;
        }
        return this.gEp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0645a c0645a;
        if (view == null) {
            c0645a = new C0645a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0645a.gqV = (TbImageView) view.findViewById(R.id.cover);
            c0645a.gqV.setDrawerType(1);
            c0645a.gqV.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0645a.gqV.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0645a.gqV.setDefaultBgResource(R.color.transparent);
            c0645a.gqV.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0645a.title = (TextView) view.findViewById(R.id.title);
            ap.setViewTextColor(c0645a.title, R.color.CAM_X0106);
            view.setTag(c0645a);
        } else {
            c0645a = (C0645a) view.getTag();
        }
        c0645a.gqV.startLoad(this.gEp.get(i).iconUrl, 10, false);
        c0645a.title.setText(this.gEp.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gEp = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gEp;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0645a {
        TbImageView gqV;
        TextView title;

        C0645a() {
        }
    }
}
