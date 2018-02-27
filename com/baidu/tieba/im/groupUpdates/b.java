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
    private TextView bbC;
    private RelativeLayout eIA;
    private UpdatesItemData eIB;
    private UpdatesActivity eIr;
    private View eIt;
    private HeadImageView eIu;
    private TextView eIv;
    private TextView eIw;
    private TextView eIx;
    private ImageView eIy;
    private RelativeLayout eIz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.h.updates_item);
        this.eIr = updatesActivity;
        initView();
    }

    void initView() {
        this.eIt = this.abw.findViewById(d.g.root_view);
        this.eIu = (HeadImageView) this.eIt.findViewById(d.g.iv_head);
        this.eIv = (TextView) this.eIt.findViewById(d.g.tv_group_name);
        this.eIw = (TextView) this.eIt.findViewById(d.g.tv_content);
        this.bbC = (TextView) this.eIt.findViewById(d.g.tv_title);
        this.eIx = (TextView) this.eIt.findViewById(d.g.tv_time);
        this.eIy = (ImageView) this.eIt.findViewById(d.g.cb_select);
        this.eIz = (RelativeLayout) this.eIt.findViewById(d.g.layout_body);
        this.eIA = (RelativeLayout) this.eIt.findViewById(d.g.layout_title);
        this.eIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eIz.setClickable(true);
        this.eIz.setLongClickable(true);
        this.eIA.setClickable(true);
        this.eIA.setLongClickable(true);
        this.eIz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eIr.aKp()) {
                    b.this.eIy.performClick();
                } else {
                    b.this.eIr.a(b.this.eIt, 101, 0, 0L, b.this.eIB);
                }
            }
        });
        this.eIz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eIr.b(b.this.eIt, 200, 0, 0L, b.this.eIB);
                return true;
            }
        });
        this.eIA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eIr.a(b.this.eIt, 101, 0, 0L, b.this.eIB);
            }
        });
        this.eIA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eIr.b(b.this.eIt, 200, 0, 0L, b.this.eIB);
                return true;
            }
        });
        this.eIy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eIr.a(view, view.isSelected(), b.this.eIB);
            }
        });
    }

    public void refresh() {
        if (this.eIB != null) {
            if (this.eIr.aKp()) {
                this.eIy.setVisibility(0);
            } else {
                this.eIy.setVisibility(8);
                this.eIz.setSelected(false);
            }
            String groupHeadUrl = this.eIB.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eIu.setTag(groupHeadUrl);
                this.eIu.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eIu.setTag(null);
            }
            this.eIu.setClickable(false);
            if (!TextUtils.isEmpty(this.eIB.getTitle())) {
                this.bbC.setText(this.eIB.getTitle());
            } else {
                this.bbC.setText(this.eIr.getPageContext().getString(d.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eIB.getTime());
            this.eIx.setText(am.e(date));
            if (!TextUtils.isEmpty(this.eIB.getContent())) {
                this.eIw.setText(this.eIB.getContent());
            } else {
                this.eIw.setText("");
            }
            if (!TextUtils.isEmpty(this.eIB.getGroupName())) {
                this.eIv.setText(this.eIB.getGroupName());
            } else {
                this.eIv.setText("");
            }
            int paddingLeft = this.eIz.getPaddingLeft();
            int paddingTop = this.eIz.getPaddingTop();
            int paddingRight = this.eIz.getPaddingRight();
            int paddingBottom = this.eIz.getPaddingBottom();
            this.eIr.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
            this.eIr.getLayoutMode().aM(this.abw);
            this.eIy.setSelected(this.eIB.isSelected());
            if (this.eIB.isSelected() && this.eIr.aKp()) {
                aj.s(this.eIz, d.f.bg_information_down_s);
            } else {
                aj.s(this.eIz, d.f.selector_group_updates_bottom_bg);
            }
            this.eIz.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eIB = updatesItemData;
    }
}
