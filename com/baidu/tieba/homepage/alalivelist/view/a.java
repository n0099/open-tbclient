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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private HeadImageView byl;
    private HeadImageView bym;
    private HeadImageView byn;
    private ImageView byo;
    private View cKF;
    private ArrayList<String> cNY;
    private com.baidu.tieba.homepage.alalivelist.a.b cNZ;
    private InterfaceC0088a cOa;
    private LinearLayout cOb;
    View.OnClickListener cOc;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0088a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.b bVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cOc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cNZ != null) {
                    TiebaStatic.log(new aj("c11831").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    if (view == a.this.byl) {
                        a.this.a(a.this.cNZ.cNP, a.this.cNZ.cNQ.get(0));
                    } else if (view == a.this.bym) {
                        a.this.a(a.this.cNZ.cNP, a.this.cNZ.cNQ.get(1));
                    } else if (view == a.this.byn) {
                        a.this.a(a.this.cNZ.cNP, a.this.cNZ.cNQ.get(2));
                    }
                    if (a.this.cOa != null) {
                        a.this.cOa.a(view, a.this.cNZ);
                    }
                }
            }
        };
        this.mContext = context;
        bg(context);
    }

    private void bg(Context context) {
        inflate(context, d.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(d.h.ala_attention_tip_title_txt);
        this.byo = (ImageView) findViewById(d.h.ala_attention_tip_arrow_img);
        this.byl = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img1);
        this.bym = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img2);
        this.byn = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img3);
        this.cOb = (LinearLayout) findViewById(d.h.ala_attention_tip_linear);
        this.cKF = findViewById(d.h.ala_attention_tip_bottom);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.anz();
            }
        });
        this.byl.setOnClickListener(this.cOc);
        this.bym.setOnClickListener(this.cOc);
        this.byn.setOnClickListener(this.cOc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                le(forcusUsers.user_name);
            } else if (i == 50) {
                lf(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void le(String str) {
        if (!i.hh()) {
            k.showToast(this.mContext, d.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new aj("c11829").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void lf(String str) {
        TiebaStatic.log(new aj("c11830").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anz() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.byo != null) {
            this.byo.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.byl.setVisibility(0);
                this.byl.setIsRound(true);
                this.byl.c(arrayList.get(0), 12, false);
            } else {
                this.byl.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bym.setVisibility(0);
                this.bym.setIsRound(true);
                this.bym.c(arrayList.get(1), 12, false);
            } else {
                this.bym.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.byn.setVisibility(0);
                this.byn.setIsRound(true);
                this.byn.c(arrayList.get(2), 12, false);
                return;
            }
            this.byn.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.b bVar) {
        this.cNZ = bVar;
        int i = bVar.cNP;
        List<ForcusUsers> list = bVar.cNQ;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_record));
        }
        if (this.cNY == null) {
            this.cNY = new ArrayList<>();
        }
        this.cNY.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cNY.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cNY);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(this.cOb, d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_b);
            ai.k(this.cKF, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0088a interfaceC0088a) {
        this.cOa = interfaceC0088a;
    }
}
