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
    private TextView iGY;
    private TextView jvG;
    private TextView jvH;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jvG.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jvH.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.ll_main);
        this.bMg = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.iGY = (TextView) this.mRootView.findViewById(R.id.dialog_content);
        this.jvG = (TextView) this.mRootView.findViewById(R.id.next_time);
        this.jvH = (TextView) this.mRootView.findViewById(R.id.del_tv);
        this.bMg.setText(R.string.forum_rule_item_del_dialog_title);
        this.iGY.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.jvG.setText(R.string.next_time);
        this.jvH.setText(R.string.del_post);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.elementsMaven.c.br(this.bMg).nY(R.color.CAM_X0105).oa(R.string.F_X02).nZ(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iGY).nY(R.color.CAM_X0107).nZ(R.dimen.T_X07);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvG).nY(R.color.CAM_X0105).og(R.string.J_X07).ok(R.dimen.L_X02).nZ(R.dimen.T_X08).oj(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvH).nY(R.color.CAM_X0302).og(R.string.J_X07).nZ(R.dimen.T_X08).ok(R.dimen.L_X02).ol(R.string.A_X07).oj(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }
}
