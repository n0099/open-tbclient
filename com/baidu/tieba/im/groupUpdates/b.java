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
    private TextView dUc;
    private UpdatesActivity iFk;
    private View iFl;
    private HeadImageView iFm;
    private TextView iFn;
    private TextView iFo;
    private TextView iFp;
    private ImageView iFq;
    private RelativeLayout iFr;
    private RelativeLayout iFs;
    private UpdatesItemData iFt;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.iFk = updatesActivity;
        initView();
    }

    void initView() {
        this.iFl = this.mConvertView.findViewById(R.id.root_view);
        this.iFm = (HeadImageView) this.iFl.findViewById(R.id.iv_head);
        this.iFn = (TextView) this.iFl.findViewById(R.id.tv_group_name);
        this.iFo = (TextView) this.iFl.findViewById(R.id.tv_content);
        this.dUc = (TextView) this.iFl.findViewById(R.id.tv_title);
        this.iFp = (TextView) this.iFl.findViewById(R.id.tv_time);
        this.iFq = (ImageView) this.iFl.findViewById(R.id.cb_select);
        this.iFr = (RelativeLayout) this.iFl.findViewById(R.id.layout_body);
        this.iFs = (RelativeLayout) this.iFl.findViewById(R.id.layout_title);
        this.iFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.iFr.setClickable(true);
        this.iFr.setLongClickable(true);
        this.iFs.setClickable(true);
        this.iFs.setLongClickable(true);
        this.iFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.iFk.bTY()) {
                    b.this.iFq.performClick();
                } else {
                    b.this.iFk.a(b.this.iFl, 101, 0, 0L, b.this.iFt);
                }
            }
        });
        this.iFr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iFk.b(b.this.iFl, 200, 0, 0L, b.this.iFt);
                return true;
            }
        });
        this.iFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iFk.a(b.this.iFl, 101, 0, 0L, b.this.iFt);
            }
        });
        this.iFs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iFk.b(b.this.iFl, 200, 0, 0L, b.this.iFt);
                return true;
            }
        });
        this.iFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.iFk.a(view, view.isSelected(), b.this.iFt);
            }
        });
    }

    public void refresh() {
        if (this.iFt != null) {
            if (this.iFk.bTY()) {
                this.iFq.setVisibility(0);
            } else {
                this.iFq.setVisibility(8);
                this.iFr.setSelected(false);
            }
            String groupHeadUrl = this.iFt.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.iFm.setTag(groupHeadUrl);
                this.iFm.startLoad(groupHeadUrl, 10, false);
            } else {
                this.iFm.setTag(null);
            }
            this.iFm.setClickable(false);
            if (!TextUtils.isEmpty(this.iFt.getTitle())) {
                this.dUc.setText(this.iFt.getTitle());
            } else {
                this.dUc.setText(this.iFk.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.iFt.getTime());
            this.iFp.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.iFt.getContent())) {
                this.iFo.setText(this.iFt.getContent());
            } else {
                this.iFo.setText("");
            }
            if (!TextUtils.isEmpty(this.iFt.getGroupName())) {
                this.iFn.setText(this.iFt.getGroupName());
            } else {
                this.iFn.setText("");
            }
            int paddingLeft = this.iFr.getPaddingLeft();
            int paddingTop = this.iFr.getPaddingTop();
            int paddingRight = this.iFr.getPaddingRight();
            int paddingBottom = this.iFr.getPaddingBottom();
            this.iFk.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.iFk.getLayoutMode().onModeChanged(this.mConvertView);
            this.iFq.setSelected(this.iFt.isSelected());
            if (this.iFt.isSelected() && this.iFk.bTY()) {
                am.setBackgroundResource(this.iFr, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.iFr, R.drawable.selector_group_updates_bottom_bg);
            }
            this.iFr.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.iFt = updatesItemData;
    }
}
