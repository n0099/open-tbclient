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
    private TextView iDi;
    private UpdatesActivity jfl;
    private View jfm;
    private HeadImageView jfn;
    private TextView jfo;
    private TextView jfp;
    private ImageView jfq;
    private RelativeLayout jfr;
    private RelativeLayout jfs;
    private UpdatesItemData jft;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.jfl = updatesActivity;
        initView();
    }

    void initView() {
        this.jfm = this.mConvertView.findViewById(R.id.root_view);
        this.jfn = (HeadImageView) this.jfm.findViewById(R.id.iv_head);
        this.jfo = (TextView) this.jfm.findViewById(R.id.tv_group_name);
        this.iDi = (TextView) this.jfm.findViewById(R.id.tv_content);
        this.ehD = (TextView) this.jfm.findViewById(R.id.tv_title);
        this.jfp = (TextView) this.jfm.findViewById(R.id.tv_time);
        this.jfq = (ImageView) this.jfm.findViewById(R.id.cb_select);
        this.jfr = (RelativeLayout) this.jfm.findViewById(R.id.layout_body);
        this.jfs = (RelativeLayout) this.jfm.findViewById(R.id.layout_title);
        this.jfn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.jfr.setClickable(true);
        this.jfr.setLongClickable(true);
        this.jfs.setClickable(true);
        this.jfs.setLongClickable(true);
        this.jfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jfl.caq()) {
                    b.this.jfq.performClick();
                } else {
                    b.this.jfl.a(b.this.jfm, 101, 0, 0L, b.this.jft);
                }
            }
        });
        this.jfr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jfl.b(b.this.jfm, 200, 0, 0L, b.this.jft);
                return true;
            }
        });
        this.jfs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jfl.a(b.this.jfm, 101, 0, 0L, b.this.jft);
            }
        });
        this.jfs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jfl.b(b.this.jfm, 200, 0, 0L, b.this.jft);
                return true;
            }
        });
        this.jfq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.jfl.a(view, view.isSelected(), b.this.jft);
            }
        });
    }

    public void refresh() {
        if (this.jft != null) {
            if (this.jfl.caq()) {
                this.jfq.setVisibility(0);
            } else {
                this.jfq.setVisibility(8);
                this.jfr.setSelected(false);
            }
            String groupHeadUrl = this.jft.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.jfn.setTag(groupHeadUrl);
                this.jfn.startLoad(groupHeadUrl, 10, false);
            } else {
                this.jfn.setTag(null);
            }
            this.jfn.setClickable(false);
            if (!TextUtils.isEmpty(this.jft.getTitle())) {
                this.ehD.setText(this.jft.getTitle());
            } else {
                this.ehD.setText(this.jfl.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.jft.getTime());
            this.jfp.setText(as.l(date));
            if (!TextUtils.isEmpty(this.jft.getContent())) {
                this.iDi.setText(this.jft.getContent());
            } else {
                this.iDi.setText("");
            }
            if (!TextUtils.isEmpty(this.jft.getGroupName())) {
                this.jfo.setText(this.jft.getGroupName());
            } else {
                this.jfo.setText("");
            }
            int paddingLeft = this.jfr.getPaddingLeft();
            int paddingTop = this.jfr.getPaddingTop();
            int paddingRight = this.jfr.getPaddingRight();
            int paddingBottom = this.jfr.getPaddingBottom();
            this.jfl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jfl.getLayoutMode().onModeChanged(this.mConvertView);
            this.jfq.setSelected(this.jft.isSelected());
            if (this.jft.isSelected() && this.jfl.caq()) {
                ao.setBackgroundResource(this.jfr, R.drawable.bg_information_down_s);
            } else {
                ao.setBackgroundResource(this.jfr, R.drawable.selector_group_updates_bottom_bg);
            }
            this.jfr.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.jft = updatesItemData;
    }
}
