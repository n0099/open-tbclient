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
    private TextView ery;
    private TextView iSo;
    private RelativeLayout juA;
    private UpdatesItemData juB;
    private UpdatesActivity jut;
    private View juu;
    private HeadImageView juv;
    private TextView juw;
    private TextView jux;
    private ImageView juy;
    private RelativeLayout juz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.jut = updatesActivity;
        initView();
    }

    void initView() {
        this.juu = this.mConvertView.findViewById(R.id.root_view);
        this.juv = (HeadImageView) this.juu.findViewById(R.id.iv_head);
        this.juw = (TextView) this.juu.findViewById(R.id.tv_group_name);
        this.iSo = (TextView) this.juu.findViewById(R.id.tv_content);
        this.ery = (TextView) this.juu.findViewById(R.id.tv_title);
        this.jux = (TextView) this.juu.findViewById(R.id.tv_time);
        this.juy = (ImageView) this.juu.findViewById(R.id.cb_select);
        this.juz = (RelativeLayout) this.juu.findViewById(R.id.layout_body);
        this.juA = (RelativeLayout) this.juu.findViewById(R.id.layout_title);
        this.juv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.juz.setClickable(true);
        this.juz.setLongClickable(true);
        this.juA.setClickable(true);
        this.juA.setLongClickable(true);
        this.juz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jut.ckN()) {
                    b.this.juy.performClick();
                } else {
                    b.this.jut.a(b.this.juu, 101, 0, 0L, b.this.juB);
                }
            }
        });
        this.juz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jut.b(b.this.juu, 200, 0, 0L, b.this.juB);
                return true;
            }
        });
        this.juA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jut.a(b.this.juu, 101, 0, 0L, b.this.juB);
            }
        });
        this.juA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jut.b(b.this.juu, 200, 0, 0L, b.this.juB);
                return true;
            }
        });
        this.juy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.jut.a(view, view.isSelected(), b.this.juB);
            }
        });
    }

    public void refresh() {
        if (this.juB != null) {
            if (this.jut.ckN()) {
                this.juy.setVisibility(0);
            } else {
                this.juy.setVisibility(8);
                this.juz.setSelected(false);
            }
            String groupHeadUrl = this.juB.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.juv.setTag(groupHeadUrl);
                this.juv.startLoad(groupHeadUrl, 10, false);
            } else {
                this.juv.setTag(null);
            }
            this.juv.setClickable(false);
            if (!TextUtils.isEmpty(this.juB.getTitle())) {
                this.ery.setText(this.juB.getTitle());
            } else {
                this.ery.setText(this.jut.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.juB.getTime());
            this.jux.setText(at.l(date));
            if (!TextUtils.isEmpty(this.juB.getContent())) {
                this.iSo.setText(this.juB.getContent());
            } else {
                this.iSo.setText("");
            }
            if (!TextUtils.isEmpty(this.juB.getGroupName())) {
                this.juw.setText(this.juB.getGroupName());
            } else {
                this.juw.setText("");
            }
            int paddingLeft = this.juz.getPaddingLeft();
            int paddingTop = this.juz.getPaddingTop();
            int paddingRight = this.juz.getPaddingRight();
            int paddingBottom = this.juz.getPaddingBottom();
            this.jut.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jut.getLayoutMode().onModeChanged(this.mConvertView);
            this.juy.setSelected(this.juB.isSelected());
            if (this.juB.isSelected() && this.jut.ckN()) {
                ap.setBackgroundResource(this.juz, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.juz, R.drawable.selector_group_updates_bottom_bg);
            }
            this.juz.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.juB = updatesItemData;
    }
}
