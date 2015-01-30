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
    private ChatClipImageItemView aVS;
    private LinearLayout aVT;
    private TextView aVU;
    private TbImageView awI;

    public ChatImageWithTailView(Context context) {
        super(context);
        aq(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aq(context);
    }

    public void aq(Context context) {
        b.ei().inflate(context, x.chat_image_with_tail_item, this);
        this.aVS = (ChatClipImageItemView) findViewById(w.img_msgitem_image_new);
        this.aVS.setDefaultResource(v.image_h_not);
        this.aVT = (LinearLayout) findViewById(w.small_tail);
        this.awI = (TbImageView) findViewById(w.tail_icon);
        this.awI.setDefaultResource(v.icon);
        this.awI.setAutoChangeStyle(false);
        this.aVU = (TextView) findViewById(w.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.aVS;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.aVS = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.aVT;
    }

    public void setTail(LinearLayout linearLayout) {
        this.aVT = linearLayout;
    }

    public TbImageView getIcon() {
        return this.awI;
    }

    public void setIcon(TbImageView tbImageView) {
        this.awI = tbImageView;
    }

    public TextView getFromSource() {
        return this.aVU;
    }

    public void setFromSource(TextView textView) {
        this.aVU = textView;
    }
}
