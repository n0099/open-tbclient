package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.d<UpdatesItemData> {
    private TextView HX;
    private UpdatesActivity bck;
    private View bcl;
    private HeadImageView bcm;
    private TextView bcn;
    private TextView bco;
    private TextView bcp;
    private ImageView bcq;
    private RelativeLayout bcr;
    private RelativeLayout bcs;
    private UpdatesItemData bct;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity, w.updates_item);
        this.bck = updatesActivity;
        nu();
    }

    void nu() {
        this.bcl = this.ay.findViewById(v.root_view);
        this.bcm = (HeadImageView) this.bcl.findViewById(v.iv_head);
        this.bcn = (TextView) this.bcl.findViewById(v.tv_group_name);
        this.bco = (TextView) this.bcl.findViewById(v.tv_content);
        this.HX = (TextView) this.bcl.findViewById(v.tv_title);
        this.bcp = (TextView) this.bcl.findViewById(v.tv_time);
        this.bcq = (ImageView) this.bcl.findViewById(v.cb_select);
        this.bcr = (RelativeLayout) this.bcl.findViewById(v.layout_body);
        this.bcs = (RelativeLayout) this.bcl.findViewById(v.layout_title);
        this.bcm.setOnClickListener(new j(this));
        this.bcr.setClickable(true);
        this.bcr.setLongClickable(true);
        this.bcs.setClickable(true);
        this.bcs.setLongClickable(true);
        this.bcr.setOnClickListener(new k(this));
        this.bcr.setOnLongClickListener(new l(this));
        this.bcs.setOnClickListener(new m(this));
        this.bcs.setOnLongClickListener(new n(this));
        this.bcq.setOnClickListener(new o(this));
    }

    public void refresh() {
        if (this.bct != null) {
            if (this.bck.Ph()) {
                this.bcq.setVisibility(0);
            } else {
                this.bcq.setVisibility(8);
                this.bcr.setSelected(false);
            }
            String groupHeadUrl = this.bct.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.bcm.setTag(groupHeadUrl);
                this.bcm.c(groupHeadUrl, 10, false);
            } else {
                this.bcm.setTag(null);
            }
            this.bcm.setClickable(false);
            if (!TextUtils.isEmpty(this.bct.getTitle())) {
                this.HX.setText(this.bct.getTitle());
            } else {
                this.HX.setText(this.bck.getString(y.alert_title));
            }
            Date date = new Date();
            date.setTime(this.bct.getTime());
            this.bcp.setText(az.f(date));
            if (!TextUtils.isEmpty(this.bct.getContent())) {
                this.bco.setText(this.bct.getContent());
            } else {
                this.bco.setText("");
            }
            if (!TextUtils.isEmpty(this.bct.getGroupName())) {
                this.bcn.setText(this.bct.getGroupName());
            } else {
                this.bcn.setText("");
            }
            int paddingLeft = this.bcr.getPaddingLeft();
            int paddingTop = this.bcr.getPaddingTop();
            int paddingRight = this.bcr.getPaddingRight();
            int paddingBottom = this.bcr.getPaddingBottom();
            this.bck.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.bck.getLayoutMode().h(this.ay);
            this.bcq.setSelected(this.bct.isSelected());
            if (this.bct.isSelected()) {
                aw.h(this.bcr, u.bg_information_down_s);
            } else {
                aw.h(this.bcr, u.selector_group_updates_bottom_bg);
            }
            this.bcr.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.bct = updatesItemData;
    }
}
