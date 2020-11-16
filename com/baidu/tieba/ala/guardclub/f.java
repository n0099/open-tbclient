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
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends BaseAdapter {
    private ArrayList<a> fFZ = new ArrayList<>();
    private BaseActivity gFF;
    private BdUniqueId gFG;
    private b gFH;
    private List<com.baidu.tieba.ala.guardclub.model.d> gFI;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gFF = baseActivity;
        this.gFG = bdUniqueId;
    }

    public void a(b bVar) {
        this.gFH = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gFI == null) {
            return 0;
        }
        return this.gFI.size();
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
            view = LayoutInflater.from(this.gFF.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gFL = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gFL.setIsRound(true);
            aVar.gFL.setBorderColor(this.gFF.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.gFL.setAutoChangeStyle(false);
            aVar.aDP = (TextView) view.findViewById(a.f.name_textView);
            aVar.gFM = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.gFN = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gFO = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.gFP = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.gFQ = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fFZ.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gFI.get(i);
        if (dVar != null) {
            aVar.gFL.startLoad(dVar.beG, 12, false);
            aVar.gFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.gFM.getWidth();
            if (width <= 0) {
                aVar.gFM.measure(0, 0);
                width = aVar.gFM.getMeasuredWidth();
            }
            String str2 = dVar.bez;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aDP.setPadding(0, 0, width, 0);
                aVar.gFM.setVisibility(0);
                str = substring;
            } else {
                aVar.aDP.setPadding(0, 0, 0, 0);
                aVar.gFM.setVisibility(4);
                str = str2;
            }
            aVar.aDP.setText(str);
            aVar.gFN.setText(String.format(this.gFF.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.gFL.setScaleX(1.0f);
            aVar.gFL.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String ez = com.baidu.live.guardclub.g.JW().ez(dVar.beE);
            if (!TextUtils.isEmpty(ez)) {
                aVar.gFO.setVisibility(0);
                aVar.gFO.startLoad(ez, 10, false);
            } else {
                aVar.gFO.setVisibility(8);
            }
            aVar.gFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.gFH != null) {
                        f.this.gFH.a(dVar, i);
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
        aVar.gFP.setVisibility(0);
        aVar.gFP.setAnimation("live_anim_guard_join.json");
        aVar.gFP.setVisibility(0);
        aVar.gFP.loop(true);
        aVar.gFP.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gFL, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gFL, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gFR == null) {
            aVar.gFR = new AnimatorSet();
        } else {
            aVar.gFR.cancel();
        }
        aVar.gFR.play(ofFloat).with(ofFloat2);
        aVar.gFR.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gFP.setVisibility(8);
        aVar.gFP.cancelAnimation();
        if (aVar.gFR != null) {
            aVar.gFR.cancel();
        }
        aVar.gFL.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.Ph().bms.aLa) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gFF);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gFF.getPageContext().getPageActivity(), Long.valueOf(dVar.aOM).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void cl(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gFI = new ArrayList(list);
        } else {
            this.gFI = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cm(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gFI == null) {
                this.gFI = new ArrayList();
            }
            this.gFI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void vg(int i) {
        if (this.gFI != null && this.gFI.size() > 0 && i >= 0 && i < this.gFI.size()) {
            this.gFI.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bSy() {
        if (this.fFZ != null && this.fFZ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fFZ.size()) {
                    b(this.fFZ.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView aDP;
        private HeadImageView gFL;
        private TextView gFM;
        private TextView gFN;
        private TbImageView gFO;
        private LottieAnimationView gFP;
        private TextView gFQ;
        private AnimatorSet gFR;

        private a() {
        }
    }
}
