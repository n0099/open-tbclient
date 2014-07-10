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
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private static final int[] b = {u.icon_ba_news, u.icon_hot_check, u.icon_me_dynamic};
    private static final int[] c = {y.ba_square_description, y.post_recommend_title_description, y.ba_dongtai_description};
    private static final int[] d = {y.ba_square, y.post_recommend_title, y.ba_dongtai};
    Context a;

    public q(Context context) {
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
        r rVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(w.discover_square_item, viewGroup, false);
            r rVar2 = new r(null);
            rVar2.b = (TextView) view.findViewById(v.squre_name);
            rVar2.c = (BestStringsFitTextView) view.findViewById(v.description);
            rVar2.a = (HeadImageView) view.findViewById(v.portrait);
            view.setTag(rVar2);
            rVar = rVar2;
        } else {
            rVar = (r) view.getTag();
        }
        rVar.b.setText(d[i]);
        rVar.c.setText(c[i]);
        rVar.a.setImageResource(b[i]);
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
