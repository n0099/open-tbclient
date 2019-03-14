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
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox ZB;
    private HeadImageView fbS;
    private ViewGroup gcd;
    private ImageView gce;
    private final TouchType gcf;
    View.OnLongClickListener gcg;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgleft_view);
        this.gcf = new TouchType();
        this.gcg = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gcf.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.gce = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.gcd = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.fbS = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.fbS.setAutoChangeStyle(false);
        this.fbS.setDrawerType(1);
        this.fbS.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.ZB = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.fbS.setLongClickable(true);
        this.fbS.setOnLongClickListener(this.gcg);
        this.fbS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gch = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gch = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gch > 200) {
                        if (MsgleftView.this.gcf.get()) {
                            MsgleftView.this.gbv.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gcf.set(false);
                        }
                    } else {
                        MsgleftView.this.gbu.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gbW.setIsLeft(true);
        this.gbX.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bqh();
        if (this.ZB != null && this.gca) {
            this.ZB.setVisibility(0);
            this.ZB.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.ZB.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gbS.setVisibility(0);
            this.gbS.setText(null);
            tA(8);
            this.gbZ.getImage().setTag(null);
            this.gbT.setVisibility(8);
            this.gbT.setTag(null);
            this.gbV.setVisibility(8);
            this.gbV.setTag(null);
            this.gbW.setVisibility(8);
            this.gbX.setVisibility(8);
            this.gbY.setVisibility(8);
            this.gce.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.fbS.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.fbS.startLoad(str, 10, false);
            } else {
                this.fbS.startLoad(str, 12, false);
            }
            this.fbS.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gbS.setVisibility(8);
            tA(8);
            this.gbT.setVisibility(8);
            this.gbU.setVisibility(8);
            this.gbV.setVisibility(8);
            this.gbX.setVisibility(8);
            this.gbW.setVisibility(8);
            this.gbY.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.gce.setVisibility(0);
        } else {
            this.gce.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.gca) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = d.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = d.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.gca) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bqh() {
        if (this.gca) {
            this.mName.setVisibility(0);
            this.ZB.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gcd.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gcd.setLayoutParams(marginLayoutParams);
        this.ZB.setVisibility(8);
    }
}
