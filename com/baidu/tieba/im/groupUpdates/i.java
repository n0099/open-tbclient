package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.Date;
/* loaded from: classes.dex */
public final class i extends com.baidu.adp.a.d<UpdatesItemData> {
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

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity, com.baidu.tieba.im.i.updates_item);
        this.l = updatesActivity;
        this.c = this.a.findViewById(com.baidu.tieba.im.h.root_view);
        this.d = (HeadImageView) this.c.findViewById(com.baidu.tieba.im.h.iv_head);
        this.e = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_group_name);
        this.f = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_content);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_title);
        this.h = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_time);
        this.i = (ImageView) this.c.findViewById(com.baidu.tieba.im.h.cb_select);
        this.j = (RelativeLayout) this.c.findViewById(com.baidu.tieba.im.h.layout_body);
        this.k = (RelativeLayout) this.c.findViewById(com.baidu.tieba.im.h.layout_title);
        this.d.setOnClickListener(new j(this));
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.k.setClickable(true);
        this.k.setLongClickable(true);
        this.j.setOnClickListener(new k(this));
        this.j.setOnLongClickListener(new l(this));
        this.k.setOnClickListener(new m(this));
        this.k.setOnLongClickListener(new n(this));
        this.i.setOnClickListener(new o(this));
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
                this.g.setText(this.l.getString(com.baidu.tieba.im.j.alerm_title));
            }
            Date date = new Date();
            date.setTime(this.m.getTime());
            this.h.setText(bc.e(date));
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
            boolean z = TbadkApplication.j().l() == 1;
            this.l.getLayoutMode().a(z);
            this.l.getLayoutMode().a(this.a);
            this.i.setSelected(this.m.isSelected());
            if (this.m.isSelected()) {
                this.j.setBackgroundResource(z ? com.baidu.tieba.im.g.bg_information_down_s_1 : com.baidu.tieba.im.g.bg_information_down_s);
            } else {
                this.j.setBackgroundResource(z ? com.baidu.tieba.im.g.selector_group_updates_bottom_bg_1 : com.baidu.tieba.im.g.selector_group_updates_bottom_bg);
            }
            this.j.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public final void a(UpdatesItemData updatesItemData) {
        this.m = updatesItemData;
    }
}
