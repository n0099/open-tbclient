package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private LinearLayout aUA;
    private TextView aUB;
    private ChatClipImageItemView aUz;
    private TbImageView avI;

    public ChatImageWithTailView(Context context) {
        super(context);
        aq(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aq(context);
    }

    public void aq(Context context) {
        b.ek().inflate(context, x.chat_image_with_tail_item, this);
        this.aUz = (ChatClipImageItemView) findViewById(w.img_msgitem_image_new);
        this.aUz.setDefaultResource(v.image_h_not);
        this.aUA = (LinearLayout) findViewById(w.small_tail);
        this.avI = (TbImageView) findViewById(w.tail_icon);
        this.avI.setDefaultResource(v.icon);
        this.avI.setAutoChangeStyle(false);
        this.aUB = (TextView) findViewById(w.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.aUz;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.aUz = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.aUA;
    }

    public void setTail(LinearLayout linearLayout) {
        this.aUA = linearLayout;
    }

    public TbImageView getIcon() {
        return this.avI;
    }

    public void setIcon(TbImageView tbImageView) {
        this.avI = tbImageView;
    }

    public TextView getFromSource() {
        return this.aUB;
    }

    public void setFromSource(TextView textView) {
        this.aUB = textView;
    }
}
