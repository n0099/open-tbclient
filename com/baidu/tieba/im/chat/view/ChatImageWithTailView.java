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
    private TbImageView eVt;
    private ChatClipImageItemView jZX;
    private LinearLayout jZY;
    private TextView jZZ;

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
        this.jZX = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.jZX.setContentDescription(getContext().getString(R.string.editor_image));
        this.jZX.setDefaultResource(R.drawable.pic_image_h_not);
        this.jZY = (LinearLayout) findViewById(R.id.small_tail);
        this.eVt = (TbImageView) findViewById(R.id.tail_icon);
        this.eVt.setDefaultResource(R.drawable.tb_launcher_icon);
        this.eVt.setAutoChangeStyle(false);
        this.jZZ = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.jZX;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.jZX = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.jZY;
    }

    public void setTail(LinearLayout linearLayout) {
        this.jZY = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eVt;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eVt = tbImageView;
    }

    public TextView getFromSource() {
        return this.jZZ;
    }

    public void setFromSource(TextView textView) {
        this.jZZ = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eVt.setAutoChangeStyle(z);
    }
}
