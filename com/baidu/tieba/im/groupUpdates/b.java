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
    private TextView bQD;
    private UpdatesActivity gnT;
    private View gnU;
    private HeadImageView gnV;
    private TextView gnW;
    private TextView gnX;
    private TextView gnY;
    private ImageView gnZ;
    private RelativeLayout goa;
    private RelativeLayout gob;
    private UpdatesItemData goc;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.h.updates_item);
        this.gnT = updatesActivity;
        initView();
    }

    void initView() {
        this.gnU = this.vk.findViewById(d.g.root_view);
        this.gnV = (HeadImageView) this.gnU.findViewById(d.g.iv_head);
        this.gnW = (TextView) this.gnU.findViewById(d.g.tv_group_name);
        this.gnX = (TextView) this.gnU.findViewById(d.g.tv_content);
        this.bQD = (TextView) this.gnU.findViewById(d.g.tv_title);
        this.gnY = (TextView) this.gnU.findViewById(d.g.tv_time);
        this.gnZ = (ImageView) this.gnU.findViewById(d.g.cb_select);
        this.goa = (RelativeLayout) this.gnU.findViewById(d.g.layout_body);
        this.gob = (RelativeLayout) this.gnU.findViewById(d.g.layout_title);
        this.gnV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.goa.setClickable(true);
        this.goa.setLongClickable(true);
        this.gob.setClickable(true);
        this.gob.setLongClickable(true);
        this.goa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gnT.bbE()) {
                    b.this.gnZ.performClick();
                } else {
                    b.this.gnT.a(b.this.gnU, 101, 0, 0L, b.this.goc);
                }
            }
        });
        this.goa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gnT.b(b.this.gnU, 200, 0, 0L, b.this.goc);
                return true;
            }
        });
        this.gob.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gnT.a(b.this.gnU, 101, 0, 0L, b.this.goc);
            }
        });
        this.gob.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gnT.b(b.this.gnU, 200, 0, 0L, b.this.goc);
                return true;
            }
        });
        this.gnZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gnT.a(view, view.isSelected(), b.this.goc);
            }
        });
    }

    public void refresh() {
        if (this.goc != null) {
            if (this.gnT.bbE()) {
                this.gnZ.setVisibility(0);
            } else {
                this.gnZ.setVisibility(8);
                this.goa.setSelected(false);
            }
            String groupHeadUrl = this.goc.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gnV.setTag(groupHeadUrl);
                this.gnV.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gnV.setTag(null);
            }
            this.gnV.setClickable(false);
            if (!TextUtils.isEmpty(this.goc.getTitle())) {
                this.bQD.setText(this.goc.getTitle());
            } else {
                this.bQD.setText(this.gnT.getPageContext().getString(d.j.inform));
            }
            Date date = new Date();
            date.setTime(this.goc.getTime());
            this.gnY.setText(ap.m(date));
            if (!TextUtils.isEmpty(this.goc.getContent())) {
                this.gnX.setText(this.goc.getContent());
            } else {
                this.gnX.setText("");
            }
            if (!TextUtils.isEmpty(this.goc.getGroupName())) {
                this.gnW.setText(this.goc.getGroupName());
            } else {
                this.gnW.setText("");
            }
            int paddingLeft = this.goa.getPaddingLeft();
            int paddingTop = this.goa.getPaddingTop();
            int paddingRight = this.goa.getPaddingRight();
            int paddingBottom = this.goa.getPaddingBottom();
            this.gnT.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gnT.getLayoutMode().onModeChanged(this.vk);
            this.gnZ.setSelected(this.goc.isSelected());
            if (this.goc.isSelected() && this.gnT.bbE()) {
                al.k(this.goa, d.f.bg_information_down_s);
            } else {
                al.k(this.goa, d.f.selector_group_updates_bottom_bg);
            }
            this.goa.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.goc = updatesItemData;
    }
}
