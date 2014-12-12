package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class n {
    private TextView aFX;
    private TextView aSz;
    private TextView aYB;
    private TextView aaL;
    private int status;

    public n(View view) {
        this.aaL = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_name);
        this.aYB = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_distance);
        this.aSz = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_time);
        this.aFX = (TextView) view.findViewById(com.baidu.tieba.w.floating_chat_add_friend);
    }

    public void gB(String str) {
        this.aaL.setText(str);
    }

    public void fK(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aFX.setClickable(true);
                this.aFX.setVisibility(0);
                this.aFX.setText(com.baidu.tieba.z.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aFX.setVisibility(8);
                return;
            case 2:
                this.aFX.setVisibility(0);
                this.aFX.setText(com.baidu.tieba.z.waiting);
                this.aFX.setClickable(false);
                this.aFX.setBackgroundResource(com.baidu.tieba.t.transparent);
                this.aFX.setText(com.baidu.tieba.z.waiting);
                this.aFX.setTextColor(TbadkCoreApplication.m255getInst().getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                return;
            case 4:
                this.aFX.setClickable(true);
                this.aFX.setVisibility(0);
                this.aFX.setText(com.baidu.tieba.z.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void v(View.OnClickListener onClickListener) {
        this.aFX.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.f fVar) {
        this.aaL.setText(str);
        if (fVar != null) {
            if (fVar.sX() < 0 || fVar.sX() > 1) {
                this.aYB.setVisibility(8);
                this.aSz.setVisibility(8);
                return;
            }
            this.aYB.setVisibility(0);
            this.aSz.setVisibility(0);
            this.aYB.setText(TbadkCoreApplication.m255getInst().getResources().getString(com.baidu.tieba.z.contact_yinshen));
            if (!StringUtils.isNull(fVar.getDistance()) && fVar.getTime() > 0) {
                this.aYB.setVisibility(0);
                this.aYB.setText(fVar.getDistance());
                this.aSz.setText(ba.m(fVar.getTime()));
                return;
            }
            this.aYB.setVisibility(8);
        }
    }
}
