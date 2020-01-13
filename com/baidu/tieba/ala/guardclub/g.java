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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class g extends BaseAdapter {
    private boolean WF;
    private BaseActivity eAE;
    private BdUniqueId eAF;
    private boolean eBg;
    private com.baidu.tieba.ala.guardclub.model.k eBh;
    private b eBi;
    private List<com.baidu.tieba.ala.guardclub.model.k> eBj;
    private CustomMessageListener ern = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = g.this.eBj.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.tieba.ala.guardclub.model.k kVar = (com.baidu.tieba.ala.guardclub.model.k) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(kVar.userId)) {
                                    kVar.evd = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            g.this.notifyDataSetChanged();
                            if (message.getTag().equals(g.this.eAF)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    g.this.eAE.getPageContext().showToast(g.this.eAE.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    g.this.eAE.getPageContext().showToast(g.this.eAE.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(g.this.eAF)) {
                        g.this.eAE.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void d(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.eAE = baseActivity;
        this.eAF = bdUniqueId;
        this.WF = z;
        this.eBg = z2;
        MessageManager.getInstance().registerListener(this.ern);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.tieba.ala.guardclub.model.k kVar) {
        this.eBh = kVar;
    }

    public void a(b bVar) {
        this.eBi = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eBj == null) {
            return 0;
        }
        return this.eBj.size();
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
            view = LayoutInflater.from(this.eAE.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.eBm = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.eBn = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.eBo = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.eBp = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.eAL = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eBq = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.eBr = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.eAN = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eBs = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.eBt = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.k kVar = this.eBj.get(i);
        if (kVar != null) {
            if (!this.eBg) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.eBp.setText(String.valueOf(i + 1));
                        aVar.eBo.setVisibility(8);
                        aVar.eBp.setVisibility(0);
                    }
                    aVar.eBn.setVisibility(8);
                    aVar.eBm.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.eBm.setVisibility(8);
                    aVar.eBn.setVisibility(0);
                }
            } else {
                aVar.eBm.setVisibility(8);
                aVar.eBn.setVisibility(0);
            }
            aVar.eAL.setIsRound(true);
            aVar.eAL.setAutoChangeStyle(false);
            aVar.eAL.startLoad(kVar.bXf, 12, false);
            String pc = l.bcZ().pc(kVar.eCE);
            if (!TextUtils.isEmpty(pc)) {
                aVar.eBq.startLoad(pc, 10, false);
                aVar.eBq.setVisibility(0);
            } else {
                aVar.eBq.setVisibility(4);
            }
            aVar.eAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.b(kVar);
                }
            });
            aVar.eBr.setText(kVar.userName);
            aVar.eAN.setText(String.format(this.eAE.getResources().getString(a.i.guard_member_list_contribution), kVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.eBt.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.eBs.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.eBt.setTextColor(this.eAE.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.eBs.setTextColor(this.eAE.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, kVar.evd, kVar.userId);
            aVar.eBs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.c(kVar);
                    if (!g.this.WF && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, g.this.eBg ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", g.this.eBg ? "guard_member" : "guard", g.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, g.this.eBg ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, g.this.otherParams);
                    }
                }
            });
            aVar.eBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.3
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
        if (this.eBi != null) {
            this.eBi.d(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (kVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.eAE, this.eAE.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.eAE);
            } else if (kVar.evd) {
                com.baidu.live.view.a.yR().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", false, this.eAF));
            } else {
                com.baidu.live.view.a.yR().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", true, this.eAF));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.eBh == null || !TextUtils.equals(str, this.eBh.userId)) {
            if (z) {
                aVar.eBs.setVisibility(8);
                aVar.eBt.setVisibility(0);
                return;
            }
            aVar.eBt.setVisibility(8);
            aVar.eBs.setVisibility(0);
            return;
        }
        aVar.eBs.setVisibility(8);
        aVar.eBt.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.eBo.setImageResource(i);
        aVar.eBp.setVisibility(8);
        aVar.eBo.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            this.eBj = new ArrayList(list);
        } else {
            this.eBj = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eBj == null) {
                this.eBj = new ArrayList();
            }
            this.eBj.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcS() {
        MessageManager.getInstance().unRegisterListener(this.ern);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private HeadImageView eAL;
        private TextView eAN;
        private RelativeLayout eBm;
        private View eBn;
        private ImageView eBo;
        private TextView eBp;
        private TbImageView eBq;
        private TextView eBr;
        private GradientTextView eBs;
        private TextView eBt;

        private a() {
        }
    }
}
