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
    private TextView jWG;
    private TextView kyA;
    private TextView kyB;
    private ImageView kyC;
    private RelativeLayout kyD;
    private RelativeLayout kyE;
    private UpdatesItemData kyF;
    private UpdatesActivity kyx;
    private View kyy;
    private HeadImageView kyz;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kyx = updatesActivity;
        initView();
    }

    void initView() {
        this.kyy = this.mConvertView.findViewById(R.id.root_view);
        this.kyz = (HeadImageView) this.kyy.findViewById(R.id.iv_head);
        this.kyA = (TextView) this.kyy.findViewById(R.id.tv_group_name);
        this.jWG = (TextView) this.kyy.findViewById(R.id.tv_content);
        this.fav = (TextView) this.kyy.findViewById(R.id.tv_title);
        this.kyB = (TextView) this.kyy.findViewById(R.id.tv_time);
        this.kyC = (ImageView) this.kyy.findViewById(R.id.cb_select);
        this.kyD = (RelativeLayout) this.kyy.findViewById(R.id.layout_body);
        this.kyE = (RelativeLayout) this.kyy.findViewById(R.id.layout_title);
        this.kyz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kyD.setClickable(true);
        this.kyD.setLongClickable(true);
        this.kyE.setClickable(true);
        this.kyE.setLongClickable(true);
        this.kyD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kyx.cAY()) {
                    b.this.kyC.performClick();
                } else {
                    b.this.kyx.a(b.this.kyy, 101, 0, 0L, b.this.kyF);
                }
            }
        });
        this.kyD.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kyx.b(b.this.kyy, 200, 0, 0L, b.this.kyF);
                return true;
            }
        });
        this.kyE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kyx.a(b.this.kyy, 101, 0, 0L, b.this.kyF);
            }
        });
        this.kyE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kyx.b(b.this.kyy, 200, 0, 0L, b.this.kyF);
                return true;
            }
        });
        this.kyC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kyx.a(view, view.isSelected(), b.this.kyF);
            }
        });
    }

    public void refresh() {
        if (this.kyF != null) {
            if (this.kyx.cAY()) {
                this.kyC.setVisibility(0);
            } else {
                this.kyC.setVisibility(8);
                this.kyD.setSelected(false);
            }
            String groupHeadUrl = this.kyF.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kyz.setTag(groupHeadUrl);
                this.kyz.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kyz.setTag(null);
            }
            this.kyz.setClickable(false);
            if (!TextUtils.isEmpty(this.kyF.getTitle())) {
                this.fav.setText(this.kyF.getTitle());
            } else {
                this.fav.setText(this.kyx.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kyF.getTime());
            this.kyB.setText(au.l(date));
            if (!TextUtils.isEmpty(this.kyF.getContent())) {
                this.jWG.setText(this.kyF.getContent());
            } else {
                this.jWG.setText("");
            }
            if (!TextUtils.isEmpty(this.kyF.getGroupName())) {
                this.kyA.setText(this.kyF.getGroupName());
            } else {
                this.kyA.setText("");
            }
            int paddingLeft = this.kyD.getPaddingLeft();
            int paddingTop = this.kyD.getPaddingTop();
            int paddingRight = this.kyD.getPaddingRight();
            int paddingBottom = this.kyD.getPaddingBottom();
            this.kyx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kyx.getLayoutMode().onModeChanged(this.mConvertView);
            this.kyC.setSelected(this.kyF.isSelected());
            if (this.kyF.isSelected() && this.kyx.cAY()) {
                ap.setBackgroundResource(this.kyD, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.kyD, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kyD.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kyF = updatesItemData;
    }
}
