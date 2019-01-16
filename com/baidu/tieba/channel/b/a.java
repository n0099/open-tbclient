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
    private View.OnClickListener aTI = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.deg.getCancelView()) {
                if (view != a.this.deg.getLayerView()) {
                    if (view == a.this.deg.getUpInfoView()) {
                        a.this.anD();
                        if (a.this.arx()) {
                            a.this.dismissPopMenu();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.deg.getPushView()) {
                        if (a.this.deh != null) {
                            a.this.deh.a(18, null, null, -1);
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
    private Runnable bdZ;
    private d ddg;
    private k def;
    private ChannelMoreView deg;
    private ChannelHomeActivity deh;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.deh = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.ddg != null) {
            if (this.def == null) {
                this.deg = new ChannelMoreView(this.deh.getApplicationContext(), this.ddg, this.aTI);
                this.deg.setBackGround();
                this.def = new k(this.deh.getActivity(), this.deg);
            }
            this.def.showAtLocation(this.deh.findViewById(e.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void dismissPopMenu() {
        if (this.bdZ == null) {
            this.bdZ = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.def != null) {
                        g.a(a.this.def, a.this.deh.getPageContext().getPageActivity());
                        a.this.def = null;
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bdZ, 100L);
    }

    public void b(d dVar) {
        this.ddg = dVar;
    }

    public boolean arx() {
        return this.def != null && this.def.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.deg != null) {
            this.deg.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        if (this.ddg != null && this.ddg.arB() != null) {
            ChannelInfo arB = this.ddg.arB();
            String valueOf = String.valueOf(arB.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.deh.getPageContext().getPageActivity()).createNormalConfig(arB.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
