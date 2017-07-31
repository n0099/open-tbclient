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
    private TbPageContext<MsglistActivity<?>> acp;
    private UserIconBox apm;
    private HeadImageView cld;
    private ViewGroup dhP;
    private ImageView dhQ;
    private final TouchType dhR;
    View.OnLongClickListener dhS;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgleft_view);
        this.dhR = new TouchType();
        this.dhS = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dhR.set(true);
                return true;
            }
        };
        this.acp = tbPageContext;
        initView();
        this.dhQ = (ImageView) findViewById(d.h.iv_live_group_host);
        this.mName = (TextView) findViewById(d.h.tex_msgitem_name);
        this.dhP = (ViewGroup) findViewById(d.h.box_msgitem_bubble);
        this.cld = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.cld.setAutoChangeStyle(false);
        this.cld.setDrawerType(1);
        this.cld.setRadius(k.dip2px(this.acp.getContext(), 4.0f));
        this.apm = (UserIconBox) findViewById(d.h.user_tshow_icon_box);
        this.cld.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgleftView.this.dhg.a(view, 2, MsgleftView.this.awz, 0L);
            }
        });
        this.cld.setLongClickable(true);
        this.cld.setOnLongClickListener(this.dhS);
        this.cld.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MsgleftView.this.dhR.get() && motionEvent.getAction() == 1) {
                    MsgleftView.this.dhh.b(view, 2, MsgleftView.this.awz, 0L);
                    MsgleftView.this.dhR.set(false);
                }
                return false;
            }
        });
        this.dhI.setIsLeft(true);
        this.dhJ.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        arU();
        if (this.apm != null && this.dhM) {
            this.apm.setVisibility(0);
            this.apm.setAutoChangedStyle(false);
            Resources resources = this.acp.getResources();
            this.apm.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dhE.setVisibility(0);
            this.dhE.setText(null);
            lL(8);
            this.dhL.getImage().setTag(null);
            this.dhF.setVisibility(8);
            this.dhF.setTag(null);
            this.dhH.setVisibility(8);
            this.dhH.setTag(null);
            this.dhI.setVisibility(8);
            this.dhJ.setVisibility(8);
            this.dhK.setVisibility(8);
            this.dhQ.setVisibility(8);
            return;
        }
        e(chatMessage);
        g(chatMessage);
        this.mName.setText("");
        f(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.cld.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.cld.c(str, 10, false);
            } else {
                this.cld.c(str, 12, false);
            }
            this.cld.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dhE.setVisibility(8);
            lL(8);
            this.dhF.setVisibility(8);
            this.dhG.setVisibility(8);
            this.dhH.setVisibility(8);
            this.dhJ.setVisibility(8);
            this.dhI.setVisibility(8);
            this.dhK.setVisibility(8);
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
            this.dhQ.setVisibility(0);
        } else {
            this.dhQ.setVisibility(8);
        }
    }

    private void g(ChatMessage chatMessage) {
        int i;
        if (this.dhM) {
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
            if (!this.dhM) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void arU() {
        if (this.dhM) {
            this.mName.setVisibility(0);
            this.apm.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dhP.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dhP.setLayoutParams(marginLayoutParams);
        this.apm.setVisibility(8);
    }
}
