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
    private TbImageView aEZ;
    private ChatClipImageItemView bao;
    private LinearLayout bap;
    private TextView baq;

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
        this.bao = (ChatClipImageItemView) findViewById(v.img_msgitem_image_new);
        this.bao.setDefaultResource(u.pic_image_h_not);
        this.bap = (LinearLayout) findViewById(v.small_tail);
        this.aEZ = (TbImageView) findViewById(v.tail_icon);
        this.aEZ.setDefaultResource(u.icon);
        this.aEZ.setAutoChangeStyle(false);
        this.baq = (TextView) findViewById(v.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bao;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bao = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bap;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bap = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aEZ;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aEZ = tbImageView;
    }

    public TextView getFromSource() {
        return this.baq;
    }

    public void setFromSource(TextView textView) {
        this.baq = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aEZ.setAutoChangeStyle(z);
    }
}
