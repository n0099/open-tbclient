package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView bQB;
    private UpdatesActivity gog;
    private View goh;
    private HeadImageView goi;
    private TextView goj;
    private TextView gok;
    private TextView gol;
    private ImageView gom;
    private RelativeLayout gon;
    private RelativeLayout goo;
    private UpdatesItemData gop;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.h.updates_item);
        this.gog = updatesActivity;
        initView();
    }

    void initView() {
        this.goh = this.vk.findViewById(d.g.root_view);
        this.goi = (HeadImageView) this.goh.findViewById(d.g.iv_head);
        this.goj = (TextView) this.goh.findViewById(d.g.tv_group_name);
        this.gok = (TextView) this.goh.findViewById(d.g.tv_content);
        this.bQB = (TextView) this.goh.findViewById(d.g.tv_title);
        this.gol = (TextView) this.goh.findViewById(d.g.tv_time);
        this.gom = (ImageView) this.goh.findViewById(d.g.cb_select);
        this.gon = (RelativeLayout) this.goh.findViewById(d.g.layout_body);
        this.goo = (RelativeLayout) this.goh.findViewById(d.g.layout_title);
        this.goi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gon.setClickable(true);
        this.gon.setLongClickable(true);
        this.goo.setClickable(true);
        this.goo.setLongClickable(true);
        this.gon.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gog.bbG()) {
                    b.this.gom.performClick();
                } else {
                    b.this.gog.a(b.this.goh, 101, 0, 0L, b.this.gop);
                }
            }
        });
        this.gon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gog.b(b.this.goh, 200, 0, 0L, b.this.gop);
                return true;
            }
        });
        this.goo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gog.a(b.this.goh, 101, 0, 0L, b.this.gop);
            }
        });
        this.goo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gog.b(b.this.goh, 200, 0, 0L, b.this.gop);
                return true;
            }
        });
        this.gom.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gog.a(view, view.isSelected(), b.this.gop);
            }
        });
    }

    public void refresh() {
        if (this.gop != null) {
            if (this.gog.bbG()) {
                this.gom.setVisibility(0);
            } else {
                this.gom.setVisibility(8);
                this.gon.setSelected(false);
            }
            String groupHeadUrl = this.gop.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.goi.setTag(groupHeadUrl);
                this.goi.startLoad(groupHeadUrl, 10, false);
            } else {
                this.goi.setTag(null);
            }
            this.goi.setClickable(false);
            if (!TextUtils.isEmpty(this.gop.getTitle())) {
                this.bQB.setText(this.gop.getTitle());
            } else {
                this.bQB.setText(this.gog.getPageContext().getString(d.j.inform));
            }
            Date date = new Date();
            date.setTime(this.gop.getTime());
            this.gol.setText(ap.m(date));
            if (!TextUtils.isEmpty(this.gop.getContent())) {
                this.gok.setText(this.gop.getContent());
            } else {
                this.gok.setText("");
            }
            if (!TextUtils.isEmpty(this.gop.getGroupName())) {
                this.goj.setText(this.gop.getGroupName());
            } else {
                this.goj.setText("");
            }
            int paddingLeft = this.gon.getPaddingLeft();
            int paddingTop = this.gon.getPaddingTop();
            int paddingRight = this.gon.getPaddingRight();
            int paddingBottom = this.gon.getPaddingBottom();
            this.gog.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gog.getLayoutMode().onModeChanged(this.vk);
            this.gom.setSelected(this.gop.isSelected());
            if (this.gop.isSelected() && this.gog.bbG()) {
                al.k(this.gon, d.f.bg_information_down_s);
            } else {
                al.k(this.gon, d.f.selector_group_updates_bottom_bg);
            }
            this.gon.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gop = updatesItemData;
    }
}
