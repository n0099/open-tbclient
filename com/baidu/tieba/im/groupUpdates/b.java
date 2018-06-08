package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView avg;
    private UpdatesActivity epF;
    private View epH;
    private HeadImageView epI;
    private TextView epJ;
    private TextView epK;
    private TextView epL;
    private ImageView epM;
    private RelativeLayout epN;
    private RelativeLayout epO;
    private UpdatesItemData epP;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.i.updates_item);
        this.epF = updatesActivity;
        initView();
    }

    void initView() {
        this.epH = this.sf.findViewById(d.g.root_view);
        this.epI = (HeadImageView) this.epH.findViewById(d.g.iv_head);
        this.epJ = (TextView) this.epH.findViewById(d.g.tv_group_name);
        this.epK = (TextView) this.epH.findViewById(d.g.tv_content);
        this.avg = (TextView) this.epH.findViewById(d.g.tv_title);
        this.epL = (TextView) this.epH.findViewById(d.g.tv_time);
        this.epM = (ImageView) this.epH.findViewById(d.g.cb_select);
        this.epN = (RelativeLayout) this.epH.findViewById(d.g.layout_body);
        this.epO = (RelativeLayout) this.epH.findViewById(d.g.layout_title);
        this.epI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.epN.setClickable(true);
        this.epN.setLongClickable(true);
        this.epO.setClickable(true);
        this.epO.setLongClickable(true);
        this.epN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.epF.aKg()) {
                    b.this.epM.performClick();
                } else {
                    b.this.epF.a(b.this.epH, 101, 0, 0L, b.this.epP);
                }
            }
        });
        this.epN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.epF.b(b.this.epH, 200, 0, 0L, b.this.epP);
                return true;
            }
        });
        this.epO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.epF.a(b.this.epH, 101, 0, 0L, b.this.epP);
            }
        });
        this.epO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.epF.b(b.this.epH, 200, 0, 0L, b.this.epP);
                return true;
            }
        });
        this.epM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.epF.a(view, view.isSelected(), b.this.epP);
            }
        });
    }

    public void refresh() {
        if (this.epP != null) {
            if (this.epF.aKg()) {
                this.epM.setVisibility(0);
            } else {
                this.epM.setVisibility(8);
                this.epN.setSelected(false);
            }
            String groupHeadUrl = this.epP.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.epI.setTag(groupHeadUrl);
                this.epI.startLoad(groupHeadUrl, 10, false);
            } else {
                this.epI.setTag(null);
            }
            this.epI.setClickable(false);
            if (!TextUtils.isEmpty(this.epP.getTitle())) {
                this.avg.setText(this.epP.getTitle());
            } else {
                this.avg.setText(this.epF.getPageContext().getString(d.k.inform));
            }
            Date date = new Date();
            date.setTime(this.epP.getTime());
            this.epL.setText(ao.h(date));
            if (!TextUtils.isEmpty(this.epP.getContent())) {
                this.epK.setText(this.epP.getContent());
            } else {
                this.epK.setText("");
            }
            if (!TextUtils.isEmpty(this.epP.getGroupName())) {
                this.epJ.setText(this.epP.getGroupName());
            } else {
                this.epJ.setText("");
            }
            int paddingLeft = this.epN.getPaddingLeft();
            int paddingTop = this.epN.getPaddingTop();
            int paddingRight = this.epN.getPaddingRight();
            int paddingBottom = this.epN.getPaddingBottom();
            this.epF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.epF.getLayoutMode().onModeChanged(this.sf);
            this.epM.setSelected(this.epP.isSelected());
            if (this.epP.isSelected() && this.epF.aKg()) {
                al.i(this.epN, d.f.bg_information_down_s);
            } else {
                al.i(this.epN, d.f.selector_group_updates_bottom_bg);
            }
            this.epN.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.epP = updatesItemData;
    }
}
