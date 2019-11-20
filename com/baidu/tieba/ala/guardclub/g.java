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
    private boolean Pr;
    private CustomMessageListener dEn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = g.this.dLM.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.tieba.ala.guardclub.model.k kVar = (com.baidu.tieba.ala.guardclub.model.k) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(kVar.userId)) {
                                    kVar.dGK = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            g.this.notifyDataSetChanged();
                            if (message.getTag().equals(g.this.dLh)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    g.this.dLg.getPageContext().showToast(g.this.dLg.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    g.this.dLg.getPageContext().showToast(g.this.dLg.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(g.this.dLh)) {
                        g.this.dLg.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private boolean dLJ;
    private com.baidu.tieba.ala.guardclub.model.k dLK;
    private b dLL;
    private List<com.baidu.tieba.ala.guardclub.model.k> dLM;
    private BaseActivity dLg;
    private BdUniqueId dLh;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface b {
        void d(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.dLg = baseActivity;
        this.dLh = bdUniqueId;
        this.Pr = z;
        this.dLJ = z2;
        MessageManager.getInstance().registerListener(this.dEn);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.tieba.ala.guardclub.model.k kVar) {
        this.dLK = kVar;
    }

    public void a(b bVar) {
        this.dLL = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dLM == null) {
            return 0;
        }
        return this.dLM.size();
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
            view = LayoutInflater.from(this.dLg.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.dLP = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.dLQ = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.dLR = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.dLS = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.dLn = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.dLT = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.dLU = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.dLq = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.dLV = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.dLW = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.k kVar = this.dLM.get(i);
        if (kVar != null) {
            if (!this.dLJ) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.dLS.setText(String.valueOf(i + 1));
                        aVar.dLR.setVisibility(8);
                        aVar.dLS.setVisibility(0);
                    }
                    aVar.dLQ.setVisibility(8);
                    aVar.dLP.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.dLP.setVisibility(8);
                    aVar.dLQ.setVisibility(0);
                }
            } else {
                aVar.dLP.setVisibility(8);
                aVar.dLQ.setVisibility(0);
            }
            aVar.dLn.setIsRound(true);
            aVar.dLn.setAutoChangeStyle(false);
            aVar.dLn.startLoad(kVar.dlx, 12, false);
            String mL = m.aLv().mL(kVar.dNl);
            if (!TextUtils.isEmpty(mL)) {
                aVar.dLT.startLoad(mL, 10, false);
                aVar.dLT.setVisibility(0);
            } else {
                aVar.dLT.setVisibility(4);
            }
            aVar.dLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.b(kVar);
                }
            });
            aVar.dLU.setText(kVar.userName);
            aVar.dLq.setText(String.format(this.dLg.getResources().getString(a.i.guard_member_list_contribution), kVar.score));
            a(aVar, kVar.dGK, kVar.userId);
            aVar.dLV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.c(kVar);
                    if (!g.this.Pr && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, g.this.dLJ ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", g.this.dLJ ? "guard_member" : "guard", g.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, g.this.dLJ ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, g.this.otherParams);
                    }
                }
            });
            aVar.dLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.3
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
        if (this.dLL != null) {
            this.dLL.d(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (kVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.dLg, this.dLg.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.dLg);
            } else if (kVar.dGK) {
                com.baidu.live.view.a.wy().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", false, this.dLh));
            } else {
                com.baidu.live.view.a.wy().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", true, this.dLh));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.dLK == null || !TextUtils.equals(str, this.dLK.userId)) {
            if (z) {
                aVar.dLV.setVisibility(8);
                aVar.dLW.setVisibility(0);
                return;
            }
            aVar.dLW.setVisibility(8);
            aVar.dLV.setVisibility(0);
            return;
        }
        aVar.dLV.setVisibility(8);
        aVar.dLW.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.dLR.setImageResource(i);
        aVar.dLS.setVisibility(8);
        aVar.dLR.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            this.dLM = new ArrayList(list);
        } else {
            this.dLM = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            if (this.dLM == null) {
                this.dLM = new ArrayList();
            }
            this.dLM.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLn() {
        MessageManager.getInstance().unRegisterListener(this.dEn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        private RelativeLayout dLP;
        private View dLQ;
        private ImageView dLR;
        private TextView dLS;
        private TbImageView dLT;
        private TextView dLU;
        private GradientTextView dLV;
        private TextView dLW;
        private HeadImageView dLn;
        private TextView dLq;

        private a() {
        }
    }
}
