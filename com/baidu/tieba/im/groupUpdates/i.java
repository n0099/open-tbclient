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
    private TextView Yr;
    private View aCi;
    private HeadImageView biA;
    private TextView biB;
    private TextView biC;
    private TextView biD;
    private ImageView biE;
    private RelativeLayout biF;
    private RelativeLayout biG;
    private UpdatesActivity biz;
    private UpdatesItemData data;

    public i(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), w.updates_item);
        this.biz = updatesActivity;
        initView();
    }

    void initView() {
        this.aCi = this.mConvertView.findViewById(v.root_view);
        this.biA = (HeadImageView) this.aCi.findViewById(v.iv_head);
        this.biB = (TextView) this.aCi.findViewById(v.tv_group_name);
        this.biC = (TextView) this.aCi.findViewById(v.tv_content);
        this.Yr = (TextView) this.aCi.findViewById(v.tv_title);
        this.biD = (TextView) this.aCi.findViewById(v.tv_time);
        this.biE = (ImageView) this.aCi.findViewById(v.cb_select);
        this.biF = (RelativeLayout) this.aCi.findViewById(v.layout_body);
        this.biG = (RelativeLayout) this.aCi.findViewById(v.layout_title);
        this.biA.setOnClickListener(new j(this));
        this.biF.setClickable(true);
        this.biF.setLongClickable(true);
        this.biG.setClickable(true);
        this.biG.setLongClickable(true);
        this.biF.setOnClickListener(new k(this));
        this.biF.setOnLongClickListener(new l(this));
        this.biG.setOnClickListener(new m(this));
        this.biG.setOnLongClickListener(new n(this));
        this.biE.setOnClickListener(new o(this));
    }

    public void refresh() {
        if (this.data != null) {
            if (this.biz.isEditMode()) {
                this.biE.setVisibility(0);
            } else {
                this.biE.setVisibility(8);
                this.biF.setSelected(false);
            }
            String groupHeadUrl = this.data.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.biA.setTag(groupHeadUrl);
                this.biA.c(groupHeadUrl, 10, false);
            } else {
                this.biA.setTag(null);
            }
            this.biA.setClickable(false);
            if (!TextUtils.isEmpty(this.data.getTitle())) {
                this.Yr.setText(this.data.getTitle());
            } else {
                this.Yr.setText(this.biz.getPageContext().getString(y.alert_title));
            }
            Date date = new Date();
            date.setTime(this.data.getTime());
            this.biD.setText(bd.e(date));
            if (!TextUtils.isEmpty(this.data.getContent())) {
                this.biC.setText(this.data.getContent());
            } else {
                this.biC.setText("");
            }
            if (!TextUtils.isEmpty(this.data.getGroupName())) {
                this.biB.setText(this.data.getGroupName());
            } else {
                this.biB.setText("");
            }
            int paddingLeft = this.biF.getPaddingLeft();
            int paddingTop = this.biF.getPaddingTop();
            int paddingRight = this.biF.getPaddingRight();
            int paddingBottom = this.biF.getPaddingBottom();
            this.biz.getLayoutMode().X(TbadkApplication.getInst().getSkinType() == 1);
            this.biz.getLayoutMode().h(this.mConvertView);
            this.biE.setSelected(this.data.isSelected());
            if (this.data.isSelected()) {
                ba.i(this.biF, u.bg_information_down_s);
            } else {
                ba.i(this.biF, u.selector_group_updates_bottom_bg);
            }
            this.biF.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
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
