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
    private View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.eDA.getCancelView()) {
                if (view != a.this.eDA.getLayerView()) {
                    if (view == a.this.eDA.getUpInfoView()) {
                        a.this.aUv();
                        if (a.this.aYy()) {
                            a.this.TU();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eDA.getPushView()) {
                        if (a.this.eDB != null) {
                            a.this.eDB.a(18, null, null, -1);
                        }
                        if (a.this.aYy()) {
                            a.this.TU();
                        }
                    }
                } else if (a.this.aYy()) {
                    a.this.TU();
                }
            } else if (a.this.aYy()) {
                a.this.TU();
            }
        }
    };
    private Runnable cvS;
    private d eCC;
    private ChannelMoreView eDA;
    private ChannelHomeActivity eDB;
    private k eDz;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eDB = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.eCC != null) {
            if (this.eDz == null) {
                this.eDA = new ChannelMoreView(this.eDB.getApplicationContext(), this.eCC, this.ckH);
                this.eDA.setBackGround();
                this.eDz = new k(this.eDB.getActivity(), this.eDA);
            }
            this.eDz.showAtLocation(this.eDB.findViewById(R.id.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void TU() {
        if (this.cvS == null) {
            this.cvS = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eDz != null) {
                        g.a(a.this.eDz, a.this.eDB.getPageContext().getPageActivity());
                        a.this.eDz = null;
                    }
                }
            };
        }
        e.iB().postDelayed(this.cvS, 100L);
    }

    public void b(d dVar) {
        this.eCC = dVar;
    }

    public boolean aYy() {
        return this.eDz != null && this.eDz.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eDA != null) {
            this.eDA.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUv() {
        if (this.eCC != null && this.eCC.aYC() != null) {
            ChannelInfo aYC = this.eCC.aYC();
            String valueOf = String.valueOf(aYC.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.eDB.getPageContext().getPageActivity()).createNormalConfig(aYC.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
