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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private BaseActivity eAE;
    private BdUniqueId eAF;
    private b eAG;
    private ArrayList<a> eAH = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.g> eAI;

    /* loaded from: classes2.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public d(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.eAE = baseActivity;
        this.eAF = bdUniqueId;
    }

    public void a(b bVar) {
        this.eAG = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAI == null) {
            return 0;
        }
        return this.eAI.size();
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
            view = LayoutInflater.from(this.eAE.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.eAL = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eAL.setIsRound(true);
            aVar.eAL.setBorderColor(this.eAE.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.eAL.setAutoChangeStyle(false);
            aVar.aro = (TextView) view.findViewById(a.g.name_textView);
            aVar.eAM = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.eAN = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eAO = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.eAP = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.eAQ = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.eAH.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.g gVar = this.eAI.get(i);
        if (gVar != null) {
            aVar.eAL.startLoad(gVar.eCG, 12, false);
            aVar.eAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.a(gVar);
                }
            });
            int width = aVar.eAM.getWidth();
            if (width <= 0) {
                aVar.eAM.measure(0, 0);
                width = aVar.eAM.getMeasuredWidth();
            }
            String str2 = gVar.eCz;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aro.setPadding(0, 0, width, 0);
                aVar.eAM.setVisibility(0);
                str = substring;
            } else {
                aVar.aro.setPadding(0, 0, 0, 0);
                aVar.eAM.setVisibility(4);
                str = str2;
            }
            aVar.aro.setText(str);
            aVar.eAN.setText(String.format(this.eAE.getResources().getString(a.i.guard_join_list_contribution), gVar.score));
            aVar.eAL.setScaleX(1.0f);
            aVar.eAL.setScaleY(1.0f);
            if (gVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String pe = l.bcZ().pe(gVar.eCE);
            if (!TextUtils.isEmpty(pe)) {
                aVar.eAO.setVisibility(0);
                aVar.eAO.startLoad(pe, 10, false);
            } else {
                aVar.eAO.setVisibility(8);
            }
            aVar.eAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eAG != null) {
                        d.this.eAG.a(gVar, i);
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
        aVar.eAP.setVisibility(0);
        aVar.eAP.setAnimation("live_anim_guard_join.json");
        aVar.eAP.setVisibility(0);
        aVar.eAP.loop(true);
        aVar.eAP.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.eAL, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.eAL, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.eAR == null) {
            aVar.eAR = new AnimatorSet();
        } else {
            aVar.eAR.cancel();
        }
        aVar.eAR.play(ofFloat).with(ofFloat2);
        aVar.eAR.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.eAP.setVisibility(8);
        aVar.eAP.cancelAnimation();
        if (aVar.eAR != null) {
            aVar.eAR.cancel();
        }
        aVar.eAL.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        if (gVar != null) {
            try {
                if (gVar.liveStatus == 1 && !TextUtils.isEmpty(gVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.s.a.wR().asq.YD) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.eAE);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(gVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.eAE.getPageContext().getPageActivity(), Long.valueOf(gVar.abx).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.g> list) {
        if (list != null && !list.isEmpty()) {
            this.eAI = new ArrayList(list);
        } else {
            this.eAI = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.g> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eAI == null) {
                this.eAI = new ArrayList();
            }
            this.eAI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void oY(int i) {
        if (this.eAI != null && this.eAI.size() > 0 && i >= 0 && i < this.eAI.size()) {
            this.eAI.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bcS() {
        if (this.eAH != null && this.eAH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eAH.size()) {
                    b(this.eAH.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private TextView aro;
        private HeadImageView eAL;
        private TextView eAM;
        private TextView eAN;
        private TbImageView eAO;
        private LottieAnimationView eAP;
        private TextView eAQ;
        private AnimatorSet eAR;

        private a() {
        }
    }
}
