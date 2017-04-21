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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends ar {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> aaY;
    private UserIconBox ams;
    private HeadImageView bRt;
    private ViewGroup cQt;
    private ImageView cQu;
    private final TouchType cQv;
    View.OnLongClickListener cQw;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgleft_view);
        this.cQv = new TouchType();
        this.cQw = new bh(this);
        this.aaY = tbPageContext;
        initView();
        this.cQu = (ImageView) findViewById(w.h.iv_live_group_host);
        this.mName = (TextView) findViewById(w.h.tex_msgitem_name);
        this.cQt = (ViewGroup) findViewById(w.h.box_msgitem_bubble);
        this.bRt = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bRt.setAutoChangeStyle(false);
        this.bRt.setDrawerType(1);
        this.bRt.setRadius(com.baidu.adp.lib.util.k.dip2px(this.aaY.getContext(), 4.0f));
        this.ams = (UserIconBox) findViewById(w.h.user_tshow_icon_box);
        this.bRt.setOnClickListener(new bi(this));
        this.bRt.setLongClickable(true);
        this.bRt.setOnLongClickListener(this.cQw);
        this.bRt.setOnTouchListener(new bj(this));
        this.cQm.setIsLeft(true);
        this.cQn.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aoy();
        if (this.ams != null && this.cQq) {
            this.ams.setVisibility(0);
            this.ams.setAutoChangedStyle(false);
            Resources resources = this.aaY.getResources();
            this.ams.a(tShowInfoNew, 2, resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.cQi.setVisibility(0);
            this.cQi.setText(null);
            lk(8);
            this.cQp.getImage().setTag(null);
            this.cQj.setVisibility(8);
            this.cQj.setTag(null);
            this.cQl.setVisibility(8);
            this.cQl.setTag(null);
            this.cQm.setVisibility(8);
            this.cQn.setVisibility(8);
            this.cQo.setVisibility(8);
            this.cQu.setVisibility(8);
            return;
        }
        d(chatMessage);
        f(chatMessage);
        this.mName.setText("");
        e(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.bRt.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bRt.c(str, 10, false);
            } else {
                this.bRt.c(str, 12, false);
            }
            this.bRt.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cQi.setVisibility(8);
            lk(8);
            this.cQj.setVisibility(8);
            this.cQk.setVisibility(8);
            this.cQl.setVisibility(8);
            this.cQn.setVisibility(8);
            this.cQm.setVisibility(8);
            this.cQo.setVisibility(8);
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

    private void e(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.uL().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cQu.setVisibility(0);
        } else {
            this.cQu.setVisibility(8);
        }
    }

    private void f(ChatMessage chatMessage) {
        int i;
        if (this.cQq) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = w.g.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = w.g.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cQq) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aoy() {
        if (this.cQq) {
            this.mName.setVisibility(0);
            this.ams.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cQt.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cQt.setLayoutParams(marginLayoutParams);
        this.ams.setVisibility(8);
    }
}
