package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bNi;
    private TextView iFV;
    private TextView kCp;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.kCp.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bNi = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.iFV = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.kCp = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bNi.setText(R.string.subscribe_bar_title);
        this.iFV.setText(R.string.forum_broadcast_major_history_hint);
        this.kCp.setText(R.string.know);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ao.setViewTextColor(this.bNi, R.color.CAM_X0105);
        ao.setViewTextColor(this.iFV, R.color.CAM_X0107);
        ao.setViewTextColor(this.kCp, R.color.CAM_X0302);
    }
}
