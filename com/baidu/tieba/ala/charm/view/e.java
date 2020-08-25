package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends BaseAdapter {
    private List<ALaCharmData> mDatas;

    public void setData(List<ALaCharmData> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDatas != null) {
            return this.mDatas.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sZ */
    public ALaCharmData getItem(int i) {
        if (this.mDatas != null) {
            return this.mDatas.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        ALaCharmData item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.sdk_charm_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.fSa = (CharmItemView) view.findViewById(a.g.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (item = getItem(i)) != null) {
            aVar.fSa.setData(1, i + 4, item.user_name, item.portrait, 0L, item.forwardDiff);
            aVar.fSa.fRR.setupLevelIcon(item.level_id);
        }
        return view;
    }

    /* loaded from: classes7.dex */
    private class a {
        private CharmItemView fSa;

        private a() {
        }
    }
}
