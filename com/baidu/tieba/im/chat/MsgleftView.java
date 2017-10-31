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
    private UserIconBox aoj;
    private HeadImageView czK;
    private ViewGroup dvd;
    private ImageView dve;
    private final TouchType dvf;
    View.OnLongClickListener dvg;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.dvf = new TouchType();
        this.dvg = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.dvf.set(true);
                return true;
            }
        };
        this.abI = tbPageContext;
        initView();
        this.dve = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.dvd = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.czK = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.czK.setAutoChangeStyle(false);
        this.czK.setDrawerType(1);
        this.czK.setRadius(l.dip2px(this.abI.getContext(), 4.0f));
        this.aoj = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.czK.setLongClickable(true);
        this.czK.setOnLongClickListener(this.dvg);
        this.czK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dvh = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dvh = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dvh > 200) {
                        if (MsgleftView.this.dvf.get()) {
                            MsgleftView.this.duv.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.dvf.set(false);
                        }
                    } else {
                        MsgleftView.this.duu.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.duW.setIsLeft(true);
        this.duX.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        avq();
        if (this.aoj != null && this.dva) {
            this.aoj.setVisibility(0);
            this.aoj.setAutoChangedStyle(false);
            Resources resources = this.abI.getResources();
            this.aoj.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.duS.setVisibility(0);
            this.duS.setText(null);
            mB(8);
            this.duZ.getImage().setTag(null);
            this.duT.setVisibility(8);
            this.duT.setTag(null);
            this.duV.setVisibility(8);
            this.duV.setTag(null);
            this.duW.setVisibility(8);
            this.duX.setVisibility(8);
            this.duY.setVisibility(8);
            this.dve.setVisibility(8);
            return;
        }
        f(chatMessage);
        h(chatMessage);
        this.mName.setText("");
        g(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.czK.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.czK.startLoad(str, 10, false);
            } else {
                this.czK.startLoad(str, 12, false);
            }
            this.czK.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.duS.setVisibility(8);
            mB(8);
            this.duT.setVisibility(8);
            this.duU.setVisibility(8);
            this.duV.setVisibility(8);
            this.duX.setVisibility(8);
            this.duW.setVisibility(8);
            this.duY.setVisibility(8);
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
            this.dve.setVisibility(0);
        } else {
            this.dve.setVisibility(8);
        }
    }

    private void h(ChatMessage chatMessage) {
        int i;
        if (this.dva) {
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
            if (!this.dva) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void avq() {
        if (this.dva) {
            this.mName.setVisibility(0);
            this.aoj.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dvd.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dvd.setLayoutParams(marginLayoutParams);
        this.aoj.setVisibility(8);
    }
}
