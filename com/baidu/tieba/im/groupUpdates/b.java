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
    private TextView eTY;
    private TextView jIq;
    private UpdatesActivity kkp;
    private View kkq;
    private HeadImageView kkr;
    private TextView kks;
    private TextView kkt;
    private ImageView kku;
    private RelativeLayout kkv;
    private RelativeLayout kkw;
    private UpdatesItemData kkx;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kkp = updatesActivity;
        initView();
    }

    void initView() {
        this.kkq = this.mConvertView.findViewById(R.id.root_view);
        this.kkr = (HeadImageView) this.kkq.findViewById(R.id.iv_head);
        this.kks = (TextView) this.kkq.findViewById(R.id.tv_group_name);
        this.jIq = (TextView) this.kkq.findViewById(R.id.tv_content);
        this.eTY = (TextView) this.kkq.findViewById(R.id.tv_title);
        this.kkt = (TextView) this.kkq.findViewById(R.id.tv_time);
        this.kku = (ImageView) this.kkq.findViewById(R.id.cb_select);
        this.kkv = (RelativeLayout) this.kkq.findViewById(R.id.layout_body);
        this.kkw = (RelativeLayout) this.kkq.findViewById(R.id.layout_title);
        this.kkr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kkv.setClickable(true);
        this.kkv.setLongClickable(true);
        this.kkw.setClickable(true);
        this.kkw.setLongClickable(true);
        this.kkv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kkp.cxg()) {
                    b.this.kku.performClick();
                } else {
                    b.this.kkp.a(b.this.kkq, 101, 0, 0L, b.this.kkx);
                }
            }
        });
        this.kkv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kkp.b(b.this.kkq, 200, 0, 0L, b.this.kkx);
                return true;
            }
        });
        this.kkw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kkp.a(b.this.kkq, 101, 0, 0L, b.this.kkx);
            }
        });
        this.kkw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kkp.b(b.this.kkq, 200, 0, 0L, b.this.kkx);
                return true;
            }
        });
        this.kku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kkp.a(view, view.isSelected(), b.this.kkx);
            }
        });
    }

    public void refresh() {
        if (this.kkx != null) {
            if (this.kkp.cxg()) {
                this.kku.setVisibility(0);
            } else {
                this.kku.setVisibility(8);
                this.kkv.setSelected(false);
            }
            String groupHeadUrl = this.kkx.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kkr.setTag(groupHeadUrl);
                this.kkr.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kkr.setTag(null);
            }
            this.kkr.setClickable(false);
            if (!TextUtils.isEmpty(this.kkx.getTitle())) {
                this.eTY.setText(this.kkx.getTitle());
            } else {
                this.eTY.setText(this.kkp.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kkx.getTime());
            this.kkt.setText(at.l(date));
            if (!TextUtils.isEmpty(this.kkx.getContent())) {
                this.jIq.setText(this.kkx.getContent());
            } else {
                this.jIq.setText("");
            }
            if (!TextUtils.isEmpty(this.kkx.getGroupName())) {
                this.kks.setText(this.kkx.getGroupName());
            } else {
                this.kks.setText("");
            }
            int paddingLeft = this.kkv.getPaddingLeft();
            int paddingTop = this.kkv.getPaddingTop();
            int paddingRight = this.kkv.getPaddingRight();
            int paddingBottom = this.kkv.getPaddingBottom();
            this.kkp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kkp.getLayoutMode().onModeChanged(this.mConvertView);
            this.kku.setSelected(this.kkx.isSelected());
            if (this.kkx.isSelected() && this.kkp.cxg()) {
                ap.setBackgroundResource(this.kkv, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.kkv, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kkv.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kkx = updatesItemData;
    }
}
