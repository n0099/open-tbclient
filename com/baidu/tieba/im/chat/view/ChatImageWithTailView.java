package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView esP;
    private ChatClipImageItemView jjV;
    private LinearLayout jjW;
    private TextView jjX;

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
        this.jjV = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.jjV.setContentDescription(getContext().getString(R.string.editor_image));
        this.jjV.setDefaultResource(R.drawable.pic_image_h_not);
        this.jjW = (LinearLayout) findViewById(R.id.small_tail);
        this.esP = (TbImageView) findViewById(R.id.tail_icon);
        this.esP.setDefaultResource(R.drawable.tb_launcher_icon);
        this.esP.setAutoChangeStyle(false);
        this.jjX = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.jjV;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.jjV = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.jjW;
    }

    public void setTail(LinearLayout linearLayout) {
        this.jjW = linearLayout;
    }

    public TbImageView getIcon() {
        return this.esP;
    }

    public void setIcon(TbImageView tbImageView) {
        this.esP = tbImageView;
    }

    public TextView getFromSource() {
        return this.jjX;
    }

    public void setFromSource(TextView textView) {
        this.jjX = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.esP.setAutoChangeStyle(z);
    }
}
