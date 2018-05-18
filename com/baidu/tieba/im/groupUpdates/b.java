package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView amY;
    private UpdatesItemData eeA;
    private UpdatesActivity eeq;
    private View ees;
    private HeadImageView eet;
    private TextView eeu;
    private TextView eev;
    private TextView eew;
    private ImageView eex;
    private RelativeLayout eey;
    private RelativeLayout eez;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.i.updates_item);
        this.eeq = updatesActivity;
        initView();
    }

    void initView() {
        this.ees = this.lJ.findViewById(d.g.root_view);
        this.eet = (HeadImageView) this.ees.findViewById(d.g.iv_head);
        this.eeu = (TextView) this.ees.findViewById(d.g.tv_group_name);
        this.eev = (TextView) this.ees.findViewById(d.g.tv_content);
        this.amY = (TextView) this.ees.findViewById(d.g.tv_title);
        this.eew = (TextView) this.ees.findViewById(d.g.tv_time);
        this.eex = (ImageView) this.ees.findViewById(d.g.cb_select);
        this.eey = (RelativeLayout) this.ees.findViewById(d.g.layout_body);
        this.eez = (RelativeLayout) this.ees.findViewById(d.g.layout_title);
        this.eet.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        this.eey.setClickable(true);
        this.eey.setLongClickable(true);
        this.eez.setClickable(true);
        this.eez.setLongClickable(true);
        this.eey.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.eeq.aFl()) {
                    b.this.eex.performClick();
                } else {
                    b.this.eeq.a(b.this.ees, 101, 0, 0L, b.this.eeA);
                }
            }
        });
        this.eey.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.eeq.b(b.this.ees, 200, 0, 0L, b.this.eeA);
                return true;
            }
        });
        this.eez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.eeq.a(b.this.ees, 101, 0, 0L, b.this.eeA);
            }
        });
        this.eez.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.eeq.b(b.this.ees, 200, 0, 0L, b.this.eeA);
                return true;
            }
        });
        this.eex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view2.setSelected(!view2.isSelected());
                b.this.eeq.a(view2, view2.isSelected(), b.this.eeA);
            }
        });
    }

    public void refresh() {
        if (this.eeA != null) {
            if (this.eeq.aFl()) {
                this.eex.setVisibility(0);
            } else {
                this.eex.setVisibility(8);
                this.eey.setSelected(false);
            }
            String groupHeadUrl = this.eeA.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eet.setTag(groupHeadUrl);
                this.eet.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eet.setTag(null);
            }
            this.eet.setClickable(false);
            if (!TextUtils.isEmpty(this.eeA.getTitle())) {
                this.amY.setText(this.eeA.getTitle());
            } else {
                this.amY.setText(this.eeq.getPageContext().getString(d.k.inform));
            }
            Date date = new Date();
            date.setTime(this.eeA.getTime());
            this.eew.setText(an.f(date));
            if (!TextUtils.isEmpty(this.eeA.getContent())) {
                this.eev.setText(this.eeA.getContent());
            } else {
                this.eev.setText("");
            }
            if (!TextUtils.isEmpty(this.eeA.getGroupName())) {
                this.eeu.setText(this.eeA.getGroupName());
            } else {
                this.eeu.setText("");
            }
            int paddingLeft = this.eey.getPaddingLeft();
            int paddingTop = this.eey.getPaddingTop();
            int paddingRight = this.eey.getPaddingRight();
            int paddingBottom = this.eey.getPaddingBottom();
            this.eeq.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eeq.getLayoutMode().u(this.lJ);
            this.eex.setSelected(this.eeA.isSelected());
            if (this.eeA.isSelected() && this.eeq.aFl()) {
                ak.i(this.eey, d.f.bg_information_down_s);
            } else {
                ak.i(this.eey, d.f.selector_group_updates_bottom_bg);
            }
            this.eey.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eeA = updatesItemData;
    }
}
