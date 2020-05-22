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
    private CustomMessageListener fnH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.fyn.iterator();
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
                            if (message.getTag().equals(i.this.fxJ)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.fxI.getPageContext().showToast(i.this.fxI.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.fxI.getPageContext().showToast(i.this.fxI.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.fxJ)) {
                        i.this.fxI.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private BaseActivity fxI;
    private BdUniqueId fxJ;
    private boolean fyk;
    private com.baidu.live.guardclub.f fyl;
    private b fym;
    private List<com.baidu.live.guardclub.f> fyn;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fxI = baseActivity;
        this.fxJ = bdUniqueId;
        this.avR = z;
        this.fyk = z2;
        MessageManager.getInstance().registerListener(this.fnH);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.fyl = fVar;
    }

    public void a(b bVar) {
        this.fym = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fyn == null) {
            return 0;
        }
        return this.fyn.size();
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
            view = LayoutInflater.from(this.fxI.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.fyq = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.fyr = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.fys = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.fyt = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.fxP = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fyu = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.fyv = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.fxR = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fyw = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.fyx = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.fyn.get(i);
        if (fVar != null) {
            if (!this.fyk) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.fyt.setText(String.valueOf(i + 1));
                        aVar.fys.setVisibility(8);
                        aVar.fyt.setVisibility(0);
                    }
                    aVar.fyr.setVisibility(8);
                    aVar.fyq.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.fyq.setVisibility(8);
                    aVar.fyr.setVisibility(0);
                }
            } else {
                aVar.fyq.setVisibility(8);
                aVar.fyr.setVisibility(0);
            }
            aVar.fxP.setIsRound(true);
            aVar.fxP.setAutoChangeStyle(false);
            aVar.fxP.startLoad(fVar.aOX, 12, false);
            String cn = com.baidu.live.guardclub.g.BH().cn(fVar.aOz);
            if (!TextUtils.isEmpty(cn)) {
                aVar.fyu.startLoad(cn, 10, false);
                aVar.fyu.setVisibility(0);
            } else {
                aVar.fyu.setVisibility(4);
            }
            aVar.fxP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.fyv.setText(fVar.userName);
            aVar.fxR.setText(String.format(this.fxI.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.fyx.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.fyw.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.fyx.setTextColor(this.fxI.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.fyw.setTextColor(this.fxI.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aOV, fVar.userId);
            aVar.fyw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.avR && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.fyk ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.fyk ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.fyk ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.fyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.fym != null) {
            this.fym.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.fxI, this.fxI.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fxI);
            } else if (fVar.aOV) {
                com.baidu.live.data.d dVar = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", false, this.fxJ);
                dVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Jl().a(fVar.userId, dVar);
            } else {
                com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", true, this.fxJ);
                dVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Jl().a(fVar.userId, dVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.fyl == null || !TextUtils.equals(str, this.fyl.userId)) {
            if (z) {
                aVar.fyw.setVisibility(8);
                aVar.fyx.setVisibility(0);
                return;
            }
            aVar.fyx.setVisibility(8);
            aVar.fyw.setVisibility(0);
            return;
        }
        aVar.fyw.setVisibility(8);
        aVar.fyx.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.fys.setImageResource(i);
        aVar.fyt.setVisibility(8);
        aVar.fys.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bA(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.fyn = new ArrayList(list);
        } else {
            this.fyn = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bB(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fyn == null) {
                this.fyn = new ArrayList();
            }
            this.fyn.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buw() {
        MessageManager.getInstance().unRegisterListener(this.fnH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private HeadImageView fxP;
        private TextView fxR;
        private RelativeLayout fyq;
        private View fyr;
        private ImageView fys;
        private TextView fyt;
        private TbImageView fyu;
        private TextView fyv;
        private GradientTextView fyw;
        private TextView fyx;

        private a() {
        }
    }
}
