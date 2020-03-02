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
    private BaseActivity eET;
    private BdUniqueId eEU;
    private boolean eFv;
    private com.baidu.live.guardclub.f eFw;
    private b eFx;
    private List<com.baidu.live.guardclub.f> eFy;
    private CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.eFy.iterator();
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
                            if (message.getTag().equals(i.this.eEU)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.eET.getPageContext().showToast(i.this.eET.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.eET.getPageContext().showToast(i.this.eET.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.eEU)) {
                        i.this.eET.showToast(updateAttentionMessage.getData().errorString);
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
        this.eET = baseActivity;
        this.eEU = bdUniqueId;
        this.Yr = z;
        this.eFv = z2;
        MessageManager.getInstance().registerListener(this.evz);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.eFw = fVar;
    }

    public void a(b bVar) {
        this.eFx = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eFy == null) {
            return 0;
        }
        return this.eFy.size();
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
            view = LayoutInflater.from(this.eET.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.eFB = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.eFC = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.eFD = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.eFE = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.eFa = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eFF = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.eFG = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.eFc = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eFH = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.eFI = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.eFy.get(i);
        if (fVar != null) {
            if (!this.eFv) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.eFE.setText(String.valueOf(i + 1));
                        aVar.eFD.setVisibility(8);
                        aVar.eFE.setVisibility(0);
                    }
                    aVar.eFC.setVisibility(8);
                    aVar.eFB.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.eFB.setVisibility(8);
                    aVar.eFC.setVisibility(0);
                }
            } else {
                aVar.eFB.setVisibility(8);
                aVar.eFC.setVisibility(0);
            }
            aVar.eFa.setIsRound(true);
            aVar.eFa.setAutoChangeStyle(false);
            aVar.eFa.startLoad(fVar.aqo, 12, false);
            String bR = com.baidu.live.guardclub.g.vH().bR(fVar.apQ);
            if (!TextUtils.isEmpty(bR)) {
                aVar.eFF.startLoad(bR, 10, false);
                aVar.eFF.setVisibility(0);
            } else {
                aVar.eFF.setVisibility(4);
            }
            aVar.eFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.eFG.setText(fVar.userName);
            aVar.eFc.setText(String.format(this.eET.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.eFI.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.eFH.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.eFI.setTextColor(this.eET.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.eFH.setTextColor(this.eET.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aqm, fVar.userId);
            aVar.eFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.Yr && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.eFv ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.eFv ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.eFv ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.eFI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.eFx != null) {
            this.eFx.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.eET, this.eET.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.eET);
            } else if (fVar.aqm) {
                com.baidu.live.view.a.Bj().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", false, this.eEU));
            } else {
                com.baidu.live.view.a.Bj().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", true, this.eEU));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.eFw == null || !TextUtils.equals(str, this.eFw.userId)) {
            if (z) {
                aVar.eFH.setVisibility(8);
                aVar.eFI.setVisibility(0);
                return;
            }
            aVar.eFI.setVisibility(8);
            aVar.eFH.setVisibility(0);
            return;
        }
        aVar.eFH.setVisibility(8);
        aVar.eFI.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.eFD.setImageResource(i);
        aVar.eFE.setVisibility(8);
        aVar.eFD.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.eFy = new ArrayList(list);
        } else {
            this.eFy = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eFy == null) {
                this.eFy = new ArrayList();
            }
            this.eFy.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfj() {
        MessageManager.getInstance().unRegisterListener(this.evz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private RelativeLayout eFB;
        private View eFC;
        private ImageView eFD;
        private TextView eFE;
        private TbImageView eFF;
        private TextView eFG;
        private GradientTextView eFH;
        private TextView eFI;
        private HeadImageView eFa;
        private TextView eFc;

        private a() {
        }
    }
}
