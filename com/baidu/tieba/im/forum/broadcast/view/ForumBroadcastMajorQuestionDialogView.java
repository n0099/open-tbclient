package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bMg;
    private TextView iGY;
    private TextView kFQ;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.kFQ.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bMg = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.iGY = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.kFQ = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bMg.setText(R.string.subscribe_bar_title);
        this.iGY.setText(R.string.forum_broadcast_major_history_hint);
        this.kFQ.setText(R.string.know);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setViewTextColor(this.bMg, R.color.CAM_X0105);
        ap.setViewTextColor(this.iGY, R.color.CAM_X0107);
        ap.setViewTextColor(this.kFQ, R.color.CAM_X0302);
    }
}
