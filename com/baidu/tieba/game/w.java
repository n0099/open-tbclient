package com.baidu.tieba.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private List<String> aHC;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHC == null) {
            return 0;
        }
        return this.aHC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aHC.get(i);
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
            xVar2.aHD = (TbImageView) view.findViewById(com.baidu.tieba.v.game_detail_thumb_item_thumb_iv);
            xVar2.aHE = view.findViewById(com.baidu.tieba.v.game_detail_thumb_item_left_empty_view);
            xVar2.aHF = view.findViewById(com.baidu.tieba.v.game_detail_thumb_item_right_empty_view);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        xVar.aHE.setVisibility(i == 0 ? 0 : 8);
        xVar.aHF.setVisibility(i == getCount() + (-1) ? 0 : 8);
        xVar.aHD.c(this.aHC.get(i), 10, false);
        return view;
    }

    public void setData(List<String> list) {
        this.aHC = list;
    }
}
