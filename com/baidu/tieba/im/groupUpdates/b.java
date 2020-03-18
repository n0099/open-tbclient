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
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView dgp;
    private UpdatesActivity hGI;
    private View hGJ;
    private HeadImageView hGK;
    private TextView hGL;
    private TextView hGM;
    private TextView hGN;
    private ImageView hGO;
    private RelativeLayout hGP;
    private RelativeLayout hGQ;
    private UpdatesItemData hGR;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.hGI = updatesActivity;
        initView();
    }

    void initView() {
        this.hGJ = this.mConvertView.findViewById(R.id.root_view);
        this.hGK = (HeadImageView) this.hGJ.findViewById(R.id.iv_head);
        this.hGL = (TextView) this.hGJ.findViewById(R.id.tv_group_name);
        this.hGM = (TextView) this.hGJ.findViewById(R.id.tv_content);
        this.dgp = (TextView) this.hGJ.findViewById(R.id.tv_title);
        this.hGN = (TextView) this.hGJ.findViewById(R.id.tv_time);
        this.hGO = (ImageView) this.hGJ.findViewById(R.id.cb_select);
        this.hGP = (RelativeLayout) this.hGJ.findViewById(R.id.layout_body);
        this.hGQ = (RelativeLayout) this.hGJ.findViewById(R.id.layout_title);
        this.hGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.hGP.setClickable(true);
        this.hGP.setLongClickable(true);
        this.hGQ.setClickable(true);
        this.hGQ.setLongClickable(true);
        this.hGP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hGI.bDe()) {
                    b.this.hGO.performClick();
                } else {
                    b.this.hGI.a(b.this.hGJ, 101, 0, 0L, b.this.hGR);
                }
            }
        });
        this.hGP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hGI.b(b.this.hGJ, 200, 0, 0L, b.this.hGR);
                return true;
            }
        });
        this.hGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hGI.a(b.this.hGJ, 101, 0, 0L, b.this.hGR);
            }
        });
        this.hGQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hGI.b(b.this.hGJ, 200, 0, 0L, b.this.hGR);
                return true;
            }
        });
        this.hGO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.hGI.a(view, view.isSelected(), b.this.hGR);
            }
        });
    }

    public void refresh() {
        if (this.hGR != null) {
            if (this.hGI.bDe()) {
                this.hGO.setVisibility(0);
            } else {
                this.hGO.setVisibility(8);
                this.hGP.setSelected(false);
            }
            String groupHeadUrl = this.hGR.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.hGK.setTag(groupHeadUrl);
                this.hGK.startLoad(groupHeadUrl, 10, false);
            } else {
                this.hGK.setTag(null);
            }
            this.hGK.setClickable(false);
            if (!TextUtils.isEmpty(this.hGR.getTitle())) {
                this.dgp.setText(this.hGR.getTitle());
            } else {
                this.dgp.setText(this.hGI.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.hGR.getTime());
            this.hGN.setText(aq.j(date));
            if (!TextUtils.isEmpty(this.hGR.getContent())) {
                this.hGM.setText(this.hGR.getContent());
            } else {
                this.hGM.setText("");
            }
            if (!TextUtils.isEmpty(this.hGR.getGroupName())) {
                this.hGL.setText(this.hGR.getGroupName());
            } else {
                this.hGL.setText("");
            }
            int paddingLeft = this.hGP.getPaddingLeft();
            int paddingTop = this.hGP.getPaddingTop();
            int paddingRight = this.hGP.getPaddingRight();
            int paddingBottom = this.hGP.getPaddingBottom();
            this.hGI.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hGI.getLayoutMode().onModeChanged(this.mConvertView);
            this.hGO.setSelected(this.hGR.isSelected());
            if (this.hGR.isSelected() && this.hGI.bDe()) {
                am.setBackgroundResource(this.hGP, R.drawable.bg_information_down_s);
            } else {
                am.setBackgroundResource(this.hGP, R.drawable.selector_group_updates_bottom_bg);
            }
            this.hGP.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.hGR = updatesItemData;
    }
}
