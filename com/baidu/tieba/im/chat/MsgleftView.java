package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
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
    private TbPageContext<MsglistActivity<?>> abm;
    private UserIconBox anO;
    private HeadImageView csn;
    private ViewGroup dnn;
    private ImageView dno;
    private final TouchType dnp;
    View.OnLongClickListener dnq;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgleft_view);
        this.dnp = new TouchType();
        this.dnq = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dnp.set(true);
                return true;
            }
        };
        this.abm = tbPageContext;
        initView();
        this.dno = (ImageView) findViewById(d.h.iv_live_group_host);
        this.mName = (TextView) findViewById(d.h.tex_msgitem_name);
        this.dnn = (ViewGroup) findViewById(d.h.box_msgitem_bubble);
        this.csn = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.csn.setAutoChangeStyle(false);
        this.csn.setDrawerType(1);
        this.csn.setRadius(l.dip2px(this.abm.getContext(), 4.0f));
        this.anO = (UserIconBox) findViewById(d.h.user_tshow_icon_box);
        this.csn.setLongClickable(true);
        this.csn.setOnLongClickListener(this.dnq);
        this.csn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dnr = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dnr = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dnr > 200) {
                        if (MsgleftView.this.dnp.get()) {
                            MsgleftView.this.dmF.b(view, 2, MsgleftView.this.auI, 0L);
                            MsgleftView.this.dnp.set(false);
                        }
                    } else {
                        MsgleftView.this.dmE.a(view, 2, MsgleftView.this.auI, 0L);
                    }
                }
                return false;
            }
        });
        this.dng.setIsLeft(true);
        this.dnh.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        asV();
        if (this.anO != null && this.dnk) {
            this.anO.setVisibility(0);
            this.anO.setAutoChangedStyle(false);
            Resources resources = this.abm.getResources();
            this.anO.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dnc.setVisibility(0);
            this.dnc.setText(null);
            mk(8);
            this.dnj.getImage().setTag(null);
            this.dnd.setVisibility(8);
            this.dnd.setTag(null);
            this.dnf.setVisibility(8);
            this.dnf.setTag(null);
            this.dng.setVisibility(8);
            this.dnh.setVisibility(8);
            this.dni.setVisibility(8);
            this.dno.setVisibility(8);
            return;
        }
        e(chatMessage);
        g(chatMessage);
        this.mName.setText("");
        f(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.csn.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.csn.c(str, 10, false);
            } else {
                this.csn.c(str, 12, false);
            }
            this.csn.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dnc.setVisibility(8);
            mk(8);
            this.dnd.setVisibility(8);
            this.dne.setVisibility(8);
            this.dnf.setVisibility(8);
            this.dnh.setVisibility(8);
            this.dng.setVisibility(8);
            this.dni.setVisibility(8);
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
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.dno.setVisibility(0);
        } else {
            this.dno.setVisibility(8);
        }
    }

    private void g(ChatMessage chatMessage) {
        int i;
        if (this.dnk) {
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
            if (!this.dnk) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void asV() {
        if (this.dnk) {
            this.mName.setVisibility(0);
            this.anO.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dnn.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dnn.setLayoutParams(marginLayoutParams);
        this.anO.setVisibility(8);
    }
}
