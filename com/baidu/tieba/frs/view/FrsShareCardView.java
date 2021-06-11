package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class FrsShareCardView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15939e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15940f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f15941g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15942h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15943i;
    public TextView j;
    public TextView k;
    public ShareFromFrsMsgData l;

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15940f = context;
        c(context);
    }

    public final String a(String str) {
        return k.cutString(str, 18) + this.f15940f.getString(R.string.forum);
    }

    public void b() {
        this.f15939e.setFocusable(true);
        this.f15939e.setFocusableInTouchMode(true);
        this.f15939e.requestFocus();
    }

    public final void c(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.f15939e = (LinearLayout) findViewById(R.id.share_content);
        this.f15943i = (TextView) findViewById(R.id.frs_card_name);
        this.f15941g = (EditText) findViewById(R.id.chat_msg);
        this.f15942h = (HeadImageView) findViewById(R.id.frs_card_img);
        this.k = (TextView) findViewById(R.id.frs_card_member_num);
        this.j = (TextView) findViewById(R.id.frs_card_post_num);
        SkinManager.setViewTextColor(this.f15943i, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f15941g, R.color.CAM_X0105, 2);
        this.f15941g.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f15941g.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        b();
    }

    public void d(String str, boolean z) {
        HeadImageView headImageView = this.f15942h;
        if (headImageView != null) {
            headImageView.U(str, 15, false);
        }
    }

    public final void e() {
        this.f15943i.setText(a(this.l.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.l.getImageUrl());
        this.f15942h.U(this.l.getImageUrl(), 15, false);
        this.k.setText(StringHelper.numFormatOver10000((long) this.l.getMemberNum()));
        this.j.setText(StringHelper.numFormatOver10000((long) this.l.getPostNum()));
    }

    public EditText getChatMsgView() {
        return this.f15941g;
    }

    public String getLeaveMsg() {
        EditText editText = this.f15941g;
        if (editText != null) {
            return k.charSequence2String(editText.getText(), null);
        }
        return null;
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.l = shareFromFrsMsgData;
        e();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.f15942h.setPageId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.f15940f = context;
        c(context);
    }
}
