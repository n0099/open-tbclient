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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ArrayList<AlaSquareTabInfo> gUs;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.gUs)) {
            return 0;
        }
        return this.gUs.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (x.isEmpty(this.gUs)) {
            return null;
        }
        return this.gUs.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0632a c0632a;
        if (view == null) {
            c0632a = new C0632a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            c0632a.gFD = (TbImageView) view.findViewById(R.id.cover);
            c0632a.gFD.setDrawerType(1);
            c0632a.gFD.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0632a.gFD.setDefaultBgResource(R.color.transparent);
            c0632a.gFD.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0632a.title = (TextView) view.findViewById(R.id.title);
            ao.setViewTextColor(c0632a.title, R.color.CAM_X0106);
            view.setTag(c0632a);
        } else {
            c0632a = (C0632a) view.getTag();
        }
        c0632a.gFD.startLoad(this.gUs.get(i).iconUrl, 10, false);
        c0632a.title.setText(this.gUs.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gUs = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gUs;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0632a {
        TbImageView gFD;
        TextView title;

        C0632a() {
        }
    }
}
