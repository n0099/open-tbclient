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
    private HeadImageView cZB;
    private ViewGroup dRf;
    private ImageView dRg;
    private final TouchType dRh;
    View.OnLongClickListener dRi;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgleft_view);
        this.dRh = new TouchType();
        this.dRi = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MsgleftView.this.dRh.set(true);
                return true;
            }
        };
        this.adf = tbPageContext;
        initView();
        this.dRg = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.dRf = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.cZB = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cZB.setAutoChangeStyle(false);
        this.cZB.setDrawerType(1);
        this.cZB.setRadius(l.dip2px(this.adf.getContext(), 4.0f));
        this.apM = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.cZB.setLongClickable(true);
        this.cZB.setOnLongClickListener(this.dRi);
        this.cZB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long dRj = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.dRj = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.dRj > 200) {
                        if (MsgleftView.this.dRh.get()) {
                            MsgleftView.this.dQx.b(view2, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.dRh.set(false);
                        }
                    } else {
                        MsgleftView.this.dQw.a(view2, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.dQY.setIsLeft(true);
        this.dQZ.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view2, ChatMessage chatMessage) {
        String str = null;
        super.b(view2, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aAV();
        if (this.apM != null && this.dRc) {
            this.apM.setVisibility(0);
            this.apM.setAutoChangedStyle(false);
            Resources resources = this.adf.getResources();
            this.apM.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.dQU.setVisibility(0);
            this.dQU.setText(null);
            nh(8);
            this.dRb.getImage().setTag(null);
            this.dQV.setVisibility(8);
            this.dQV.setTag(null);
            this.dQX.setVisibility(8);
            this.dQX.setTag(null);
            this.dQY.setVisibility(8);
            this.dQZ.setVisibility(8);
            this.dRa.setVisibility(8);
            this.dRg.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.cZB.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.cZB.startLoad(str, 10, false);
            } else {
                this.cZB.startLoad(str, 12, false);
            }
            this.cZB.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.dQU.setVisibility(8);
            nh(8);
            this.dQV.setVisibility(8);
            this.dQW.setVisibility(8);
            this.dQX.setVisibility(8);
            this.dQZ.setVisibility(8);
            this.dQY.setVisibility(8);
            this.dRa.setVisibility(8);
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
            this.dRg.setVisibility(0);
        } else {
            this.dRg.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.dRc) {
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
            if (!this.dRc) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aAV() {
        if (this.dRc) {
            this.mName.setVisibility(0);
            this.apM.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dRf.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.dRf.setLayoutParams(marginLayoutParams);
        this.apM.setVisibility(8);
    }
}
