package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
    private HeadImageView bDA;
    private HeadImageView bDB;
    private ImageView bDC;
    private HeadImageView bDz;
    private ArrayList<String> cUU;
    private com.baidu.tieba.homepage.alalivelist.a.b cUV;
    private View cUW;
    private InterfaceC0089a cUX;
    private LinearLayout cUY;
    View.OnClickListener cUZ;
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
        this.cUZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cUV != null) {
                    TiebaStatic.log(new ak("c11831").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    if (view == a.this.bDz) {
                        a.this.a(a.this.cUV.cUL, a.this.cUV.cUM.get(0));
                    } else if (view == a.this.bDA) {
                        a.this.a(a.this.cUV.cUL, a.this.cUV.cUM.get(1));
                    } else if (view == a.this.bDB) {
                        a.this.a(a.this.cUV.cUL, a.this.cUV.cUM.get(2));
                    }
                    if (a.this.cUX != null) {
                        a.this.cUX.a(view, a.this.cUV);
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
        this.bDC = (ImageView) findViewById(d.h.ala_attention_tip_arrow_img);
        this.bDz = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img1);
        this.bDA = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img2);
        this.bDB = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img3);
        this.cUY = (LinearLayout) findViewById(d.h.ala_attention_tip_linear);
        this.cUW = findViewById(d.h.ala_attention_tip_bottom);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aoI();
            }
        });
        this.bDz.setOnClickListener(this.cUZ);
        this.bDA.setOnClickListener(this.cUZ);
        this.bDB.setOnClickListener(this.cUZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                lm(forcusUsers.user_name);
            } else if (i == 50) {
                ln(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void lm(String str) {
        if (!j.hh()) {
            l.showToast(this.mContext, d.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new ak("c11829").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void ln(String str) {
        TiebaStatic.log(new ak("c11830").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoI() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bDC != null) {
            this.bDC.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bDz.setVisibility(0);
                this.bDz.setIsRound(true);
                this.bDz.c(arrayList.get(0), 12, false);
            } else {
                this.bDz.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bDA.setVisibility(0);
                this.bDA.setIsRound(true);
                this.bDA.c(arrayList.get(1), 12, false);
            } else {
                this.bDA.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bDB.setVisibility(0);
                this.bDB.setIsRound(true);
                this.bDB.c(arrayList.get(2), 12, false);
                return;
            }
            this.bDB.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.b bVar) {
        this.cUV = bVar;
        int i = bVar.cUL;
        List<ForcusUsers> list = bVar.cUM;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_record));
        }
        if (this.cUU == null) {
            this.cUU = new ArrayList<>();
        }
        this.cUU.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cUU.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cUU);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(this.cUY, d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.cUW, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0089a interfaceC0089a) {
        this.cUX = interfaceC0089a;
    }
}
