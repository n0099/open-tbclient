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
    private TbPageContext<MsglistActivity<?>> adf;
    private UserIconBox apM;
    private HeadImageView cZE;
    private ViewGroup dRi;
    private ImageView dRj;
    private final TouchType dRk;
    View.OnLongClickListener dRl;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgleft_view);
        this.dRk = new TouchType();
        this.dRl = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MsgleftView.this.dRk.set(true);
                return true;
            }
        };
        this.adf = tbPageContext;
        initView();
        this.dRj = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.dRi = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.cZE = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cZE.setAutoChangeStyle(false);
        this.cZE.setDrawerType(1);
        this.cZE.setRadius(l.dip2px(this.adf.getContext(), 4.0f));
        this.apM = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.cZE.setLongClickable(true);
        this.cZE.setOnLongClickListener(this.dRl);
        this.cZE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dRm = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dRm = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dRm > 200) {
                        if (MsgleftView.this.dRk.get()) {
                            MsgleftView.this.dQA.b(view2, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.dRk.set(false);
                        }
                    } else {
                        MsgleftView.this.dQz.a(view2, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.dRb.setIsLeft(true);
        this.dRc.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view2, ChatMessage chatMessage) {
        String str = null;
        super.b(view2, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aAV();
        if (this.apM != null && this.dRf) {
            this.apM.setVisibility(0);
            this.apM.setAutoChangedStyle(false);
            Resources resources = this.adf.getResources();
            this.apM.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dQX.setVisibility(0);
            this.dQX.setText(null);
            ni(8);
            this.dRe.getImage().setTag(null);
            this.dQY.setVisibility(8);
            this.dQY.setTag(null);
            this.dRa.setVisibility(8);
            this.dRa.setTag(null);
            this.dRb.setVisibility(8);
            this.dRc.setVisibility(8);
            this.dRd.setVisibility(8);
            this.dRj.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.cZE.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.cZE.startLoad(str, 10, false);
            } else {
                this.cZE.startLoad(str, 12, false);
            }
            this.cZE.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dQX.setVisibility(8);
            ni(8);
            this.dQY.setVisibility(8);
            this.dQZ.setVisibility(8);
            this.dRa.setVisibility(8);
            this.dRc.setVisibility(8);
            this.dRb.setVisibility(8);
            this.dRd.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view2, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    return;
                case 4:
                    a(chatMessage, false);
                    return;
                case 5:
                    b(view2, chatMessage, TAG);
                    return;
                case 6:
                case 7:
                case 8:
                default:
                    return;
                case 9:
                    c(view2, chatMessage, TAG);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void h(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.dRj.setVisibility(0);
        } else {
            this.dRj.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.dRf) {
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
            if (!this.dRf) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aAV() {
        if (this.dRf) {
            this.mName.setVisibility(0);
            this.apM.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dRi.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dRi.setLayoutParams(marginLayoutParams);
        this.apM.setVisibility(8);
    }
}
