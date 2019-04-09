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
    private TextView bQE;
    private UpdatesActivity gnU;
    private View gnV;
    private HeadImageView gnW;
    private TextView gnX;
    private TextView gnY;
    private TextView gnZ;
    private ImageView goa;
    private RelativeLayout gob;
    private RelativeLayout goc;
    private UpdatesItemData god;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.h.updates_item);
        this.gnU = updatesActivity;
        initView();
    }

    void initView() {
        this.gnV = this.vk.findViewById(d.g.root_view);
        this.gnW = (HeadImageView) this.gnV.findViewById(d.g.iv_head);
        this.gnX = (TextView) this.gnV.findViewById(d.g.tv_group_name);
        this.gnY = (TextView) this.gnV.findViewById(d.g.tv_content);
        this.bQE = (TextView) this.gnV.findViewById(d.g.tv_title);
        this.gnZ = (TextView) this.gnV.findViewById(d.g.tv_time);
        this.goa = (ImageView) this.gnV.findViewById(d.g.cb_select);
        this.gob = (RelativeLayout) this.gnV.findViewById(d.g.layout_body);
        this.goc = (RelativeLayout) this.gnV.findViewById(d.g.layout_title);
        this.gnW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gob.setClickable(true);
        this.gob.setLongClickable(true);
        this.goc.setClickable(true);
        this.goc.setLongClickable(true);
        this.gob.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gnU.bbE()) {
                    b.this.goa.performClick();
                } else {
                    b.this.gnU.a(b.this.gnV, 101, 0, 0L, b.this.god);
                }
            }
        });
        this.gob.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gnU.b(b.this.gnV, 200, 0, 0L, b.this.god);
                return true;
            }
        });
        this.goc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gnU.a(b.this.gnV, 101, 0, 0L, b.this.god);
            }
        });
        this.goc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gnU.b(b.this.gnV, 200, 0, 0L, b.this.god);
                return true;
            }
        });
        this.goa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gnU.a(view, view.isSelected(), b.this.god);
            }
        });
    }

    public void refresh() {
        if (this.god != null) {
            if (this.gnU.bbE()) {
                this.goa.setVisibility(0);
            } else {
                this.goa.setVisibility(8);
                this.gob.setSelected(false);
            }
            String groupHeadUrl = this.god.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gnW.setTag(groupHeadUrl);
                this.gnW.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gnW.setTag(null);
            }
            this.gnW.setClickable(false);
            if (!TextUtils.isEmpty(this.god.getTitle())) {
                this.bQE.setText(this.god.getTitle());
            } else {
                this.bQE.setText(this.gnU.getPageContext().getString(d.j.inform));
            }
            Date date = new Date();
            date.setTime(this.god.getTime());
            this.gnZ.setText(ap.m(date));
            if (!TextUtils.isEmpty(this.god.getContent())) {
                this.gnY.setText(this.god.getContent());
            } else {
                this.gnY.setText("");
            }
            if (!TextUtils.isEmpty(this.god.getGroupName())) {
                this.gnX.setText(this.god.getGroupName());
            } else {
                this.gnX.setText("");
            }
            int paddingLeft = this.gob.getPaddingLeft();
            int paddingTop = this.gob.getPaddingTop();
            int paddingRight = this.gob.getPaddingRight();
            int paddingBottom = this.gob.getPaddingBottom();
            this.gnU.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gnU.getLayoutMode().onModeChanged(this.vk);
            this.goa.setSelected(this.god.isSelected());
            if (this.god.isSelected() && this.gnU.bbE()) {
                al.k(this.gob, d.f.bg_information_down_s);
            } else {
                al.k(this.gob, d.f.selector_group_updates_bottom_bg);
            }
            this.gob.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.god = updatesItemData;
    }
}
