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
    private UpdatesActivity eMn;
    private View eMo;
    private HeadImageView eMp;
    private TextView eMq;
    private TextView eMr;
    private TextView eMs;
    private ImageView eMt;
    private RelativeLayout eMu;
    private RelativeLayout eMv;
    private UpdatesItemData eMw;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eMn = updatesActivity;
        initView();
    }

    void initView() {
        this.eMo = this.vm.findViewById(e.g.root_view);
        this.eMp = (HeadImageView) this.eMo.findViewById(e.g.iv_head);
        this.eMq = (TextView) this.eMo.findViewById(e.g.tv_group_name);
        this.eMr = (TextView) this.eMo.findViewById(e.g.tv_content);
        this.aDo = (TextView) this.eMo.findViewById(e.g.tv_title);
        this.eMs = (TextView) this.eMo.findViewById(e.g.tv_time);
        this.eMt = (ImageView) this.eMo.findViewById(e.g.cb_select);
        this.eMu = (RelativeLayout) this.eMo.findViewById(e.g.layout_body);
        this.eMv = (RelativeLayout) this.eMo.findViewById(e.g.layout_title);
        this.eMp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eMu.setClickable(true);
        this.eMu.setLongClickable(true);
        this.eMv.setClickable(true);
        this.eMv.setLongClickable(true);
        this.eMu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eMn.ayN()) {
                    b.this.eMt.performClick();
                } else {
                    b.this.eMn.a(b.this.eMo, 101, 0, 0L, b.this.eMw);
                }
            }
        });
        this.eMu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eMn.b(b.this.eMo, 200, 0, 0L, b.this.eMw);
                return true;
            }
        });
        this.eMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eMn.a(b.this.eMo, 101, 0, 0L, b.this.eMw);
            }
        });
        this.eMv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eMn.b(b.this.eMo, 200, 0, 0L, b.this.eMw);
                return true;
            }
        });
        this.eMt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eMn.a(view, view.isSelected(), b.this.eMw);
            }
        });
    }

    public void refresh() {
        if (this.eMw != null) {
            if (this.eMn.ayN()) {
                this.eMt.setVisibility(0);
            } else {
                this.eMt.setVisibility(8);
                this.eMu.setSelected(false);
            }
            String groupHeadUrl = this.eMw.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eMp.setTag(groupHeadUrl);
                this.eMp.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eMp.setTag(null);
            }
            this.eMp.setClickable(false);
            if (!TextUtils.isEmpty(this.eMw.getTitle())) {
                this.aDo.setText(this.eMw.getTitle());
            } else {
                this.aDo.setText(this.eMn.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eMw.getTime());
            this.eMs.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eMw.getContent())) {
                this.eMr.setText(this.eMw.getContent());
            } else {
                this.eMr.setText("");
            }
            if (!TextUtils.isEmpty(this.eMw.getGroupName())) {
                this.eMq.setText(this.eMw.getGroupName());
            } else {
                this.eMq.setText("");
            }
            int paddingLeft = this.eMu.getPaddingLeft();
            int paddingTop = this.eMu.getPaddingTop();
            int paddingRight = this.eMu.getPaddingRight();
            int paddingBottom = this.eMu.getPaddingBottom();
            this.eMn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eMn.getLayoutMode().onModeChanged(this.vm);
            this.eMt.setSelected(this.eMw.isSelected());
            if (this.eMw.isSelected() && this.eMn.ayN()) {
                al.i(this.eMu, e.f.bg_information_down_s);
            } else {
                al.i(this.eMu, e.f.selector_group_updates_bottom_bg);
            }
            this.eMu.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eMw = updatesItemData;
    }
}
