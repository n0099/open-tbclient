package com.baidu.tieba.game;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.GameListBaseItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bg extends BaseAdapter {
    private Context mContext;
    private List<GameInfoData> mData = new ArrayList(0);

    public bg(Context context) {
        this.mContext = context;
    }

    public void setData(List<GameInfoData> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData.isEmpty()) {
            return 1;
        }
        return this.mData.size();
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
        ag agVar;
        af afVar;
        switch (getItemViewType(i)) {
            case 0:
                if (!(view instanceof ag)) {
                    agVar = new ag(this.mContext, GameListBaseItem.SECOND_LINE_TYPE.TYPE_ALL_DOWNLOADS);
                    agVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                    agVar.setPadding(com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds30), 0, com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds32), 0);
                } else {
                    agVar = (ag) view;
                }
                agVar.setData(getItem(i));
                return agVar;
            case 1:
            default:
                if (!(view instanceof ag)) {
                    afVar = new af(this.mContext, GameListBaseItem.SECOND_LINE_TYPE.TYPE_ALL_DOWNLOADS);
                    afVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                    afVar.setPadding(com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds30), 0, com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds32), 0);
                } else {
                    afVar = (af) view;
                }
                afVar.setData(getItem(i));
                return afVar;
            case 2:
                if (!(view instanceof TextView)) {
                    return HI();
                }
                return view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.mData.isEmpty()) {
            return 2;
        }
        GameInfoData item = getItem(i);
        if (item != null && !StringUtils.isNull(item.getEditorRec())) {
            return 0;
        }
        return 1;
    }

    private TextView HI() {
        TextView textView = new TextView(this.mContext);
        textView.setText(com.baidu.tieba.y.game_center_waiting);
        textView.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_d));
        textView.setGravity(17);
        textView.setPadding(0, com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds134), 0, 0);
        textView.setTextSize(0, com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds32));
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        return textView;
    }
}
