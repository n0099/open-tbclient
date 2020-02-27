package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView dfO;
    private UpdatesActivity hEU;
    private View hEV;
    private HeadImageView hEW;
    private TextView hEX;
    private TextView hEY;
    private TextView hEZ;
    private ImageView hFa;
    private RelativeLayout hFb;
    private RelativeLayout hFc;
    private UpdatesItemData hFd;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.hEU = updatesActivity;
        initView();
    }

    void initView() {
        this.hEV = this.mConvertView.findViewById(R.id.root_view);
        this.hEW = (HeadImageView) this.hEV.findViewById(R.id.iv_head);
        this.hEX = (TextView) this.hEV.findViewById(R.id.tv_group_name);
        this.hEY = (TextView) this.hEV.findViewById(R.id.tv_content);
        this.dfO = (TextView) this.hEV.findViewById(R.id.tv_title);
        this.hEZ = (TextView) this.hEV.findViewById(R.id.tv_time);
        this.hFa = (ImageView) this.hEV.findViewById(R.id.cb_select);
        this.hFb = (RelativeLayout) this.hEV.findViewById(R.id.layout_body);
        this.hFc = (RelativeLayout) this.hEV.findViewById(R.id.layout_title);
        this.hEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.hFb.setClickable(true);
        this.hFb.setLongClickable(true);
        this.hFc.setClickable(true);
        this.hFc.setLongClickable(true);
        this.hFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hEU.bCU()) {
                    b.this.hFa.performClick();
                } else {
                    b.this.hEU.a(b.this.hEV, 101, 0, 0L, b.this.hFd);
                }
            }
        });
        this.hFb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hEU.b(b.this.hEV, 200, 0, 0L, b.this.hFd);
                return true;
            }
        });
        this.hFc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hEU.a(b.this.hEV, 101, 0, 0L, b.this.hFd);
            }
        });
        this.hFc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hEU.b(b.this.hEV, 200, 0, 0L, b.this.hFd);
                return true;
            }
        });
        this.hFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.hEU.a(view, view.isSelected(), b.this.hFd);
            }
        });
    }

    public void refresh() {
        if (this.hFd != null) {
            if (this.hEU.bCU()) {
                this.hFa.setVisibility(0);
            } else {
                this.hFa.setVisibility(8);
                this.hFb.setSelected(false);
            }
            String groupHeadUrl = this.hFd.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.hEW.setTag(groupHeadUrl);
                this.hEW.startLoad(groupHeadUrl, 10, false);
            } else {
                this.hEW.setTag(null);
            }
            this.hEW.setClickable(false);
            if (!TextUtils.isEmpty(this.hFd.getTitle())) {
                this.dfO.setText(this.hFd.getTitle());
            } else {
                this.dfO.setText(this.hEU.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.hFd.getTime());
            this.hEZ.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.hFd.getContent())) {
                this.hEY.setText(this.hFd.getContent());
            } else {
                this.hEY.setText("");
            }
            if (!TextUtils.isEmpty(this.hFd.getGroupName())) {
                this.hEX.setText(this.hFd.getGroupName());
            } else {
                this.hEX.setText("");
            }
            int paddingLeft = this.hFb.getPaddingLeft();
            int paddingTop = this.hFb.getPaddingTop();
            int paddingRight = this.hFb.getPaddingRight();
            int paddingBottom = this.hFb.getPaddingBottom();
            this.hEU.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hEU.getLayoutMode().onModeChanged(this.mConvertView);
            this.hFa.setSelected(this.hFd.isSelected());
            if (this.hFd.isSelected() && this.hEU.bCU()) {
                am.setBackgroundResource(this.hFb, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.hFb, R.drawable.selector_group_updates_bottom_bg);
            }
            this.hFb.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.hFd = updatesItemData;
    }
}
