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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.data.d;
import com.baidu.tieba.channel.view.ChannelMoreView;
import com.baidu.tieba.channel.view.k;
/* loaded from: classes6.dex */
public class a {
    private View.OnClickListener cmb = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.eID.getCancelView()) {
                if (view != a.this.eID.getLayerView()) {
                    if (view == a.this.eID.getUpInfoView()) {
                        a.this.aWv();
                        if (a.this.baz()) {
                            a.this.UM();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eID.getPushView()) {
                        if (a.this.eIE != null) {
                            a.this.eIE.a(18, null, null, -1);
                        }
                        if (a.this.baz()) {
                            a.this.UM();
                        }
                    }
                } else if (a.this.baz()) {
                    a.this.UM();
                }
            } else if (a.this.baz()) {
                a.this.UM();
            }
        }
    };
    private Runnable cxp;
    private d eHF;
    private k eIC;
    private ChannelMoreView eID;
    private ChannelHomeActivity eIE;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eIE = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.eHF != null) {
            if (this.eIC == null) {
                this.eID = new ChannelMoreView(this.eIE.getApplicationContext(), this.eHF, this.cmb);
                this.eID.setBackGround();
                this.eIC = new k(this.eIE.getActivity(), this.eID);
            }
            this.eIC.showAtLocation(this.eIE.findViewById(R.id.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void UM() {
        if (this.cxp == null) {
            this.cxp = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eIC != null) {
                        g.a(a.this.eIC, a.this.eIE.getPageContext().getPageActivity());
                        a.this.eIC = null;
                    }
                }
            };
        }
        e.iK().postDelayed(this.cxp, 100L);
    }

    public void b(d dVar) {
        this.eHF = dVar;
    }

    public boolean baz() {
        return this.eIC != null && this.eIC.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eID != null) {
            this.eID.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWv() {
        if (this.eHF != null && this.eHF.baD() != null) {
            ChannelInfo baD = this.eHF.baD();
            String valueOf = String.valueOf(baD.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.eIE.getPageContext().getPageActivity()).createNormalConfig(baD.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
