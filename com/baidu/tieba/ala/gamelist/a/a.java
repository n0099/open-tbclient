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
    private ArrayList<AlaSquareTabInfo> gXc;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.gXc)) {
            return 0;
        }
        return this.gXc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (y.isEmpty(this.gXc)) {
            return null;
        }
        return this.gXc.get(i);
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
            c0632a.gIn = (TbImageView) view.findViewById(R.id.cover);
            c0632a.gIn.setDrawerType(1);
            c0632a.gIn.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c0632a.gIn.setDefaultBgResource(R.color.transparent);
            c0632a.gIn.setRadius(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds20));
            c0632a.title = (TextView) view.findViewById(R.id.title);
            ap.setViewTextColor(c0632a.title, R.color.CAM_X0106);
            view.setTag(c0632a);
        } else {
            c0632a = (C0632a) view.getTag();
        }
        c0632a.gIn.startLoad(this.gXc.get(i).iconUrl, 10, false);
        c0632a.title.setText(this.gXc.get(i).name);
        return view;
    }

    public void setData(ArrayList<AlaSquareTabInfo> arrayList) {
        this.gXc = arrayList;
    }

    public ArrayList<AlaSquareTabInfo> getData() {
        return this.gXc;
    }

    /* renamed from: com.baidu.tieba.ala.gamelist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0632a {
        TbImageView gIn;
        TextView title;

        C0632a() {
        }
    }
}
