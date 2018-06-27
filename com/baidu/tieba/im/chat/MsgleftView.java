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
    private UserIconBox ayK;
    private HeadImageView dmh;
    private ViewGroup eht;
    private ImageView ehu;
    private final TouchType ehv;
    View.OnLongClickListener ehw;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgleft_view);
        this.ehv = new TouchType();
        this.ehw = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.ehv.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.ehu = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.eht = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.dmh = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dmh.setAutoChangeStyle(false);
        this.dmh.setDrawerType(1);
        this.dmh.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.ayK = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.dmh.setLongClickable(true);
        this.dmh.setOnLongClickListener(this.ehw);
        this.dmh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long ehx = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.ehx = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.ehx > 200) {
                        if (MsgleftView.this.ehv.get()) {
                            MsgleftView.this.egL.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.ehv.set(false);
                        }
                    } else {
                        MsgleftView.this.egK.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.ehm.setIsLeft(true);
        this.ehn.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aGw();
        if (this.ayK != null && this.ehq) {
            this.ayK.setVisibility(0);
            this.ayK.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.ayK.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.ehi.setVisibility(0);
            this.ehi.setText(null);
            nz(8);
            this.ehp.getImage().setTag(null);
            this.ehj.setVisibility(8);
            this.ehj.setTag(null);
            this.ehl.setVisibility(8);
            this.ehl.setTag(null);
            this.ehm.setVisibility(8);
            this.ehn.setVisibility(8);
            this.eho.setVisibility(8);
            this.ehu.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.dmh.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dmh.startLoad(str, 10, false);
            } else {
                this.dmh.startLoad(str, 12, false);
            }
            this.dmh.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.ehi.setVisibility(8);
            nz(8);
            this.ehj.setVisibility(8);
            this.ehk.setVisibility(8);
            this.ehl.setVisibility(8);
            this.ehn.setVisibility(8);
            this.ehm.setVisibility(8);
            this.eho.setVisibility(8);
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
            this.ehu.setVisibility(0);
        } else {
            this.ehu.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.ehq) {
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
            if (!this.ehq) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aGw() {
        if (this.ehq) {
            this.mName.setVisibility(0);
            this.ayK.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eht.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.eht.setLayoutParams(marginLayoutParams);
        this.ayK.setVisibility(8);
    }
}
