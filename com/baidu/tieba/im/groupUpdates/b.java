package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes25.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView eTa;
    private TextView jJb;
    private UpdatesActivity kkZ;
    private View kla;
    private HeadImageView klb;
    private TextView klc;
    private TextView kld;
    private ImageView kle;
    private RelativeLayout klf;
    private RelativeLayout klg;
    private UpdatesItemData klh;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kkZ = updatesActivity;
        initView();
    }

    void initView() {
        this.kla = this.mConvertView.findViewById(R.id.root_view);
        this.klb = (HeadImageView) this.kla.findViewById(R.id.iv_head);
        this.klc = (TextView) this.kla.findViewById(R.id.tv_group_name);
        this.jJb = (TextView) this.kla.findViewById(R.id.tv_content);
        this.eTa = (TextView) this.kla.findViewById(R.id.tv_title);
        this.kld = (TextView) this.kla.findViewById(R.id.tv_time);
        this.kle = (ImageView) this.kla.findViewById(R.id.cb_select);
        this.klf = (RelativeLayout) this.kla.findViewById(R.id.layout_body);
        this.klg = (RelativeLayout) this.kla.findViewById(R.id.layout_title);
        this.klb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.klf.setClickable(true);
        this.klf.setLongClickable(true);
        this.klg.setClickable(true);
        this.klg.setLongClickable(true);
        this.klf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kkZ.cwI()) {
                    b.this.kle.performClick();
                } else {
                    b.this.kkZ.a(b.this.kla, 101, 0, 0L, b.this.klh);
                }
            }
        });
        this.klf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kkZ.b(b.this.kla, 200, 0, 0L, b.this.klh);
                return true;
            }
        });
        this.klg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kkZ.a(b.this.kla, 101, 0, 0L, b.this.klh);
            }
        });
        this.klg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kkZ.b(b.this.kla, 200, 0, 0L, b.this.klh);
                return true;
            }
        });
        this.kle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kkZ.a(view, view.isSelected(), b.this.klh);
            }
        });
    }

    public void refresh() {
        if (this.klh != null) {
            if (this.kkZ.cwI()) {
                this.kle.setVisibility(0);
            } else {
                this.kle.setVisibility(8);
                this.klf.setSelected(false);
            }
            String groupHeadUrl = this.klh.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.klb.setTag(groupHeadUrl);
                this.klb.startLoad(groupHeadUrl, 10, false);
            } else {
                this.klb.setTag(null);
            }
            this.klb.setClickable(false);
            if (!TextUtils.isEmpty(this.klh.getTitle())) {
                this.eTa.setText(this.klh.getTitle());
            } else {
                this.eTa.setText(this.kkZ.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.klh.getTime());
            this.kld.setText(au.l(date));
            if (!TextUtils.isEmpty(this.klh.getContent())) {
                this.jJb.setText(this.klh.getContent());
            } else {
                this.jJb.setText("");
            }
            if (!TextUtils.isEmpty(this.klh.getGroupName())) {
                this.klc.setText(this.klh.getGroupName());
            } else {
                this.klc.setText("");
            }
            int paddingLeft = this.klf.getPaddingLeft();
            int paddingTop = this.klf.getPaddingTop();
            int paddingRight = this.klf.getPaddingRight();
            int paddingBottom = this.klf.getPaddingBottom();
            this.kkZ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kkZ.getLayoutMode().onModeChanged(this.mConvertView);
            this.kle.setSelected(this.klh.isSelected());
            if (this.klh.isSelected() && this.kkZ.cwI()) {
                ap.setBackgroundResource(this.klf, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.klf, R.drawable.selector_group_updates_bottom_bg);
            }
            this.klf.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.klh = updatesItemData;
    }
}
