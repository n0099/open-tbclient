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
    private UserIconBox ajw;
    private TbPageContext<MsglistActivity<?>> etO;
    private HeadImageView isB;
    private ViewGroup jDQ;
    private ImageView jDR;
    private final TouchType jDS;
    View.OnLongClickListener jDT;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.jDS = new TouchType();
        this.jDT = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.jDS.set(true);
                return true;
            }
        };
        this.etO = tbPageContext;
        initView();
        this.jDR = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.jDQ = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.isB = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.isB.setAutoChangeStyle(false);
        this.isB.setDrawerType(1);
        this.isB.setRadius(l.dip2px(this.etO.getContext(), 4.0f));
        this.isB.setPlaceHolder(1);
        this.ajw = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.isB.setLongClickable(true);
        this.isB.setOnLongClickListener(this.jDT);
        this.isB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long jDU = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.jDU = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.jDU > 200) {
                        if (MsgleftView.this.jDS.get()) {
                            MsgleftView.this.jDk.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.jDS.set(false);
                        }
                    } else {
                        MsgleftView.this.jDj.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.jDJ.setIsLeft(true);
        this.jDK.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cJk();
        if (this.ajw != null && this.jDN) {
            this.ajw.setVisibility(0);
            this.ajw.setAutoChangedStyle(false);
            Resources resources = this.etO.getResources();
            this.ajw.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.jDF.setVisibility(0);
            this.jDF.setText(null);
            BS(8);
            this.jDM.getImage().setTag(null);
            this.jDG.setVisibility(8);
            this.jDG.setTag(null);
            this.jDI.setVisibility(8);
            this.jDI.setTag(null);
            this.jDJ.setVisibility(8);
            this.jDK.setVisibility(8);
            this.jDL.setVisibility(8);
            this.jDR.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.isB.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.isB.startLoad(str, 10, false);
            } else {
                this.isB.startLoad(str, 12, false);
            }
            this.isB.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.jDF.setVisibility(8);
            BS(8);
            this.jDG.setVisibility(8);
            this.jDH.setVisibility(8);
            this.jDI.setVisibility(8);
            this.jDK.setVisibility(8);
            this.jDJ.setVisibility(8);
            this.jDL.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.jDR.setVisibility(0);
        } else {
            this.jDR.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.jDN) {
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
            if (!this.jDN) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cJk() {
        if (this.jDN) {
            this.mName.setVisibility(0);
            this.ajw.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jDQ.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.jDQ.setLayoutParams(marginLayoutParams);
        this.ajw.setVisibility(8);
    }
}
