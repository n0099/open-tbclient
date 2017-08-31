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
    private HeadImageView bAX;
    private HeadImageView bAY;
    private HeadImageView bAZ;
    private ImageView bBa;
    private View cUo;
    private ArrayList<String> cXI;
    private com.baidu.tieba.homepage.alalivelist.a.b cXJ;
    private InterfaceC0090a cXK;
    private LinearLayout cXL;
    View.OnClickListener cXM;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0090a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.b bVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cXM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cXJ != null) {
                    TiebaStatic.log(new ak("c11831").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    if (view == a.this.bAX) {
                        a.this.a(a.this.cXJ.cXz, a.this.cXJ.cXA.get(0));
                    } else if (view == a.this.bAY) {
                        a.this.a(a.this.cXJ.cXz, a.this.cXJ.cXA.get(1));
                    } else if (view == a.this.bAZ) {
                        a.this.a(a.this.cXJ.cXz, a.this.cXJ.cXA.get(2));
                    }
                    if (a.this.cXK != null) {
                        a.this.cXK.a(view, a.this.cXJ);
                    }
                }
            }
        };
        this.mContext = context;
        bm(context);
    }

    private void bm(Context context) {
        inflate(context, d.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(d.h.ala_attention_tip_title_txt);
        this.bBa = (ImageView) findViewById(d.h.ala_attention_tip_arrow_img);
        this.bAX = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img1);
        this.bAY = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img2);
        this.bAZ = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img3);
        this.cXL = (LinearLayout) findViewById(d.h.ala_attention_tip_linear);
        this.cUo = findViewById(d.h.ala_attention_tip_bottom);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.apU();
            }
        });
        this.bAX.setOnClickListener(this.cXM);
        this.bAY.setOnClickListener(this.cXM);
        this.bAZ.setOnClickListener(this.cXM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                lG(forcusUsers.user_name);
            } else if (i == 50) {
                lH(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void lG(String str) {
        if (!i.hi()) {
            k.showToast(this.mContext, d.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new ak("c11829").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void lH(String str) {
        TiebaStatic.log(new ak("c11830").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bBa != null) {
            this.bBa.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bAX.setVisibility(0);
                this.bAX.setIsRound(true);
                this.bAX.c(arrayList.get(0), 12, false);
            } else {
                this.bAX.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bAY.setVisibility(0);
                this.bAY.setIsRound(true);
                this.bAY.c(arrayList.get(1), 12, false);
            } else {
                this.bAY.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bAZ.setVisibility(0);
                this.bAZ.setIsRound(true);
                this.bAZ.c(arrayList.get(2), 12, false);
                return;
            }
            this.bAZ.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.b bVar) {
        this.cXJ = bVar;
        int i = bVar.cXz;
        List<ForcusUsers> list = bVar.cXA;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_record));
        }
        if (this.cXI == null) {
            this.cXI = new ArrayList<>();
        }
        this.cXI.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cXI.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cXI);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(this.cXL, d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.cUo, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0090a interfaceC0090a) {
        this.cXK = interfaceC0090a;
    }
}
