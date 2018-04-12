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
/* loaded from: classes3.dex */
public class a {
    private Runnable aHT;
    private View.OnClickListener axG = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != a.this.cuz.getCancelView()) {
                if (view2 != a.this.cuz.getLayerView()) {
                    if (view2 == a.this.cuz.getUpInfoView()) {
                        a.this.acd();
                        if (a.this.agf()) {
                            a.this.pr();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view2 == a.this.cuz.getPushView()) {
                        if (a.this.cuA != null) {
                            a.this.cuA.a(18, null, null, -1);
                        }
                        if (a.this.agf()) {
                            a.this.pr();
                        }
                    }
                } else if (a.this.agf()) {
                    a.this.pr();
                }
            } else if (a.this.agf()) {
                a.this.pr();
            }
        }
    };
    private d cty;
    private ChannelHomeActivity cuA;
    private k cuy;
    private ChannelMoreView cuz;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cuA = channelHomeActivity;
    }

    public void age() {
        if (this.cty != null) {
            if (this.cuy == null) {
                this.cuz = new ChannelMoreView(this.cuA.getApplicationContext(), this.cty, this.axG);
                this.cuz.setBackGround();
                this.cuy = new k(this.cuA.getActivity(), this.cuz);
            }
            this.cuy.showAtLocation(this.cuA.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void pr() {
        if (this.aHT == null) {
            this.aHT = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cuy != null) {
                        g.a(a.this.cuy, a.this.cuA.getPageContext().getPageActivity());
                        a.this.cuy = null;
                    }
                }
            };
        }
        e.fw().postDelayed(this.aHT, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.cty = dVar;
    }

    public boolean agf() {
        return this.cuy != null && this.cuy.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cuz != null) {
            this.cuz.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acd() {
        if (this.cty != null && this.cty.agj() != null) {
            ChannelInfo agj = this.cty.agj();
            String valueOf = String.valueOf(agj.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cuA.getPageContext().getPageActivity()).createNormalConfig(agj.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
