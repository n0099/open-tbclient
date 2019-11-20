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
    private TbImageView fhB;
    private ChatClipImageItemView gCc;
    private LinearLayout gCd;
    private TextView gCe;

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
        this.gCc = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.gCc.setContentDescription(getContext().getString(R.string.editor_image));
        this.gCc.setDefaultResource(R.drawable.pic_image_h_not);
        this.gCd = (LinearLayout) findViewById(R.id.small_tail);
        this.fhB = (TbImageView) findViewById(R.id.tail_icon);
        this.fhB.setDefaultResource(R.drawable.icon);
        this.fhB.setAutoChangeStyle(false);
        this.gCe = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.gCc;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.gCc = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.gCd;
    }

    public void setTail(LinearLayout linearLayout) {
        this.gCd = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fhB;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fhB = tbImageView;
    }

    public TextView getFromSource() {
        return this.gCe;
    }

    public void setFromSource(TextView textView) {
        this.gCe = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fhB.setAutoChangeStyle(z);
    }
}
