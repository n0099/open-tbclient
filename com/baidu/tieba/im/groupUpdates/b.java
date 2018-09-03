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
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView avt;
    private UpdatesActivity exl;
    private View exm;
    private HeadImageView exn;
    private TextView exo;
    private TextView exp;
    private TextView exq;
    private ImageView exr;
    private RelativeLayout exs;
    private RelativeLayout exu;
    private UpdatesItemData exv;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), f.h.updates_item);
        this.exl = updatesActivity;
        initView();
    }

    void initView() {
        this.exm = this.rW.findViewById(f.g.root_view);
        this.exn = (HeadImageView) this.exm.findViewById(f.g.iv_head);
        this.exo = (TextView) this.exm.findViewById(f.g.tv_group_name);
        this.exp = (TextView) this.exm.findViewById(f.g.tv_content);
        this.avt = (TextView) this.exm.findViewById(f.g.tv_title);
        this.exq = (TextView) this.exm.findViewById(f.g.tv_time);
        this.exr = (ImageView) this.exm.findViewById(f.g.cb_select);
        this.exs = (RelativeLayout) this.exm.findViewById(f.g.layout_body);
        this.exu = (RelativeLayout) this.exm.findViewById(f.g.layout_title);
        this.exn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.exs.setClickable(true);
        this.exs.setLongClickable(true);
        this.exu.setClickable(true);
        this.exu.setLongClickable(true);
        this.exs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.exl.atD()) {
                    b.this.exr.performClick();
                } else {
                    b.this.exl.a(b.this.exm, 101, 0, 0L, b.this.exv);
                }
            }
        });
        this.exs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.exl.b(b.this.exm, 200, 0, 0L, b.this.exv);
                return true;
            }
        });
        this.exu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.exl.a(b.this.exm, 101, 0, 0L, b.this.exv);
            }
        });
        this.exu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.exl.b(b.this.exm, 200, 0, 0L, b.this.exv);
                return true;
            }
        });
        this.exr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.exl.a(view, view.isSelected(), b.this.exv);
            }
        });
    }

    public void refresh() {
        if (this.exv != null) {
            if (this.exl.atD()) {
                this.exr.setVisibility(0);
            } else {
                this.exr.setVisibility(8);
                this.exs.setSelected(false);
            }
            String groupHeadUrl = this.exv.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.exn.setTag(groupHeadUrl);
                this.exn.startLoad(groupHeadUrl, 10, false);
            } else {
                this.exn.setTag(null);
            }
            this.exn.setClickable(false);
            if (!TextUtils.isEmpty(this.exv.getTitle())) {
                this.avt.setText(this.exv.getTitle());
            } else {
                this.avt.setText(this.exl.getPageContext().getString(f.j.inform));
            }
            Date date = new Date();
            date.setTime(this.exv.getTime());
            this.exq.setText(ap.g(date));
            if (!TextUtils.isEmpty(this.exv.getContent())) {
                this.exp.setText(this.exv.getContent());
            } else {
                this.exp.setText("");
            }
            if (!TextUtils.isEmpty(this.exv.getGroupName())) {
                this.exo.setText(this.exv.getGroupName());
            } else {
                this.exo.setText("");
            }
            int paddingLeft = this.exs.getPaddingLeft();
            int paddingTop = this.exs.getPaddingTop();
            int paddingRight = this.exs.getPaddingRight();
            int paddingBottom = this.exs.getPaddingBottom();
            this.exl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.exl.getLayoutMode().onModeChanged(this.rW);
            this.exr.setSelected(this.exv.isSelected());
            if (this.exv.isSelected() && this.exl.atD()) {
                am.i(this.exs, f.C0146f.bg_information_down_s);
            } else {
                am.i(this.exs, f.C0146f.selector_group_updates_bottom_bg);
            }
            this.exs.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.exv = updatesItemData;
    }
}
