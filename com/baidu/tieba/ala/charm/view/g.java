package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends BaseAdapter {
    private ArrayList<p> eIM = new ArrayList<>();
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<p> list) {
        if (list != null) {
            this.eIM.clear();
            this.eIM.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM == null) {
            return 0;
        }
        return this.eIM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uw */
    public p getItem(int i) {
        if (this.eIM == null) {
            return null;
        }
        return this.eIM.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.sdk_charm_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.gxy = (CharmItemView) view.findViewById(a.f.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (alaLiveUserInfoData = getItem(i).aIV) != null) {
            aVar.gxy.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            aVar.gxy.gxq.setData(alaLiveUserInfoData);
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    private class a {
        private CharmItemView gxy;

        private a() {
        }
    }
}
