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
    private UserIconBox axT;
    private HeadImageView dka;
    private ImageView edA;
    private final TouchType edB;
    View.OnLongClickListener edC;
    private ViewGroup edz;
    private TbPageContext<MsglistActivity<?>> mContext;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgleft_view);
        this.edB = new TouchType();
        this.edC = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.edB.set(true);
                return true;
            }
        };
        this.mContext = tbPageContext;
        initView();
        this.edA = (ImageView) findViewById(d.g.iv_live_group_host);
        this.mName = (TextView) findViewById(d.g.tex_msgitem_name);
        this.edz = (ViewGroup) findViewById(d.g.box_msgitem_bubble);
        this.dka = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dka.setAutoChangeStyle(false);
        this.dka.setDrawerType(1);
        this.dka.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.axT = (UserIconBox) findViewById(d.g.user_tshow_icon_box);
        this.dka.setLongClickable(true);
        this.dka.setOnLongClickListener(this.edC);
        this.dka.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long edD = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.edD = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.edD > 200) {
                        if (MsgleftView.this.edB.get()) {
                            MsgleftView.this.ecR.b(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.edB.set(false);
                        }
                    } else {
                        MsgleftView.this.ecQ.a(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.eds.setIsLeft(true);
        this.edt.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aFO();
        if (this.axT != null && this.edw) {
            this.axT.setVisibility(0);
            this.axT.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.axT.a(tShowInfoNew, 2, resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds32), resources.getDimensionPixelSize(d.e.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.edo.setVisibility(0);
            this.edo.setText(null);
            ns(8);
            this.edv.getImage().setTag(null);
            this.edp.setVisibility(8);
            this.edp.setTag(null);
            this.edr.setVisibility(8);
            this.edr.setTag(null);
            this.eds.setVisibility(8);
            this.edt.setVisibility(8);
            this.edu.setVisibility(8);
            this.edA.setVisibility(8);
            return;
        }
        g(chatMessage);
        i(chatMessage);
        this.mName.setText("");
        h(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.dka.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.dka.startLoad(str, 10, false);
            } else {
                this.dka.startLoad(str, 12, false);
            }
            this.dka.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.edo.setVisibility(8);
            ns(8);
            this.edp.setVisibility(8);
            this.edq.setVisibility(8);
            this.edr.setVisibility(8);
            this.edt.setVisibility(8);
            this.eds.setVisibility(8);
            this.edu.setVisibility(8);
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
            this.edA.setVisibility(0);
        } else {
            this.edA.setVisibility(8);
        }
    }

    private void i(ChatMessage chatMessage) {
        int i;
        if (this.edw) {
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
            if (!this.edw) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aFO() {
        if (this.edw) {
            this.mName.setVisibility(0);
            this.axT.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.edz.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.edz.setLayoutParams(marginLayoutParams);
        this.axT.setVisibility(8);
    }
}
