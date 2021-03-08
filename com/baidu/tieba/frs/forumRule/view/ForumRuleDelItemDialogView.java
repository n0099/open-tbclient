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
    private TextView bNG;
    private TextView iIV;
    private TextView jxD;
    private TextView jxE;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jxD.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jxE.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.ll_main);
        this.bNG = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.iIV = (TextView) this.mRootView.findViewById(R.id.dialog_content);
        this.jxD = (TextView) this.mRootView.findViewById(R.id.next_time);
        this.jxE = (TextView) this.mRootView.findViewById(R.id.del_tv);
        this.bNG.setText(R.string.forum_rule_item_del_dialog_title);
        this.iIV.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.jxD.setText(R.string.next_time);
        this.jxE.setText(R.string.del_post);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.elementsMaven.c.br(this.bNG).nZ(R.color.CAM_X0105).ob(R.string.F_X02).oa(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iIV).nZ(R.color.CAM_X0107).oa(R.dimen.T_X07);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jxD).nZ(R.color.CAM_X0105).oh(R.string.J_X07).ol(R.dimen.L_X02).oa(R.dimen.T_X08).ok(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jxE).nZ(R.color.CAM_X0302).oh(R.string.J_X07).oa(R.dimen.T_X08).ol(R.dimen.L_X02).om(R.string.A_X07).ok(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }
}
