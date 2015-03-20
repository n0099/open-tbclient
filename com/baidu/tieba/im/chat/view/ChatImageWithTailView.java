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
    private TbImageView aER;
    private ChatClipImageItemView aZY;
    private LinearLayout aZZ;
    private TextView baa;

    public ChatImageWithTailView(Context context) {
        super(context);
        au(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        au(context);
    }

    public void au(Context context) {
        b.hH().inflate(context, w.chat_image_with_tail_item, this);
        this.aZY = (ChatClipImageItemView) findViewById(v.img_msgitem_image_new);
        this.aZY.setDefaultResource(u.pic_image_h_not);
        this.aZZ = (LinearLayout) findViewById(v.small_tail);
        this.aER = (TbImageView) findViewById(v.tail_icon);
        this.aER.setDefaultResource(u.icon);
        this.aER.setAutoChangeStyle(false);
        this.baa = (TextView) findViewById(v.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.aZY;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.aZY = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.aZZ;
    }

    public void setTail(LinearLayout linearLayout) {
        this.aZZ = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aER;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aER = tbImageView;
    }

    public TextView getFromSource() {
        return this.baa;
    }

    public void setFromSource(TextView textView) {
        this.baa = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aER.setAutoChangeStyle(z);
    }
}
