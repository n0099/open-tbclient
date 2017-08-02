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
    private TbPageContext<MsglistActivity<?>> aaS;
    private UserIconBox anT;
    private HeadImageView cjV;
    View.OnLongClickListener dgA;
    private ViewGroup dgx;
    private ImageView dgy;
    private final TouchType dgz;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgleft_view);
        this.dgz = new TouchType();
        this.dgA = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dgz.set(true);
                return true;
            }
        };
        this.aaS = tbPageContext;
        initView();
        this.dgy = (ImageView) findViewById(d.h.iv_live_group_host);
        this.mName = (TextView) findViewById(d.h.tex_msgitem_name);
        this.dgx = (ViewGroup) findViewById(d.h.box_msgitem_bubble);
        this.cjV = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.cjV.setAutoChangeStyle(false);
        this.cjV.setDrawerType(1);
        this.cjV.setRadius(k.dip2px(this.aaS.getContext(), 4.0f));
        this.anT = (UserIconBox) findViewById(d.h.user_tshow_icon_box);
        this.cjV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgleftView.this.dfO.a(view, 2, MsgleftView.this.avi, 0L);
            }
        });
        this.cjV.setLongClickable(true);
        this.cjV.setOnLongClickListener(this.dgA);
        this.cjV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MsgleftView.this.dgz.get() && motionEvent.getAction() == 1) {
                    MsgleftView.this.dfP.b(view, 2, MsgleftView.this.avi, 0L);
                    MsgleftView.this.dgz.set(false);
                }
                return false;
            }
        });
        this.dgq.setIsLeft(true);
        this.dgr.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        arI();
        if (this.anT != null && this.dgu) {
            this.anT.setVisibility(0);
            this.anT.setAutoChangedStyle(false);
            Resources resources = this.aaS.getResources();
            this.anT.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds32), resources.getDimensionPixelSize(d.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dgm.setVisibility(0);
            this.dgm.setText(null);
            lM(8);
            this.dgt.getImage().setTag(null);
            this.dgn.setVisibility(8);
            this.dgn.setTag(null);
            this.dgp.setVisibility(8);
            this.dgp.setTag(null);
            this.dgq.setVisibility(8);
            this.dgr.setVisibility(8);
            this.dgs.setVisibility(8);
            this.dgy.setVisibility(8);
            return;
        }
        e(chatMessage);
        g(chatMessage);
        this.mName.setText("");
        f(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.cjV.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.cjV.c(str, 10, false);
            } else {
                this.cjV.c(str, 12, false);
            }
            this.cjV.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dgm.setVisibility(8);
            lM(8);
            this.dgn.setVisibility(8);
            this.dgo.setVisibility(8);
            this.dgp.setVisibility(8);
            this.dgr.setVisibility(8);
            this.dgq.setVisibility(8);
            this.dgs.setVisibility(8);
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
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.dgy.setVisibility(0);
        } else {
            this.dgy.setVisibility(8);
        }
    }

    private void g(ChatMessage chatMessage) {
        int i;
        if (this.dgu) {
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
            if (!this.dgu) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void arI() {
        if (this.dgu) {
            this.mName.setVisibility(0);
            this.anT.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dgx.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dgx.setLayoutParams(marginLayoutParams);
        this.anT.setVisibility(8);
    }
}
