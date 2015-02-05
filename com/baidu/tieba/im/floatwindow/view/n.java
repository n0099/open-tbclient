package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class n {
    private TextView aHe;
    private TextView aTI;
    private TextView aZW;
    private TextView abj;
    private int status;

    public n(View view) {
        this.abj = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_name);
        this.aZW = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_distance);
        this.aTI = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_time);
        this.aHe = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_add_friend);
    }

    public void gD(String str) {
        this.abj.setText(str);
    }

    public void fP(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aHe.setClickable(true);
                this.aHe.setVisibility(0);
                this.aHe.setText(com.baidu.tieba.z.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aHe.setVisibility(8);
                return;
            case 2:
                this.aHe.setVisibility(0);
                this.aHe.setText(com.baidu.tieba.z.waiting);
                this.aHe.setClickable(false);
                this.aHe.setBackgroundResource(com.baidu.tieba.t.transparent);
                this.aHe.setText(com.baidu.tieba.z.waiting);
                this.aHe.setTextColor(TbadkCoreApplication.m255getInst().getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                return;
            case 4:
                this.aHe.setClickable(true);
                this.aHe.setVisibility(0);
                this.aHe.setText(com.baidu.tieba.z.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.aHe.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.f fVar) {
        this.abj.setText(str);
        if (fVar != null) {
            if (fVar.ti() < 0 || fVar.ti() > 1) {
                this.aZW.setVisibility(8);
                this.aTI.setVisibility(8);
                return;
            }
            this.aZW.setVisibility(0);
            this.aTI.setVisibility(0);
            this.aZW.setText(TbadkCoreApplication.m255getInst().getResources().getString(com.baidu.tieba.z.contact_yinshen));
            if (!StringUtils.isNull(fVar.getDistance()) && fVar.getTime() > 0) {
                this.aZW.setVisibility(0);
                this.aZW.setText(fVar.getDistance());
                this.aTI.setText(bf.m(fVar.getTime()));
                return;
            }
            this.aZW.setVisibility(8);
        }
    }
}
