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
    private TbImageView ePE;
    private ChatClipImageItemView jUb;
    private LinearLayout jUc;
    private TextView jUd;

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
        this.jUb = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.jUb.setContentDescription(getContext().getString(R.string.editor_image));
        this.jUb.setDefaultResource(R.drawable.pic_image_h_not);
        this.jUc = (LinearLayout) findViewById(R.id.small_tail);
        this.ePE = (TbImageView) findViewById(R.id.tail_icon);
        this.ePE.setDefaultResource(R.drawable.tb_launcher_icon);
        this.ePE.setAutoChangeStyle(false);
        this.jUd = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.jUb;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.jUb = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.jUc;
    }

    public void setTail(LinearLayout linearLayout) {
        this.jUc = linearLayout;
    }

    public TbImageView getIcon() {
        return this.ePE;
    }

    public void setIcon(TbImageView tbImageView) {
        this.ePE = tbImageView;
    }

    public TextView getFromSource() {
        return this.jUd;
    }

    public void setFromSource(TextView textView) {
        this.jUd = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.ePE.setAutoChangeStyle(z);
    }
}
