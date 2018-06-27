package com.baidu.tieba.channel.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.data.d;
import com.baidu.tieba.channel.view.ChannelMoreView;
import com.baidu.tieba.channel.view.k;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener aGU = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cCb.getCancelView()) {
                if (view != a.this.cCb.getLayerView()) {
                    if (view == a.this.cCb.getUpInfoView()) {
                        a.this.agk();
                        if (a.this.ajh()) {
                            a.this.sN();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.cCb.getPushView()) {
                        if (a.this.cCc != null) {
                            a.this.cCc.a(18, null, null, -1);
                        }
                        if (a.this.ajh()) {
                            a.this.sN();
                        }
                    }
                } else if (a.this.ajh()) {
                    a.this.sN();
                }
            } else if (a.this.ajh()) {
                a.this.sN();
            }
        }
    };
    private Runnable aRn;
    private d cBc;
    private k cCa;
    private ChannelMoreView cCb;
    private ChannelHomeActivity cCc;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cCc = channelHomeActivity;
    }

    public void ajg() {
        if (this.cBc != null) {
            if (this.cCa == null) {
                this.cCb = new ChannelMoreView(this.cCc.getApplicationContext(), this.cBc, this.aGU);
                this.cCb.setBackGround();
                this.cCa = new k(this.cCc.getActivity(), this.cCb);
            }
            this.cCa.showAtLocation(this.cCc.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void sN() {
        if (this.aRn == null) {
            this.aRn = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cCa != null) {
                        g.a(a.this.cCa, a.this.cCc.getPageContext().getPageActivity());
                        a.this.cCa = null;
                    }
                }
            };
        }
        e.im().postDelayed(this.aRn, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.cBc = dVar;
    }

    public boolean ajh() {
        return this.cCa != null && this.cCa.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cCb != null) {
            this.cCb.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agk() {
        if (this.cBc != null && this.cBc.ajl() != null) {
            ChannelInfo ajl = this.cBc.ajl();
            String valueOf = String.valueOf(ajl.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cCc.getPageContext().getPageActivity()).createNormalConfig(ajl.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
