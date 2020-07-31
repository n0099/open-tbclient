package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bjS;
    private TextView hgC;
    private TextView iYk;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iYk.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bjS = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.hgC = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.iYk = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bjS.setText(R.string.subscribe_bar_title);
        this.hgC.setText(R.string.forum_broadcast_major_history_hint);
        this.iYk.setText(R.string.know);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ao.setViewTextColor(this.bjS, R.color.cp_cont_b);
        ao.setViewTextColor(this.hgC, R.color.cp_cont_j);
        ao.setViewTextColor(this.iYk, R.color.cp_link_tip_a);
    }
}
