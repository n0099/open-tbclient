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
    private TextView aSO;
    private HeadImageView bmB;
    private HeadImageView bmC;
    private HeadImageView bmD;
    private ImageView bmE;
    private View crv;
    private ArrayList<String> cuW;
    private com.baidu.tieba.homepage.alalivelist.a.c cuX;
    private InterfaceC0060a cuY;
    private LinearLayout cuZ;
    View.OnClickListener cva;
    private Context mContext;
    private int mSkinType;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.c cVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cva = new b(this);
        this.mContext = context;
        bi(context);
    }

    private void bi(Context context) {
        inflate(context, w.j.ala_attention_live_list_layout, this);
        this.aSO = (TextView) findViewById(w.h.ala_attention_tip_title_txt);
        this.bmE = (ImageView) findViewById(w.h.ala_attention_tip_arrow_img);
        this.bmB = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img1);
        this.bmC = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img2);
        this.bmD = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img3);
        this.cuZ = (LinearLayout) findViewById(w.h.ala_attention_tip_linear);
        this.crv = findViewById(w.h.ala_attention_tip_bottom);
        setOnClickListener(new c(this));
        this.bmB.setOnClickListener(this.cva);
        this.bmC.setOnClickListener(this.cva);
        this.bmD.setOnClickListener(this.cva);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                jw(forcusUsers.user_name);
            } else if (i == 50) {
                jx(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void jw(String str) {
        TiebaStatic.log(new as("c11829").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void jx(String str) {
        TiebaStatic.log(new as("c11830").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.aSO != null) {
            this.aSO.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bmE != null) {
            this.bmE.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bmB.setVisibility(0);
                this.bmB.setIsRound(true);
                this.bmB.c(arrayList.get(0), 12, false);
            } else {
                this.bmB.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bmC.setVisibility(0);
                this.bmC.setIsRound(true);
                this.bmC.c(arrayList.get(1), 12, false);
            } else {
                this.bmC.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bmD.setVisibility(0);
                this.bmD.setIsRound(true);
                this.bmD.c(arrayList.get(2), 12, false);
                return;
            }
            this.bmD.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.c cVar) {
        this.cuX = cVar;
        int i = cVar.cuK;
        List<ForcusUsers> list = cVar.cuL;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_record));
        }
        if (this.cuW == null) {
            this.cuW = new ArrayList<>();
        }
        this.cuW.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cuW.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cuW);
                return;
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.k(this.cuZ, w.e.cp_bg_line_d);
            aq.i((View) this.aSO, w.e.cp_cont_b);
            aq.k(this.crv, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0060a interfaceC0060a) {
        this.cuY = interfaceC0060a;
    }
}
