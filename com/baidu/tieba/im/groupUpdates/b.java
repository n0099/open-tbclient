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
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView bZy;
    private ImageView gLA;
    private RelativeLayout gLB;
    private RelativeLayout gLC;
    private UpdatesItemData gLD;
    private UpdatesActivity gLu;
    private View gLv;
    private HeadImageView gLw;
    private TextView gLx;
    private TextView gLy;
    private TextView gLz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gLu = updatesActivity;
        initView();
    }

    void initView() {
        this.gLv = this.sP.findViewById(R.id.root_view);
        this.gLw = (HeadImageView) this.gLv.findViewById(R.id.iv_head);
        this.gLx = (TextView) this.gLv.findViewById(R.id.tv_group_name);
        this.gLy = (TextView) this.gLv.findViewById(R.id.tv_content);
        this.bZy = (TextView) this.gLv.findViewById(R.id.tv_title);
        this.gLz = (TextView) this.gLv.findViewById(R.id.tv_time);
        this.gLA = (ImageView) this.gLv.findViewById(R.id.cb_select);
        this.gLB = (RelativeLayout) this.gLv.findViewById(R.id.layout_body);
        this.gLC = (RelativeLayout) this.gLv.findViewById(R.id.layout_title);
        this.gLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gLB.setClickable(true);
        this.gLB.setLongClickable(true);
        this.gLC.setClickable(true);
        this.gLC.setLongClickable(true);
        this.gLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gLu.bkZ()) {
                    b.this.gLA.performClick();
                } else {
                    b.this.gLu.a(b.this.gLv, 101, 0, 0L, b.this.gLD);
                }
            }
        });
        this.gLB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gLu.b(b.this.gLv, 200, 0, 0L, b.this.gLD);
                return true;
            }
        });
        this.gLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gLu.a(b.this.gLv, 101, 0, 0L, b.this.gLD);
            }
        });
        this.gLC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gLu.b(b.this.gLv, 200, 0, 0L, b.this.gLD);
                return true;
            }
        });
        this.gLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gLu.a(view, view.isSelected(), b.this.gLD);
            }
        });
    }

    public void refresh() {
        if (this.gLD != null) {
            if (this.gLu.bkZ()) {
                this.gLA.setVisibility(0);
            } else {
                this.gLA.setVisibility(8);
                this.gLB.setSelected(false);
            }
            String groupHeadUrl = this.gLD.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gLw.setTag(groupHeadUrl);
                this.gLw.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gLw.setTag(null);
            }
            this.gLw.setClickable(false);
            if (!TextUtils.isEmpty(this.gLD.getTitle())) {
                this.bZy.setText(this.gLD.getTitle());
            } else {
                this.bZy.setText(this.gLu.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gLD.getTime());
            this.gLz.setText(aq.m(date));
            if (!TextUtils.isEmpty(this.gLD.getContent())) {
                this.gLy.setText(this.gLD.getContent());
            } else {
                this.gLy.setText("");
            }
            if (!TextUtils.isEmpty(this.gLD.getGroupName())) {
                this.gLx.setText(this.gLD.getGroupName());
            } else {
                this.gLx.setText("");
            }
            int paddingLeft = this.gLB.getPaddingLeft();
            int paddingTop = this.gLB.getPaddingTop();
            int paddingRight = this.gLB.getPaddingRight();
            int paddingBottom = this.gLB.getPaddingBottom();
            this.gLu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gLu.getLayoutMode().onModeChanged(this.sP);
            this.gLA.setSelected(this.gLD.isSelected());
            if (this.gLD.isSelected() && this.gLu.bkZ()) {
                am.k(this.gLB, R.drawable.bg_information_down_s);
            } else {
                am.k(this.gLB, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gLB.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gLD = updatesItemData;
    }
}
