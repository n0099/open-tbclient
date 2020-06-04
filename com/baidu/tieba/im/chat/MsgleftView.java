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
    private UserIconBox agz;
    private TbPageContext<MsglistActivity<?>> dIF;
    private HeadImageView hqx;
    private ViewGroup itX;
    private ImageView itY;
    private final TouchType itZ;
    View.OnLongClickListener iua;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.itZ = new TouchType();
        this.iua = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.itZ.set(true);
                return true;
            }
        };
        this.dIF = tbPageContext;
        initView();
        this.itY = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.itX = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.hqx = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hqx.setAutoChangeStyle(false);
        this.hqx.setDrawerType(1);
        this.hqx.setRadius(l.dip2px(this.dIF.getContext(), 4.0f));
        this.hqx.setPlaceHolder(1);
        this.agz = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.hqx.setLongClickable(true);
        this.hqx.setOnLongClickListener(this.iua);
        this.hqx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long iub = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.iub = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.iub > 200) {
                        if (MsgleftView.this.itZ.get()) {
                            MsgleftView.this.itr.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.itZ.set(false);
                        }
                    } else {
                        MsgleftView.this.itq.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.itQ.setIsLeft(true);
        this.itR.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cjL();
        if (this.agz != null && this.itU) {
            this.agz.setVisibility(0);
            this.agz.setAutoChangedStyle(false);
            Resources resources = this.dIF.getResources();
            this.agz.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.itM.setVisibility(0);
            this.itM.setText(null);
            xp(8);
            this.itT.getImage().setTag(null);
            this.itN.setVisibility(8);
            this.itN.setTag(null);
            this.itP.setVisibility(8);
            this.itP.setTag(null);
            this.itQ.setVisibility(8);
            this.itR.setVisibility(8);
            this.itS.setVisibility(8);
            this.itY.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.hqx.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.hqx.startLoad(str, 10, false);
            } else {
                this.hqx.startLoad(str, 12, false);
            }
            this.hqx.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.itM.setVisibility(8);
            xp(8);
            this.itN.setVisibility(8);
            this.itO.setVisibility(8);
            this.itP.setVisibility(8);
            this.itR.setVisibility(8);
            this.itQ.setVisibility(8);
            this.itS.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.itY.setVisibility(0);
        } else {
            this.itY.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.itU) {
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
            if (!this.itU) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cjL() {
        if (this.itU) {
            this.mName.setVisibility(0);
            this.agz.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.itX.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.itX.setLayoutParams(marginLayoutParams);
        this.agz.setVisibility(8);
    }
}
