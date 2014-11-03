package com.baidu.tieba.game.newgame;

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
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private GameNewActivity aKh;
    private boolean aKi;
    private com.baidu.tieba.game.view.c aKj;
    private List<GameInfoData> mData = new ArrayList(0);

    public d(GameNewActivity gameNewActivity) {
        this.aKh = gameNewActivity;
    }

    public void a(com.baidu.tieba.game.view.c cVar) {
        this.aKj = cVar;
    }

    public List<GameInfoData> getData() {
        return this.mData;
    }

    public void co(boolean z) {
        this.aKi = z;
    }

    public void Im() {
        if (!this.aKi) {
            this.aKi = true;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.aKi ? 1 : 0) + this.mData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) == null ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ff */
    public GameInfoData getItem(int i) {
        if (i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 1:
                return H(view);
            default:
                return a(i, view);
        }
    }

    private View a(int i, View view) {
        af afVar;
        if (!(view instanceof af)) {
            afVar = new af(this.aKh, GameListBaseItem.SECOND_LINE_TYPE.TYPE_CATEGORY);
            afVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            afVar.setPadding(m.c(this.aKh, t.ds30), 0, m.c(this.aKh, t.ds32), 0);
            afVar.setOnItemDownloadClick(this.aKj);
        } else {
            afVar = (af) view;
        }
        GameInfoData item = getItem(i);
        if (item.getGameType() == 2) {
            String str = "";
            if (item != null && item.getCategoryName() != null) {
                str = item.getCategoryName();
            }
            afVar.setGameInfoStr(str);
        }
        afVar.a(this.aKh.getUniqueId(), item);
        return afVar;
    }

    private View H(View view) {
        e eVar;
        if (view == null || !(view.getTag() instanceof e)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.aKh, w.new_pb_list_more, null);
            e eVar2 = new e(this, null);
            eVar2.aJX = (TextView) view.findViewById(v.pb_more_text);
            eVar2.mProgress = (ProgressBar) view.findViewById(v.progress);
            view.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
        }
        eVar.aJX.setText(TbadkApplication.m251getInst().getString(y.loading));
        eVar.aJX.setTextColor(aw.getColor(s.pb_more_txt));
        eVar.mProgress.setVisibility(0);
        return view;
    }
}
