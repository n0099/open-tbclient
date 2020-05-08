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
    private boolean aqR;
    private CustomMessageListener fae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.fkH.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aJm = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.fkd)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.fkc.getPageContext().showToast(i.this.fkc.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.fkc.getPageContext().showToast(i.this.fkc.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.fkd)) {
                        i.this.fkc.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private boolean fkE;
    private com.baidu.live.guardclub.f fkF;
    private b fkG;
    private List<com.baidu.live.guardclub.f> fkH;
    private BaseActivity fkc;
    private BdUniqueId fkd;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fkc = baseActivity;
        this.fkd = bdUniqueId;
        this.aqR = z;
        this.fkE = z2;
        MessageManager.getInstance().registerListener(this.fae);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.fkF = fVar;
    }

    public void a(b bVar) {
        this.fkG = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkH == null) {
            return 0;
        }
        return this.fkH.size();
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
            view = LayoutInflater.from(this.fkc.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.fkK = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.fkL = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.fkM = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.fkN = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.fkj = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fkO = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.fkP = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.fkl = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fkQ = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.fkR = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.fkH.get(i);
        if (fVar != null) {
            if (!this.fkE) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.fkN.setText(String.valueOf(i + 1));
                        aVar.fkM.setVisibility(8);
                        aVar.fkN.setVisibility(0);
                    }
                    aVar.fkL.setVisibility(8);
                    aVar.fkK.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.fkK.setVisibility(8);
                    aVar.fkL.setVisibility(0);
                }
            } else {
                aVar.fkK.setVisibility(8);
                aVar.fkL.setVisibility(0);
            }
            aVar.fkj.setIsRound(true);
            aVar.fkj.setAutoChangeStyle(false);
            aVar.fkj.startLoad(fVar.aJo, 12, false);
            String cg = com.baidu.live.guardclub.g.Ar().cg(fVar.aIQ);
            if (!TextUtils.isEmpty(cg)) {
                aVar.fkO.startLoad(cg, 10, false);
                aVar.fkO.setVisibility(0);
            } else {
                aVar.fkO.setVisibility(4);
            }
            aVar.fkj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.fkP.setText(fVar.userName);
            aVar.fkl.setText(String.format(this.fkc.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.fkR.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.fkQ.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.fkR.setTextColor(this.fkc.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.fkQ.setTextColor(this.fkc.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aJm, fVar.userId);
            aVar.fkQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aqR && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.fkE ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.fkE ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.fkE ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.fkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.fkG != null) {
            this.fkG.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.fkc, this.fkc.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fkc);
            } else if (fVar.aJm) {
                com.baidu.live.data.b bVar = new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", false, this.fkd);
                bVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Hs().a(fVar.userId, bVar);
            } else {
                com.baidu.live.data.b bVar2 = new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", true, this.fkd);
                bVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Hs().a(fVar.userId, bVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.fkF == null || !TextUtils.equals(str, this.fkF.userId)) {
            if (z) {
                aVar.fkQ.setVisibility(8);
                aVar.fkR.setVisibility(0);
                return;
            }
            aVar.fkR.setVisibility(8);
            aVar.fkQ.setVisibility(0);
            return;
        }
        aVar.fkQ.setVisibility(8);
        aVar.fkR.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.fkM.setImageResource(i);
        aVar.fkN.setVisibility(8);
        aVar.fkM.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bD(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.fkH = new ArrayList(list);
        } else {
            this.fkH = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bE(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fkH == null) {
                this.fkH = new ArrayList();
            }
            this.fkH.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void boE() {
        MessageManager.getInstance().unRegisterListener(this.fae);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private RelativeLayout fkK;
        private View fkL;
        private ImageView fkM;
        private TextView fkN;
        private TbImageView fkO;
        private TextView fkP;
        private GradientTextView fkQ;
        private TextView fkR;
        private HeadImageView fkj;
        private TextView fkl;

        private a() {
        }
    }
}
