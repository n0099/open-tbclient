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
    private TbPageContext<MsglistActivity<?>> abz;
    private UserIconBox aoa;
    private HeadImageView csz;
    private ViewGroup dnA;
    private ImageView dnB;
    private final TouchType dnC;
    View.OnLongClickListener dnD;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgleft_view);
        this.dnC = new TouchType();
        this.dnD = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dnC.set(true);
                return true;
            }
        };
        this.abz = tbPageContext;
        initView();
        this.dnB = (ImageView) findViewById(d.h.iv_live_group_host);
        this.mName = (TextView) findViewById(d.h.tex_msgitem_name);
        this.dnA = (ViewGroup) findViewById(d.h.box_msgitem_bubble);
        this.csz = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.csz.setAutoChangeStyle(false);
        this.csz.setDrawerType(1);
        this.csz.setRadius(l.dip2px(this.abz.getContext(), 4.0f));
        this.aoa = (UserIconBox) findViewById(d.h.user_tshow_icon_box);
        this.csz.setLongClickable(true);
        this.csz.setOnLongClickListener(this.dnD);
        this.csz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dnE = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dnE = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dnE > 200) {
                        if (MsgleftView.this.dnC.get()) {
                            MsgleftView.this.dmS.b(view, 2, MsgleftView.this.auU, 0L);
                            MsgleftView.this.dnC.set(false);
                        }
                    } else {
                        MsgleftView.this.dmR.a(view, 2, MsgleftView.this.auU, 0L);
                    }
                }
                return false;
            }
        });
        this.dnt.setIsLeft(true);
        this.dnu.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        ata();
        if (this.aoa != null && this.dnx) {
            this.aoa.setVisibility(0);
            this.aoa.setAutoChangedStyle(false);
            Resources resources = this.abz.getResources();
            this.aoa.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dnp.setVisibility(0);
            this.dnp.setText(null);
            ml(8);
            this.dnw.getImage().setTag(null);
            this.dnq.setVisibility(8);
            this.dnq.setTag(null);
            this.dns.setVisibility(8);
            this.dns.setTag(null);
            this.dnt.setVisibility(8);
            this.dnu.setVisibility(8);
            this.dnv.setVisibility(8);
            this.dnB.setVisibility(8);
            return;
        }
        e(chatMessage);
        g(chatMessage);
        this.mName.setText("");
        f(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.csz.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.csz.c(str, 10, false);
            } else {
                this.csz.c(str, 12, false);
            }
            this.csz.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dnp.setVisibility(8);
            ml(8);
            this.dnq.setVisibility(8);
            this.dnr.setVisibility(8);
            this.dns.setVisibility(8);
            this.dnu.setVisibility(8);
            this.dnt.setVisibility(8);
            this.dnv.setVisibility(8);
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
            this.dnB.setVisibility(0);
        } else {
            this.dnB.setVisibility(8);
        }
    }

    private void g(ChatMessage chatMessage) {
        int i;
        if (this.dnx) {
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
            if (!this.dnx) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void ata() {
        if (this.dnx) {
            this.mName.setVisibility(0);
            this.aoa.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dnA.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dnA.setLayoutParams(marginLayoutParams);
        this.aoa.setVisibility(8);
    }
}
