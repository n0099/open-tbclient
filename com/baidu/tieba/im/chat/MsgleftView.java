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
    private UserIconBox Np;
    private TbPageContext<MsglistActivity<?>> cVv;
    private HeadImageView gsg;
    private ViewGroup huI;
    private ImageView huJ;
    private final TouchType huK;
    View.OnLongClickListener huL;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.huK = new TouchType();
        this.huL = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.huK.set(true);
                return true;
            }
        };
        this.cVv = tbPageContext;
        initView();
        this.huJ = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.huI = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.gsg = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.gsg.setAutoChangeStyle(false);
        this.gsg.setDrawerType(1);
        this.gsg.setRadius(l.dip2px(this.cVv.getContext(), 4.0f));
        this.gsg.setPlaceHolder(1);
        this.Np = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.gsg.setLongClickable(true);
        this.gsg.setOnLongClickListener(this.huL);
        this.gsg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long huM = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.huM = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.huM > 200) {
                        if (MsgleftView.this.huK.get()) {
                            MsgleftView.this.huc.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.huK.set(false);
                        }
                    } else {
                        MsgleftView.this.hub.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.huB.setIsLeft(true);
        this.huC.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        bSG();
        if (this.Np != null && this.huF) {
            this.Np.setVisibility(0);
            this.Np.setAutoChangedStyle(false);
            Resources resources = this.cVv.getResources();
            this.Np.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.hux.setVisibility(0);
            this.hux.setText(null);
            wj(8);
            this.huE.getImage().setTag(null);
            this.huy.setVisibility(8);
            this.huy.setTag(null);
            this.huA.setVisibility(8);
            this.huA.setTag(null);
            this.huB.setVisibility(8);
            this.huC.setVisibility(8);
            this.huD.setVisibility(8);
            this.huJ.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.gsg.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.gsg.startLoad(str, 10, false);
            } else {
                this.gsg.startLoad(str, 12, false);
            }
            this.gsg.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.hux.setVisibility(8);
            wj(8);
            this.huy.setVisibility(8);
            this.huz.setVisibility(8);
            this.huA.setVisibility(8);
            this.huC.setVisibility(8);
            this.huB.setVisibility(8);
            this.huD.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.huJ.setVisibility(0);
        } else {
            this.huJ.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.huF) {
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
            if (!this.huF) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void bSG() {
        if (this.huF) {
            this.mName.setVisibility(0);
            this.Np.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.huI.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.huI.setLayoutParams(marginLayoutParams);
        this.Np.setVisibility(8);
    }
}
