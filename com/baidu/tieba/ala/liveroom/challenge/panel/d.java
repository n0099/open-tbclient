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
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private List<com.baidu.live.challenge.d> ber;
    private a hwy;

    /* loaded from: classes11.dex */
    public interface a {
        void e(com.baidu.live.challenge.d dVar);

        void f(com.baidu.live.challenge.d dVar);
    }

    public a cdx() {
        return this.hwy;
    }

    public void a(a aVar) {
        this.hwy = aVar;
    }

    public void setData(List<com.baidu.live.challenge.d> list) {
        if (this.ber == null) {
            this.ber = new ArrayList();
        }
        this.ber.clear();
        this.ber.addAll(list);
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
                    item.aFB = dVar.aFB;
                    item.aFC = dVar.aFC;
                    break;
                }
            }
            if (i >= 0 && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                getView(i, childAt, absListView);
                if (!(childAt.getTag() instanceof b) || ((b) childAt.getTag()).hwB == null) {
                    return;
                }
                ((b) childAt.getTag()).hwB.setActionEnabled(z);
            }
        }
    }

    public void clearData() {
        if (this.ber != null) {
            this.ber.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ber != null) {
            return this.ber.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vs */
    public com.baidu.live.challenge.d getItem(int i) {
        if (this.ber != null) {
            return this.ber.get(i);
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
            bVar2.hwB = (AlaChallengeTargetItemView) view.findViewById(a.f.item_challenge_latest_target);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.live.challenge.d item = getItem(i);
        if (item != null) {
            bVar.hwB.setCallback(new AlaChallengeTargetItemView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.d.1
                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void cdy() {
                    if (d.this.hwy != null) {
                        d.this.hwy.e(item);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeTargetItemView.a
                public void cdz() {
                    if (d.this.hwy != null && d.this.d(item)) {
                        d.this.hwy.f(item);
                    }
                }
            });
            bVar.hwB.setActionEnabled(true);
            bVar.hwB.setData(item);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(com.baidu.live.challenge.d dVar) {
        boolean z = true;
        if (dVar == null) {
            return false;
        }
        if (dVar.liveStatus != 1 || dVar.aFB == 2 || dVar.aFC == 1) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private AlaChallengeTargetItemView hwB;

        private b() {
        }
    }
}
