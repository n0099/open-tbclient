package com.baidu.tieba.ala.guardclub;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class g extends BaseAdapter {
    private BdUniqueId aWU;
    private ArrayList<a> fUX = new ArrayList<>();
    private BaseActivity gYG;
    private b gYH;
    private List<com.baidu.tieba.ala.guardclub.model.d> gYI;

    /* loaded from: classes11.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gYG = baseActivity;
        this.aWU = bdUniqueId;
    }

    public void a(b bVar) {
        this.gYH = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gYI == null) {
            return 0;
        }
        return this.gYI.size();
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
            view = LayoutInflater.from(this.gYG.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gYL = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gYL.setIsRound(true);
            aVar.gYL.setBorderColor(this.gYG.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.gYL.setAutoChangeStyle(false);
            aVar.aDM = (TextView) view.findViewById(a.f.name_textView);
            aVar.gYM = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.gYN = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gYO = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.gYP = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.gYQ = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fUX.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gYI.get(i);
        if (dVar != null) {
            aVar.gYL.startLoad(dVar.biR, 12, false);
            aVar.gYL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.a(dVar);
                }
            });
            int width = aVar.gYM.getWidth();
            if (width <= 0) {
                aVar.gYM.measure(0, 0);
                width = aVar.gYM.getMeasuredWidth();
            }
            String str2 = dVar.biL;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aDM.setPadding(0, 0, width, 0);
                aVar.gYM.setVisibility(0);
                str = substring;
            } else {
                aVar.aDM.setPadding(0, 0, 0, 0);
                aVar.gYM.setVisibility(4);
                str = str2;
            }
            aVar.aDM.setText(str);
            aVar.gYN.setText(String.format(this.gYG.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.gYL.setScaleX(1.0f);
            aVar.gYL.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String ds = com.baidu.live.guardclub.g.IT().ds(dVar.guardLevel);
            if (!TextUtils.isEmpty(ds)) {
                aVar.gYO.setVisibility(0);
                aVar.gYO.startLoad(ds, 10, false);
            } else {
                aVar.gYO.setVisibility(8);
            }
            aVar.gYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.this.gYH != null) {
                        g.this.gYH.a(dVar, i);
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
        aVar.gYP.setVisibility(0);
        aVar.gYP.setAnimation("live_anim_guard_join.json");
        aVar.gYP.setVisibility(0);
        aVar.gYP.loop(true);
        aVar.gYP.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gYL, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gYL, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gYR == null) {
            aVar.gYR = new AnimatorSet();
        } else {
            aVar.gYR.cancel();
        }
        aVar.gYR.play(ofFloat).with(ofFloat2);
        aVar.gYR.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gYP.setVisibility(8);
        aVar.gYP.cancelAnimation();
        if (aVar.gYR != null) {
            aVar.gYR.cancel();
        }
        aVar.gYL.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qj().buX.aMw) {
                        com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(dVar.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gYG);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gYG.getPageContext().getPageActivity(), Long.valueOf(dVar.aJM).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void cr(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gYI = new ArrayList(list);
        } else {
            this.gYI = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gYI == null) {
                this.gYI = new ArrayList();
            }
            this.gYI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void uy(int i) {
        if (this.gYI != null && this.gYI.size() > 0 && i >= 0 && i < this.gYI.size()) {
            this.gYI.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bVC() {
        if (this.fUX != null && this.fUX.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fUX.size()) {
                    b(this.fUX.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private TextView aDM;
        private HeadImageView gYL;
        private TextView gYM;
        private TextView gYN;
        private TbImageView gYO;
        private LottieAnimationView gYP;
        private TextView gYQ;
        private AnimatorSet gYR;

        private a() {
        }
    }
}
