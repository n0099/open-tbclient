package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bNG;
    private TextView iIV;
    private TextView kIg;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.kIg.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bNG = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.iIV = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.kIg = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bNG.setText(R.string.subscribe_bar_title);
        this.iIV.setText(R.string.forum_broadcast_major_history_hint);
        this.kIg.setText(R.string.know);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setViewTextColor(this.bNG, R.color.CAM_X0105);
        ap.setViewTextColor(this.iIV, R.color.CAM_X0107);
        ap.setViewTextColor(this.kIg, R.color.CAM_X0302);
    }
}
