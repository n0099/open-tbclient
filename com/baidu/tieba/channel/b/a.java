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
    private View.OnClickListener aGc = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cEi.getCancelView()) {
                if (view != a.this.cEi.getLayerView()) {
                    if (view == a.this.cEi.getUpInfoView()) {
                        a.this.afC();
                        if (a.this.ajN()) {
                            a.this.sL();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.cEi.getPushView()) {
                        if (a.this.cEj != null) {
                            a.this.cEj.a(18, null, null, -1);
                        }
                        if (a.this.ajN()) {
                            a.this.sL();
                        }
                    }
                } else if (a.this.ajN()) {
                    a.this.sL();
                }
            } else if (a.this.ajN()) {
                a.this.sL();
            }
        }
    };
    private Runnable aQr;
    private d cDi;
    private k cEh;
    private ChannelMoreView cEi;
    private ChannelHomeActivity cEj;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cEj = channelHomeActivity;
    }

    public void ajM() {
        if (this.cDi != null) {
            if (this.cEh == null) {
                this.cEi = new ChannelMoreView(this.cEj.getApplicationContext(), this.cDi, this.aGc);
                this.cEi.setBackGround();
                this.cEh = new k(this.cEj.getActivity(), this.cEi);
            }
            this.cEh.showAtLocation(this.cEj.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void sL() {
        if (this.aQr == null) {
            this.aQr = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cEh != null) {
                        g.a(a.this.cEh, a.this.cEj.getPageContext().getPageActivity());
                        a.this.cEh = null;
                    }
                }
            };
        }
        e.im().postDelayed(this.aQr, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.cDi = dVar;
    }

    public boolean ajN() {
        return this.cEh != null && this.cEh.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cEi != null) {
            this.cEi.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afC() {
        if (this.cDi != null && this.cDi.ajR() != null) {
            ChannelInfo ajR = this.cDi.ajR();
            String valueOf = String.valueOf(ajR.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cEj.getPageContext().getPageActivity()).createNormalConfig(ajR.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
