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
    private UpdatesActivity gFh;
    private View gFi;
    private HeadImageView gFj;
    private TextView gFk;
    private TextView gFl;
    private TextView gFm;
    private ImageView gFn;
    private RelativeLayout gFo;
    private RelativeLayout gFp;
    private UpdatesItemData gFq;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gFh = updatesActivity;
        initView();
    }

    void initView() {
        this.gFi = this.sN.findViewById(R.id.root_view);
        this.gFj = (HeadImageView) this.gFi.findViewById(R.id.iv_head);
        this.gFk = (TextView) this.gFi.findViewById(R.id.tv_group_name);
        this.gFl = (TextView) this.gFi.findViewById(R.id.tv_content);
        this.bYv = (TextView) this.gFi.findViewById(R.id.tv_title);
        this.gFm = (TextView) this.gFi.findViewById(R.id.tv_time);
        this.gFn = (ImageView) this.gFi.findViewById(R.id.cb_select);
        this.gFo = (RelativeLayout) this.gFi.findViewById(R.id.layout_body);
        this.gFp = (RelativeLayout) this.gFi.findViewById(R.id.layout_title);
        this.gFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gFo.setClickable(true);
        this.gFo.setLongClickable(true);
        this.gFp.setClickable(true);
        this.gFp.setLongClickable(true);
        this.gFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gFh.biU()) {
                    b.this.gFn.performClick();
                } else {
                    b.this.gFh.a(b.this.gFi, 101, 0, 0L, b.this.gFq);
                }
            }
        });
        this.gFo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gFh.b(b.this.gFi, 200, 0, 0L, b.this.gFq);
                return true;
            }
        });
        this.gFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gFh.a(b.this.gFi, 101, 0, 0L, b.this.gFq);
            }
        });
        this.gFp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gFh.b(b.this.gFi, 200, 0, 0L, b.this.gFq);
                return true;
            }
        });
        this.gFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gFh.a(view, view.isSelected(), b.this.gFq);
            }
        });
    }

    public void refresh() {
        if (this.gFq != null) {
            if (this.gFh.biU()) {
                this.gFn.setVisibility(0);
            } else {
                this.gFn.setVisibility(8);
                this.gFo.setSelected(false);
            }
            String groupHeadUrl = this.gFq.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gFj.setTag(groupHeadUrl);
                this.gFj.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gFj.setTag(null);
            }
            this.gFj.setClickable(false);
            if (!TextUtils.isEmpty(this.gFq.getTitle())) {
                this.bYv.setText(this.gFq.getTitle());
            } else {
                this.bYv.setText(this.gFh.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gFq.getTime());
            this.gFm.setText(ap.m(date));
            if (!TextUtils.isEmpty(this.gFq.getContent())) {
                this.gFl.setText(this.gFq.getContent());
            } else {
                this.gFl.setText("");
            }
            if (!TextUtils.isEmpty(this.gFq.getGroupName())) {
                this.gFk.setText(this.gFq.getGroupName());
            } else {
                this.gFk.setText("");
            }
            int paddingLeft = this.gFo.getPaddingLeft();
            int paddingTop = this.gFo.getPaddingTop();
            int paddingRight = this.gFo.getPaddingRight();
            int paddingBottom = this.gFo.getPaddingBottom();
            this.gFh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gFh.getLayoutMode().onModeChanged(this.sN);
            this.gFn.setSelected(this.gFq.isSelected());
            if (this.gFq.isSelected() && this.gFh.biU()) {
                al.k(this.gFo, R.drawable.bg_information_down_s);
            } else {
                al.k(this.gFo, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gFo.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gFq = updatesItemData;
    }
}
