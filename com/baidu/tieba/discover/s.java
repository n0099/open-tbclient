package com.baidu.tieba.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.square.BestStringsFitTextView;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private static final int[] b = {com.baidu.tieba.t.icon_ba_news, com.baidu.tieba.t.icon_hot_check, com.baidu.tieba.t.icon_me_dynamic};
    private static final int[] c = {x.ba_square_description, x.post_recommend_title_description, x.ba_dongtai_description};
    private static final int[] d = {x.ba_square, x.post_recommend_title, x.ba_dongtai};
    Context a;

    public s(Context context) {
        this.a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return c.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        t tVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.discover_square_item, viewGroup, false);
            t tVar2 = new t(null);
            tVar2.b = (TextView) view.findViewById(com.baidu.tieba.u.squre_name);
            tVar2.c = (BestStringsFitTextView) view.findViewById(com.baidu.tieba.u.description);
            tVar2.a = (HeadImageView) view.findViewById(com.baidu.tieba.u.portrait);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        tVar.b.setText(d[i]);
        tVar.c.setText(c[i]);
        tVar.a.setImageResource(b[i]);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        DiscoverSquareActivity discoverSquareActivity = (DiscoverSquareActivity) this.a;
        discoverSquareActivity.getLayoutMode().a(skinType == 1);
        discoverSquareActivity.getLayoutMode().a(view);
        return view;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }
}
