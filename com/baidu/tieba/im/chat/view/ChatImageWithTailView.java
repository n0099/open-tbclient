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
    private TbImageView fit;
    private ChatClipImageItemView gCT;
    private LinearLayout gCU;
    private TextView gCV;

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
        this.gCT = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.gCT.setContentDescription(getContext().getString(R.string.editor_image));
        this.gCT.setDefaultResource(R.drawable.pic_image_h_not);
        this.gCU = (LinearLayout) findViewById(R.id.small_tail);
        this.fit = (TbImageView) findViewById(R.id.tail_icon);
        this.fit.setDefaultResource(R.drawable.icon);
        this.fit.setAutoChangeStyle(false);
        this.gCV = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.gCT;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.gCT = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.gCU;
    }

    public void setTail(LinearLayout linearLayout) {
        this.gCU = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fit;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fit = tbImageView;
    }

    public TextView getFromSource() {
        return this.gCV;
    }

    public void setFromSource(TextView textView) {
        this.gCV = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fit.setAutoChangeStyle(z);
    }
}
