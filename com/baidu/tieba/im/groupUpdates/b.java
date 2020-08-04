package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView ehD;
    private TextView iDk;
    private UpdatesActivity jfn;
    private View jfo;
    private HeadImageView jfp;
    private TextView jfq;
    private TextView jfr;
    private ImageView jfs;
    private RelativeLayout jft;
    private RelativeLayout jfu;
    private UpdatesItemData jfv;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.jfn = updatesActivity;
        initView();
    }

    void initView() {
        this.jfo = this.mConvertView.findViewById(R.id.root_view);
        this.jfp = (HeadImageView) this.jfo.findViewById(R.id.iv_head);
        this.jfq = (TextView) this.jfo.findViewById(R.id.tv_group_name);
        this.iDk = (TextView) this.jfo.findViewById(R.id.tv_content);
        this.ehD = (TextView) this.jfo.findViewById(R.id.tv_title);
        this.jfr = (TextView) this.jfo.findViewById(R.id.tv_time);
        this.jfs = (ImageView) this.jfo.findViewById(R.id.cb_select);
        this.jft = (RelativeLayout) this.jfo.findViewById(R.id.layout_body);
        this.jfu = (RelativeLayout) this.jfo.findViewById(R.id.layout_title);
        this.jfp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.jft.setClickable(true);
        this.jft.setLongClickable(true);
        this.jfu.setClickable(true);
        this.jfu.setLongClickable(true);
        this.jft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jfn.caq()) {
                    b.this.jfs.performClick();
                } else {
                    b.this.jfn.a(b.this.jfo, 101, 0, 0L, b.this.jfv);
                }
            }
        });
        this.jft.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jfn.b(b.this.jfo, 200, 0, 0L, b.this.jfv);
                return true;
            }
        });
        this.jfu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jfn.a(b.this.jfo, 101, 0, 0L, b.this.jfv);
            }
        });
        this.jfu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jfn.b(b.this.jfo, 200, 0, 0L, b.this.jfv);
                return true;
            }
        });
        this.jfs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.jfn.a(view, view.isSelected(), b.this.jfv);
            }
        });
    }

    public void refresh() {
        if (this.jfv != null) {
            if (this.jfn.caq()) {
                this.jfs.setVisibility(0);
            } else {
                this.jfs.setVisibility(8);
                this.jft.setSelected(false);
            }
            String groupHeadUrl = this.jfv.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.jfp.setTag(groupHeadUrl);
                this.jfp.startLoad(groupHeadUrl, 10, false);
            } else {
                this.jfp.setTag(null);
            }
            this.jfp.setClickable(false);
            if (!TextUtils.isEmpty(this.jfv.getTitle())) {
                this.ehD.setText(this.jfv.getTitle());
            } else {
                this.ehD.setText(this.jfn.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.jfv.getTime());
            this.jfr.setText(as.l(date));
            if (!TextUtils.isEmpty(this.jfv.getContent())) {
                this.iDk.setText(this.jfv.getContent());
            } else {
                this.iDk.setText("");
            }
            if (!TextUtils.isEmpty(this.jfv.getGroupName())) {
                this.jfq.setText(this.jfv.getGroupName());
            } else {
                this.jfq.setText("");
            }
            int paddingLeft = this.jft.getPaddingLeft();
            int paddingTop = this.jft.getPaddingTop();
            int paddingRight = this.jft.getPaddingRight();
            int paddingBottom = this.jft.getPaddingBottom();
            this.jfn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jfn.getLayoutMode().onModeChanged(this.mConvertView);
            this.jfs.setSelected(this.jfv.isSelected());
            if (this.jfv.isSelected() && this.jfn.caq()) {
                ao.setBackgroundResource(this.jft, R.drawable.bg_information_down_s);
            } else {
                ao.setBackgroundResource(this.jft, R.drawable.selector_group_updates_bottom_bg);
            }
            this.jft.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.jfv = updatesItemData;
    }
}
