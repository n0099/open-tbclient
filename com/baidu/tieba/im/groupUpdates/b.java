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
    private TextView aDo;
    private UpdatesActivity eMo;
    private View eMp;
    private HeadImageView eMq;
    private TextView eMr;
    private TextView eMs;
    private TextView eMt;
    private ImageView eMu;
    private RelativeLayout eMv;
    private RelativeLayout eMw;
    private UpdatesItemData eMx;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eMo = updatesActivity;
        initView();
    }

    void initView() {
        this.eMp = this.vm.findViewById(e.g.root_view);
        this.eMq = (HeadImageView) this.eMp.findViewById(e.g.iv_head);
        this.eMr = (TextView) this.eMp.findViewById(e.g.tv_group_name);
        this.eMs = (TextView) this.eMp.findViewById(e.g.tv_content);
        this.aDo = (TextView) this.eMp.findViewById(e.g.tv_title);
        this.eMt = (TextView) this.eMp.findViewById(e.g.tv_time);
        this.eMu = (ImageView) this.eMp.findViewById(e.g.cb_select);
        this.eMv = (RelativeLayout) this.eMp.findViewById(e.g.layout_body);
        this.eMw = (RelativeLayout) this.eMp.findViewById(e.g.layout_title);
        this.eMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eMv.setClickable(true);
        this.eMv.setLongClickable(true);
        this.eMw.setClickable(true);
        this.eMw.setLongClickable(true);
        this.eMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eMo.ayO()) {
                    b.this.eMu.performClick();
                } else {
                    b.this.eMo.a(b.this.eMp, 101, 0, 0L, b.this.eMx);
                }
            }
        });
        this.eMv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eMo.b(b.this.eMp, 200, 0, 0L, b.this.eMx);
                return true;
            }
        });
        this.eMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eMo.a(b.this.eMp, 101, 0, 0L, b.this.eMx);
            }
        });
        this.eMw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eMo.b(b.this.eMp, 200, 0, 0L, b.this.eMx);
                return true;
            }
        });
        this.eMu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eMo.a(view, view.isSelected(), b.this.eMx);
            }
        });
    }

    public void refresh() {
        if (this.eMx != null) {
            if (this.eMo.ayO()) {
                this.eMu.setVisibility(0);
            } else {
                this.eMu.setVisibility(8);
                this.eMv.setSelected(false);
            }
            String groupHeadUrl = this.eMx.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eMq.setTag(groupHeadUrl);
                this.eMq.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eMq.setTag(null);
            }
            this.eMq.setClickable(false);
            if (!TextUtils.isEmpty(this.eMx.getTitle())) {
                this.aDo.setText(this.eMx.getTitle());
            } else {
                this.aDo.setText(this.eMo.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eMx.getTime());
            this.eMt.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eMx.getContent())) {
                this.eMs.setText(this.eMx.getContent());
            } else {
                this.eMs.setText("");
            }
            if (!TextUtils.isEmpty(this.eMx.getGroupName())) {
                this.eMr.setText(this.eMx.getGroupName());
            } else {
                this.eMr.setText("");
            }
            int paddingLeft = this.eMv.getPaddingLeft();
            int paddingTop = this.eMv.getPaddingTop();
            int paddingRight = this.eMv.getPaddingRight();
            int paddingBottom = this.eMv.getPaddingBottom();
            this.eMo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eMo.getLayoutMode().onModeChanged(this.vm);
            this.eMu.setSelected(this.eMx.isSelected());
            if (this.eMx.isSelected() && this.eMo.ayO()) {
                al.i(this.eMv, e.f.bg_information_down_s);
            } else {
                al.i(this.eMv, e.f.selector_group_updates_bottom_bg);
            }
            this.eMv.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eMx = updatesItemData;
    }
}
