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
    private HeadImageView eem;
    private ViewGroup gAn;
    private ImageView gAo;
    private final TouchType gAp;
    View.OnLongClickListener gAq;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.gAp = new TouchType();
        this.gAq = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gAp.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.gAo = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.gAn = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.eem = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.eem.setAutoChangeStyle(false);
        this.eem.setDrawerType(1);
        this.eem.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.XO = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.eem.setLongClickable(true);
        this.eem.setOnLongClickListener(this.gAq);
        this.eem.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gAr = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gAr = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gAr > 200) {
                        if (MsgleftView.this.gAp.get()) {
                            MsgleftView.this.gzF.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gAp.set(false);
                        }
                    } else {
                        MsgleftView.this.gzE.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gAg.setIsLeft(true);
        this.gAh.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bAM();
        if (this.XO != null && this.gAk) {
            this.XO.setVisibility(0);
            this.XO.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.XO.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gAc.setVisibility(0);
            this.gAc.setText(null);
            vg(8);
            this.gAj.getImage().setTag(null);
            this.gAd.setVisibility(8);
            this.gAd.setTag(null);
            this.gAf.setVisibility(8);
            this.gAf.setTag(null);
            this.gAg.setVisibility(8);
            this.gAh.setVisibility(8);
            this.gAi.setVisibility(8);
            this.gAo.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.eem.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.eem.startLoad(str, 10, false);
            } else {
                this.eem.startLoad(str, 12, false);
            }
            this.eem.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gAc.setVisibility(8);
            vg(8);
            this.gAd.setVisibility(8);
            this.gAe.setVisibility(8);
            this.gAf.setVisibility(8);
            this.gAh.setVisibility(8);
            this.gAg.setVisibility(8);
            this.gAi.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.gAo.setVisibility(0);
        } else {
            this.gAo.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.gAk) {
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
            if (!this.gAk) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bAM() {
        if (this.gAk) {
            this.mName.setVisibility(0);
            this.XO.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gAn.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gAn.setLayoutParams(marginLayoutParams);
        this.XO.setVisibility(8);
    }
}
