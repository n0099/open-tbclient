package com.baidu.tieba.game.classify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GameCategory;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private Context context;
    private ArrayList<GameCategory> lI = new ArrayList<>();

    public b(Context context) {
        this.context = context;
    }

    public void setData(List<GameCategory> list) {
        if (list != null && !list.isEmpty()) {
            this.lI.clear();
            for (GameCategory gameCategory : list) {
                if (gameCategory != null && gameCategory.id != null && gameCategory.id.intValue() > 0) {
                    this.lI.add(gameCategory);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lI == null || this.lI.isEmpty()) {
            return 0;
        }
        return this.lI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lI != null && i >= 0 && i < this.lI.size()) {
            return this.lI.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        Object item = getItem(i);
        if (item == null || !(item instanceof GameCategory)) {
            return null;
        }
        if (view == null || !(view.getTag() instanceof c)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.context, w.game_classify_item, null);
            cVar = new c(null);
            cVar.aJq = (TbClipImageView) view.findViewById(v.game_classify_head);
            cVar.aJt = (ImageView) view.findViewById(v.game_classify_arrow);
            cVar.aJu = view.findViewById(v.game_classify_line);
            cVar.aJr = (TextView) view.findViewById(v.game_classify_title);
            cVar.aJs = (TextView) view.findViewById(v.game_classify_subdesc);
            cVar.aJq.setDrawerType(1);
            cVar.aJq.setRadius(m.c(this.context, t.ds26));
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        GameCategory gameCategory = (GameCategory) item;
        cVar.aJq.c(gameCategory.icon_url, 10, false);
        if (StringUtils.isNull(gameCategory.name)) {
            cVar.aJr.setText(y.game_classify_text_default);
        } else {
            cVar.aJr.setText(gameCategory.name);
        }
        cVar.aJs.setText(a(gameCategory));
        cVar.HZ();
        return view;
    }

    private String a(GameCategory gameCategory) {
        if (gameCategory == null || gameCategory.game_list == null || gameCategory.game_list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = gameCategory.game_list.size();
        for (int i = 0; i < size; i++) {
            String str = gameCategory.game_list.get(i);
            if (!StringUtils.isNull(str)) {
                sb.append(str);
                if (i != size - 1) {
                    sb.append("、");
                }
            }
        }
        return sb.toString();
    }
}
