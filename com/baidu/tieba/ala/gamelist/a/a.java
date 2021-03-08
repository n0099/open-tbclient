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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> gYZ;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.gYZ)) {
            return 0;
        }
        return this.gYZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (y.isEmpty(this.gYZ)) {
            return null;
        }
        return this.gYZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0639a c0639a;
        if (view == null) {
            c0639a = new C0639a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0639a.gKk = (TbImageView) view.findViewById(R.id.cover);
            c0639a.gKk.setDrawerType(1);
            c0639a.gKk.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0639a.gKk.setDefaultBgResource(R.color.transparent);
            c0639a.gKk.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0639a.title = (TextView) view.findViewById(R.id.title);
            ap.setViewTextColor(c0639a.title, R.color.CAM_X0106);
            view.setTag(c0639a);
        } else {
            c0639a = (C0639a) view.getTag();
        }
        c0639a.gKk.startLoad(this.gYZ.get(i).iconUrl, 10, false);
        c0639a.title.setText(this.gYZ.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gYZ = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gYZ;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0639a {
        TbImageView gKk;
        TextView title;

        C0639a() {
        }
    }
}
