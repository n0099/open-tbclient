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
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends BaseAdapter {
    private boolean aqL;
    private CustomMessageListener eZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.fkC.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aJg = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.fjY)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.fjX.getPageContext().showToast(i.this.fjX.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.fjX.getPageContext().showToast(i.this.fjX.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.fjY)) {
                        i.this.fjX.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private BaseActivity fjX;
    private BdUniqueId fjY;
    private com.baidu.live.guardclub.f fkA;
    private b fkB;
    private List<com.baidu.live.guardclub.f> fkC;
    private boolean fkz;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fjX = baseActivity;
        this.fjY = bdUniqueId;
        this.aqL = z;
        this.fkz = z2;
        MessageManager.getInstance().registerListener(this.eZZ);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.fkA = fVar;
    }

    public void a(b bVar) {
        this.fkB = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkC == null) {
            return 0;
        }
        return this.fkC.size();
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
            view = LayoutInflater.from(this.fjX.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.fkF = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.fkG = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.fkH = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.fkI = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.fke = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fkJ = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.fkK = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.fkg = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fkL = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.fkM = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.fkC.get(i);
        if (fVar != null) {
            if (!this.fkz) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.fkI.setText(String.valueOf(i + 1));
                        aVar.fkH.setVisibility(8);
                        aVar.fkI.setVisibility(0);
                    }
                    aVar.fkG.setVisibility(8);
                    aVar.fkF.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.fkF.setVisibility(8);
                    aVar.fkG.setVisibility(0);
                }
            } else {
                aVar.fkF.setVisibility(8);
                aVar.fkG.setVisibility(0);
            }
            aVar.fke.setIsRound(true);
            aVar.fke.setAutoChangeStyle(false);
            aVar.fke.startLoad(fVar.aJi, 12, false);
            String cg = com.baidu.live.guardclub.g.As().cg(fVar.aIK);
            if (!TextUtils.isEmpty(cg)) {
                aVar.fkJ.startLoad(cg, 10, false);
                aVar.fkJ.setVisibility(0);
            } else {
                aVar.fkJ.setVisibility(4);
            }
            aVar.fke.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.fkK.setText(fVar.userName);
            aVar.fkg.setText(String.format(this.fjX.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.fkM.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.fkL.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.fkM.setTextColor(this.fjX.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.fkL.setTextColor(this.fjX.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aJg, fVar.userId);
            aVar.fkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aqL && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.fkz ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.fkz ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.fkz ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.fkM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.fkB != null) {
            this.fkB.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.fjX, this.fjX.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fjX);
            } else if (fVar.aJg) {
                com.baidu.live.data.b bVar = new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", false, this.fjY);
                bVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Ht().a(fVar.userId, bVar);
            } else {
                com.baidu.live.data.b bVar2 = new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", true, this.fjY);
                bVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Ht().a(fVar.userId, bVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.fkA == null || !TextUtils.equals(str, this.fkA.userId)) {
            if (z) {
                aVar.fkL.setVisibility(8);
                aVar.fkM.setVisibility(0);
                return;
            }
            aVar.fkM.setVisibility(8);
            aVar.fkL.setVisibility(0);
            return;
        }
        aVar.fkL.setVisibility(8);
        aVar.fkM.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.fkH.setImageResource(i);
        aVar.fkI.setVisibility(8);
        aVar.fkH.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bD(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.fkC = new ArrayList(list);
        } else {
            this.fkC = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bE(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fkC == null) {
                this.fkC = new ArrayList();
            }
            this.fkC.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void boG() {
        MessageManager.getInstance().unRegisterListener(this.eZZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private RelativeLayout fkF;
        private View fkG;
        private ImageView fkH;
        private TextView fkI;
        private TbImageView fkJ;
        private TextView fkK;
        private GradientTextView fkL;
        private TextView fkM;
        private HeadImageView fke;
        private TextView fkg;

        private a() {
        }
    }
}
