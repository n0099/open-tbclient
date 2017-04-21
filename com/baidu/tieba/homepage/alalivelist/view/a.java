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
    private HeadImageView boL;
    private HeadImageView boM;
    private HeadImageView boN;
    private ImageView boO;
    private View csm;
    private ArrayList<String> cvN;
    private com.baidu.tieba.homepage.alalivelist.a.c cvO;
    private InterfaceC0059a cvP;
    private LinearLayout cvQ;
    View.OnClickListener cvR;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.c cVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cvR = new b(this);
        this.mContext = context;
        bc(context);
    }

    private void bc(Context context) {
        inflate(context, w.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(w.h.ala_attention_tip_title_txt);
        this.boO = (ImageView) findViewById(w.h.ala_attention_tip_arrow_img);
        this.boL = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img1);
        this.boM = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img2);
        this.boN = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img3);
        this.cvQ = (LinearLayout) findViewById(w.h.ala_attention_tip_linear);
        this.csm = findViewById(w.h.ala_attention_tip_bottom);
        setOnClickListener(new c(this));
        this.boL.setOnClickListener(this.cvR);
        this.boM.setOnClickListener(this.cvR);
        this.boN.setOnClickListener(this.cvR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                jC(forcusUsers.user_name);
            } else if (i == 50) {
                jD(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void jC(String str) {
        if (!com.baidu.adp.lib.util.i.hk()) {
            com.baidu.adp.lib.util.k.showToast(this.mContext, w.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new as("c11829").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void jD(String str) {
        TiebaStatic.log(new as("c11830").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajt() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.boO != null) {
            this.boO.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.boL.setVisibility(0);
                this.boL.setIsRound(true);
                this.boL.c(arrayList.get(0), 12, false);
            } else {
                this.boL.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.boM.setVisibility(0);
                this.boM.setIsRound(true);
                this.boM.c(arrayList.get(1), 12, false);
            } else {
                this.boM.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.boN.setVisibility(0);
                this.boN.setIsRound(true);
                this.boN.c(arrayList.get(2), 12, false);
                return;
            }
            this.boN.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.c cVar) {
        this.cvO = cVar;
        int i = cVar.cvB;
        List<ForcusUsers> list = cVar.cvC;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_record));
        }
        if (this.cvN == null) {
            this.cvN = new ArrayList<>();
        }
        this.cvN.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cvN.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cvN);
                return;
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.k(this.cvQ, w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_b);
            aq.k(this.csm, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0059a interfaceC0059a) {
        this.cvP = interfaceC0059a;
    }
}
