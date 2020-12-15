package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bIt;
    private TextView itI;
    private TextView krA;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.krA.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bIt = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.itI = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.krA = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bIt.setText(R.string.subscribe_bar_title);
        this.itI.setText(R.string.forum_broadcast_major_history_hint);
        this.krA.setText(R.string.know);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setViewTextColor(this.bIt, R.color.CAM_X0105);
        ap.setViewTextColor(this.itI, R.color.CAM_X0107);
        ap.setViewTextColor(this.krA, R.color.CAM_X0302);
    }
}
