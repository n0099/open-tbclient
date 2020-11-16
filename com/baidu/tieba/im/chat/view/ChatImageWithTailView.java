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
    private TbImageView eUE;
    private ChatClipImageItemView kaI;
    private LinearLayout kaJ;
    private TextView kaK;

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
        this.kaI = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.kaI.setContentDescription(getContext().getString(R.string.editor_image));
        this.kaI.setDefaultResource(R.drawable.pic_image_h_not);
        this.kaJ = (LinearLayout) findViewById(R.id.small_tail);
        this.eUE = (TbImageView) findViewById(R.id.tail_icon);
        this.eUE.setDefaultResource(R.drawable.tb_launcher_icon);
        this.eUE.setAutoChangeStyle(false);
        this.kaK = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.kaI;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.kaI = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.kaJ;
    }

    public void setTail(LinearLayout linearLayout) {
        this.kaJ = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eUE;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eUE = tbImageView;
    }

    public TextView getFromSource() {
        return this.kaK;
    }

    public void setFromSource(TextView textView) {
        this.kaK = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eUE.setAutoChangeStyle(z);
    }
}
