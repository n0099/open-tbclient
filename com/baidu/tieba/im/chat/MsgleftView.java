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
    private UserIconBox No;
    private TbPageContext<MsglistActivity<?>> cVg;
    private HeadImageView grh;
    private ViewGroup hsU;
    private ImageView hsV;
    private final TouchType hsW;
    View.OnLongClickListener hsX;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.hsW = new TouchType();
        this.hsX = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.hsW.set(true);
                return true;
            }
        };
        this.cVg = tbPageContext;
        initView();
        this.hsV = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.hsU = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.grh = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.grh.setAutoChangeStyle(false);
        this.grh.setDrawerType(1);
        this.grh.setRadius(l.dip2px(this.cVg.getContext(), 4.0f));
        this.grh.setPlaceHolder(1);
        this.No = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.grh.setLongClickable(true);
        this.grh.setOnLongClickListener(this.hsX);
        this.grh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long hsY = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.hsY = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.hsY > 200) {
                        if (MsgleftView.this.hsW.get()) {
                            MsgleftView.this.hso.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.hsW.set(false);
                        }
                    } else {
                        MsgleftView.this.hsn.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.hsN.setIsLeft(true);
        this.hsO.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bSl();
        if (this.No != null && this.hsR) {
            this.No.setVisibility(0);
            this.No.setAutoChangedStyle(false);
            Resources resources = this.cVg.getResources();
            this.No.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.hsJ.setVisibility(0);
            this.hsJ.setText(null);
            wb(8);
            this.hsQ.getImage().setTag(null);
            this.hsK.setVisibility(8);
            this.hsK.setTag(null);
            this.hsM.setVisibility(8);
            this.hsM.setTag(null);
            this.hsN.setVisibility(8);
            this.hsO.setVisibility(8);
            this.hsP.setVisibility(8);
            this.hsV.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.grh.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.grh.startLoad(str, 10, false);
            } else {
                this.grh.startLoad(str, 12, false);
            }
            this.grh.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.hsJ.setVisibility(8);
            wb(8);
            this.hsK.setVisibility(8);
            this.hsL.setVisibility(8);
            this.hsM.setVisibility(8);
            this.hsO.setVisibility(8);
            this.hsN.setVisibility(8);
            this.hsP.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.hsV.setVisibility(0);
        } else {
            this.hsV.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.hsR) {
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
            if (!this.hsR) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bSl() {
        if (this.hsR) {
            this.mName.setVisibility(0);
            this.No.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hsU.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.hsU.setLayoutParams(marginLayoutParams);
        this.No.setVisibility(8);
    }
}
