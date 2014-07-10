package com.baidu.tieba.im.live.room.intro;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.editortool.aa;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private LiveRoomIntroActivity a;
    private List<LiveCardData> b = null;
    private aa c;

    public aa a() {
        return this.c;
    }

    public b(LiveRoomIntroActivity liveRoomIntroActivity) {
        this.a = null;
        this.a = liveRoomIntroActivity;
        this.c = new aa(liveRoomIntroActivity);
        this.c.b(true);
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
        c a = c.a(this.a, view);
        LiveCardData item = getItem(i);
        if (item != null) {
            a.a(item);
        }
        if (i == 0) {
            a.a();
        } else {
            a.b();
        }
        this.a.changSkinType(a.c());
        return a.c();
    }
}
