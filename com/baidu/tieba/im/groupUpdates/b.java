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
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<UpdatesActivity> {
    private TextView eOj;
    private TextView jCt;
    private UpdatesItemData keA;
    private UpdatesActivity ker;
    private View kes;
    private HeadImageView ket;
    private TextView keu;
    private TextView kev;
    private ImageView kew;
    private RelativeLayout kex;
    private RelativeLayout kez;

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.ker = updatesActivity;
        initView();
    }

    void initView() {
        this.kes = this.mConvertView.findViewById(R.id.root_view);
        this.ket = (HeadImageView) this.kes.findViewById(R.id.iv_head);
        this.keu = (TextView) this.kes.findViewById(R.id.tv_group_name);
        this.jCt = (TextView) this.kes.findViewById(R.id.tv_content);
        this.eOj = (TextView) this.kes.findViewById(R.id.tv_title);
        this.kev = (TextView) this.kes.findViewById(R.id.tv_time);
        this.kew = (ImageView) this.kes.findViewById(R.id.cb_select);
        this.kex = (RelativeLayout) this.kes.findViewById(R.id.layout_body);
        this.kez = (RelativeLayout) this.kes.findViewById(R.id.layout_title);
        this.ket.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.kex.setClickable(true);
        this.kex.setLongClickable(true);
        this.kez.setClickable(true);
        this.kez.setLongClickable(true);
        this.kex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ker.cuF()) {
                    b.this.kew.performClick();
                } else {
                    b.this.ker.a(b.this.kes, 101, 0, 0L, b.this.keA);
                }
            }
        });
        this.kex.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.ker.b(b.this.kes, 200, 0, 0L, b.this.keA);
                return true;
            }
        });
        this.kez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ker.a(b.this.kes, 101, 0, 0L, b.this.keA);
            }
        });
        this.kez.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.ker.b(b.this.kes, 200, 0, 0L, b.this.keA);
                return true;
            }
        });
        this.kew.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupUpdates.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
                b.this.ker.a(view, view.isSelected(), b.this.keA);
            }
        });
    }

    public void refresh() {
        if (this.keA != null) {
            if (this.ker.cuF()) {
                this.kew.setVisibility(0);
            } else {
                this.kew.setVisibility(8);
                this.kex.setSelected(false);
            }
            String groupHeadUrl = this.keA.getGroupHeadUrl();
            if (!TextUtils.isEmpty(groupHeadUrl)) {
                this.ket.setTag(groupHeadUrl);
                this.ket.startLoad(groupHeadUrl, 10, false);
            } else {
                this.ket.setTag(null);
            }
            this.ket.setClickable(false);
            if (!TextUtils.isEmpty(this.keA.getTitle())) {
                this.eOj.setText(this.keA.getTitle());
            } else {
                this.eOj.setText(this.ker.getPageContext().getString(R.string.inform));
            }
            Date date = new Date();
            date.setTime(this.keA.getTime());
            this.kev.setText(at.l(date));
            if (!TextUtils.isEmpty(this.keA.getContent())) {
                this.jCt.setText(this.keA.getContent());
            } else {
                this.jCt.setText("");
            }
            if (!TextUtils.isEmpty(this.keA.getGroupName())) {
                this.keu.setText(this.keA.getGroupName());
            } else {
                this.keu.setText("");
            }
            int paddingLeft = this.kex.getPaddingLeft();
            int paddingTop = this.kex.getPaddingTop();
            int paddingRight = this.kex.getPaddingRight();
            int paddingBottom = this.kex.getPaddingBottom();
            this.ker.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.ker.getLayoutMode().onModeChanged(this.mConvertView);
            this.kew.setSelected(this.keA.isSelected());
            if (this.keA.isSelected() && this.ker.cuF()) {
                ap.setBackgroundResource(this.kex, R.drawable.bg_information_down_s);
            } else {
                ap.setBackgroundResource(this.kex, R.drawable.selector_group_updates_bottom_bg);
            }
            this.kex.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void b(UpdatesItemData updatesItemData) {
        c(updatesItemData);
        refresh();
    }

    public void c(UpdatesItemData updatesItemData) {
        this.keA = updatesItemData;
    }
}
