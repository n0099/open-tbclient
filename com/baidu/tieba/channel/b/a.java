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
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.eSR.getCancelView()) {
                if (view != a.this.eSR.getLayerView()) {
                    if (view == a.this.eSR.getUpInfoView()) {
                        a.this.bbh();
                        if (a.this.bbg()) {
                            a.this.ZF();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eSR.getPushView()) {
                        if (a.this.eSS != null) {
                            a.this.eSS.a(18, null, null, -1);
                        }
                        if (a.this.bbg()) {
                            a.this.ZF();
                        }
                    }
                } else if (a.this.bbg()) {
                    a.this.ZF();
                }
            } else if (a.this.bbg()) {
                a.this.ZF();
            }
        }
    };
    private d eRT;
    private k eSQ;
    private ChannelMoreView eSR;
    private ChannelHomeActivity eSS;
    private Runnable runnable;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eSS = channelHomeActivity;
    }

    public void bbf() {
        if (this.eRT != null) {
            if (this.eSQ == null) {
                this.eSR = new ChannelMoreView(this.eSS.getApplicationContext(), this.eRT, this.czV);
                this.eSR.setBackGround();
                this.eSQ = new k(this.eSS.getActivity(), this.eSR);
            }
            this.eSQ.showAtLocation(this.eSS.findViewById(R.id.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void ZF() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eSQ != null) {
                        g.dismissPopupWindow(a.this.eSQ, a.this.eSS.getPageContext().getPageActivity());
                        a.this.eSQ = null;
                    }
                }
            };
        }
        e.fZ().postDelayed(this.runnable, 100L);
    }

    public void b(d dVar) {
        this.eRT = dVar;
    }

    public boolean bbg() {
        return this.eSQ != null && this.eSQ.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eSR != null) {
            this.eSR.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbh() {
        if (this.eRT != null && this.eRT.bbl() != null) {
            ChannelInfo bbl = this.eRT.bbl();
            String valueOf = String.valueOf(bbl.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eSS.getPageContext().getPageActivity()).createNormalConfig(bbl.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
