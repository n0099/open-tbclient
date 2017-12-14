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
    private TbPageContext<MsglistActivity<?>> abX;
    private UserIconBox aox;
    private HeadImageView cJr;
    private ViewGroup dEo;
    private ImageView dEp;
    private final TouchType dEq;
    View.OnLongClickListener dEr;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.dEq = new TouchType();
        this.dEr = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dEq.set(true);
                return true;
            }
        };
        this.abX = tbPageContext;
        initView();
        this.dEp = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.dEo = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.cJr = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cJr.setAutoChangeStyle(false);
        this.cJr.setDrawerType(1);
        this.cJr.setRadius(l.dip2px(this.abX.getContext(), 4.0f));
        this.aox = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.cJr.setLongClickable(true);
        this.cJr.setOnLongClickListener(this.dEr);
        this.cJr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dEs = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dEs = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dEs > 200) {
                        if (MsgleftView.this.dEq.get()) {
                            MsgleftView.this.dDG.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.dEq.set(false);
                        }
                    } else {
                        MsgleftView.this.dDF.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.dEh.setIsLeft(true);
        this.dEi.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        axq();
        if (this.aox != null && this.dEl) {
            this.aox.setVisibility(0);
            this.aox.setAutoChangedStyle(false);
            Resources resources = this.abX.getResources();
            this.aox.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dEd.setVisibility(0);
            this.dEd.setText(null);
            mW(8);
            this.dEk.getImage().setTag(null);
            this.dEe.setVisibility(8);
            this.dEe.setTag(null);
            this.dEg.setVisibility(8);
            this.dEg.setTag(null);
            this.dEh.setVisibility(8);
            this.dEi.setVisibility(8);
            this.dEj.setVisibility(8);
            this.dEp.setVisibility(8);
            return;
        }
        f(chatMessage);
        h(chatMessage);
        this.mName.setText("");
        g(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.cJr.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.cJr.startLoad(str, 10, false);
            } else {
                this.cJr.startLoad(str, 12, false);
            }
            this.cJr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dEd.setVisibility(8);
            mW(8);
            this.dEe.setVisibility(8);
            this.dEf.setVisibility(8);
            this.dEg.setVisibility(8);
            this.dEi.setVisibility(8);
            this.dEh.setVisibility(8);
            this.dEj.setVisibility(8);
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

    private void g(ChatMessage chatMessage) {
        String string = b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.dEp.setVisibility(0);
        } else {
            this.dEp.setVisibility(8);
        }
    }

    private void h(ChatMessage chatMessage) {
        int i;
        if (this.dEl) {
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
            if (!this.dEl) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void axq() {
        if (this.dEl) {
            this.mName.setVisibility(0);
            this.aox.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dEo.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dEo.setLayoutParams(marginLayoutParams);
        this.aox.setVisibility(8);
    }
}
