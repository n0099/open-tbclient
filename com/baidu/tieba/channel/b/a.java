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
    private View.OnClickListener cmX = new View.OnClickListener() { // from class: com.baidu.tieba.channel.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.eKm.getCancelView()) {
                if (view != a.this.eKm.getLayerView()) {
                    if (view == a.this.eKm.getUpInfoView()) {
                        a.this.aWZ();
                        if (a.this.bbd()) {
                            a.this.UQ();
                        }
                        TiebaStatic.log("c11994");
                    } else if (view == a.this.eKm.getPushView()) {
                        if (a.this.eKn != null) {
                            a.this.eKn.a(18, null, null, -1);
                        }
                        if (a.this.bbd()) {
                            a.this.UQ();
                        }
                    }
                } else if (a.this.bbd()) {
                    a.this.UQ();
                }
            } else if (a.this.bbd()) {
                a.this.UQ();
            }
        }
    };
    private Runnable cyl;
    private d eJo;
    private k eKl;
    private ChannelMoreView eKm;
    private ChannelHomeActivity eKn;

    public a(ChannelHomeActivity channelHomeActivity) {
        this.eKn = channelHomeActivity;
    }

    public void showPopWindow() {
        if (this.eJo != null) {
            if (this.eKl == null) {
                this.eKm = new ChannelMoreView(this.eKn.getApplicationContext(), this.eJo, this.cmX);
                this.eKm.setBackGround();
                this.eKl = new k(this.eKn.getActivity(), this.eKm);
            }
            this.eKl.showAtLocation(this.eKn.findViewById(R.id.channel_home_navigation_bar), 17, 0, 0);
        }
    }

    public void UQ() {
        if (this.cyl == null) {
            this.cyl = new Runnable() { // from class: com.baidu.tieba.channel.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eKl != null) {
                        g.a(a.this.eKl, a.this.eKn.getPageContext().getPageActivity());
                        a.this.eKl = null;
                    }
                }
            };
        }
        e.iK().postDelayed(this.cyl, 100L);
    }

    public void b(d dVar) {
        this.eJo = dVar;
    }

    public boolean bbd() {
        return this.eKl != null && this.eKl.isShowing();
    }

    public void onChangeSkinType(int i) {
        if (this.eKm != null) {
            this.eKm.setBackGround();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWZ() {
        if (this.eJo != null && this.eJo.bbh() != null) {
            ChannelInfo bbh = this.eJo.bbh();
            String valueOf = String.valueOf(bbh.getUserId());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.eKn.getPageContext().getPageActivity()).createNormalConfig(bbh.getUserId(), !TextUtils.isEmpty(currentAccount) && currentAccount.equals(valueOf), false)));
        }
    }
}
