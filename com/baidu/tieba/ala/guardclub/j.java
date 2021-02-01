package com.baidu.tieba.ala.guardclub;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
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
/* loaded from: classes11.dex */
public class j extends BaseAdapter {
    private boolean aJC;
    private BdUniqueId aWU;
    private CustomMessageListener gNg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.j.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = j.this.gZi.iterator();
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
                            if (message.getTag().equals(j.this.aWU)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    j.this.gYG.getPageContext().showToast(j.this.gYG.getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                } else {
                                    j.this.gYG.getPageContext().showToast(j.this.gYG.getResources().getString(a.h.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(j.this.aWU)) {
                        if (!TextUtils.isEmpty(updateAttentionMessage.getData().usermsg)) {
                            string = updateAttentionMessage.getData().usermsg;
                        } else if (!TextUtils.isEmpty(updateAttentionMessage.getData().errmsg)) {
                            string = updateAttentionMessage.getData().errmsg;
                        } else if (TextUtils.isEmpty(updateAttentionMessage.getData().errorString)) {
                            string = j.this.gYG.getResources().getString(a.h.sdk_op_failed_toast);
                        } else {
                            string = updateAttentionMessage.getData().errorString;
                        }
                        j.this.gYG.showToast(string);
                    }
                }
            }
        }
    };
    private BaseActivity gYG;
    private boolean gZf;
    private com.baidu.live.guardclub.f gZg;
    private b gZh;
    private List<com.baidu.live.guardclub.f> gZi;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gYG = baseActivity;
        this.aWU = bdUniqueId;
        this.aJC = z;
        this.gZf = z2;
        MessageManager.getInstance().registerListener(this.gNg);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gZg = fVar;
    }

    public void a(b bVar) {
        this.gZh = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZi == null) {
            return 0;
        }
        return this.gZi.size();
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
            view = LayoutInflater.from(this.gYG.getPageContext().getPageActivity()).inflate(a.g.item_guard_member_list, viewGroup, false);
            a aVar2 = new a();
            aVar2.gZl = (RelativeLayout) view.findViewById(a.f.layout_guard_member_list_rank);
            aVar2.gZm = view.findViewById(a.f.view_guard_club_list_rank);
            aVar2.gZn = (ImageView) view.findViewById(a.f.img_guard_club_list_rank);
            aVar2.gZo = (TextView) view.findViewById(a.f.tv_guard_club_list_rank);
            aVar2.gYL = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar2.gZp = (TbImageView) view.findViewById(a.f.img_guard_club_list_medal);
            aVar2.cbw = (TextView) view.findViewById(a.f.tv_guard_club_list_name);
            aVar2.gYN = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar2.gZq = (GradientTextView) view.findViewById(a.f.tv_guard_club_list_followed);
            aVar2.gZr = (TextView) view.findViewById(a.f.tv_guard_club_list_un_followed);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gZi.get(i);
        if (fVar != null) {
            if (!this.gZf) {
                try {
                    if (i == 0) {
                        a(aVar, a.e.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.e.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.e.gcb_icon_contribution_third);
                    } else {
                        aVar.gZo.setText(String.valueOf(i + 1));
                        aVar.gZn.setVisibility(8);
                        aVar.gZo.setVisibility(0);
                    }
                    aVar.gZm.setVisibility(8);
                    aVar.gZl.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gZl.setVisibility(8);
                    aVar.gZm.setVisibility(0);
                }
            } else {
                aVar.gZl.setVisibility(8);
                aVar.gZm.setVisibility(0);
            }
            aVar.gYL.setIsRound(true);
            aVar.gYL.setAutoChangeStyle(false);
            aVar.gYL.startLoad(fVar.aVj, 12, false);
            Bitmap a2 = com.baidu.live.aj.b.a(this.gYG, fVar.guardName, fVar.guardLevel, 0, a.d.sdk_ds32, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                aVar.gZp.setImageBitmap(a2);
                aVar.gZp.setVisibility(0);
            } else {
                aVar.gZp.setVisibility(4);
            }
            aVar.gYL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    j.this.b(fVar);
                }
            });
            aVar.cbw.setText(fVar.userName);
            aVar.gYN.setText(String.format(this.gYG.getResources().getString(a.h.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gZr.setBackgroundResource(a.e.gcb_attention_bg_bd_s);
                aVar.gZq.setBackgroundResource(a.e.gcb_attention_bg_bd_selector);
                aVar.gZr.setTextColor(this.gYG.getResources().getColor(a.c.sdk_white_alpha20));
                aVar.gZq.setTextColor(this.gYG.getResources().getColor(a.c.sdk_white_alpha70));
            }
            a(aVar, fVar.isFollowed, fVar.userId);
            if (fVar.extInfoJson != null) {
                if (fVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    aVar.gZq.setVisibility(8);
                    aVar.gZr.setVisibility(4);
                }
            }
            aVar.gZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    j.this.c(fVar);
                    if (!j.this.aJC && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, j.this.gZf ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", j.this.gZf ? "guard_member" : "guard", j.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, j.this.gZf ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, j.this.otherParams);
                    }
                }
            });
            aVar.gZr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.3
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
        if (this.gZh != null) {
            this.gZh.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gYG, this.gYG.getResources().getString(a.h.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gYG);
            } else if (fVar.isFollowed) {
                com.baidu.live.data.f fVar2 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", false, this.aWU);
                fVar2.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Xo().a(fVar.userId, fVar2);
            } else {
                com.baidu.live.data.f fVar3 = new com.baidu.live.data.f(fVar.portrait, fVar.userId, "1", true, this.aWU);
                fVar3.setFrom("source_guardian_club_member_list");
                com.baidu.live.view.a.Xo().a(fVar.userId, fVar3);
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.gZg == null || !TextUtils.equals(str, this.gZg.userId)) {
            if (z) {
                aVar.gZq.setVisibility(8);
                aVar.gZr.setVisibility(0);
                return;
            }
            aVar.gZr.setVisibility(8);
            aVar.gZq.setVisibility(0);
            return;
        }
        aVar.gZq.setVisibility(8);
        aVar.gZr.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gZn.setImageResource(i);
        aVar.gZo.setVisibility(8);
        aVar.gZn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ct(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gZi = new ArrayList(list);
        } else {
            this.gZi = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cu(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gZi == null) {
                this.gZi = new ArrayList();
            }
            this.gZi.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVC() {
        MessageManager.getInstance().unRegisterListener(this.gNg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private TextView cbw;
        private HeadImageView gYL;
        private TextView gYN;
        private RelativeLayout gZl;
        private View gZm;
        private ImageView gZn;
        private TextView gZo;
        private TbImageView gZp;
        private GradientTextView gZq;
        private TextView gZr;

        private a() {
        }
    }
}
