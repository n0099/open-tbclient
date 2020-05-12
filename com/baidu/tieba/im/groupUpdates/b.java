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
    private TextView dFQ;
    private UpdatesActivity iqE;
    private View iqF;
    private HeadImageView iqG;
    private TextView iqH;
    private TextView iqI;
    private TextView iqJ;
    private ImageView iqK;
    private RelativeLayout iqL;
    private RelativeLayout iqM;
    private UpdatesItemData iqN;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.iqE = updatesActivity;
        initView();
    }

    void initView() {
        this.iqF = this.mConvertView.findViewById(R.id.root_view);
        this.iqG = (HeadImageView) this.iqF.findViewById(R.id.iv_head);
        this.iqH = (TextView) this.iqF.findViewById(R.id.tv_group_name);
        this.iqI = (TextView) this.iqF.findViewById(R.id.tv_content);
        this.dFQ = (TextView) this.iqF.findViewById(R.id.tv_title);
        this.iqJ = (TextView) this.iqF.findViewById(R.id.tv_time);
        this.iqK = (ImageView) this.iqF.findViewById(R.id.cb_select);
        this.iqL = (RelativeLayout) this.iqF.findViewById(R.id.layout_body);
        this.iqM = (RelativeLayout) this.iqF.findViewById(R.id.layout_title);
        this.iqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.iqL.setClickable(true);
        this.iqL.setLongClickable(true);
        this.iqM.setClickable(true);
        this.iqM.setLongClickable(true);
        this.iqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.iqE.bND()) {
                    b.this.iqK.performClick();
                } else {
                    b.this.iqE.a(b.this.iqF, 101, 0, 0L, b.this.iqN);
                }
            }
        });
        this.iqL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iqE.b(b.this.iqF, 200, 0, 0L, b.this.iqN);
                return true;
            }
        });
        this.iqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iqE.a(b.this.iqF, 101, 0, 0L, b.this.iqN);
            }
        });
        this.iqM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iqE.b(b.this.iqF, 200, 0, 0L, b.this.iqN);
                return true;
            }
        });
        this.iqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.iqE.a(view, view.isSelected(), b.this.iqN);
            }
        });
    }

    public void refresh() {
        if (this.iqN != null) {
            if (this.iqE.bND()) {
                this.iqK.setVisibility(0);
            } else {
                this.iqK.setVisibility(8);
                this.iqL.setSelected(false);
            }
            String groupHeadUrl = this.iqN.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.iqG.setTag(groupHeadUrl);
                this.iqG.startLoad(groupHeadUrl, 10, false);
            } else {
                this.iqG.setTag(null);
            }
            this.iqG.setClickable(false);
            if (!TextUtils.isEmpty(this.iqN.getTitle())) {
                this.dFQ.setText(this.iqN.getTitle());
            } else {
                this.dFQ.setText(this.iqE.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.iqN.getTime());
            this.iqJ.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.iqN.getContent())) {
                this.iqI.setText(this.iqN.getContent());
            } else {
                this.iqI.setText("");
            }
            if (!TextUtils.isEmpty(this.iqN.getGroupName())) {
                this.iqH.setText(this.iqN.getGroupName());
            } else {
                this.iqH.setText("");
            }
            int paddingLeft = this.iqL.getPaddingLeft();
            int paddingTop = this.iqL.getPaddingTop();
            int paddingRight = this.iqL.getPaddingRight();
            int paddingBottom = this.iqL.getPaddingBottom();
            this.iqE.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.iqE.getLayoutMode().onModeChanged(this.mConvertView);
            this.iqK.setSelected(this.iqN.isSelected());
            if (this.iqN.isSelected() && this.iqE.bND()) {
                am.setBackgroundResource(this.iqL, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.iqL, R.drawable.selector_group_updates_bottom_bg);
            }
            this.iqL.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.iqN = updatesItemData;
    }
}
