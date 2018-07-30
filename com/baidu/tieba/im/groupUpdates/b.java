package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView avv;
    private UpdatesActivity exp;
    private View exq;
    private HeadImageView exr;
    private TextView exs;
    private TextView exu;
    private TextView exv;
    private ImageView exw;
    private RelativeLayout exx;
    private RelativeLayout exy;
    private UpdatesItemData exz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.h.updates_item);
        this.exp = updatesActivity;
        initView();
    }

    void initView() {
        this.exq = this.rV.findViewById(d.g.root_view);
        this.exr = (HeadImageView) this.exq.findViewById(d.g.iv_head);
        this.exs = (TextView) this.exq.findViewById(d.g.tv_group_name);
        this.exu = (TextView) this.exq.findViewById(d.g.tv_content);
        this.avv = (TextView) this.exq.findViewById(d.g.tv_title);
        this.exv = (TextView) this.exq.findViewById(d.g.tv_time);
        this.exw = (ImageView) this.exq.findViewById(d.g.cb_select);
        this.exx = (RelativeLayout) this.exq.findViewById(d.g.layout_body);
        this.exy = (RelativeLayout) this.exq.findViewById(d.g.layout_title);
        this.exr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.exx.setClickable(true);
        this.exx.setLongClickable(true);
        this.exy.setClickable(true);
        this.exy.setLongClickable(true);
        this.exx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.exp.atE()) {
                    b.this.exw.performClick();
                } else {
                    b.this.exp.a(b.this.exq, 101, 0, 0L, b.this.exz);
                }
            }
        });
        this.exx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.exp.b(b.this.exq, 200, 0, 0L, b.this.exz);
                return true;
            }
        });
        this.exy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.exp.a(b.this.exq, 101, 0, 0L, b.this.exz);
            }
        });
        this.exy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.exp.b(b.this.exq, 200, 0, 0L, b.this.exz);
                return true;
            }
        });
        this.exw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.exp.a(view, view.isSelected(), b.this.exz);
            }
        });
    }

    public void refresh() {
        if (this.exz != null) {
            if (this.exp.atE()) {
                this.exw.setVisibility(0);
            } else {
                this.exw.setVisibility(8);
                this.exx.setSelected(false);
            }
            String groupHeadUrl = this.exz.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.exr.setTag(groupHeadUrl);
                this.exr.startLoad(groupHeadUrl, 10, false);
            } else {
                this.exr.setTag(null);
            }
            this.exr.setClickable(false);
            if (!TextUtils.isEmpty(this.exz.getTitle())) {
                this.avv.setText(this.exz.getTitle());
            } else {
                this.avv.setText(this.exp.getPageContext().getString(d.j.inform));
            }
            Date date = new Date();
            date.setTime(this.exz.getTime());
            this.exv.setText(ap.g(date));
            if (!TextUtils.isEmpty(this.exz.getContent())) {
                this.exu.setText(this.exz.getContent());
            } else {
                this.exu.setText("");
            }
            if (!TextUtils.isEmpty(this.exz.getGroupName())) {
                this.exs.setText(this.exz.getGroupName());
            } else {
                this.exs.setText("");
            }
            int paddingLeft = this.exx.getPaddingLeft();
            int paddingTop = this.exx.getPaddingTop();
            int paddingRight = this.exx.getPaddingRight();
            int paddingBottom = this.exx.getPaddingBottom();
            this.exp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.exp.getLayoutMode().onModeChanged(this.rV);
            this.exw.setSelected(this.exz.isSelected());
            if (this.exz.isSelected() && this.exp.atE()) {
                am.i(this.exx, d.f.bg_information_down_s);
            } else {
                am.i(this.exx, d.f.selector_group_updates_bottom_bg);
            }
            this.exx.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.exz = updatesItemData;
    }
}
