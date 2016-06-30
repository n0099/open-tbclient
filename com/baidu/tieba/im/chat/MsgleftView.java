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
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> Dp;
    private UserIconBox aef;
    private HeadImageView bBS;
    private ImageView cFA;
    private final TouchType cFB;
    View.OnLongClickListener cFC;
    private TextView cFy;
    private ViewGroup cFz;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, u.h.msg_msgleft_view);
        this.cFB = new TouchType();
        this.cFC = new bi(this);
        this.Dp = tbPageContext;
        initView();
        this.cFA = (ImageView) findViewById(u.g.iv_live_group_host);
        this.cFy = (TextView) findViewById(u.g.tex_msgitem_name);
        this.cFz = (ViewGroup) findViewById(u.g.box_msgitem_bubble);
        this.bBS = (HeadImageView) findViewById(u.g.img_msgitem_photo);
        this.bBS.setAutoChangeStyle(false);
        this.bBS.setDrawerType(1);
        this.bBS.setRadius(com.baidu.adp.lib.util.k.dip2px(this.Dp.getContext(), 4.0f));
        this.aef = (UserIconBox) findViewById(u.g.user_tshow_icon_box);
        this.bBS.setOnClickListener(new bj(this));
        this.bBS.setLongClickable(true);
        this.bBS.setOnLongClickListener(this.cFC);
        this.bBS.setOnTouchListener(new bk(this));
        this.cFr.setIsLeft(true);
        this.cFs.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        akF();
        if (this.aef != null && this.cFv) {
            this.aef.setVisibility(0);
            this.aef.setAutoChangedStyle(false);
            Resources resources = this.Dp.getResources();
            this.aef.a(tShowInfoNew, 2, resources.getDimensionPixelSize(u.e.ds32), resources.getDimensionPixelSize(u.e.ds32), resources.getDimensionPixelSize(u.e.ds8), true);
        }
        if (chatMessage == null) {
            this.cFy.setText((CharSequence) null);
            this.cFn.setVisibility(0);
            this.cFn.setText(null);
            kr(8);
            this.cFu.getImage().setTag(null);
            this.cFo.setVisibility(8);
            this.cFo.setTag(null);
            this.cFq.setVisibility(8);
            this.cFq.setTag(null);
            this.cFr.setVisibility(8);
            this.cFs.setVisibility(8);
            this.cFt.setVisibility(8);
            this.cFA.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.cFy.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.cFy.setText(chatMessage.getUserInfo().getUserName());
                this.bBS.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bBS.c(str, 10, false);
            } else {
                this.bBS.c(str, 12, false);
            }
            this.bBS.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cFn.setVisibility(8);
            kr(8);
            this.cFo.setVisibility(8);
            this.cFp.setVisibility(8);
            this.cFq.setVisibility(8);
            this.cFs.setVisibility(8);
            this.cFr.setVisibility(8);
            this.cFt.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.sO().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cFA.setVisibility(0);
        } else {
            this.cFA.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cFv) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = u.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = u.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cFv) {
                i = 0;
            }
            this.cFy.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void akF() {
        if (this.cFv) {
            this.cFy.setVisibility(0);
            this.aef.setVisibility(0);
            return;
        }
        this.cFy.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cFz.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cFz.setLayoutParams(marginLayoutParams);
        this.aef.setVisibility(8);
    }
}
