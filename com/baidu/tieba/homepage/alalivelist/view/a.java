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
    private HeadImageView bpi;
    private HeadImageView bpj;
    private HeadImageView bpk;
    private ImageView bpl;
    private View cpl;
    private ArrayList<String> csK;
    private com.baidu.tieba.homepage.alalivelist.a.c csL;
    private InterfaceC0064a csM;
    private LinearLayout csN;
    View.OnClickListener csO;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0064a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.c cVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.csO = new b(this);
        this.mContext = context;
        bf(context);
    }

    private void bf(Context context) {
        inflate(context, w.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(w.h.ala_attention_tip_title_txt);
        this.bpl = (ImageView) findViewById(w.h.ala_attention_tip_arrow_img);
        this.bpi = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img1);
        this.bpj = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img2);
        this.bpk = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img3);
        this.csN = (LinearLayout) findViewById(w.h.ala_attention_tip_linear);
        this.cpl = findViewById(w.h.ala_attention_tip_bottom);
        setOnClickListener(new c(this));
        this.bpi.setOnClickListener(this.csO);
        this.bpj.setOnClickListener(this.csO);
        this.bpk.setOnClickListener(this.csO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                jJ(forcusUsers.user_name);
            } else if (i == 50) {
                jK(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void jJ(String str) {
        if (!com.baidu.adp.lib.util.i.hk()) {
            com.baidu.adp.lib.util.k.showToast(this.mContext, w.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new as("c11829").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void jK(String str) {
        TiebaStatic.log(new as("c11830").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aha() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bpl != null) {
            this.bpl.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bpi.setVisibility(0);
                this.bpi.setIsRound(true);
                this.bpi.c(arrayList.get(0), 12, false);
            } else {
                this.bpi.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bpj.setVisibility(0);
                this.bpj.setIsRound(true);
                this.bpj.c(arrayList.get(1), 12, false);
            } else {
                this.bpj.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bpk.setVisibility(0);
                this.bpk.setIsRound(true);
                this.bpk.c(arrayList.get(2), 12, false);
                return;
            }
            this.bpk.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.c cVar) {
        this.csL = cVar;
        int i = cVar.csB;
        List<ForcusUsers> list = cVar.csC;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_record));
        }
        if (this.csK == null) {
            this.csK = new ArrayList<>();
        }
        this.csK.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.csK.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.csK);
                return;
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.k(this.csN, w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_b);
            aq.k(this.cpl, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0064a interfaceC0064a) {
        this.csM = interfaceC0064a;
    }
}
