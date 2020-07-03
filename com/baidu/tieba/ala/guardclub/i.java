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
/* loaded from: classes3.dex */
public class i extends BaseAdapter {
    private boolean axZ;
    private boolean fJF;
    private com.baidu.live.guardclub.f fJG;
    private b fJH;
    private List<com.baidu.live.guardclub.f> fJI;
    private BaseActivity fJe;
    private BdUniqueId fJf;
    private CustomMessageListener fzf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.fJI.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aRB = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.fJf)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.fJe.getPageContext().showToast(i.this.fJe.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.fJe.getPageContext().showToast(i.this.fJe.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.fJf)) {
                        i.this.fJe.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fJe = baseActivity;
        this.fJf = bdUniqueId;
        this.axZ = z;
        this.fJF = z2;
        MessageManager.getInstance().registerListener(this.fzf);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.fJG = fVar;
    }

    public void a(b bVar) {
        this.fJH = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJI == null) {
            return 0;
        }
        return this.fJI.size();
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
            view = LayoutInflater.from(this.fJe.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.fJL = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.fJM = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.fJN = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.fJO = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.fJk = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fJP = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.fJQ = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.fJm = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fJR = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.fJS = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.fJI.get(i);
        if (fVar != null) {
            if (!this.fJF) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.fJO.setText(String.valueOf(i + 1));
                        aVar.fJN.setVisibility(8);
                        aVar.fJO.setVisibility(0);
                    }
                    aVar.fJM.setVisibility(8);
                    aVar.fJL.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.fJL.setVisibility(8);
                    aVar.fJM.setVisibility(0);
                }
            } else {
                aVar.fJL.setVisibility(8);
                aVar.fJM.setVisibility(0);
            }
            aVar.fJk.setIsRound(true);
            aVar.fJk.setAutoChangeStyle(false);
            aVar.fJk.startLoad(fVar.aRD, 12, false);
            String cv = com.baidu.live.guardclub.g.Ch().cv(fVar.aRf);
            if (!TextUtils.isEmpty(cv)) {
                aVar.fJP.startLoad(cv, 10, false);
                aVar.fJP.setVisibility(0);
            } else {
                aVar.fJP.setVisibility(4);
            }
            aVar.fJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.fJQ.setText(fVar.userName);
            aVar.fJm.setText(String.format(this.fJe.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.fJS.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.fJR.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.fJS.setTextColor(this.fJe.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.fJR.setTextColor(this.fJe.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aRB, fVar.userId);
            aVar.fJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.axZ && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.fJF ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.fJF ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.fJF ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.fJS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.fJH != null) {
            this.fJH.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.fJe, this.fJe.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fJe);
            } else if (fVar.aRB) {
                com.baidu.live.data.d dVar = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", false, this.fJf);
                dVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Ky().a(fVar.userId, dVar);
            } else {
                com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", true, this.fJf);
                dVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Ky().a(fVar.userId, dVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.fJG == null || !TextUtils.equals(str, this.fJG.userId)) {
            if (z) {
                aVar.fJR.setVisibility(8);
                aVar.fJS.setVisibility(0);
                return;
            }
            aVar.fJS.setVisibility(8);
            aVar.fJR.setVisibility(0);
            return;
        }
        aVar.fJR.setVisibility(8);
        aVar.fJS.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.fJN.setImageResource(i);
        aVar.fJO.setVisibility(8);
        aVar.fJN.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bJ(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.fJI = new ArrayList(list);
        } else {
            this.fJI = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bK(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fJI == null) {
                this.fJI = new ArrayList();
            }
            this.fJI.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bxt() {
        MessageManager.getInstance().unRegisterListener(this.fzf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private RelativeLayout fJL;
        private View fJM;
        private ImageView fJN;
        private TextView fJO;
        private TbImageView fJP;
        private TextView fJQ;
        private GradientTextView fJR;
        private TextView fJS;
        private HeadImageView fJk;
        private TextView fJm;

        private a() {
        }
    }
}
