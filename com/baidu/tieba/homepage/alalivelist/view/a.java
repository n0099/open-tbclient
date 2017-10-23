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
    private HeadImageView bDn;
    private HeadImageView bDo;
    private HeadImageView bDp;
    private ImageView bDq;
    private ArrayList<String> cUI;
    private com.baidu.tieba.homepage.alalivelist.a.b cUJ;
    private View cUK;
    private InterfaceC0089a cUL;
    private LinearLayout cUM;
    View.OnClickListener cUN;
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
        this.cUN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cUJ != null) {
                    TiebaStatic.log(new ak("c11831").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    if (view == a.this.bDn) {
                        a.this.a(a.this.cUJ.cUz, a.this.cUJ.cUA.get(0));
                    } else if (view == a.this.bDo) {
                        a.this.a(a.this.cUJ.cUz, a.this.cUJ.cUA.get(1));
                    } else if (view == a.this.bDp) {
                        a.this.a(a.this.cUJ.cUz, a.this.cUJ.cUA.get(2));
                    }
                    if (a.this.cUL != null) {
                        a.this.cUL.a(view, a.this.cUJ);
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
        this.bDq = (ImageView) findViewById(d.h.ala_attention_tip_arrow_img);
        this.bDn = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img1);
        this.bDo = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img2);
        this.bDp = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img3);
        this.cUM = (LinearLayout) findViewById(d.h.ala_attention_tip_linear);
        this.cUK = findViewById(d.h.ala_attention_tip_bottom);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aoD();
            }
        });
        this.bDn.setOnClickListener(this.cUN);
        this.bDo.setOnClickListener(this.cUN);
        this.bDp.setOnClickListener(this.cUN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                ll(forcusUsers.user_name);
            } else if (i == 50) {
                lm(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void ll(String str) {
        if (!j.hh()) {
            l.showToast(this.mContext, d.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new ak("c11829").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void lm(String str) {
        TiebaStatic.log(new ak("c11830").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoD() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bDq != null) {
            this.bDq.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bDn.setVisibility(0);
                this.bDn.setIsRound(true);
                this.bDn.c(arrayList.get(0), 12, false);
            } else {
                this.bDn.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bDo.setVisibility(0);
                this.bDo.setIsRound(true);
                this.bDo.c(arrayList.get(1), 12, false);
            } else {
                this.bDo.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bDp.setVisibility(0);
                this.bDp.setIsRound(true);
                this.bDp.c(arrayList.get(2), 12, false);
                return;
            }
            this.bDp.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.b bVar) {
        this.cUJ = bVar;
        int i = bVar.cUz;
        List<ForcusUsers> list = bVar.cUA;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_record));
        }
        if (this.cUI == null) {
            this.cUI = new ArrayList<>();
        }
        this.cUI.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cUI.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cUI);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(this.cUM, d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.cUK, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0089a interfaceC0089a) {
        this.cUL = interfaceC0089a;
    }
}
