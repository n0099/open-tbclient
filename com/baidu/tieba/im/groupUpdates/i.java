package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.d<UpdatesItemData> {
    private TextView HW;
    private UpdatesActivity bbW;
    private View bbX;
    private HeadImageView bbY;
    private TextView bbZ;
    private TextView bca;
    private TextView bcb;
    private ImageView bcc;
    private RelativeLayout bcd;
    private RelativeLayout bce;
    private UpdatesItemData bcf;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity, w.updates_item);
        this.bbW = updatesActivity;
        nu();
    }

    void nu() {
        this.bbX = this.ay.findViewById(v.root_view);
        this.bbY = (HeadImageView) this.bbX.findViewById(v.iv_head);
        this.bbZ = (TextView) this.bbX.findViewById(v.tv_group_name);
        this.bca = (TextView) this.bbX.findViewById(v.tv_content);
        this.HW = (TextView) this.bbX.findViewById(v.tv_title);
        this.bcb = (TextView) this.bbX.findViewById(v.tv_time);
        this.bcc = (ImageView) this.bbX.findViewById(v.cb_select);
        this.bcd = (RelativeLayout) this.bbX.findViewById(v.layout_body);
        this.bce = (RelativeLayout) this.bbX.findViewById(v.layout_title);
        this.bbY.setOnClickListener(new j(this));
        this.bcd.setClickable(true);
        this.bcd.setLongClickable(true);
        this.bce.setClickable(true);
        this.bce.setLongClickable(true);
        this.bcd.setOnClickListener(new k(this));
        this.bcd.setOnLongClickListener(new l(this));
        this.bce.setOnClickListener(new m(this));
        this.bce.setOnLongClickListener(new n(this));
        this.bcc.setOnClickListener(new o(this));
    }

    public void refresh() {
        if (this.bcf != null) {
            if (this.bbW.Pe()) {
                this.bcc.setVisibility(0);
            } else {
                this.bcc.setVisibility(8);
                this.bcd.setSelected(false);
            }
            String groupHeadUrl = this.bcf.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.bbY.setTag(groupHeadUrl);
                this.bbY.c(groupHeadUrl, 10, false);
            } else {
                this.bbY.setTag(null);
            }
            this.bbY.setClickable(false);
            if (!TextUtils.isEmpty(this.bcf.getTitle())) {
                this.HW.setText(this.bcf.getTitle());
            } else {
                this.HW.setText(this.bbW.getString(y.alert_title));
            }
            Date date = new Date();
            date.setTime(this.bcf.getTime());
            this.bcb.setText(ay.f(date));
            if (!TextUtils.isEmpty(this.bcf.getContent())) {
                this.bca.setText(this.bcf.getContent());
            } else {
                this.bca.setText("");
            }
            if (!TextUtils.isEmpty(this.bcf.getGroupName())) {
                this.bbZ.setText(this.bcf.getGroupName());
            } else {
                this.bbZ.setText("");
            }
            int paddingLeft = this.bcd.getPaddingLeft();
            int paddingTop = this.bcd.getPaddingTop();
            int paddingRight = this.bcd.getPaddingRight();
            int paddingBottom = this.bcd.getPaddingBottom();
            this.bbW.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.bbW.getLayoutMode().h(this.ay);
            this.bcc.setSelected(this.bcf.isSelected());
            if (this.bcf.isSelected()) {
                aw.h(this.bcd, u.bg_information_down_s);
            } else {
                aw.h(this.bcd, u.selector_group_updates_bottom_bg);
            }
            this.bcd.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.bcf = updatesItemData;
    }
}
