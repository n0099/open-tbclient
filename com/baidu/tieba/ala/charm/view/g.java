package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g extends BaseAdapter {
    private ArrayList<j> efX = new ArrayList<>();
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<j> list) {
        if (list != null) {
            this.efX.clear();
            this.efX.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.efX == null) {
            return 0;
        }
        return this.efX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tc */
    public j getItem(int i) {
        if (this.efX == null) {
            return null;
        }
        return this.efX.get(i);
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
            aVar2.fSa = (CharmItemView) view.findViewById(a.g.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (alaLiveUserInfoData = getItem(i).aDE) != null) {
            aVar.fSa.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            aVar.fSa.fRR.setData(alaLiveUserInfoData);
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes7.dex */
    private class a {
        private CharmItemView fSa;

        private a() {
        }
    }
}
