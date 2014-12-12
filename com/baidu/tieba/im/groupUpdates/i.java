package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<UpdatesActivity> {
    private TextView MQ;
    private View avy;
    private UpdatesActivity bfS;
    private HeadImageView bfT;
    private TextView bfU;
    private TextView bfV;
    private TextView bfW;
    private ImageView bfX;
    private RelativeLayout bfY;
    private RelativeLayout bfZ;
    private UpdatesItemData data;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), x.updates_item);
        this.bfS = updatesActivity;
        initView();
    }

    void initView() {
        this.avy = this.mConvertView.findViewById(w.root_view);
        this.bfT = (HeadImageView) this.avy.findViewById(w.iv_head);
        this.bfU = (TextView) this.avy.findViewById(w.tv_group_name);
        this.bfV = (TextView) this.avy.findViewById(w.tv_content);
        this.MQ = (TextView) this.avy.findViewById(w.tv_title);
        this.bfW = (TextView) this.avy.findViewById(w.tv_time);
        this.bfX = (ImageView) this.avy.findViewById(w.cb_select);
        this.bfY = (RelativeLayout) this.avy.findViewById(w.layout_body);
        this.bfZ = (RelativeLayout) this.avy.findViewById(w.layout_title);
        this.bfT.setOnClickListener(new j(this));
        this.bfY.setClickable(true);
        this.bfY.setLongClickable(true);
        this.bfZ.setClickable(true);
        this.bfZ.setLongClickable(true);
        this.bfY.setOnClickListener(new k(this));
        this.bfY.setOnLongClickListener(new l(this));
        this.bfZ.setOnClickListener(new m(this));
        this.bfZ.setOnLongClickListener(new n(this));
        this.bfX.setOnClickListener(new o(this));
    }

    public void refresh() {
        if (this.data != null) {
            if (this.bfS.isEditMode()) {
                this.bfX.setVisibility(0);
            } else {
                this.bfX.setVisibility(8);
                this.bfY.setSelected(false);
            }
            String groupHeadUrl = this.data.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.bfT.setTag(groupHeadUrl);
                this.bfT.d(groupHeadUrl, 10, false);
            } else {
                this.bfT.setTag(null);
            }
            this.bfT.setClickable(false);
            if (!TextUtils.isEmpty(this.data.getTitle())) {
                this.MQ.setText(this.data.getTitle());
            } else {
                this.MQ.setText(this.bfS.getPageContext().getString(z.alert_title));
            }
            Date date = new Date();
            date.setTime(this.data.getTime());
            this.bfW.setText(ba.f(date));
            if (!TextUtils.isEmpty(this.data.getContent())) {
                this.bfV.setText(this.data.getContent());
            } else {
                this.bfV.setText("");
            }
            if (!TextUtils.isEmpty(this.data.getGroupName())) {
                this.bfU.setText(this.data.getGroupName());
            } else {
                this.bfU.setText("");
            }
            int paddingLeft = this.bfY.getPaddingLeft();
            int paddingTop = this.bfY.getPaddingTop();
            int paddingRight = this.bfY.getPaddingRight();
            int paddingBottom = this.bfY.getPaddingBottom();
            this.bfS.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.bfS.getLayoutMode().h(this.mConvertView);
            this.bfX.setSelected(this.data.isSelected());
            if (this.data.isSelected()) {
                ax.i(this.bfY, v.bg_information_down_s);
            } else {
                ax.i(this.bfY, v.selector_group_updates_bottom_bg);
            }
            this.bfY.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
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
