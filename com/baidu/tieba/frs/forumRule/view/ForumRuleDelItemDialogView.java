package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ForumRuleDelItemDialogView extends LinearLayout {
    private TextView bIt;
    private TextView itI;
    private TextView jih;
    private TextView jii;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jih.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jii.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.ll_main);
        this.bIt = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.itI = (TextView) this.mRootView.findViewById(R.id.dialog_content);
        this.jih = (TextView) this.mRootView.findViewById(R.id.next_time);
        this.jii = (TextView) this.mRootView.findViewById(R.id.del_tv);
        this.bIt.setText(R.string.forum_rule_item_del_dialog_title);
        this.itI.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.jih.setText(R.string.next_time);
        this.jii.setText(R.string.del_post);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.bIt).ps(R.color.CAM_X0105).pu(R.string.F_X02).pt(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.itI).ps(R.color.CAM_X0107).pt(R.dimen.T_X07);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jih).ps(R.color.CAM_X0105).pA(R.string.J_X07).pD(R.dimen.L_X02).pt(R.dimen.T_X08).pC(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jii).ps(R.color.CAM_X0302).pA(R.string.J_X07).pt(R.dimen.T_X08).pD(R.dimen.L_X02).pE(R.string.A_X07).pC(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }
}
