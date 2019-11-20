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
    private UserIconBox Hh;
    private TbPageContext<MsglistActivity<?>> ceu;
    private HeadImageView fxA;
    private ViewGroup gzl;
    private ImageView gzm;
    private final TouchType gzn;
    View.OnLongClickListener gzo;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.gzn = new TouchType();
        this.gzo = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.gzn.set(true);
                return true;
            }
        };
        this.ceu = tbPageContext;
        initView();
        this.gzm = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.gzl = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.fxA = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.fxA.setAutoChangeStyle(false);
        this.fxA.setDrawerType(1);
        this.fxA.setRadius(l.dip2px(this.ceu.getContext(), 4.0f));
        this.Hh = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.fxA.setLongClickable(true);
        this.fxA.setOnLongClickListener(this.gzo);
        this.fxA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long gzp = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.gzp = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.gzp > 200) {
                        if (MsgleftView.this.gzn.get()) {
                            MsgleftView.this.gyE.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.gzn.set(false);
                        }
                    } else {
                        MsgleftView.this.gyD.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.gze.setIsLeft(true);
        this.gzf.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        byj();
        if (this.Hh != null && this.gzi) {
            this.Hh.setVisibility(0);
            this.Hh.setAutoChangedStyle(false);
            Resources resources = this.ceu.getResources();
            this.Hh.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.gza.setVisibility(0);
            this.gza.setText(null);
            tO(8);
            this.gzh.getImage().setTag(null);
            this.gzb.setVisibility(8);
            this.gzb.setTag(null);
            this.gzd.setVisibility(8);
            this.gzd.setTag(null);
            this.gze.setVisibility(8);
            this.gzf.setVisibility(8);
            this.gzg.setVisibility(8);
            this.gzm.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.fxA.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.fxA.startLoad(str, 10, false);
            } else {
                this.fxA.startLoad(str, 12, false);
            }
            this.fxA.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.gza.setVisibility(8);
            tO(8);
            this.gzb.setVisibility(8);
            this.gzc.setVisibility(8);
            this.gzd.setVisibility(8);
            this.gzf.setVisibility(8);
            this.gze.setVisibility(8);
            this.gzg.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.gzm.setVisibility(0);
        } else {
            this.gzm.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.gzi) {
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
            if (!this.gzi) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void byj() {
        if (this.gzi) {
            this.mName.setVisibility(0);
            this.Hh.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gzl.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.gzl.setLayoutParams(marginLayoutParams);
        this.Hh.setVisibility(8);
    }
}
