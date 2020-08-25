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
/* loaded from: classes2.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox aiI;
    private TbPageContext<MsglistActivity<?>> efn;
    private HeadImageView hWu;
    private ViewGroup jgh;
    private ImageView jgi;
    private final TouchType jgj;
    View.OnLongClickListener jgk;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.jgj = new TouchType();
        this.jgk = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.jgj.set(true);
                return true;
            }
        };
        this.efn = tbPageContext;
        initView();
        this.jgi = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.jgh = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.hWu = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hWu.setAutoChangeStyle(false);
        this.hWu.setDrawerType(1);
        this.hWu.setRadius(l.dip2px(this.efn.getContext(), 4.0f));
        this.hWu.setPlaceHolder(1);
        this.aiI = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.hWu.setLongClickable(true);
        this.hWu.setOnLongClickListener(this.jgk);
        this.hWu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long jgl = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.jgl = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.jgl > 200) {
                        if (MsgleftView.this.jgj.get()) {
                            MsgleftView.this.jfB.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.jgj.set(false);
                        }
                    } else {
                        MsgleftView.this.jfA.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.jga.setIsLeft(true);
        this.jgb.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cBT();
        if (this.aiI != null && this.jge) {
            this.aiI.setVisibility(0);
            this.aiI.setAutoChangedStyle(false);
            Resources resources = this.efn.getResources();
            this.aiI.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.jfW.setVisibility(0);
            this.jfW.setText(null);
            AL(8);
            this.jgd.getImage().setTag(null);
            this.jfX.setVisibility(8);
            this.jfX.setTag(null);
            this.jfZ.setVisibility(8);
            this.jfZ.setTag(null);
            this.jga.setVisibility(8);
            this.jgb.setVisibility(8);
            this.jgc.setVisibility(8);
            this.jgi.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.hWu.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.hWu.startLoad(str, 10, false);
            } else {
                this.hWu.startLoad(str, 12, false);
            }
            this.hWu.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.jfW.setVisibility(8);
            AL(8);
            this.jfX.setVisibility(8);
            this.jfY.setVisibility(8);
            this.jfZ.setVisibility(8);
            this.jgb.setVisibility(8);
            this.jga.setVisibility(8);
            this.jgc.setVisibility(8);
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
            this.jgi.setVisibility(0);
        } else {
            this.jgi.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.jge) {
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
            if (!this.jge) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cBT() {
        if (this.jge) {
            this.mName.setVisibility(0);
            this.aiI.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jgh.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.jgh.setLayoutParams(marginLayoutParams);
        this.aiI.setVisibility(8);
    }
}
