package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    private TextView bIw;
    private TextView iBo;
    private TextView kxK;
    private Context mContext;
    private LinearLayout mRootView;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.kxK.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.bIw = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_title);
        this.iBo = (TextView) this.mRootView.findViewById(R.id.forum_broadcast_question_content);
        this.kxK = (TextView) this.mRootView.findViewById(R.id.known_icon);
        this.bIw.setText(R.string.subscribe_bar_title);
        this.iBo.setText(R.string.forum_broadcast_major_history_hint);
        this.kxK.setText(R.string.know);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ao.setViewTextColor(this.bIw, R.color.CAM_X0105);
        ao.setViewTextColor(this.iBo, R.color.CAM_X0107);
        ao.setViewTextColor(this.kxK, R.color.CAM_X0302);
    }
}
