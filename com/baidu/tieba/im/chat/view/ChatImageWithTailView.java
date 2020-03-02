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
    private TbImageView gbo;
    private ChatClipImageItemView hvL;
    private LinearLayout hvM;
    private TextView hvN;

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
        this.hvL = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.hvL.setContentDescription(getContext().getString(R.string.editor_image));
        this.hvL.setDefaultResource(R.drawable.pic_image_h_not);
        this.hvM = (LinearLayout) findViewById(R.id.small_tail);
        this.gbo = (TbImageView) findViewById(R.id.tail_icon);
        this.gbo.setDefaultResource(R.drawable.tb_launcher_icon);
        this.gbo.setAutoChangeStyle(false);
        this.hvN = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.hvL;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.hvL = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.hvM;
    }

    public void setTail(LinearLayout linearLayout) {
        this.hvM = linearLayout;
    }

    public TbImageView getIcon() {
        return this.gbo;
    }

    public void setIcon(TbImageView tbImageView) {
        this.gbo = tbImageView;
    }

    public TextView getFromSource() {
        return this.hvN;
    }

    public void setFromSource(TextView textView) {
        this.hvN = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.gbo.setAutoChangeStyle(z);
    }
}
