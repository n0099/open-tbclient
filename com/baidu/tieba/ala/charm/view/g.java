package com.baidu.tieba.ala.charm.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends BaseAdapter {
    private String gFX;
    private boolean isHost;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.charm.view.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            g.this.bJ(message.arg1, message.arg2);
        }
    };
    private ArrayList<p> eOt = new ArrayList<>();

    public g(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.isHost = z;
    }

    public void setData(List<p> list) {
        if (list != null) {
            this.eOt.clear();
            this.eOt.addAll(list);
        }
        notifyDataSetChanged();
    }

    public ArrayList<p> getData() {
        return this.eOt;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vB */
    public p getItem(int i) {
        if (this.eOt == null) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.sdk_charm_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.gFZ = (CharmPokeItemView) view.findViewById(a.f.pokeItem);
            aVar2.gFS = (CharmItemView) view.findViewById(a.f.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        p item = getItem(i);
        AlaLiveUserInfoData alaLiveUserInfoData = getItem(i).aJV;
        if (item != null && alaLiveUserInfoData != null) {
            if (!this.isHost || item.hadPoked == 0) {
                aVar.gFZ.setVisibility(8);
                aVar.gFS.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
                aVar.gFS.gFI.setData(alaLiveUserInfoData);
            } else {
                aVar.gFS.setVisibility(8);
                aVar.gFZ.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L, item.hadPoked, alaLiveUserInfoData.userId, this.gFX);
                aVar.gFZ.gFI.setData(alaLiveUserInfoData);
            }
            this.mPageContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void a(BdListView bdListView) {
        this.mListView = bdListView;
    }

    public void bI(int i, int i2) {
        p pVar = this.eOt.get(i);
        pVar.hadPoked = 1;
        this.eOt.set(i, pVar);
        Message obtain = Message.obtain();
        obtain.arg1 = i;
        obtain.arg2 = i2;
        this.mHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(int i, int i2) {
        if (this.mListView != null) {
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mListView.getLastVisiblePosition();
            if (firstVisiblePosition <= i && i <= lastVisiblePosition) {
                a aVar = (a) this.mListView.getChildAt(i - firstVisiblePosition).getTag();
                if (i2 != 1) {
                    if (i2 != 0) {
                        return;
                    }
                    aVar.gFZ.gFK.setVisibility(8);
                    return;
                }
                aVar.gFZ.gFK.setEnabled(false);
                aVar.gFZ.gFK.setText(this.mPageContext.getString(a.h.sdk_poke_had_poked));
            }
        }
    }

    public void setLiveId(String str) {
        this.gFX = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private CharmItemView gFS;
        private CharmPokeItemView gFZ;

        private a() {
        }
    }
}
