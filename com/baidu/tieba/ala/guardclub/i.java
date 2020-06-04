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
    private boolean avR;
    private CustomMessageListener fnS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.fyy.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aOV = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.fxU)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.fxT.getPageContext().showToast(i.this.fxT.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.fxT.getPageContext().showToast(i.this.fxT.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.fxU)) {
                        i.this.fxT.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private BaseActivity fxT;
    private BdUniqueId fxU;
    private boolean fyv;
    private com.baidu.live.guardclub.f fyw;
    private b fyx;
    private List<com.baidu.live.guardclub.f> fyy;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fxT = baseActivity;
        this.fxU = bdUniqueId;
        this.avR = z;
        this.fyv = z2;
        MessageManager.getInstance().registerListener(this.fnS);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.fyw = fVar;
    }

    public void a(b bVar) {
        this.fyx = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fyy == null) {
            return 0;
        }
        return this.fyy.size();
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
            view = LayoutInflater.from(this.fxT.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.fyB = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.fyC = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.fyD = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.fyE = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.fya = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fyF = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.fyG = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.fyc = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fyH = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.fyI = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.fyy.get(i);
        if (fVar != null) {
            if (!this.fyv) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.fyE.setText(String.valueOf(i + 1));
                        aVar.fyD.setVisibility(8);
                        aVar.fyE.setVisibility(0);
                    }
                    aVar.fyC.setVisibility(8);
                    aVar.fyB.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.fyB.setVisibility(8);
                    aVar.fyC.setVisibility(0);
                }
            } else {
                aVar.fyB.setVisibility(8);
                aVar.fyC.setVisibility(0);
            }
            aVar.fya.setIsRound(true);
            aVar.fya.setAutoChangeStyle(false);
            aVar.fya.startLoad(fVar.aOX, 12, false);
            String cp = com.baidu.live.guardclub.g.BH().cp(fVar.aOz);
            if (!TextUtils.isEmpty(cp)) {
                aVar.fyF.startLoad(cp, 10, false);
                aVar.fyF.setVisibility(0);
            } else {
                aVar.fyF.setVisibility(4);
            }
            aVar.fya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.fyG.setText(fVar.userName);
            aVar.fyc.setText(String.format(this.fxT.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.fyI.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.fyH.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.fyI.setTextColor(this.fxT.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.fyH.setTextColor(this.fxT.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aOV, fVar.userId);
            aVar.fyH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.avR && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.fyv ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.fyv ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.fyv ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.fyI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.fyx != null) {
            this.fyx.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.fxT, this.fxT.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fxT);
            } else if (fVar.aOV) {
                com.baidu.live.data.d dVar = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", false, this.fxU);
                dVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Jl().a(fVar.userId, dVar);
            } else {
                com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", true, this.fxU);
                dVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Jl().a(fVar.userId, dVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.fyw == null || !TextUtils.equals(str, this.fyw.userId)) {
            if (z) {
                aVar.fyH.setVisibility(8);
                aVar.fyI.setVisibility(0);
                return;
            }
            aVar.fyI.setVisibility(8);
            aVar.fyH.setVisibility(0);
            return;
        }
        aVar.fyH.setVisibility(8);
        aVar.fyI.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.fyD.setImageResource(i);
        aVar.fyE.setVisibility(8);
        aVar.fyD.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bA(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.fyy = new ArrayList(list);
        } else {
            this.fyy = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bB(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fyy == null) {
                this.fyy = new ArrayList();
            }
            this.fyy.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buy() {
        MessageManager.getInstance().unRegisterListener(this.fnS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private RelativeLayout fyB;
        private View fyC;
        private ImageView fyD;
        private TextView fyE;
        private TbImageView fyF;
        private TextView fyG;
        private GradientTextView fyH;
        private TextView fyI;
        private HeadImageView fya;
        private TextView fyc;

        private a() {
        }
    }
}
