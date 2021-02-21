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
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class g extends BaseAdapter {
    private String gPY;
    private boolean isHost;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.charm.view.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            g.this.bG(message.arg1, message.arg2);
        }
    };
    private ArrayList<u> eVV = new ArrayList<>();

    public g(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.isHost = z;
    }

    public void setData(List<u> list) {
        if (list != null) {
            this.eVV.clear();
            this.eVV.addAll(list);
        }
        notifyDataSetChanged();
    }

    public ArrayList<u> getData() {
        return this.eVV;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: um */
    public u getItem(int i) {
        if (this.eVV == null) {
            return null;
        }
        return this.eVV.get(i);
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
            aVar2.gQa = (CharmPokeItemView) view.findViewById(a.f.pokeItem);
            aVar2.gPT = (CharmItemView) view.findViewById(a.f.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        u item = getItem(i);
        AlaLiveUserInfoData alaLiveUserInfoData = getItem(i).aId;
        if (item != null && alaLiveUserInfoData != null) {
            boolean z = false;
            if (alaLiveUserInfoData.extInfoJson != null) {
                z = alaLiveUserInfoData.extInfoJson.optInt("is_mysterious_man") == 1;
            }
            if (!this.isHost || item.hadPoked == 0 || z) {
                aVar.gQa.setVisibility(8);
                aVar.gPT.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
                aVar.gPT.gPJ.setData(alaLiveUserInfoData);
                aVar.gPT.setVisibility(0);
            } else {
                aVar.gPT.setVisibility(8);
                aVar.gQa.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L, item.hadPoked, alaLiveUserInfoData.userId, this.gPY);
                aVar.gQa.gPJ.setData(alaLiveUserInfoData);
                aVar.gQa.setVisibility(0);
            }
            this.mPageContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void a(BdListView bdListView) {
        this.mListView = bdListView;
    }

    public void bF(int i, int i2) {
        u uVar = this.eVV.get(i);
        uVar.hadPoked = 1;
        this.eVV.set(i, uVar);
        Message obtain = Message.obtain();
        obtain.arg1 = i;
        obtain.arg2 = i2;
        this.mHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(int i, int i2) {
        if (this.mListView != null) {
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mListView.getLastVisiblePosition();
            if (firstVisiblePosition <= i && i <= lastVisiblePosition) {
                a aVar = (a) this.mListView.getChildAt(i - firstVisiblePosition).getTag();
                if (i2 != 1) {
                    if (i2 != 0) {
                        return;
                    }
                    aVar.gQa.gPL.setVisibility(8);
                    return;
                }
                aVar.gQa.gPL.setEnabled(false);
                aVar.gQa.gPL.setText(this.mPageContext.getString(a.h.sdk_poke_had_poked));
            }
        }
    }

    public void setLiveId(String str) {
        this.gPY = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private CharmItemView gPT;
        private CharmPokeItemView gQa;

        private a() {
        }
    }
}
