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
    private TextView dFM;
    private HeadImageView iqA;
    private TextView iqB;
    private TextView iqC;
    private TextView iqD;
    private ImageView iqE;
    private RelativeLayout iqF;
    private RelativeLayout iqG;
    private UpdatesItemData iqH;
    private UpdatesActivity iqy;
    private View iqz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.iqy = updatesActivity;
        initView();
    }

    void initView() {
        this.iqz = this.mConvertView.findViewById(R.id.root_view);
        this.iqA = (HeadImageView) this.iqz.findViewById(R.id.iv_head);
        this.iqB = (TextView) this.iqz.findViewById(R.id.tv_group_name);
        this.iqC = (TextView) this.iqz.findViewById(R.id.tv_content);
        this.dFM = (TextView) this.iqz.findViewById(R.id.tv_title);
        this.iqD = (TextView) this.iqz.findViewById(R.id.tv_time);
        this.iqE = (ImageView) this.iqz.findViewById(R.id.cb_select);
        this.iqF = (RelativeLayout) this.iqz.findViewById(R.id.layout_body);
        this.iqG = (RelativeLayout) this.iqz.findViewById(R.id.layout_title);
        this.iqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.iqF.setClickable(true);
        this.iqF.setLongClickable(true);
        this.iqG.setClickable(true);
        this.iqG.setLongClickable(true);
        this.iqF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.iqy.bNE()) {
                    b.this.iqE.performClick();
                } else {
                    b.this.iqy.a(b.this.iqz, 101, 0, 0L, b.this.iqH);
                }
            }
        });
        this.iqF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iqy.b(b.this.iqz, 200, 0, 0L, b.this.iqH);
                return true;
            }
        });
        this.iqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iqy.a(b.this.iqz, 101, 0, 0L, b.this.iqH);
            }
        });
        this.iqG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iqy.b(b.this.iqz, 200, 0, 0L, b.this.iqH);
                return true;
            }
        });
        this.iqE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.iqy.a(view, view.isSelected(), b.this.iqH);
            }
        });
    }

    public void refresh() {
        if (this.iqH != null) {
            if (this.iqy.bNE()) {
                this.iqE.setVisibility(0);
            } else {
                this.iqE.setVisibility(8);
                this.iqF.setSelected(false);
            }
            String groupHeadUrl = this.iqH.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.iqA.setTag(groupHeadUrl);
                this.iqA.startLoad(groupHeadUrl, 10, false);
            } else {
                this.iqA.setTag(null);
            }
            this.iqA.setClickable(false);
            if (!TextUtils.isEmpty(this.iqH.getTitle())) {
                this.dFM.setText(this.iqH.getTitle());
            } else {
                this.dFM.setText(this.iqy.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.iqH.getTime());
            this.iqD.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.iqH.getContent())) {
                this.iqC.setText(this.iqH.getContent());
            } else {
                this.iqC.setText("");
            }
            if (!TextUtils.isEmpty(this.iqH.getGroupName())) {
                this.iqB.setText(this.iqH.getGroupName());
            } else {
                this.iqB.setText("");
            }
            int paddingLeft = this.iqF.getPaddingLeft();
            int paddingTop = this.iqF.getPaddingTop();
            int paddingRight = this.iqF.getPaddingRight();
            int paddingBottom = this.iqF.getPaddingBottom();
            this.iqy.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.iqy.getLayoutMode().onModeChanged(this.mConvertView);
            this.iqE.setSelected(this.iqH.isSelected());
            if (this.iqH.isSelected() && this.iqy.bNE()) {
                am.setBackgroundResource(this.iqF, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.iqF, R.drawable.selector_group_updates_bottom_bg);
            }
            this.iqF.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.iqH = updatesItemData;
    }
}
