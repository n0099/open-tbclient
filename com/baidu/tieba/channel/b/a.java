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
    private View.OnClickListener ccC = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.enP.getCancelView()) {
                if (view != a.this.enP.getLayerView()) {
                    if (view == a.this.enP.getUpInfoView()) {
                        a.this.aOi();
                        if (a.this.aRm()) {
                            a.this.Qi();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.enP.getPushView()) {
                        if (a.this.enQ != null) {
                            a.this.enQ.a(18, null, null, -1);
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
    private Runnable cnK;
    private d emP;
    private k enO;
    private ChannelMoreView enP;
    private ChannelHomeActivity enQ;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.enQ = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.emP != null) {
            if (this.enO == null) {
                this.enP = new ChannelMoreView(this.enQ.getApplicationContext(), this.emP, this.ccC);
                this.enP.setBackGround();
                this.enO = new k(this.enQ.getActivity(), this.enP);
            }
            this.enO.showAtLocation(this.enQ.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void Qi() {
        if (this.cnK == null) {
            this.cnK = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.enO != null) {
                        g.a(a.this.enO, a.this.enQ.getPageContext().getPageActivity());
                        a.this.enO = null;
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnK, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.emP = dVar;
    }

    public boolean aRm() {
        return this.enO != null && this.enO.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.enP != null) {
            this.enP.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOi() {
        if (this.emP != null && this.emP.aRq() != null) {
            ChannelInfo aRq = this.emP.aRq();
            String valueOf = String.valueOf(aRq.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.enQ.getPageContext().getPageActivity()).createNormalConfig(aRq.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
