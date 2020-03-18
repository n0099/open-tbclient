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
    private boolean YB;
    private BaseActivity eFC;
    private BdUniqueId eFD;
    private boolean eGe;
    private com.baidu.live.guardclub.f eGf;
    private b eGg;
    private List<com.baidu.live.guardclub.f> eGh;
    private CustomMessageListener ewi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.guardclub.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid)) {
                            Iterator it = i.this.eGh.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.guardclub.f fVar = (com.baidu.live.guardclub.f) it.next();
                                if (updateAttentionMessage.getData().toUid.equals(fVar.userId)) {
                                    fVar.aqx = updateAttentionMessage.getData().isAttention;
                                    break;
                                }
                            }
                            i.this.notifyDataSetChanged();
                            if (message.getTag().equals(i.this.eFD)) {
                                if (updateAttentionMessage.getData().isAttention) {
                                    i.this.eFC.getPageContext().showToast(i.this.eFC.getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                } else {
                                    i.this.eFC.getPageContext().showToast(i.this.eFC.getResources().getString(a.i.sdk_unfollow_success_toast));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(i.this.eFD)) {
                        i.this.eFC.showToast(updateAttentionMessage.getData().errorString);
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
        this.eFC = baseActivity;
        this.eFD = bdUniqueId;
        this.YB = z;
        this.eGe = z2;
        MessageManager.getInstance().registerListener(this.ewi);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(com.baidu.live.guardclub.f fVar) {
        this.eGf = fVar;
    }

    public void a(b bVar) {
        this.eGg = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGh == null) {
            return 0;
        }
        return this.eGh.size();
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
            view = LayoutInflater.from(this.eFC.getPageContext().getPageActivity()).inflate(a.h.item_guard_member_list, viewGroup, false);
            aVar = new a();
            aVar.eGk = (RelativeLayout) view.findViewById(a.g.layout_guard_member_list_rank);
            aVar.eGl = view.findViewById(a.g.view_guard_club_list_rank);
            aVar.eGm = (ImageView) view.findViewById(a.g.img_guard_club_list_rank);
            aVar.eGn = (TextView) view.findViewById(a.g.tv_guard_club_list_rank);
            aVar.eFJ = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eGo = (TbImageView) view.findViewById(a.g.img_guard_club_list_medal);
            aVar.eGp = (TextView) view.findViewById(a.g.tv_guard_club_list_name);
            aVar.eFL = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eGq = (GradientTextView) view.findViewById(a.g.tv_guard_club_list_followed);
            aVar.eGr = (TextView) view.findViewById(a.g.tv_guard_club_list_un_followed);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.guardclub.f fVar = this.eGh.get(i);
        if (fVar != null) {
            if (!this.eGe) {
                try {
                    if (i == 0) {
                        a(aVar, a.f.gcb_icon_contribution_first);
                    } else if (i == 1) {
                        a(aVar, a.f.gcb_icon_contribution_second);
                    } else if (i == 2) {
                        a(aVar, a.f.gcb_icon_contribution_third);
                    } else {
                        aVar.eGn.setText(String.valueOf(i + 1));
                        aVar.eGm.setVisibility(8);
                        aVar.eGn.setVisibility(0);
                    }
                    aVar.eGl.setVisibility(8);
                    aVar.eGk.setVisibility(0);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    aVar.eGk.setVisibility(8);
                    aVar.eGl.setVisibility(0);
                }
            } else {
                aVar.eGk.setVisibility(8);
                aVar.eGl.setVisibility(0);
            }
            aVar.eFJ.setIsRound(true);
            aVar.eFJ.setAutoChangeStyle(false);
            aVar.eFJ.startLoad(fVar.aqz, 12, false);
            String bR = com.baidu.live.guardclub.g.vM().bR(fVar.aqb);
            if (!TextUtils.isEmpty(bR)) {
                aVar.eGo.startLoad(bR, 10, false);
                aVar.eGo.setVisibility(0);
            } else {
                aVar.eGo.setVisibility(4);
            }
            aVar.eFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.b(fVar);
                }
            });
            aVar.eGp.setText(fVar.userName);
            aVar.eFL.setText(String.format(this.eFC.getResources().getString(a.i.guard_member_list_contribution), fVar.score));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                aVar.eGr.setBackgroundResource(a.f.gcb_attention_bg_bd_s);
                aVar.eGq.setBackgroundResource(a.f.gcb_attention_bg_bd_selector);
                aVar.eGr.setTextColor(this.eFC.getResources().getColor(a.d.sdk_white_alpha20));
                aVar.eGq.setTextColor(this.eFC.getResources().getColor(a.d.sdk_white_alpha70));
            }
            a(aVar, fVar.aqx, fVar.userId);
            aVar.eGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.c(fVar);
                    if (!i.this.YB && TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, i.this.eGe ? LogConfig.VALUE_LIVE_GUARD_MEMBER : "liveroom", i.this.eGe ? "guard_member" : "guard", i.this.otherParams);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getGuardClubLogger().doClickFollowLog(null, null, null, null, i.this.eGe ? "guardian_members_tooltip" : LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP, i.this.otherParams);
                    }
                }
            });
            aVar.eGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
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
        if (this.eGg != null) {
            this.eGg.d(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.guardclub.f fVar) {
        if (fVar != null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.eFC, this.eFC.getResources().getString(a.i.sdk_neterror));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.eFC);
            } else if (fVar.aqx) {
                com.baidu.live.view.a.Bq().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", false, this.eFD));
            } else {
                com.baidu.live.view.a.Bq().a(fVar.userId, new com.baidu.live.data.b(fVar.portrait, fVar.userId, "1", true, this.eFD));
            }
        }
    }

    private void a(a aVar, boolean z, String str) {
        if (this.eGf == null || !TextUtils.equals(str, this.eGf.userId)) {
            if (z) {
                aVar.eGq.setVisibility(8);
                aVar.eGr.setVisibility(0);
                return;
            }
            aVar.eGr.setVisibility(8);
            aVar.eGq.setVisibility(0);
            return;
        }
        aVar.eGq.setVisibility(8);
        aVar.eGr.setVisibility(4);
    }

    private void a(a aVar, int i) {
        aVar.eGm.setImageResource(i);
        aVar.eGn.setVisibility(8);
        aVar.eGm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            this.eGh = new ArrayList(list);
        } else {
            this.eGh = new ArrayList();
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eGh == null) {
                this.eGh = new ArrayList();
            }
            this.eGh.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfp() {
        MessageManager.getInstance().unRegisterListener(this.ewi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private HeadImageView eFJ;
        private TextView eFL;
        private RelativeLayout eGk;
        private View eGl;
        private ImageView eGm;
        private TextView eGn;
        private TbImageView eGo;
        private TextView eGp;
        private GradientTextView eGq;
        private TextView eGr;

        private a() {
        }
    }
}
