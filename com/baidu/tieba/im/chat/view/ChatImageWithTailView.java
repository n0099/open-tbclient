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
    private TbImageView fkQ;
    private ChatClipImageItemView kGK;
    private LinearLayout kGL;
    private TextView kGM;

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
        this.kGK = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.kGK.setContentDescription(getContext().getString(R.string.editor_image));
        this.kGK.setDefaultResource(R.drawable.pic_image_h_not);
        this.kGL = (LinearLayout) findViewById(R.id.small_tail);
        this.fkQ = (TbImageView) findViewById(R.id.tail_icon);
        this.fkQ.setDefaultResource(R.drawable.tb_launcher_icon);
        this.fkQ.setAutoChangeStyle(false);
        this.kGM = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.kGK;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.kGK = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.kGL;
    }

    public void setTail(LinearLayout linearLayout) {
        this.kGL = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fkQ;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fkQ = tbImageView;
    }

    public TextView getFromSource() {
        return this.kGM;
    }

    public void setFromSource(TextView textView) {
        this.kGM = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fkQ.setAutoChangeStyle(z);
    }
}
