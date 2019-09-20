package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView cax;
    private UpdatesActivity gOe;
    private View gOf;
    private HeadImageView gOg;
    private TextView gOh;
    private TextView gOi;
    private TextView gOj;
    private ImageView gOk;
    private RelativeLayout gOl;
    private RelativeLayout gOm;
    private UpdatesItemData gOn;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gOe = updatesActivity;
        initView();
    }

    void initView() {
        this.gOf = this.sP.findViewById(R.id.root_view);
        this.gOg = (HeadImageView) this.gOf.findViewById(R.id.iv_head);
        this.gOh = (TextView) this.gOf.findViewById(R.id.tv_group_name);
        this.gOi = (TextView) this.gOf.findViewById(R.id.tv_content);
        this.cax = (TextView) this.gOf.findViewById(R.id.tv_title);
        this.gOj = (TextView) this.gOf.findViewById(R.id.tv_time);
        this.gOk = (ImageView) this.gOf.findViewById(R.id.cb_select);
        this.gOl = (RelativeLayout) this.gOf.findViewById(R.id.layout_body);
        this.gOm = (RelativeLayout) this.gOf.findViewById(R.id.layout_title);
        this.gOg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gOl.setClickable(true);
        this.gOl.setLongClickable(true);
        this.gOm.setClickable(true);
        this.gOm.setLongClickable(true);
        this.gOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gOe.blR()) {
                    b.this.gOk.performClick();
                } else {
                    b.this.gOe.a(b.this.gOf, 101, 0, 0L, b.this.gOn);
                }
            }
        });
        this.gOl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gOe.b(b.this.gOf, 200, 0, 0L, b.this.gOn);
                return true;
            }
        });
        this.gOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gOe.a(b.this.gOf, 101, 0, 0L, b.this.gOn);
            }
        });
        this.gOm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gOe.b(b.this.gOf, 200, 0, 0L, b.this.gOn);
                return true;
            }
        });
        this.gOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gOe.a(view, view.isSelected(), b.this.gOn);
            }
        });
    }

    public void refresh() {
        if (this.gOn != null) {
            if (this.gOe.blR()) {
                this.gOk.setVisibility(0);
            } else {
                this.gOk.setVisibility(8);
                this.gOl.setSelected(false);
            }
            String groupHeadUrl = this.gOn.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gOg.setTag(groupHeadUrl);
                this.gOg.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gOg.setTag(null);
            }
            this.gOg.setClickable(false);
            if (!TextUtils.isEmpty(this.gOn.getTitle())) {
                this.cax.setText(this.gOn.getTitle());
            } else {
                this.cax.setText(this.gOe.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gOn.getTime());
            this.gOj.setText(aq.m(date));
            if (!TextUtils.isEmpty(this.gOn.getContent())) {
                this.gOi.setText(this.gOn.getContent());
            } else {
                this.gOi.setText("");
            }
            if (!TextUtils.isEmpty(this.gOn.getGroupName())) {
                this.gOh.setText(this.gOn.getGroupName());
            } else {
                this.gOh.setText("");
            }
            int paddingLeft = this.gOl.getPaddingLeft();
            int paddingTop = this.gOl.getPaddingTop();
            int paddingRight = this.gOl.getPaddingRight();
            int paddingBottom = this.gOl.getPaddingBottom();
            this.gOe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gOe.getLayoutMode().onModeChanged(this.sP);
            this.gOk.setSelected(this.gOn.isSelected());
            if (this.gOn.isSelected() && this.gOe.blR()) {
                am.k(this.gOl, R.drawable.bg_information_down_s);
            } else {
                am.k(this.gOl, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gOl.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gOn = updatesItemData;
    }
}
