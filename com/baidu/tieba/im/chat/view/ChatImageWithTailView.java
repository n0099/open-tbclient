package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private ChatClipImageItemView aSX;
    private LinearLayout aSY;
    private TextView aSZ;
    private TbImageView anO;

    public ChatImageWithTailView(Context context) {
        super(context);
        ad(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ad(context);
    }

    public void ad(Context context) {
        b.ek().inflate(context, w.chat_image_with_tail_item, this);
        this.aSX = (ChatClipImageItemView) findViewById(v.img_msgitem_image_new);
        this.aSX.setDefaultResource(u.image_h_not);
        this.aSY = (LinearLayout) findViewById(v.small_tail);
        this.anO = (TbImageView) findViewById(v.tail_icon);
        this.anO.setDefaultResource(u.icon);
        this.anO.setAutoChangeStyle(false);
        this.aSZ = (TextView) findViewById(v.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.aSX;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.aSX = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.aSY;
    }

    public void setTail(LinearLayout linearLayout) {
        this.aSY = linearLayout;
    }

    public TbImageView getIcon() {
        return this.anO;
    }

    public void setIcon(TbImageView tbImageView) {
        this.anO = tbImageView;
    }

    public TextView getFromSource() {
        return this.aSZ;
    }

    public void setFromSource(TextView textView) {
        this.aSZ = textView;
    }
}
