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
    private UserIconBox ajx;
    private TbPageContext<MsglistActivity<?>> eIc;
    private HeadImageView iKU;
    private ViewGroup jWm;
    private ImageView jWn;
    private final TouchType jWo;
    View.OnLongClickListener jWp;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.jWo = new TouchType();
        this.jWp = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.jWo.set(true);
                return true;
            }
        };
        this.eIc = tbPageContext;
        initView();
        this.jWn = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.jWm = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.iKU = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.iKU.setAutoChangeStyle(false);
        this.iKU.setDrawerType(1);
        this.iKU.setRadius(l.dip2px(this.eIc.getContext(), 4.0f));
        this.iKU.setPlaceHolder(1);
        this.ajx = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.iKU.setLongClickable(true);
        this.iKU.setOnLongClickListener(this.jWp);
        this.iKU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long jWq = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.jWq = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.jWq > 200) {
                        if (MsgleftView.this.jWo.get()) {
                            MsgleftView.this.jVG.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.jWo.set(false);
                        }
                    } else {
                        MsgleftView.this.jVF.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.jWf.setIsLeft(true);
        this.jWg.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cOS();
        if (this.ajx != null && this.jWj) {
            this.ajx.setVisibility(0);
            this.ajx.setAutoChangedStyle(false);
            Resources resources = this.eIc.getResources();
            this.ajx.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.jWb.setVisibility(0);
            this.jWb.setText(null);
            Cy(8);
            this.jWi.getImage().setTag(null);
            this.jWc.setVisibility(8);
            this.jWc.setTag(null);
            this.jWe.setVisibility(8);
            this.jWe.setTag(null);
            this.jWf.setVisibility(8);
            this.jWg.setVisibility(8);
            this.jWh.setVisibility(8);
            this.jWn.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.iKU.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.iKU.startLoad(str, 10, false);
            } else {
                this.iKU.startLoad(str, 12, false);
            }
            this.iKU.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.jWb.setVisibility(8);
            Cy(8);
            this.jWc.setVisibility(8);
            this.jWd.setVisibility(8);
            this.jWe.setVisibility(8);
            this.jWg.setVisibility(8);
            this.jWf.setVisibility(8);
            this.jWh.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.jWn.setVisibility(0);
        } else {
            this.jWn.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.jWj) {
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
            if (!this.jWj) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cOS() {
        if (this.jWj) {
            this.mName.setVisibility(0);
            this.ajx.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jWm.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.jWm.setLayoutParams(marginLayoutParams);
        this.ajx.setVisibility(8);
    }
}
