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
    private boolean aKf;
    private BaseActivity gFY;
    private BdUniqueId gFZ;
    private b gGA;
    private List<com.baidu.live.guardclub.f> gGB;
    private boolean gGy;
    private com.baidu.live.guardclub.f gGz;
    private CustomMessageListener gvc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.gGB.iterator();
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
                            if (message.getTag().equals(i.this.gFZ)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.gFY.getPageContext().showToast(i.this.gFY.getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.gFY.getPageContext().showToast(i.this.gFY.getResources().getString(a.h.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.gFZ)) {
                        i.this.gFY.showToast(updateAttentionMessage.getData().errorString);
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
        this.gFY = baseActivity;
        this.gFZ = bdUniqueId;
        this.aKf = z;
        this.gGy = z2;
        MessageManager.getInstance().registerListener(this.gvc);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gGz = fVar;
    }

    public void a(b bVar) {
        this.gGA = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gGB == null) {
            return 0;
        }
        return this.gGB.size();
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
            view = LayoutInflater.from(this.gFY.getPageContext().getPageActivity()).inflate(a.g.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.gGE = (RelativeLayout) view.findViewById(a.f.layout_guard_member_list_rank);
            aVar.gGF = view.findViewById(a.f.view_guard_club_list_rank);
            aVar.gGG = (ImageView) view.findViewById(a.f.img_guard_club_list_rank);
            aVar.gGH = (TextView) view.findViewById(a.f.tv_guard_club_list_rank);
            aVar.gGe = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gGI = (TbImageView) view.findViewById(a.f.img_guard_club_list_medal);
            aVar.bSt = (TextView) view.findViewById(a.f.tv_guard_club_list_name);
            aVar.gGg = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gGJ = (GradientTextView) view.findViewById(a.f.tv_guard_club_list_followed);
            aVar.gGK = (TextView) view.findViewById(a.f.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gGB.get(i);
        if (fVar != null) {
            if (!this.gGy) {
                try {
                    if (i == 0) {
                        a(aVar, a.e.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.e.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.e.gcb_icon_contribution_third);
                    } else {
                        aVar.gGH.setText(String.valueOf(i + 1));
                        aVar.gGG.setVisibility(8);
                        aVar.gGH.setVisibility(0);
                    }
                    aVar.gGF.setVisibility(8);
                    aVar.gGE.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gGE.setVisibility(8);
                    aVar.gGF.setVisibility(0);
                }
            } else {
                aVar.gGE.setVisibility(8);
                aVar.gGF.setVisibility(0);
            }
            aVar.gGe.setIsRound(true);
            aVar.gGe.setAutoChangeStyle(false);
            aVar.gGe.startLoad(fVar.bgP, 12, false);
            String eB = com.baidu.live.guardclub.g.KF().eB(fVar.bgr);
            if (!TextUtils.isEmpty(eB)) {
                aVar.gGI.startLoad(eB, 10, false);
                aVar.gGI.setVisibility(0);
            } else {
                aVar.gGI.setVisibility(4);
            }
            aVar.gGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.bSt.setText(fVar.userName);
            aVar.gGg.setText(String.format(this.gFY.getResources().getString(a.h.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gGK.setBackgroundResource(a.e.gcb_attention_bg_bd_s);
                aVar.gGJ.setBackgroundResource(a.e.gcb_attention_bg_bd_selector);
                aVar.gGK.setTextColor(this.gFY.getResources().getColor(a.c.sdk_white_alpha20));
                aVar.gGJ.setTextColor(this.gFY.getResources().getColor(a.c.sdk_white_alpha70));
            }
            a(aVar, fVar.isFollowed, fVar.userId);
            aVar.gGJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aKf && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.gGy ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.gGy ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.gGy ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.gGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.gGA != null) {
            this.gGA.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gFY, this.gFY.getResources().getString(a.h.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gFY);
            } else if (fVar.isFollowed) {
                com.baidu.live.data.f fVar2 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", false, this.gFZ);
                fVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Wx().a(fVar.userId, fVar2);
            } else {
                com.baidu.live.data.f fVar3 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", true, this.gFZ);
                fVar3.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Wx().a(fVar.userId, fVar3);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.gGz == null || !TextUtils.equals(str, this.gGz.userId)) {
            if (z) {
                aVar.gGJ.setVisibility(8);
                aVar.gGK.setVisibility(0);
                return;
            }
            aVar.gGK.setVisibility(8);
            aVar.gGJ.setVisibility(0);
            return;
        }
        aVar.gGJ.setVisibility(8);
        aVar.gGK.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gGG.setImageResource(i);
        aVar.gGH.setVisibility(8);
        aVar.gGG.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cn(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gGB = new ArrayList(list);
        } else {
            this.gGB = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void co(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gGB == null) {
                this.gGB = new ArrayList();
            }
            this.gGB.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bTf() {
        MessageManager.getInstance().unRegisterListener(this.gvc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView bSt;
        private RelativeLayout gGE;
        private View gGF;
        private ImageView gGG;
        private TextView gGH;
        private TbImageView gGI;
        private GradientTextView gGJ;
        private TextView gGK;
        private HeadImageView gGe;
        private TextView gGg;

        private a() {
        }
    }
}
