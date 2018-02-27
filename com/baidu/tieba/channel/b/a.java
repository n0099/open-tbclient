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
import com.baidu.tieba.channel.view.k;
import com.baidu.tieba.channel.view.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener blQ = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.dcD.getCancelView()) {
                if (view != a.this.dcD.getLayerView()) {
                    if (view == a.this.dcD.getUpInfoView()) {
                        a.this.ahW();
                        if (a.this.ame()) {
                            a.this.wH();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.dcD.getPushView()) {
                        if (a.this.dcE != null) {
                            a.this.dcE.a(18, null, null, -1);
                        }
                        if (a.this.ame()) {
                            a.this.wH();
                        }
                    }
                } else if (a.this.ame()) {
                    a.this.wH();
                }
            } else if (a.this.ame()) {
                a.this.wH();
            }
        }
    };
    private Runnable bxt;
    private d dbC;
    private k dcC;
    private l dcD;
    private ChannelHomeActivity dcE;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.dcE = channelHomeActivity;
    }

    public void amd() {
        if (this.dbC != null) {
            if (this.dcC == null) {
                this.dcD = new l(this.dcE.getApplicationContext(), this.dbC, this.blQ);
                this.dcD.amH();
                this.dcC = new k(this.dcE.getActivity(), this.dcD);
            }
            this.dcC.showAtLocation(this.dcE.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void wH() {
        if (this.bxt == null) {
            this.bxt = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dcC != null) {
                        g.a(a.this.dcC, a.this.dcE.getPageContext().getPageActivity());
                        a.this.dcC = null;
                    }
                }
            };
        }
        e.ns().postDelayed(this.bxt, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.dbC = dVar;
    }

    public boolean ame() {
        return this.dcC != null && this.dcC.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.dcD != null) {
            this.dcD.amH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahW() {
        if (this.dbC != null && this.dbC.ami() != null) {
            ChannelInfo ami = this.dbC.ami();
            String valueOf = String.valueOf(ami.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.dcE.getPageContext().getPageActivity()).createNormalConfig(ami.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
