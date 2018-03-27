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
    private TbPageContext<MsglistActivity<?>> aRI;
    private UserIconBox bew;
    private HeadImageView dGH;
    private ViewGroup ewC;
    private ImageView ewD;
    private final TouchType ewE;
    View.OnLongClickListener ewF;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.ewE = new TouchType();
        this.ewF = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.ewE.set(true);
                return true;
            }
        };
        this.aRI = tbPageContext;
        initView();
        this.ewD = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.ewC = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.dGH = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dGH.setAutoChangeStyle(false);
        this.dGH.setDrawerType(1);
        this.dGH.setRadius(l.dip2px(this.aRI.getContext(), 4.0f));
        this.bew = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.dGH.setLongClickable(true);
        this.dGH.setOnLongClickListener(this.ewF);
        this.dGH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long ewG = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.ewG = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.ewG > 200) {
                        if (MsgleftView.this.ewE.get()) {
                            MsgleftView.this.evU.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.ewE.set(false);
                        }
                    } else {
                        MsgleftView.this.evT.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.ewv.setIsLeft(true);
        this.eww.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aFV();
        if (this.bew != null && this.ewz) {
            this.bew.setVisibility(0);
            this.bew.setAutoChangedStyle(false);
            Resources resources = this.aRI.getResources();
            this.bew.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.ewr.setVisibility(0);
            this.ewr.setText(null);
            pJ(8);
            this.ewy.getImage().setTag(null);
            this.ews.setVisibility(8);
            this.ews.setTag(null);
            this.ewu.setVisibility(8);
            this.ewu.setTag(null);
            this.ewv.setVisibility(8);
            this.eww.setVisibility(8);
            this.ewx.setVisibility(8);
            this.ewD.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.dGH.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dGH.startLoad(str, 10, false);
            } else {
                this.dGH.startLoad(str, 12, false);
            }
            this.dGH.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.ewr.setVisibility(8);
            pJ(8);
            this.ews.setVisibility(8);
            this.ewt.setVisibility(8);
            this.ewu.setVisibility(8);
            this.eww.setVisibility(8);
            this.ewv.setVisibility(8);
            this.ewx.setVisibility(8);
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
            this.ewD.setVisibility(0);
        } else {
            this.ewD.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.ewz) {
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
            if (!this.ewz) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aFV() {
        if (this.ewz) {
            this.mName.setVisibility(0);
            this.bew.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ewC.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.ewC.setLayoutParams(marginLayoutParams);
        this.bew.setVisibility(8);
    }
}
