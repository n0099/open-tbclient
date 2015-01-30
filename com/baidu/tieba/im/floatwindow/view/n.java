package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class n {
    private TextView aHh;
    private TextView aTJ;
    private TextView aZX;
    private TextView abm;
    private int status;

    public n(View view) {
        this.abm = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_name);
        this.aZX = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_distance);
        this.aTJ = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_time);
        this.aHh = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_add_friend);
    }

    public void gG(String str) {
        this.abm.setText(str);
    }

    public void fP(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aHh.setClickable(true);
                this.aHh.setVisibility(0);
                this.aHh.setText(com.baidu.tieba.z.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aHh.setVisibility(8);
                return;
            case 2:
                this.aHh.setVisibility(0);
                this.aHh.setText(com.baidu.tieba.z.waiting);
                this.aHh.setClickable(false);
                this.aHh.setBackgroundResource(com.baidu.tieba.t.transparent);
                this.aHh.setText(com.baidu.tieba.z.waiting);
                this.aHh.setTextColor(TbadkCoreApplication.m255getInst().getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                return;
            case 4:
                this.aHh.setClickable(true);
                this.aHh.setVisibility(0);
                this.aHh.setText(com.baidu.tieba.z.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.aHh.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.f fVar) {
        this.abm.setText(str);
        if (fVar != null) {
            if (fVar.to() < 0 || fVar.to() > 1) {
                this.aZX.setVisibility(8);
                this.aTJ.setVisibility(8);
                return;
            }
            this.aZX.setVisibility(0);
            this.aTJ.setVisibility(0);
            this.aZX.setText(TbadkCoreApplication.m255getInst().getResources().getString(com.baidu.tieba.z.contact_yinshen));
            if (!StringUtils.isNull(fVar.getDistance()) && fVar.getTime() > 0) {
                this.aZX.setVisibility(0);
                this.aZX.setText(fVar.getDistance());
                this.aTJ.setText(bf.m(fVar.getTime()));
                return;
            }
            this.aZX.setVisibility(8);
        }
    }
}
