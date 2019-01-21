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
    private TextView aIi;
    private UpdatesActivity eYa;
    private View eYb;
    private HeadImageView eYc;
    private TextView eYd;
    private TextView eYe;
    private TextView eYf;
    private ImageView eYg;
    private RelativeLayout eYh;
    private RelativeLayout eYi;
    private UpdatesItemData eYj;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eYa = updatesActivity;
        initView();
    }

    void initView() {
        this.eYb = this.vo.findViewById(e.g.root_view);
        this.eYc = (HeadImageView) this.eYb.findViewById(e.g.iv_head);
        this.eYd = (TextView) this.eYb.findViewById(e.g.tv_group_name);
        this.eYe = (TextView) this.eYb.findViewById(e.g.tv_content);
        this.aIi = (TextView) this.eYb.findViewById(e.g.tv_title);
        this.eYf = (TextView) this.eYb.findViewById(e.g.tv_time);
        this.eYg = (ImageView) this.eYb.findViewById(e.g.cb_select);
        this.eYh = (RelativeLayout) this.eYb.findViewById(e.g.layout_body);
        this.eYi = (RelativeLayout) this.eYb.findViewById(e.g.layout_title);
        this.eYc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eYh.setClickable(true);
        this.eYh.setLongClickable(true);
        this.eYi.setClickable(true);
        this.eYi.setLongClickable(true);
        this.eYh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eYa.aBh()) {
                    b.this.eYg.performClick();
                } else {
                    b.this.eYa.a(b.this.eYb, 101, 0, 0L, b.this.eYj);
                }
            }
        });
        this.eYh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eYa.b(b.this.eYb, 200, 0, 0L, b.this.eYj);
                return true;
            }
        });
        this.eYi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eYa.a(b.this.eYb, 101, 0, 0L, b.this.eYj);
            }
        });
        this.eYi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eYa.b(b.this.eYb, 200, 0, 0L, b.this.eYj);
                return true;
            }
        });
        this.eYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eYa.a(view, view.isSelected(), b.this.eYj);
            }
        });
    }

    public void refresh() {
        if (this.eYj != null) {
            if (this.eYa.aBh()) {
                this.eYg.setVisibility(0);
            } else {
                this.eYg.setVisibility(8);
                this.eYh.setSelected(false);
            }
            String groupHeadUrl = this.eYj.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eYc.setTag(groupHeadUrl);
                this.eYc.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eYc.setTag(null);
            }
            this.eYc.setClickable(false);
            if (!TextUtils.isEmpty(this.eYj.getTitle())) {
                this.aIi.setText(this.eYj.getTitle());
            } else {
                this.aIi.setText(this.eYa.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eYj.getTime());
            this.eYf.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eYj.getContent())) {
                this.eYe.setText(this.eYj.getContent());
            } else {
                this.eYe.setText("");
            }
            if (!TextUtils.isEmpty(this.eYj.getGroupName())) {
                this.eYd.setText(this.eYj.getGroupName());
            } else {
                this.eYd.setText("");
            }
            int paddingLeft = this.eYh.getPaddingLeft();
            int paddingTop = this.eYh.getPaddingTop();
            int paddingRight = this.eYh.getPaddingRight();
            int paddingBottom = this.eYh.getPaddingBottom();
            this.eYa.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eYa.getLayoutMode().onModeChanged(this.vo);
            this.eYg.setSelected(this.eYj.isSelected());
            if (this.eYj.isSelected() && this.eYa.aBh()) {
                al.i(this.eYh, e.f.bg_information_down_s);
            } else {
                al.i(this.eYh, e.f.selector_group_updates_bottom_bg);
            }
            this.eYh.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eYj = updatesItemData;
    }
}
