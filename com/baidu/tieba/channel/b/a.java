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
    private View.OnClickListener aKh = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cKu.getCancelView()) {
                if (view != a.this.cKu.getLayerView()) {
                    if (view == a.this.cKu.getUpInfoView()) {
                        a.this.ais();
                        if (a.this.alt()) {
                            a.this.tF();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.cKu.getPushView()) {
                        if (a.this.cKv != null) {
                            a.this.cKv.a(18, null, null, -1);
                        }
                        if (a.this.alt()) {
                            a.this.tF();
                        }
                    }
                } else if (a.this.alt()) {
                    a.this.tF();
                }
            } else if (a.this.alt()) {
                a.this.tF();
            }
        }
    };
    private Runnable aUC;
    private d cJv;
    private k cKt;
    private ChannelMoreView cKu;
    private ChannelHomeActivity cKv;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cKv = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.cJv != null) {
            if (this.cKt == null) {
                this.cKu = new ChannelMoreView(this.cKv.getApplicationContext(), this.cJv, this.aKh);
                this.cKu.setBackGround();
                this.cKt = new k(this.cKv.getActivity(), this.cKu);
            }
            this.cKt.showAtLocation(this.cKv.findViewById(e.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void tF() {
        if (this.aUC == null) {
            this.aUC = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cKt != null) {
                        g.a(a.this.cKt, a.this.cKv.getPageContext().getPageActivity());
                        a.this.cKt = null;
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jt().postDelayed(this.aUC, 100L);
    }

    public void b(d dVar) {
        this.cJv = dVar;
    }

    public boolean alt() {
        return this.cKt != null && this.cKt.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cKu != null) {
            this.cKu.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ais() {
        if (this.cJv != null && this.cJv.alx() != null) {
            ChannelInfo alx = this.cJv.alx();
            String valueOf = String.valueOf(alx.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cKv.getPageContext().getPageActivity()).createNormalConfig(alx.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
