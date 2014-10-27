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
    private ChatClipImageItemView aSJ;
    private LinearLayout aSK;
    private TextView aSL;
    private TbImageView anF;

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
        this.aSJ = (ChatClipImageItemView) findViewById(v.img_msgitem_image_new);
        this.aSJ.setDefaultResource(u.image_h_not);
        this.aSK = (LinearLayout) findViewById(v.small_tail);
        this.anF = (TbImageView) findViewById(v.tail_icon);
        this.anF.setDefaultResource(u.icon);
        this.anF.setAutoChangeStyle(false);
        this.aSL = (TextView) findViewById(v.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.aSJ;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.aSJ = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.aSK;
    }

    public void setTail(LinearLayout linearLayout) {
        this.aSK = linearLayout;
    }

    public TbImageView getIcon() {
        return this.anF;
    }

    public void setIcon(TbImageView tbImageView) {
        this.anF = tbImageView;
    }

    public TextView getFromSource() {
        return this.aSL;
    }

    public void setFromSource(TextView textView) {
        this.aSL = textView;
    }
}
