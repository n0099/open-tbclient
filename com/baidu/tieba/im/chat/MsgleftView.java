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
    private TbPageContext<MsglistActivity<?>> abI;
    private UserIconBox aoi;
    private HeadImageView cAd;
    View.OnLongClickListener dvA;
    private ViewGroup dvx;
    private ImageView dvy;
    private final TouchType dvz;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.dvz = new TouchType();
        this.dvA = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dvz.set(true);
                return true;
            }
        };
        this.abI = tbPageContext;
        initView();
        this.dvy = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.dvx = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.cAd = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cAd.setAutoChangeStyle(false);
        this.cAd.setDrawerType(1);
        this.cAd.setRadius(l.dip2px(this.abI.getContext(), 4.0f));
        this.aoi = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.cAd.setLongClickable(true);
        this.cAd.setOnLongClickListener(this.dvA);
        this.cAd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dvB = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dvB = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dvB > 200) {
                        if (MsgleftView.this.dvz.get()) {
                            MsgleftView.this.duP.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.dvz.set(false);
                        }
                    } else {
                        MsgleftView.this.duO.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.dvq.setIsLeft(true);
        this.dvr.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        avH();
        if (this.aoi != null && this.dvu) {
            this.aoi.setVisibility(0);
            this.aoi.setAutoChangedStyle(false);
            Resources resources = this.abI.getResources();
            this.aoi.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dvm.setVisibility(0);
            this.dvm.setText(null);
            mB(8);
            this.dvt.getImage().setTag(null);
            this.dvn.setVisibility(8);
            this.dvn.setTag(null);
            this.dvp.setVisibility(8);
            this.dvp.setTag(null);
            this.dvq.setVisibility(8);
            this.dvr.setVisibility(8);
            this.dvs.setVisibility(8);
            this.dvy.setVisibility(8);
            return;
        }
        f(chatMessage);
        h(chatMessage);
        this.mName.setText("");
        g(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.cAd.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.cAd.startLoad(str, 10, false);
            } else {
                this.cAd.startLoad(str, 12, false);
            }
            this.cAd.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dvm.setVisibility(8);
            mB(8);
            this.dvn.setVisibility(8);
            this.dvo.setVisibility(8);
            this.dvp.setVisibility(8);
            this.dvr.setVisibility(8);
            this.dvq.setVisibility(8);
            this.dvs.setVisibility(8);
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
            this.dvy.setVisibility(0);
        } else {
            this.dvy.setVisibility(8);
        }
    }

    private void h(ChatMessage chatMessage) {
        int i;
        if (this.dvu) {
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
            if (!this.dvu) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void avH() {
        if (this.dvu) {
            this.mName.setVisibility(0);
            this.aoi.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dvx.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dvx.setLayoutParams(marginLayoutParams);
        this.aoi.setVisibility(8);
    }
}
