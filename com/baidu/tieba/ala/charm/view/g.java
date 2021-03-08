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
/* loaded from: classes10.dex */
public class g extends BaseAdapter {
    private String gRH;
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
    private ArrayList<u> eXu = new ArrayList<>();

    public g(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.isHost = z;
    }

    public void setData(List<u> list) {
        if (list != null) {
            this.eXu.clear();
            this.eXu.addAll(list);
        }
        notifyDataSetChanged();
    }

    public ArrayList<u> getData() {
        return this.eXu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uo */
    public u getItem(int i) {
        if (this.eXu == null) {
            return null;
        }
        return this.eXu.get(i);
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
            aVar2.gRJ = (CharmPokeItemView) view.findViewById(a.f.pokeItem);
            aVar2.gRC = (CharmItemView) view.findViewById(a.f.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        u item = getItem(i);
        AlaLiveUserInfoData alaLiveUserInfoData = getItem(i).aJD;
        if (item != null && alaLiveUserInfoData != null) {
            boolean z = false;
            if (alaLiveUserInfoData.extInfoJson != null) {
                z = alaLiveUserInfoData.extInfoJson.optInt("is_mysterious_man") == 1;
            }
            if (!this.isHost || item.hadPoked == 0 || z) {
                aVar.gRJ.setVisibility(8);
                aVar.gRC.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
                aVar.gRC.gRs.setData(alaLiveUserInfoData);
                aVar.gRC.setVisibility(0);
            } else {
                aVar.gRC.setVisibility(8);
                aVar.gRJ.setData(2, i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L, item.hadPoked, alaLiveUserInfoData.userId, this.gRH);
                aVar.gRJ.gRs.setData(alaLiveUserInfoData);
                aVar.gRJ.setVisibility(0);
            }
            this.mPageContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void a(BdListView bdListView) {
        this.mListView = bdListView;
    }

    public void bF(int i, int i2) {
        u uVar = this.eXu.get(i);
        uVar.hadPoked = 1;
        this.eXu.set(i, uVar);
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
                    aVar.gRJ.gRu.setVisibility(8);
                    return;
                }
                aVar.gRJ.gRu.setEnabled(false);
                aVar.gRJ.gRu.setText(this.mPageContext.getString(a.h.sdk_poke_had_poked));
            }
        }
    }

    public void setLiveId(String str) {
        this.gRH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private CharmItemView gRC;
        private CharmPokeItemView gRJ;

        private a() {
        }
    }
}
