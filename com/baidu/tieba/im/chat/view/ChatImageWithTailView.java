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
    public ChatClipImageItemView f17286e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17287f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17288g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17289h;

    public ChatImageWithTailView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_image_with_tail_item, this);
        ChatClipImageItemView chatClipImageItemView = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.f17286e = chatClipImageItemView;
        chatClipImageItemView.setContentDescription(getContext().getString(R.string.editor_image));
        this.f17286e.setDefaultResource(R.drawable.pic_image_h_not);
        this.f17287f = (LinearLayout) findViewById(R.id.small_tail);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.tail_icon);
        this.f17288g = tbImageView;
        tbImageView.setDefaultResource(R.drawable.tb_launcher_icon);
        this.f17288g.setAutoChangeStyle(false);
        this.f17289h = (TextView) findViewById(R.id.tail_game_from);
    }

    public TextView getFromSource() {
        return this.f17289h;
    }

    public TbImageView getIcon() {
        return this.f17288g;
    }

    public ChatClipImageItemView getImage() {
        return this.f17286e;
    }

    public LinearLayout getTail() {
        return this.f17287f;
    }

    public void setFromSource(TextView textView) {
        this.f17289h = textView;
    }

    public void setIcon(TbImageView tbImageView) {
        this.f17288g = tbImageView;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.f17286e = chatClipImageItemView;
    }

    public void setIsSupportNight(boolean z) {
        this.f17288g.setAutoChangeStyle(z);
    }

    public void setTail(LinearLayout linearLayout) {
        this.f17287f = linearLayout;
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
