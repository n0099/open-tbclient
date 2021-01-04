package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ForumRuleDelItemDialogView extends LinearLayout {
    private TextView bNi;
    private TextView iFV;
    private TextView juG;
    private TextView juH;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.juG.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.juH.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.ll_main);
        this.bNi = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.iFV = (TextView) this.mRootView.findViewById(R.id.dialog_content);
        this.juG = (TextView) this.mRootView.findViewById(R.id.next_time);
        this.juH = (TextView) this.mRootView.findViewById(R.id.del_tv);
        this.bNi.setText(R.string.forum_rule_item_del_dialog_title);
        this.iFV.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.juG.setText(R.string.next_time);
        this.juH.setText(R.string.del_post);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.bNi).pC(R.color.CAM_X0105).pE(R.string.F_X02).pD(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iFV).pC(R.color.CAM_X0107).pD(R.dimen.T_X07);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.juG).pC(R.color.CAM_X0105).pK(R.string.J_X07).pN(R.dimen.L_X02).pD(R.dimen.T_X08).pM(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.juH).pC(R.color.CAM_X0302).pK(R.string.J_X07).pD(R.dimen.T_X08).pN(R.dimen.L_X02).pO(R.string.A_X07).pM(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }
}
