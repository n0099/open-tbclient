package com.baidu.tieba.im.live.livenotify;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.Date;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.d<UpdatesItemData> {
    private LiveNotifyActivity b;
    private UpdatesItemData c;
    private View d;
    private LiveNotifyCardView e;
    private HeadImageView f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private TextView j;

    public k(LiveNotifyActivity liveNotifyActivity) {
        super(liveNotifyActivity, w.live_notify_list_item);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.b = liveNotifyActivity;
        b();
    }

    void b() {
        this.d = a(v.live_notfiy_list_item_root);
        this.e = (LiveNotifyCardView) a(v.live_notfiy_list_item_card);
        this.f = (HeadImageView) a(v.live_notfiy_list_item_userinfo_head);
        this.g = (ImageView) a(v.live_notfiy_list_item_userinfo_delete);
        this.h = (TextView) a(v.live_notfiy_list_item_userinfo_name);
        this.i = (TextView) a(v.live_notfiy_list_item_userinfo_time);
        this.j = (TextView) a(v.live_notfiy_list_item_userinfo_content);
        this.d.setClickable(true);
        this.d.setOnClickListener(new l(this));
        this.g.setOnClickListener(new m(this));
        this.e.setOnClickListener(new n(this));
    }

    public void c() {
        if (this.c != null) {
            if (this.b.b()) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
                this.d.setSelected(false);
            }
            String groupHeadUrl = this.c.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.f.a(groupHeadUrl, 12, false);
            }
            this.f.setClickable(false);
            Date date = new Date();
            date.setTime(this.c.getTime());
            this.i.setText(bm.e(date));
            if (!TextUtils.isEmpty(this.c.getContent())) {
                this.j.setText(this.c.getContent());
            } else {
                this.j.setText("");
            }
            if (!TextUtils.isEmpty(this.c.getAuthorName())) {
                this.h.setText(this.c.getAuthorName());
            } else {
                this.h.setText("");
            }
            boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
            this.b.getLayoutMode().a(z);
            this.b.getLayoutMode().a(this.a);
            this.g.setSelected(this.c.isSelected());
            if (this.c.isSelected()) {
                this.d.setBackgroundResource(z ? u.bg_information_down_s_1 : u.bg_information_down_s);
            } else {
                this.d.setBackgroundResource(z ? u.selector_group_updates_bottom_bg_1 : u.selector_group_updates_bottom_bg);
            }
            if (this.c.getLiveCardData() != null) {
                this.e.setData(this.c.getLiveCardData());
            }
        }
    }

    public void a(UpdatesItemData updatesItemData) {
        b(updatesItemData);
        c();
    }

    public void b(UpdatesItemData updatesItemData) {
        this.c = updatesItemData;
    }
}
