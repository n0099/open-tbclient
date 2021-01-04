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
    private TbImageView flJ;
    private ChatClipImageItemView kAT;
    private LinearLayout kAU;
    private TextView kAV;

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
        this.kAT = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.kAT.setContentDescription(getContext().getString(R.string.editor_image));
        this.kAT.setDefaultResource(R.drawable.pic_image_h_not);
        this.kAU = (LinearLayout) findViewById(R.id.small_tail);
        this.flJ = (TbImageView) findViewById(R.id.tail_icon);
        this.flJ.setDefaultResource(R.drawable.tb_launcher_icon);
        this.flJ.setAutoChangeStyle(false);
        this.kAV = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.kAT;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.kAT = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.kAU;
    }

    public void setTail(LinearLayout linearLayout) {
        this.kAU = linearLayout;
    }

    public TbImageView getIcon() {
        return this.flJ;
    }

    public void setIcon(TbImageView tbImageView) {
        this.flJ = tbImageView;
    }

    public TextView getFromSource() {
        return this.kAV;
    }

    public void setFromSource(TextView textView) {
        this.kAV = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.flJ.setAutoChangeStyle(z);
    }
}
