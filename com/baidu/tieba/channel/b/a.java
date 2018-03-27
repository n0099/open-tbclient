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
import com.baidu.tieba.channel.view.k;
import com.baidu.tieba.channel.view.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener blT = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.dcG.getCancelView()) {
                if (view != a.this.dcG.getLayerView()) {
                    if (view == a.this.dcG.getUpInfoView()) {
                        a.this.ahX();
                        if (a.this.amf()) {
                            a.this.wH();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.dcG.getPushView()) {
                        if (a.this.dcH != null) {
                            a.this.dcH.a(18, null, null, -1);
                        }
                        if (a.this.amf()) {
                            a.this.wH();
                        }
                    }
                } else if (a.this.amf()) {
                    a.this.wH();
                }
            } else if (a.this.amf()) {
                a.this.wH();
            }
        }
    };
    private Runnable bxw;
    private d dbF;
    private k dcF;
    private l dcG;
    private ChannelHomeActivity dcH;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.dcH = channelHomeActivity;
    }

    public void ame() {
        if (this.dbF != null) {
            if (this.dcF == null) {
                this.dcG = new l(this.dcH.getApplicationContext(), this.dbF, this.blT);
                this.dcG.amI();
                this.dcF = new k(this.dcH.getActivity(), this.dcG);
            }
            this.dcF.showAtLocation(this.dcH.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void wH() {
        if (this.bxw == null) {
            this.bxw = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dcF != null) {
                        g.a(a.this.dcF, a.this.dcH.getPageContext().getPageActivity());
                        a.this.dcF = null;
                    }
                }
            };
        }
        e.ns().postDelayed(this.bxw, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.dbF = dVar;
    }

    public boolean amf() {
        return this.dcF != null && this.dcF.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.dcG != null) {
            this.dcG.amI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahX() {
        if (this.dbF != null && this.dbF.amj() != null) {
            ChannelInfo amj = this.dbF.amj();
            String valueOf = String.valueOf(amj.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.dcH.getPageContext().getPageActivity()).createNormalConfig(amj.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
