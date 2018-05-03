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
            if (view2 != a.this.cuw.getCancelView()) {
                if (view2 != a.this.cuw.getLayerView()) {
                    if (view2 == a.this.cuw.getUpInfoView()) {
                        a.this.acd();
                        if (a.this.agf()) {
                            a.this.pr();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view2 == a.this.cuw.getPushView()) {
                        if (a.this.cux != null) {
                            a.this.cux.a(18, null, null, -1);
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
    private d ctu;
    private k cuv;
    private ChannelMoreView cuw;
    private ChannelHomeActivity cux;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cux = channelHomeActivity;
    }

    public void age() {
        if (this.ctu != null) {
            if (this.cuv == null) {
                this.cuw = new ChannelMoreView(this.cux.getApplicationContext(), this.ctu, this.axG);
                this.cuw.setBackGround();
                this.cuv = new k(this.cux.getActivity(), this.cuw);
            }
            this.cuv.showAtLocation(this.cux.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void pr() {
        if (this.aHT == null) {
            this.aHT = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cuv != null) {
                        g.a(a.this.cuv, a.this.cux.getPageContext().getPageActivity());
                        a.this.cuv = null;
                    }
                }
            };
        }
        e.fw().postDelayed(this.aHT, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.ctu = dVar;
    }

    public boolean agf() {
        return this.cuv != null && this.cuv.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cuw != null) {
            this.cuw.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acd() {
        if (this.ctu != null && this.ctu.agj() != null) {
            ChannelInfo agj = this.ctu.agj();
            String valueOf = String.valueOf(agj.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cux.getPageContext().getPageActivity()).createNormalConfig(agj.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
