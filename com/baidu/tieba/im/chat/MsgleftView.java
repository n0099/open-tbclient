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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> Gf;
    private UserIconBox ahx;
    private HeadImageView bAJ;
    private TextView cGh;
    private ViewGroup cGi;
    private ImageView cGj;
    private final TouchType cGk;
    View.OnLongClickListener cGl;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_msgleft_view);
        this.cGk = new TouchType();
        this.cGl = new bi(this);
        this.Gf = tbPageContext;
        initView();
        this.cGj = (ImageView) findViewById(r.g.iv_live_group_host);
        this.cGh = (TextView) findViewById(r.g.tex_msgitem_name);
        this.cGi = (ViewGroup) findViewById(r.g.box_msgitem_bubble);
        this.bAJ = (HeadImageView) findViewById(r.g.img_msgitem_photo);
        this.bAJ.setAutoChangeStyle(false);
        this.bAJ.setDrawerType(1);
        this.bAJ.setRadius(com.baidu.adp.lib.util.k.dip2px(this.Gf.getContext(), 4.0f));
        this.ahx = (UserIconBox) findViewById(r.g.user_tshow_icon_box);
        this.bAJ.setOnClickListener(new bj(this));
        this.bAJ.setLongClickable(true);
        this.bAJ.setOnLongClickListener(this.cGl);
        this.bAJ.setOnTouchListener(new bk(this));
        this.cGa.setIsLeft(true);
        this.cGb.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        anb();
        if (this.ahx != null && this.cGe) {
            this.ahx.setVisibility(0);
            this.ahx.setAutoChangedStyle(false);
            Resources resources = this.Gf.getResources();
            this.ahx.a(tShowInfoNew, 2, resources.getDimensionPixelSize(r.e.ds32), resources.getDimensionPixelSize(r.e.ds32), resources.getDimensionPixelSize(r.e.ds8), true);
        }
        if (chatMessage == null) {
            this.cGh.setText((CharSequence) null);
            this.cFW.setVisibility(0);
            this.cFW.setText(null);
            kA(8);
            this.cGd.getImage().setTag(null);
            this.cFX.setVisibility(8);
            this.cFX.setTag(null);
            this.cFZ.setVisibility(8);
            this.cFZ.setTag(null);
            this.cGa.setVisibility(8);
            this.cGb.setVisibility(8);
            this.cGc.setVisibility(8);
            this.cGj.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.cGh.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.cGh.setText(chatMessage.getUserInfo().getUserName());
                this.bAJ.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bAJ.c(str, 10, false);
            } else {
                this.bAJ.c(str, 12, false);
            }
            this.bAJ.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cFW.setVisibility(8);
            kA(8);
            this.cFX.setVisibility(8);
            this.cFY.setVisibility(8);
            this.cFZ.setVisibility(8);
            this.cGb.setVisibility(8);
            this.cGa.setVisibility(8);
            this.cGc.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.tW().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cGj.setVisibility(0);
        } else {
            this.cGj.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cGe) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = r.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = r.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cGe) {
                i = 0;
            }
            this.cGh.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void anb() {
        if (this.cGe) {
            this.cGh.setVisibility(0);
            this.ahx.setVisibility(0);
            return;
        }
        this.cGh.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cGi.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cGi.setLayoutParams(marginLayoutParams);
        this.ahx.setVisibility(8);
    }
}
