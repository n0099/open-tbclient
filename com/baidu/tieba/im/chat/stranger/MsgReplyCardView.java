package com.baidu.tieba.im.chat.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.az;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class MsgReplyCardView extends az {
    private LinearLayout aUi;
    private TextView aUj;
    private TextView aUk;
    private TextView aUl;
    private TextView aUm;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, x.msg_reply_card_view);
        init();
    }

    private void init() {
        this.aUi = (LinearLayout) findViewById(w.reply_card);
        this.aUj = (TextView) findViewById(w.reply_title);
        this.aUk = (TextView) findViewById(w.reply_content);
        this.aUl = (TextView) findViewById(w.reply_quote_content);
        this.aUm = (TextView) findViewById(w.reply_frs_name);
        this.aUi.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c ga = b.ga(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.aUj.setText(a(ga, valueOf));
            this.aUk.setText(ga.replyContent);
            this.aUl.setText(b(ga, valueOf));
            this.aUm.setText(String.valueOf(ga.aUv) + this.mContext.getString(z.bar));
        }
    }

    private String a(c cVar, String str) {
        String string;
        String fw;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = fw(cVar.aUp);
            fw = this.mContext.getString(z.you);
        } else {
            string = this.mContext.getString(z.you);
            fw = fw(cVar.aUp);
        }
        return String.format(this.mContext.getString(z.add_friend_card_title), string, getType(cVar.type), fw);
    }

    private String b(c cVar, String str) {
        String fw;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            fw = this.mContext.getString(z.me);
        } else {
            fw = fw(cVar.aUp);
        }
        if (cVar.type == 1) {
            sb.append(String.format(this.mContext.getString(z.add_friend_card_quote_comment), fw));
            sb.append(cVar.aUt);
        } else {
            sb.append(String.format(this.mContext.getString(z.add_friend_card_quote_thread), fw));
            sb.append(cVar.title);
        }
        return sb.toString();
    }

    private String fw(int i) {
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
