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
public class MsgleftView extends e {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox akb;
    private TbPageContext<MsglistActivity<?>> eUY;
    private HeadImageView kAp;
    private ViewGroup kBa;
    private ImageView kBb;
    private final TouchType kBc;
    View.OnLongClickListener kBd;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.kBc = new TouchType();
        this.kBd = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.kBc.set(true);
                return true;
            }
        };
        this.eUY = tbPageContext;
        initView();
        this.kBb = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.kBa = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.kAp = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kAp.setAutoChangeStyle(false);
        this.kAp.setDrawerType(1);
        this.kAp.setRadius(l.dip2px(this.eUY.getContext(), 4.0f));
        this.kAp.setPlaceHolder(1);
        this.akb = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.kAp.setLongClickable(true);
        this.kAp.setOnLongClickListener(this.kBd);
        this.kAp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long kBe = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.kBe = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.kBe > 200) {
                        if (MsgleftView.this.kBc.get()) {
                            MsgleftView.this.kAu.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.kBc.set(false);
                        }
                    } else {
                        MsgleftView.this.kAt.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.kAT.setIsLeft(true);
        this.kAU.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cUN();
        if (this.akb != null && this.kAX) {
            this.akb.setVisibility(0);
            this.akb.setAutoChangedStyle(false);
            Resources resources = this.eUY.getResources();
            this.akb.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.kAP.setVisibility(0);
            this.kAP.setText(null);
            CI(8);
            this.kAW.getImage().setTag(null);
            this.kAQ.setVisibility(8);
            this.kAQ.setTag(null);
            this.kAS.setVisibility(8);
            this.kAS.setTag(null);
            this.kAT.setVisibility(8);
            this.kAU.setVisibility(8);
            this.kAV.setVisibility(8);
            this.kBb.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.kAp.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.kAp.startLoad(str, 10, false);
            } else {
                this.kAp.startLoad(str, 12, false);
            }
            this.kAp.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.kAP.setVisibility(8);
            CI(8);
            this.kAQ.setVisibility(8);
            this.kAR.setVisibility(8);
            this.kAS.setVisibility(8);
            this.kAU.setVisibility(8);
            this.kAT.setVisibility(8);
            this.kAV.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.kBb.setVisibility(0);
        } else {
            this.kBb.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.kAX) {
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
            if (!this.kAX) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cUN() {
        if (this.kAX) {
            this.mName.setVisibility(0);
            this.akb.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kBa.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.kBa.setLayoutParams(marginLayoutParams);
        this.akb.setVisibility(8);
    }
}
