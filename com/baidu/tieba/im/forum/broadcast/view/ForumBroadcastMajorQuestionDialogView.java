package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bpA;
    private TextView htB;
    private TextView jns;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jns.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bpA = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.htB = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.jns = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bpA.setText(R.string.subscribe_bar_title);
        this.htB.setText(R.string.forum_broadcast_major_history_hint);
        this.jns.setText(R.string.know);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setViewTextColor(this.bpA, R.color.cp_cont_b);
        ap.setViewTextColor(this.htB, R.color.cp_cont_j);
        ap.setViewTextColor(this.jns, R.color.cp_link_tip_a);
    }
}
