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
    private UserIconBox aGO;
    private HeadImageView dEl;
    private ViewGroup eBJ;
    private ImageView eBK;
    private final TouchType eBL;
    View.OnLongClickListener eBM;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgleft_view);
        this.eBL = new TouchType();
        this.eBM = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.eBL.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.eBK = (ImageView) findViewById(e.g.iv_live_group_host);
        this.mName = (TextView) findViewById(e.g.tex_msgitem_name);
        this.eBJ = (ViewGroup) findViewById(e.g.box_msgitem_bubble);
        this.dEl = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dEl.setAutoChangeStyle(false);
        this.dEl.setDrawerType(1);
        this.dEl.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.aGO = (UserIconBox) findViewById(e.g.user_tshow_icon_box);
        this.dEl.setLongClickable(true);
        this.dEl.setOnLongClickListener(this.eBM);
        this.dEl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long eBN = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.eBN = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.eBN > 200) {
                        if (MsgleftView.this.eBL.get()) {
                            MsgleftView.this.eBb.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.eBL.set(false);
                        }
                    } else {
                        MsgleftView.this.eBa.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.eBC.setIsLeft(true);
        this.eBD.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aMx();
        if (this.aGO != null && this.eBG) {
            this.aGO.setVisibility(0);
            this.aGO.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aGO.a(tShowInfoNew, 2, resources.getDimensionPixelSize(e.C0200e.ds32), resources.getDimensionPixelSize(e.C0200e.ds32), resources.getDimensionPixelSize(e.C0200e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.eBy.setVisibility(0);
            this.eBy.setText(null);
            ph(8);
            this.eBF.getImage().setTag(null);
            this.eBz.setVisibility(8);
            this.eBz.setTag(null);
            this.eBB.setVisibility(8);
            this.eBB.setTag(null);
            this.eBC.setVisibility(8);
            this.eBD.setVisibility(8);
            this.eBE.setVisibility(8);
            this.eBK.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.dEl.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dEl.startLoad(str, 10, false);
            } else {
                this.dEl.startLoad(str, 12, false);
            }
            this.dEl.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.eBy.setVisibility(8);
            ph(8);
            this.eBz.setVisibility(8);
            this.eBA.setVisibility(8);
            this.eBB.setVisibility(8);
            this.eBD.setVisibility(8);
            this.eBC.setVisibility(8);
            this.eBE.setVisibility(8);
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
            this.eBK.setVisibility(0);
        } else {
            this.eBK.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.eBG) {
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
            if (!this.eBG) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aMx() {
        if (this.eBG) {
            this.mName.setVisibility(0);
            this.aGO.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eBJ.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.eBJ.setLayoutParams(marginLayoutParams);
        this.aGO.setVisibility(8);
    }
}
