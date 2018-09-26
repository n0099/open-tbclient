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
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox aBs;
    private HeadImageView duU;
    private ImageView esA;
    private final TouchType esB;
    View.OnLongClickListener esC;
    private ViewGroup esz;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgleft_view);
        this.esB = new TouchType();
        this.esC = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.esB.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.esA = (ImageView) findViewById(e.g.iv_live_group_host);
        this.mName = (TextView) findViewById(e.g.tex_msgitem_name);
        this.esz = (ViewGroup) findViewById(e.g.box_msgitem_bubble);
        this.duU = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.duU.setAutoChangeStyle(false);
        this.duU.setDrawerType(1);
        this.duU.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.aBs = (UserIconBox) findViewById(e.g.user_tshow_icon_box);
        this.duU.setLongClickable(true);
        this.duU.setOnLongClickListener(this.esC);
        this.duU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long esD = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.esD = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.esD > 200) {
                        if (MsgleftView.this.esB.get()) {
                            MsgleftView.this.erR.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.esB.set(false);
                        }
                    } else {
                        MsgleftView.this.erQ.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.ess.setIsLeft(true);
        this.est.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aJI();
        if (this.aBs != null && this.esw) {
            this.aBs.setVisibility(0);
            this.aBs.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aBs.a(tShowInfoNew, 2, resources.getDimensionPixelSize(e.C0141e.ds32), resources.getDimensionPixelSize(e.C0141e.ds32), resources.getDimensionPixelSize(e.C0141e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.eso.setVisibility(0);
            this.eso.setText(null);
            or(8);
            this.esv.getImage().setTag(null);
            this.esp.setVisibility(8);
            this.esp.setTag(null);
            this.esr.setVisibility(8);
            this.esr.setTag(null);
            this.ess.setVisibility(8);
            this.est.setVisibility(8);
            this.esu.setVisibility(8);
            this.esA.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.duU.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.duU.startLoad(str, 10, false);
            } else {
                this.duU.startLoad(str, 12, false);
            }
            this.duU.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.eso.setVisibility(8);
            or(8);
            this.esp.setVisibility(8);
            this.esq.setVisibility(8);
            this.esr.setVisibility(8);
            this.est.setVisibility(8);
            this.ess.setVisibility(8);
            this.esu.setVisibility(8);
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
            this.esA.setVisibility(0);
        } else {
            this.esA.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.esw) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = e.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = e.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.esw) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aJI() {
        if (this.esw) {
            this.mName.setVisibility(0);
            this.aBs.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.esz.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.esz.setLayoutParams(marginLayoutParams);
        this.aBs.setVisibility(8);
    }
}
