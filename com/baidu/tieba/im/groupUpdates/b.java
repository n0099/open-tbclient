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
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView fav;
    private TextView jWE;
    private ImageView kyA;
    private RelativeLayout kyB;
    private RelativeLayout kyC;
    private UpdatesItemData kyD;
    private UpdatesActivity kyv;
    private View kyw;
    private HeadImageView kyx;
    private TextView kyy;
    private TextView kyz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kyv = updatesActivity;
        initView();
    }

    void initView() {
        this.kyw = this.mConvertView.findViewById(R.id.root_view);
        this.kyx = (HeadImageView) this.kyw.findViewById(R.id.iv_head);
        this.kyy = (TextView) this.kyw.findViewById(R.id.tv_group_name);
        this.jWE = (TextView) this.kyw.findViewById(R.id.tv_content);
        this.fav = (TextView) this.kyw.findViewById(R.id.tv_title);
        this.kyz = (TextView) this.kyw.findViewById(R.id.tv_time);
        this.kyA = (ImageView) this.kyw.findViewById(R.id.cb_select);
        this.kyB = (RelativeLayout) this.kyw.findViewById(R.id.layout_body);
        this.kyC = (RelativeLayout) this.kyw.findViewById(R.id.layout_title);
        this.kyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kyB.setClickable(true);
        this.kyB.setLongClickable(true);
        this.kyC.setClickable(true);
        this.kyC.setLongClickable(true);
        this.kyB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kyv.cAX()) {
                    b.this.kyA.performClick();
                } else {
                    b.this.kyv.a(b.this.kyw, 101, 0, 0L, b.this.kyD);
                }
            }
        });
        this.kyB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kyv.b(b.this.kyw, 200, 0, 0L, b.this.kyD);
                return true;
            }
        });
        this.kyC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kyv.a(b.this.kyw, 101, 0, 0L, b.this.kyD);
            }
        });
        this.kyC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kyv.b(b.this.kyw, 200, 0, 0L, b.this.kyD);
                return true;
            }
        });
        this.kyA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kyv.a(view, view.isSelected(), b.this.kyD);
            }
        });
    }

    public void refresh() {
        if (this.kyD != null) {
            if (this.kyv.cAX()) {
                this.kyA.setVisibility(0);
            } else {
                this.kyA.setVisibility(8);
                this.kyB.setSelected(false);
            }
            String groupHeadUrl = this.kyD.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kyx.setTag(groupHeadUrl);
                this.kyx.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kyx.setTag(null);
            }
            this.kyx.setClickable(false);
            if (!TextUtils.isEmpty(this.kyD.getTitle())) {
                this.fav.setText(this.kyD.getTitle());
            } else {
                this.fav.setText(this.kyv.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kyD.getTime());
            this.kyz.setText(au.l(date));
            if (!TextUtils.isEmpty(this.kyD.getContent())) {
                this.jWE.setText(this.kyD.getContent());
            } else {
                this.jWE.setText("");
            }
            if (!TextUtils.isEmpty(this.kyD.getGroupName())) {
                this.kyy.setText(this.kyD.getGroupName());
            } else {
                this.kyy.setText("");
            }
            int paddingLeft = this.kyB.getPaddingLeft();
            int paddingTop = this.kyB.getPaddingTop();
            int paddingRight = this.kyB.getPaddingRight();
            int paddingBottom = this.kyB.getPaddingBottom();
            this.kyv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kyv.getLayoutMode().onModeChanged(this.mConvertView);
            this.kyA.setSelected(this.kyD.isSelected());
            if (this.kyD.isSelected() && this.kyv.cAX()) {
                ap.setBackgroundResource(this.kyB, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.kyB, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kyB.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kyD = updatesItemData;
    }
}
