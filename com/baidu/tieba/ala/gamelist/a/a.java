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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> gNo;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.gNo)) {
            return 0;
        }
        return this.gNo.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (y.isEmpty(this.gNo)) {
            return null;
        }
        return this.gNo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0658a c0658a;
        if (view == null) {
            c0658a = new C0658a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0658a.gzg = (TbImageView) view.findViewById(R.id.cover);
            c0658a.gzg.setDrawerType(1);
            c0658a.gzg.setDefaultErrorResource(R.drawable.ala_all_game_default_icon);
            c0658a.gzg.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0658a.gzg.setDefaultBgResource(R.color.transparent);
            c0658a.gzg.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0658a.title = (TextView) view.findViewById(R.id.title);
            ap.setViewTextColor(c0658a.title, (int) R.color.CAM_X0106);
            view.setTag(c0658a);
        } else {
            c0658a = (C0658a) view.getTag();
        }
        c0658a.gzg.startLoad(this.gNo.get(i).iconUrl, 10, false);
        c0658a.title.setText(this.gNo.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gNo = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gNo;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0658a {
        TbImageView gzg;
        TextView title;

        C0658a() {
        }
    }
}
