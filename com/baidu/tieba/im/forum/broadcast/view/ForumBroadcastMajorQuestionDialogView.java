package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bsJ;
    private TextView hAG;
    private TextView jvV;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jvV.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bsJ = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.hAG = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.jvV = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bsJ.setText(R.string.subscribe_bar_title);
        this.hAG.setText(R.string.forum_broadcast_major_history_hint);
        this.jvV.setText(R.string.know);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setViewTextColor(this.bsJ, R.color.cp_cont_b);
        ap.setViewTextColor(this.hAG, R.color.cp_cont_j);
        ap.setViewTextColor(this.jvV, R.color.cp_link_tip_a);
    }
}
