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
/* loaded from: classes6.dex */
public class a {
    private View.OnClickListener ccD = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.enQ.getCancelView()) {
                if (view != a.this.enQ.getLayerView()) {
                    if (view == a.this.enQ.getUpInfoView()) {
                        a.this.aOi();
                        if (a.this.aRm()) {
                            a.this.Qi();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.enQ.getPushView()) {
                        if (a.this.enR != null) {
                            a.this.enR.a(18, null, null, -1);
                        }
                        if (a.this.aRm()) {
                            a.this.Qi();
                        }
                    }
                } else if (a.this.aRm()) {
                    a.this.Qi();
                }
            } else if (a.this.aRm()) {
                a.this.Qi();
            }
        }
    };
    private Runnable cnL;
    private d emQ;
    private k enP;
    private ChannelMoreView enQ;
    private ChannelHomeActivity enR;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.enR = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.emQ != null) {
            if (this.enP == null) {
                this.enQ = new ChannelMoreView(this.enR.getApplicationContext(), this.emQ, this.ccD);
                this.enQ.setBackGround();
                this.enP = new k(this.enR.getActivity(), this.enQ);
            }
            this.enP.showAtLocation(this.enR.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void Qi() {
        if (this.cnL == null) {
            this.cnL = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.enP != null) {
                        g.a(a.this.enP, a.this.enR.getPageContext().getPageActivity());
                        a.this.enP = null;
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnL, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.emQ = dVar;
    }

    public boolean aRm() {
        return this.enP != null && this.enP.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.enQ != null) {
            this.enQ.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOi() {
        if (this.emQ != null && this.emQ.aRq() != null) {
            ChannelInfo aRq = this.emQ.aRq();
            String valueOf = String.valueOf(aRq.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.enR.getPageContext().getPageActivity()).createNormalConfig(aRq.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
