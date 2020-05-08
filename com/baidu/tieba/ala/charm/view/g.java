package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private ArrayList<com.baidu.live.data.g> dvu = new ArrayList<>();
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.live.data.g> list) {
        if (list != null) {
            this.dvu.clear();
            this.dvu.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvu == null) {
            return 0;
        }
        return this.dvu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pz */
    public com.baidu.live.data.g getItem(int i) {
        if (this.dvu == null) {
            return null;
        }
        return this.dvu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.sdk_charm_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.fcA = (CharmItemView) view.findViewById(a.g.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (alaLiveUserInfoData = getItem(i).aqk) != null) {
            aVar.fcA.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            aVar.fcA.fcr.setData(alaLiveUserInfoData);
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        private CharmItemView fcA;

        private a() {
        }
    }
}
