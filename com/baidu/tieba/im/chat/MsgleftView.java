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
    private UserIconBox alu;
    private TbPageContext<MsglistActivity<?>> eWx;
    private HeadImageView kCr;
    private ViewGroup kDc;
    private ImageView kDd;
    private final TouchType kDe;
    View.OnLongClickListener kDf;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.kDe = new TouchType();
        this.kDf = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.kDe.set(true);
                return true;
            }
        };
        this.eWx = tbPageContext;
        initView();
        this.kDd = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.kDc = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.kCr = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kCr.setAutoChangeStyle(false);
        this.kCr.setDrawerType(1);
        this.kCr.setRadius(l.dip2px(this.eWx.getContext(), 4.0f));
        this.kCr.setPlaceHolder(1);
        this.alu = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.kCr.setLongClickable(true);
        this.kCr.setOnLongClickListener(this.kDf);
        this.kCr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long kDg = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.kDg = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.kDg > 200) {
                        if (MsgleftView.this.kDe.get()) {
                            MsgleftView.this.kCw.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.kDe.set(false);
                        }
                    } else {
                        MsgleftView.this.kCv.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.kCV.setIsLeft(true);
        this.kCW.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cUU();
        if (this.alu != null && this.kCZ) {
            this.alu.setVisibility(0);
            this.alu.setAutoChangedStyle(false);
            Resources resources = this.eWx.getResources();
            this.alu.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.kCR.setVisibility(0);
            this.kCR.setText(null);
            CL(8);
            this.kCY.getImage().setTag(null);
            this.kCS.setVisibility(8);
            this.kCS.setTag(null);
            this.kCU.setVisibility(8);
            this.kCU.setTag(null);
            this.kCV.setVisibility(8);
            this.kCW.setVisibility(8);
            this.kCX.setVisibility(8);
            this.kDd.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.kCr.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.kCr.startLoad(str, 10, false);
            } else {
                this.kCr.startLoad(str, 12, false);
            }
            this.kCr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.kCR.setVisibility(8);
            CL(8);
            this.kCS.setVisibility(8);
            this.kCT.setVisibility(8);
            this.kCU.setVisibility(8);
            this.kCW.setVisibility(8);
            this.kCV.setVisibility(8);
            this.kCX.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.kDd.setVisibility(0);
        } else {
            this.kDd.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.kCZ) {
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
            if (!this.kCZ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cUU() {
        if (this.kCZ) {
            this.mName.setVisibility(0);
            this.alu.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kDc.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.kDc.setLayoutParams(marginLayoutParams);
        this.alu.setVisibility(8);
    }
}
