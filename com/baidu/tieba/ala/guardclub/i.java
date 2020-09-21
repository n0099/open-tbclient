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
import com.baidu.live.sdk.a;
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
/* loaded from: classes4.dex */
public class i extends BaseAdapter {
    private boolean aFD;
    private CustomMessageListener fSS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.get.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.isFollowed = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.gdQ)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.gdP.getPageContext().showToast(i.this.gdP.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.gdP.getPageContext().showToast(i.this.gdP.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.gdQ)) {
                        i.this.gdP.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private BaseActivity gdP;
    private BdUniqueId gdQ;
    private boolean geq;
    private com.baidu.live.guardclub.f ger;
    private b ges;
    private List<com.baidu.live.guardclub.f> get;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gdP = baseActivity;
        this.gdQ = bdUniqueId;
        this.aFD = z;
        this.geq = z2;
        MessageManager.getInstance().registerListener(this.fSS);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.ger = fVar;
    }

    public void a(b bVar) {
        this.ges = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.get == null) {
            return 0;
        }
        return this.get.size();
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
            view = LayoutInflater.from(this.gdP.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.gew = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.gex = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.gey = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.gez = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.gdV = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.geA = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.geB = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.gdX = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.geC = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.geD = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.get.get(i);
        if (fVar != null) {
            if (!this.geq) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.gez.setText(String.valueOf(i + 1));
                        aVar.gey.setVisibility(8);
                        aVar.gez.setVisibility(0);
                    }
                    aVar.gex.setVisibility(8);
                    aVar.gew.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gew.setVisibility(8);
                    aVar.gex.setVisibility(0);
                }
            } else {
                aVar.gew.setVisibility(8);
                aVar.gex.setVisibility(0);
            }
            aVar.gdV.setIsRound(true);
            aVar.gdV.setAutoChangeStyle(false);
            aVar.gdV.startLoad(fVar.baJ, 12, false);
            String ev = com.baidu.live.guardclub.g.IP().ev(fVar.bal);
            if (!TextUtils.isEmpty(ev)) {
                aVar.geA.startLoad(ev, 10, false);
                aVar.geA.setVisibility(0);
            } else {
                aVar.geA.setVisibility(4);
            }
            aVar.gdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.geB.setText(fVar.userName);
            aVar.gdX.setText(String.format(this.gdP.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.geD.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.geC.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.geD.setTextColor(this.gdP.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.geC.setTextColor(this.gdP.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.isFollowed, fVar.userId);
            aVar.geC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aFD && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.geq ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.geq ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.geq ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.geD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.guardclub.f fVar) {
        if (this.ges != null) {
            this.ges.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gdP, this.gdP.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gdP);
            } else if (fVar.isFollowed) {
                com.baidu.live.data.e eVar = new com.baidu.live.data.e(fVar.portrait, fVar.userId, "1", false, this.gdQ);
                eVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Rg().a(fVar.userId, eVar);
            } else {
                com.baidu.live.data.e eVar2 = new com.baidu.live.data.e(fVar.portrait, fVar.userId, "1", true, this.gdQ);
                eVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Rg().a(fVar.userId, eVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.ger == null || !TextUtils.equals(str, this.ger.userId)) {
            if (z) {
                aVar.geC.setVisibility(8);
                aVar.geD.setVisibility(0);
                return;
            }
            aVar.geD.setVisibility(8);
            aVar.geC.setVisibility(0);
            return;
        }
        aVar.geC.setVisibility(8);
        aVar.geD.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gey.setImageResource(i);
        aVar.gez.setVisibility(8);
        aVar.gey.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.get = new ArrayList(list);
        } else {
            this.get = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bU(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.get == null) {
                this.get = new ArrayList();
            }
            this.get.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bLq() {
        MessageManager.getInstance().unRegisterListener(this.fSS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private HeadImageView gdV;
        private TextView gdX;
        private TbImageView geA;
        private TextView geB;
        private GradientTextView geC;
        private TextView geD;
        private RelativeLayout gew;
        private View gex;
        private ImageView gey;
        private TextView gez;

        private a() {
        }
    }
}
