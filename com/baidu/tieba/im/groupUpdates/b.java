package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<UpdatesActivity> {
    private TextView fjZ;
    private UpdatesActivity kDS;
    private View kDT;
    private HeadImageView kDU;
    private TextView kDV;
    private TextView kDW;
    private ImageView kDX;
    private RelativeLayout kDY;
    private RelativeLayout kDZ;
    private UpdatesItemData kEa;
    private TextView kjS;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kDS = updatesActivity;
        initView();
    }

    void initView() {
        this.kDT = this.mConvertView.findViewById(R.id.root_view);
        this.kDU = (HeadImageView) this.kDT.findViewById(R.id.iv_head);
        this.kDV = (TextView) this.kDT.findViewById(R.id.tv_group_name);
        this.kjS = (TextView) this.kDT.findViewById(R.id.tv_content);
        this.fjZ = (TextView) this.kDT.findViewById(R.id.tv_title);
        this.kDW = (TextView) this.kDT.findViewById(R.id.tv_time);
        this.kDX = (ImageView) this.kDT.findViewById(R.id.cb_select);
        this.kDY = (RelativeLayout) this.kDT.findViewById(R.id.layout_body);
        this.kDZ = (RelativeLayout) this.kDT.findViewById(R.id.layout_title);
        this.kDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kDY.setClickable(true);
        this.kDY.setLongClickable(true);
        this.kDZ.setClickable(true);
        this.kDZ.setLongClickable(true);
        this.kDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kDS.cDS()) {
                    b.this.kDX.performClick();
                } else {
                    b.this.kDS.a(b.this.kDT, 101, 0, 0L, b.this.kEa);
                }
            }
        });
        this.kDY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kDS.b(b.this.kDT, 200, 0, 0L, b.this.kEa);
                return true;
            }
        });
        this.kDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kDS.a(b.this.kDT, 101, 0, 0L, b.this.kEa);
            }
        });
        this.kDZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kDS.b(b.this.kDT, 200, 0, 0L, b.this.kEa);
                return true;
            }
        });
        this.kDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kDS.a(view, view.isSelected(), b.this.kEa);
            }
        });
    }

    public void refresh() {
        if (this.kEa != null) {
            if (this.kDS.cDS()) {
                this.kDX.setVisibility(0);
            } else {
                this.kDX.setVisibility(8);
                this.kDY.setSelected(false);
            }
            String groupHeadUrl = this.kEa.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kDU.setTag(groupHeadUrl);
                this.kDU.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kDU.setTag(null);
            }
            this.kDU.setClickable(false);
            if (!TextUtils.isEmpty(this.kEa.getTitle())) {
                this.fjZ.setText(this.kEa.getTitle());
            } else {
                this.fjZ.setText(this.kDS.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kEa.getTime());
            this.kDW.setText(at.l(date));
            if (!TextUtils.isEmpty(this.kEa.getContent())) {
                this.kjS.setText(this.kEa.getContent());
            } else {
                this.kjS.setText("");
            }
            if (!TextUtils.isEmpty(this.kEa.getGroupName())) {
                this.kDV.setText(this.kEa.getGroupName());
            } else {
                this.kDV.setText("");
            }
            int paddingLeft = this.kDY.getPaddingLeft();
            int paddingTop = this.kDY.getPaddingTop();
            int paddingRight = this.kDY.getPaddingRight();
            int paddingBottom = this.kDY.getPaddingBottom();
            this.kDS.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kDS.getLayoutMode().onModeChanged(this.mConvertView);
            this.kDX.setSelected(this.kEa.isSelected());
            if (this.kEa.isSelected() && this.kDS.cDS()) {
                ao.setBackgroundResource(this.kDY, R.drawable.bg_information_down_s);
            } else {
                ao.setBackgroundResource(this.kDY, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kDY.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kEa = updatesItemData;
    }
}
