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
    private ChatClipImageItemView aVR;
    private LinearLayout aVS;
    private TextView aVT;
    private TbImageView awF;

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
        this.aVR = (ChatClipImageItemView) findViewById(w.img_msgitem_image_new);
        this.aVR.setDefaultResource(v.image_h_not);
        this.aVS = (LinearLayout) findViewById(w.small_tail);
        this.awF = (TbImageView) findViewById(w.tail_icon);
        this.awF.setDefaultResource(v.icon);
        this.awF.setAutoChangeStyle(false);
        this.aVT = (TextView) findViewById(w.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.aVR;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.aVR = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.aVS;
    }

    public void setTail(LinearLayout linearLayout) {
        this.aVS = linearLayout;
    }

    public TbImageView getIcon() {
        return this.awF;
    }

    public void setIcon(TbImageView tbImageView) {
        this.awF = tbImageView;
    }

    public TextView getFromSource() {
        return this.aVT;
    }

    public void setFromSource(TextView textView) {
        this.aVT = textView;
    }
}
