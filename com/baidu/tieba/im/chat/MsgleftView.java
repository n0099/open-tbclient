package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> acr;
    private UserIconBox apn;
    private HeadImageView clO;
    private ViewGroup djM;
    private ImageView djN;
    private final TouchType djO;
    View.OnLongClickListener djP;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgleft_view);
        this.djO = new TouchType();
        this.djP = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.djO.set(true);
                return true;
            }
        };
        this.acr = tbPageContext;
        initView();
        this.djN = (ImageView) findViewById(d.h.iv_live_group_host);
        this.mName = (TextView) findViewById(d.h.tex_msgitem_name);
        this.djM = (ViewGroup) findViewById(d.h.box_msgitem_bubble);
        this.clO = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.clO.setAutoChangeStyle(false);
        this.clO.setDrawerType(1);
        this.clO.setRadius(k.dip2px(this.acr.getContext(), 4.0f));
        this.apn = (UserIconBox) findViewById(d.h.user_tshow_icon_box);
        this.clO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgleftView.this.djd.a(view, 2, MsgleftView.this.awA, 0L);
            }
        });
        this.clO.setLongClickable(true);
        this.clO.setOnLongClickListener(this.djP);
        this.clO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MsgleftView.this.djO.get() && motionEvent.getAction() == 1) {
                    MsgleftView.this.dje.b(view, 2, MsgleftView.this.awA, 0L);
                    MsgleftView.this.djO.set(false);
                }
                return false;
            }
        });
        this.djF.setIsLeft(true);
        this.djG.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        asB();
        if (this.apn != null && this.djJ) {
            this.apn.setVisibility(0);
            this.apn.setAutoChangedStyle(false);
            Resources resources = this.acr.getResources();
            this.apn.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.djB.setVisibility(0);
            this.djB.setText(null);
            lV(8);
            this.djI.getImage().setTag(null);
            this.djC.setVisibility(8);
            this.djC.setTag(null);
            this.djE.setVisibility(8);
            this.djE.setTag(null);
            this.djF.setVisibility(8);
            this.djG.setVisibility(8);
            this.djH.setVisibility(8);
            this.djN.setVisibility(8);
            return;
        }
        e(chatMessage);
        g(chatMessage);
        this.mName.setText("");
        f(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.clO.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.clO.c(str, 10, false);
            } else {
                this.clO.c(str, 12, false);
            }
            this.clO.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.djB.setVisibility(8);
            lV(8);
            this.djC.setVisibility(8);
            this.djD.setVisibility(8);
            this.djE.setVisibility(8);
            this.djG.setVisibility(8);
            this.djF.setVisibility(8);
            this.djH.setVisibility(8);
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

    private void f(ChatMessage chatMessage) {
        String string = b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.djN.setVisibility(0);
        } else {
            this.djN.setVisibility(8);
        }
    }

    private void g(ChatMessage chatMessage) {
        int i;
        if (this.djJ) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = d.g.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = d.g.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.djJ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void asB() {
        if (this.djJ) {
            this.mName.setVisibility(0);
            this.apn.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.djM.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.djM.setLayoutParams(marginLayoutParams);
        this.apn.setVisibility(8);
    }
}
