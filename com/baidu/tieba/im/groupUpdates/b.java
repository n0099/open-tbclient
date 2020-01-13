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
/* loaded from: classes11.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView dbJ;
    private UpdatesActivity hCV;
    private View hCW;
    private HeadImageView hCX;
    private TextView hCY;
    private TextView hCZ;
    private TextView hDa;
    private ImageView hDb;
    private RelativeLayout hDc;
    private RelativeLayout hDd;
    private UpdatesItemData hDe;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.hCV = updatesActivity;
        initView();
    }

    void initView() {
        this.hCW = this.mConvertView.findViewById(R.id.root_view);
        this.hCX = (HeadImageView) this.hCW.findViewById(R.id.iv_head);
        this.hCY = (TextView) this.hCW.findViewById(R.id.tv_group_name);
        this.hCZ = (TextView) this.hCW.findViewById(R.id.tv_content);
        this.dbJ = (TextView) this.hCW.findViewById(R.id.tv_title);
        this.hDa = (TextView) this.hCW.findViewById(R.id.tv_time);
        this.hDb = (ImageView) this.hCW.findViewById(R.id.cb_select);
        this.hDc = (RelativeLayout) this.hCW.findViewById(R.id.layout_body);
        this.hDd = (RelativeLayout) this.hCW.findViewById(R.id.layout_title);
        this.hCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.hDc.setClickable(true);
        this.hDc.setLongClickable(true);
        this.hDd.setClickable(true);
        this.hDd.setLongClickable(true);
        this.hDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hCV.bBs()) {
                    b.this.hDb.performClick();
                } else {
                    b.this.hCV.a(b.this.hCW, 101, 0, 0L, b.this.hDe);
                }
            }
        });
        this.hDc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hCV.b(b.this.hCW, 200, 0, 0L, b.this.hDe);
                return true;
            }
        });
        this.hDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hCV.a(b.this.hCW, 101, 0, 0L, b.this.hDe);
            }
        });
        this.hDd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hCV.b(b.this.hCW, 200, 0, 0L, b.this.hDe);
                return true;
            }
        });
        this.hDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.hCV.a(view, view.isSelected(), b.this.hDe);
            }
        });
    }

    public void refresh() {
        if (this.hDe != null) {
            if (this.hCV.bBs()) {
                this.hDb.setVisibility(0);
            } else {
                this.hDb.setVisibility(8);
                this.hDc.setSelected(false);
            }
            String groupHeadUrl = this.hDe.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.hCX.setTag(groupHeadUrl);
                this.hCX.startLoad(groupHeadUrl, 10, false);
            } else {
                this.hCX.setTag(null);
            }
            this.hCX.setClickable(false);
            if (!TextUtils.isEmpty(this.hDe.getTitle())) {
                this.dbJ.setText(this.hDe.getTitle());
            } else {
                this.dbJ.setText(this.hCV.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.hDe.getTime());
            this.hDa.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.hDe.getContent())) {
                this.hCZ.setText(this.hDe.getContent());
            } else {
                this.hCZ.setText("");
            }
            if (!TextUtils.isEmpty(this.hDe.getGroupName())) {
                this.hCY.setText(this.hDe.getGroupName());
            } else {
                this.hCY.setText("");
            }
            int paddingLeft = this.hDc.getPaddingLeft();
            int paddingTop = this.hDc.getPaddingTop();
            int paddingRight = this.hDc.getPaddingRight();
            int paddingBottom = this.hDc.getPaddingBottom();
            this.hCV.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hCV.getLayoutMode().onModeChanged(this.mConvertView);
            this.hDb.setSelected(this.hDe.isSelected());
            if (this.hDe.isSelected() && this.hCV.bBs()) {
                am.setBackgroundResource(this.hDc, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.hDc, R.drawable.selector_group_updates_bottom_bg);
            }
            this.hDc.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.hDe = updatesItemData;
    }
}
