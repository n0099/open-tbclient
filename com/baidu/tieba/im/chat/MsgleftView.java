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
    private TbPageContext<MsglistActivity<?>> aQp;
    private UserIconBox bcF;
    private HeadImageView dDq;
    private ViewGroup erT;
    private ImageView erU;
    private final TouchType erV;
    View.OnLongClickListener erW;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.erV = new TouchType();
        this.erW = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.erV.set(true);
                return true;
            }
        };
        this.aQp = tbPageContext;
        initView();
        this.erU = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.erT = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.dDq = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dDq.setAutoChangeStyle(false);
        this.dDq.setDrawerType(1);
        this.dDq.setRadius(l.dip2px(this.aQp.getContext(), 4.0f));
        this.bcF = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.dDq.setLongClickable(true);
        this.dDq.setOnLongClickListener(this.erW);
        this.dDq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long erX = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.erX = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.erX > 200) {
                        if (MsgleftView.this.erV.get()) {
                            MsgleftView.this.erk.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.erV.set(false);
                        }
                    } else {
                        MsgleftView.this.erj.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.erM.setIsLeft(true);
        this.erN.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aEw();
        if (this.bcF != null && this.erQ) {
            this.bcF.setVisibility(0);
            this.bcF.setAutoChangedStyle(false);
            Resources resources = this.aQp.getResources();
            this.bcF.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.erI.setVisibility(0);
            this.erI.setText(null);
            pH(8);
            this.erP.getImage().setTag(null);
            this.erJ.setVisibility(8);
            this.erJ.setTag(null);
            this.erL.setVisibility(8);
            this.erL.setTag(null);
            this.erM.setVisibility(8);
            this.erN.setVisibility(8);
            this.erO.setVisibility(8);
            this.erU.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.dDq.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dDq.startLoad(str, 10, false);
            } else {
                this.dDq.startLoad(str, 12, false);
            }
            this.dDq.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.erI.setVisibility(8);
            pH(8);
            this.erJ.setVisibility(8);
            this.erK.setVisibility(8);
            this.erL.setVisibility(8);
            this.erN.setVisibility(8);
            this.erM.setVisibility(8);
            this.erO.setVisibility(8);
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
        String string = b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.erU.setVisibility(0);
        } else {
            this.erU.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.erQ) {
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
            if (!this.erQ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aEw() {
        if (this.erQ) {
            this.mName.setVisibility(0);
            this.bcF.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.erT.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.erT.setLayoutParams(marginLayoutParams);
        this.bcF.setVisibility(8);
    }
}
