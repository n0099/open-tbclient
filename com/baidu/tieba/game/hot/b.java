package com.baidu.tieba.game.hot;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.GameListBaseItem;
import com.baidu.tieba.game.af;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private View.OnClickListener Hd = new c(this);
    private HotGameActivity aJP;
    private List<GameInfoData> list;

    public b(HotGameActivity hotGameActivity) {
        this.aJP = hotGameActivity;
    }

    public void setData(List<GameInfoData> list) {
        if (list != null && !list.isEmpty()) {
            this.list = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list == null || this.list.isEmpty()) {
            return 0;
        }
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.list != null && i >= 0 && i < this.list.size()) {
            return this.list.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        af afVar;
        Object item = getItem(i);
        if (!(item instanceof GameInfoData)) {
            return null;
        }
        if (view == null || !(view instanceof af)) {
            afVar = new af(this.aJP, GameListBaseItem.SECOND_LINE_TYPE.TYPE_DAY_DOWNLOADS);
            afVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            afVar.setPadding(m.c(this.aJP, t.ds30), 0, m.c(this.aJP, t.ds30), 0);
        } else {
            afVar = (af) view;
        }
        afVar.setTag(Integer.valueOf(i));
        afVar.setOnClickListener(this.Hd);
        afVar.setData((GameInfoData) item);
        return afVar;
    }
}
