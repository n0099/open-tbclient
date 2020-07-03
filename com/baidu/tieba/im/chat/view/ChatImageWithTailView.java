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
    private TbImageView ecM;
    private ChatClipImageItemView iNR;
    private LinearLayout iNS;
    private TextView iNT;

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
        this.iNR = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.iNR.setContentDescription(getContext().getString(R.string.editor_image));
        this.iNR.setDefaultResource(R.drawable.pic_image_h_not);
        this.iNS = (LinearLayout) findViewById(R.id.small_tail);
        this.ecM = (TbImageView) findViewById(R.id.tail_icon);
        this.ecM.setDefaultResource(R.drawable.tb_launcher_icon);
        this.ecM.setAutoChangeStyle(false);
        this.iNT = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.iNR;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.iNR = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.iNS;
    }

    public void setTail(LinearLayout linearLayout) {
        this.iNS = linearLayout;
    }

    public TbImageView getIcon() {
        return this.ecM;
    }

    public void setIcon(TbImageView tbImageView) {
        this.ecM = tbImageView;
    }

    public TextView getFromSource() {
        return this.iNT;
    }

    public void setFromSource(TextView textView) {
        this.iNT = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.ecM.setAutoChangeStyle(z);
    }
}
