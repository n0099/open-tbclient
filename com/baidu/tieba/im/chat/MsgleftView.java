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
    private UserIconBox akm;
    private TbPageContext<MsglistActivity<?>> eSJ;
    private HeadImageView krU;
    private ViewGroup ksF;
    private ImageView ksG;
    private final TouchType ksH;
    View.OnLongClickListener ksI;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.ksH = new TouchType();
        this.ksI = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.ksH.set(true);
                return true;
            }
        };
        this.eSJ = tbPageContext;
        initView();
        this.ksG = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.ksF = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.krU = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.krU.setAutoChangeStyle(false);
        this.krU.setDrawerType(1);
        this.krU.setRadius(l.dip2px(this.eSJ.getContext(), 4.0f));
        this.krU.setPlaceHolder(1);
        this.akm = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.krU.setLongClickable(true);
        this.krU.setOnLongClickListener(this.ksI);
        this.krU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long ksJ = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.ksJ = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.ksJ > 200) {
                        if (MsgleftView.this.ksH.get()) {
                            MsgleftView.this.krZ.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.ksH.set(false);
                        }
                    } else {
                        MsgleftView.this.krY.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.ksy.setIsLeft(true);
        this.ksz.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cSI();
        if (this.akm != null && this.ksC) {
            this.akm.setVisibility(0);
            this.akm.setAutoChangedStyle(false);
            Resources resources = this.eSJ.getResources();
            this.akm.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.ksu.setVisibility(0);
            this.ksu.setText(null);
            Cq(8);
            this.ksB.getImage().setTag(null);
            this.ksv.setVisibility(8);
            this.ksv.setTag(null);
            this.ksx.setVisibility(8);
            this.ksx.setTag(null);
            this.ksy.setVisibility(8);
            this.ksz.setVisibility(8);
            this.ksA.setVisibility(8);
            this.ksG.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.krU.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.krU.startLoad(str, 10, false);
            } else {
                this.krU.startLoad(str, 12, false);
            }
            this.krU.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.ksu.setVisibility(8);
            Cq(8);
            this.ksv.setVisibility(8);
            this.ksw.setVisibility(8);
            this.ksx.setVisibility(8);
            this.ksz.setVisibility(8);
            this.ksy.setVisibility(8);
            this.ksA.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.ksG.setVisibility(0);
        } else {
            this.ksG.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.ksC) {
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
            if (!this.ksC) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cSI() {
        if (this.ksC) {
            this.mName.setVisibility(0);
            this.akm.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ksF.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.ksF.setLayoutParams(marginLayoutParams);
        this.akm.setVisibility(8);
    }
}
