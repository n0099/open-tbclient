package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView eFN;
    private UpdatesActivity jRS;
    private View jRT;
    private HeadImageView jRU;
    private TextView jRV;
    private TextView jRW;
    private ImageView jRX;
    private RelativeLayout jRY;
    private RelativeLayout jRZ;
    private UpdatesItemData jSa;
    private TextView jpT;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.jRS = updatesActivity;
        initView();
    }

    void initView() {
        this.jRT = this.mConvertView.findViewById(R.id.root_view);
        this.jRU = (HeadImageView) this.jRT.findViewById(R.id.iv_head);
        this.jRV = (TextView) this.jRT.findViewById(R.id.tv_group_name);
        this.jpT = (TextView) this.jRT.findViewById(R.id.tv_content);
        this.eFN = (TextView) this.jRT.findViewById(R.id.tv_title);
        this.jRW = (TextView) this.jRT.findViewById(R.id.tv_time);
        this.jRX = (ImageView) this.jRT.findViewById(R.id.cb_select);
        this.jRY = (RelativeLayout) this.jRT.findViewById(R.id.layout_body);
        this.jRZ = (RelativeLayout) this.jRT.findViewById(R.id.layout_title);
        this.jRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.jRY.setClickable(true);
        this.jRY.setLongClickable(true);
        this.jRZ.setClickable(true);
        this.jRZ.setLongClickable(true);
        this.jRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jRS.cry()) {
                    b.this.jRX.performClick();
                } else {
                    b.this.jRS.a(b.this.jRT, 101, 0, 0L, b.this.jSa);
                }
            }
        });
        this.jRY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jRS.b(b.this.jRT, 200, 0, 0L, b.this.jSa);
                return true;
            }
        });
        this.jRZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jRS.a(b.this.jRT, 101, 0, 0L, b.this.jSa);
            }
        });
        this.jRZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jRS.b(b.this.jRT, 200, 0, 0L, b.this.jSa);
                return true;
            }
        });
        this.jRX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.jRS.a(view, view.isSelected(), b.this.jSa);
            }
        });
    }

    public void refresh() {
        if (this.jSa != null) {
            if (this.jRS.cry()) {
                this.jRX.setVisibility(0);
            } else {
                this.jRX.setVisibility(8);
                this.jRY.setSelected(false);
            }
            String groupHeadUrl = this.jSa.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.jRU.setTag(groupHeadUrl);
                this.jRU.startLoad(groupHeadUrl, 10, false);
            } else {
                this.jRU.setTag(null);
            }
            this.jRU.setClickable(false);
            if (!TextUtils.isEmpty(this.jSa.getTitle())) {
                this.eFN.setText(this.jSa.getTitle());
            } else {
                this.eFN.setText(this.jRS.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.jSa.getTime());
            this.jRW.setText(at.l(date));
            if (!TextUtils.isEmpty(this.jSa.getContent())) {
                this.jpT.setText(this.jSa.getContent());
            } else {
                this.jpT.setText("");
            }
            if (!TextUtils.isEmpty(this.jSa.getGroupName())) {
                this.jRV.setText(this.jSa.getGroupName());
            } else {
                this.jRV.setText("");
            }
            int paddingLeft = this.jRY.getPaddingLeft();
            int paddingTop = this.jRY.getPaddingTop();
            int paddingRight = this.jRY.getPaddingRight();
            int paddingBottom = this.jRY.getPaddingBottom();
            this.jRS.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jRS.getLayoutMode().onModeChanged(this.mConvertView);
            this.jRX.setSelected(this.jSa.isSelected());
            if (this.jSa.isSelected() && this.jRS.cry()) {
                ap.setBackgroundResource(this.jRY, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.jRY, R.drawable.selector_group_updates_bottom_bg);
            }
            this.jRY.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.jSa = updatesItemData;
    }
}
