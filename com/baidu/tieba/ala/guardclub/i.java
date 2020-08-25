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
    private boolean aEw;
    private CustomMessageListener fPD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.gbc.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aYi = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.gaz)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.gay.getPageContext().showToast(i.this.gay.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.gay.getPageContext().showToast(i.this.gay.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.gaz)) {
                        i.this.gay.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private boolean gaZ;
    private BaseActivity gay;
    private BdUniqueId gaz;
    private com.baidu.live.guardclub.f gba;
    private b gbb;
    private List<com.baidu.live.guardclub.f> gbc;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gay = baseActivity;
        this.gaz = bdUniqueId;
        this.aEw = z;
        this.gaZ = z2;
        MessageManager.getInstance().registerListener(this.fPD);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gba = fVar;
    }

    public void a(b bVar) {
        this.gbb = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gbc == null) {
            return 0;
        }
        return this.gbc.size();
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
            view = LayoutInflater.from(this.gay.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.gbf = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.gbg = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.gbh = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.gbi = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.gaE = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gbj = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.gbk = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.gaG = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gbl = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.gbm = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gbc.get(i);
        if (fVar != null) {
            if (!this.gaZ) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.gbi.setText(String.valueOf(i + 1));
                        aVar.gbh.setVisibility(8);
                        aVar.gbi.setVisibility(0);
                    }
                    aVar.gbg.setVisibility(8);
                    aVar.gbf.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gbf.setVisibility(8);
                    aVar.gbg.setVisibility(0);
                }
            } else {
                aVar.gbf.setVisibility(8);
                aVar.gbg.setVisibility(0);
            }
            aVar.gaE.setIsRound(true);
            aVar.gaE.setAutoChangeStyle(false);
            aVar.gaE.startLoad(fVar.aYk, 12, false);
            String er = com.baidu.live.guardclub.g.Im().er(fVar.aXM);
            if (!TextUtils.isEmpty(er)) {
                aVar.gbj.startLoad(er, 10, false);
                aVar.gbj.setVisibility(0);
            } else {
                aVar.gbj.setVisibility(4);
            }
            aVar.gaE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.gbk.setText(fVar.userName);
            aVar.gaG.setText(String.format(this.gay.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gbm.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.gbl.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.gbm.setTextColor(this.gay.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.gbl.setTextColor(this.gay.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aYi, fVar.userId);
            aVar.gbl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.aEw && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.gaZ ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.gaZ ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.gaZ ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.gbm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.gbb != null) {
            this.gbb.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gay, this.gay.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gay);
            } else if (fVar.aYi) {
                com.baidu.live.data.d dVar = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", false, this.gaz);
                dVar.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Qx().a(fVar.userId, dVar);
            } else {
                com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(fVar.portrait, fVar.userId, "1", true, this.gaz);
                dVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Qx().a(fVar.userId, dVar2);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.gba == null || !TextUtils.equals(str, this.gba.userId)) {
            if (z) {
                aVar.gbl.setVisibility(8);
                aVar.gbm.setVisibility(0);
                return;
            }
            aVar.gbm.setVisibility(8);
            aVar.gbl.setVisibility(0);
            return;
        }
        aVar.gbl.setVisibility(8);
        aVar.gbm.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gbh.setImageResource(i);
        aVar.gbi.setVisibility(8);
        aVar.gbh.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bO(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gbc = new ArrayList(list);
        } else {
            this.gbc = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bP(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gbc == null) {
                this.gbc = new ArrayList();
            }
            this.gbc.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bKf() {
        MessageManager.getInstance().unRegisterListener(this.fPD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private HeadImageView gaE;
        private TextView gaG;
        private RelativeLayout gbf;
        private View gbg;
        private ImageView gbh;
        private TextView gbi;
        private TbImageView gbj;
        private TextView gbk;
        private GradientTextView gbl;
        private TextView gbm;

        private a() {
        }
    }
}
