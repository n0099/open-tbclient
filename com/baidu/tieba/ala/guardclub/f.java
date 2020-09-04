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
    private ArrayList<a> fdd = new ArrayList<>();
    private BaseActivity gaC;
    private BdUniqueId gaD;
    private b gaE;
    private List<com.baidu.tieba.ala.guardclub.model.d> gaF;

    /* loaded from: classes7.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gaC = baseActivity;
        this.gaD = bdUniqueId;
    }

    public void a(b bVar) {
        this.gaE = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gaF == null) {
            return 0;
        }
        return this.gaF.size();
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
            view = LayoutInflater.from(this.gaC.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gaI = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gaI.setIsRound(true);
            aVar.gaI.setBorderColor(this.gaC.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.gaI.setAutoChangeStyle(false);
            aVar.aAR = (TextView) view.findViewById(a.g.name_textView);
            aVar.gaJ = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.gaK = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gaL = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.gaM = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.gaN = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fdd.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gaF.get(i);
        if (dVar != null) {
            aVar.gaI.startLoad(dVar.aXQ, 12, false);
            aVar.gaI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.gaJ.getWidth();
            if (width <= 0) {
                aVar.gaJ.measure(0, 0);
                width = aVar.gaJ.getMeasuredWidth();
            }
            String str2 = dVar.aXJ;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aAR.setPadding(0, 0, width, 0);
                aVar.gaJ.setVisibility(0);
                str = substring;
            } else {
                aVar.aAR.setPadding(0, 0, 0, 0);
                aVar.gaJ.setVisibility(4);
                str = str2;
            }
            aVar.aAR.setText(str);
            aVar.gaK.setText(String.format(this.gaC.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.gaI.setScaleX(1.0f);
            aVar.gaI.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String et = com.baidu.live.guardclub.g.Im().et(dVar.aXO);
            if (!TextUtils.isEmpty(et)) {
                aVar.gaL.setVisibility(0);
                aVar.gaL.startLoad(et, 10, false);
            } else {
                aVar.gaL.setVisibility(8);
            }
            aVar.gaN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.gaE != null) {
                        f.this.gaE.a(dVar, i);
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
        aVar.gaM.setVisibility(0);
        aVar.gaM.setAnimation("live_anim_guard_join.json");
        aVar.gaM.setVisibility(0);
        aVar.gaM.loop(true);
        aVar.gaM.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gaI, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gaI, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gaO == null) {
            aVar.gaO = new AnimatorSet();
        } else {
            aVar.gaO.cancel();
        }
        aVar.gaO.play(ofFloat).with(ofFloat2);
        aVar.gaO.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gaM.setVisibility(8);
        aVar.gaM.cancelAnimation();
        if (aVar.gaO != null) {
            aVar.gaO.cancel();
        }
        aVar.gaI.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beJ.aGO) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gaC);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gaC.getPageContext().getPageActivity(), Long.valueOf(dVar.aKj).longValue(), 0L, false, "", true);
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
            this.gaF = new ArrayList(list);
        } else {
            this.gaF = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bN(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gaF == null) {
                this.gaF = new ArrayList();
            }
            this.gaF.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void tp(int i) {
        if (this.gaF != null && this.gaF.size() > 0 && i >= 0 && i < this.gaF.size()) {
            this.gaF.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bKg() {
        if (this.fdd != null && this.fdd.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fdd.size()) {
                    b(this.fdd.get(i2));
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
        private TextView aAR;
        private HeadImageView gaI;
        private TextView gaJ;
        private TextView gaK;
        private TbImageView gaL;
        private LottieAnimationView gaM;
        private TextView gaN;
        private AnimatorSet gaO;

        private a() {
        }
    }
}
