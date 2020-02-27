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
    private boolean Yr;
    private BaseActivity eES;
    private BdUniqueId eET;
    private boolean eFu;
    private com.baidu.live.guardclub.f eFv;
    private b eFw;
    private List<com.baidu.live.guardclub.f> eFx;
    private CustomMessageListener evy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.eFx.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aqm = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.eET)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.eES.getPageContext().showToast(i.this.eES.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.eES.getPageContext().showToast(i.this.eES.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.eET)) {
                        i.this.eES.showToast(updateAttentionMessage.getData().errorString);
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
        this.eES = baseActivity;
        this.eET = bdUniqueId;
        this.Yr = z;
        this.eFu = z2;
        MessageManager.getInstance().registerListener(this.evy);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.eFv = fVar;
    }

    public void a(b bVar) {
        this.eFw = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eFx == null) {
            return 0;
        }
        return this.eFx.size();
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
            view = LayoutInflater.from(this.eES.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.eFA = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.eFB = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.eFC = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.eFD = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.eEZ = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eFE = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.eFF = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.eFb = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eFG = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.eFH = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.eFx.get(i);
        if (fVar != null) {
            if (!this.eFu) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.eFD.setText(String.valueOf(i + 1));
                        aVar.eFC.setVisibility(8);
                        aVar.eFD.setVisibility(0);
                    }
                    aVar.eFB.setVisibility(8);
                    aVar.eFA.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.eFA.setVisibility(8);
                    aVar.eFB.setVisibility(0);
                }
            } else {
                aVar.eFA.setVisibility(8);
                aVar.eFB.setVisibility(0);
            }
            aVar.eEZ.setIsRound(true);
            aVar.eEZ.setAutoChangeStyle(false);
            aVar.eEZ.startLoad(fVar.aqo, 12, false);
            String bR = com.baidu.live.guardclub.g.vH().bR(fVar.apQ);
            if (!TextUtils.isEmpty(bR)) {
                aVar.eFE.startLoad(bR, 10, false);
                aVar.eFE.setVisibility(0);
            } else {
                aVar.eFE.setVisibility(4);
            }
            aVar.eEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.eFF.setText(fVar.userName);
            aVar.eFb.setText(String.format(this.eES.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.eFH.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.eFG.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.eFH.setTextColor(this.eES.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.eFG.setTextColor(this.eES.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aqm, fVar.userId);
            aVar.eFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.Yr && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.eFu ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.eFu ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.eFu ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.eFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.eFw != null) {
            this.eFw.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.eES, this.eES.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.eES);
            } else if (fVar.aqm) {
                com.baidu.live.view.a.Bh().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", false, this.eET));
            } else {
                com.baidu.live.view.a.Bh().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", true, this.eET));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.eFv == null || !TextUtils.equals(str, this.eFv.userId)) {
            if (z) {
                aVar.eFG.setVisibility(8);
                aVar.eFH.setVisibility(0);
                return;
            }
            aVar.eFH.setVisibility(8);
            aVar.eFG.setVisibility(0);
            return;
        }
        aVar.eFG.setVisibility(8);
        aVar.eFH.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.eFC.setImageResource(i);
        aVar.eFD.setVisibility(8);
        aVar.eFC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.eFx = new ArrayList(list);
        } else {
            this.eFx = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eFx == null) {
                this.eFx = new ArrayList();
            }
            this.eFx.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfh() {
        MessageManager.getInstance().unRegisterListener(this.evy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private HeadImageView eEZ;
        private RelativeLayout eFA;
        private View eFB;
        private ImageView eFC;
        private TextView eFD;
        private TbImageView eFE;
        private TextView eFF;
        private GradientTextView eFG;
        private TextView eFH;
        private TextView eFb;

        private a() {
        }
    }
}
