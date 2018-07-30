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
    private View.OnClickListener aGU = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cEG.getCancelView()) {
                if (view != a.this.cEG.getLayerView()) {
                    if (view == a.this.cEG.getUpInfoView()) {
                        a.this.agE();
                        if (a.this.ajF()) {
                            a.this.sz();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.cEG.getPushView()) {
                        if (a.this.cEH != null) {
                            a.this.cEH.a(18, null, null, -1);
                        }
                        if (a.this.ajF()) {
                            a.this.sz();
                        }
                    }
                } else if (a.this.ajF()) {
                    a.this.sz();
                }
            } else if (a.this.ajF()) {
                a.this.sz();
            }
        }
    };
    private Runnable aRn;
    private d cDH;
    private k cEF;
    private ChannelMoreView cEG;
    private ChannelHomeActivity cEH;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cEH = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.cDH != null) {
            if (this.cEF == null) {
                this.cEG = new ChannelMoreView(this.cEH.getApplicationContext(), this.cDH, this.aGU);
                this.cEG.setBackGround();
                this.cEF = new k(this.cEH.getActivity(), this.cEG);
            }
            this.cEF.showAtLocation(this.cEH.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void sz() {
        if (this.aRn == null) {
            this.aRn = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cEF != null) {
                        g.a(a.this.cEF, a.this.cEH.getPageContext().getPageActivity());
                        a.this.cEF = null;
                    }
                }
            };
        }
        e.in().postDelayed(this.aRn, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.cDH = dVar;
    }

    public boolean ajF() {
        return this.cEF != null && this.cEF.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cEG != null) {
            this.cEG.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agE() {
        if (this.cDH != null && this.cDH.ajJ() != null) {
            ChannelInfo ajJ = this.cDH.ajJ();
            String valueOf = String.valueOf(ajJ.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cEH.getPageContext().getPageActivity()).createNormalConfig(ajJ.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
