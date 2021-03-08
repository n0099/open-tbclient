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
/* loaded from: classes10.dex */
public class g extends BaseAdapter {
    private BdUniqueId aYu;
    private ArrayList<a> fWx = new ArrayList<>();
    private BaseActivity haD;
    private b haE;
    private List<com.baidu.tieba.ala.guardclub.model.d> haF;

    /* loaded from: classes10.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.haD = baseActivity;
        this.aYu = bdUniqueId;
    }

    public void a(b bVar) {
        this.haE = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.haF == null) {
            return 0;
        }
        return this.haF.size();
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
            view = LayoutInflater.from(this.haD.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.haI = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.haI.setIsRound(true);
            aVar.haI.setBorderColor(this.haD.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.haI.setAutoChangeStyle(false);
            aVar.aFm = (TextView) view.findViewById(a.f.name_textView);
            aVar.haJ = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.haK = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.haL = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.haM = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.haN = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fWx.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.haF.get(i);
        if (dVar != null) {
            aVar.haI.startLoad(dVar.bkr, 12, false);
            aVar.haI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.a(dVar);
                }
            });
            int width = aVar.haJ.getWidth();
            if (width <= 0) {
                aVar.haJ.measure(0, 0);
                width = aVar.haJ.getMeasuredWidth();
            }
            String str2 = dVar.bkl;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aFm.setPadding(0, 0, width, 0);
                aVar.haJ.setVisibility(0);
                str = substring;
            } else {
                aVar.aFm.setPadding(0, 0, 0, 0);
                aVar.haJ.setVisibility(4);
                str = str2;
            }
            aVar.aFm.setText(str);
            aVar.haK.setText(String.format(this.haD.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.haI.setScaleX(1.0f);
            aVar.haI.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String dt = com.baidu.live.guardclub.g.IW().dt(dVar.guardLevel);
            if (!TextUtils.isEmpty(dt)) {
                aVar.haL.setVisibility(0);
                aVar.haL.startLoad(dt, 10, false);
            } else {
                aVar.haL.setVisibility(8);
            }
            aVar.haN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.this.haE != null) {
                        g.this.haE.a(dVar, i);
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
        aVar.haM.setVisibility(0);
        aVar.haM.setAnimation("live_anim_guard_join.json");
        aVar.haM.setVisibility(0);
        aVar.haM.loop(true);
        aVar.haM.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.haI, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.haI, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.haO == null) {
            aVar.haO = new AnimatorSet();
        } else {
            aVar.haO.cancel();
        }
        aVar.haO.play(ofFloat).with(ofFloat2);
        aVar.haO.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.haM.setVisibility(8);
        aVar.haM.cancelAnimation();
        if (aVar.haO != null) {
            aVar.haO.cancel();
        }
        aVar.haI.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qm().bwx.aNW) {
                        com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(dVar.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.haD);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.haD.getPageContext().getPageActivity(), Long.valueOf(dVar.aLm).longValue(), 0L, false, "", true);
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
            this.haF = new ArrayList(list);
        } else {
            this.haF = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.haF == null) {
                this.haF = new ArrayList();
            }
            this.haF.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void uA(int i) {
        if (this.haF != null && this.haF.size() > 0 && i >= 0 && i < this.haF.size()) {
            this.haF.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bVP() {
        if (this.fWx != null && this.fWx.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fWx.size()) {
                    b(this.fWx.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private TextView aFm;
        private HeadImageView haI;
        private TextView haJ;
        private TextView haK;
        private TbImageView haL;
        private LottieAnimationView haM;
        private TextView haN;
        private AnimatorSet haO;

        private a() {
        }
    }
}
