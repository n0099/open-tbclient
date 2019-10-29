package com.baidu.tieba.ala.guardclub;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.GradientTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends BaseAdapter {
    private boolean PW;
    private CustomMessageListener dFe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = g.this.dMD.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.tieba.ala.guardclub.model.k kVar = (com.baidu.tieba.ala.guardclub.model.k) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(kVar.userId)) {
                                    kVar.dHB = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            g.this.notifyDataSetChanged();
                            if (message.getTag().equals(g.this.dLY)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    g.this.dLX.getPageContext().showToast(g.this.dLX.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    g.this.dLX.getPageContext().showToast(g.this.dLX.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(g.this.dLY)) {
                        g.this.dLX.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private BaseActivity dLX;
    private BdUniqueId dLY;
    private boolean dMA;
    private com.baidu.tieba.ala.guardclub.model.k dMB;
    private b dMC;
    private List<com.baidu.tieba.ala.guardclub.model.k> dMD;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface b {
        void d(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.dLX = baseActivity;
        this.dLY = bdUniqueId;
        this.PW = z;
        this.dMA = z2;
        MessageManager.getInstance().registerListener(this.dFe);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.tieba.ala.guardclub.model.k kVar) {
        this.dMB = kVar;
    }

    public void a(b bVar) {
        this.dMC = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dMD == null) {
            return 0;
        }
        return this.dMD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.dLX.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.dMG = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.dMH = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.dMI = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.dMJ = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.dMe = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.dMK = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.dML = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.dMh = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.dMM = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.dMN = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.k kVar = this.dMD.get(i);
        if (kVar != null) {
            if (!this.dMA) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.dMJ.setText(String.valueOf(i + 1));
                        aVar.dMI.setVisibility(8);
                        aVar.dMJ.setVisibility(0);
                    }
                    aVar.dMH.setVisibility(8);
                    aVar.dMG.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.dMG.setVisibility(8);
                    aVar.dMH.setVisibility(0);
                }
            } else {
                aVar.dMG.setVisibility(8);
                aVar.dMH.setVisibility(0);
            }
            aVar.dMe.setIsRound(true);
            aVar.dMe.setAutoChangeStyle(false);
            aVar.dMe.startLoad(kVar.dmo, 12, false);
            String mM = m.aLx().mM(kVar.dOc);
            if (!TextUtils.isEmpty(mM)) {
                aVar.dMK.startLoad(mM, 10, false);
                aVar.dMK.setVisibility(0);
            } else {
                aVar.dMK.setVisibility(4);
            }
            aVar.dMe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.b(kVar);
                }
            });
            aVar.dML.setText(kVar.userName);
            aVar.dMh.setText(String.format(this.dLX.getResources().getString(a.i.guard_member_list_contribution), kVar.score));
            a(aVar, kVar.dHB, kVar.userId);
            aVar.dMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.c(kVar);
                    if (!g.this.PW && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, g.this.dMA ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", g.this.dMA ? "guard_member" : "guard", g.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, g.this.dMA ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, g.this.otherParams);
                    }
                }
            });
            aVar.dMN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.c(kVar);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.dMC != null) {
            this.dMC.d(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (kVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.dLX, this.dLX.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.dLX);
            } else if (kVar.dHB) {
                com.baidu.live.view.a.wx().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", false, this.dLY));
            } else {
                com.baidu.live.view.a.wx().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", true, this.dLY));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.dMB == null || !TextUtils.equals(str, this.dMB.userId)) {
            if (z) {
                aVar.dMM.setVisibility(8);
                aVar.dMN.setVisibility(0);
                return;
            }
            aVar.dMN.setVisibility(8);
            aVar.dMM.setVisibility(0);
            return;
        }
        aVar.dMM.setVisibility(8);
        aVar.dMN.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.dMI.setImageResource(i);
        aVar.dMJ.setVisibility(8);
        aVar.dMI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            this.dMD = new ArrayList(list);
        } else {
            this.dMD = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            if (this.dMD == null) {
                this.dMD = new ArrayList();
            }
            this.dMD.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLp() {
        MessageManager.getInstance().unRegisterListener(this.dFe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        private RelativeLayout dMG;
        private View dMH;
        private ImageView dMI;
        private TextView dMJ;
        private TbImageView dMK;
        private TextView dML;
        private GradientTextView dMM;
        private TextView dMN;
        private HeadImageView dMe;
        private TextView dMh;

        private a() {
        }
    }
}
