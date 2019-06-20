package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView bYw;
    private UpdatesActivity gFk;
    private View gFl;
    private HeadImageView gFm;
    private TextView gFn;
    private TextView gFo;
    private TextView gFp;
    private ImageView gFq;
    private RelativeLayout gFr;
    private RelativeLayout gFs;
    private UpdatesItemData gFt;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gFk = updatesActivity;
        initView();
    }

    void initView() {
        this.gFl = this.sM.findViewById(R.id.root_view);
        this.gFm = (HeadImageView) this.gFl.findViewById(R.id.iv_head);
        this.gFn = (TextView) this.gFl.findViewById(R.id.tv_group_name);
        this.gFo = (TextView) this.gFl.findViewById(R.id.tv_content);
        this.bYw = (TextView) this.gFl.findViewById(R.id.tv_title);
        this.gFp = (TextView) this.gFl.findViewById(R.id.tv_time);
        this.gFq = (ImageView) this.gFl.findViewById(R.id.cb_select);
        this.gFr = (RelativeLayout) this.gFl.findViewById(R.id.layout_body);
        this.gFs = (RelativeLayout) this.gFl.findViewById(R.id.layout_title);
        this.gFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gFr.setClickable(true);
        this.gFr.setLongClickable(true);
        this.gFs.setClickable(true);
        this.gFs.setLongClickable(true);
        this.gFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gFk.biX()) {
                    b.this.gFq.performClick();
                } else {
                    b.this.gFk.a(b.this.gFl, 101, 0, 0L, b.this.gFt);
                }
            }
        });
        this.gFr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gFk.b(b.this.gFl, 200, 0, 0L, b.this.gFt);
                return true;
            }
        });
        this.gFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gFk.a(b.this.gFl, 101, 0, 0L, b.this.gFt);
            }
        });
        this.gFs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gFk.b(b.this.gFl, 200, 0, 0L, b.this.gFt);
                return true;
            }
        });
        this.gFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gFk.a(view, view.isSelected(), b.this.gFt);
            }
        });
    }

    public void refresh() {
        if (this.gFt != null) {
            if (this.gFk.biX()) {
                this.gFq.setVisibility(0);
            } else {
                this.gFq.setVisibility(8);
                this.gFr.setSelected(false);
            }
            String groupHeadUrl = this.gFt.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gFm.setTag(groupHeadUrl);
                this.gFm.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gFm.setTag(null);
            }
            this.gFm.setClickable(false);
            if (!TextUtils.isEmpty(this.gFt.getTitle())) {
                this.bYw.setText(this.gFt.getTitle());
            } else {
                this.bYw.setText(this.gFk.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gFt.getTime());
            this.gFp.setText(ap.m(date));
            if (!TextUtils.isEmpty(this.gFt.getContent())) {
                this.gFo.setText(this.gFt.getContent());
            } else {
                this.gFo.setText("");
            }
            if (!TextUtils.isEmpty(this.gFt.getGroupName())) {
                this.gFn.setText(this.gFt.getGroupName());
            } else {
                this.gFn.setText("");
            }
            int paddingLeft = this.gFr.getPaddingLeft();
            int paddingTop = this.gFr.getPaddingTop();
            int paddingRight = this.gFr.getPaddingRight();
            int paddingBottom = this.gFr.getPaddingBottom();
            this.gFk.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gFk.getLayoutMode().onModeChanged(this.sM);
            this.gFq.setSelected(this.gFt.isSelected());
            if (this.gFt.isSelected() && this.gFk.biX()) {
                al.k(this.gFr, R.drawable.bg_information_down_s);
            } else {
                al.k(this.gFr, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gFr.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gFt = updatesItemData;
    }
}
