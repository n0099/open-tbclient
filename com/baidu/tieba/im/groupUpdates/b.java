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
    private UpdatesActivity edj;
    private View edl;
    private HeadImageView edm;
    private TextView edn;
    private TextView edo;
    private TextView edp;
    private ImageView edq;
    private RelativeLayout edr;
    private RelativeLayout eds;
    private UpdatesItemData edt;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.i.updates_item);
        this.edj = updatesActivity;
        initView();
    }

    void initView() {
        this.edl = this.lJ.findViewById(d.g.root_view);
        this.edm = (HeadImageView) this.edl.findViewById(d.g.iv_head);
        this.edn = (TextView) this.edl.findViewById(d.g.tv_group_name);
        this.edo = (TextView) this.edl.findViewById(d.g.tv_content);
        this.amY = (TextView) this.edl.findViewById(d.g.tv_title);
        this.edp = (TextView) this.edl.findViewById(d.g.tv_time);
        this.edq = (ImageView) this.edl.findViewById(d.g.cb_select);
        this.edr = (RelativeLayout) this.edl.findViewById(d.g.layout_body);
        this.eds = (RelativeLayout) this.edl.findViewById(d.g.layout_title);
        this.edm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        this.edr.setClickable(true);
        this.edr.setLongClickable(true);
        this.eds.setClickable(true);
        this.eds.setLongClickable(true);
        this.edr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.edj.aFn()) {
                    b.this.edq.performClick();
                } else {
                    b.this.edj.a(b.this.edl, 101, 0, 0L, b.this.edt);
                }
            }
        });
        this.edr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.edj.b(b.this.edl, 200, 0, 0L, b.this.edt);
                return true;
            }
        });
        this.eds.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.edj.a(b.this.edl, 101, 0, 0L, b.this.edt);
            }
        });
        this.eds.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.edj.b(b.this.edl, 200, 0, 0L, b.this.edt);
                return true;
            }
        });
        this.edq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view2.setSelected(!view2.isSelected());
                b.this.edj.a(view2, view2.isSelected(), b.this.edt);
            }
        });
    }

    public void refresh() {
        if (this.edt != null) {
            if (this.edj.aFn()) {
                this.edq.setVisibility(0);
            } else {
                this.edq.setVisibility(8);
                this.edr.setSelected(false);
            }
            String groupHeadUrl = this.edt.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.edm.setTag(groupHeadUrl);
                this.edm.startLoad(groupHeadUrl, 10, false);
            } else {
                this.edm.setTag(null);
            }
            this.edm.setClickable(false);
            if (!TextUtils.isEmpty(this.edt.getTitle())) {
                this.amY.setText(this.edt.getTitle());
            } else {
                this.amY.setText(this.edj.getPageContext().getString(d.k.inform));
            }
            Date date = new Date();
            date.setTime(this.edt.getTime());
            this.edp.setText(an.f(date));
            if (!TextUtils.isEmpty(this.edt.getContent())) {
                this.edo.setText(this.edt.getContent());
            } else {
                this.edo.setText("");
            }
            if (!TextUtils.isEmpty(this.edt.getGroupName())) {
                this.edn.setText(this.edt.getGroupName());
            } else {
                this.edn.setText("");
            }
            int paddingLeft = this.edr.getPaddingLeft();
            int paddingTop = this.edr.getPaddingTop();
            int paddingRight = this.edr.getPaddingRight();
            int paddingBottom = this.edr.getPaddingBottom();
            this.edj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.edj.getLayoutMode().u(this.lJ);
            this.edq.setSelected(this.edt.isSelected());
            if (this.edt.isSelected() && this.edj.aFn()) {
                ak.i(this.edr, d.f.bg_information_down_s);
            } else {
                ak.i(this.edr, d.f.selector_group_updates_bottom_bg);
            }
            this.edr.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.edt = updatesItemData;
    }
}
