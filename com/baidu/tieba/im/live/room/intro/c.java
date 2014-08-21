package com.baidu.tieba.im.live.room.intro;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class c {
    private View a;
    private LiveBroadcastCard b;
    private View c;
    private View d;

    public static c a(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
            return new c(context);
        }
        return (c) view.getTag();
    }

    private c(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = com.baidu.adp.lib.e.b.a().a(context, v.live_room_list_item, null);
        this.b = (LiveBroadcastCard) this.a.findViewById(u.live_rom_item);
        this.c = this.a.findViewById(u.live_rom_item_line_2dp);
        this.d = this.a.findViewById(u.live_rom_item_line_1dp);
    }

    public void a() {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    }

    public void b() {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
    }

    public View c() {
        return this.a;
    }

    public void a(LiveCardData liveCardData) {
        this.b.setData(liveCardData);
    }
}
