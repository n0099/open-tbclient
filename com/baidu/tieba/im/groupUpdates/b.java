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
    private UpdatesActivity edm;
    private View edo;
    private HeadImageView edp;
    private TextView edq;
    private TextView edr;
    private TextView eds;
    private ImageView edt;
    private RelativeLayout edu;
    private RelativeLayout edv;
    private UpdatesItemData edw;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), d.i.updates_item);
        this.edm = updatesActivity;
        initView();
    }

    void initView() {
        this.edo = this.lJ.findViewById(d.g.root_view);
        this.edp = (HeadImageView) this.edo.findViewById(d.g.iv_head);
        this.edq = (TextView) this.edo.findViewById(d.g.tv_group_name);
        this.edr = (TextView) this.edo.findViewById(d.g.tv_content);
        this.amY = (TextView) this.edo.findViewById(d.g.tv_title);
        this.eds = (TextView) this.edo.findViewById(d.g.tv_time);
        this.edt = (ImageView) this.edo.findViewById(d.g.cb_select);
        this.edu = (RelativeLayout) this.edo.findViewById(d.g.layout_body);
        this.edv = (RelativeLayout) this.edo.findViewById(d.g.layout_title);
        this.edp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        this.edu.setClickable(true);
        this.edu.setLongClickable(true);
        this.edv.setClickable(true);
        this.edv.setLongClickable(true);
        this.edu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.edm.aFn()) {
                    b.this.edt.performClick();
                } else {
                    b.this.edm.a(b.this.edo, 101, 0, 0L, b.this.edw);
                }
            }
        });
        this.edu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.edm.b(b.this.edo, 200, 0, 0L, b.this.edw);
                return true;
            }
        });
        this.edv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.edm.a(b.this.edo, 101, 0, 0L, b.this.edw);
            }
        });
        this.edv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.edm.b(b.this.edo, 200, 0, 0L, b.this.edw);
                return true;
            }
        });
        this.edt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view2.setSelected(!view2.isSelected());
                b.this.edm.a(view2, view2.isSelected(), b.this.edw);
            }
        });
    }

    public void refresh() {
        if (this.edw != null) {
            if (this.edm.aFn()) {
                this.edt.setVisibility(0);
            } else {
                this.edt.setVisibility(8);
                this.edu.setSelected(false);
            }
            String groupHeadUrl = this.edw.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.edp.setTag(groupHeadUrl);
                this.edp.startLoad(groupHeadUrl, 10, false);
            } else {
                this.edp.setTag(null);
            }
            this.edp.setClickable(false);
            if (!TextUtils.isEmpty(this.edw.getTitle())) {
                this.amY.setText(this.edw.getTitle());
            } else {
                this.amY.setText(this.edm.getPageContext().getString(d.k.inform));
            }
            Date date = new Date();
            date.setTime(this.edw.getTime());
            this.eds.setText(an.f(date));
            if (!TextUtils.isEmpty(this.edw.getContent())) {
                this.edr.setText(this.edw.getContent());
            } else {
                this.edr.setText("");
            }
            if (!TextUtils.isEmpty(this.edw.getGroupName())) {
                this.edq.setText(this.edw.getGroupName());
            } else {
                this.edq.setText("");
            }
            int paddingLeft = this.edu.getPaddingLeft();
            int paddingTop = this.edu.getPaddingTop();
            int paddingRight = this.edu.getPaddingRight();
            int paddingBottom = this.edu.getPaddingBottom();
            this.edm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.edm.getLayoutMode().u(this.lJ);
            this.edt.setSelected(this.edw.isSelected());
            if (this.edw.isSelected() && this.edm.aFn()) {
                ak.i(this.edu, d.f.bg_information_down_s);
            } else {
                ak.i(this.edu, d.f.selector_group_updates_bottom_bg);
            }
            this.edu.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.edw = updatesItemData;
    }
}
