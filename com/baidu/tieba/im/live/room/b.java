package com.baidu.tieba.im.live.room;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import java.util.List;
import protobuf.QueryLiveGroupLikeList.LikeUserInfo;
/* loaded from: classes.dex */
public class b extends BaseAdapter implements AbsListView.OnScrollListener {
    private LiveGroupLikeListActivity a;
    private volatile boolean b;
    private List<LikeUserInfo> c = null;

    public b(LiveGroupLikeListActivity liveGroupLikeListActivity) {
        this.a = null;
        this.a = liveGroupLikeListActivity;
    }

    public void a(List<LikeUserInfo> list) {
        this.c = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public LikeUserInfo getItem(int i) {
        if (this.c != null) {
            return this.c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.b = false;
            notifyDataSetChanged();
            return;
        }
        this.b = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        c a = a(this.a, view);
        LikeUserInfo item = getItem(i);
        a.a(item.userName, item.portrait, item.time.intValue() * 1000, this.b);
        this.a.changSkinType(a.a());
        return a.a();
    }

    public c a(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
            return new c(this, context, null);
        }
        return (c) view.getTag();
    }
}
