package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private List<com.baidu.live.challenge.d> bsU;
    private a hbt;

    /* loaded from: classes4.dex */
    public interface a {
        void e(com.baidu.live.challenge.d dVar);

        void f(com.baidu.live.challenge.d dVar);
    }

    public a cah() {
        return this.hbt;
    }

    public void a(a aVar) {
        this.hbt = aVar;
    }

    public void setData(List<com.baidu.live.challenge.d> list) {
        if (this.bsU == null) {
            this.bsU = new ArrayList();
        }
        this.bsU.clear();
        this.bsU.addAll(list);
        notifyDataSetChanged();
    }

    public void a(AbsListView absListView, com.baidu.live.challenge.d dVar, boolean z) {
        int count;
        int firstVisiblePosition;
        View childAt;
        if (dVar != null && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                com.baidu.live.challenge.d item = getItem(i);
                if (!dVar.equals(item)) {
                    i++;
                } else {
                    item.liveStatus = dVar.liveStatus;
                    item.aHi = dVar.aHi;
                    item.aHj = dVar.aHj;
                    break;
                }
            }
            if (i >= 0 && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                getView(i, childAt, absListView);
                if (!(childAt.getTag() instanceof b) || ((b) childAt.getTag()).hbw == null) {
                    return;
                }
                ((b) childAt.getTag()).hbw.setActionEnabled(z);
            }
        }
    }

    public void clearData() {
        if (this.bsU != null) {
            this.bsU.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bsU != null) {
            return this.bsU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vz */
    public com.baidu.live.challenge.d getItem(int i) {
        if (this.bsU != null) {
            return this.bsU.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_challenge_latest_list_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.hbw = (AlaChallengeTargetItemView) view.findViewById(a.f.item_challenge_latest_target);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.live.challenge.d item = getItem(i);
        if (item != null) {
            bVar.hbw.setCallback(new AlaChallengeTargetItemView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void cai() {
                    if (d.this.hbt != null) {
                        d.this.hbt.e(item);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void caj() {
                    if (d.this.hbt != null && d.this.d(item)) {
                        d.this.hbt.f(item);
                    }
                }
            });
            bVar.hbw.setActionEnabled(true);
            bVar.hbw.setData(item);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(com.baidu.live.challenge.d dVar) {
        boolean z = true;
        if (dVar == null) {
            return false;
        }
        if (dVar.liveStatus != 1 || dVar.aHi == 2 || dVar.aHj == 1) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        private AlaChallengeTargetItemView hbw;

        private b() {
        }
    }
}
