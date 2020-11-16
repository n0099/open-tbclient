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
    private TextView bDl;
    private TextView iiN;
    private TextView kdX;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.kdX.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bDl = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.iiN = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.kdX = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bDl.setText(R.string.subscribe_bar_title);
        this.iiN.setText(R.string.forum_broadcast_major_history_hint);
        this.kdX.setText(R.string.know);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setViewTextColor(this.bDl, R.color.CAM_X0105);
        ap.setViewTextColor(this.iiN, R.color.CAM_X0107);
        ap.setViewTextColor(this.kdX, R.color.CAM_X0302);
    }
}
