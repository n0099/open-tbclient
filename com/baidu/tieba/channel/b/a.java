package com.baidu.tieba.channel.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.data.d;
import com.baidu.tieba.channel.view.ChannelMoreView;
import com.baidu.tieba.channel.view.k;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener aSY = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.daC.getCancelView()) {
                if (view != a.this.daC.getLayerView()) {
                    if (view == a.this.daC.getUpInfoView()) {
                        a.this.amE();
                        if (a.this.aqk()) {
                            a.this.dismissPopMenu();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.daC.getPushView()) {
                        if (a.this.daD != null) {
                            a.this.daD.a(18, null, null, -1);
                        }
                        if (a.this.aqk()) {
                            a.this.dismissPopMenu();
                        }
                    }
                } else if (a.this.aqk()) {
                    a.this.dismissPopMenu();
                }
            } else if (a.this.aqk()) {
                a.this.dismissPopMenu();
            }
        }
    };
    private Runnable bdm;
    private d cZB;
    private k daB;
    private ChannelMoreView daC;
    private ChannelHomeActivity daD;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.daD = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.cZB != null) {
            if (this.daB == null) {
                this.daC = new ChannelMoreView(this.daD.getApplicationContext(), this.cZB, this.aSY);
                this.daC.setBackGround();
                this.daB = new k(this.daD.getActivity(), this.daC);
            }
            this.daB.showAtLocation(this.daD.findViewById(e.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void dismissPopMenu() {
        if (this.bdm == null) {
            this.bdm = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.daB != null) {
                        g.a(a.this.daB, a.this.daD.getPageContext().getPageActivity());
                        a.this.daB = null;
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bdm, 100L);
    }

    public void b(d dVar) {
        this.cZB = dVar;
    }

    public boolean aqk() {
        return this.daB != null && this.daB.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.daC != null) {
            this.daC.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amE() {
        if (this.cZB != null && this.cZB.aqo() != null) {
            ChannelInfo aqo = this.cZB.aqo();
            String valueOf = String.valueOf(aqo.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.daD.getPageContext().getPageActivity()).createNormalConfig(aqo.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
