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
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox XN;
    private HeadImageView efW;
    private ViewGroup gCe;
    private ImageView gCf;
    private final TouchType gCg;
    View.OnLongClickListener gCh;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.gCg = new TouchType();
        this.gCh = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gCg.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.gCf = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.gCe = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.efW = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.efW.setAutoChangeStyle(false);
        this.efW.setDrawerType(1);
        this.efW.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.XN = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.efW.setLongClickable(true);
        this.efW.setOnLongClickListener(this.gCh);
        this.efW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gCi = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gCi = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gCi > 200) {
                        if (MsgleftView.this.gCg.get()) {
                            MsgleftView.this.gBw.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gCg.set(false);
                        }
                    } else {
                        MsgleftView.this.gBv.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gBX.setIsLeft(true);
        this.gBY.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bBA();
        if (this.XN != null && this.gCb) {
            this.XN.setVisibility(0);
            this.XN.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.XN.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gBT.setVisibility(0);
            this.gBT.setText(null);
            vk(8);
            this.gCa.getImage().setTag(null);
            this.gBU.setVisibility(8);
            this.gBU.setTag(null);
            this.gBW.setVisibility(8);
            this.gBW.setTag(null);
            this.gBX.setVisibility(8);
            this.gBY.setVisibility(8);
            this.gBZ.setVisibility(8);
            this.gCf.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.efW.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.efW.startLoad(str, 10, false);
            } else {
                this.efW.startLoad(str, 12, false);
            }
            this.efW.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gBT.setVisibility(8);
            vk(8);
            this.gBU.setVisibility(8);
            this.gBV.setVisibility(8);
            this.gBW.setVisibility(8);
            this.gBY.setVisibility(8);
            this.gBX.setVisibility(8);
            this.gBZ.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.gCf.setVisibility(0);
        } else {
            this.gCf.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.gCb) {
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
            if (!this.gCb) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bBA() {
        if (this.gCb) {
            this.mName.setVisibility(0);
            this.XN.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gCe.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gCe.setLayoutParams(marginLayoutParams);
        this.XN.setVisibility(8);
    }
}
