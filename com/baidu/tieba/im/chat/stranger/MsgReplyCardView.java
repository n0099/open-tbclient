package com.baidu.tieba.im.chat.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bc;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class MsgReplyCardView extends bc {
    private LinearLayout aVB;
    private TextView aVC;
    private TextView aVD;
    private TextView aVE;
    private TextView aVF;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, x.msg_reply_card_view);
        init();
    }

    private void init() {
        this.aVB = (LinearLayout) findViewById(w.reply_card);
        this.aVC = (TextView) findViewById(w.reply_title);
        this.aVD = (TextView) findViewById(w.reply_content);
        this.aVE = (TextView) findViewById(w.reply_quote_content);
        this.aVF = (TextView) findViewById(w.reply_frs_name);
        this.aVB.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c gf = b.gf(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.aVC.setText(a(gf, valueOf));
            this.aVD.setText(gf.replyContent);
            this.aVE.setText(b(gf, valueOf));
            this.aVF.setText(String.valueOf(gf.aVO) + this.mContext.getString(z.bar));
        }
    }

    private String a(c cVar, String str) {
        String string;
        String fB;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = fB(cVar.aVI);
            fB = this.mContext.getString(z.you);
        } else {
            string = this.mContext.getString(z.you);
            fB = fB(cVar.aVI);
        }
        return String.format(this.mContext.getString(z.add_friend_card_title), string, getType(cVar.type), fB);
    }

    private String b(c cVar, String str) {
        String fB;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            fB = this.mContext.getString(z.me);
        } else {
            fB = fB(cVar.aVI);
        }
        if (cVar.type == 1) {
            sb.append(String.format(this.mContext.getString(z.add_friend_card_quote_comment), fB));
            sb.append(cVar.aVM);
        } else {
            sb.append(String.format(this.mContext.getString(z.add_friend_card_quote_thread), fB));
            sb.append(cVar.title);
        }
        return sb.toString();
    }

    private String fB(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(z.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(z.she);
        }
        return this.mContext.getResources().getString(z.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(z.add_friend_card_title_comment) : this.mContext.getResources().getString(z.add_friend_card_title_thread);
    }
}
