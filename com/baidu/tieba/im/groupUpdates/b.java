package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView bbO;
    private UpdatesActivity eID;
    private View eIF;
    private HeadImageView eIG;
    private TextView eIH;
    private TextView eII;
    private TextView eIJ;
    private ImageView eIK;
    private RelativeLayout eIL;
    private RelativeLayout eIM;
    private UpdatesItemData eIN;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.h.updates_item);
        this.eID = updatesActivity;
        initView();
    }

    void initView() {
        this.eIF = this.abC.findViewById(d.g.root_view);
        this.eIG = (HeadImageView) this.eIF.findViewById(d.g.iv_head);
        this.eIH = (TextView) this.eIF.findViewById(d.g.tv_group_name);
        this.eII = (TextView) this.eIF.findViewById(d.g.tv_content);
        this.bbO = (TextView) this.eIF.findViewById(d.g.tv_title);
        this.eIJ = (TextView) this.eIF.findViewById(d.g.tv_time);
        this.eIK = (ImageView) this.eIF.findViewById(d.g.cb_select);
        this.eIL = (RelativeLayout) this.eIF.findViewById(d.g.layout_body);
        this.eIM = (RelativeLayout) this.eIF.findViewById(d.g.layout_title);
        this.eIG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eIL.setClickable(true);
        this.eIL.setLongClickable(true);
        this.eIM.setClickable(true);
        this.eIM.setLongClickable(true);
        this.eIL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eID.aKq()) {
                    b.this.eIK.performClick();
                } else {
                    b.this.eID.a(b.this.eIF, 101, 0, 0L, b.this.eIN);
                }
            }
        });
        this.eIL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eID.b(b.this.eIF, 200, 0, 0L, b.this.eIN);
                return true;
            }
        });
        this.eIM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eID.a(b.this.eIF, 101, 0, 0L, b.this.eIN);
            }
        });
        this.eIM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eID.b(b.this.eIF, 200, 0, 0L, b.this.eIN);
                return true;
            }
        });
        this.eIK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eID.a(view, view.isSelected(), b.this.eIN);
            }
        });
    }

    public void refresh() {
        if (this.eIN != null) {
            if (this.eID.aKq()) {
                this.eIK.setVisibility(0);
            } else {
                this.eIK.setVisibility(8);
                this.eIL.setSelected(false);
            }
            String groupHeadUrl = this.eIN.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eIG.setTag(groupHeadUrl);
                this.eIG.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eIG.setTag(null);
            }
            this.eIG.setClickable(false);
            if (!TextUtils.isEmpty(this.eIN.getTitle())) {
                this.bbO.setText(this.eIN.getTitle());
            } else {
                this.bbO.setText(this.eID.getPageContext().getString(d.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eIN.getTime());
            this.eIJ.setText(am.e(date));
            if (!TextUtils.isEmpty(this.eIN.getContent())) {
                this.eII.setText(this.eIN.getContent());
            } else {
                this.eII.setText("");
            }
            if (!TextUtils.isEmpty(this.eIN.getGroupName())) {
                this.eIH.setText(this.eIN.getGroupName());
            } else {
                this.eIH.setText("");
            }
            int paddingLeft = this.eIL.getPaddingLeft();
            int paddingTop = this.eIL.getPaddingTop();
            int paddingRight = this.eIL.getPaddingRight();
            int paddingBottom = this.eIL.getPaddingBottom();
            this.eID.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
            this.eID.getLayoutMode().aM(this.abC);
            this.eIK.setSelected(this.eIN.isSelected());
            if (this.eIN.isSelected() && this.eID.aKq()) {
                aj.s(this.eIL, d.f.bg_information_down_s);
            } else {
                aj.s(this.eIL, d.f.selector_group_updates_bottom_bg);
            }
            this.eIL.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eIN = updatesItemData;
    }
}
