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
    private TextView cok;
    private UpdatesActivity gLo;
    private View gLp;
    private HeadImageView gLq;
    private TextView gLr;
    private TextView gLs;
    private TextView gLt;
    private ImageView gLu;
    private RelativeLayout gLv;
    private RelativeLayout gLw;
    private UpdatesItemData gLx;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gLo = updatesActivity;
        initView();
    }

    void initView() {
        this.gLp = this.mConvertView.findViewById(R.id.root_view);
        this.gLq = (HeadImageView) this.gLp.findViewById(R.id.iv_head);
        this.gLr = (TextView) this.gLp.findViewById(R.id.tv_group_name);
        this.gLs = (TextView) this.gLp.findViewById(R.id.tv_content);
        this.cok = (TextView) this.gLp.findViewById(R.id.tv_title);
        this.gLt = (TextView) this.gLp.findViewById(R.id.tv_time);
        this.gLu = (ImageView) this.gLp.findViewById(R.id.cb_select);
        this.gLv = (RelativeLayout) this.gLp.findViewById(R.id.layout_body);
        this.gLw = (RelativeLayout) this.gLp.findViewById(R.id.layout_title);
        this.gLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gLv.setClickable(true);
        this.gLv.setLongClickable(true);
        this.gLw.setClickable(true);
        this.gLw.setLongClickable(true);
        this.gLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gLo.biV()) {
                    b.this.gLu.performClick();
                } else {
                    b.this.gLo.a(b.this.gLp, 101, 0, 0L, b.this.gLx);
                }
            }
        });
        this.gLv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gLo.b(b.this.gLp, 200, 0, 0L, b.this.gLx);
                return true;
            }
        });
        this.gLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gLo.a(b.this.gLp, 101, 0, 0L, b.this.gLx);
            }
        });
        this.gLw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gLo.b(b.this.gLp, 200, 0, 0L, b.this.gLx);
                return true;
            }
        });
        this.gLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gLo.a(view, view.isSelected(), b.this.gLx);
            }
        });
    }

    public void refresh() {
        if (this.gLx != null) {
            if (this.gLo.biV()) {
                this.gLu.setVisibility(0);
            } else {
                this.gLu.setVisibility(8);
                this.gLv.setSelected(false);
            }
            String groupHeadUrl = this.gLx.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gLq.setTag(groupHeadUrl);
                this.gLq.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gLq.setTag(null);
            }
            this.gLq.setClickable(false);
            if (!TextUtils.isEmpty(this.gLx.getTitle())) {
                this.cok.setText(this.gLx.getTitle());
            } else {
                this.cok.setText(this.gLo.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gLx.getTime());
            this.gLt.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.gLx.getContent())) {
                this.gLs.setText(this.gLx.getContent());
            } else {
                this.gLs.setText("");
            }
            if (!TextUtils.isEmpty(this.gLx.getGroupName())) {
                this.gLr.setText(this.gLx.getGroupName());
            } else {
                this.gLr.setText("");
            }
            int paddingLeft = this.gLv.getPaddingLeft();
            int paddingTop = this.gLv.getPaddingTop();
            int paddingRight = this.gLv.getPaddingRight();
            int paddingBottom = this.gLv.getPaddingBottom();
            this.gLo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gLo.getLayoutMode().onModeChanged(this.mConvertView);
            this.gLu.setSelected(this.gLx.isSelected());
            if (this.gLx.isSelected() && this.gLo.biV()) {
                am.setBackgroundResource(this.gLv, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.gLv, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gLv.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gLx = updatesItemData;
    }
}
