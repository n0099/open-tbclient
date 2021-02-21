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
    private CustomMessageListener gNu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.j.4
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
                            Iterator it = j.this.gZw.iterator();
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
                                    j.this.gYU.getPageContext().showToast(j.this.gYU.getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                } else {
                                    j.this.gYU.getPageContext().showToast(j.this.gYU.getResources().getString(a.h.sdk_unfollow_success_toast));
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
                            string = j.this.gYU.getResources().getString(a.h.sdk_op_failed_toast);
                        } else {
                            string = updateAttentionMessage.getData().errorString;
                        }
                        j.this.gYU.showToast(string);
                    }
                }
            }
        }
    };
    private BaseActivity gYU;
    private boolean gZt;
    private com.baidu.live.guardclub.f gZu;
    private b gZv;
    private List<com.baidu.live.guardclub.f> gZw;
    private String otherParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        void d(com.baidu.live.guardclub.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gYU = baseActivity;
        this.aWU = bdUniqueId;
        this.aJC = z;
        this.gZt = z2;
        MessageManager.getInstance().registerListener(this.gNu);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.gZu = fVar;
    }

    public void a(b bVar) {
        this.gZv = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZw == null) {
            return 0;
        }
        return this.gZw.size();
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
            view = LayoutInflater.from(this.gYU.getPageContext().getPageActivity()).inflate(a.g.item_guard_member_list, viewGroup, false);
            a aVar2 = new a();
            aVar2.gZz = (RelativeLayout) view.findViewById(a.f.layout_guard_member_list_rank);
            aVar2.gZA = view.findViewById(a.f.view_guard_club_list_rank);
            aVar2.gZB = (ImageView) view.findViewById(a.f.img_guard_club_list_rank);
            aVar2.gZC = (TextView) view.findViewById(a.f.tv_guard_club_list_rank);
            aVar2.gYZ = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar2.gZD = (TbImageView) view.findViewById(a.f.img_guard_club_list_medal);
            aVar2.cbw = (TextView) view.findViewById(a.f.tv_guard_club_list_name);
            aVar2.gZb = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar2.gZE = (GradientTextView) view.findViewById(a.f.tv_guard_club_list_followed);
            aVar2.gZF = (TextView) view.findViewById(a.f.tv_guard_club_list_un_followed);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.gZw.get(i);
        if (fVar != null) {
            if (!this.gZt) {
                try {
                    if (i == 0) {
                        a(aVar, a.e.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.e.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.e.gcb_icon_contribution_third);
                    } else {
                        aVar.gZC.setText(String.valueOf(i + 1));
                        aVar.gZB.setVisibility(8);
                        aVar.gZC.setVisibility(0);
                    }
                    aVar.gZA.setVisibility(8);
                    aVar.gZz.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.gZz.setVisibility(8);
                    aVar.gZA.setVisibility(0);
                }
            } else {
                aVar.gZz.setVisibility(8);
                aVar.gZA.setVisibility(0);
            }
            aVar.gYZ.setIsRound(true);
            aVar.gYZ.setAutoChangeStyle(false);
            aVar.gYZ.startLoad(fVar.aVj, 12, false);
            Bitmap a2 = com.baidu.live.aj.b.a(this.gYU, fVar.guardName, fVar.guardLevel, 0, a.d.sdk_ds32, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                aVar.gZD.setImageBitmap(a2);
                aVar.gZD.setVisibility(0);
            } else {
                aVar.gZD.setVisibility(4);
            }
            aVar.gYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    j.this.b(fVar);
                }
            });
            aVar.cbw.setText(fVar.userName);
            aVar.gZb.setText(String.format(this.gYU.getResources().getString(a.h.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.gZF.setBackgroundResource(a.e.gcb_attention_bg_bd_s);
                aVar.gZE.setBackgroundResource(a.e.gcb_attention_bg_bd_selector);
                aVar.gZF.setTextColor(this.gYU.getResources().getColor(a.c.sdk_white_alpha20));
                aVar.gZE.setTextColor(this.gYU.getResources().getColor(a.c.sdk_white_alpha70));
            }
            a(aVar, fVar.isFollowed, fVar.userId);
            if (fVar.extInfoJson != null) {
                if (fVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    aVar.gZE.setVisibility(8);
                    aVar.gZF.setVisibility(4);
                }
            }
            aVar.gZE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    j.this.c(fVar);
                    if (!j.this.aJC && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, j.this.gZt ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", j.this.gZt ? "guard_member" : "guard", j.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, j.this.gZt ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, j.this.otherParams);
                    }
                }
            });
            aVar.gZF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.3
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
        if (this.gZv != null) {
            this.gZv.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.gYU, this.gYU.getResources().getString(a.h.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gYU);
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
        if (this.gZu == null || !TextUtils.equals(str, this.gZu.userId)) {
            if (z) {
                aVar.gZE.setVisibility(8);
                aVar.gZF.setVisibility(0);
                return;
            }
            aVar.gZF.setVisibility(8);
            aVar.gZE.setVisibility(0);
            return;
        }
        aVar.gZE.setVisibility(8);
        aVar.gZF.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.gZB.setImageResource(i);
        aVar.gZC.setVisibility(8);
        aVar.gZB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ct(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.gZw = new ArrayList(list);
        } else {
            this.gZw = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cu(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gZw == null) {
                this.gZw = new ArrayList();
            }
            this.gZw.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVJ() {
        MessageManager.getInstance().unRegisterListener(this.gNu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private TextView cbw;
        private HeadImageView gYZ;
        private View gZA;
        private ImageView gZB;
        private TextView gZC;
        private TbImageView gZD;
        private GradientTextView gZE;
        private TextView gZF;
        private TextView gZb;
        private RelativeLayout gZz;

        private a() {
        }
    }
}
