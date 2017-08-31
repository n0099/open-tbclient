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
    private TbPageContext<MsglistActivity<?>> aby;
    private UserIconBox aoS;
    private HeadImageView crk;
    private ViewGroup dqq;
    private ImageView dqr;
    private final TouchType dqs;
    View.OnLongClickListener dqt;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgleft_view);
        this.dqs = new TouchType();
        this.dqt = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dqs.set(true);
                return true;
            }
        };
        this.aby = tbPageContext;
        initView();
        this.dqr = (ImageView) findViewById(d.h.iv_live_group_host);
        this.mName = (TextView) findViewById(d.h.tex_msgitem_name);
        this.dqq = (ViewGroup) findViewById(d.h.box_msgitem_bubble);
        this.crk = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.crk.setAutoChangeStyle(false);
        this.crk.setDrawerType(1);
        this.crk.setRadius(k.dip2px(this.aby.getContext(), 4.0f));
        this.aoS = (UserIconBox) findViewById(d.h.user_tshow_icon_box);
        this.crk.setLongClickable(true);
        this.crk.setOnLongClickListener(this.dqt);
        this.crk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dqu = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dqu = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dqu > 200) {
                        if (MsgleftView.this.dqs.get()) {
                            MsgleftView.this.dpI.b(view, 2, MsgleftView.this.avN, 0L);
                            MsgleftView.this.dqs.set(false);
                        }
                    } else {
                        MsgleftView.this.dpH.a(view, 2, MsgleftView.this.avN, 0L);
                    }
                }
                return false;
            }
        });
        this.dqj.setIsLeft(true);
        this.dqk.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aue();
        if (this.aoS != null && this.dqn) {
            this.aoS.setVisibility(0);
            this.aoS.setAutoChangedStyle(false);
            Resources resources = this.aby.getResources();
            this.aoS.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dqf.setVisibility(0);
            this.dqf.setText(null);
            mn(8);
            this.dqm.getImage().setTag(null);
            this.dqg.setVisibility(8);
            this.dqg.setTag(null);
            this.dqi.setVisibility(8);
            this.dqi.setTag(null);
            this.dqj.setVisibility(8);
            this.dqk.setVisibility(8);
            this.dql.setVisibility(8);
            this.dqr.setVisibility(8);
            return;
        }
        e(chatMessage);
        g(chatMessage);
        this.mName.setText("");
        f(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.crk.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.crk.c(str, 10, false);
            } else {
                this.crk.c(str, 12, false);
            }
            this.crk.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dqf.setVisibility(8);
            mn(8);
            this.dqg.setVisibility(8);
            this.dqh.setVisibility(8);
            this.dqi.setVisibility(8);
            this.dqk.setVisibility(8);
            this.dqj.setVisibility(8);
            this.dql.setVisibility(8);
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
            this.dqr.setVisibility(0);
        } else {
            this.dqr.setVisibility(8);
        }
    }

    private void g(ChatMessage chatMessage) {
        int i;
        if (this.dqn) {
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
            if (!this.dqn) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aue() {
        if (this.dqn) {
            this.mName.setVisibility(0);
            this.aoS.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dqq.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dqq.setLayoutParams(marginLayoutParams);
        this.aoS.setVisibility(8);
    }
}
