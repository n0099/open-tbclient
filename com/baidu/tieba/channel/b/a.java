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
    private View.OnClickListener clU = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.eIw.getCancelView()) {
                if (view != a.this.eIw.getLayerView()) {
                    if (view == a.this.eIw.getUpInfoView()) {
                        a.this.aWt();
                        if (a.this.bax()) {
                            a.this.UM();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eIw.getPushView()) {
                        if (a.this.eIx != null) {
                            a.this.eIx.a(18, null, null, -1);
                        }
                        if (a.this.bax()) {
                            a.this.UM();
                        }
                    }
                } else if (a.this.bax()) {
                    a.this.UM();
                }
            } else if (a.this.bax()) {
                a.this.UM();
            }
        }
    };
    private Runnable cxi;
    private d eHy;
    private k eIv;
    private ChannelMoreView eIw;
    private ChannelHomeActivity eIx;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eIx = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.eHy != null) {
            if (this.eIv == null) {
                this.eIw = new ChannelMoreView(this.eIx.getApplicationContext(), this.eHy, this.clU);
                this.eIw.setBackGround();
                this.eIv = new k(this.eIx.getActivity(), this.eIw);
            }
            this.eIv.showAtLocation(this.eIx.findViewById(R.id.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void UM() {
        if (this.cxi == null) {
            this.cxi = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eIv != null) {
                        g.a(a.this.eIv, a.this.eIx.getPageContext().getPageActivity());
                        a.this.eIv = null;
                    }
                }
            };
        }
        e.iK().postDelayed(this.cxi, 100L);
    }

    public void b(d dVar) {
        this.eHy = dVar;
    }

    public boolean bax() {
        return this.eIv != null && this.eIv.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eIw != null) {
            this.eIw.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWt() {
        if (this.eHy != null && this.eHy.baB() != null) {
            ChannelInfo baB = this.eHy.baB();
            String valueOf = String.valueOf(baB.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.eIx.getPageContext().getPageActivity()).createNormalConfig(baB.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
