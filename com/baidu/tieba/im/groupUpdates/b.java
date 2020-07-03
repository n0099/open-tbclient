package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView ebr;
    private UpdatesActivity iXb;
    private View iXc;
    private HeadImageView iXd;
    private TextView iXe;
    private TextView iXf;
    private ImageView iXg;
    private RelativeLayout iXh;
    private RelativeLayout iXi;
    private UpdatesItemData iXj;
    private TextView ixe;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.iXb = updatesActivity;
        initView();
    }

    void initView() {
        this.iXc = this.mConvertView.findViewById(R.id.root_view);
        this.iXd = (HeadImageView) this.iXc.findViewById(R.id.iv_head);
        this.iXe = (TextView) this.iXc.findViewById(R.id.tv_group_name);
        this.ixe = (TextView) this.iXc.findViewById(R.id.tv_content);
        this.ebr = (TextView) this.iXc.findViewById(R.id.tv_title);
        this.iXf = (TextView) this.iXc.findViewById(R.id.tv_time);
        this.iXg = (ImageView) this.iXc.findViewById(R.id.cb_select);
        this.iXh = (RelativeLayout) this.iXc.findViewById(R.id.layout_body);
        this.iXi = (RelativeLayout) this.iXc.findViewById(R.id.layout_title);
        this.iXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.iXh.setClickable(true);
        this.iXh.setLongClickable(true);
        this.iXi.setClickable(true);
        this.iXi.setLongClickable(true);
        this.iXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.iXb.bWW()) {
                    b.this.iXg.performClick();
                } else {
                    b.this.iXb.a(b.this.iXc, 101, 0, 0L, b.this.iXj);
                }
            }
        });
        this.iXh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iXb.b(b.this.iXc, 200, 0, 0L, b.this.iXj);
                return true;
            }
        });
        this.iXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iXb.a(b.this.iXc, 101, 0, 0L, b.this.iXj);
            }
        });
        this.iXi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iXb.b(b.this.iXc, 200, 0, 0L, b.this.iXj);
                return true;
            }
        });
        this.iXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.iXb.a(view, view.isSelected(), b.this.iXj);
            }
        });
    }

    public void refresh() {
        if (this.iXj != null) {
            if (this.iXb.bWW()) {
                this.iXg.setVisibility(0);
            } else {
                this.iXg.setVisibility(8);
                this.iXh.setSelected(false);
            }
            String groupHeadUrl = this.iXj.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.iXd.setTag(groupHeadUrl);
                this.iXd.startLoad(groupHeadUrl, 10, false);
            } else {
                this.iXd.setTag(null);
            }
            this.iXd.setClickable(false);
            if (!TextUtils.isEmpty(this.iXj.getTitle())) {
                this.ebr.setText(this.iXj.getTitle());
            } else {
                this.ebr.setText(this.iXb.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.iXj.getTime());
            this.iXf.setText(ar.j(date));
            if (!TextUtils.isEmpty(this.iXj.getContent())) {
                this.ixe.setText(this.iXj.getContent());
            } else {
                this.ixe.setText("");
            }
            if (!TextUtils.isEmpty(this.iXj.getGroupName())) {
                this.iXe.setText(this.iXj.getGroupName());
            } else {
                this.iXe.setText("");
            }
            int paddingLeft = this.iXh.getPaddingLeft();
            int paddingTop = this.iXh.getPaddingTop();
            int paddingRight = this.iXh.getPaddingRight();
            int paddingBottom = this.iXh.getPaddingBottom();
            this.iXb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.iXb.getLayoutMode().onModeChanged(this.mConvertView);
            this.iXg.setSelected(this.iXj.isSelected());
            if (this.iXj.isSelected() && this.iXb.bWW()) {
                an.setBackgroundResource(this.iXh, R.drawable.bg_information_down_s);
            } else {
                an.setBackgroundResource(this.iXh, R.drawable.selector_group_updates_bottom_bg);
            }
            this.iXh.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.iXj = updatesItemData;
    }
}
