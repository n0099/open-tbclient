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
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private List<com.baidu.live.challenge.d> fKA;
    private a gaq;

    /* loaded from: classes3.dex */
    public interface a {
        void e(com.baidu.live.challenge.d dVar);

        void f(com.baidu.live.challenge.d dVar);
    }

    public a bDd() {
        return this.gaq;
    }

    public void a(a aVar) {
        this.gaq = aVar;
    }

    public void setData(List<com.baidu.live.challenge.d> list) {
        if (this.fKA == null) {
            this.fKA = new ArrayList();
        }
        this.fKA.clear();
        this.fKA.addAll(list);
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
                    item.awo = dVar.awo;
                    break;
                }
            }
            if (i >= 0 && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                getView(i, childAt, absListView);
                if (!(childAt.getTag() instanceof b) || ((b) childAt.getTag()).gat == null) {
                    return;
                }
                ((b) childAt.getTag()).gat.setActionEnabled(z);
            }
        }
    }

    public void clearData() {
        if (this.fKA != null) {
            this.fKA.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fKA != null) {
            return this.fKA.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rs */
    public com.baidu.live.challenge.d getItem(int i) {
        if (this.fKA != null) {
            return this.fKA.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_challenge_latest_list_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.gat = (AlaChallengeTargetItemView) view.findViewById(a.g.item_challenge_latest_target);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.live.challenge.d item = getItem(i);
        if (item != null) {
            bVar.gat.setCallback(new AlaChallengeTargetItemView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void bDe() {
                    if (d.this.gaq != null) {
                        d.this.gaq.e(item);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void bDf() {
                    if (d.this.gaq != null && d.this.d(item)) {
                        d.this.gaq.f(item);
                    }
                }
            });
            bVar.gat.setActionEnabled(true);
            bVar.gat.setData(item);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(com.baidu.live.challenge.d dVar) {
        boolean z = true;
        if (dVar == null) {
            return false;
        }
        if (dVar.liveStatus != 1 || dVar.awo == 2) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private AlaChallengeTargetItemView gat;

        private b() {
        }
    }
}
