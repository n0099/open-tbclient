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
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView dgc;
    private UpdatesActivity hFi;
    private View hFj;
    private HeadImageView hFk;
    private TextView hFl;
    private TextView hFm;
    private TextView hFn;
    private ImageView hFo;
    private RelativeLayout hFp;
    private RelativeLayout hFq;
    private UpdatesItemData hFr;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.hFi = updatesActivity;
        initView();
    }

    void initView() {
        this.hFj = this.mConvertView.findViewById(R.id.root_view);
        this.hFk = (HeadImageView) this.hFj.findViewById(R.id.iv_head);
        this.hFl = (TextView) this.hFj.findViewById(R.id.tv_group_name);
        this.hFm = (TextView) this.hFj.findViewById(R.id.tv_content);
        this.dgc = (TextView) this.hFj.findViewById(R.id.tv_title);
        this.hFn = (TextView) this.hFj.findViewById(R.id.tv_time);
        this.hFo = (ImageView) this.hFj.findViewById(R.id.cb_select);
        this.hFp = (RelativeLayout) this.hFj.findViewById(R.id.layout_body);
        this.hFq = (RelativeLayout) this.hFj.findViewById(R.id.layout_title);
        this.hFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.hFp.setClickable(true);
        this.hFp.setLongClickable(true);
        this.hFq.setClickable(true);
        this.hFq.setLongClickable(true);
        this.hFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hFi.bCX()) {
                    b.this.hFo.performClick();
                } else {
                    b.this.hFi.a(b.this.hFj, 101, 0, 0L, b.this.hFr);
                }
            }
        });
        this.hFp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hFi.b(b.this.hFj, 200, 0, 0L, b.this.hFr);
                return true;
            }
        });
        this.hFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hFi.a(b.this.hFj, 101, 0, 0L, b.this.hFr);
            }
        });
        this.hFq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hFi.b(b.this.hFj, 200, 0, 0L, b.this.hFr);
                return true;
            }
        });
        this.hFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.hFi.a(view, view.isSelected(), b.this.hFr);
            }
        });
    }

    public void refresh() {
        if (this.hFr != null) {
            if (this.hFi.bCX()) {
                this.hFo.setVisibility(0);
            } else {
                this.hFo.setVisibility(8);
                this.hFp.setSelected(false);
            }
            String groupHeadUrl = this.hFr.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.hFk.setTag(groupHeadUrl);
                this.hFk.startLoad(groupHeadUrl, 10, false);
            } else {
                this.hFk.setTag(null);
            }
            this.hFk.setClickable(false);
            if (!TextUtils.isEmpty(this.hFr.getTitle())) {
                this.dgc.setText(this.hFr.getTitle());
            } else {
                this.dgc.setText(this.hFi.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.hFr.getTime());
            this.hFn.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.hFr.getContent())) {
                this.hFm.setText(this.hFr.getContent());
            } else {
                this.hFm.setText("");
            }
            if (!TextUtils.isEmpty(this.hFr.getGroupName())) {
                this.hFl.setText(this.hFr.getGroupName());
            } else {
                this.hFl.setText("");
            }
            int paddingLeft = this.hFp.getPaddingLeft();
            int paddingTop = this.hFp.getPaddingTop();
            int paddingRight = this.hFp.getPaddingRight();
            int paddingBottom = this.hFp.getPaddingBottom();
            this.hFi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hFi.getLayoutMode().onModeChanged(this.mConvertView);
            this.hFo.setSelected(this.hFr.isSelected());
            if (this.hFr.isSelected() && this.hFi.bCX()) {
                am.setBackgroundResource(this.hFp, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.hFp, R.drawable.selector_group_updates_bottom_bg);
            }
            this.hFp.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.hFr = updatesItemData;
    }
}
