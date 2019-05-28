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
    private UserIconBox Xu;
    private HeadImageView frV;
    private ViewGroup gti;
    private ImageView gtj;
    private final TouchType gtk;
    View.OnLongClickListener gtl;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.gtk = new TouchType();
        this.gtl = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gtk.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.gtj = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.gti = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.frV = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.frV.setAutoChangeStyle(false);
        this.frV.setDrawerType(1);
        this.frV.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.Xu = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.frV.setLongClickable(true);
        this.frV.setOnLongClickListener(this.gtl);
        this.frV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gtm = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gtm = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gtm > 200) {
                        if (MsgleftView.this.gtk.get()) {
                            MsgleftView.this.gsA.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gtk.set(false);
                        }
                    } else {
                        MsgleftView.this.gsz.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gtb.setIsLeft(true);
        this.gtc.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bxT();
        if (this.Xu != null && this.gtf) {
            this.Xu.setVisibility(0);
            this.Xu.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.Xu.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gsX.setVisibility(0);
            this.gsX.setText(null);
            uD(8);
            this.gte.getImage().setTag(null);
            this.gsY.setVisibility(8);
            this.gsY.setTag(null);
            this.gta.setVisibility(8);
            this.gta.setTag(null);
            this.gtb.setVisibility(8);
            this.gtc.setVisibility(8);
            this.gtd.setVisibility(8);
            this.gtj.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.frV.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.frV.startLoad(str, 10, false);
            } else {
                this.frV.startLoad(str, 12, false);
            }
            this.frV.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gsX.setVisibility(8);
            uD(8);
            this.gsY.setVisibility(8);
            this.gsZ.setVisibility(8);
            this.gta.setVisibility(8);
            this.gtc.setVisibility(8);
            this.gtb.setVisibility(8);
            this.gtd.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.gtj.setVisibility(0);
        } else {
            this.gtj.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.gtf) {
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
            if (!this.gtf) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bxT() {
        if (this.gtf) {
            this.mName.setVisibility(0);
            this.Xu.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gti.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gti.setLayoutParams(marginLayoutParams);
        this.Xu.setVisibility(8);
    }
}
