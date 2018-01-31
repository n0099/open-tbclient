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
    private TbPageContext<MsglistActivity<?>> aQs;
    private UserIconBox bcN;
    private HeadImageView dDL;
    private ViewGroup eso;
    private ImageView esp;
    private final TouchType esq;
    View.OnLongClickListener esr;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.esq = new TouchType();
        this.esr = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.esq.set(true);
                return true;
            }
        };
        this.aQs = tbPageContext;
        initView();
        this.esp = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.eso = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.dDL = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dDL.setAutoChangeStyle(false);
        this.dDL.setDrawerType(1);
        this.dDL.setRadius(l.dip2px(this.aQs.getContext(), 4.0f));
        this.bcN = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.dDL.setLongClickable(true);
        this.dDL.setOnLongClickListener(this.esr);
        this.dDL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long ess = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.ess = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.ess > 200) {
                        if (MsgleftView.this.esq.get()) {
                            MsgleftView.this.erG.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.esq.set(false);
                        }
                    } else {
                        MsgleftView.this.erF.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.esh.setIsLeft(true);
        this.esi.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aEB();
        if (this.bcN != null && this.esl) {
            this.bcN.setVisibility(0);
            this.bcN.setAutoChangedStyle(false);
            Resources resources = this.aQs.getResources();
            this.bcN.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.esd.setVisibility(0);
            this.esd.setText(null);
            pH(8);
            this.esk.getImage().setTag(null);
            this.ese.setVisibility(8);
            this.ese.setTag(null);
            this.esg.setVisibility(8);
            this.esg.setTag(null);
            this.esh.setVisibility(8);
            this.esi.setVisibility(8);
            this.esj.setVisibility(8);
            this.esp.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.dDL.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dDL.startLoad(str, 10, false);
            } else {
                this.dDL.startLoad(str, 12, false);
            }
            this.dDL.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.esd.setVisibility(8);
            pH(8);
            this.ese.setVisibility(8);
            this.esf.setVisibility(8);
            this.esg.setVisibility(8);
            this.esi.setVisibility(8);
            this.esh.setVisibility(8);
            this.esj.setVisibility(8);
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
        String string = b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.esp.setVisibility(0);
        } else {
            this.esp.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.esl) {
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
            if (!this.esl) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aEB() {
        if (this.esl) {
            this.mName.setVisibility(0);
            this.bcN.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eso.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.eso.setLayoutParams(marginLayoutParams);
        this.bcN.setVisibility(8);
    }
}
