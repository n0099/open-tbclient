package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.c<MsglistActivity<?>> {
    protected TextView gDC;
    protected int kAC;
    private Calendar kAN;
    protected long kAO;
    protected TbRichTextView kAP;
    protected ChatVoiceView kAQ;
    protected GifView kAR;
    protected Invite2GroupView kAS;
    protected ShareFromPBView kAT;
    protected ShareFromFrsView kAU;
    protected ShareFromGameCenter kAV;
    protected ChatImageWithTailView kAW;
    protected boolean kAX;
    protected boolean kAY;
    protected com.baidu.adp.lib.b.a kAt;
    protected com.baidu.adp.lib.b.b kAu;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.kAt = null;
        this.kAu = null;
        this.mPosition = 0;
        this.kAO = 0L;
        this.mId = null;
        this.kAX = true;
        this.kAY = false;
        this.mLastTime = 0L;
        this.kAN = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kAt = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAu = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gL(long j) {
        this.mLastTime = j;
    }

    public void gM(long j) {
        this.kAN = Calendar.getInstance();
        this.kAN.setTimeInMillis(1000 * j);
    }

    private boolean gN(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String gO(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.kAN != null && this.kAN.get(1) == calendar.get(1) && this.kAN.get(6) == calendar.get(6)) {
            return au.getDateStringHm(calendar.getTime());
        }
        return au.getDateStringMdHm(calendar.getTime());
    }

    public void a(View view, ChatMessage chatMessage) {
    }

    public void b(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.mId = Long.valueOf(chatMessage.getMsgId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.gDC = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kAP = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.kAP.setLinkTextColor(-14845754);
        this.kAW = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.kAS = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.kAT = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.kAU = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.kAV = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.kAQ = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.kAQ.setClickable(true);
        this.kAQ.setOnClickListener(this.kAQ);
        this.kAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.kAP != null && e.this.kAP.getTextView() != null) {
                    CharSequence text = e.this.kAP.getTextView().getText();
                    if (!TextUtils.isEmpty(text)) {
                        if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                            if (text.toString().contains("http://") || text.toString().contains(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                                bf.bsV().b((TbPageContext) j.K(view.getContext()), new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1"});
                                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_PERSON_POST_RECYCLE_BIN_RED_TIP_SHOW), false);
                                TiebaStatic.log(new ar("c14050").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                        }
                    }
                }
            }
        });
        this.kAQ.setLongClickable(true);
        this.kAQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAu.onItemViewLongClick(view, 5, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAW.getImage().setClickable(true);
        this.kAW.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAt.onItemViewClick(view, 4, e.this.mPosition, 0L);
            }
        });
        this.kAW.getImage().setLongClickable(true);
        this.kAW.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAu.onItemViewLongClick(view, 4, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAW.getTail().setClickable(true);
        this.kAW.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAt.onItemViewClick(view, 13, e.this.mPosition, 0L);
            }
        });
        this.kAP.setLongClickable(true);
        this.kAP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAu.onItemViewLongClick(view, 3, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAR = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.kAR.setSupportNoImage(false);
        this.kAR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAt.onItemViewClick(view, 7, e.this.mPosition, 0L);
            }
        });
        this.kAR.setLongClickable(true);
        this.kAR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAu.onItemViewLongClick(view, 7, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAT.setClickable(true);
        this.kAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAt.onItemViewClick(view, 10, e.this.mPosition, 0L);
            }
        });
        this.kAT.setLongClickable(true);
        this.kAT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAu.onItemViewLongClick(view, 10, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAU.setClickable(true);
        this.kAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAt.onItemViewClick(view, 15, e.this.mPosition, 0L);
            }
        });
        this.kAU.setLongClickable(true);
        this.kAU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAu.onItemViewLongClick(view, 15, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAV.getContentBody().setClickable(true);
        this.kAV.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAt.onItemViewClick(view, 11, e.this.mPosition, 0L);
            }
        });
        this.kAV.getTail().setClickable(true);
        this.kAV.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAt.onItemViewClick(view, 12, e.this.mPosition, 0L);
            }
        });
        this.kAV.getContentBody().setLongClickable(true);
        this.kAV.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAu.onItemViewLongClick(view, 11, e.this.mPosition, 0L);
                return true;
            }
        });
        if (this.kAS != null) {
            this.kAS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.8
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    e.this.kAu.onItemViewLongClick(view, 17, e.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CI(int i) {
        this.kAW.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gN = gN(chatMessage.getTime());
        if (z || gN) {
            this.gDC.setVisibility(0);
            this.gDC.setText(gO(chatMessage.getTime()));
        } else {
            this.gDC.setVisibility(8);
        }
        if (!z && gN) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setIs_show_time(1);
                chatMessage.setCacheData(msgCacheData);
                return;
            }
            cacheData.setIs_show_time(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), this.kAP, chatMessage, str, this.kAC);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.kAP.setContentDescription(stringBuffer.toString());
            this.kAP.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kAW, chatMessage, this.kAO, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), this.kAQ, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        h.a(this.mContext.getContext(), this.kAR, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        h.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.kAS, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kAT, this.kAU, this.kAV, chatMessage, str);
    }

    public void sD(boolean z) {
        this.kAX = z;
    }

    public void sE(boolean z) {
        this.kAY = z;
    }

    public void CH(int i) {
        this.kAC = i;
    }
}
