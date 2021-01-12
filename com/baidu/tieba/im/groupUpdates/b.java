package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<UpdatesActivity> {
    private TextView ffo;
    private TextView kfm;
    private UpdatesActivity kzn;
    private View kzo;
    private HeadImageView kzp;
    private TextView kzq;
    private TextView kzr;
    private ImageView kzs;
    private RelativeLayout kzt;
    private RelativeLayout kzu;
    private UpdatesItemData kzv;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kzn = updatesActivity;
        initView();
    }

    void initView() {
        this.kzo = this.mConvertView.findViewById(R.id.root_view);
        this.kzp = (HeadImageView) this.kzo.findViewById(R.id.iv_head);
        this.kzq = (TextView) this.kzo.findViewById(R.id.tv_group_name);
        this.kfm = (TextView) this.kzo.findViewById(R.id.tv_content);
        this.ffo = (TextView) this.kzo.findViewById(R.id.tv_title);
        this.kzr = (TextView) this.kzo.findViewById(R.id.tv_time);
        this.kzs = (ImageView) this.kzo.findViewById(R.id.cb_select);
        this.kzt = (RelativeLayout) this.kzo.findViewById(R.id.layout_body);
        this.kzu = (RelativeLayout) this.kzo.findViewById(R.id.layout_title);
        this.kzp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kzt.setClickable(true);
        this.kzt.setLongClickable(true);
        this.kzu.setClickable(true);
        this.kzu.setLongClickable(true);
        this.kzt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kzn.cAa()) {
                    b.this.kzs.performClick();
                } else {
                    b.this.kzn.a(b.this.kzo, 101, 0, 0L, b.this.kzv);
                }
            }
        });
        this.kzt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kzn.b(b.this.kzo, 200, 0, 0L, b.this.kzv);
                return true;
            }
        });
        this.kzu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kzn.a(b.this.kzo, 101, 0, 0L, b.this.kzv);
            }
        });
        this.kzu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kzn.b(b.this.kzo, 200, 0, 0L, b.this.kzv);
                return true;
            }
        });
        this.kzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kzn.a(view, view.isSelected(), b.this.kzv);
            }
        });
    }

    public void refresh() {
        if (this.kzv != null) {
            if (this.kzn.cAa()) {
                this.kzs.setVisibility(0);
            } else {
                this.kzs.setVisibility(8);
                this.kzt.setSelected(false);
            }
            String groupHeadUrl = this.kzv.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kzp.setTag(groupHeadUrl);
                this.kzp.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kzp.setTag(null);
            }
            this.kzp.setClickable(false);
            if (!TextUtils.isEmpty(this.kzv.getTitle())) {
                this.ffo.setText(this.kzv.getTitle());
            } else {
                this.ffo.setText(this.kzn.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kzv.getTime());
            this.kzr.setText(at.l(date));
            if (!TextUtils.isEmpty(this.kzv.getContent())) {
                this.kfm.setText(this.kzv.getContent());
            } else {
                this.kfm.setText("");
            }
            if (!TextUtils.isEmpty(this.kzv.getGroupName())) {
                this.kzq.setText(this.kzv.getGroupName());
            } else {
                this.kzq.setText("");
            }
            int paddingLeft = this.kzt.getPaddingLeft();
            int paddingTop = this.kzt.getPaddingTop();
            int paddingRight = this.kzt.getPaddingRight();
            int paddingBottom = this.kzt.getPaddingBottom();
            this.kzn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kzn.getLayoutMode().onModeChanged(this.mConvertView);
            this.kzs.setSelected(this.kzv.isSelected());
            if (this.kzv.isSelected() && this.kzn.cAa()) {
                ao.setBackgroundResource(this.kzt, R.drawable.bg_information_down_s);
            } else {
                ao.setBackgroundResource(this.kzt, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kzt.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kzv = updatesItemData;
    }
}
