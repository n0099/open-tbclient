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
    protected TextView gFk;
    protected com.baidu.adp.lib.b.a kwD;
    protected com.baidu.adp.lib.b.b kwE;
    protected int kwM;
    private Calendar kwX;
    protected long kwY;
    protected TbRichTextView kwZ;
    protected ChatVoiceView kxa;
    protected GifView kxb;
    protected Invite2GroupView kxc;
    protected ShareFromPBView kxd;
    protected ShareFromFrsView kxe;
    protected ShareFromGameCenter kxf;
    protected ChatImageWithTailView kxg;
    protected boolean kxh;
    protected boolean kxi;
    protected Long mId;
    private long mLastTime;
    protected int mPosition;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, int i) {
        super(tbPageContext, i);
        this.kwD = null;
        this.kwE = null;
        this.mPosition = 0;
        this.kwY = 0L;
        this.mId = null;
        this.kxh = true;
        this.kxi = false;
        this.mLastTime = 0L;
        this.kwX = null;
        this.mContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kwD = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kwE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gG(long j) {
        this.mLastTime = j;
    }

    public void gH(long j) {
        this.kwX = Calendar.getInstance();
        this.kwX.setTimeInMillis(1000 * j);
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
        if (this.kwX != null && this.kwX.get(1) == calendar.get(1) && this.kwX.get(6) == calendar.get(6)) {
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
        this.gFk = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kwZ = (TbRichTextView) findViewById(R.id.tex_msgitem_text);
        this.kwZ.setLinkTextColor(-14845754);
        this.kxg = (ChatImageWithTailView) findViewById(R.id.img_msgitem_image);
        this.kxc = (Invite2GroupView) findViewById(R.id.lay_msgitem_invite_view);
        this.kxd = (ShareFromPBView) findViewById(R.id.lay_msgitem_share_view);
        this.kxe = (ShareFromFrsView) findViewById(R.id.lay_msgitem_share_frs);
        this.kxf = (ShareFromGameCenter) findViewById(R.id.lay_msgitem_share_game);
        this.kxa = (ChatVoiceView) findViewById(R.id.lay_msgitem_voice);
        this.kxa.setClickable(true);
        this.kxa.setOnClickListener(this.kxa);
        this.kwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.kwZ != null && e.this.kwZ.getTextView() != null) {
                    CharSequence text = e.this.kwZ.getTextView().getText();
                    if (!TextUtils.isEmpty(text)) {
                        if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                            if (text.toString().contains("http://") || text.toString().contains(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                                be.bwv().b((TbPageContext) j.K(view.getContext()), new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1"});
                                com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_PERSON_POST_RECYCLE_BIN_RED_TIP_SHOW), false);
                                TiebaStatic.log(new aq("c14050").dX("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                        }
                    }
                }
            }
        });
        this.kxa.setLongClickable(true);
        this.kxa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kwE.onItemViewLongClick(view, 5, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kxg.getImage().setClickable(true);
        this.kxg.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kwD.onItemViewClick(view, 4, e.this.mPosition, 0L);
            }
        });
        this.kxg.getImage().setLongClickable(true);
        this.kxg.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kwE.onItemViewLongClick(view, 4, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kxg.getTail().setClickable(true);
        this.kxg.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kwD.onItemViewClick(view, 13, e.this.mPosition, 0L);
            }
        });
        this.kwZ.setLongClickable(true);
        this.kwZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kwE.onItemViewLongClick(view, 3, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kxb = (GifView) findViewById(R.id.emotion_msgitem_image);
        this.kxb.setSupportNoImage(false);
        this.kxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kwD.onItemViewClick(view, 7, e.this.mPosition, 0L);
            }
        });
        this.kxb.setLongClickable(true);
        this.kxb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kwE.onItemViewLongClick(view, 7, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kxd.setClickable(true);
        this.kxd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kwD.onItemViewClick(view, 10, e.this.mPosition, 0L);
            }
        });
        this.kxd.setLongClickable(true);
        this.kxd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kwE.onItemViewLongClick(view, 10, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kxe.setClickable(true);
        this.kxe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kwD.onItemViewClick(view, 15, e.this.mPosition, 0L);
            }
        });
        this.kxe.setLongClickable(true);
        this.kxe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kwE.onItemViewLongClick(view, 15, e.this.mPosition, 0L);
                return true;
            }
        });
        this.kxf.getContentBody().setClickable(true);
        this.kxf.getContentBody().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kwD.onItemViewClick(view, 11, e.this.mPosition, 0L);
            }
        });
        this.kxf.getTail().setClickable(true);
        this.kxf.getTail().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.kwD.onItemViewClick(view, 12, e.this.mPosition, 0L);
            }
        });
        this.kxf.getContentBody().setLongClickable(true);
        this.kxf.getContentBody().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.kwE.onItemViewLongClick(view, 11, e.this.mPosition, 0L);
                return true;
            }
        });
        if (this.kxc != null) {
            this.kxc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.e.8
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    e.this.kwE.onItemViewLongClick(view, 17, e.this.mPosition, 0L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DX(int i) {
        this.kxg.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean gI = gI(chatMessage.getTime());
        if (z || gI) {
            this.gFk.setVisibility(0);
            this.gFk.setText(gJ(chatMessage.getTime()));
        } else {
            this.gFk.setVisibility(8);
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
        h.a(this.mContext.getContext(), this.kwZ, chatMessage, str, this.kwM);
        if (chatMessage != null && chatMessage.getContent() != null) {
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
            }
            this.kwZ.setContentDescription(stringBuffer.toString());
            this.kwZ.getTextView().setContentDescription(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kxg, chatMessage, this.kwY, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), this.kxa, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChatMessage chatMessage, boolean z) {
        h.a(this.mContext.getContext(), this.kxb, chatMessage, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, ChatMessage chatMessage, String str) {
        h.a((TbPageContext) this.mContext, this.mContext.getContext(), view, this.kxc, chatMessage, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, ChatMessage chatMessage, String str) {
        h.a(this.mContext.getContext(), view, this.kxd, this.kxe, this.kxf, chatMessage, str);
    }

    public void su(boolean z) {
        this.kxh = z;
    }

    public void sv(boolean z) {
        this.kxi = z;
    }

    public void DW(int i) {
        this.kwM = i;
    }
}
