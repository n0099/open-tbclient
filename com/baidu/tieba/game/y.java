package com.baidu.tieba.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BaseAdapter {
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
        z zVar;
        if (view == null || !(view.getTag() instanceof z)) {
            view = com.baidu.adp.lib.e.b.a().a(viewGroup.getContext(), com.baidu.tieba.v.game_detail_thumb_item, null);
            z zVar2 = new z(null);
            zVar2.a = (TbImageView) view.findViewById(com.baidu.tieba.u.game_detail_thumb_item_thumb_iv);
            zVar2.b = view.findViewById(com.baidu.tieba.u.game_detail_thumb_item_left_empty_view);
            zVar2.c = view.findViewById(com.baidu.tieba.u.game_detail_thumb_item_right_empty_view);
            zVar = zVar2;
        } else {
            zVar = (z) view.getTag();
        }
        zVar.b.setVisibility(i == 0 ? 0 : 8);
        zVar.c.setVisibility(i == getCount() + (-1) ? 0 : 8);
        zVar.a.a(this.a.get(i), 10, false);
        return view;
    }

    public void a(List<String> list) {
        this.a = list;
    }
}
