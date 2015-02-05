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
    private TextView Nj;
    private View awv;
    private UpdatesActivity bhj;
    private HeadImageView bhk;
    private TextView bhl;
    private TextView bhm;
    private TextView bhn;
    private ImageView bho;
    private RelativeLayout bhp;
    private RelativeLayout bhq;
    private UpdatesItemData data;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), x.updates_item);
        this.bhj = updatesActivity;
        initView();
    }

    void initView() {
        this.awv = this.mConvertView.findViewById(w.root_view);
        this.bhk = (HeadImageView) this.awv.findViewById(w.iv_head);
        this.bhl = (TextView) this.awv.findViewById(w.tv_group_name);
        this.bhm = (TextView) this.awv.findViewById(w.tv_content);
        this.Nj = (TextView) this.awv.findViewById(w.tv_title);
        this.bhn = (TextView) this.awv.findViewById(w.tv_time);
        this.bho = (ImageView) this.awv.findViewById(w.cb_select);
        this.bhp = (RelativeLayout) this.awv.findViewById(w.layout_body);
        this.bhq = (RelativeLayout) this.awv.findViewById(w.layout_title);
        this.bhk.setOnClickListener(new j(this));
        this.bhp.setClickable(true);
        this.bhp.setLongClickable(true);
        this.bhq.setClickable(true);
        this.bhq.setLongClickable(true);
        this.bhp.setOnClickListener(new k(this));
        this.bhp.setOnLongClickListener(new l(this));
        this.bhq.setOnClickListener(new m(this));
        this.bhq.setOnLongClickListener(new n(this));
        this.bho.setOnClickListener(new o(this));
    }

    public void refresh() {
        if (this.data != null) {
            if (this.bhj.isEditMode()) {
                this.bho.setVisibility(0);
            } else {
                this.bho.setVisibility(8);
                this.bhp.setSelected(false);
            }
            String groupHeadUrl = this.data.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.bhk.setTag(groupHeadUrl);
                this.bhk.d(groupHeadUrl, 10, false);
            } else {
                this.bhk.setTag(null);
            }
            this.bhk.setClickable(false);
            if (!TextUtils.isEmpty(this.data.getTitle())) {
                this.Nj.setText(this.data.getTitle());
            } else {
                this.Nj.setText(this.bhj.getPageContext().getString(z.alert_title));
            }
            Date date = new Date();
            date.setTime(this.data.getTime());
            this.bhn.setText(bf.f(date));
            if (!TextUtils.isEmpty(this.data.getContent())) {
                this.bhm.setText(this.data.getContent());
            } else {
                this.bhm.setText("");
            }
            if (!TextUtils.isEmpty(this.data.getGroupName())) {
                this.bhl.setText(this.data.getGroupName());
            } else {
                this.bhl.setText("");
            }
            int paddingLeft = this.bhp.getPaddingLeft();
            int paddingTop = this.bhp.getPaddingTop();
            int paddingRight = this.bhp.getPaddingRight();
            int paddingBottom = this.bhp.getPaddingBottom();
            this.bhj.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.bhj.getLayoutMode().h(this.mConvertView);
            this.bho.setSelected(this.data.isSelected());
            if (this.data.isSelected()) {
                bc.i(this.bhp, v.bg_information_down_s);
            } else {
                bc.i(this.bhp, v.selector_group_updates_bottom_bg);
            }
            this.bhp.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
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
