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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<UpdatesActivity> {
    private TextView fjg;
    private UpdatesActivity kJI;
    private View kJJ;
    private HeadImageView kJK;
    private TextView kJL;
    private TextView kJM;
    private ImageView kJN;
    private RelativeLayout kJO;
    private RelativeLayout kJP;
    private UpdatesItemData kJQ;
    private TextView kpK;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.kJI = updatesActivity;
        initView();
    }

    void initView() {
        this.kJJ = this.mConvertView.findViewById(R.id.root_view);
        this.kJK = (HeadImageView) this.kJJ.findViewById(R.id.iv_head);
        this.kJL = (TextView) this.kJJ.findViewById(R.id.tv_group_name);
        this.kpK = (TextView) this.kJJ.findViewById(R.id.tv_content);
        this.fjg = (TextView) this.kJJ.findViewById(R.id.tv_title);
        this.kJM = (TextView) this.kJJ.findViewById(R.id.tv_time);
        this.kJN = (ImageView) this.kJJ.findViewById(R.id.cb_select);
        this.kJO = (RelativeLayout) this.kJJ.findViewById(R.id.layout_body);
        this.kJP = (RelativeLayout) this.kJJ.findViewById(R.id.layout_title);
        this.kJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kJO.setClickable(true);
        this.kJO.setLongClickable(true);
        this.kJP.setClickable(true);
        this.kJP.setLongClickable(true);
        this.kJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kJI.cBy()) {
                    b.this.kJN.performClick();
                } else {
                    b.this.kJI.a(b.this.kJJ, 101, 0, 0L, b.this.kJQ);
                }
            }
        });
        this.kJO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kJI.b(b.this.kJJ, 200, 0, 0L, b.this.kJQ);
                return true;
            }
        });
        this.kJP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kJI.a(b.this.kJJ, 101, 0, 0L, b.this.kJQ);
            }
        });
        this.kJP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kJI.b(b.this.kJJ, 200, 0, 0L, b.this.kJQ);
                return true;
            }
        });
        this.kJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.kJI.a(view, view.isSelected(), b.this.kJQ);
            }
        });
    }

    public void refresh() {
        if (this.kJQ != null) {
            if (this.kJI.cBy()) {
                this.kJN.setVisibility(0);
            } else {
                this.kJN.setVisibility(8);
                this.kJO.setSelected(false);
            }
            String groupHeadUrl = this.kJQ.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.kJK.setTag(groupHeadUrl);
                this.kJK.startLoad(groupHeadUrl, 10, false);
            } else {
                this.kJK.setTag(null);
            }
            this.kJK.setClickable(false);
            if (!TextUtils.isEmpty(this.kJQ.getTitle())) {
                this.fjg.setText(this.kJQ.getTitle());
            } else {
                this.fjg.setText(this.kJI.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.kJQ.getTime());
            this.kJM.setText(au.l(date));
            if (!TextUtils.isEmpty(this.kJQ.getContent())) {
                this.kpK.setText(this.kJQ.getContent());
            } else {
                this.kpK.setText("");
            }
            if (!TextUtils.isEmpty(this.kJQ.getGroupName())) {
                this.kJL.setText(this.kJQ.getGroupName());
            } else {
                this.kJL.setText("");
            }
            int paddingLeft = this.kJO.getPaddingLeft();
            int paddingTop = this.kJO.getPaddingTop();
            int paddingRight = this.kJO.getPaddingRight();
            int paddingBottom = this.kJO.getPaddingBottom();
            this.kJI.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kJI.getLayoutMode().onModeChanged(this.mConvertView);
            this.kJN.setSelected(this.kJQ.isSelected());
            if (this.kJQ.isSelected() && this.kJI.cBy()) {
                ap.setBackgroundResource(this.kJO, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.kJO, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kJO.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.kJQ = updatesItemData;
    }
}
