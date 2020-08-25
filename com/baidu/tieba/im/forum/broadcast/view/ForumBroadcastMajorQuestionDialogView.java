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
    private TextView bpx;
    private TextView htv;
    private TextView jnm;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jnm.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bpx = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.htv = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.jnm = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bpx.setText(R.string.subscribe_bar_title);
        this.htv.setText(R.string.forum_broadcast_major_history_hint);
        this.jnm.setText(R.string.know);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setViewTextColor(this.bpx, R.color.cp_cont_b);
        ap.setViewTextColor(this.htv, R.color.cp_cont_j);
        ap.setViewTextColor(this.jnm, R.color.cp_link_tip_a);
    }
}
