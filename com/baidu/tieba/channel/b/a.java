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
    private View.OnClickListener aTa = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.ddt.getCancelView()) {
                if (view != a.this.ddt.getLayerView()) {
                    if (view == a.this.ddt.getUpInfoView()) {
                        a.this.ang();
                        if (a.this.aqZ()) {
                            a.this.dismissPopMenu();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.ddt.getPushView()) {
                        if (a.this.ddv != null) {
                            a.this.ddv.a(18, null, null, -1);
                        }
                        if (a.this.aqZ()) {
                            a.this.dismissPopMenu();
                        }
                    }
                } else if (a.this.aqZ()) {
                    a.this.dismissPopMenu();
                }
            } else if (a.this.aqZ()) {
                a.this.dismissPopMenu();
            }
        }
    };
    private Runnable bdp;
    private d dct;
    private k dds;
    private ChannelMoreView ddt;
    private ChannelHomeActivity ddv;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.ddv = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.dct != null) {
            if (this.dds == null) {
                this.ddt = new ChannelMoreView(this.ddv.getApplicationContext(), this.dct, this.aTa);
                this.ddt.setBackGround();
                this.dds = new k(this.ddv.getActivity(), this.ddt);
            }
            this.dds.showAtLocation(this.ddv.findViewById(e.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void dismissPopMenu() {
        if (this.bdp == null) {
            this.bdp = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dds != null) {
                        g.a(a.this.dds, a.this.ddv.getPageContext().getPageActivity());
                        a.this.dds = null;
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bdp, 100L);
    }

    public void b(d dVar) {
        this.dct = dVar;
    }

    public boolean aqZ() {
        return this.dds != null && this.dds.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.ddt != null) {
            this.ddt.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ang() {
        if (this.dct != null && this.dct.ard() != null) {
            ChannelInfo ard = this.dct.ard();
            String valueOf = String.valueOf(ard.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.ddv.getPageContext().getPageActivity()).createNormalConfig(ard.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
