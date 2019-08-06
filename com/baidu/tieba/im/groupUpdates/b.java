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
    private TextView bZE;
    private UpdatesActivity gMm;
    private View gMn;
    private HeadImageView gMo;
    private TextView gMp;
    private TextView gMq;
    private TextView gMr;
    private ImageView gMs;
    private RelativeLayout gMt;
    private RelativeLayout gMu;
    private UpdatesItemData gMv;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gMm = updatesActivity;
        initView();
    }

    void initView() {
        this.gMn = this.sP.findViewById(R.id.root_view);
        this.gMo = (HeadImageView) this.gMn.findViewById(R.id.iv_head);
        this.gMp = (TextView) this.gMn.findViewById(R.id.tv_group_name);
        this.gMq = (TextView) this.gMn.findViewById(R.id.tv_content);
        this.bZE = (TextView) this.gMn.findViewById(R.id.tv_title);
        this.gMr = (TextView) this.gMn.findViewById(R.id.tv_time);
        this.gMs = (ImageView) this.gMn.findViewById(R.id.cb_select);
        this.gMt = (RelativeLayout) this.gMn.findViewById(R.id.layout_body);
        this.gMu = (RelativeLayout) this.gMn.findViewById(R.id.layout_title);
        this.gMo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gMt.setClickable(true);
        this.gMt.setLongClickable(true);
        this.gMu.setClickable(true);
        this.gMu.setLongClickable(true);
        this.gMt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gMm.blg()) {
                    b.this.gMs.performClick();
                } else {
                    b.this.gMm.a(b.this.gMn, 101, 0, 0L, b.this.gMv);
                }
            }
        });
        this.gMt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gMm.b(b.this.gMn, 200, 0, 0L, b.this.gMv);
                return true;
            }
        });
        this.gMu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gMm.a(b.this.gMn, 101, 0, 0L, b.this.gMv);
            }
        });
        this.gMu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gMm.b(b.this.gMn, 200, 0, 0L, b.this.gMv);
                return true;
            }
        });
        this.gMs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gMm.a(view, view.isSelected(), b.this.gMv);
            }
        });
    }

    public void refresh() {
        if (this.gMv != null) {
            if (this.gMm.blg()) {
                this.gMs.setVisibility(0);
            } else {
                this.gMs.setVisibility(8);
                this.gMt.setSelected(false);
            }
            String groupHeadUrl = this.gMv.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gMo.setTag(groupHeadUrl);
                this.gMo.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gMo.setTag(null);
            }
            this.gMo.setClickable(false);
            if (!TextUtils.isEmpty(this.gMv.getTitle())) {
                this.bZE.setText(this.gMv.getTitle());
            } else {
                this.bZE.setText(this.gMm.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gMv.getTime());
            this.gMr.setText(aq.m(date));
            if (!TextUtils.isEmpty(this.gMv.getContent())) {
                this.gMq.setText(this.gMv.getContent());
            } else {
                this.gMq.setText("");
            }
            if (!TextUtils.isEmpty(this.gMv.getGroupName())) {
                this.gMp.setText(this.gMv.getGroupName());
            } else {
                this.gMp.setText("");
            }
            int paddingLeft = this.gMt.getPaddingLeft();
            int paddingTop = this.gMt.getPaddingTop();
            int paddingRight = this.gMt.getPaddingRight();
            int paddingBottom = this.gMt.getPaddingBottom();
            this.gMm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gMm.getLayoutMode().onModeChanged(this.sP);
            this.gMs.setSelected(this.gMv.isSelected());
            if (this.gMv.isSelected() && this.gMm.blg()) {
                am.k(this.gMt, R.drawable.bg_information_down_s);
            } else {
                am.k(this.gMt, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gMt.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gMv = updatesItemData;
    }
}
