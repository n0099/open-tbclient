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
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView dby;
    private RelativeLayout hzA;
    private UpdatesItemData hzB;
    private UpdatesActivity hzs;
    private View hzt;
    private HeadImageView hzu;
    private TextView hzv;
    private TextView hzw;
    private TextView hzx;
    private ImageView hzy;
    private RelativeLayout hzz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.hzs = updatesActivity;
        initView();
    }

    void initView() {
        this.hzt = this.mConvertView.findViewById(R.id.root_view);
        this.hzu = (HeadImageView) this.hzt.findViewById(R.id.iv_head);
        this.hzv = (TextView) this.hzt.findViewById(R.id.tv_group_name);
        this.hzw = (TextView) this.hzt.findViewById(R.id.tv_content);
        this.dby = (TextView) this.hzt.findViewById(R.id.tv_title);
        this.hzx = (TextView) this.hzt.findViewById(R.id.tv_time);
        this.hzy = (ImageView) this.hzt.findViewById(R.id.cb_select);
        this.hzz = (RelativeLayout) this.hzt.findViewById(R.id.layout_body);
        this.hzA = (RelativeLayout) this.hzt.findViewById(R.id.layout_title);
        this.hzu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.hzz.setClickable(true);
        this.hzz.setLongClickable(true);
        this.hzA.setClickable(true);
        this.hzA.setLongClickable(true);
        this.hzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hzs.bAq()) {
                    b.this.hzy.performClick();
                } else {
                    b.this.hzs.a(b.this.hzt, 101, 0, 0L, b.this.hzB);
                }
            }
        });
        this.hzz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hzs.b(b.this.hzt, 200, 0, 0L, b.this.hzB);
                return true;
            }
        });
        this.hzA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hzs.a(b.this.hzt, 101, 0, 0L, b.this.hzB);
            }
        });
        this.hzA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hzs.b(b.this.hzt, 200, 0, 0L, b.this.hzB);
                return true;
            }
        });
        this.hzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.hzs.a(view, view.isSelected(), b.this.hzB);
            }
        });
    }

    public void refresh() {
        if (this.hzB != null) {
            if (this.hzs.bAq()) {
                this.hzy.setVisibility(0);
            } else {
                this.hzy.setVisibility(8);
                this.hzz.setSelected(false);
            }
            String groupHeadUrl = this.hzB.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.hzu.setTag(groupHeadUrl);
                this.hzu.startLoad(groupHeadUrl, 10, false);
            } else {
                this.hzu.setTag(null);
            }
            this.hzu.setClickable(false);
            if (!TextUtils.isEmpty(this.hzB.getTitle())) {
                this.dby.setText(this.hzB.getTitle());
            } else {
                this.dby.setText(this.hzs.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.hzB.getTime());
            this.hzx.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.hzB.getContent())) {
                this.hzw.setText(this.hzB.getContent());
            } else {
                this.hzw.setText("");
            }
            if (!TextUtils.isEmpty(this.hzB.getGroupName())) {
                this.hzv.setText(this.hzB.getGroupName());
            } else {
                this.hzv.setText("");
            }
            int paddingLeft = this.hzz.getPaddingLeft();
            int paddingTop = this.hzz.getPaddingTop();
            int paddingRight = this.hzz.getPaddingRight();
            int paddingBottom = this.hzz.getPaddingBottom();
            this.hzs.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hzs.getLayoutMode().onModeChanged(this.mConvertView);
            this.hzy.setSelected(this.hzB.isSelected());
            if (this.hzB.isSelected() && this.hzs.bAq()) {
                am.setBackgroundResource(this.hzz, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.hzz, R.drawable.selector_group_updates_bottom_bg);
            }
            this.hzz.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.hzB = updatesItemData;
    }
}
