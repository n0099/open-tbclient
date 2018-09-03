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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener aGT = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cED.getCancelView()) {
                if (view != a.this.cED.getLayerView()) {
                    if (view == a.this.cED.getUpInfoView()) {
                        a.this.agG();
                        if (a.this.ajI()) {
                            a.this.sy();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.cED.getPushView()) {
                        if (a.this.cEE != null) {
                            a.this.cEE.a(18, null, null, -1);
                        }
                        if (a.this.ajI()) {
                            a.this.sy();
                        }
                    }
                } else if (a.this.ajI()) {
                    a.this.sy();
                }
            } else if (a.this.ajI()) {
                a.this.sy();
            }
        }
    };
    private Runnable aRk;
    private d cDE;
    private k cEC;
    private ChannelMoreView cED;
    private ChannelHomeActivity cEE;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cEE = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.cDE != null) {
            if (this.cEC == null) {
                this.cED = new ChannelMoreView(this.cEE.getApplicationContext(), this.cDE, this.aGT);
                this.cED.setBackGround();
                this.cEC = new k(this.cEE.getActivity(), this.cED);
            }
            this.cEC.showAtLocation(this.cEE.findViewById(f.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void sy() {
        if (this.aRk == null) {
            this.aRk = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cEC != null) {
                        g.a(a.this.cEC, a.this.cEE.getPageContext().getPageActivity());
                        a.this.cEC = null;
                    }
                }
            };
        }
        e.in().postDelayed(this.aRk, 100L);
    }

    public void b(d dVar) {
        this.cDE = dVar;
    }

    public boolean ajI() {
        return this.cEC != null && this.cEC.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cED != null) {
            this.cED.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agG() {
        if (this.cDE != null && this.cDE.ajM() != null) {
            ChannelInfo ajM = this.cDE.ajM();
            String valueOf = String.valueOf(ajM.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cEE.getPageContext().getPageActivity()).createNormalConfig(ajM.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
