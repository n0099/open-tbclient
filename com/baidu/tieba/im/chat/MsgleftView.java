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
    private UserIconBox aKT;
    private HeadImageView dOi;
    private ViewGroup eMc;
    private ImageView eMd;
    private final TouchType eMe;
    View.OnLongClickListener eMf;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgleft_view);
        this.eMe = new TouchType();
        this.eMf = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.eMe.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.eMd = (ImageView) findViewById(e.g.iv_live_group_host);
        this.mName = (TextView) findViewById(e.g.tex_msgitem_name);
        this.eMc = (ViewGroup) findViewById(e.g.box_msgitem_bubble);
        this.dOi = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dOi.setAutoChangeStyle(false);
        this.dOi.setDrawerType(1);
        this.dOi.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.aKT = (UserIconBox) findViewById(e.g.user_tshow_icon_box);
        this.dOi.setLongClickable(true);
        this.dOi.setOnLongClickListener(this.eMf);
        this.dOi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long eMg = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.eMg = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.eMg > 200) {
                        if (MsgleftView.this.eMe.get()) {
                            MsgleftView.this.eLu.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.eMe.set(false);
                        }
                    } else {
                        MsgleftView.this.eLt.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.eLV.setIsLeft(true);
        this.eLW.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aPC();
        if (this.aKT != null && this.eLZ) {
            this.aKT.setVisibility(0);
            this.aKT.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aKT.a(tShowInfoNew, 2, resources.getDimensionPixelSize(e.C0210e.ds32), resources.getDimensionPixelSize(e.C0210e.ds32), resources.getDimensionPixelSize(e.C0210e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.eLR.setVisibility(0);
            this.eLR.setText(null);
            pQ(8);
            this.eLY.getImage().setTag(null);
            this.eLS.setVisibility(8);
            this.eLS.setTag(null);
            this.eLU.setVisibility(8);
            this.eLU.setTag(null);
            this.eLV.setVisibility(8);
            this.eLW.setVisibility(8);
            this.eLX.setVisibility(8);
            this.eMd.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.dOi.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dOi.startLoad(str, 10, false);
            } else {
                this.dOi.startLoad(str, 12, false);
            }
            this.dOi.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.eLR.setVisibility(8);
            pQ(8);
            this.eLS.setVisibility(8);
            this.eLT.setVisibility(8);
            this.eLU.setVisibility(8);
            this.eLW.setVisibility(8);
            this.eLV.setVisibility(8);
            this.eLX.setVisibility(8);
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
            this.eMd.setVisibility(0);
        } else {
            this.eMd.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.eLZ) {
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
            if (!this.eLZ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aPC() {
        if (this.eLZ) {
            this.mName.setVisibility(0);
            this.aKT.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eMc.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.eMc.setLayoutParams(marginLayoutParams);
        this.aKT.setVisibility(8);
    }
}
