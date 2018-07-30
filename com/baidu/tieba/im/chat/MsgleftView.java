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
    private UserIconBox ayx;
    private HeadImageView doZ;
    private ViewGroup elj;
    private ImageView elk;
    private final TouchType ell;
    View.OnLongClickListener elm;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.ell = new TouchType();
        this.elm = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.ell.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.elk = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.elj = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.doZ = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.doZ.setAutoChangeStyle(false);
        this.doZ.setDrawerType(1);
        this.doZ.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.ayx = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.doZ.setLongClickable(true);
        this.doZ.setOnLongClickListener(this.elm);
        this.doZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long eln = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.eln = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.eln > 200) {
                        if (MsgleftView.this.ell.get()) {
                            MsgleftView.this.ekB.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.ell.set(false);
                        }
                    } else {
                        MsgleftView.this.ekA.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.elc.setIsLeft(true);
        this.eld.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aHw();
        if (this.ayx != null && this.elg) {
            this.ayx.setVisibility(0);
            this.ayx.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.ayx.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.ekY.setVisibility(0);
            this.ekY.setText(null);
            nN(8);
            this.elf.getImage().setTag(null);
            this.ekZ.setVisibility(8);
            this.ekZ.setTag(null);
            this.elb.setVisibility(8);
            this.elb.setTag(null);
            this.elc.setVisibility(8);
            this.eld.setVisibility(8);
            this.ele.setVisibility(8);
            this.elk.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.doZ.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.doZ.startLoad(str, 10, false);
            } else {
                this.doZ.startLoad(str, 12, false);
            }
            this.doZ.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.ekY.setVisibility(8);
            nN(8);
            this.ekZ.setVisibility(8);
            this.ela.setVisibility(8);
            this.elb.setVisibility(8);
            this.eld.setVisibility(8);
            this.elc.setVisibility(8);
            this.ele.setVisibility(8);
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
            this.elk.setVisibility(0);
        } else {
            this.elk.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.elg) {
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
            if (!this.elg) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aHw() {
        if (this.elg) {
            this.mName.setVisibility(0);
            this.ayx.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.elj.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.elj.setLayoutParams(marginLayoutParams);
        this.ayx.setVisibility(8);
    }
}
