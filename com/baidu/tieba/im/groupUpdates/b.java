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
/* loaded from: classes25.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView etD;
    private UpdatesActivity jCV;
    private View jCW;
    private HeadImageView jCX;
    private TextView jCY;
    private TextView jCZ;
    private ImageView jDa;
    private RelativeLayout jDb;
    private RelativeLayout jDc;
    private UpdatesItemData jDd;
    private TextView jaU;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.jCV = updatesActivity;
        initView();
    }

    void initView() {
        this.jCW = this.mConvertView.findViewById(R.id.root_view);
        this.jCX = (HeadImageView) this.jCW.findViewById(R.id.iv_head);
        this.jCY = (TextView) this.jCW.findViewById(R.id.tv_group_name);
        this.jaU = (TextView) this.jCW.findViewById(R.id.tv_content);
        this.etD = (TextView) this.jCW.findViewById(R.id.tv_title);
        this.jCZ = (TextView) this.jCW.findViewById(R.id.tv_time);
        this.jDa = (ImageView) this.jCW.findViewById(R.id.cb_select);
        this.jDb = (RelativeLayout) this.jCW.findViewById(R.id.layout_body);
        this.jDc = (RelativeLayout) this.jCW.findViewById(R.id.layout_title);
        this.jCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.jDb.setClickable(true);
        this.jDb.setLongClickable(true);
        this.jDc.setClickable(true);
        this.jDc.setLongClickable(true);
        this.jDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jCV.coa()) {
                    b.this.jDa.performClick();
                } else {
                    b.this.jCV.a(b.this.jCW, 101, 0, 0L, b.this.jDd);
                }
            }
        });
        this.jDb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jCV.b(b.this.jCW, 200, 0, 0L, b.this.jDd);
                return true;
            }
        });
        this.jDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jCV.a(b.this.jCW, 101, 0, 0L, b.this.jDd);
            }
        });
        this.jDc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jCV.b(b.this.jCW, 200, 0, 0L, b.this.jDd);
                return true;
            }
        });
        this.jDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.jCV.a(view, view.isSelected(), b.this.jDd);
            }
        });
    }

    public void refresh() {
        if (this.jDd != null) {
            if (this.jCV.coa()) {
                this.jDa.setVisibility(0);
            } else {
                this.jDa.setVisibility(8);
                this.jDb.setSelected(false);
            }
            String groupHeadUrl = this.jDd.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.jCX.setTag(groupHeadUrl);
                this.jCX.startLoad(groupHeadUrl, 10, false);
            } else {
                this.jCX.setTag(null);
            }
            this.jCX.setClickable(false);
            if (!TextUtils.isEmpty(this.jDd.getTitle())) {
                this.etD.setText(this.jDd.getTitle());
            } else {
                this.etD.setText(this.jCV.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.jDd.getTime());
            this.jCZ.setText(at.l(date));
            if (!TextUtils.isEmpty(this.jDd.getContent())) {
                this.jaU.setText(this.jDd.getContent());
            } else {
                this.jaU.setText("");
            }
            if (!TextUtils.isEmpty(this.jDd.getGroupName())) {
                this.jCY.setText(this.jDd.getGroupName());
            } else {
                this.jCY.setText("");
            }
            int paddingLeft = this.jDb.getPaddingLeft();
            int paddingTop = this.jDb.getPaddingTop();
            int paddingRight = this.jDb.getPaddingRight();
            int paddingBottom = this.jDb.getPaddingBottom();
            this.jCV.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jCV.getLayoutMode().onModeChanged(this.mConvertView);
            this.jDa.setSelected(this.jDd.isSelected());
            if (this.jDd.isSelected() && this.jCV.coa()) {
                ap.setBackgroundResource(this.jDb, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.jDb, R.drawable.selector_group_updates_bottom_bg);
            }
            this.jDb.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.jDd = updatesItemData;
    }
}
