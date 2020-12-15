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
    private UserIconBox akB;
    private TbPageContext<MsglistActivity<?>> eNx;
    private HeadImageView kjT;
    private ViewGroup kkE;
    private ImageView kkF;
    private final TouchType kkG;
    View.OnLongClickListener kkH;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.kkG = new TouchType();
        this.kkH = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.kkG.set(true);
                return true;
            }
        };
        this.eNx = tbPageContext;
        initView();
        this.kkF = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.kkE = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.kjT = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kjT.setAutoChangeStyle(false);
        this.kjT.setDrawerType(1);
        this.kjT.setRadius(l.dip2px(this.eNx.getContext(), 4.0f));
        this.kjT.setPlaceHolder(1);
        this.akB = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.kjT.setLongClickable(true);
        this.kjT.setOnLongClickListener(this.kkH);
        this.kjT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long kkI = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.kkI = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.kkI > 200) {
                        if (MsgleftView.this.kkG.get()) {
                            MsgleftView.this.kjY.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.kkG.set(false);
                        }
                    } else {
                        MsgleftView.this.kjX.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.kkx.setIsLeft(true);
        this.kky.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cTN();
        if (this.akB != null && this.kkB) {
            this.akB.setVisibility(0);
            this.akB.setAutoChangedStyle(false);
            Resources resources = this.eNx.getResources();
            this.akB.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.kkt.setVisibility(0);
            this.kkt.setText(null);
            DL(8);
            this.kkA.getImage().setTag(null);
            this.kku.setVisibility(8);
            this.kku.setTag(null);
            this.kkw.setVisibility(8);
            this.kkw.setTag(null);
            this.kkx.setVisibility(8);
            this.kky.setVisibility(8);
            this.kkz.setVisibility(8);
            this.kkF.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.kjT.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.kjT.startLoad(str, 10, false);
            } else {
                this.kjT.startLoad(str, 12, false);
            }
            this.kjT.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.kkt.setVisibility(8);
            DL(8);
            this.kku.setVisibility(8);
            this.kkv.setVisibility(8);
            this.kkw.setVisibility(8);
            this.kky.setVisibility(8);
            this.kkx.setVisibility(8);
            this.kkz.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.kkF.setVisibility(0);
        } else {
            this.kkF.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.kkB) {
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
            if (!this.kkB) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cTN() {
        if (this.kkB) {
            this.mName.setVisibility(0);
            this.akB.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kkE.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.kkE.setLayoutParams(marginLayoutParams);
        this.akB.setVisibility(8);
    }
}
