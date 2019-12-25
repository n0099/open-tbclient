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
    private UserIconBox MH;
    private TbPageContext<MsglistActivity<?>> cQU;
    private HeadImageView glX;
    private ViewGroup hns;
    private ImageView hnt;
    private final TouchType hnu;
    View.OnLongClickListener hnv;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.hnu = new TouchType();
        this.hnv = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.hnu.set(true);
                return true;
            }
        };
        this.cQU = tbPageContext;
        initView();
        this.hnt = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.hns = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.glX = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.glX.setAutoChangeStyle(false);
        this.glX.setDrawerType(1);
        this.glX.setRadius(l.dip2px(this.cQU.getContext(), 4.0f));
        this.glX.setPlaceHolder(1);
        this.MH = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.glX.setLongClickable(true);
        this.glX.setOnLongClickListener(this.hnv);
        this.glX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long hnw = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.hnw = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.hnw > 200) {
                        if (MsgleftView.this.hnu.get()) {
                            MsgleftView.this.hmM.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.hnu.set(false);
                        }
                    } else {
                        MsgleftView.this.hmL.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.hnl.setIsLeft(true);
        this.hnm.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bPB();
        if (this.MH != null && this.hnp) {
            this.MH.setVisibility(0);
            this.MH.setAutoChangedStyle(false);
            Resources resources = this.cQU.getResources();
            this.MH.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.hnh.setVisibility(0);
            this.hnh.setText(null);
            vQ(8);
            this.hno.getImage().setTag(null);
            this.hni.setVisibility(8);
            this.hni.setTag(null);
            this.hnk.setVisibility(8);
            this.hnk.setTag(null);
            this.hnl.setVisibility(8);
            this.hnm.setVisibility(8);
            this.hnn.setVisibility(8);
            this.hnt.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.glX.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.glX.startLoad(str, 10, false);
            } else {
                this.glX.startLoad(str, 12, false);
            }
            this.glX.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.hnh.setVisibility(8);
            vQ(8);
            this.hni.setVisibility(8);
            this.hnj.setVisibility(8);
            this.hnk.setVisibility(8);
            this.hnm.setVisibility(8);
            this.hnl.setVisibility(8);
            this.hnn.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.hnt.setVisibility(0);
        } else {
            this.hnt.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.hnp) {
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
            if (!this.hnp) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bPB() {
        if (this.hnp) {
            this.mName.setVisibility(0);
            this.MH.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hns.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.hns.setLayoutParams(marginLayoutParams);
        this.MH.setVisibility(8);
    }
}
