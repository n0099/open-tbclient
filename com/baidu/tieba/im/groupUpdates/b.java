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
    private TextView ayF;
    private UpdatesActivity eEE;
    private View eEF;
    private HeadImageView eEG;
    private TextView eEH;
    private TextView eEI;
    private TextView eEJ;
    private ImageView eEK;
    private RelativeLayout eEL;
    private RelativeLayout eEM;
    private UpdatesItemData eEN;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), e.h.updates_item);
        this.eEE = updatesActivity;
        initView();
    }

    void initView() {
        this.eEF = this.uz.findViewById(e.g.root_view);
        this.eEG = (HeadImageView) this.eEF.findViewById(e.g.iv_head);
        this.eEH = (TextView) this.eEF.findViewById(e.g.tv_group_name);
        this.eEI = (TextView) this.eEF.findViewById(e.g.tv_content);
        this.ayF = (TextView) this.eEF.findViewById(e.g.tv_title);
        this.eEJ = (TextView) this.eEF.findViewById(e.g.tv_time);
        this.eEK = (ImageView) this.eEF.findViewById(e.g.cb_select);
        this.eEL = (RelativeLayout) this.eEF.findViewById(e.g.layout_body);
        this.eEM = (RelativeLayout) this.eEF.findViewById(e.g.layout_title);
        this.eEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eEL.setClickable(true);
        this.eEL.setLongClickable(true);
        this.eEM.setClickable(true);
        this.eEM.setLongClickable(true);
        this.eEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eEE.avr()) {
                    b.this.eEK.performClick();
                } else {
                    b.this.eEE.a(b.this.eEF, 101, 0, 0L, b.this.eEN);
                }
            }
        });
        this.eEL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eEE.b(b.this.eEF, 200, 0, 0L, b.this.eEN);
                return true;
            }
        });
        this.eEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eEE.a(b.this.eEF, 101, 0, 0L, b.this.eEN);
            }
        });
        this.eEM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eEE.b(b.this.eEF, 200, 0, 0L, b.this.eEN);
                return true;
            }
        });
        this.eEK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eEE.a(view, view.isSelected(), b.this.eEN);
            }
        });
    }

    public void refresh() {
        if (this.eEN != null) {
            if (this.eEE.avr()) {
                this.eEK.setVisibility(0);
            } else {
                this.eEK.setVisibility(8);
                this.eEL.setSelected(false);
            }
            String groupHeadUrl = this.eEN.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eEG.setTag(groupHeadUrl);
                this.eEG.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eEG.setTag(null);
            }
            this.eEG.setClickable(false);
            if (!TextUtils.isEmpty(this.eEN.getTitle())) {
                this.ayF.setText(this.eEN.getTitle());
            } else {
                this.ayF.setText(this.eEE.getPageContext().getString(e.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eEN.getTime());
            this.eEJ.setText(ao.g(date));
            if (!TextUtils.isEmpty(this.eEN.getContent())) {
                this.eEI.setText(this.eEN.getContent());
            } else {
                this.eEI.setText("");
            }
            if (!TextUtils.isEmpty(this.eEN.getGroupName())) {
                this.eEH.setText(this.eEN.getGroupName());
            } else {
                this.eEH.setText("");
            }
            int paddingLeft = this.eEL.getPaddingLeft();
            int paddingTop = this.eEL.getPaddingTop();
            int paddingRight = this.eEL.getPaddingRight();
            int paddingBottom = this.eEL.getPaddingBottom();
            this.eEE.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eEE.getLayoutMode().onModeChanged(this.uz);
            this.eEK.setSelected(this.eEN.isSelected());
            if (this.eEN.isSelected() && this.eEE.avr()) {
                al.i(this.eEL, e.f.bg_information_down_s);
            } else {
                al.i(this.eEL, e.f.selector_group_updates_bottom_bg);
            }
            this.eEL.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eEN = updatesItemData;
    }
}
