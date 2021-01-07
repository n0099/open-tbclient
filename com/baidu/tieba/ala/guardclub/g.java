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
    private BdUniqueId aYC;
    private ArrayList<a> fXp = new ArrayList<>();
    private BaseActivity haC;
    private b haD;
    private List<com.baidu.tieba.ala.guardclub.model.d> haE;

    /* loaded from: classes11.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.haC = baseActivity;
        this.aYC = bdUniqueId;
    }

    public void a(b bVar) {
        this.haD = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.haE == null) {
            return 0;
        }
        return this.haE.size();
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
            view = LayoutInflater.from(this.haC.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.haH = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.haH.setIsRound(true);
            aVar.haH.setBorderColor(this.haC.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.haH.setAutoChangeStyle(false);
            aVar.aGM = (TextView) view.findViewById(a.f.name_textView);
            aVar.haI = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.haJ = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.haK = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.haL = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.haM = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fXp.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.haE.get(i);
        if (dVar != null) {
            aVar.haH.startLoad(dVar.bky, 12, false);
            aVar.haH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.a(dVar);
                }
            });
            int width = aVar.haI.getWidth();
            if (width <= 0) {
                aVar.haI.measure(0, 0);
                width = aVar.haI.getMeasuredWidth();
            }
            String str2 = dVar.bks;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aGM.setPadding(0, 0, width, 0);
                aVar.haI.setVisibility(0);
                str = substring;
            } else {
                aVar.aGM.setPadding(0, 0, 0, 0);
                aVar.haI.setVisibility(4);
                str = str2;
            }
            aVar.aGM.setText(str);
            aVar.haJ.setText(String.format(this.haC.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.haH.setScaleX(1.0f);
            aVar.haH.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String eT = com.baidu.live.guardclub.g.Ly().eT(dVar.guardLevel);
            if (!TextUtils.isEmpty(eT)) {
                aVar.haK.setVisibility(0);
                aVar.haK.startLoad(eT, 10, false);
            } else {
                aVar.haK.setVisibility(8);
            }
            aVar.haM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.this.haD != null) {
                        g.this.haD.a(dVar, i);
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
        aVar.haL.setVisibility(0);
        aVar.haL.setAnimation("live_anim_guard_join.json");
        aVar.haL.setVisibility(0);
        aVar.haL.loop(true);
        aVar.haL.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.haH, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.haH, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.haN == null) {
            aVar.haN = new AnimatorSet();
        } else {
            aVar.haN.cancel();
        }
        aVar.haN.play(ofFloat).with(ofFloat2);
        aVar.haN.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.haL.setVisibility(8);
        aVar.haL.cancelAnimation();
        if (aVar.haN != null) {
            aVar.haN.cancel();
        }
        aVar.haH.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.SE().bwi.aOz) {
                        com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(dVar.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.haC);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.haC.getPageContext().getPageActivity(), Long.valueOf(dVar.aLV).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void cw(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.haE = new ArrayList(list);
        } else {
            this.haE = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cx(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.haE == null) {
                this.haE = new ArrayList();
            }
            this.haE.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void vY(int i) {
        if (this.haE != null && this.haE.size() > 0 && i >= 0 && i < this.haE.size()) {
            this.haE.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bYP() {
        if (this.fXp != null && this.fXp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fXp.size()) {
                    b(this.fXp.get(i2));
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
        private TextView aGM;
        private HeadImageView haH;
        private TextView haI;
        private TextView haJ;
        private TbImageView haK;
        private LottieAnimationView haL;
        private TextView haM;
        private AnimatorSet haN;

        private a() {
        }
    }
}
