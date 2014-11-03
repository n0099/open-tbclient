package com.baidu.tieba.gamecategorydetail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.GameListBaseItem;
import com.baidu.tieba.game.af;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private List<GameInfoData> Yh = new ArrayList();
    private GameCategoryDetailActivity aKQ;

    public a(GameCategoryDetailActivity gameCategoryDetailActivity) {
        this.aKQ = gameCategoryDetailActivity;
    }

    public void setData(List<GameInfoData> list) {
        if (list != null) {
            this.Yh = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Yh == null || this.Yh.isEmpty()) {
            return 0;
        }
        int size = this.Yh.size();
        if (this.aKQ != null && this.aKQ.getHasMore() && size > 8) {
            return size + 1;
        }
        return size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ff */
    public GameInfoData getItem(int i) {
        if (this.Yh == null || this.Yh.size() == 0 || i < 0 || i > this.Yh.size() - 1) {
            return null;
        }
        return this.Yh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.Yh == null || i >= this.Yh.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        if (getItemViewType(i) == 0) {
            if (view instanceof af) {
                view2 = view;
            } else {
                view2 = new af(this.aKQ, GameListBaseItem.SECOND_LINE_TYPE.TYPE_ALL_DOWNLOADS);
                view2.setPadding(m.c(this.aKQ, t.ds30), 0, m.c(this.aKQ, t.ds32), 0);
            }
            af afVar = (af) view2;
            afVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            afVar.a(this.aKQ.getUniqueId(), getItem(i));
            return afVar;
        }
        if (view == null || !(view.getTag() instanceof b)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.aKQ, w.new_pb_list_more, null);
            b bVar2 = new b(this, null);
            bVar2.aJX = (TextView) view.findViewById(v.pb_more_text);
            bVar2.mProgress = (ProgressBar) view.findViewById(v.progress);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.aJX.setText(this.aKQ.getString(y.loading));
        bVar.mProgress.setVisibility(0);
        this.aKQ.getLayoutMode().h(view);
        aw.h(view, u.bg_neighbor_item);
        return view;
    }
}
