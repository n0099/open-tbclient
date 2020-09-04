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
/* loaded from: classes7.dex */
public class i extends BaseAdapter {
    private boolean aEy;
    private CustomMessageListener fPH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.gbg.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aYk = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.gaD)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.gaC.getPageContext().showToast(i.this.gaC.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.gaC.getPageContext().showToast(i.this.gaC.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.gaD)) {
                        i.this.gaC.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private BaseActivity gaC;
    private BdUniqueId gaD;
    private boolean gbd;
    private com.baidu.live.guardclub.f gbe;
    private b gbf;
    private List<com.baidu.live.guardclub.f> gbg;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gaC = baseActivity;
        this.gaD = bdUniqueId;
        this.aEy = z;
        this.gbd = z2;
        MessageManager.getInstance().registerListener(this.fPH);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gbe = fVar;
    }

    public void a(b bVar) {
        this.gbf = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gbg == null) {
            return 0;
        }
        return this.gbg.size();
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
            view = LayoutInflater.from(this.gaC.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.gbj = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.gbk = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.gbl = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.gbm = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.gaI = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gbn = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.gbo = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.gaK = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gbp = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.gbq = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gbg.get(i);
        if (fVar != null) {
            if (!this.gbd) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.gbm.setText(String.valueOf(i + 1));
                        aVar.gbl.setVisibility(8);
                        aVar.gbm.setVisibility(0);
                    }
                    aVar.gbk.setVisibility(8);
                    aVar.gbj.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gbj.setVisibility(8);
                    aVar.gbk.setVisibility(0);
                }
            } else {
                aVar.gbj.setVisibility(8);
                aVar.gbk.setVisibility(0);
            }
            aVar.gaI.setIsRound(true);
            aVar.gaI.setAutoChangeStyle(false);
            aVar.gaI.startLoad(fVar.aYm, 12, false);
            String er = com.baidu.live.guardclub.g.Im().er(fVar.aXO);
            if (!TextUtils.isEmpty(er)) {
                aVar.gbn.startLoad(er, 10, false);
                aVar.gbn.setVisibility(0);
            } else {
                aVar.gbn.setVisibility(4);
            }
            aVar.gaI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.gbo.setText(fVar.userName);
            aVar.gaK.setText(String.format(this.gaC.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gbq.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.gbp.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.gbq.setTextColor(this.gaC.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.gbp.setTextColor(this.gaC.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aYk, fVar.userId);
            aVar.gbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aEy && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.gbd ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.gbd ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.gbd ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.gbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.gbf != null) {
            this.gbf.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gaC, this.gaC.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gaC);
            } else if (fVar.aYk) {
                com.baidu.live.data.d dVar = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", false, this.gaD);
                dVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Qx().a(fVar.userId, dVar);
            } else {
                com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", true, this.gaD);
                dVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Qx().a(fVar.userId, dVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.gbe == null || !TextUtils.equals(str, this.gbe.userId)) {
            if (z) {
                aVar.gbp.setVisibility(8);
                aVar.gbq.setVisibility(0);
                return;
            }
            aVar.gbq.setVisibility(8);
            aVar.gbp.setVisibility(0);
            return;
        }
        aVar.gbp.setVisibility(8);
        aVar.gbq.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gbl.setImageResource(i);
        aVar.gbm.setVisibility(8);
        aVar.gbl.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bO(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gbg = new ArrayList(list);
        } else {
            this.gbg = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bP(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gbg == null) {
                this.gbg = new ArrayList();
            }
            this.gbg.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bKg() {
        MessageManager.getInstance().unRegisterListener(this.fPH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private HeadImageView gaI;
        private TextView gaK;
        private RelativeLayout gbj;
        private View gbk;
        private ImageView gbl;
        private TextView gbm;
        private TbImageView gbn;
        private TextView gbo;
        private GradientTextView gbp;
        private TextView gbq;

        private a() {
        }
    }
}
