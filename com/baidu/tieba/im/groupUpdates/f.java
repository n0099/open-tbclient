package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.a.c<UpdatesItemData> {
    private View c;
    private HeadImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private RelativeLayout j;
    private RelativeLayout k;
    private UpdatesActivity l;
    private UpdatesItemData m;

    public f(UpdatesActivity updatesActivity) {
        super(updatesActivity, R.layout.updates_item);
        this.l = updatesActivity;
        this.c = this.a.findViewById(R.id.root_view);
        this.d = (HeadImageView) this.c.findViewById(R.id.iv_head);
        this.e = (TextView) this.c.findViewById(R.id.tv_group_name);
        this.f = (TextView) this.c.findViewById(R.id.tv_content);
        this.g = (TextView) this.c.findViewById(R.id.tv_title);
        this.h = (TextView) this.c.findViewById(R.id.tv_time);
        this.i = (ImageView) this.c.findViewById(R.id.cb_select);
        this.j = (RelativeLayout) this.c.findViewById(R.id.layout_body);
        this.k = (RelativeLayout) this.c.findViewById(R.id.layout_title);
        this.d.setOnClickListener(new g(this));
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.k.setClickable(true);
        this.k.setLongClickable(true);
        this.j.setOnClickListener(new h(this));
        this.j.setOnLongClickListener(new i(this));
        this.k.setOnClickListener(new j(this));
        this.k.setOnLongClickListener(new k(this));
        this.i.setOnClickListener(new l(this));
    }

    public final void d() {
        if (this.m != null) {
            if (this.l.b()) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
                this.j.setSelected(false);
            }
            String groupHeadUrl = this.m.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.d.setTag(groupHeadUrl);
            } else {
                this.d.setTag(null);
            }
            this.d.setClickable(false);
            if (!TextUtils.isEmpty(this.m.getTitle())) {
                this.g.setText(this.m.getTitle());
            } else {
                this.g.setText(this.l.getString(R.string.alerm_title));
            }
            Date date = new Date();
            date.setTime(this.m.getTime());
            this.h.setText(bs.d(date));
            if (!TextUtils.isEmpty(this.m.getContent())) {
                this.f.setText(this.m.getContent());
            } else {
                this.f.setText("");
            }
            if (!TextUtils.isEmpty(this.m.getGroupName())) {
                this.e.setText(this.m.getGroupName());
            } else {
                this.e.setText("");
            }
            int paddingLeft = this.j.getPaddingLeft();
            int paddingTop = this.j.getPaddingTop();
            int paddingRight = this.j.getPaddingRight();
            int paddingBottom = this.j.getPaddingBottom();
            boolean z = TiebaApplication.g().ae() == 1;
            this.l.getLayoutMode().a(z);
            this.l.getLayoutMode().a(this.a);
            this.i.setSelected(this.m.isSelected());
            if (this.m.isSelected()) {
                this.j.setBackgroundResource(z ? R.drawable.bg_information_down_s_1 : R.drawable.bg_information_down_s);
            } else {
                this.j.setBackgroundResource(z ? R.drawable.selector_group_updates_bottom_bg_1 : R.drawable.selector_group_updates_bottom_bg);
            }
            this.j.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public final void a(UpdatesItemData updatesItemData) {
        this.m = updatesItemData;
    }
}
