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
    private BaseActivity fxI;
    private BdUniqueId fxJ;
    private b fxK;
    private ArrayList<a> fxL = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.d> fxM;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.fxI = baseActivity;
        this.fxJ = bdUniqueId;
    }

    public void a(b bVar) {
        this.fxK = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxM == null) {
            return 0;
        }
        return this.fxM.size();
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
            view = LayoutInflater.from(this.fxI.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.fxP = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fxP.setIsRound(true);
            aVar.fxP.setBorderColor(this.fxI.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.fxP.setAutoChangeStyle(false);
            aVar.aVs = (TextView) view.findViewById(a.g.name_textView);
            aVar.fxQ = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.fxR = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fxS = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.fxT = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.fxU = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fxL.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.fxM.get(i);
        if (dVar != null) {
            aVar.fxP.startLoad(dVar.aOB, 12, false);
            aVar.fxP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.fxQ.getWidth();
            if (width <= 0) {
                aVar.fxQ.measure(0, 0);
                width = aVar.fxQ.getMeasuredWidth();
            }
            String str2 = dVar.aOu;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aVs.setPadding(0, 0, width, 0);
                aVar.fxQ.setVisibility(0);
                str = substring;
            } else {
                aVar.aVs.setPadding(0, 0, 0, 0);
                aVar.fxQ.setVisibility(4);
                str = str2;
            }
            aVar.aVs.setText(str);
            aVar.fxR.setText(String.format(this.fxI.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.fxP.setScaleX(1.0f);
            aVar.fxP.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String cp = com.baidu.live.guardclub.g.BH().cp(dVar.aOz);
            if (!TextUtils.isEmpty(cp)) {
                aVar.fxS.setVisibility(0);
                aVar.fxS.startLoad(cp, 10, false);
            } else {
                aVar.fxS.setVisibility(8);
            }
            aVar.fxU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.fxK != null) {
                        f.this.fxK.a(dVar, i);
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
        aVar.fxT.setVisibility(0);
        aVar.fxT.setAnimation("live_anim_guard_join.json");
        aVar.fxT.setVisibility(0);
        aVar.fxT.loop(true);
        aVar.fxT.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.fxP, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.fxP, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.fxV == null) {
            aVar.fxV = new AnimatorSet();
        } else {
            aVar.fxV.cancel();
        }
        aVar.fxV.play(ofFloat).with(ofFloat2);
        aVar.fxV.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.fxT.setVisibility(8);
        aVar.fxT.cancelAnimation();
        if (aVar.fxV != null) {
            aVar.fxV.cancel();
        }
        aVar.fxP.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Ge().aWF.aya) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.fxI);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.fxI.getPageContext().getPageActivity(), Long.valueOf(dVar.aBs).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void by(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.fxM = new ArrayList(list);
        } else {
            this.fxM = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bz(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fxM == null) {
                this.fxM = new ArrayList();
            }
            this.fxM.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void qm(int i) {
        if (this.fxM != null && this.fxM.size() > 0 && i >= 0 && i < this.fxM.size()) {
            this.fxM.remove(i);
            notifyDataSetChanged();
        }
    }

    public void buw() {
        if (this.fxL != null && this.fxL.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fxL.size()) {
                    b(this.fxL.get(i2));
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
        private TextView aVs;
        private HeadImageView fxP;
        private TextView fxQ;
        private TextView fxR;
        private TbImageView fxS;
        private LottieAnimationView fxT;
        private TextView fxU;
        private AnimatorSet fxV;

        private a() {
        }
    }
}
