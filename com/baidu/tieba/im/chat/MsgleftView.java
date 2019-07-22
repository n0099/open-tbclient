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
    private UserIconBox XO;
    private HeadImageView eef;
    private ViewGroup gzv;
    private ImageView gzw;
    private final TouchType gzx;
    View.OnLongClickListener gzy;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.gzx = new TouchType();
        this.gzy = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gzx.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.gzw = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.gzv = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.eef = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.eef.setAutoChangeStyle(false);
        this.eef.setDrawerType(1);
        this.eef.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.XO = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.eef.setLongClickable(true);
        this.eef.setOnLongClickListener(this.gzy);
        this.eef.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gzz = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gzz = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gzz > 200) {
                        if (MsgleftView.this.gzx.get()) {
                            MsgleftView.this.gyN.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gzx.set(false);
                        }
                    } else {
                        MsgleftView.this.gyM.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gzo.setIsLeft(true);
        this.gzp.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bAy();
        if (this.XO != null && this.gzs) {
            this.XO.setVisibility(0);
            this.XO.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.XO.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gzk.setVisibility(0);
            this.gzk.setText(null);
            ve(8);
            this.gzr.getImage().setTag(null);
            this.gzl.setVisibility(8);
            this.gzl.setTag(null);
            this.gzn.setVisibility(8);
            this.gzn.setTag(null);
            this.gzo.setVisibility(8);
            this.gzp.setVisibility(8);
            this.gzq.setVisibility(8);
            this.gzw.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.eef.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.eef.startLoad(str, 10, false);
            } else {
                this.eef.startLoad(str, 12, false);
            }
            this.eef.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gzk.setVisibility(8);
            ve(8);
            this.gzl.setVisibility(8);
            this.gzm.setVisibility(8);
            this.gzn.setVisibility(8);
            this.gzp.setVisibility(8);
            this.gzo.setVisibility(8);
            this.gzq.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.gzw.setVisibility(0);
        } else {
            this.gzw.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.gzs) {
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
            if (!this.gzs) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bAy() {
        if (this.gzs) {
            this.mName.setVisibility(0);
            this.XO.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gzv.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gzv.setLayoutParams(marginLayoutParams);
        this.XO.setVisibility(8);
    }
}
