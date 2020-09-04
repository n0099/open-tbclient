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
    private UserIconBox aiK;
    private TbPageContext<MsglistActivity<?>> efr;
    private HeadImageView hWA;
    private ViewGroup jgn;
    private ImageView jgo;
    private final TouchType jgp;
    View.OnLongClickListener jgq;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.jgp = new TouchType();
        this.jgq = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.jgp.set(true);
                return true;
            }
        };
        this.efr = tbPageContext;
        initView();
        this.jgo = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.jgn = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.hWA = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hWA.setAutoChangeStyle(false);
        this.hWA.setDrawerType(1);
        this.hWA.setRadius(l.dip2px(this.efr.getContext(), 4.0f));
        this.hWA.setPlaceHolder(1);
        this.aiK = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.hWA.setLongClickable(true);
        this.hWA.setOnLongClickListener(this.jgq);
        this.hWA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long jgr = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.jgr = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.jgr > 200) {
                        if (MsgleftView.this.jgp.get()) {
                            MsgleftView.this.jfH.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.jgp.set(false);
                        }
                    } else {
                        MsgleftView.this.jfG.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.jgg.setIsLeft(true);
        this.jgh.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cBU();
        if (this.aiK != null && this.jgk) {
            this.aiK.setVisibility(0);
            this.aiK.setAutoChangedStyle(false);
            Resources resources = this.efr.getResources();
            this.aiK.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.jgc.setVisibility(0);
            this.jgc.setText(null);
            AL(8);
            this.jgj.getImage().setTag(null);
            this.jgd.setVisibility(8);
            this.jgd.setTag(null);
            this.jgf.setVisibility(8);
            this.jgf.setTag(null);
            this.jgg.setVisibility(8);
            this.jgh.setVisibility(8);
            this.jgi.setVisibility(8);
            this.jgo.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.hWA.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.hWA.startLoad(str, 10, false);
            } else {
                this.hWA.startLoad(str, 12, false);
            }
            this.hWA.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.jgc.setVisibility(8);
            AL(8);
            this.jgd.setVisibility(8);
            this.jge.setVisibility(8);
            this.jgf.setVisibility(8);
            this.jgh.setVisibility(8);
            this.jgg.setVisibility(8);
            this.jgi.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.jgo.setVisibility(0);
        } else {
            this.jgo.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.jgk) {
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
            if (!this.jgk) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cBU() {
        if (this.jgk) {
            this.mName.setVisibility(0);
            this.aiK.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jgn.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.jgn.setLayoutParams(marginLayoutParams);
        this.aiK.setVisibility(8);
    }
}
