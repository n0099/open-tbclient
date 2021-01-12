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
/* loaded from: classes10.dex */
public class d extends BaseAdapter {
    private List<com.baidu.live.challenge.d> bbl;
    private a hsa;

    /* loaded from: classes10.dex */
    public interface a {
        void e(com.baidu.live.challenge.d dVar);

        void f(com.baidu.live.challenge.d dVar);
    }

    public a ccv() {
        return this.hsa;
    }

    public void a(a aVar) {
        this.hsa = aVar;
    }

    public void setData(List<com.baidu.live.challenge.d> list) {
        if (this.bbl == null) {
            this.bbl = new ArrayList();
        }
        this.bbl.clear();
        this.bbl.addAll(list);
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
                    item.aDO = dVar.aDO;
                    item.aDP = dVar.aDP;
                    break;
                }
            }
            if (i >= 0 && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                getView(i, childAt, absListView);
                if (!(childAt.getTag() instanceof b) || ((b) childAt.getTag()).hsd == null) {
                    return;
                }
                ((b) childAt.getTag()).hsd.setActionEnabled(z);
            }
        }
    }

    public void clearData() {
        if (this.bbl != null) {
            this.bbl.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbl != null) {
            return this.bbl.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vh */
    public com.baidu.live.challenge.d getItem(int i) {
        if (this.bbl != null) {
            return this.bbl.get(i);
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
            bVar2.hsd = (AlaChallengeTargetItemView) view.findViewById(a.f.item_challenge_latest_target);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.live.challenge.d item = getItem(i);
        if (item != null) {
            bVar.hsd.setCallback(new AlaChallengeTargetItemView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void ccw() {
                    if (d.this.hsa != null) {
                        d.this.hsa.e(item);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void ccx() {
                    if (d.this.hsa != null && d.this.d(item)) {
                        d.this.hsa.f(item);
                    }
                }
            });
            bVar.hsd.setActionEnabled(true);
            bVar.hsd.setData(item);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(com.baidu.live.challenge.d dVar) {
        boolean z = true;
        if (dVar == null) {
            return false;
        }
        if (dVar.liveStatus != 1 || dVar.aDO == 2 || dVar.aDP == 1) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private AlaChallengeTargetItemView hsd;

        private b() {
        }
    }
}
