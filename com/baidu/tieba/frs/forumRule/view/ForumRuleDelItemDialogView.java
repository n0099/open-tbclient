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
    private TextView bIw;
    private TextView iBo;
    private TextView jqa;
    private TextView jqb;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jqa.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jqb.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.ll_main);
        this.bIw = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.iBo = (TextView) this.mRootView.findViewById(R.id.dialog_content);
        this.jqa = (TextView) this.mRootView.findViewById(R.id.next_time);
        this.jqb = (TextView) this.mRootView.findViewById(R.id.del_tv);
        this.bIw.setText(R.string.forum_rule_item_del_dialog_title);
        this.iBo.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.jqa.setText(R.string.next_time);
        this.jqb.setText(R.string.del_post);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.bIw).nV(R.color.CAM_X0105).nX(R.string.F_X02).nW(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iBo).nV(R.color.CAM_X0107).nW(R.dimen.T_X07);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jqa).nV(R.color.CAM_X0105).od(R.string.J_X07).og(R.dimen.L_X02).nW(R.dimen.T_X08).of(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jqb).nV(R.color.CAM_X0302).od(R.string.J_X07).nW(R.dimen.T_X08).og(R.dimen.L_X02).oh(R.string.A_X07).of(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }
}
