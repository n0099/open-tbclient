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
import com.baidu.live.q.a;
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
    private boolean Wm;
    private CustomMessageListener eqb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = g.this.ezY.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.tieba.ala.guardclub.model.k kVar = (com.baidu.tieba.ala.guardclub.model.k) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(kVar.userId)) {
                                    kVar.etS = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            g.this.notifyDataSetChanged();
                            if (message.getTag().equals(g.this.ezu)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    g.this.ezt.getPageContext().showToast(g.this.ezt.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    g.this.ezt.getPageContext().showToast(g.this.ezt.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(g.this.ezu)) {
                        g.this.ezt.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private boolean ezV;
    private com.baidu.tieba.ala.guardclub.model.k ezW;
    private b ezX;
    private List<com.baidu.tieba.ala.guardclub.model.k> ezY;
    private BaseActivity ezt;
    private BdUniqueId ezu;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void d(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.ezt = baseActivity;
        this.ezu = bdUniqueId;
        this.Wm = z;
        this.ezV = z2;
        MessageManager.getInstance().registerListener(this.eqb);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.tieba.ala.guardclub.model.k kVar) {
        this.ezW = kVar;
    }

    public void a(b bVar) {
        this.ezX = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ezY == null) {
            return 0;
        }
        return this.ezY.size();
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
            view = LayoutInflater.from(this.ezt.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.eAb = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.eAc = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.eAd = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.eAe = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.ezA = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eAf = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.eAg = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.ezC = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eAh = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.eAi = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.k kVar = this.ezY.get(i);
        if (kVar != null) {
            if (!this.ezV) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.eAe.setText(String.valueOf(i + 1));
                        aVar.eAd.setVisibility(8);
                        aVar.eAe.setVisibility(0);
                    }
                    aVar.eAc.setVisibility(8);
                    aVar.eAb.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.eAb.setVisibility(8);
                    aVar.eAc.setVisibility(0);
                }
            } else {
                aVar.eAb.setVisibility(8);
                aVar.eAc.setVisibility(0);
            }
            aVar.ezA.setIsRound(true);
            aVar.ezA.setAutoChangeStyle(false);
            aVar.ezA.startLoad(kVar.bWT, 12, false);
            String pb = l.bcE().pb(kVar.eBt);
            if (!TextUtils.isEmpty(pb)) {
                aVar.eAf.startLoad(pb, 10, false);
                aVar.eAf.setVisibility(0);
            } else {
                aVar.eAf.setVisibility(4);
            }
            aVar.ezA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.b(kVar);
                }
            });
            aVar.eAg.setText(kVar.userName);
            aVar.ezC.setText(String.format(this.ezt.getResources().getString(a.i.guard_member_list_contribution), kVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.eAi.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.eAh.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.eAi.setTextColor(this.ezt.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.eAh.setTextColor(this.ezt.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, kVar.etS, kVar.userId);
            aVar.eAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.c(kVar);
                    if (!g.this.Wm && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, g.this.ezV ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", g.this.ezV ? "guard_member" : "guard", g.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, g.this.ezV ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, g.this.otherParams);
                    }
                }
            });
            aVar.eAi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.3
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
        if (this.ezX != null) {
            this.ezX.d(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (kVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.ezt, this.ezt.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.ezt);
            } else if (kVar.etS) {
                com.baidu.live.view.a.yy().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", false, this.ezu));
            } else {
                com.baidu.live.view.a.yy().a(kVar.userId, new com.baidu.live.data.b(kVar.portrait, kVar.userId, "1", true, this.ezu));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.ezW == null || !TextUtils.equals(str, this.ezW.userId)) {
            if (z) {
                aVar.eAh.setVisibility(8);
                aVar.eAi.setVisibility(0);
                return;
            }
            aVar.eAi.setVisibility(8);
            aVar.eAh.setVisibility(0);
            return;
        }
        aVar.eAh.setVisibility(8);
        aVar.eAi.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.eAd.setImageResource(i);
        aVar.eAe.setVisibility(8);
        aVar.eAd.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            this.ezY = new ArrayList(list);
        } else {
            this.ezY = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (list != null && !list.isEmpty()) {
            if (this.ezY == null) {
                this.ezY = new ArrayList();
            }
            this.ezY.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcx() {
        MessageManager.getInstance().unRegisterListener(this.eqb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private RelativeLayout eAb;
        private View eAc;
        private ImageView eAd;
        private TextView eAe;
        private TbImageView eAf;
        private TextView eAg;
        private GradientTextView eAh;
        private TextView eAi;
        private HeadImageView ezA;
        private TextView ezC;

        private a() {
        }
    }
}
