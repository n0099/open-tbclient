package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView bbE;
    private UpdatesActivity eIH;
    private View eIJ;
    private HeadImageView eIK;
    private TextView eIL;
    private TextView eIM;
    private TextView eIN;
    private ImageView eIO;
    private RelativeLayout eIP;
    private RelativeLayout eIQ;
    private UpdatesItemData eIR;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.h.updates_item);
        this.eIH = updatesActivity;
        initView();
    }

    void initView() {
        this.eIJ = this.abw.findViewById(d.g.root_view);
        this.eIK = (HeadImageView) this.eIJ.findViewById(d.g.iv_head);
        this.eIL = (TextView) this.eIJ.findViewById(d.g.tv_group_name);
        this.eIM = (TextView) this.eIJ.findViewById(d.g.tv_content);
        this.bbE = (TextView) this.eIJ.findViewById(d.g.tv_title);
        this.eIN = (TextView) this.eIJ.findViewById(d.g.tv_time);
        this.eIO = (ImageView) this.eIJ.findViewById(d.g.cb_select);
        this.eIP = (RelativeLayout) this.eIJ.findViewById(d.g.layout_body);
        this.eIQ = (RelativeLayout) this.eIJ.findViewById(d.g.layout_title);
        this.eIK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.eIP.setClickable(true);
        this.eIP.setLongClickable(true);
        this.eIQ.setClickable(true);
        this.eIQ.setLongClickable(true);
        this.eIP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eIH.aKq()) {
                    b.this.eIO.performClick();
                } else {
                    b.this.eIH.a(b.this.eIJ, 101, 0, 0L, b.this.eIR);
                }
            }
        });
        this.eIP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eIH.b(b.this.eIJ, 200, 0, 0L, b.this.eIR);
                return true;
            }
        });
        this.eIQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eIH.a(b.this.eIJ, 101, 0, 0L, b.this.eIR);
            }
        });
        this.eIQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eIH.b(b.this.eIJ, 200, 0, 0L, b.this.eIR);
                return true;
            }
        });
        this.eIO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.eIH.a(view, view.isSelected(), b.this.eIR);
            }
        });
    }

    public void refresh() {
        if (this.eIR != null) {
            if (this.eIH.aKq()) {
                this.eIO.setVisibility(0);
            } else {
                this.eIO.setVisibility(8);
                this.eIP.setSelected(false);
            }
            String groupHeadUrl = this.eIR.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.eIK.setTag(groupHeadUrl);
                this.eIK.startLoad(groupHeadUrl, 10, false);
            } else {
                this.eIK.setTag(null);
            }
            this.eIK.setClickable(false);
            if (!TextUtils.isEmpty(this.eIR.getTitle())) {
                this.bbE.setText(this.eIR.getTitle());
            } else {
                this.bbE.setText(this.eIH.getPageContext().getString(d.j.inform));
            }
            Date date = new Date();
            date.setTime(this.eIR.getTime());
            this.eIN.setText(am.e(date));
            if (!TextUtils.isEmpty(this.eIR.getContent())) {
                this.eIM.setText(this.eIR.getContent());
            } else {
                this.eIM.setText("");
            }
            if (!TextUtils.isEmpty(this.eIR.getGroupName())) {
                this.eIL.setText(this.eIR.getGroupName());
            } else {
                this.eIL.setText("");
            }
            int paddingLeft = this.eIP.getPaddingLeft();
            int paddingTop = this.eIP.getPaddingTop();
            int paddingRight = this.eIP.getPaddingRight();
            int paddingBottom = this.eIP.getPaddingBottom();
            this.eIH.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
            this.eIH.getLayoutMode().aM(this.abw);
            this.eIO.setSelected(this.eIR.isSelected());
            if (this.eIR.isSelected() && this.eIH.aKq()) {
                aj.s(this.eIP, d.f.bg_information_down_s);
            } else {
                aj.s(this.eIP, d.f.selector_group_updates_bottom_bg);
            }
            this.eIP.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.eIR = updatesItemData;
    }
}
