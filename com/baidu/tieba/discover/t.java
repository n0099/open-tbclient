package com.baidu.tieba.discover;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.square.BestStringsFitTextView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    private static final int[] aob = {com.baidu.tieba.u.icon_ba_news, com.baidu.tieba.u.icon_hot_check, com.baidu.tieba.u.icon_me_dynamic};
    private static final int[] aoc = {y.ba_square_description, y.post_recommend_title_description, y.ba_dongtai_description};
    private static final int[] aod = {y.ba_square, y.post_recommend_title, y.ba_dongtai};
    Context mContext;

    public t(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return aoc.length;
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
        u uVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.discover_square_item, viewGroup, false);
            u uVar2 = new u(null);
            uVar2.QG = (TextView) view.findViewById(com.baidu.tieba.v.squre_name);
            uVar2.aoe = (BestStringsFitTextView) view.findViewById(com.baidu.tieba.v.description);
            uVar2.QF = (HeadImageView) view.findViewById(com.baidu.tieba.v.portrait);
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.QG.setText(aod[i]);
        uVar.aoe.setText(aoc[i]);
        uVar.QF.setImageResource(aob[i]);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        DiscoverSquareActivity discoverSquareActivity = (DiscoverSquareActivity) this.mContext;
        discoverSquareActivity.getLayoutMode().L(skinType == 1);
        discoverSquareActivity.getLayoutMode().h(view);
        return view;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }
}
