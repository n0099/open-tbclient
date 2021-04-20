package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChatImageWithTailView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ChatClipImageItemView f17576e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17577f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17578g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17579h;

    public ChatImageWithTailView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_image_with_tail_item, this);
        ChatClipImageItemView chatClipImageItemView = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.f17576e = chatClipImageItemView;
        chatClipImageItemView.setContentDescription(getContext().getString(R.string.editor_image));
        this.f17576e.setDefaultResource(R.drawable.pic_image_h_not);
        this.f17577f = (LinearLayout) findViewById(R.id.small_tail);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.tail_icon);
        this.f17578g = tbImageView;
        tbImageView.setDefaultResource(R.drawable.tb_launcher_icon);
        this.f17578g.setAutoChangeStyle(false);
        this.f17579h = (TextView) findViewById(R.id.tail_game_from);
    }

    public TextView getFromSource() {
        return this.f17579h;
    }

    public TbImageView getIcon() {
        return this.f17578g;
    }

    public ChatClipImageItemView getImage() {
        return this.f17576e;
    }

    public LinearLayout getTail() {
        return this.f17577f;
    }

    public void setFromSource(TextView textView) {
        this.f17579h = textView;
    }

    public void setIcon(TbImageView tbImageView) {
        this.f17578g = tbImageView;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.f17576e = chatClipImageItemView;
    }

    public void setIsSupportNight(boolean z) {
        this.f17578g.setAutoChangeStyle(z);
    }

    public void setTail(LinearLayout linearLayout) {
        this.f17577f = linearLayout;
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
