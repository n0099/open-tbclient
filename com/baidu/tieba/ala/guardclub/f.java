package com.baidu.tieba.ala.guardclub;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private BaseActivity eFC;
    private BdUniqueId eFD;
    private b eFE;
    private ArrayList<a> eFF = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.d> eFG;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.eFC = baseActivity;
        this.eFD = bdUniqueId;
    }

    public void a(b bVar) {
        this.eFE = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eFG == null) {
            return 0;
        }
        return this.eFG.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.eFC.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.eFJ = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eFJ.setIsRound(true);
            aVar.eFJ.setBorderColor(this.eFC.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.eFJ.setAutoChangeStyle(false);
            aVar.avA = (TextView) view.findViewById(a.g.name_textView);
            aVar.eFK = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.eFL = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eFM = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.eFN = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.eFO = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.eFF.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.eFG.get(i);
        if (dVar != null) {
            aVar.eFJ.startLoad(dVar.aqd, 12, false);
            aVar.eFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.eFK.getWidth();
            if (width <= 0) {
                aVar.eFK.measure(0, 0);
                width = aVar.eFK.getMeasuredWidth();
            }
            String str2 = dVar.apW;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.avA.setPadding(0, 0, width, 0);
                aVar.eFK.setVisibility(0);
                str = substring;
            } else {
                aVar.avA.setPadding(0, 0, 0, 0);
                aVar.eFK.setVisibility(4);
                str = str2;
            }
            aVar.avA.setText(str);
            aVar.eFL.setText(String.format(this.eFC.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.eFJ.setScaleX(1.0f);
            aVar.eFJ.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String bT = com.baidu.live.guardclub.g.vM().bT(dVar.aqb);
            if (!TextUtils.isEmpty(bT)) {
                aVar.eFM.setVisibility(0);
                aVar.eFM.startLoad(bT, 10, false);
            } else {
                aVar.eFM.setVisibility(8);
            }
            aVar.eFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.eFE != null) {
                        f.this.eFE.a(dVar, i);
                    }
                }
            });
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.eFN.setVisibility(0);
        aVar.eFN.setAnimation("live_anim_guard_join.json");
        aVar.eFN.setVisibility(0);
        aVar.eFN.loop(true);
        aVar.eFN.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.eFJ, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.eFJ, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.eFP == null) {
            aVar.eFP = new AnimatorSet();
        } else {
            aVar.eFP.cancel();
        }
        aVar.eFP.play(ofFloat).with(ofFloat2);
        aVar.eFP.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.eFN.setVisibility(8);
        aVar.eFN.cancelAnimation();
        if (aVar.eFP != null) {
            aVar.eFP.cancel();
        }
        aVar.eFJ.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zs().awM.aaF) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.eFC);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.eFC.getPageContext().getPageActivity(), Long.valueOf(dVar.adM).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.eFG = new ArrayList(list);
        } else {
            this.eFG = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eFG == null) {
                this.eFG = new ArrayList();
            }
            this.eFG.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void pr(int i) {
        if (this.eFG != null && this.eFG.size() > 0 && i >= 0 && i < this.eFG.size()) {
            this.eFG.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bfp() {
        if (this.eFF != null && this.eFF.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eFF.size()) {
                    b(this.eFF.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private TextView avA;
        private HeadImageView eFJ;
        private TextView eFK;
        private TextView eFL;
        private TbImageView eFM;
        private LottieAnimationView eFN;
        private TextView eFO;
        private AnimatorSet eFP;

        private a() {
        }
    }
}
