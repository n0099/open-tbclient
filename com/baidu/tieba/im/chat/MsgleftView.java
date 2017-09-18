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
    private UserIconBox aoQ;
    private HeadImageView csc;
    private ViewGroup drl;
    private ImageView drm;
    private final TouchType drn;
    View.OnLongClickListener dro;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgleft_view);
        this.drn = new TouchType();
        this.dro = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.drn.set(true);
                return true;
            }
        };
        this.aby = tbPageContext;
        initView();
        this.drm = (ImageView) findViewById(d.h.iv_live_group_host);
        this.mName = (TextView) findViewById(d.h.tex_msgitem_name);
        this.drl = (ViewGroup) findViewById(d.h.box_msgitem_bubble);
        this.csc = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.csc.setAutoChangeStyle(false);
        this.csc.setDrawerType(1);
        this.csc.setRadius(k.dip2px(this.aby.getContext(), 4.0f));
        this.aoQ = (UserIconBox) findViewById(d.h.user_tshow_icon_box);
        this.csc.setLongClickable(true);
        this.csc.setOnLongClickListener(this.dro);
        this.csc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long drp = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.drp = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.drp > 200) {
                        if (MsgleftView.this.drn.get()) {
                            MsgleftView.this.dqD.b(view, 2, MsgleftView.this.avK, 0L);
                            MsgleftView.this.drn.set(false);
                        }
                    } else {
                        MsgleftView.this.dqC.a(view, 2, MsgleftView.this.avK, 0L);
                    }
                }
                return false;
            }
        });
        this.dre.setIsLeft(true);
        this.drf.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aup();
        if (this.aoQ != null && this.dri) {
            this.aoQ.setVisibility(0);
            this.aoQ.setAutoChangedStyle(false);
            Resources resources = this.aby.getResources();
            this.aoQ.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dra.setVisibility(0);
            this.dra.setText(null);
            mp(8);
            this.drh.getImage().setTag(null);
            this.drb.setVisibility(8);
            this.drb.setTag(null);
            this.drd.setVisibility(8);
            this.drd.setTag(null);
            this.dre.setVisibility(8);
            this.drf.setVisibility(8);
            this.drg.setVisibility(8);
            this.drm.setVisibility(8);
            return;
        }
        e(chatMessage);
        g(chatMessage);
        this.mName.setText("");
        f(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.csc.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.csc.c(str, 10, false);
            } else {
                this.csc.c(str, 12, false);
            }
            this.csc.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dra.setVisibility(8);
            mp(8);
            this.drb.setVisibility(8);
            this.drc.setVisibility(8);
            this.drd.setVisibility(8);
            this.drf.setVisibility(8);
            this.dre.setVisibility(8);
            this.drg.setVisibility(8);
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
            this.drm.setVisibility(0);
        } else {
            this.drm.setVisibility(8);
        }
    }

    private void g(ChatMessage chatMessage) {
        int i;
        if (this.dri) {
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
            if (!this.dri) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aup() {
        if (this.dri) {
            this.mName.setVisibility(0);
            this.aoQ.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.drl.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.drl.setLayoutParams(marginLayoutParams);
        this.aoQ.setVisibility(8);
    }
}
