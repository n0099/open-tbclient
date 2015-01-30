package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<UpdatesActivity> {
    private TextView Nm;
    private View awy;
    private UpdatesActivity bhk;
    private HeadImageView bhl;
    private TextView bhm;
    private TextView bhn;
    private TextView bho;
    private ImageView bhp;
    private RelativeLayout bhq;
    private RelativeLayout bhr;
    private UpdatesItemData data;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), x.updates_item);
        this.bhk = updatesActivity;
        initView();
    }

    void initView() {
        this.awy = this.mConvertView.findViewById(w.root_view);
        this.bhl = (HeadImageView) this.awy.findViewById(w.iv_head);
        this.bhm = (TextView) this.awy.findViewById(w.tv_group_name);
        this.bhn = (TextView) this.awy.findViewById(w.tv_content);
        this.Nm = (TextView) this.awy.findViewById(w.tv_title);
        this.bho = (TextView) this.awy.findViewById(w.tv_time);
        this.bhp = (ImageView) this.awy.findViewById(w.cb_select);
        this.bhq = (RelativeLayout) this.awy.findViewById(w.layout_body);
        this.bhr = (RelativeLayout) this.awy.findViewById(w.layout_title);
        this.bhl.setOnClickListener(new j(this));
        this.bhq.setClickable(true);
        this.bhq.setLongClickable(true);
        this.bhr.setClickable(true);
        this.bhr.setLongClickable(true);
        this.bhq.setOnClickListener(new k(this));
        this.bhq.setOnLongClickListener(new l(this));
        this.bhr.setOnClickListener(new m(this));
        this.bhr.setOnLongClickListener(new n(this));
        this.bhp.setOnClickListener(new o(this));
    }

    public void refresh() {
        if (this.data != null) {
            if (this.bhk.isEditMode()) {
                this.bhp.setVisibility(0);
            } else {
                this.bhp.setVisibility(8);
                this.bhq.setSelected(false);
            }
            String groupHeadUrl = this.data.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.bhl.setTag(groupHeadUrl);
                this.bhl.d(groupHeadUrl, 10, false);
            } else {
                this.bhl.setTag(null);
            }
            this.bhl.setClickable(false);
            if (!TextUtils.isEmpty(this.data.getTitle())) {
                this.Nm.setText(this.data.getTitle());
            } else {
                this.Nm.setText(this.bhk.getPageContext().getString(z.alert_title));
            }
            Date date = new Date();
            date.setTime(this.data.getTime());
            this.bho.setText(bf.f(date));
            if (!TextUtils.isEmpty(this.data.getContent())) {
                this.bhn.setText(this.data.getContent());
            } else {
                this.bhn.setText("");
            }
            if (!TextUtils.isEmpty(this.data.getGroupName())) {
                this.bhm.setText(this.data.getGroupName());
            } else {
                this.bhm.setText("");
            }
            int paddingLeft = this.bhq.getPaddingLeft();
            int paddingTop = this.bhq.getPaddingTop();
            int paddingRight = this.bhq.getPaddingRight();
            int paddingBottom = this.bhq.getPaddingBottom();
            this.bhk.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.bhk.getLayoutMode().h(this.mConvertView);
            this.bhp.setSelected(this.data.isSelected());
            if (this.data.isSelected()) {
                bc.i(this.bhq, v.bg_information_down_s);
            } else {
                bc.i(this.bhq, v.selector_group_updates_bottom_bg);
            }
            this.bhq.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void refresh(UpdatesItemData updatesItemData) {
        setData(updatesItemData);
        refresh();
    }

    public void setData(UpdatesItemData updatesItemData) {
        this.data = updatesItemData;
    }
}
