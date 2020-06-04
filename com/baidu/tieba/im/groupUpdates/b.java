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
    private TextView dUc;
    private UpdatesActivity iFX;
    private View iFY;
    private HeadImageView iFZ;
    private TextView iGa;
    private TextView iGb;
    private TextView iGc;
    private ImageView iGd;
    private RelativeLayout iGe;
    private RelativeLayout iGf;
    private UpdatesItemData iGg;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.iFX = updatesActivity;
        initView();
    }

    void initView() {
        this.iFY = this.mConvertView.findViewById(R.id.root_view);
        this.iFZ = (HeadImageView) this.iFY.findViewById(R.id.iv_head);
        this.iGa = (TextView) this.iFY.findViewById(R.id.tv_group_name);
        this.iGb = (TextView) this.iFY.findViewById(R.id.tv_content);
        this.dUc = (TextView) this.iFY.findViewById(R.id.tv_title);
        this.iGc = (TextView) this.iFY.findViewById(R.id.tv_time);
        this.iGd = (ImageView) this.iFY.findViewById(R.id.cb_select);
        this.iGe = (RelativeLayout) this.iFY.findViewById(R.id.layout_body);
        this.iGf = (RelativeLayout) this.iFY.findViewById(R.id.layout_title);
        this.iFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.iGe.setClickable(true);
        this.iGe.setLongClickable(true);
        this.iGf.setClickable(true);
        this.iGf.setLongClickable(true);
        this.iGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.iFX.bUa()) {
                    b.this.iGd.performClick();
                } else {
                    b.this.iFX.a(b.this.iFY, 101, 0, 0L, b.this.iGg);
                }
            }
        });
        this.iGe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iFX.b(b.this.iFY, 200, 0, 0L, b.this.iGg);
                return true;
            }
        });
        this.iGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iFX.a(b.this.iFY, 101, 0, 0L, b.this.iGg);
            }
        });
        this.iGf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iFX.b(b.this.iFY, 200, 0, 0L, b.this.iGg);
                return true;
            }
        });
        this.iGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.iFX.a(view, view.isSelected(), b.this.iGg);
            }
        });
    }

    public void refresh() {
        if (this.iGg != null) {
            if (this.iFX.bUa()) {
                this.iGd.setVisibility(0);
            } else {
                this.iGd.setVisibility(8);
                this.iGe.setSelected(false);
            }
            String groupHeadUrl = this.iGg.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.iFZ.setTag(groupHeadUrl);
                this.iFZ.startLoad(groupHeadUrl, 10, false);
            } else {
                this.iFZ.setTag(null);
            }
            this.iFZ.setClickable(false);
            if (!TextUtils.isEmpty(this.iGg.getTitle())) {
                this.dUc.setText(this.iGg.getTitle());
            } else {
                this.dUc.setText(this.iFX.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.iGg.getTime());
            this.iGc.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.iGg.getContent())) {
                this.iGb.setText(this.iGg.getContent());
            } else {
                this.iGb.setText("");
            }
            if (!TextUtils.isEmpty(this.iGg.getGroupName())) {
                this.iGa.setText(this.iGg.getGroupName());
            } else {
                this.iGa.setText("");
            }
            int paddingLeft = this.iGe.getPaddingLeft();
            int paddingTop = this.iGe.getPaddingTop();
            int paddingRight = this.iGe.getPaddingRight();
            int paddingBottom = this.iGe.getPaddingBottom();
            this.iFX.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.iFX.getLayoutMode().onModeChanged(this.mConvertView);
            this.iGd.setSelected(this.iGg.isSelected());
            if (this.iGg.isSelected() && this.iFX.bUa()) {
                am.setBackgroundResource(this.iGe, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.iGe, R.drawable.selector_group_updates_bottom_bg);
            }
            this.iGe.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.iGg = updatesItemData;
    }
}
