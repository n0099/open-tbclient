package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView esT;
    private ChatClipImageItemView jkb;
    private LinearLayout jkc;
    private TextView jkd;

    public ChatImageWithTailView(Context context) {
        super(context);
        initUI(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_image_with_tail_item, this);
        this.jkb = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.jkb.setContentDescription(getContext().getString(R.string.editor_image));
        this.jkb.setDefaultResource(R.drawable.pic_image_h_not);
        this.jkc = (LinearLayout) findViewById(R.id.small_tail);
        this.esT = (TbImageView) findViewById(R.id.tail_icon);
        this.esT.setDefaultResource(R.drawable.tb_launcher_icon);
        this.esT.setAutoChangeStyle(false);
        this.jkd = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.jkb;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.jkb = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.jkc;
    }

    public void setTail(LinearLayout linearLayout) {
        this.jkc = linearLayout;
    }

    public TbImageView getIcon() {
        return this.esT;
    }

    public void setIcon(TbImageView tbImageView) {
        this.esT = tbImageView;
    }

    public TextView getFromSource() {
        return this.jkd;
    }

    public void setFromSource(TextView textView) {
        this.jkd = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.esT.setAutoChangeStyle(z);
    }
}
