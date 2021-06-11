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
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class ShareCardView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16962e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f16963f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16964g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16965h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16966i;
    public ShareFromTopicMsgData j;

    public ShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public void a() {
        this.f16962e.setFocusable(true);
        this.f16962e.setFocusableInTouchMode(true);
        this.f16962e.requestFocus();
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.f16962e = (LinearLayout) findViewById(R.id.share_content);
        this.f16966i = (TextView) findViewById(R.id.share_title_view);
        this.f16963f = (EditText) findViewById(R.id.chat_msg);
        this.f16964g = (TbImageView) findViewById(R.id.chat_group_img);
        this.f16965h = (TextView) findViewById(R.id.chat_group_desc);
        SkinManager.setViewTextColor(this.f16966i, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f16963f, R.color.CAM_X0105, 2);
        SkinManager.setViewTextColor(this.f16965h, R.color.CAM_X0106, 1);
        this.f16963f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f16963f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        a();
    }

    public void c(String str, boolean z) {
        TbImageView tbImageView = this.f16964g;
        if (tbImageView != null) {
            tbImageView.U(str, z ? 17 : 18, false);
        }
    }

    public final void d() {
        this.f16966i.setText(this.j.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.j.getImageUrl());
        this.f16964g.setTag(this.j.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.j.getContent());
        this.f16965h.setText(this.j.getContent());
    }

    public EditText getChatMsgView() {
        return this.f16963f;
    }

    public String getLeaveMsg() {
        EditText editText = this.f16963f;
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
