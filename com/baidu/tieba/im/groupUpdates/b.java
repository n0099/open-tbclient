package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.Date;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView eru;
    private TextView iSi;
    private UpdatesActivity jun;
    private View juo;
    private HeadImageView jup;
    private TextView juq;
    private TextView jur;
    private ImageView jus;
    private RelativeLayout jut;
    private RelativeLayout juu;
    private UpdatesItemData juv;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.jun = updatesActivity;
        initView();
    }

    void initView() {
        this.juo = this.mConvertView.findViewById(R.id.root_view);
        this.jup = (HeadImageView) this.juo.findViewById(R.id.iv_head);
        this.juq = (TextView) this.juo.findViewById(R.id.tv_group_name);
        this.iSi = (TextView) this.juo.findViewById(R.id.tv_content);
        this.eru = (TextView) this.juo.findViewById(R.id.tv_title);
        this.jur = (TextView) this.juo.findViewById(R.id.tv_time);
        this.jus = (ImageView) this.juo.findViewById(R.id.cb_select);
        this.jut = (RelativeLayout) this.juo.findViewById(R.id.layout_body);
        this.juu = (RelativeLayout) this.juo.findViewById(R.id.layout_title);
        this.jup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.jut.setClickable(true);
        this.jut.setLongClickable(true);
        this.juu.setClickable(true);
        this.juu.setLongClickable(true);
        this.jut.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jun.ckM()) {
                    b.this.jus.performClick();
                } else {
                    b.this.jun.a(b.this.juo, 101, 0, 0L, b.this.juv);
                }
            }
        });
        this.jut.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jun.b(b.this.juo, 200, 0, 0L, b.this.juv);
                return true;
            }
        });
        this.juu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jun.a(b.this.juo, 101, 0, 0L, b.this.juv);
            }
        });
        this.juu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jun.b(b.this.juo, 200, 0, 0L, b.this.juv);
                return true;
            }
        });
        this.jus.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.jun.a(view, view.isSelected(), b.this.juv);
            }
        });
    }

    public void refresh() {
        if (this.juv != null) {
            if (this.jun.ckM()) {
                this.jus.setVisibility(0);
            } else {
                this.jus.setVisibility(8);
                this.jut.setSelected(false);
            }
            String groupHeadUrl = this.juv.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.jup.setTag(groupHeadUrl);
                this.jup.startLoad(groupHeadUrl, 10, false);
            } else {
                this.jup.setTag(null);
            }
            this.jup.setClickable(false);
            if (!TextUtils.isEmpty(this.juv.getTitle())) {
                this.eru.setText(this.juv.getTitle());
            } else {
                this.eru.setText(this.jun.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.juv.getTime());
            this.jur.setText(at.l(date));
            if (!TextUtils.isEmpty(this.juv.getContent())) {
                this.iSi.setText(this.juv.getContent());
            } else {
                this.iSi.setText("");
            }
            if (!TextUtils.isEmpty(this.juv.getGroupName())) {
                this.juq.setText(this.juv.getGroupName());
            } else {
                this.juq.setText("");
            }
            int paddingLeft = this.jut.getPaddingLeft();
            int paddingTop = this.jut.getPaddingTop();
            int paddingRight = this.jut.getPaddingRight();
            int paddingBottom = this.jut.getPaddingBottom();
            this.jun.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jun.getLayoutMode().onModeChanged(this.mConvertView);
            this.jus.setSelected(this.juv.isSelected());
            if (this.juv.isSelected() && this.jun.ckM()) {
                ap.setBackgroundResource(this.jut, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.jut, R.drawable.selector_group_updates_bottom_bg);
            }
            this.jut.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.juv = updatesItemData;
    }
}
