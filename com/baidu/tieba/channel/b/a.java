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
    private View.OnClickListener aTJ = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.deh.getCancelView()) {
                if (view != a.this.deh.getLayerView()) {
                    if (view == a.this.deh.getUpInfoView()) {
                        a.this.anD();
                        if (a.this.arx()) {
                            a.this.dismissPopMenu();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.deh.getPushView()) {
                        if (a.this.dei != null) {
                            a.this.dei.a(18, null, null, -1);
                        }
                        if (a.this.arx()) {
                            a.this.dismissPopMenu();
                        }
                    }
                } else if (a.this.arx()) {
                    a.this.dismissPopMenu();
                }
            } else if (a.this.arx()) {
                a.this.dismissPopMenu();
            }
        }
    };
    private Runnable bea;
    private d ddh;
    private k deg;
    private ChannelMoreView deh;
    private ChannelHomeActivity dei;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.dei = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.ddh != null) {
            if (this.deg == null) {
                this.deh = new ChannelMoreView(this.dei.getApplicationContext(), this.ddh, this.aTJ);
                this.deh.setBackGround();
                this.deg = new k(this.dei.getActivity(), this.deh);
            }
            this.deg.showAtLocation(this.dei.findViewById(e.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void dismissPopMenu() {
        if (this.bea == null) {
            this.bea = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.deg != null) {
                        g.a(a.this.deg, a.this.dei.getPageContext().getPageActivity());
                        a.this.deg = null;
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bea, 100L);
    }

    public void b(d dVar) {
        this.ddh = dVar;
    }

    public boolean arx() {
        return this.deg != null && this.deg.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.deh != null) {
            this.deh.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        if (this.ddh != null && this.ddh.arB() != null) {
            ChannelInfo arB = this.ddh.arB();
            String valueOf = String.valueOf(arB.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.dei.getPageContext().getPageActivity()).createNormalConfig(arB.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
