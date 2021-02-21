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
    private UpdatesActivity kHG;
    private View kHH;
    private HeadImageView kHI;
    private TextView kHJ;
    private TextView kHK;
    private ImageView kHL;
    private RelativeLayout kHM;
    private RelativeLayout kHN;
    private UpdatesItemData kHO;
    private TextView knI;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kHG = updatesActivity;
        initView();
    }

    void initView() {
        this.kHH = this.mConvertView.findViewById(R.id.root_view);
        this.kHI = (HeadImageView) this.kHH.findViewById(R.id.iv_head);
        this.kHJ = (TextView) this.kHH.findViewById(R.id.tv_group_name);
        this.knI = (TextView) this.kHH.findViewById(R.id.tv_content);
        this.fhE = (TextView) this.kHH.findViewById(R.id.tv_title);
        this.kHK = (TextView) this.kHH.findViewById(R.id.tv_time);
        this.kHL = (ImageView) this.kHH.findViewById(R.id.cb_select);
        this.kHM = (RelativeLayout) this.kHH.findViewById(R.id.layout_body);
        this.kHN = (RelativeLayout) this.kHH.findViewById(R.id.layout_title);
        this.kHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kHM.setClickable(true);
        this.kHM.setLongClickable(true);
        this.kHN.setClickable(true);
        this.kHN.setLongClickable(true);
        this.kHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kHG.cBs()) {
                    b.this.kHL.performClick();
                } else {
                    b.this.kHG.a(b.this.kHH, 101, 0, 0L, b.this.kHO);
                }
            }
        });
        this.kHM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kHG.b(b.this.kHH, 200, 0, 0L, b.this.kHO);
                return true;
            }
        });
        this.kHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kHG.a(b.this.kHH, 101, 0, 0L, b.this.kHO);
            }
        });
        this.kHN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kHG.b(b.this.kHH, 200, 0, 0L, b.this.kHO);
                return true;
            }
        });
        this.kHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kHG.a(view, view.isSelected(), b.this.kHO);
            }
        });
    }

    public void refresh() {
        if (this.kHO != null) {
            if (this.kHG.cBs()) {
                this.kHL.setVisibility(0);
            } else {
                this.kHL.setVisibility(8);
                this.kHM.setSelected(false);
            }
            String groupHeadUrl = this.kHO.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kHI.setTag(groupHeadUrl);
                this.kHI.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kHI.setTag(null);
            }
            this.kHI.setClickable(false);
            if (!TextUtils.isEmpty(this.kHO.getTitle())) {
                this.fhE.setText(this.kHO.getTitle());
            } else {
                this.fhE.setText(this.kHG.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kHO.getTime());
            this.kHK.setText(au.l(date));
            if (!TextUtils.isEmpty(this.kHO.getContent())) {
                this.knI.setText(this.kHO.getContent());
            } else {
                this.knI.setText("");
            }
            if (!TextUtils.isEmpty(this.kHO.getGroupName())) {
                this.kHJ.setText(this.kHO.getGroupName());
            } else {
                this.kHJ.setText("");
            }
            int paddingLeft = this.kHM.getPaddingLeft();
            int paddingTop = this.kHM.getPaddingTop();
            int paddingRight = this.kHM.getPaddingRight();
            int paddingBottom = this.kHM.getPaddingBottom();
            this.kHG.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kHG.getLayoutMode().onModeChanged(this.mConvertView);
            this.kHL.setSelected(this.kHO.isSelected());
            if (this.kHO.isSelected() && this.kHG.cBs()) {
                ap.setBackgroundResource(this.kHM, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.kHM, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kHM.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kHO = updatesItemData;
    }
}
