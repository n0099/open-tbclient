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
    private TbImageView eHi;
    private ChatClipImageItemView jHC;
    private LinearLayout jHD;
    private TextView jHE;

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
        this.jHC = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.jHC.setContentDescription(getContext().getString(R.string.editor_image));
        this.jHC.setDefaultResource(R.drawable.pic_image_h_not);
        this.jHD = (LinearLayout) findViewById(R.id.small_tail);
        this.eHi = (TbImageView) findViewById(R.id.tail_icon);
        this.eHi.setDefaultResource(R.drawable.tb_launcher_icon);
        this.eHi.setAutoChangeStyle(false);
        this.jHE = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.jHC;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.jHC = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.jHD;
    }

    public void setTail(LinearLayout linearLayout) {
        this.jHD = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eHi;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eHi = tbImageView;
    }

    public TextView getFromSource() {
        return this.jHE;
    }

    public void setFromSource(TextView textView) {
        this.jHE = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eHi.setAutoChangeStyle(z);
    }
}
