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
    private TbImageView hax;
    private ChatClipImageItemView iwM;
    private LinearLayout iwN;
    private TextView iwO;

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
        this.iwM = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.iwM.setContentDescription(getContext().getString(R.string.editor_image));
        this.iwM.setDefaultResource(R.drawable.pic_image_h_not);
        this.iwN = (LinearLayout) findViewById(R.id.small_tail);
        this.hax = (TbImageView) findViewById(R.id.tail_icon);
        this.hax.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hax.setAutoChangeStyle(false);
        this.iwO = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.iwM;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.iwM = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.iwN;
    }

    public void setTail(LinearLayout linearLayout) {
        this.iwN = linearLayout;
    }

    public TbImageView getIcon() {
        return this.hax;
    }

    public void setIcon(TbImageView tbImageView) {
        this.hax = tbImageView;
    }

    public TextView getFromSource() {
        return this.iwO;
    }

    public void setFromSource(TextView textView) {
        this.iwO = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.hax.setAutoChangeStyle(z);
    }
}
