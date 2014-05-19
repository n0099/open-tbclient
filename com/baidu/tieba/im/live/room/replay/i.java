package com.baidu.tieba.im.live.room.replay;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.LiveCardData;
import java.util.List;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private LiveRoomReplayActivity a;
    private List<LiveCardData> b = null;

    public i(LiveRoomReplayActivity liveRoomReplayActivity) {
        this.a = null;
        this.a = liveRoomReplayActivity;
    }

    public void a(List<LiveCardData> list) {
        this.b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public LiveCardData getItem(int i) {
        if (this.b == null || this.b.size() <= 0) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup);
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.im.live.room.intro.c a = com.baidu.tieba.im.live.room.intro.c.a(this.a, view);
        a.a(getItem(i));
        if (i == 0) {
            a.a();
        } else {
            a.b();
        }
        this.a.changSkinType(a.c());
        return a.c();
    }
}
