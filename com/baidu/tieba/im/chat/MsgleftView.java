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
    private UserIconBox aje;
    private TbPageContext<MsglistActivity<?>> ehG;
    private HeadImageView idE;
    private ViewGroup joT;
    private ImageView joU;
    private final TouchType joV;
    View.OnLongClickListener joW;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.joV = new TouchType();
        this.joW = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.joV.set(true);
                return true;
            }
        };
        this.ehG = tbPageContext;
        initView();
        this.joU = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.joT = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.idE = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.idE.setAutoChangeStyle(false);
        this.idE.setDrawerType(1);
        this.idE.setRadius(l.dip2px(this.ehG.getContext(), 4.0f));
        this.idE.setPlaceHolder(1);
        this.aje = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.idE.setLongClickable(true);
        this.idE.setOnLongClickListener(this.joW);
        this.idE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long joX = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.joX = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.joX > 200) {
                        if (MsgleftView.this.joV.get()) {
                            MsgleftView.this.jon.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.joV.set(false);
                        }
                    } else {
                        MsgleftView.this.jom.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.joM.setIsLeft(true);
        this.joN.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cFB();
        if (this.aje != null && this.joQ) {
            this.aje.setVisibility(0);
            this.aje.setAutoChangedStyle(false);
            Resources resources = this.ehG.getResources();
            this.aje.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.joI.setVisibility(0);
            this.joI.setText(null);
            Bm(8);
            this.joP.getImage().setTag(null);
            this.joJ.setVisibility(8);
            this.joJ.setTag(null);
            this.joL.setVisibility(8);
            this.joL.setTag(null);
            this.joM.setVisibility(8);
            this.joN.setVisibility(8);
            this.joO.setVisibility(8);
            this.joU.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.idE.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.idE.startLoad(str, 10, false);
            } else {
                this.idE.startLoad(str, 12, false);
            }
            this.idE.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.joI.setVisibility(8);
            Bm(8);
            this.joJ.setVisibility(8);
            this.joK.setVisibility(8);
            this.joL.setVisibility(8);
            this.joN.setVisibility(8);
            this.joM.setVisibility(8);
            this.joO.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.joU.setVisibility(0);
        } else {
            this.joU.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.joQ) {
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
            if (!this.joQ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cFB() {
        if (this.joQ) {
            this.mName.setVisibility(0);
            this.aje.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.joT.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.joT.setLayoutParams(marginLayoutParams);
        this.aje.setVisibility(8);
    }
}
