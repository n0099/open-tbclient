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
    private View.OnClickListener ccA = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.eod.getCancelView()) {
                if (view != a.this.eod.getLayerView()) {
                    if (view == a.this.eod.getUpInfoView()) {
                        a.this.aOs();
                        if (a.this.aRo()) {
                            a.this.Qk();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eod.getPushView()) {
                        if (a.this.eoe != null) {
                            a.this.eoe.a(18, null, null, -1);
                        }
                        if (a.this.aRo()) {
                            a.this.Qk();
                        }
                    }
                } else if (a.this.aRo()) {
                    a.this.Qk();
                }
            } else if (a.this.aRo()) {
                a.this.Qk();
            }
        }
    };
    private Runnable cnI;
    private d ene;
    private k eoc;
    private ChannelMoreView eod;
    private ChannelHomeActivity eoe;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eoe = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.ene != null) {
            if (this.eoc == null) {
                this.eod = new ChannelMoreView(this.eoe.getApplicationContext(), this.ene, this.ccA);
                this.eod.setBackGround();
                this.eoc = new k(this.eoe.getActivity(), this.eod);
            }
            this.eoc.showAtLocation(this.eoe.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void Qk() {
        if (this.cnI == null) {
            this.cnI = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eoc != null) {
                        g.a(a.this.eoc, a.this.eoe.getPageContext().getPageActivity());
                        a.this.eoc = null;
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnI, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.ene = dVar;
    }

    public boolean aRo() {
        return this.eoc != null && this.eoc.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eod != null) {
            this.eod.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOs() {
        if (this.ene != null && this.ene.aRs() != null) {
            ChannelInfo aRs = this.ene.aRs();
            String valueOf = String.valueOf(aRs.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.eoe.getPageContext().getPageActivity()).createNormalConfig(aRs.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
