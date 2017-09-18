package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaAttentionLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private HeadImageView bBO;
    private HeadImageView bBP;
    private HeadImageView bBQ;
    private ImageView bBR;
    private View cVi;
    private ArrayList<String> cYC;
    private com.baidu.tieba.homepage.alalivelist.a.b cYD;
    private InterfaceC0089a cYE;
    private LinearLayout cYF;
    View.OnClickListener cYG;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.b bVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cYG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cYD != null) {
                    TiebaStatic.log(new ak("c11831").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    if (view == a.this.bBO) {
                        a.this.a(a.this.cYD.cYt, a.this.cYD.cYu.get(0));
                    } else if (view == a.this.bBP) {
                        a.this.a(a.this.cYD.cYt, a.this.cYD.cYu.get(1));
                    } else if (view == a.this.bBQ) {
                        a.this.a(a.this.cYD.cYt, a.this.cYD.cYu.get(2));
                    }
                    if (a.this.cYE != null) {
                        a.this.cYE.a(view, a.this.cYD);
                    }
                }
            }
        };
        this.mContext = context;
        bn(context);
    }

    private void bn(Context context) {
        inflate(context, d.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(d.h.ala_attention_tip_title_txt);
        this.bBR = (ImageView) findViewById(d.h.ala_attention_tip_arrow_img);
        this.bBO = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img1);
        this.bBP = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img2);
        this.bBQ = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img3);
        this.cYF = (LinearLayout) findViewById(d.h.ala_attention_tip_linear);
        this.cVi = findViewById(d.h.ala_attention_tip_bottom);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aqf();
            }
        });
        this.bBO.setOnClickListener(this.cYG);
        this.bBP.setOnClickListener(this.cYG);
        this.bBQ.setOnClickListener(this.cYG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                lI(forcusUsers.user_name);
            } else if (i == 50) {
                lJ(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void lI(String str) {
        if (!i.hi()) {
            k.showToast(this.mContext, d.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new ak("c11829").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void lJ(String str) {
        TiebaStatic.log(new ak("c11830").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bBR != null) {
            this.bBR.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bBO.setVisibility(0);
                this.bBO.setIsRound(true);
                this.bBO.c(arrayList.get(0), 12, false);
            } else {
                this.bBO.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bBP.setVisibility(0);
                this.bBP.setIsRound(true);
                this.bBP.c(arrayList.get(1), 12, false);
            } else {
                this.bBP.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bBQ.setVisibility(0);
                this.bBQ.setIsRound(true);
                this.bBQ.c(arrayList.get(2), 12, false);
                return;
            }
            this.bBQ.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.b bVar) {
        this.cYD = bVar;
        int i = bVar.cYt;
        List<ForcusUsers> list = bVar.cYu;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_record));
        }
        if (this.cYC == null) {
            this.cYC = new ArrayList<>();
        }
        this.cYC.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cYC.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cYC);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(this.cYF, d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.cVi, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0089a interfaceC0089a) {
        this.cYE = interfaceC0089a;
    }
}
