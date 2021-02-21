package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ForumRuleDelItemDialogView extends LinearLayout {
    private TextView bMg;
    private TextView iHm;
    private TextView jvU;
    private TextView jvV;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jvU.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jvV.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.ll_main);
        this.bMg = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.iHm = (TextView) this.mRootView.findViewById(R.id.dialog_content);
        this.jvU = (TextView) this.mRootView.findViewById(R.id.next_time);
        this.jvV = (TextView) this.mRootView.findViewById(R.id.del_tv);
        this.bMg.setText(R.string.forum_rule_item_del_dialog_title);
        this.iHm.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.jvU.setText(R.string.next_time);
        this.jvV.setText(R.string.del_post);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.elementsMaven.c.br(this.bMg).nY(R.color.CAM_X0105).oa(R.string.F_X02).nZ(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iHm).nY(R.color.CAM_X0107).nZ(R.dimen.T_X07);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvU).nY(R.color.CAM_X0105).og(R.string.J_X07).ok(R.dimen.L_X02).nZ(R.dimen.T_X08).oj(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvV).nY(R.color.CAM_X0302).og(R.string.J_X07).nZ(R.dimen.T_X08).ok(R.dimen.L_X02).ol(R.string.A_X07).oj(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }
}
