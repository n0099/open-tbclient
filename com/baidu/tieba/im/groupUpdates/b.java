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
    private TextView avP;
    private HeadImageView etA;
    private TextView etB;
    private TextView etC;
    private TextView etD;
    private ImageView etE;
    private RelativeLayout etF;
    private RelativeLayout etG;
    private UpdatesItemData etH;
    private UpdatesActivity ety;
    private View etz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.i.updates_item);
        this.ety = updatesActivity;
        initView();
    }

    void initView() {
        this.etz = this.sd.findViewById(d.g.root_view);
        this.etA = (HeadImageView) this.etz.findViewById(d.g.iv_head);
        this.etB = (TextView) this.etz.findViewById(d.g.tv_group_name);
        this.etC = (TextView) this.etz.findViewById(d.g.tv_content);
        this.avP = (TextView) this.etz.findViewById(d.g.tv_title);
        this.etD = (TextView) this.etz.findViewById(d.g.tv_time);
        this.etE = (ImageView) this.etz.findViewById(d.g.cb_select);
        this.etF = (RelativeLayout) this.etz.findViewById(d.g.layout_body);
        this.etG = (RelativeLayout) this.etz.findViewById(d.g.layout_title);
        this.etA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.etF.setClickable(true);
        this.etF.setLongClickable(true);
        this.etG.setClickable(true);
        this.etG.setLongClickable(true);
        this.etF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ety.ata()) {
                    b.this.etE.performClick();
                } else {
                    b.this.ety.a(b.this.etz, 101, 0, 0L, b.this.etH);
                }
            }
        });
        this.etF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.ety.b(b.this.etz, 200, 0, 0L, b.this.etH);
                return true;
            }
        });
        this.etG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ety.a(b.this.etz, 101, 0, 0L, b.this.etH);
            }
        });
        this.etG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.ety.b(b.this.etz, 200, 0, 0L, b.this.etH);
                return true;
            }
        });
        this.etE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.ety.a(view, view.isSelected(), b.this.etH);
            }
        });
    }

    public void refresh() {
        if (this.etH != null) {
            if (this.ety.ata()) {
                this.etE.setVisibility(0);
            } else {
                this.etE.setVisibility(8);
                this.etF.setSelected(false);
            }
            String groupHeadUrl = this.etH.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.etA.setTag(groupHeadUrl);
                this.etA.startLoad(groupHeadUrl, 10, false);
            } else {
                this.etA.setTag(null);
            }
            this.etA.setClickable(false);
            if (!TextUtils.isEmpty(this.etH.getTitle())) {
                this.avP.setText(this.etH.getTitle());
            } else {
                this.avP.setText(this.ety.getPageContext().getString(d.k.inform));
            }
            Date date = new Date();
            date.setTime(this.etH.getTime());
            this.etD.setText(ap.h(date));
            if (!TextUtils.isEmpty(this.etH.getContent())) {
                this.etC.setText(this.etH.getContent());
            } else {
                this.etC.setText("");
            }
            if (!TextUtils.isEmpty(this.etH.getGroupName())) {
                this.etB.setText(this.etH.getGroupName());
            } else {
                this.etB.setText("");
            }
            int paddingLeft = this.etF.getPaddingLeft();
            int paddingTop = this.etF.getPaddingTop();
            int paddingRight = this.etF.getPaddingRight();
            int paddingBottom = this.etF.getPaddingBottom();
            this.ety.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.ety.getLayoutMode().onModeChanged(this.sd);
            this.etE.setSelected(this.etH.isSelected());
            if (this.etH.isSelected() && this.ety.ata()) {
                am.i(this.etF, d.f.bg_information_down_s);
            } else {
                am.i(this.etF, d.f.selector_group_updates_bottom_bg);
            }
            this.etF.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.etH = updatesItemData;
    }
}
