package com.baidu.tieba.game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private List<String> a;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        y yVar;
        if (view == null || !(view.getTag() instanceof y)) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.v.game_detail_thumb_item, (ViewGroup) null);
            y yVar2 = new y(null);
            yVar2.a = (TbImageView) view.findViewById(com.baidu.tieba.u.game_detail_thumb_item_thumb_iv);
            yVar2.b = view.findViewById(com.baidu.tieba.u.game_detail_thumb_item_left_empty_view);
            yVar2.c = view.findViewById(com.baidu.tieba.u.game_detail_thumb_item_right_empty_view);
            yVar = yVar2;
        } else {
            yVar = (y) view.getTag();
        }
        yVar.b.setVisibility(i == 0 ? 0 : 8);
        yVar.c.setVisibility(i == getCount() + (-1) ? 0 : 8);
        yVar.a.a(this.a.get(i), 10, false);
        return view;
    }

    public void a(List<String> list) {
        this.a = list;
    }
}
