package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.a<UpdatesItemData> {
    private View b;
    private HeadImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private RelativeLayout i;
    private RelativeLayout j;
    private UpdatesActivity k;
    private UpdatesItemData l;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity, w.updates_item);
        this.k = updatesActivity;
        b();
    }

    void b() {
        this.b = this.a.findViewById(v.root_view);
        this.c = (HeadImageView) this.b.findViewById(v.iv_head);
        this.d = (TextView) this.b.findViewById(v.tv_group_name);
        this.e = (TextView) this.b.findViewById(v.tv_content);
        this.f = (TextView) this.b.findViewById(v.tv_title);
        this.g = (TextView) this.b.findViewById(v.tv_time);
        this.h = (ImageView) this.b.findViewById(v.cb_select);
        this.i = (RelativeLayout) this.b.findViewById(v.layout_body);
        this.j = (RelativeLayout) this.b.findViewById(v.layout_title);
        this.c.setOnClickListener(new j(this));
        this.i.setClickable(true);
        this.i.setLongClickable(true);
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.i.setOnClickListener(new k(this));
        this.i.setOnLongClickListener(new l(this));
        this.j.setOnClickListener(new m(this));
        this.j.setOnLongClickListener(new n(this));
        this.h.setOnClickListener(new o(this));
    }

    public void c() {
        if (this.l != null) {
            if (this.k.b()) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
                this.i.setSelected(false);
            }
            String groupHeadUrl = this.l.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.c.setTag(groupHeadUrl);
            } else {
                this.c.setTag(null);
            }
            this.c.setClickable(false);
            if (!TextUtils.isEmpty(this.l.getTitle())) {
                this.f.setText(this.l.getTitle());
            } else {
                this.f.setText(this.k.getString(y.alerm_title));
            }
            Date date = new Date();
            date.setTime(this.l.getTime());
            this.g.setText(bg.e(date));
            if (!TextUtils.isEmpty(this.l.getContent())) {
                this.e.setText(this.l.getContent());
            } else {
                this.e.setText("");
            }
            if (!TextUtils.isEmpty(this.l.getGroupName())) {
                this.d.setText(this.l.getGroupName());
            } else {
                this.d.setText("");
            }
            int paddingLeft = this.i.getPaddingLeft();
            int paddingTop = this.i.getPaddingTop();
            int paddingRight = this.i.getPaddingRight();
            int paddingBottom = this.i.getPaddingBottom();
            boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
            this.k.getLayoutMode().a(z);
            this.k.getLayoutMode().a(this.a);
            this.h.setSelected(this.l.isSelected());
            if (this.l.isSelected()) {
                this.i.setBackgroundResource(z ? u.bg_information_down_s_1 : u.bg_information_down_s);
            } else {
                this.i.setBackgroundResource(z ? u.selector_group_updates_bottom_bg_1 : u.selector_group_updates_bottom_bg);
            }
            this.i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void a(UpdatesItemData updatesItemData) {
        b(updatesItemData);
        c();
    }

    public void b(UpdatesItemData updatesItemData) {
        this.l = updatesItemData;
    }
}
