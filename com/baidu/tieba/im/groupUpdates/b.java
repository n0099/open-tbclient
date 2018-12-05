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
    private TextView aHE;
    private TextView eUA;
    private ImageView eUB;
    private RelativeLayout eUC;
    private RelativeLayout eUD;
    private UpdatesItemData eUE;
    private UpdatesActivity eUv;
    private View eUw;
    private HeadImageView eUx;
    private TextView eUy;
    private TextView eUz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eUv = updatesActivity;
        initView();
    }

    void initView() {
        this.eUw = this.vo.findViewById(e.g.root_view);
        this.eUx = (HeadImageView) this.eUw.findViewById(e.g.iv_head);
        this.eUy = (TextView) this.eUw.findViewById(e.g.tv_group_name);
        this.eUz = (TextView) this.eUw.findViewById(e.g.tv_content);
        this.aHE = (TextView) this.eUw.findViewById(e.g.tv_title);
        this.eUA = (TextView) this.eUw.findViewById(e.g.tv_time);
        this.eUB = (ImageView) this.eUw.findViewById(e.g.cb_select);
        this.eUC = (RelativeLayout) this.eUw.findViewById(e.g.layout_body);
        this.eUD = (RelativeLayout) this.eUw.findViewById(e.g.layout_title);
        this.eUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eUC.setClickable(true);
        this.eUC.setLongClickable(true);
        this.eUD.setClickable(true);
        this.eUD.setLongClickable(true);
        this.eUC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eUv.azV()) {
                    b.this.eUB.performClick();
                } else {
                    b.this.eUv.a(b.this.eUw, 101, 0, 0L, b.this.eUE);
                }
            }
        });
        this.eUC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eUv.b(b.this.eUw, 200, 0, 0L, b.this.eUE);
                return true;
            }
        });
        this.eUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eUv.a(b.this.eUw, 101, 0, 0L, b.this.eUE);
            }
        });
        this.eUD.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eUv.b(b.this.eUw, 200, 0, 0L, b.this.eUE);
                return true;
            }
        });
        this.eUB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eUv.a(view, view.isSelected(), b.this.eUE);
            }
        });
    }

    public void refresh() {
        if (this.eUE != null) {
            if (this.eUv.azV()) {
                this.eUB.setVisibility(0);
            } else {
                this.eUB.setVisibility(8);
                this.eUC.setSelected(false);
            }
            String groupHeadUrl = this.eUE.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eUx.setTag(groupHeadUrl);
                this.eUx.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eUx.setTag(null);
            }
            this.eUx.setClickable(false);
            if (!TextUtils.isEmpty(this.eUE.getTitle())) {
                this.aHE.setText(this.eUE.getTitle());
            } else {
                this.aHE.setText(this.eUv.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eUE.getTime());
            this.eUA.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eUE.getContent())) {
                this.eUz.setText(this.eUE.getContent());
            } else {
                this.eUz.setText("");
            }
            if (!TextUtils.isEmpty(this.eUE.getGroupName())) {
                this.eUy.setText(this.eUE.getGroupName());
            } else {
                this.eUy.setText("");
            }
            int paddingLeft = this.eUC.getPaddingLeft();
            int paddingTop = this.eUC.getPaddingTop();
            int paddingRight = this.eUC.getPaddingRight();
            int paddingBottom = this.eUC.getPaddingBottom();
            this.eUv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eUv.getLayoutMode().onModeChanged(this.vo);
            this.eUB.setSelected(this.eUE.isSelected());
            if (this.eUE.isSelected() && this.eUv.azV()) {
                al.i(this.eUC, e.f.bg_information_down_s);
            } else {
                al.i(this.eUC, e.f.selector_group_updates_bottom_bg);
            }
            this.eUC.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eUE = updatesItemData;
    }
}
