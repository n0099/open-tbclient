package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<UpdatesActivity> {
    private TextView Yt;
    private View aCq;
    private UpdatesActivity biP;
    private HeadImageView biQ;
    private TextView biR;
    private TextView biS;
    private TextView biT;
    private ImageView biU;
    private RelativeLayout biV;
    private RelativeLayout biW;
    private UpdatesItemData data;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), w.updates_item);
        this.biP = updatesActivity;
        initView();
    }

    void initView() {
        this.aCq = this.mConvertView.findViewById(v.root_view);
        this.biQ = (HeadImageView) this.aCq.findViewById(v.iv_head);
        this.biR = (TextView) this.aCq.findViewById(v.tv_group_name);
        this.biS = (TextView) this.aCq.findViewById(v.tv_content);
        this.Yt = (TextView) this.aCq.findViewById(v.tv_title);
        this.biT = (TextView) this.aCq.findViewById(v.tv_time);
        this.biU = (ImageView) this.aCq.findViewById(v.cb_select);
        this.biV = (RelativeLayout) this.aCq.findViewById(v.layout_body);
        this.biW = (RelativeLayout) this.aCq.findViewById(v.layout_title);
        this.biQ.setOnClickListener(new j(this));
        this.biV.setClickable(true);
        this.biV.setLongClickable(true);
        this.biW.setClickable(true);
        this.biW.setLongClickable(true);
        this.biV.setOnClickListener(new k(this));
        this.biV.setOnLongClickListener(new l(this));
        this.biW.setOnClickListener(new m(this));
        this.biW.setOnLongClickListener(new n(this));
        this.biU.setOnClickListener(new o(this));
    }

    public void refresh() {
        if (this.data != null) {
            if (this.biP.isEditMode()) {
                this.biU.setVisibility(0);
            } else {
                this.biU.setVisibility(8);
                this.biV.setSelected(false);
            }
            String groupHeadUrl = this.data.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.biQ.setTag(groupHeadUrl);
                this.biQ.c(groupHeadUrl, 10, false);
            } else {
                this.biQ.setTag(null);
            }
            this.biQ.setClickable(false);
            if (!TextUtils.isEmpty(this.data.getTitle())) {
                this.Yt.setText(this.data.getTitle());
            } else {
                this.Yt.setText(this.biP.getPageContext().getString(y.alert_title));
            }
            Date date = new Date();
            date.setTime(this.data.getTime());
            this.biT.setText(bd.e(date));
            if (!TextUtils.isEmpty(this.data.getContent())) {
                this.biS.setText(this.data.getContent());
            } else {
                this.biS.setText("");
            }
            if (!TextUtils.isEmpty(this.data.getGroupName())) {
                this.biR.setText(this.data.getGroupName());
            } else {
                this.biR.setText("");
            }
            int paddingLeft = this.biV.getPaddingLeft();
            int paddingTop = this.biV.getPaddingTop();
            int paddingRight = this.biV.getPaddingRight();
            int paddingBottom = this.biV.getPaddingBottom();
            this.biP.getLayoutMode().X(TbadkApplication.getInst().getSkinType() == 1);
            this.biP.getLayoutMode().h(this.mConvertView);
            this.biU.setSelected(this.data.isSelected());
            if (this.data.isSelected()) {
                ba.i(this.biV, u.bg_information_down_s);
            } else {
                ba.i(this.biV, u.selector_group_updates_bottom_bg);
            }
            this.biV.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
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
