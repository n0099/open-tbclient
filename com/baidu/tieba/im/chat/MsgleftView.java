package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> aRG;
    private UserIconBox bes;
    private HeadImageView dGC;
    private ViewGroup ewm;
    private ImageView ewn;
    private final TouchType ewo;
    View.OnLongClickListener ewp;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.ewo = new TouchType();
        this.ewp = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.ewo.set(true);
                return true;
            }
        };
        this.aRG = tbPageContext;
        initView();
        this.ewn = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.ewm = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.dGC = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dGC.setAutoChangeStyle(false);
        this.dGC.setDrawerType(1);
        this.dGC.setRadius(l.dip2px(this.aRG.getContext(), 4.0f));
        this.bes = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.dGC.setLongClickable(true);
        this.dGC.setOnLongClickListener(this.ewp);
        this.dGC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long ewq = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.ewq = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.ewq > 200) {
                        if (MsgleftView.this.ewo.get()) {
                            MsgleftView.this.evE.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.ewo.set(false);
                        }
                    } else {
                        MsgleftView.this.evD.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.ewf.setIsLeft(true);
        this.ewg.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aFU();
        if (this.bes != null && this.ewj) {
            this.bes.setVisibility(0);
            this.bes.setAutoChangedStyle(false);
            Resources resources = this.aRG.getResources();
            this.bes.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.ewb.setVisibility(0);
            this.ewb.setText(null);
            pI(8);
            this.ewi.getImage().setTag(null);
            this.ewc.setVisibility(8);
            this.ewc.setTag(null);
            this.ewe.setVisibility(8);
            this.ewe.setTag(null);
            this.ewf.setVisibility(8);
            this.ewg.setVisibility(8);
            this.ewh.setVisibility(8);
            this.ewn.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.dGC.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dGC.startLoad(str, 10, false);
            } else {
                this.dGC.startLoad(str, 12, false);
            }
            this.dGC.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.ewb.setVisibility(8);
            pI(8);
            this.ewc.setVisibility(8);
            this.ewd.setVisibility(8);
            this.ewe.setVisibility(8);
            this.ewg.setVisibility(8);
            this.ewf.setVisibility(8);
            this.ewh.setVisibility(8);
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

    private void h(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.ewn.setVisibility(0);
        } else {
            this.ewn.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.ewj) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = d.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = d.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.ewj) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aFU() {
        if (this.ewj) {
            this.mName.setVisibility(0);
            this.bes.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ewm.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.ewm.setLayoutParams(marginLayoutParams);
        this.bes.setVisibility(8);
    }
}
