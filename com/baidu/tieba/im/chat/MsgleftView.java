package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> LS;
    private UserIconBox aTN;
    private HeadImageView aTO;
    private TextView boD;
    private ViewGroup boE;
    private ImageView boF;
    private final TouchType boG;
    View.OnLongClickListener boH;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgleft_view);
        this.boG = new TouchType();
        this.boH = new bf(this);
        this.LS = tbPageContext;
        initView();
        this.boF = (ImageView) findViewById(i.f.iv_live_group_host);
        this.boD = (TextView) findViewById(i.f.tex_msgitem_name);
        this.boE = (ViewGroup) findViewById(i.f.box_msgitem_bubble);
        this.aTO = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aTO.setAutoChangeStyle(false);
        this.aTO.setDrawerType(1);
        this.aTO.setRadius(com.baidu.adp.lib.util.k.dip2px(this.LS.getContext(), 4.0f));
        this.aTN = (UserIconBox) findViewById(i.f.user_tshow_icon_box);
        this.aTO.setOnClickListener(new bg(this));
        this.aTO.setLongClickable(true);
        this.aTO.setOnLongClickListener(this.boH);
        this.aTO.setOnTouchListener(new bh(this));
        this.box.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Rh();
        if (this.aTN != null && this.boA) {
            this.aTN.setVisibility(0);
            this.aTN.setAutoChangedStyle(false);
            Resources resources = this.LS.getResources();
            this.aTN.a(tShowInfo, 2, resources.getDimensionPixelSize(i.d.small_icon_width), resources.getDimensionPixelSize(i.d.small_icon_height), resources.getDimensionPixelSize(i.d.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.boD.setText((CharSequence) null);
            this.bot.setVisibility(0);
            this.bot.setText(null);
            gt(8);
            this.boz.getImage().setTag(null);
            this.bou.setVisibility(8);
            this.bou.setTag(null);
            this.bow.setVisibility(8);
            this.bow.setTag(null);
            this.box.setVisibility(8);
            this.boy.setVisibility(8);
            this.boF.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.boD.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.boD.setText(chatMessage.getUserInfo().getUserName());
                this.aTO.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aTO.d(str, 10, false);
            } else {
                this.aTO.d(str, 12, false);
            }
            this.bot.setVisibility(8);
            gt(8);
            this.bou.setVisibility(8);
            this.bov.setVisibility(8);
            this.bow.setVisibility(8);
            this.box.setVisibility(8);
            this.boy.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    return;
                case 4:
                    a(chatMessage, false);
                    return;
                case 5:
                    b(view, chatMessage, TAG);
                    return;
                case 6:
                case 7:
                case 8:
                default:
                    return;
                case 9:
                    c(view, chatMessage, TAG);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.ts().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.boF.setVisibility(0);
        } else {
            this.boF.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.boA) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = i.e.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = i.e.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.boA) {
                i = 0;
            }
            this.boD.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void Rh() {
        if (this.boA) {
            this.boD.setVisibility(0);
            this.aTN.setVisibility(0);
            return;
        }
        this.boD.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.boE.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.boE.setLayoutParams(marginLayoutParams);
        this.aTN.setVisibility(8);
    }
}
