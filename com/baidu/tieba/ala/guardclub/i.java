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
    private boolean eFI;
    private com.baidu.live.guardclub.f eFJ;
    private b eFK;
    private List<com.baidu.live.guardclub.f> eFL;
    private BaseActivity eFg;
    private BdUniqueId eFh;
    private CustomMessageListener evM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.eFL.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aqn = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.eFh)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.eFg.getPageContext().showToast(i.this.eFg.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.eFg.getPageContext().showToast(i.this.eFg.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.eFh)) {
                        i.this.eFg.showToast(updateAttentionMessage.getData().errorString);
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
        this.eFg = baseActivity;
        this.eFh = bdUniqueId;
        this.Yr = z;
        this.eFI = z2;
        MessageManager.getInstance().registerListener(this.evM);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.eFJ = fVar;
    }

    public void a(b bVar) {
        this.eFK = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eFL == null) {
            return 0;
        }
        return this.eFL.size();
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
            view = LayoutInflater.from(this.eFg.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.eFO = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.eFP = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.eFQ = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.eFR = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.eFn = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eFS = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.eFT = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.eFp = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eFU = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.eFV = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.eFL.get(i);
        if (fVar != null) {
            if (!this.eFI) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.eFR.setText(String.valueOf(i + 1));
                        aVar.eFQ.setVisibility(8);
                        aVar.eFR.setVisibility(0);
                    }
                    aVar.eFP.setVisibility(8);
                    aVar.eFO.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.eFO.setVisibility(8);
                    aVar.eFP.setVisibility(0);
                }
            } else {
                aVar.eFO.setVisibility(8);
                aVar.eFP.setVisibility(0);
            }
            aVar.eFn.setIsRound(true);
            aVar.eFn.setAutoChangeStyle(false);
            aVar.eFn.startLoad(fVar.aqp, 12, false);
            String bR = com.baidu.live.guardclub.g.vH().bR(fVar.apR);
            if (!TextUtils.isEmpty(bR)) {
                aVar.eFS.startLoad(bR, 10, false);
                aVar.eFS.setVisibility(0);
            } else {
                aVar.eFS.setVisibility(4);
            }
            aVar.eFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.eFT.setText(fVar.userName);
            aVar.eFp.setText(String.format(this.eFg.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.eFV.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.eFU.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.eFV.setTextColor(this.eFg.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.eFU.setTextColor(this.eFg.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aqn, fVar.userId);
            aVar.eFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.Yr && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.eFI ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.eFI ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.eFI ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.eFV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.eFK != null) {
            this.eFK.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.eFg, this.eFg.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.eFg);
            } else if (fVar.aqn) {
                com.baidu.live.view.a.Bj().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", false, this.eFh));
            } else {
                com.baidu.live.view.a.Bj().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", true, this.eFh));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.eFJ == null || !TextUtils.equals(str, this.eFJ.userId)) {
            if (z) {
                aVar.eFU.setVisibility(8);
                aVar.eFV.setVisibility(0);
                return;
            }
            aVar.eFV.setVisibility(8);
            aVar.eFU.setVisibility(0);
            return;
        }
        aVar.eFU.setVisibility(8);
        aVar.eFV.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.eFQ.setImageResource(i);
        aVar.eFR.setVisibility(8);
        aVar.eFQ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.eFL = new ArrayList(list);
        } else {
            this.eFL = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eFL == null) {
                this.eFL = new ArrayList();
            }
            this.eFL.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfk() {
        MessageManager.getInstance().unRegisterListener(this.evM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private RelativeLayout eFO;
        private View eFP;
        private ImageView eFQ;
        private TextView eFR;
        private TbImageView eFS;
        private TextView eFT;
        private GradientTextView eFU;
        private TextView eFV;
        private HeadImageView eFn;
        private TextView eFp;

        private a() {
        }
    }
}
