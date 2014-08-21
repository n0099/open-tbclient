package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private ChatClipImageItemView a;
    private LinearLayout b;
    private TbImageView c;
    private TextView d;

    public ChatImageWithTailView(Context context) {
        super(context);
        a(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(Context context) {
        b.a().a(context, v.chat_image_with_tail_item, this);
        this.a = (ChatClipImageItemView) findViewById(u.img_msgitem_image_new);
        this.a.setDefaultResource(t.image_h_not);
        this.b = (LinearLayout) findViewById(u.small_tail);
        this.c = (TbImageView) findViewById(u.tail_icon);
        this.c.setDefaultResource(t.icon);
        this.c.setAutoChangeStyle(false);
        this.d = (TextView) findViewById(u.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.a;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.a = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.b;
    }

    public void setTail(LinearLayout linearLayout) {
        this.b = linearLayout;
    }

    public TbImageView getIcon() {
        return this.c;
    }

    public void setIcon(TbImageView tbImageView) {
        this.c = tbImageView;
    }

    public TextView getFromSource() {
        return this.d;
    }

    public void setFromSource(TextView textView) {
        this.d = textView;
    }
}
