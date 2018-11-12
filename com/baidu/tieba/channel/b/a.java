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
    private View.OnClickListener aPz = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cTT.getCancelView()) {
                if (view != a.this.cTT.getLayerView()) {
                    if (view == a.this.cTT.getUpInfoView()) {
                        a.this.alx();
                        if (a.this.aox()) {
                            a.this.dismissPopMenu();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.cTT.getPushView()) {
                        if (a.this.cTU != null) {
                            a.this.cTU.a(18, null, null, -1);
                        }
                        if (a.this.aox()) {
                            a.this.dismissPopMenu();
                        }
                    }
                } else if (a.this.aox()) {
                    a.this.dismissPopMenu();
                }
            } else if (a.this.aox()) {
                a.this.dismissPopMenu();
            }
        }
    };
    private Runnable aZO;
    private d cSU;
    private k cTS;
    private ChannelMoreView cTT;
    private ChannelHomeActivity cTU;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cTU = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.cSU != null) {
            if (this.cTS == null) {
                this.cTT = new ChannelMoreView(this.cTU.getApplicationContext(), this.cSU, this.aPz);
                this.cTT.setBackGround();
                this.cTS = new k(this.cTU.getActivity(), this.cTT);
            }
            this.cTS.showAtLocation(this.cTU.findViewById(e.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void dismissPopMenu() {
        if (this.aZO == null) {
            this.aZO = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cTS != null) {
                        g.a(a.this.cTS, a.this.cTU.getPageContext().getPageActivity());
                        a.this.cTS = null;
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.aZO, 100L);
    }

    public void b(d dVar) {
        this.cSU = dVar;
    }

    public boolean aox() {
        return this.cTS != null && this.cTS.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cTT != null) {
            this.cTT.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alx() {
        if (this.cSU != null && this.cSU.aoB() != null) {
            ChannelInfo aoB = this.cSU.aoB();
            String valueOf = String.valueOf(aoB.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cTU.getPageContext().getPageActivity()).createNormalConfig(aoB.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
