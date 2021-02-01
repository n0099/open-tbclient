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
    protected TextView gDo;
    protected long kAA;
    protected TbRichTextView kAB;
    protected ChatVoiceView kAC;
    protected GifView kAD;
    protected Invite2GroupView kAE;
    protected ShareFromPBView kAF;
    protected ShareFromFrsView kAG;
    protected ShareFromGameCenter kAH;
    protected ChatImageWithTailView kAI;
    protected boolean kAJ;
    protected boolean kAK;
    protected com.baidu.adp.lib.b.a kAf;
    protected com.baidu.adp.lib.b.b kAg;
    protected int kAo;
    private Calendar kAz;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.kAf = null;
        this.kAg = null;
        this.mPosition = 0;
        this.kAA = 0L;
        this.mId = null;
        this.kAJ = true;
        this.kAK = false;
        this.mLastTime = 0L;
        this.kAz = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kAf = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAg = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gL(long j) {
        this.mLastTime = j;
    }

    public void gM(long j) {
        this.kAz = Calendar.getInstance();
        this.kAz.setTimeInMillis(1000 * j);
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
        if (this.kAz != null && this.kAz.get(1) == calendar.get(1) && this.kAz.get(6) == calendar.get(6)) {
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
        this.gDo = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kAB = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.kAB.setLinkTextColor(-14845754);
        this.kAI = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.kAE = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.kAF = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.kAG = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.kAH = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.kAC = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.kAC.setClickable(true);
        this.kAC.setOnClickListener(this.kAC);
        this.kAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.kAB != null && e.this.kAB.getTextView() != null) {
                    CharSequence text = e.this.kAB.getTextView().getText();
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
        this.kAC.setLongClickable(true);
        this.kAC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAg.onItemViewLongClick(view, 5, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAI.getImage().setClickable(true);
        this.kAI.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAf.onItemViewClick(view, 4, e.this.mPosition, 0L);
            }
        });
        this.kAI.getImage().setLongClickable(true);
        this.kAI.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAg.onItemViewLongClick(view, 4, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAI.getTail().setClickable(true);
        this.kAI.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAf.onItemViewClick(view, 13, e.this.mPosition, 0L);
            }
        });
        this.kAB.setLongClickable(true);
        this.kAB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAg.onItemViewLongClick(view, 3, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAD = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.kAD.setSupportNoImage(false);
        this.kAD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAf.onItemViewClick(view, 7, e.this.mPosition, 0L);
            }
        });
        this.kAD.setLongClickable(true);
        this.kAD.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAg.onItemViewLongClick(view, 7, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAF.setClickable(true);
        this.kAF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAf.onItemViewClick(view, 10, e.this.mPosition, 0L);
            }
        });
        this.kAF.setLongClickable(true);
        this.kAF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAg.onItemViewLongClick(view, 10, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAG.setClickable(true);
        this.kAG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAf.onItemViewClick(view, 15, e.this.mPosition, 0L);
            }
        });
        this.kAG.setLongClickable(true);
        this.kAG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAg.onItemViewLongClick(view, 15, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kAH.getContentBody().setClickable(true);
        this.kAH.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAf.onItemViewClick(view, 11, e.this.mPosition, 0L);
            }
        });
        this.kAH.getTail().setClickable(true);
        this.kAH.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kAf.onItemViewClick(view, 12, e.this.mPosition, 0L);
            }
        });
        this.kAH.getContentBody().setLongClickable(true);
        this.kAH.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kAg.onItemViewLongClick(view, 11, e.this.mPosition, 0L);
                return true;
            }
        });
        if (this.kAE != null) {
            this.kAE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.8
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    e.this.kAg.onItemViewLongClick(view, 17, e.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CI(int i) {
        this.kAI.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gN = gN(chatMessage.getTime());
        if (z || gN) {
            this.gDo.setVisibility(0);
            this.gDo.setText(gO(chatMessage.getTime()));
        } else {
            this.gDo.setVisibility(8);
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
        h.a(this.mContext.getContext(), this.kAB, chatMessage, str, this.kAo);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.kAB.setContentDescription(stringBuffer.toString());
            this.kAB.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kAI, chatMessage, this.kAA, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), this.kAC, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        h.a(this.mContext.getContext(), this.kAD, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        h.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.kAE, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kAF, this.kAG, this.kAH, chatMessage, str);
    }

    public void sD(boolean z) {
        this.kAJ = z;
    }

    public void sE(boolean z) {
        this.kAK = z;
    }

    public void CH(int i) {
        this.kAo = i;
    }
}
