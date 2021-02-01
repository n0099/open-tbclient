package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<UpdatesActivity> {
    private TextView fhE;
    private UpdatesItemData kHA;
    private UpdatesActivity kHs;
    private View kHt;
    private HeadImageView kHu;
    private TextView kHv;
    private TextView kHw;
    private ImageView kHx;
    private RelativeLayout kHy;
    private RelativeLayout kHz;
    private TextView knu;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kHs = updatesActivity;
        initView();
    }

    void initView() {
        this.kHt = this.mConvertView.findViewById(R.id.root_view);
        this.kHu = (HeadImageView) this.kHt.findViewById(R.id.iv_head);
        this.kHv = (TextView) this.kHt.findViewById(R.id.tv_group_name);
        this.knu = (TextView) this.kHt.findViewById(R.id.tv_content);
        this.fhE = (TextView) this.kHt.findViewById(R.id.tv_title);
        this.kHw = (TextView) this.kHt.findViewById(R.id.tv_time);
        this.kHx = (ImageView) this.kHt.findViewById(R.id.cb_select);
        this.kHy = (RelativeLayout) this.kHt.findViewById(R.id.layout_body);
        this.kHz = (RelativeLayout) this.kHt.findViewById(R.id.layout_title);
        this.kHu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kHy.setClickable(true);
        this.kHy.setLongClickable(true);
        this.kHz.setClickable(true);
        this.kHz.setLongClickable(true);
        this.kHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kHs.cBl()) {
                    b.this.kHx.performClick();
                } else {
                    b.this.kHs.a(b.this.kHt, 101, 0, 0L, b.this.kHA);
                }
            }
        });
        this.kHy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kHs.b(b.this.kHt, 200, 0, 0L, b.this.kHA);
                return true;
            }
        });
        this.kHz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kHs.a(b.this.kHt, 101, 0, 0L, b.this.kHA);
            }
        });
        this.kHz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kHs.b(b.this.kHt, 200, 0, 0L, b.this.kHA);
                return true;
            }
        });
        this.kHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kHs.a(view, view.isSelected(), b.this.kHA);
            }
        });
    }

    public void refresh() {
        if (this.kHA != null) {
            if (this.kHs.cBl()) {
                this.kHx.setVisibility(0);
            } else {
                this.kHx.setVisibility(8);
                this.kHy.setSelected(false);
            }
            String groupHeadUrl = this.kHA.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kHu.setTag(groupHeadUrl);
                this.kHu.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kHu.setTag(null);
            }
            this.kHu.setClickable(false);
            if (!TextUtils.isEmpty(this.kHA.getTitle())) {
                this.fhE.setText(this.kHA.getTitle());
            } else {
                this.fhE.setText(this.kHs.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kHA.getTime());
            this.kHw.setText(au.l(date));
            if (!TextUtils.isEmpty(this.kHA.getContent())) {
                this.knu.setText(this.kHA.getContent());
            } else {
                this.knu.setText("");
            }
            if (!TextUtils.isEmpty(this.kHA.getGroupName())) {
                this.kHv.setText(this.kHA.getGroupName());
            } else {
                this.kHv.setText("");
            }
            int paddingLeft = this.kHy.getPaddingLeft();
            int paddingTop = this.kHy.getPaddingTop();
            int paddingRight = this.kHy.getPaddingRight();
            int paddingBottom = this.kHy.getPaddingBottom();
            this.kHs.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kHs.getLayoutMode().onModeChanged(this.mConvertView);
            this.kHx.setSelected(this.kHA.isSelected());
            if (this.kHA.isSelected() && this.kHs.cBl()) {
                ap.setBackgroundResource(this.kHy, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.kHy, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kHy.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kHA = updatesItemData;
    }
}
