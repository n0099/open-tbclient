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
    private UserIconBox ZC;
    private HeadImageView fbF;
    private ViewGroup gbR;
    private ImageView gbS;
    private final TouchType gbT;
    View.OnLongClickListener gbU;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.gbT = new TouchType();
        this.gbU = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gbT.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.gbS = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.gbR = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.fbF = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.fbF.setAutoChangeStyle(false);
        this.fbF.setDrawerType(1);
        this.fbF.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.ZC = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.fbF.setLongClickable(true);
        this.fbF.setOnLongClickListener(this.gbU);
        this.fbF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gbV = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gbV = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gbV > 200) {
                        if (MsgleftView.this.gbT.get()) {
                            MsgleftView.this.gbj.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gbT.set(false);
                        }
                    } else {
                        MsgleftView.this.gbi.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gbK.setIsLeft(true);
        this.gbL.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bqe();
        if (this.ZC != null && this.gbO) {
            this.ZC.setVisibility(0);
            this.ZC.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.ZC.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gbG.setVisibility(0);
            this.gbG.setText(null);
            tw(8);
            this.gbN.getImage().setTag(null);
            this.gbH.setVisibility(8);
            this.gbH.setTag(null);
            this.gbJ.setVisibility(8);
            this.gbJ.setTag(null);
            this.gbK.setVisibility(8);
            this.gbL.setVisibility(8);
            this.gbM.setVisibility(8);
            this.gbS.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.fbF.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.fbF.startLoad(str, 10, false);
            } else {
                this.fbF.startLoad(str, 12, false);
            }
            this.fbF.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gbG.setVisibility(8);
            tw(8);
            this.gbH.setVisibility(8);
            this.gbI.setVisibility(8);
            this.gbJ.setVisibility(8);
            this.gbL.setVisibility(8);
            this.gbK.setVisibility(8);
            this.gbM.setVisibility(8);
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
            this.gbS.setVisibility(0);
        } else {
            this.gbS.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.gbO) {
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
            if (!this.gbO) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bqe() {
        if (this.gbO) {
            this.mName.setVisibility(0);
            this.ZC.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gbR.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gbR.setLayoutParams(marginLayoutParams);
        this.ZC.setVisibility(8);
    }
}
