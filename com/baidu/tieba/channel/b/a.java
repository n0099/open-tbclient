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
    private Runnable aHU;
    private View.OnClickListener axH = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != a.this.cvF.getCancelView()) {
                if (view2 != a.this.cvF.getLayerView()) {
                    if (view2 == a.this.cvF.getUpInfoView()) {
                        a.this.ace();
                        if (a.this.agf()) {
                            a.this.pq();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view2 == a.this.cvF.getPushView()) {
                        if (a.this.cvG != null) {
                            a.this.cvG.a(18, null, null, -1);
                        }
                        if (a.this.agf()) {
                            a.this.pq();
                        }
                    }
                } else if (a.this.agf()) {
                    a.this.pq();
                }
            } else if (a.this.agf()) {
                a.this.pq();
            }
        }
    };
    private d cuF;
    private k cvE;
    private ChannelMoreView cvF;
    private ChannelHomeActivity cvG;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.cvG = channelHomeActivity;
    }

    public void age() {
        if (this.cuF != null) {
            if (this.cvE == null) {
                this.cvF = new ChannelMoreView(this.cvG.getApplicationContext(), this.cuF, this.axH);
                this.cvF.setBackGround();
                this.cvE = new k(this.cvG.getActivity(), this.cvF);
            }
            this.cvE.showAtLocation(this.cvG.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void pq() {
        if (this.aHU == null) {
            this.aHU = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cvE != null) {
                        g.a(a.this.cvE, a.this.cvG.getPageContext().getPageActivity());
                        a.this.cvE = null;
                    }
                }
            };
        }
        e.fw().postDelayed(this.aHU, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.cuF = dVar;
    }

    public boolean agf() {
        return this.cvE != null && this.cvE.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.cvF != null) {
            this.cvF.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ace() {
        if (this.cuF != null && this.cuF.agj() != null) {
            ChannelInfo agj = this.cuF.agj();
            String valueOf = String.valueOf(agj.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cvG.getPageContext().getPageActivity()).createNormalConfig(agj.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
