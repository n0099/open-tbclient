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
    private TbPageContext<MsglistActivity<?>> Gd;
    private UserIconBox ahw;
    private HeadImageView bSk;
    private TextView cVm;
    private ViewGroup cVn;
    private ImageView cVo;
    private final TouchType cVp;
    View.OnLongClickListener cVq;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_msgleft_view);
        this.cVp = new TouchType();
        this.cVq = new bi(this);
        this.Gd = tbPageContext;
        initView();
        this.cVo = (ImageView) findViewById(r.g.iv_live_group_host);
        this.cVm = (TextView) findViewById(r.g.tex_msgitem_name);
        this.cVn = (ViewGroup) findViewById(r.g.box_msgitem_bubble);
        this.bSk = (HeadImageView) findViewById(r.g.img_msgitem_photo);
        this.bSk.setAutoChangeStyle(false);
        this.bSk.setDrawerType(1);
        this.bSk.setRadius(com.baidu.adp.lib.util.k.dip2px(this.Gd.getContext(), 4.0f));
        this.ahw = (UserIconBox) findViewById(r.g.user_tshow_icon_box);
        this.bSk.setOnClickListener(new bj(this));
        this.bSk.setLongClickable(true);
        this.bSk.setOnLongClickListener(this.cVq);
        this.bSk.setOnTouchListener(new bk(this));
        this.cVf.setIsLeft(true);
        this.cVg.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aqD();
        if (this.ahw != null && this.cVj) {
            this.ahw.setVisibility(0);
            this.ahw.setAutoChangedStyle(false);
            Resources resources = this.Gd.getResources();
            this.ahw.a(tShowInfoNew, 2, resources.getDimensionPixelSize(r.e.ds32), resources.getDimensionPixelSize(r.e.ds32), resources.getDimensionPixelSize(r.e.ds8), true);
        }
        if (chatMessage == null) {
            this.cVm.setText((CharSequence) null);
            this.cVb.setVisibility(0);
            this.cVb.setText(null);
            li(8);
            this.cVi.getImage().setTag(null);
            this.cVc.setVisibility(8);
            this.cVc.setTag(null);
            this.cVe.setVisibility(8);
            this.cVe.setTag(null);
            this.cVf.setVisibility(8);
            this.cVg.setVisibility(8);
            this.cVh.setVisibility(8);
            this.cVo.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.cVm.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.cVm.setText(chatMessage.getUserInfo().getUserName());
                this.bSk.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bSk.c(str, 10, false);
            } else {
                this.bSk.c(str, 12, false);
            }
            this.bSk.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cVb.setVisibility(8);
            li(8);
            this.cVc.setVisibility(8);
            this.cVd.setVisibility(8);
            this.cVe.setVisibility(8);
            this.cVg.setVisibility(8);
            this.cVf.setVisibility(8);
            this.cVh.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.uh().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cVo.setVisibility(0);
        } else {
            this.cVo.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cVj) {
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
            if (!this.cVj) {
                i = 0;
            }
            this.cVm.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aqD() {
        if (this.cVj) {
            this.cVm.setVisibility(0);
            this.ahw.setVisibility(0);
            return;
        }
        this.cVm.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cVn.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cVn.setLayoutParams(marginLayoutParams);
        this.ahw.setVisibility(8);
    }
}
