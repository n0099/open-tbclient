package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import d.b.c.e.p.k;
/* loaded from: classes4.dex */
public class ShareCardView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f17350e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f17351f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17352g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17353h;
    public TextView i;
    public ShareFromTopicMsgData j;

    public ShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public void a() {
        this.f17350e.setFocusable(true);
        this.f17350e.setFocusableInTouchMode(true);
        this.f17350e.requestFocus();
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.f17350e = (LinearLayout) findViewById(R.id.share_content);
        this.i = (TextView) findViewById(R.id.share_title_view);
        this.f17351f = (EditText) findViewById(R.id.chat_msg);
        this.f17352g = (TbImageView) findViewById(R.id.chat_group_img);
        this.f17353h = (TextView) findViewById(R.id.chat_group_desc);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f17351f, R.color.CAM_X0105, 2);
        SkinManager.setViewTextColor(this.f17353h, R.color.CAM_X0106, 1);
        this.f17351f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f17351f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        a();
    }

    public void c(String str, boolean z) {
        TbImageView tbImageView = this.f17352g;
        if (tbImageView != null) {
            tbImageView.W(str, z ? 17 : 18, false);
        }
    }

    public final void d() {
        this.i.setText(this.j.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.j.getImageUrl());
        this.f17352g.setTag(this.j.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.j.getContent());
        this.f17353h.setText(this.j.getContent());
    }

    public EditText getChatMsgView() {
        return this.f17351f;
    }

    public String getLeaveMsg() {
        EditText editText = this.f17351f;
        if (editText != null) {
            return k.charSequence2String(editText.getText(), null);
        }
        return null;
    }

    public void setData(ShareFromTopicMsgData shareFromTopicMsgData) {
        this.j = shareFromTopicMsgData;
        d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public ShareCardView(Context context) {
        super(context);
        b(context);
    }
}
