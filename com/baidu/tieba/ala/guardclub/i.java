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
    private boolean aIH;
    private CustomMessageListener gfl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.gqI.iterator();
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
                            if (message.getTag().equals(i.this.gqg)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.gqf.getPageContext().showToast(i.this.gqf.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.gqf.getPageContext().showToast(i.this.gqf.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.gqg)) {
                        i.this.gqf.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private boolean gqF;
    private com.baidu.live.guardclub.f gqG;
    private b gqH;
    private List<com.baidu.live.guardclub.f> gqI;
    private BaseActivity gqf;
    private BdUniqueId gqg;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gqf = baseActivity;
        this.gqg = bdUniqueId;
        this.aIH = z;
        this.gqF = z2;
        MessageManager.getInstance().registerListener(this.gfl);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gqG = fVar;
    }

    public void a(b bVar) {
        this.gqH = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gqI == null) {
            return 0;
        }
        return this.gqI.size();
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
            view = LayoutInflater.from(this.gqf.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.gqL = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.gqM = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.gqN = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.gqO = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.gql = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gqP = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.gqQ = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.gqn = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gqR = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.gqS = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gqI.get(i);
        if (fVar != null) {
            if (!this.gqF) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.gqO.setText(String.valueOf(i + 1));
                        aVar.gqN.setVisibility(8);
                        aVar.gqO.setVisibility(0);
                    }
                    aVar.gqM.setVisibility(8);
                    aVar.gqL.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gqL.setVisibility(8);
                    aVar.gqM.setVisibility(0);
                }
            } else {
                aVar.gqL.setVisibility(8);
                aVar.gqM.setVisibility(0);
            }
            aVar.gql.setIsRound(true);
            aVar.gql.setAutoChangeStyle(false);
            aVar.gql.startLoad(fVar.bed, 12, false);
            String eA = com.baidu.live.guardclub.g.JM().eA(fVar.bdG);
            if (!TextUtils.isEmpty(eA)) {
                aVar.gqP.startLoad(eA, 10, false);
                aVar.gqP.setVisibility(0);
            } else {
                aVar.gqP.setVisibility(4);
            }
            aVar.gql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.gqQ.setText(fVar.userName);
            aVar.gqn.setText(String.format(this.gqf.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gqS.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.gqR.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.gqS.setTextColor(this.gqf.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.gqR.setTextColor(this.gqf.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.isFollowed, fVar.userId);
            aVar.gqR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aIH && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.gqF ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.gqF ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.gqF ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.gqS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.gqH != null) {
            this.gqH.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gqf, this.gqf.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gqf);
            } else if (fVar.isFollowed) {
                com.baidu.live.data.e eVar = new com.baidu.live.data.e(fVar.portrait, fVar.userId, "1", false, this.gqg);
                eVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.SY().a(fVar.userId, eVar);
            } else {
                com.baidu.live.data.e eVar2 = new com.baidu.live.data.e(fVar.portrait, fVar.userId, "1", true, this.gqg);
                eVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.SY().a(fVar.userId, eVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.gqG == null || !TextUtils.equals(str, this.gqG.userId)) {
            if (z) {
                aVar.gqR.setVisibility(8);
                aVar.gqS.setVisibility(0);
                return;
            }
            aVar.gqS.setVisibility(8);
            aVar.gqR.setVisibility(0);
            return;
        }
        aVar.gqR.setVisibility(8);
        aVar.gqS.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gqN.setImageResource(i);
        aVar.gqO.setVisibility(8);
        aVar.gqN.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bW(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gqI = new ArrayList(list);
        } else {
            this.gqI = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bX(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gqI == null) {
                this.gqI = new ArrayList();
            }
            this.gqI.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOa() {
        MessageManager.getInstance().unRegisterListener(this.gfl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private RelativeLayout gqL;
        private View gqM;
        private ImageView gqN;
        private TextView gqO;
        private TbImageView gqP;
        private TextView gqQ;
        private GradientTextView gqR;
        private TextView gqS;
        private HeadImageView gql;
        private TextView gqn;

        private a() {
        }
    }
}
