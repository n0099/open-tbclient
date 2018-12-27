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
    private TextView aHF;
    private UpdatesActivity eXm;
    private View eXn;
    private HeadImageView eXo;
    private TextView eXp;
    private TextView eXq;
    private TextView eXr;
    private ImageView eXs;
    private RelativeLayout eXt;
    private RelativeLayout eXu;
    private UpdatesItemData eXv;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eXm = updatesActivity;
        initView();
    }

    void initView() {
        this.eXn = this.vo.findViewById(e.g.root_view);
        this.eXo = (HeadImageView) this.eXn.findViewById(e.g.iv_head);
        this.eXp = (TextView) this.eXn.findViewById(e.g.tv_group_name);
        this.eXq = (TextView) this.eXn.findViewById(e.g.tv_content);
        this.aHF = (TextView) this.eXn.findViewById(e.g.tv_title);
        this.eXr = (TextView) this.eXn.findViewById(e.g.tv_time);
        this.eXs = (ImageView) this.eXn.findViewById(e.g.cb_select);
        this.eXt = (RelativeLayout) this.eXn.findViewById(e.g.layout_body);
        this.eXu = (RelativeLayout) this.eXn.findViewById(e.g.layout_title);
        this.eXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eXt.setClickable(true);
        this.eXt.setLongClickable(true);
        this.eXu.setClickable(true);
        this.eXu.setLongClickable(true);
        this.eXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eXm.aAK()) {
                    b.this.eXs.performClick();
                } else {
                    b.this.eXm.a(b.this.eXn, 101, 0, 0L, b.this.eXv);
                }
            }
        });
        this.eXt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eXm.b(b.this.eXn, 200, 0, 0L, b.this.eXv);
                return true;
            }
        });
        this.eXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eXm.a(b.this.eXn, 101, 0, 0L, b.this.eXv);
            }
        });
        this.eXu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eXm.b(b.this.eXn, 200, 0, 0L, b.this.eXv);
                return true;
            }
        });
        this.eXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eXm.a(view, view.isSelected(), b.this.eXv);
            }
        });
    }

    public void refresh() {
        if (this.eXv != null) {
            if (this.eXm.aAK()) {
                this.eXs.setVisibility(0);
            } else {
                this.eXs.setVisibility(8);
                this.eXt.setSelected(false);
            }
            String groupHeadUrl = this.eXv.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eXo.setTag(groupHeadUrl);
                this.eXo.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eXo.setTag(null);
            }
            this.eXo.setClickable(false);
            if (!TextUtils.isEmpty(this.eXv.getTitle())) {
                this.aHF.setText(this.eXv.getTitle());
            } else {
                this.aHF.setText(this.eXm.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eXv.getTime());
            this.eXr.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eXv.getContent())) {
                this.eXq.setText(this.eXv.getContent());
            } else {
                this.eXq.setText("");
            }
            if (!TextUtils.isEmpty(this.eXv.getGroupName())) {
                this.eXp.setText(this.eXv.getGroupName());
            } else {
                this.eXp.setText("");
            }
            int paddingLeft = this.eXt.getPaddingLeft();
            int paddingTop = this.eXt.getPaddingTop();
            int paddingRight = this.eXt.getPaddingRight();
            int paddingBottom = this.eXt.getPaddingBottom();
            this.eXm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eXm.getLayoutMode().onModeChanged(this.vo);
            this.eXs.setSelected(this.eXv.isSelected());
            if (this.eXv.isSelected() && this.eXm.aAK()) {
                al.i(this.eXt, e.f.bg_information_down_s);
            } else {
                al.i(this.eXt, e.f.selector_group_updates_bottom_bg);
            }
            this.eXt.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eXv = updatesItemData;
    }
}
