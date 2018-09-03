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
import com.baidu.tieba.f;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox ayu;
    private HeadImageView doX;
    private ViewGroup elf;
    private ImageView elg;
    private final TouchType elh;
    View.OnLongClickListener eli;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, f.h.msg_msgleft_view);
        this.elh = new TouchType();
        this.eli = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.elh.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.elg = (ImageView) findViewById(f.g.iv_live_group_host);
        this.mName = (TextView) findViewById(f.g.tex_msgitem_name);
        this.elf = (ViewGroup) findViewById(f.g.box_msgitem_bubble);
        this.doX = (HeadImageView) findViewById(f.g.img_msgitem_photo);
        this.doX.setAutoChangeStyle(false);
        this.doX.setDrawerType(1);
        this.doX.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.ayu = (UserIconBox) findViewById(f.g.user_tshow_icon_box);
        this.doX.setLongClickable(true);
        this.doX.setOnLongClickListener(this.eli);
        this.doX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long elj = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.elj = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.elj > 200) {
                        if (MsgleftView.this.elh.get()) {
                            MsgleftView.this.ekx.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.elh.set(false);
                        }
                    } else {
                        MsgleftView.this.ekw.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.ekY.setIsLeft(true);
        this.ekZ.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aHt();
        if (this.ayu != null && this.elc) {
            this.ayu.setVisibility(0);
            this.ayu.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.ayu.a(tShowInfoNew, 2, resources.getDimensionPixelSize(f.e.ds32), resources.getDimensionPixelSize(f.e.ds32), resources.getDimensionPixelSize(f.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.ekU.setVisibility(0);
            this.ekU.setText(null);
            nN(8);
            this.elb.getImage().setTag(null);
            this.ekV.setVisibility(8);
            this.ekV.setTag(null);
            this.ekX.setVisibility(8);
            this.ekX.setTag(null);
            this.ekY.setVisibility(8);
            this.ekZ.setVisibility(8);
            this.ela.setVisibility(8);
            this.elg.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.doX.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.doX.startLoad(str, 10, false);
            } else {
                this.doX.startLoad(str, 12, false);
            }
            this.doX.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.ekU.setVisibility(8);
            nN(8);
            this.ekV.setVisibility(8);
            this.ekW.setVisibility(8);
            this.ekX.setVisibility(8);
            this.ekZ.setVisibility(8);
            this.ekY.setVisibility(8);
            this.ela.setVisibility(8);
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
            this.elg.setVisibility(0);
        } else {
            this.elg.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.elc) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = f.C0146f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = f.C0146f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.elc) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aHt() {
        if (this.elc) {
            this.mName.setVisibility(0);
            this.ayu.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.elf.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.elf.setLayoutParams(marginLayoutParams);
        this.ayu.setVisibility(8);
    }
}
