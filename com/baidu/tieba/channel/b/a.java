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
    private View.OnClickListener bmd = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.dcP.getCancelView()) {
                if (view != a.this.dcP.getLayerView()) {
                    if (view == a.this.dcP.getUpInfoView()) {
                        a.this.ahX();
                        if (a.this.amf()) {
                            a.this.wH();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.dcP.getPushView()) {
                        if (a.this.dcQ != null) {
                            a.this.dcQ.a(18, null, null, -1);
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
    private Runnable bxG;
    private d dbO;
    private k dcO;
    private l dcP;
    private ChannelHomeActivity dcQ;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.dcQ = channelHomeActivity;
    }

    public void ame() {
        if (this.dbO != null) {
            if (this.dcO == null) {
                this.dcP = new l(this.dcQ.getApplicationContext(), this.dbO, this.bmd);
                this.dcP.amI();
                this.dcO = new k(this.dcQ.getActivity(), this.dcP);
            }
            this.dcO.showAtLocation(this.dcQ.findViewById(d.g.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void wH() {
        if (this.bxG == null) {
            this.bxG = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dcO != null) {
                        g.a(a.this.dcO, a.this.dcQ.getPageContext().getPageActivity());
                        a.this.dcO = null;
                    }
                }
            };
        }
        e.ns().postDelayed(this.bxG, 100L);
    }

    public void b(com.baidu.tieba.channel.data.d dVar) {
        this.dbO = dVar;
    }

    public boolean amf() {
        return this.dcO != null && this.dcO.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.dcP != null) {
            this.dcP.amI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahX() {
        if (this.dbO != null && this.dbO.amj() != null) {
            ChannelInfo amj = this.dbO.amj();
            String valueOf = String.valueOf(amj.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.dcQ.getPageContext().getPageActivity()).createNormalConfig(amj.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
