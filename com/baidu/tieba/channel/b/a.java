package com.baidu.tieba.channel.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.eSa.getCancelView()) {
                if (view != a.this.eSa.getLayerView()) {
                    if (view == a.this.eSa.getUpInfoView()) {
                        a.this.bbf();
                        if (a.this.bbe()) {
                            a.this.ZD();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eSa.getPushView()) {
                        if (a.this.eSb != null) {
                            a.this.eSb.a(18, null, null, -1);
                        }
                        if (a.this.bbe()) {
                            a.this.ZD();
                        }
                    }
                } else if (a.this.bbe()) {
                    a.this.ZD();
                }
            } else if (a.this.bbe()) {
                a.this.ZD();
            }
        }
    };
    private k eRZ;
    private d eRc;
    private ChannelMoreView eSa;
    private ChannelHomeActivity eSb;
    private Runnable runnable;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eSb = channelHomeActivity;
    }

    public void bbd() {
        if (this.eRc != null) {
            if (this.eRZ == null) {
                this.eSa = new ChannelMoreView(this.eSb.getApplicationContext(), this.eRc, this.cze);
                this.eSa.setBackGround();
                this.eRZ = new k(this.eSb.getActivity(), this.eSa);
            }
            this.eRZ.showAtLocation(this.eSb.findViewById(R.id.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void ZD() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eRZ != null) {
                        g.dismissPopupWindow(a.this.eRZ, a.this.eSb.getPageContext().getPageActivity());
                        a.this.eRZ = null;
                    }
                }
            };
        }
        e.fZ().postDelayed(this.runnable, 100L);
    }

    public void b(d dVar) {
        this.eRc = dVar;
    }

    public boolean bbe() {
        return this.eRZ != null && this.eRZ.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eSa != null) {
            this.eSa.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbf() {
        if (this.eRc != null && this.eRc.bbj() != null) {
            ChannelInfo bbj = this.eRc.bbj();
            String valueOf = String.valueOf(bbj.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eSb.getPageContext().getPageActivity()).createNormalConfig(bbj.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
