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
    private TextView dfP;
    private UpdatesActivity hEW;
    private View hEX;
    private HeadImageView hEY;
    private TextView hEZ;
    private TextView hFa;
    private TextView hFb;
    private ImageView hFc;
    private RelativeLayout hFd;
    private RelativeLayout hFe;
    private UpdatesItemData hFf;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.hEW = updatesActivity;
        initView();
    }

    void initView() {
        this.hEX = this.mConvertView.findViewById(R.id.root_view);
        this.hEY = (HeadImageView) this.hEX.findViewById(R.id.iv_head);
        this.hEZ = (TextView) this.hEX.findViewById(R.id.tv_group_name);
        this.hFa = (TextView) this.hEX.findViewById(R.id.tv_content);
        this.dfP = (TextView) this.hEX.findViewById(R.id.tv_title);
        this.hFb = (TextView) this.hEX.findViewById(R.id.tv_time);
        this.hFc = (ImageView) this.hEX.findViewById(R.id.cb_select);
        this.hFd = (RelativeLayout) this.hEX.findViewById(R.id.layout_body);
        this.hFe = (RelativeLayout) this.hEX.findViewById(R.id.layout_title);
        this.hEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.hFd.setClickable(true);
        this.hFd.setLongClickable(true);
        this.hFe.setClickable(true);
        this.hFe.setLongClickable(true);
        this.hFd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hEW.bCW()) {
                    b.this.hFc.performClick();
                } else {
                    b.this.hEW.a(b.this.hEX, 101, 0, 0L, b.this.hFf);
                }
            }
        });
        this.hFd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hEW.b(b.this.hEX, 200, 0, 0L, b.this.hFf);
                return true;
            }
        });
        this.hFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hEW.a(b.this.hEX, 101, 0, 0L, b.this.hFf);
            }
        });
        this.hFe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hEW.b(b.this.hEX, 200, 0, 0L, b.this.hFf);
                return true;
            }
        });
        this.hFc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.hEW.a(view, view.isSelected(), b.this.hFf);
            }
        });
    }

    public void refresh() {
        if (this.hFf != null) {
            if (this.hEW.bCW()) {
                this.hFc.setVisibility(0);
            } else {
                this.hFc.setVisibility(8);
                this.hFd.setSelected(false);
            }
            String groupHeadUrl = this.hFf.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.hEY.setTag(groupHeadUrl);
                this.hEY.startLoad(groupHeadUrl, 10, false);
            } else {
                this.hEY.setTag(null);
            }
            this.hEY.setClickable(false);
            if (!TextUtils.isEmpty(this.hFf.getTitle())) {
                this.dfP.setText(this.hFf.getTitle());
            } else {
                this.dfP.setText(this.hEW.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.hFf.getTime());
            this.hFb.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.hFf.getContent())) {
                this.hFa.setText(this.hFf.getContent());
            } else {
                this.hFa.setText("");
            }
            if (!TextUtils.isEmpty(this.hFf.getGroupName())) {
                this.hEZ.setText(this.hFf.getGroupName());
            } else {
                this.hEZ.setText("");
            }
            int paddingLeft = this.hFd.getPaddingLeft();
            int paddingTop = this.hFd.getPaddingTop();
            int paddingRight = this.hFd.getPaddingRight();
            int paddingBottom = this.hFd.getPaddingBottom();
            this.hEW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hEW.getLayoutMode().onModeChanged(this.mConvertView);
            this.hFc.setSelected(this.hFf.isSelected());
            if (this.hFf.isSelected() && this.hEW.bCW()) {
                am.setBackgroundResource(this.hFd, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.hFd, R.drawable.selector_group_updates_bottom_bg);
            }
            this.hFd.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.hFf = updatesItemData;
    }
}
