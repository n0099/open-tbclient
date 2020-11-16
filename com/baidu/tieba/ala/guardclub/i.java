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
    private boolean aIu;
    private BaseActivity gFF;
    private BdUniqueId gFG;
    private boolean gGf;
    private com.baidu.live.guardclub.f gGg;
    private b gGh;
    private List<com.baidu.live.guardclub.f> gGi;
    private CustomMessageListener guJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.gGi.iterator();
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
                            if (message.getTag().equals(i.this.gFG)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.gFF.getPageContext().showToast(i.this.gFF.getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.gFF.getPageContext().showToast(i.this.gFF.getResources().getString(a.h.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.gFG)) {
                        i.this.gFF.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gFF = baseActivity;
        this.gFG = bdUniqueId;
        this.aIu = z;
        this.gGf = z2;
        MessageManager.getInstance().registerListener(this.guJ);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gGg = fVar;
    }

    public void a(b bVar) {
        this.gGh = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gGi == null) {
            return 0;
        }
        return this.gGi.size();
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
            view = LayoutInflater.from(this.gFF.getPageContext().getPageActivity()).inflate(a.g.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.gGl = (RelativeLayout) view.findViewById(a.f.layout_guard_member_list_rank);
            aVar.gGm = view.findViewById(a.f.view_guard_club_list_rank);
            aVar.gGn = (ImageView) view.findViewById(a.f.img_guard_club_list_rank);
            aVar.gGo = (TextView) view.findViewById(a.f.tv_guard_club_list_rank);
            aVar.gFL = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gGp = (TbImageView) view.findViewById(a.f.img_guard_club_list_medal);
            aVar.bQJ = (TextView) view.findViewById(a.f.tv_guard_club_list_name);
            aVar.gFN = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gGq = (GradientTextView) view.findViewById(a.f.tv_guard_club_list_followed);
            aVar.gGr = (TextView) view.findViewById(a.f.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gGi.get(i);
        if (fVar != null) {
            if (!this.gGf) {
                try {
                    if (i == 0) {
                        a(aVar, a.e.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.e.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.e.gcb_icon_contribution_third);
                    } else {
                        aVar.gGo.setText(String.valueOf(i + 1));
                        aVar.gGn.setVisibility(8);
                        aVar.gGo.setVisibility(0);
                    }
                    aVar.gGm.setVisibility(8);
                    aVar.gGl.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gGl.setVisibility(8);
                    aVar.gGm.setVisibility(0);
                }
            } else {
                aVar.gGl.setVisibility(8);
                aVar.gGm.setVisibility(0);
            }
            aVar.gFL.setIsRound(true);
            aVar.gFL.setAutoChangeStyle(false);
            aVar.gFL.startLoad(fVar.bfc, 12, false);
            String ex = com.baidu.live.guardclub.g.JW().ex(fVar.beE);
            if (!TextUtils.isEmpty(ex)) {
                aVar.gGp.startLoad(ex, 10, false);
                aVar.gGp.setVisibility(0);
            } else {
                aVar.gGp.setVisibility(4);
            }
            aVar.gFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.bQJ.setText(fVar.userName);
            aVar.gFN.setText(String.format(this.gFF.getResources().getString(a.h.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gGr.setBackgroundResource(a.e.gcb_attention_bg_bd_s);
                aVar.gGq.setBackgroundResource(a.e.gcb_attention_bg_bd_selector);
                aVar.gGr.setTextColor(this.gFF.getResources().getColor(a.c.sdk_white_alpha20));
                aVar.gGq.setTextColor(this.gFF.getResources().getColor(a.c.sdk_white_alpha70));
            }
            a(aVar, fVar.isFollowed, fVar.userId);
            aVar.gGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aIu && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.gGf ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.gGf ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.gGf ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.gGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.gGh != null) {
            this.gGh.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gFF, this.gFF.getResources().getString(a.h.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gFF);
            } else if (fVar.isFollowed) {
                com.baidu.live.data.f fVar2 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", false, this.gFG);
                fVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.VO().a(fVar.userId, fVar2);
            } else {
                com.baidu.live.data.f fVar3 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", true, this.gFG);
                fVar3.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.VO().a(fVar.userId, fVar3);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.gGg == null || !TextUtils.equals(str, this.gGg.userId)) {
            if (z) {
                aVar.gGq.setVisibility(8);
                aVar.gGr.setVisibility(0);
                return;
            }
            aVar.gGr.setVisibility(8);
            aVar.gGq.setVisibility(0);
            return;
        }
        aVar.gGq.setVisibility(8);
        aVar.gGr.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gGn.setImageResource(i);
        aVar.gGo.setVisibility(8);
        aVar.gGn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cn(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gGi = new ArrayList(list);
        } else {
            this.gGi = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void co(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gGi == null) {
                this.gGi = new ArrayList();
            }
            this.gGi.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSy() {
        MessageManager.getInstance().unRegisterListener(this.guJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView bQJ;
        private HeadImageView gFL;
        private TextView gFN;
        private RelativeLayout gGl;
        private View gGm;
        private ImageView gGn;
        private TextView gGo;
        private TbImageView gGp;
        private GradientTextView gGq;
        private TextView gGr;

        private a() {
        }
    }
}
