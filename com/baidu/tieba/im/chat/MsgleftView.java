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
public class MsgleftView extends e {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox ald;
    private TbPageContext<MsglistActivity<?>> eXu;
    private HeadImageView kwz;
    private ViewGroup kxk;
    private ImageView kxl;
    private final TouchType kxm;
    View.OnLongClickListener kxn;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.kxm = new TouchType();
        this.kxn = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.kxm.set(true);
                return true;
            }
        };
        this.eXu = tbPageContext;
        initView();
        this.kxl = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.kxk = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.kwz = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kwz.setAutoChangeStyle(false);
        this.kwz.setDrawerType(1);
        this.kwz.setRadius(l.dip2px(this.eXu.getContext(), 4.0f));
        this.kwz.setPlaceHolder(1);
        this.ald = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.kwz.setLongClickable(true);
        this.kwz.setOnLongClickListener(this.kxn);
        this.kwz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long kxo = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.kxo = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.kxo > 200) {
                        if (MsgleftView.this.kxm.get()) {
                            MsgleftView.this.kwE.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.kxm.set(false);
                        }
                    } else {
                        MsgleftView.this.kwD.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.kxd.setIsLeft(true);
        this.kxe.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cWA();
        if (this.ald != null && this.kxh) {
            this.ald.setVisibility(0);
            this.ald.setAutoChangedStyle(false);
            Resources resources = this.eXu.getResources();
            this.ald.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.kwZ.setVisibility(0);
            this.kwZ.setText(null);
            DX(8);
            this.kxg.getImage().setTag(null);
            this.kxa.setVisibility(8);
            this.kxa.setTag(null);
            this.kxc.setVisibility(8);
            this.kxc.setTag(null);
            this.kxd.setVisibility(8);
            this.kxe.setVisibility(8);
            this.kxf.setVisibility(8);
            this.kxl.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.kwz.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.kwz.startLoad(str, 10, false);
            } else {
                this.kwz.startLoad(str, 12, false);
            }
            this.kwz.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.kwZ.setVisibility(8);
            DX(8);
            this.kxa.setVisibility(8);
            this.kxb.setVisibility(8);
            this.kxc.setVisibility(8);
            this.kxe.setVisibility(8);
            this.kxd.setVisibility(8);
            this.kxf.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.kxl.setVisibility(0);
        } else {
            this.kxl.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.kxh) {
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
            if (!this.kxh) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cWA() {
        if (this.kxh) {
            this.mName.setVisibility(0);
            this.ald.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kxk.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.kxk.setLayoutParams(marginLayoutParams);
        this.ald.setVisibility(8);
    }
}
