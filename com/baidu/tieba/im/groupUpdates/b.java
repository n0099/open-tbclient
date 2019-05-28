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
    private TextView bYv;
    private UpdatesActivity gFi;
    private View gFj;
    private HeadImageView gFk;
    private TextView gFl;
    private TextView gFm;
    private TextView gFn;
    private ImageView gFo;
    private RelativeLayout gFp;
    private RelativeLayout gFq;
    private UpdatesItemData gFr;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gFi = updatesActivity;
        initView();
    }

    void initView() {
        this.gFj = this.sN.findViewById(R.id.root_view);
        this.gFk = (HeadImageView) this.gFj.findViewById(R.id.iv_head);
        this.gFl = (TextView) this.gFj.findViewById(R.id.tv_group_name);
        this.gFm = (TextView) this.gFj.findViewById(R.id.tv_content);
        this.bYv = (TextView) this.gFj.findViewById(R.id.tv_title);
        this.gFn = (TextView) this.gFj.findViewById(R.id.tv_time);
        this.gFo = (ImageView) this.gFj.findViewById(R.id.cb_select);
        this.gFp = (RelativeLayout) this.gFj.findViewById(R.id.layout_body);
        this.gFq = (RelativeLayout) this.gFj.findViewById(R.id.layout_title);
        this.gFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gFp.setClickable(true);
        this.gFp.setLongClickable(true);
        this.gFq.setClickable(true);
        this.gFq.setLongClickable(true);
        this.gFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gFi.biX()) {
                    b.this.gFo.performClick();
                } else {
                    b.this.gFi.a(b.this.gFj, 101, 0, 0L, b.this.gFr);
                }
            }
        });
        this.gFp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gFi.b(b.this.gFj, 200, 0, 0L, b.this.gFr);
                return true;
            }
        });
        this.gFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gFi.a(b.this.gFj, 101, 0, 0L, b.this.gFr);
            }
        });
        this.gFq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gFi.b(b.this.gFj, 200, 0, 0L, b.this.gFr);
                return true;
            }
        });
        this.gFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gFi.a(view, view.isSelected(), b.this.gFr);
            }
        });
    }

    public void refresh() {
        if (this.gFr != null) {
            if (this.gFi.biX()) {
                this.gFo.setVisibility(0);
            } else {
                this.gFo.setVisibility(8);
                this.gFp.setSelected(false);
            }
            String groupHeadUrl = this.gFr.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gFk.setTag(groupHeadUrl);
                this.gFk.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gFk.setTag(null);
            }
            this.gFk.setClickable(false);
            if (!TextUtils.isEmpty(this.gFr.getTitle())) {
                this.bYv.setText(this.gFr.getTitle());
            } else {
                this.bYv.setText(this.gFi.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gFr.getTime());
            this.gFn.setText(ap.m(date));
            if (!TextUtils.isEmpty(this.gFr.getContent())) {
                this.gFm.setText(this.gFr.getContent());
            } else {
                this.gFm.setText("");
            }
            if (!TextUtils.isEmpty(this.gFr.getGroupName())) {
                this.gFl.setText(this.gFr.getGroupName());
            } else {
                this.gFl.setText("");
            }
            int paddingLeft = this.gFp.getPaddingLeft();
            int paddingTop = this.gFp.getPaddingTop();
            int paddingRight = this.gFp.getPaddingRight();
            int paddingBottom = this.gFp.getPaddingBottom();
            this.gFi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gFi.getLayoutMode().onModeChanged(this.sN);
            this.gFo.setSelected(this.gFr.isSelected());
            if (this.gFr.isSelected() && this.gFi.biX()) {
                al.k(this.gFp, R.drawable.bg_information_down_s);
            } else {
                al.k(this.gFp, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gFp.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gFr = updatesItemData;
    }
}
