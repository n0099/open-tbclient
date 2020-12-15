package com.baidu.tieba.ala.guardclub;

import android.graphics.Bitmap;
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
public class j extends BaseAdapter {
    private boolean aLj;
    private BdUniqueId aWW;
    private CustomMessageListener gDu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.j.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = j.this.gPr.iterator();
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
                            j.this.notifyDataSetChanged();
                            if (message.getTag().equals(j.this.aWW)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    j.this.gOP.getPageContext().showToast(j.this.gOP.getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                } else {
                                    j.this.gOP.getPageContext().showToast(j.this.gOP.getResources().getString(a.h.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(j.this.aWW)) {
                        j.this.gOP.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private BaseActivity gOP;
    private boolean gPo;
    private com.baidu.live.guardclub.f gPp;
    private b gPq;
    private List<com.baidu.live.guardclub.f> gPr;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gOP = baseActivity;
        this.aWW = bdUniqueId;
        this.aLj = z;
        this.gPo = z2;
        MessageManager.getInstance().registerListener(this.gDu);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gPp = fVar;
    }

    public void a(b bVar) {
        this.gPq = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gPr == null) {
            return 0;
        }
        return this.gPr.size();
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
            view = LayoutInflater.from(this.gOP.getPageContext().getPageActivity()).inflate(a.g.item_guard_member_list, viewGroup, false);
            a aVar2 = new a();
            aVar2.gPu = (RelativeLayout) view.findViewById(a.f.layout_guard_member_list_rank);
            aVar2.gPv = view.findViewById(a.f.view_guard_club_list_rank);
            aVar2.gPw = (ImageView) view.findViewById(a.f.img_guard_club_list_rank);
            aVar2.gPx = (TextView) view.findViewById(a.f.tv_guard_club_list_rank);
            aVar2.gOU = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar2.gPy = (TbImageView) view.findViewById(a.f.img_guard_club_list_medal);
            aVar2.bVT = (TextView) view.findViewById(a.f.tv_guard_club_list_name);
            aVar2.gOW = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar2.gPz = (GradientTextView) view.findViewById(a.f.tv_guard_club_list_followed);
            aVar2.gPA = (TextView) view.findViewById(a.f.tv_guard_club_list_un_followed);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gPr.get(i);
        if (fVar != null) {
            if (!this.gPo) {
                try {
                    if (i == 0) {
                        a(aVar, a.e.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.e.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.e.gcb_icon_contribution_third);
                    } else {
                        aVar.gPx.setText(String.valueOf(i + 1));
                        aVar.gPw.setVisibility(8);
                        aVar.gPx.setVisibility(0);
                    }
                    aVar.gPv.setVisibility(8);
                    aVar.gPu.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gPu.setVisibility(8);
                    aVar.gPv.setVisibility(0);
                }
            } else {
                aVar.gPu.setVisibility(8);
                aVar.gPv.setVisibility(0);
            }
            aVar.gOU.setIsRound(true);
            aVar.gOU.setAutoChangeStyle(false);
            aVar.gOU.startLoad(fVar.bjs, 12, false);
            Bitmap a2 = com.baidu.live.ak.b.a(this.gOP, fVar.guardName, fVar.guardLevel, 0, a.d.sdk_ds32, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                aVar.gPy.setImageBitmap(a2);
                aVar.gPy.setVisibility(0);
            } else {
                aVar.gPy.setVisibility(4);
            }
            aVar.gOU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    j.this.b(fVar);
                }
            });
            aVar.bVT.setText(fVar.userName);
            aVar.gOW.setText(String.format(this.gOP.getResources().getString(a.h.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gPA.setBackgroundResource(a.e.gcb_attention_bg_bd_s);
                aVar.gPz.setBackgroundResource(a.e.gcb_attention_bg_bd_selector);
                aVar.gPA.setTextColor(this.gOP.getResources().getColor(a.c.sdk_white_alpha20));
                aVar.gPz.setTextColor(this.gOP.getResources().getColor(a.c.sdk_white_alpha70));
            }
            a(aVar, fVar.isFollowed, fVar.userId);
            aVar.gPz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    j.this.c(fVar);
                    if (!j.this.aLj && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, j.this.gPo ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", j.this.gPo ? "guard_member" : "guard", j.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, j.this.gPo ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, j.this.otherParams);
                    }
                }
            });
            aVar.gPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    j.this.c(fVar);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.guardclub.f fVar) {
        if (this.gPq != null) {
            this.gPq.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gOP, this.gOP.getResources().getString(a.h.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gOP);
            } else if (fVar.isFollowed) {
                com.baidu.live.data.f fVar2 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", false, this.aWW);
                fVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Yo().a(fVar.userId, fVar2);
            } else {
                com.baidu.live.data.f fVar3 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", true, this.aWW);
                fVar3.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Yo().a(fVar.userId, fVar3);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.gPp == null || !TextUtils.equals(str, this.gPp.userId)) {
            if (z) {
                aVar.gPz.setVisibility(8);
                aVar.gPA.setVisibility(0);
                return;
            }
            aVar.gPA.setVisibility(8);
            aVar.gPz.setVisibility(0);
            return;
        }
        aVar.gPz.setVisibility(8);
        aVar.gPA.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gPw.setImageResource(i);
        aVar.gPx.setVisibility(8);
        aVar.gPw.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cr(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gPr = new ArrayList(list);
        } else {
            this.gPr = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cs(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gPr == null) {
                this.gPr = new ArrayList();
            }
            this.gPr.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bWj() {
        MessageManager.getInstance().unRegisterListener(this.gDu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView bVT;
        private HeadImageView gOU;
        private TextView gOW;
        private TextView gPA;
        private RelativeLayout gPu;
        private View gPv;
        private ImageView gPw;
        private TextView gPx;
        private TbImageView gPy;
        private GradientTextView gPz;

        private a() {
        }
    }
}
