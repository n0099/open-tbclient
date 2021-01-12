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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
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
    protected TextView gAE;
    protected com.baidu.adp.lib.b.a krY;
    protected com.baidu.adp.lib.b.b krZ;
    protected ShareFromGameCenter ksA;
    protected ChatImageWithTailView ksB;
    protected boolean ksC;
    protected boolean ksD;
    protected int ksh;
    private Calendar kss;
    protected long kst;
    protected TbRichTextView ksu;
    protected ChatVoiceView ksv;
    protected GifView ksw;
    protected Invite2GroupView ksx;
    protected ShareFromPBView ksy;
    protected ShareFromFrsView ksz;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.krY = null;
        this.krZ = null;
        this.mPosition = 0;
        this.kst = 0L;
        this.mId = null;
        this.ksC = true;
        this.ksD = false;
        this.mLastTime = 0L;
        this.kss = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.krY = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.krZ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gG(long j) {
        this.mLastTime = j;
    }

    public void gH(long j) {
        this.kss = Calendar.getInstance();
        this.kss.setTimeInMillis(1000 * j);
    }

    private boolean gI(long j) {
        if (j < 1000) {
            return false;
        }
        return this.mLastTime == 0 || j - this.mLastTime >= 180;
    }

    private String gJ(long j) {
        if (j < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000 * j);
        if (this.kss != null && this.kss.get(1) == calendar.get(1) && this.kss.get(6) == calendar.get(6)) {
            return at.getDateStringHm(calendar.getTime());
        }
        return at.getDateStringMdHm(calendar.getTime());
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
        this.gAE = (TextView) findViewById(R.id.tex_msgitem_time);
        this.ksu = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.ksu.setLinkTextColor(-14845754);
        this.ksB = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.ksx = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.ksy = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.ksz = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.ksA = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.ksv = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.ksv.setClickable(true);
        this.ksv.setOnClickListener(this.ksv);
        this.ksu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ksu != null && e.this.ksu.getTextView() != null) {
                    CharSequence text = e.this.ksu.getTextView().getText();
                    if (!TextUtils.isEmpty(text)) {
                        if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                            if (text.toString().contains("http://") || text.toString().contains(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                                be.bsB().b((TbPageContext) j.K(view.getContext()), new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1"});
                                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_PERSON_POST_RECYCLE_BIN_RED_TIP_SHOW), false);
                                TiebaStatic.log(new aq("c14050").dW("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                        }
                    }
                }
            }
        });
        this.ksv.setLongClickable(true);
        this.ksv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.krZ.onItemViewLongClick(view, 5, e.this.mPosition, 0L);
                return true;
            }
        });
        this.ksB.getImage().setClickable(true);
        this.ksB.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.krY.onItemViewClick(view, 4, e.this.mPosition, 0L);
            }
        });
        this.ksB.getImage().setLongClickable(true);
        this.ksB.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.krZ.onItemViewLongClick(view, 4, e.this.mPosition, 0L);
                return true;
            }
        });
        this.ksB.getTail().setClickable(true);
        this.ksB.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.krY.onItemViewClick(view, 13, e.this.mPosition, 0L);
            }
        });
        this.ksu.setLongClickable(true);
        this.ksu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.krZ.onItemViewLongClick(view, 3, e.this.mPosition, 0L);
                return true;
            }
        });
        this.ksw = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.ksw.setSupportNoImage(false);
        this.ksw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.krY.onItemViewClick(view, 7, e.this.mPosition, 0L);
            }
        });
        this.ksw.setLongClickable(true);
        this.ksw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.krZ.onItemViewLongClick(view, 7, e.this.mPosition, 0L);
                return true;
            }
        });
        this.ksy.setClickable(true);
        this.ksy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.krY.onItemViewClick(view, 10, e.this.mPosition, 0L);
            }
        });
        this.ksy.setLongClickable(true);
        this.ksy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.krZ.onItemViewLongClick(view, 10, e.this.mPosition, 0L);
                return true;
            }
        });
        this.ksz.setClickable(true);
        this.ksz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.krY.onItemViewClick(view, 15, e.this.mPosition, 0L);
            }
        });
        this.ksz.setLongClickable(true);
        this.ksz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.krZ.onItemViewLongClick(view, 15, e.this.mPosition, 0L);
                return true;
            }
        });
        this.ksA.getContentBody().setClickable(true);
        this.ksA.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.krY.onItemViewClick(view, 11, e.this.mPosition, 0L);
            }
        });
        this.ksA.getTail().setClickable(true);
        this.ksA.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.krY.onItemViewClick(view, 12, e.this.mPosition, 0L);
            }
        });
        this.ksA.getContentBody().setLongClickable(true);
        this.ksA.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.krZ.onItemViewLongClick(view, 11, e.this.mPosition, 0L);
                return true;
            }
        });
        if (this.ksx != null) {
            this.ksx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.8
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    e.this.krZ.onItemViewLongClick(view, 17, e.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cr(int i) {
        this.ksB.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gI = gI(chatMessage.getTime());
        if (z || gI) {
            this.gAE.setVisibility(0);
            this.gAE.setText(gJ(chatMessage.getTime()));
        } else {
            this.gAE.setVisibility(8);
        }
        if (!z && gI) {
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
        h.a(this.mContext.getContext(), this.ksu, chatMessage, str, this.ksh);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.ksu.setContentDescription(stringBuffer.toString());
            this.ksu.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.ksB, chatMessage, this.kst, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), this.ksv, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        h.a(this.mContext.getContext(), this.ksw, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        h.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.ksx, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.ksy, this.ksz, this.ksA, chatMessage, str);
    }

    public void sq(boolean z) {
        this.ksC = z;
    }

    public void sr(boolean z) {
        this.ksD = z;
    }

    public void Cq(int i) {
        this.ksh = i;
    }
}
