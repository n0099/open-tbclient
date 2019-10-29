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
    private TextView cpb;
    private UpdatesActivity gMf;
    private View gMg;
    private HeadImageView gMh;
    private TextView gMi;
    private TextView gMj;
    private TextView gMk;
    private ImageView gMl;
    private RelativeLayout gMm;
    private RelativeLayout gMn;
    private UpdatesItemData gMo;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.gMf = updatesActivity;
        initView();
    }

    void initView() {
        this.gMg = this.mConvertView.findViewById(R.id.root_view);
        this.gMh = (HeadImageView) this.gMg.findViewById(R.id.iv_head);
        this.gMi = (TextView) this.gMg.findViewById(R.id.tv_group_name);
        this.gMj = (TextView) this.gMg.findViewById(R.id.tv_content);
        this.cpb = (TextView) this.gMg.findViewById(R.id.tv_title);
        this.gMk = (TextView) this.gMg.findViewById(R.id.tv_time);
        this.gMl = (ImageView) this.gMg.findViewById(R.id.cb_select);
        this.gMm = (RelativeLayout) this.gMg.findViewById(R.id.layout_body);
        this.gMn = (RelativeLayout) this.gMg.findViewById(R.id.layout_title);
        this.gMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gMm.setClickable(true);
        this.gMm.setLongClickable(true);
        this.gMn.setClickable(true);
        this.gMn.setLongClickable(true);
        this.gMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gMf.biX()) {
                    b.this.gMl.performClick();
                } else {
                    b.this.gMf.a(b.this.gMg, 101, 0, 0L, b.this.gMo);
                }
            }
        });
        this.gMm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gMf.b(b.this.gMg, 200, 0, 0L, b.this.gMo);
                return true;
            }
        });
        this.gMn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gMf.a(b.this.gMg, 101, 0, 0L, b.this.gMo);
            }
        });
        this.gMn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gMf.b(b.this.gMg, 200, 0, 0L, b.this.gMo);
                return true;
            }
        });
        this.gMl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.gMf.a(view, view.isSelected(), b.this.gMo);
            }
        });
    }

    public void refresh() {
        if (this.gMo != null) {
            if (this.gMf.biX()) {
                this.gMl.setVisibility(0);
            } else {
                this.gMl.setVisibility(8);
                this.gMm.setSelected(false);
            }
            String groupHeadUrl = this.gMo.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.gMh.setTag(groupHeadUrl);
                this.gMh.startLoad(groupHeadUrl, 10, false);
            } else {
                this.gMh.setTag(null);
            }
            this.gMh.setClickable(false);
            if (!TextUtils.isEmpty(this.gMo.getTitle())) {
                this.cpb.setText(this.gMo.getTitle());
            } else {
                this.cpb.setText(this.gMf.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.gMo.getTime());
            this.gMk.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.gMo.getContent())) {
                this.gMj.setText(this.gMo.getContent());
            } else {
                this.gMj.setText("");
            }
            if (!TextUtils.isEmpty(this.gMo.getGroupName())) {
                this.gMi.setText(this.gMo.getGroupName());
            } else {
                this.gMi.setText("");
            }
            int paddingLeft = this.gMm.getPaddingLeft();
            int paddingTop = this.gMm.getPaddingTop();
            int paddingRight = this.gMm.getPaddingRight();
            int paddingBottom = this.gMm.getPaddingBottom();
            this.gMf.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gMf.getLayoutMode().onModeChanged(this.mConvertView);
            this.gMl.setSelected(this.gMo.isSelected());
            if (this.gMo.isSelected() && this.gMf.biX()) {
                am.setBackgroundResource(this.gMm, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.gMm, R.drawable.selector_group_updates_bottom_bg);
            }
            this.gMm.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.gMo = updatesItemData;
    }
}
