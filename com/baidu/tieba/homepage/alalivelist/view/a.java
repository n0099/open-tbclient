package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaAttentionLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private HeadImageView bqp;
    private HeadImageView bqq;
    private HeadImageView bqr;
    private ImageView bqs;
    private View cvI;
    private ArrayList<String> czc;
    private com.baidu.tieba.homepage.alalivelist.a.c czd;
    private InterfaceC0062a cze;
    private LinearLayout czf;
    View.OnClickListener czg;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.c cVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.czg = new b(this);
        this.mContext = context;
        bg(context);
    }

    private void bg(Context context) {
        inflate(context, w.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(w.h.ala_attention_tip_title_txt);
        this.bqs = (ImageView) findViewById(w.h.ala_attention_tip_arrow_img);
        this.bqp = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img1);
        this.bqq = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img2);
        this.bqr = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img3);
        this.czf = (LinearLayout) findViewById(w.h.ala_attention_tip_linear);
        this.cvI = findViewById(w.h.ala_attention_tip_bottom);
        setOnClickListener(new c(this));
        this.bqp.setOnClickListener(this.czg);
        this.bqq.setOnClickListener(this.czg);
        this.bqr.setOnClickListener(this.czg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                jT(forcusUsers.user_name);
            } else if (i == 50) {
                jU(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void jT(String str) {
        if (!com.baidu.adp.lib.util.i.hk()) {
            com.baidu.adp.lib.util.k.showToast(this.mContext, w.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new as("c11829").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void jU(String str) {
        TiebaStatic.log(new as("c11830").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aip() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bqs != null) {
            this.bqs.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bqp.setVisibility(0);
                this.bqp.setIsRound(true);
                this.bqp.c(arrayList.get(0), 12, false);
            } else {
                this.bqp.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bqq.setVisibility(0);
                this.bqq.setIsRound(true);
                this.bqq.c(arrayList.get(1), 12, false);
            } else {
                this.bqq.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bqr.setVisibility(0);
                this.bqr.setIsRound(true);
                this.bqr.c(arrayList.get(2), 12, false);
                return;
            }
            this.bqr.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.c cVar) {
        this.czd = cVar;
        int i = cVar.cyT;
        List<ForcusUsers> list = cVar.cyU;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_record));
        }
        if (this.czc == null) {
            this.czc = new ArrayList<>();
        }
        this.czc.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.czc.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.czc);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.k(this.czf, w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_b);
            aq.k(this.cvI, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0062a interfaceC0062a) {
        this.cze = interfaceC0062a;
    }
}
