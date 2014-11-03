package com.baidu.tieba.game.gamesearch;

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
public class j extends BaseAdapter {
    private GameSearchActivity aJV;
    private List<GameInfoData> Yh = new ArrayList();
    private View.OnClickListener aJW = null;

    public j(GameSearchActivity gameSearchActivity) {
        this.aJV = gameSearchActivity;
    }

    public void setData(List<GameInfoData> list) {
        if (list != null && !list.isEmpty()) {
            this.Yh = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Yh == null || this.Yh.isEmpty()) {
            return 0;
        }
        int size = this.Yh.size();
        if (this.aJV != null && this.aJV.getHasMore()) {
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

    public void p(View.OnClickListener onClickListener) {
        this.aJW = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.Yh == null || i >= this.Yh.size()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        View view2;
        if (getItemViewType(i) == 0) {
            if (view instanceof af) {
                view2 = view;
            } else {
                view2 = new af(this.aJV, GameListBaseItem.SECOND_LINE_TYPE.TYPE_ALL_DOWNLOADS);
                view2.setPadding(m.c(this.aJV, t.ds30), 0, m.c(this.aJV, t.ds32), 0);
            }
            af afVar = (af) view2;
            afVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            afVar.a(this.aJV.getUniqueId(), getItem(i));
            return afVar;
        }
        if (view == null || !(view.getTag() instanceof k)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.aJV, w.new_pb_list_more, null);
            k kVar2 = new k(this, null);
            kVar2.aJX = (TextView) view.findViewById(v.pb_more_text);
            kVar2.mProgress = (ProgressBar) view.findViewById(v.progress);
            view.setOnClickListener(this.aJW);
            view.setTag(kVar2);
            kVar = kVar2;
        } else {
            kVar = (k) view.getTag();
        }
        kVar.aJX.setText(this.aJV.getString(y.loading));
        kVar.mProgress.setVisibility(0);
        this.aJV.getLayoutMode().h(view);
        aw.h(view, u.bg_neighbor_item);
        return view;
    }
}
