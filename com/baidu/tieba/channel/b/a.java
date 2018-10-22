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
    private View.OnClickListener aOJ = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cSN.getCancelView()) {
                if (view != a.this.cSN.getLayerView()) {
                    if (view == a.this.cSN.getUpInfoView()) {
                        a.this.alY();
                        if (a.this.aoW()) {
                            a.this.vO();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.cSN.getPushView()) {
                        if (a.this.cSO != null) {
                            a.this.cSO.a(18, null, null, -1);
                        }
                        if (a.this.aoW()) {
                            a.this.vO();
                        }
                    }
                } else if (a.this.aoW()) {
                    a.this.vO();
                }
            } else if (a.this.aoW()) {
                a.this.vO();
            }
        }
    };
    private Runnable aZb;
    private d cRO;
    private k cSM;
    private ChannelMoreView cSN;
    private ChannelHomeActivity cSO;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cSO = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.cRO != null) {
            if (this.cSM == null) {
                this.cSN = new ChannelMoreView(this.cSO.getApplicationContext(), this.cRO, this.aOJ);
                this.cSN.setBackGround();
                this.cSM = new k(this.cSO.getActivity(), this.cSN);
            }
            this.cSM.showAtLocation(this.cSO.findViewById(e.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void vO() {
        if (this.aZb == null) {
            this.aZb = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cSM != null) {
                        g.a(a.this.cSM, a.this.cSO.getPageContext().getPageActivity());
                        a.this.cSM = null;
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jI().postDelayed(this.aZb, 100L);
    }

    public void b(d dVar) {
        this.cRO = dVar;
    }

    public boolean aoW() {
        return this.cSM != null && this.cSM.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cSN != null) {
            this.cSN.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alY() {
        if (this.cRO != null && this.cRO.apa() != null) {
            ChannelInfo apa = this.cRO.apa();
            String valueOf = String.valueOf(apa.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cSO.getPageContext().getPageActivity()).createNormalConfig(apa.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
