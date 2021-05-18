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
    public LinearLayout f17257e;

    /* renamed from: f  reason: collision with root package name */
    public Context f17258f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17259g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17260h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17261i;

    public ForumBroadcastMajorQuestionDialogView(Context context) {
        super(context);
        this.f17258f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.forum_broadcast_question);
        this.f17257e = linearLayout;
        this.f17259g = (TextView) linearLayout.findViewById(R.id.forum_broadcast_question_title);
        this.f17260h = (TextView) this.f17257e.findViewById(R.id.forum_broadcast_question_content);
        this.f17261i = (TextView) this.f17257e.findViewById(R.id.known_icon);
        this.f17259g.setText(R.string.subscribe_bar_title);
        this.f17260h.setText(R.string.forum_broadcast_major_history_hint);
        this.f17261i.setText(R.string.know);
        SkinManager.setBackgroundResource(this.f17257e, R.drawable.bg_frs_private_dialog);
        SkinManager.setViewTextColor(this.f17259g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f17260h, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17261i, R.color.CAM_X0302);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f17261i.setOnClickListener(onClickListener);
        }
    }
}
