package com.baidu.tieba.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private List<String> aHs;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHs == null) {
            return 0;
        }
        return this.aHs.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aHs.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        x xVar;
        if (view == null || !(view.getTag() instanceof x)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(viewGroup.getContext(), com.baidu.tieba.w.game_detail_thumb_item, null);
            x xVar2 = new x(null);
            xVar2.aHt = (TbImageView) view.findViewById(com.baidu.tieba.v.game_detail_thumb_item_thumb_iv);
            xVar2.aHu = view.findViewById(com.baidu.tieba.v.game_detail_thumb_item_left_empty_view);
            xVar2.aHv = view.findViewById(com.baidu.tieba.v.game_detail_thumb_item_right_empty_view);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        xVar.aHu.setVisibility(i == 0 ? 0 : 8);
        xVar.aHv.setVisibility(i == getCount() + (-1) ? 0 : 8);
        xVar.aHt.c(this.aHs.get(i), 10, false);
        return view;
    }

    public void setData(List<String> list) {
        this.aHs = list;
    }
}
