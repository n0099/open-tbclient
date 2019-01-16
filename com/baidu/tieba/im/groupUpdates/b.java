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
    private TextView aIh;
    private UpdatesActivity eXZ;
    private View eYa;
    private HeadImageView eYb;
    private TextView eYc;
    private TextView eYd;
    private TextView eYe;
    private ImageView eYf;
    private RelativeLayout eYg;
    private RelativeLayout eYh;
    private UpdatesItemData eYi;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eXZ = updatesActivity;
        initView();
    }

    void initView() {
        this.eYa = this.vo.findViewById(e.g.root_view);
        this.eYb = (HeadImageView) this.eYa.findViewById(e.g.iv_head);
        this.eYc = (TextView) this.eYa.findViewById(e.g.tv_group_name);
        this.eYd = (TextView) this.eYa.findViewById(e.g.tv_content);
        this.aIh = (TextView) this.eYa.findViewById(e.g.tv_title);
        this.eYe = (TextView) this.eYa.findViewById(e.g.tv_time);
        this.eYf = (ImageView) this.eYa.findViewById(e.g.cb_select);
        this.eYg = (RelativeLayout) this.eYa.findViewById(e.g.layout_body);
        this.eYh = (RelativeLayout) this.eYa.findViewById(e.g.layout_title);
        this.eYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eYg.setClickable(true);
        this.eYg.setLongClickable(true);
        this.eYh.setClickable(true);
        this.eYh.setLongClickable(true);
        this.eYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eXZ.aBh()) {
                    b.this.eYf.performClick();
                } else {
                    b.this.eXZ.a(b.this.eYa, 101, 0, 0L, b.this.eYi);
                }
            }
        });
        this.eYg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eXZ.b(b.this.eYa, 200, 0, 0L, b.this.eYi);
                return true;
            }
        });
        this.eYh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eXZ.a(b.this.eYa, 101, 0, 0L, b.this.eYi);
            }
        });
        this.eYh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eXZ.b(b.this.eYa, 200, 0, 0L, b.this.eYi);
                return true;
            }
        });
        this.eYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eXZ.a(view, view.isSelected(), b.this.eYi);
            }
        });
    }

    public void refresh() {
        if (this.eYi != null) {
            if (this.eXZ.aBh()) {
                this.eYf.setVisibility(0);
            } else {
                this.eYf.setVisibility(8);
                this.eYg.setSelected(false);
            }
            String groupHeadUrl = this.eYi.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eYb.setTag(groupHeadUrl);
                this.eYb.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eYb.setTag(null);
            }
            this.eYb.setClickable(false);
            if (!TextUtils.isEmpty(this.eYi.getTitle())) {
                this.aIh.setText(this.eYi.getTitle());
            } else {
                this.aIh.setText(this.eXZ.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eYi.getTime());
            this.eYe.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eYi.getContent())) {
                this.eYd.setText(this.eYi.getContent());
            } else {
                this.eYd.setText("");
            }
            if (!TextUtils.isEmpty(this.eYi.getGroupName())) {
                this.eYc.setText(this.eYi.getGroupName());
            } else {
                this.eYc.setText("");
            }
            int paddingLeft = this.eYg.getPaddingLeft();
            int paddingTop = this.eYg.getPaddingTop();
            int paddingRight = this.eYg.getPaddingRight();
            int paddingBottom = this.eYg.getPaddingBottom();
            this.eXZ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eXZ.getLayoutMode().onModeChanged(this.vo);
            this.eYf.setSelected(this.eYi.isSelected());
            if (this.eYi.isSelected() && this.eXZ.aBh()) {
                al.i(this.eYg, e.f.bg_information_down_s);
            } else {
                al.i(this.eYg, e.f.selector_group_updates_bottom_bg);
            }
            this.eYg.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eYi = updatesItemData;
    }
}
