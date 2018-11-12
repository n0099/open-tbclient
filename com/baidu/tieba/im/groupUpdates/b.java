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
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView aEe;
    private UpdatesActivity eNG;
    private View eNH;
    private HeadImageView eNI;
    private TextView eNJ;
    private TextView eNK;
    private TextView eNL;
    private ImageView eNM;
    private RelativeLayout eNN;
    private RelativeLayout eNO;
    private UpdatesItemData eNP;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eNG = updatesActivity;
        initView();
    }

    void initView() {
        this.eNH = this.vo.findViewById(e.g.root_view);
        this.eNI = (HeadImageView) this.eNH.findViewById(e.g.iv_head);
        this.eNJ = (TextView) this.eNH.findViewById(e.g.tv_group_name);
        this.eNK = (TextView) this.eNH.findViewById(e.g.tv_content);
        this.aEe = (TextView) this.eNH.findViewById(e.g.tv_title);
        this.eNL = (TextView) this.eNH.findViewById(e.g.tv_time);
        this.eNM = (ImageView) this.eNH.findViewById(e.g.cb_select);
        this.eNN = (RelativeLayout) this.eNH.findViewById(e.g.layout_body);
        this.eNO = (RelativeLayout) this.eNH.findViewById(e.g.layout_title);
        this.eNI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eNN.setClickable(true);
        this.eNN.setLongClickable(true);
        this.eNO.setClickable(true);
        this.eNO.setLongClickable(true);
        this.eNN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eNG.ayl()) {
                    b.this.eNM.performClick();
                } else {
                    b.this.eNG.a(b.this.eNH, 101, 0, 0L, b.this.eNP);
                }
            }
        });
        this.eNN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eNG.b(b.this.eNH, 200, 0, 0L, b.this.eNP);
                return true;
            }
        });
        this.eNO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eNG.a(b.this.eNH, 101, 0, 0L, b.this.eNP);
            }
        });
        this.eNO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eNG.b(b.this.eNH, 200, 0, 0L, b.this.eNP);
                return true;
            }
        });
        this.eNM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eNG.a(view, view.isSelected(), b.this.eNP);
            }
        });
    }

    public void refresh() {
        if (this.eNP != null) {
            if (this.eNG.ayl()) {
                this.eNM.setVisibility(0);
            } else {
                this.eNM.setVisibility(8);
                this.eNN.setSelected(false);
            }
            String groupHeadUrl = this.eNP.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eNI.setTag(groupHeadUrl);
                this.eNI.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eNI.setTag(null);
            }
            this.eNI.setClickable(false);
            if (!TextUtils.isEmpty(this.eNP.getTitle())) {
                this.aEe.setText(this.eNP.getTitle());
            } else {
                this.aEe.setText(this.eNG.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eNP.getTime());
            this.eNL.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eNP.getContent())) {
                this.eNK.setText(this.eNP.getContent());
            } else {
                this.eNK.setText("");
            }
            if (!TextUtils.isEmpty(this.eNP.getGroupName())) {
                this.eNJ.setText(this.eNP.getGroupName());
            } else {
                this.eNJ.setText("");
            }
            int paddingLeft = this.eNN.getPaddingLeft();
            int paddingTop = this.eNN.getPaddingTop();
            int paddingRight = this.eNN.getPaddingRight();
            int paddingBottom = this.eNN.getPaddingBottom();
            this.eNG.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eNG.getLayoutMode().onModeChanged(this.vo);
            this.eNM.setSelected(this.eNP.isSelected());
            if (this.eNP.isSelected() && this.eNG.ayl()) {
                al.i(this.eNN, e.f.bg_information_down_s);
            } else {
                al.i(this.eNN, e.f.selector_group_updates_bottom_bg);
            }
            this.eNN.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eNP = updatesItemData;
    }
}
