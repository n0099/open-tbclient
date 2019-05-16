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
            if (view != a.this.eDz.getCancelView()) {
                if (view != a.this.eDz.getLayerView()) {
                    if (view == a.this.eDz.getUpInfoView()) {
                        a.this.aUs();
                        if (a.this.aYv()) {
                            a.this.TU();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eDz.getPushView()) {
                        if (a.this.eDA != null) {
                            a.this.eDA.a(18, null, null, -1);
                        }
                        if (a.this.aYv()) {
                            a.this.TU();
                        }
                    }
                } else if (a.this.aYv()) {
                    a.this.TU();
                }
            } else if (a.this.aYv()) {
                a.this.TU();
            }
        }
    };
    private Runnable cvS;
    private d eCB;
    private ChannelHomeActivity eDA;
    private k eDy;
    private ChannelMoreView eDz;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eDA = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.eCB != null) {
            if (this.eDy == null) {
                this.eDz = new ChannelMoreView(this.eDA.getApplicationContext(), this.eCB, this.ckH);
                this.eDz.setBackGround();
                this.eDy = new k(this.eDA.getActivity(), this.eDz);
            }
            this.eDy.showAtLocation(this.eDA.findViewById(R.id.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void TU() {
        if (this.cvS == null) {
            this.cvS = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eDy != null) {
                        g.a(a.this.eDy, a.this.eDA.getPageContext().getPageActivity());
                        a.this.eDy = null;
                    }
                }
            };
        }
        e.iB().postDelayed(this.cvS, 100L);
    }

    public void b(d dVar) {
        this.eCB = dVar;
    }

    public boolean aYv() {
        return this.eDy != null && this.eDy.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eDz != null) {
            this.eDz.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUs() {
        if (this.eCB != null && this.eCB.aYz() != null) {
            ChannelInfo aYz = this.eCB.aYz();
            String valueOf = String.valueOf(aYz.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.eDA.getPageContext().getPageActivity()).createNormalConfig(aYz.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
