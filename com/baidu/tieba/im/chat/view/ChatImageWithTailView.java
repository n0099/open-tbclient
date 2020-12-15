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
    private TbImageView fca;
    private ChatClipImageItemView koo;
    private LinearLayout kop;
    private TextView koq;

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
        this.koo = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.koo.setContentDescription(getContext().getString(R.string.editor_image));
        this.koo.setDefaultResource(R.drawable.pic_image_h_not);
        this.kop = (LinearLayout) findViewById(R.id.small_tail);
        this.fca = (TbImageView) findViewById(R.id.tail_icon);
        this.fca.setDefaultResource(R.drawable.tb_launcher_icon);
        this.fca.setAutoChangeStyle(false);
        this.koq = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.koo;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.koo = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.kop;
    }

    public void setTail(LinearLayout linearLayout) {
        this.kop = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fca;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fca = tbImageView;
    }

    public TextView getFromSource() {
        return this.koq;
    }

    public void setFromSource(TextView textView) {
        this.koq = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fca.setAutoChangeStyle(z);
    }
}
