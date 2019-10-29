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
    private UserIconBox HH;
    private TbPageContext<MsglistActivity<?>> cfl;
    private HeadImageView fyr;
    private ViewGroup gAc;
    private ImageView gAd;
    private final TouchType gAe;
    View.OnLongClickListener gAf;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.gAe = new TouchType();
        this.gAf = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gAe.set(true);
                return true;
            }
        };
        this.cfl = tbPageContext;
        initView();
        this.gAd = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.gAc = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.fyr = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.fyr.setAutoChangeStyle(false);
        this.fyr.setDrawerType(1);
        this.fyr.setRadius(l.dip2px(this.cfl.getContext(), 4.0f));
        this.HH = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.fyr.setLongClickable(true);
        this.fyr.setOnLongClickListener(this.gAf);
        this.fyr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gAg = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gAg = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gAg > 200) {
                        if (MsgleftView.this.gAe.get()) {
                            MsgleftView.this.gzv.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gAe.set(false);
                        }
                    } else {
                        MsgleftView.this.gzu.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gzV.setIsLeft(true);
        this.gzW.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        byl();
        if (this.HH != null && this.gzZ) {
            this.HH.setVisibility(0);
            this.HH.setAutoChangedStyle(false);
            Resources resources = this.cfl.getResources();
            this.HH.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gzR.setVisibility(0);
            this.gzR.setText(null);
            tP(8);
            this.gzY.getImage().setTag(null);
            this.gzS.setVisibility(8);
            this.gzS.setTag(null);
            this.gzU.setVisibility(8);
            this.gzU.setTag(null);
            this.gzV.setVisibility(8);
            this.gzW.setVisibility(8);
            this.gzX.setVisibility(8);
            this.gAd.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.fyr.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.fyr.startLoad(str, 10, false);
            } else {
                this.fyr.startLoad(str, 12, false);
            }
            this.fyr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gzR.setVisibility(8);
            tP(8);
            this.gzS.setVisibility(8);
            this.gzT.setVisibility(8);
            this.gzU.setVisibility(8);
            this.gzW.setVisibility(8);
            this.gzV.setVisibility(8);
            this.gzX.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.gAd.setVisibility(0);
        } else {
            this.gAd.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.gzZ) {
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
            if (!this.gzZ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void byl() {
        if (this.gzZ) {
            this.mName.setVisibility(0);
            this.HH.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gAc.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gAc.setLayoutParams(marginLayoutParams);
        this.HH.setVisibility(8);
    }
}
