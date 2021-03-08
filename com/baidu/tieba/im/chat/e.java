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
    protected TextView gFl;
    protected int kCE;
    private Calendar kCP;
    protected long kCQ;
    protected TbRichTextView kCR;
    protected ChatVoiceView kCS;
    protected GifView kCT;
    protected Invite2GroupView kCU;
    protected ShareFromPBView kCV;
    protected ShareFromFrsView kCW;
    protected ShareFromGameCenter kCX;
    protected ChatImageWithTailView kCY;
    protected boolean kCZ;
    protected com.baidu.adp.lib.b.a kCv;
    protected com.baidu.adp.lib.b.b kCw;
    protected boolean kDa;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.kCv = null;
        this.kCw = null;
        this.mPosition = 0;
        this.kCQ = 0L;
        this.mId = null;
        this.kCZ = true;
        this.kDa = false;
        this.mLastTime = 0L;
        this.kCP = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kCv = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kCw = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gL(long j) {
        this.mLastTime = j;
    }

    public void gM(long j) {
        this.kCP = Calendar.getInstance();
        this.kCP.setTimeInMillis(1000 * j);
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
        if (this.kCP != null && this.kCP.get(1) == calendar.get(1) && this.kCP.get(6) == calendar.get(6)) {
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
        this.gFl = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kCR = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.kCR.setLinkTextColor(-14845754);
        this.kCY = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.kCU = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.kCV = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.kCW = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.kCX = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.kCS = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.kCS.setClickable(true);
        this.kCS.setOnClickListener(this.kCS);
        this.kCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.kCR != null && e.this.kCR.getTextView() != null) {
                    CharSequence text = e.this.kCR.getTextView().getText();
                    if (!TextUtils.isEmpty(text)) {
                        if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                            if (text.toString().contains("http://") || text.toString().contains(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                                bf.bsY().b((TbPageContext) j.J(view.getContext()), new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1"});
                                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_PERSON_POST_RECYCLE_BIN_RED_TIP_SHOW), false);
                                TiebaStatic.log(new ar("c14050").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                        }
                    }
                }
            }
        });
        this.kCS.setLongClickable(true);
        this.kCS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kCw.onItemViewLongClick(view, 5, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kCY.getImage().setClickable(true);
        this.kCY.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kCv.onItemViewClick(view, 4, e.this.mPosition, 0L);
            }
        });
        this.kCY.getImage().setLongClickable(true);
        this.kCY.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kCw.onItemViewLongClick(view, 4, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kCY.getTail().setClickable(true);
        this.kCY.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kCv.onItemViewClick(view, 13, e.this.mPosition, 0L);
            }
        });
        this.kCR.setLongClickable(true);
        this.kCR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kCw.onItemViewLongClick(view, 3, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kCT = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.kCT.setSupportNoImage(false);
        this.kCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kCv.onItemViewClick(view, 7, e.this.mPosition, 0L);
            }
        });
        this.kCT.setLongClickable(true);
        this.kCT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kCw.onItemViewLongClick(view, 7, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kCV.setClickable(true);
        this.kCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kCv.onItemViewClick(view, 10, e.this.mPosition, 0L);
            }
        });
        this.kCV.setLongClickable(true);
        this.kCV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kCw.onItemViewLongClick(view, 10, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kCW.setClickable(true);
        this.kCW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kCv.onItemViewClick(view, 15, e.this.mPosition, 0L);
            }
        });
        this.kCW.setLongClickable(true);
        this.kCW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kCw.onItemViewLongClick(view, 15, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kCX.getContentBody().setClickable(true);
        this.kCX.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kCv.onItemViewClick(view, 11, e.this.mPosition, 0L);
            }
        });
        this.kCX.getTail().setClickable(true);
        this.kCX.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kCv.onItemViewClick(view, 12, e.this.mPosition, 0L);
            }
        });
        this.kCX.getContentBody().setLongClickable(true);
        this.kCX.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kCw.onItemViewLongClick(view, 11, e.this.mPosition, 0L);
                return true;
            }
        });
        if (this.kCU != null) {
            this.kCU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.8
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    e.this.kCw.onItemViewLongClick(view, 17, e.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CL(int i) {
        this.kCY.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gN = gN(chatMessage.getTime());
        if (z || gN) {
            this.gFl.setVisibility(0);
            this.gFl.setText(gO(chatMessage.getTime()));
        } else {
            this.gFl.setVisibility(8);
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
        h.a(this.mContext.getContext(), this.kCR, chatMessage, str, this.kCE);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.kCR.setContentDescription(stringBuffer.toString());
            this.kCR.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kCY, chatMessage, this.kCQ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), this.kCS, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        h.a(this.mContext.getContext(), this.kCT, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        h.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.kCU, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kCV, this.kCW, this.kCX, chatMessage, str);
    }

    public void sD(boolean z) {
        this.kCZ = z;
    }

    public void sE(boolean z) {
        this.kDa = z;
    }

    public void CK(int i) {
        this.kCE = i;
    }
}
