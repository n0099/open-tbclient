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
    private UserIconBox ahD;
    private TbPageContext<MsglistActivity<?>> dPv;
    private HeadImageView hDg;
    private ViewGroup iLd;
    private ImageView iLe;
    private final TouchType iLf;
    View.OnLongClickListener iLg;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.iLf = new TouchType();
        this.iLg = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.iLf.set(true);
                return true;
            }
        };
        this.dPv = tbPageContext;
        initView();
        this.iLe = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.iLd = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.hDg = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hDg.setAutoChangeStyle(false);
        this.hDg.setDrawerType(1);
        this.hDg.setRadius(l.dip2px(this.dPv.getContext(), 4.0f));
        this.hDg.setPlaceHolder(1);
        this.ahD = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.hDg.setLongClickable(true);
        this.hDg.setOnLongClickListener(this.iLg);
        this.hDg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long iLh = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.iLh = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.iLh > 200) {
                        if (MsgleftView.this.iLf.get()) {
                            MsgleftView.this.iKx.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.iLf.set(false);
                        }
                    } else {
                        MsgleftView.this.iKw.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.iKW.setIsLeft(true);
        this.iKX.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cnB();
        if (this.ahD != null && this.iLa) {
            this.ahD.setVisibility(0);
            this.ahD.setAutoChangedStyle(false);
            Resources resources = this.dPv.getResources();
            this.ahD.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.iKS.setVisibility(0);
            this.iKS.setText(null);
            xZ(8);
            this.iKZ.getImage().setTag(null);
            this.iKT.setVisibility(8);
            this.iKT.setTag(null);
            this.iKV.setVisibility(8);
            this.iKV.setTag(null);
            this.iKW.setVisibility(8);
            this.iKX.setVisibility(8);
            this.iKY.setVisibility(8);
            this.iLe.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.hDg.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.hDg.startLoad(str, 10, false);
            } else {
                this.hDg.startLoad(str, 12, false);
            }
            this.hDg.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.iKS.setVisibility(8);
            xZ(8);
            this.iKT.setVisibility(8);
            this.iKU.setVisibility(8);
            this.iKV.setVisibility(8);
            this.iKX.setVisibility(8);
            this.iKW.setVisibility(8);
            this.iKY.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.iLe.setVisibility(0);
        } else {
            this.iLe.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.iLa) {
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
            if (!this.iLa) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cnB() {
        if (this.iLa) {
            this.mName.setVisibility(0);
            this.ahD.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iLd.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.iLd.setLayoutParams(marginLayoutParams);
        this.ahD.setVisibility(8);
    }
}
