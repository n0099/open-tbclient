package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox MP;
    private TbPageContext<MsglistActivity<?>> cRe;
    private HeadImageView gpg;
    private ViewGroup hqV;
    private ImageView hqW;
    private final TouchType hqX;
    View.OnLongClickListener hqY;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.hqX = new TouchType();
        this.hqY = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.hqX.set(true);
                return true;
            }
        };
        this.cRe = tbPageContext;
        initView();
        this.hqW = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.hqV = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.gpg = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.gpg.setAutoChangeStyle(false);
        this.gpg.setDrawerType(1);
        this.gpg.setRadius(l.dip2px(this.cRe.getContext(), 4.0f));
        this.gpg.setPlaceHolder(1);
        this.MP = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.gpg.setLongClickable(true);
        this.gpg.setOnLongClickListener(this.hqY);
        this.gpg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long hqZ = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.hqZ = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.hqZ > 200) {
                        if (MsgleftView.this.hqX.get()) {
                            MsgleftView.this.hqp.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.hqX.set(false);
                        }
                    } else {
                        MsgleftView.this.hqo.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.hqO.setIsLeft(true);
        this.hqP.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bQK();
        if (this.MP != null && this.hqS) {
            this.MP.setVisibility(0);
            this.MP.setAutoChangedStyle(false);
            Resources resources = this.cRe.getResources();
            this.MP.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.hqK.setVisibility(0);
            this.hqK.setText(null);
            vV(8);
            this.hqR.getImage().setTag(null);
            this.hqL.setVisibility(8);
            this.hqL.setTag(null);
            this.hqN.setVisibility(8);
            this.hqN.setTag(null);
            this.hqO.setVisibility(8);
            this.hqP.setVisibility(8);
            this.hqQ.setVisibility(8);
            this.hqW.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.gpg.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.gpg.startLoad(str, 10, false);
            } else {
                this.gpg.startLoad(str, 12, false);
            }
            this.gpg.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.hqK.setVisibility(8);
            vV(8);
            this.hqL.setVisibility(8);
            this.hqM.setVisibility(8);
            this.hqN.setVisibility(8);
            this.hqP.setVisibility(8);
            this.hqO.setVisibility(8);
            this.hqQ.setVisibility(8);
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

    private void c(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.hqW.setVisibility(0);
        } else {
            this.hqW.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.hqS) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = R.drawable.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = R.drawable.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.hqS) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bQK() {
        if (this.hqS) {
            this.mName.setVisibility(0);
            this.MP.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hqV.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.hqV.setLayoutParams(marginLayoutParams);
        this.MP.setVisibility(8);
    }
}
