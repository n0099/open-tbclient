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
    public LinearLayout f17243e;

    /* renamed from: f  reason: collision with root package name */
    public Context f17244f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17245g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17246h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17247i;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.f17244f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.f17243e = linearLayout;
        this.f17245g = (TextView) linearLayout.findViewById(R.id.forum_broadcast_question_title);
        this.f17246h = (TextView) this.f17243e.findViewById(R.id.forum_broadcast_question_content);
        this.f17247i = (TextView) this.f17243e.findViewById(R.id.known_icon);
        this.f17245g.setText(R.string.subscribe_bar_title);
        this.f17246h.setText(R.string.forum_broadcast_major_history_hint);
        this.f17247i.setText(R.string.know);
        SkinManager.setBackgroundResource(this.f17243e, R.drawable.bg_frs_private_dialog);
        SkinManager.setViewTextColor(this.f17245g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f17246h, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17247i, R.color.CAM_X0302);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f17247i.setOnClickListener(onClickListener);
        }
    }
}
