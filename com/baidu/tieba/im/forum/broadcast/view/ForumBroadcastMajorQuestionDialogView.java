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
    public LinearLayout f17325e;

    /* renamed from: f  reason: collision with root package name */
    public Context f17326f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17327g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17328h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17329i;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.f17326f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.f17325e = linearLayout;
        this.f17327g = (TextView) linearLayout.findViewById(R.id.forum_broadcast_question_title);
        this.f17328h = (TextView) this.f17325e.findViewById(R.id.forum_broadcast_question_content);
        this.f17329i = (TextView) this.f17325e.findViewById(R.id.known_icon);
        this.f17327g.setText(R.string.subscribe_bar_title);
        this.f17328h.setText(R.string.forum_broadcast_major_history_hint);
        this.f17329i.setText(R.string.know);
        SkinManager.setBackgroundResource(this.f17325e, R.drawable.bg_frs_private_dialog);
        SkinManager.setViewTextColor(this.f17327g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f17328h, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17329i, R.color.CAM_X0302);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f17329i.setOnClickListener(onClickListener);
        }
    }
}
