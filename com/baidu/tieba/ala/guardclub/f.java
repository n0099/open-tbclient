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
/* loaded from: classes7.dex */
public class f extends BaseAdapter {
    private ArrayList<a> fcZ = new ArrayList<>();
    private b gaA;
    private List<com.baidu.tieba.ala.guardclub.model.d> gaB;
    private BaseActivity gay;
    private BdUniqueId gaz;

    /* loaded from: classes7.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gay = baseActivity;
        this.gaz = bdUniqueId;
    }

    public void a(b bVar) {
        this.gaA = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gaB == null) {
            return 0;
        }
        return this.gaB.size();
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
            view = LayoutInflater.from(this.gay.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gaE = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gaE.setIsRound(true);
            aVar.gaE.setBorderColor(this.gay.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.gaE.setAutoChangeStyle(false);
            aVar.aAP = (TextView) view.findViewById(a.g.name_textView);
            aVar.gaF = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.gaG = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gaH = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.gaI = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.gaJ = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fcZ.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gaB.get(i);
        if (dVar != null) {
            aVar.gaE.startLoad(dVar.aXO, 12, false);
            aVar.gaE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.gaF.getWidth();
            if (width <= 0) {
                aVar.gaF.measure(0, 0);
                width = aVar.gaF.getMeasuredWidth();
            }
            String str2 = dVar.aXH;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aAP.setPadding(0, 0, width, 0);
                aVar.gaF.setVisibility(0);
                str = substring;
            } else {
                aVar.aAP.setPadding(0, 0, 0, 0);
                aVar.gaF.setVisibility(4);
                str = str2;
            }
            aVar.aAP.setText(str);
            aVar.gaG.setText(String.format(this.gay.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.gaE.setScaleX(1.0f);
            aVar.gaE.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String et = com.baidu.live.guardclub.g.Im().et(dVar.aXM);
            if (!TextUtils.isEmpty(et)) {
                aVar.gaH.setVisibility(0);
                aVar.gaH.startLoad(et, 10, false);
            } else {
                aVar.gaH.setVisibility(8);
            }
            aVar.gaJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.gaA != null) {
                        f.this.gaA.a(dVar, i);
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
        aVar.gaI.setVisibility(0);
        aVar.gaI.setAnimation("live_anim_guard_join.json");
        aVar.gaI.setVisibility(0);
        aVar.gaI.loop(true);
        aVar.gaI.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gaE, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gaE, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gaK == null) {
            aVar.gaK = new AnimatorSet();
        } else {
            aVar.gaK.cancel();
        }
        aVar.gaK.play(ofFloat).with(ofFloat2);
        aVar.gaK.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gaI.setVisibility(8);
        aVar.gaI.cancelAnimation();
        if (aVar.gaK != null) {
            aVar.gaK.cancel();
        }
        aVar.gaE.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beH.aGM) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gay);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gay.getPageContext().getPageActivity(), Long.valueOf(dVar.aKh).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bM(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gaB = new ArrayList(list);
        } else {
            this.gaB = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bN(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gaB == null) {
                this.gaB = new ArrayList();
            }
            this.gaB.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void tp(int i) {
        if (this.gaB != null && this.gaB.size() > 0 && i >= 0 && i < this.gaB.size()) {
            this.gaB.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bKf() {
        if (this.fcZ != null && this.fcZ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fcZ.size()) {
                    b(this.fcZ.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private TextView aAP;
        private HeadImageView gaE;
        private TextView gaF;
        private TextView gaG;
        private TbImageView gaH;
        private LottieAnimationView gaI;
        private TextView gaJ;
        private AnimatorSet gaK;

        private a() {
        }
    }
}
