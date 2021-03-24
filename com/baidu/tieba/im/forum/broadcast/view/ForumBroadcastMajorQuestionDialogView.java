package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f17935e;

    /* renamed from: f  reason: collision with root package name */
    public Context f17936f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17937g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17938h;
    public TextView i;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.f17936f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.f17935e = linearLayout;
        this.f17937g = (TextView) linearLayout.findViewById(R.id.forum_broadcast_question_title);
        this.f17938h = (TextView) this.f17935e.findViewById(R.id.forum_broadcast_question_content);
        this.i = (TextView) this.f17935e.findViewById(R.id.known_icon);
        this.f17937g.setText(R.string.subscribe_bar_title);
        this.f17938h.setText(R.string.forum_broadcast_major_history_hint);
        this.i.setText(R.string.know);
        SkinManager.setBackgroundResource(this.f17935e, R.drawable.bg_frs_private_dialog);
        SkinManager.setViewTextColor(this.f17937g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f17938h, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0302);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.i.setOnClickListener(onClickListener);
        }
    }
}
