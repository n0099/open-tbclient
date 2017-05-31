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
    private TbPageContext<MsglistActivity<?>> aas;
    private UserIconBox amk;
    private HeadImageView bWb;
    private ViewGroup cPT;
    private ImageView cPU;
    private final TouchType cPV;
    View.OnLongClickListener cPW;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgleft_view);
        this.cPV = new TouchType();
        this.cPW = new bh(this);
        this.aas = tbPageContext;
        initView();
        this.cPU = (ImageView) findViewById(w.h.iv_live_group_host);
        this.mName = (TextView) findViewById(w.h.tex_msgitem_name);
        this.cPT = (ViewGroup) findViewById(w.h.box_msgitem_bubble);
        this.bWb = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bWb.setAutoChangeStyle(false);
        this.bWb.setDrawerType(1);
        this.bWb.setRadius(com.baidu.adp.lib.util.k.dip2px(this.aas.getContext(), 4.0f));
        this.amk = (UserIconBox) findViewById(w.h.user_tshow_icon_box);
        this.bWb.setOnClickListener(new bi(this));
        this.bWb.setLongClickable(true);
        this.bWb.setOnLongClickListener(this.cPW);
        this.bWb.setOnTouchListener(new bj(this));
        this.cPM.setIsLeft(true);
        this.cPN.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        amr();
        if (this.amk != null && this.cPQ) {
            this.amk.setVisibility(0);
            this.amk.setAutoChangedStyle(false);
            Resources resources = this.aas.getResources();
            this.amk.a(tShowInfoNew, 2, resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.cPI.setVisibility(0);
            this.cPI.setText(null);
            lr(8);
            this.cPP.getImage().setTag(null);
            this.cPJ.setVisibility(8);
            this.cPJ.setTag(null);
            this.cPL.setVisibility(8);
            this.cPL.setTag(null);
            this.cPM.setVisibility(8);
            this.cPN.setVisibility(8);
            this.cPO.setVisibility(8);
            this.cPU.setVisibility(8);
            return;
        }
        d(chatMessage);
        f(chatMessage);
        this.mName.setText("");
        e(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.bWb.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bWb.c(str, 10, false);
            } else {
                this.bWb.c(str, 12, false);
            }
            this.bWb.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cPI.setVisibility(8);
            lr(8);
            this.cPJ.setVisibility(8);
            this.cPK.setVisibility(8);
            this.cPL.setVisibility(8);
            this.cPN.setVisibility(8);
            this.cPM.setVisibility(8);
            this.cPO.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cPU.setVisibility(0);
        } else {
            this.cPU.setVisibility(8);
        }
    }

    private void f(ChatMessage chatMessage) {
        int i;
        if (this.cPQ) {
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
            if (!this.cPQ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void amr() {
        if (this.cPQ) {
            this.mName.setVisibility(0);
            this.amk.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cPT.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cPT.setLayoutParams(marginLayoutParams);
        this.amk.setVisibility(8);
    }
}
