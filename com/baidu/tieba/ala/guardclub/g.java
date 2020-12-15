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
public class g extends BaseAdapter {
    private BdUniqueId aWW;
    private ArrayList<a> fNL = new ArrayList<>();
    private BaseActivity gOP;
    private b gOQ;
    private List<com.baidu.tieba.ala.guardclub.model.d> gOR;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gOP = baseActivity;
        this.aWW = bdUniqueId;
    }

    public void a(b bVar) {
        this.gOQ = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gOR == null) {
            return 0;
        }
        return this.gOR.size();
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
            view = LayoutInflater.from(this.gOP.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gOU = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gOU.setIsRound(true);
            aVar.gOU.setBorderColor(this.gOP.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.gOU.setAutoChangeStyle(false);
            aVar.aGv = (TextView) view.findViewById(a.f.name_textView);
            aVar.gOV = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.gOW = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gOX = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.gOY = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.gOZ = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fNL.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gOR.get(i);
        if (dVar != null) {
            aVar.gOU.startLoad(dVar.biT, 12, false);
            aVar.gOU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.a(dVar);
                }
            });
            int width = aVar.gOV.getWidth();
            if (width <= 0) {
                aVar.gOV.measure(0, 0);
                width = aVar.gOV.getMeasuredWidth();
            }
            String str2 = dVar.biN;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aGv.setPadding(0, 0, width, 0);
                aVar.gOV.setVisibility(0);
                str = substring;
            } else {
                aVar.aGv.setPadding(0, 0, 0, 0);
                aVar.gOV.setVisibility(4);
                str = str2;
            }
            aVar.aGv.setText(str);
            aVar.gOW.setText(String.format(this.gOP.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.gOU.setScaleX(1.0f);
            aVar.gOU.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String eV = com.baidu.live.guardclub.g.LZ().eV(dVar.guardLevel);
            if (!TextUtils.isEmpty(eV)) {
                aVar.gOX.setVisibility(0);
                aVar.gOX.startLoad(eV, 10, false);
            } else {
                aVar.gOX.setVisibility(8);
            }
            aVar.gOZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.this.gOQ != null) {
                        g.this.gOQ.a(dVar, i);
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
        aVar.gOY.setVisibility(0);
        aVar.gOY.setAnimation("live_anim_guard_join.json");
        aVar.gOY.setVisibility(0);
        aVar.gOY.loop(true);
        aVar.gOY.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gOU, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gOU, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gPa == null) {
            aVar.gPa = new AnimatorSet();
        } else {
            aVar.gPa.cancel();
        }
        aVar.gPa.play(ofFloat).with(ofFloat2);
        aVar.gPa.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gOY.setVisibility(8);
        aVar.gOY.cancelAnimation();
        if (aVar.gPa != null) {
            aVar.gPa.cancel();
        }
        aVar.gOU.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.RB().brA.aNV) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gOP);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gOP.getPageContext().getPageActivity(), Long.valueOf(dVar.aRO).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void cp(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gOR = new ArrayList(list);
        } else {
            this.gOR = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cq(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gOR == null) {
                this.gOR = new ArrayList();
            }
            this.gOR.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void vN(int i) {
        if (this.gOR != null && this.gOR.size() > 0 && i >= 0 && i < this.gOR.size()) {
            this.gOR.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bWj() {
        if (this.fNL != null && this.fNL.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fNL.size()) {
                    b(this.fNL.get(i2));
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
        private TextView aGv;
        private HeadImageView gOU;
        private TextView gOV;
        private TextView gOW;
        private TbImageView gOX;
        private LottieAnimationView gOY;
        private TextView gOZ;
        private AnimatorSet gPa;

        private a() {
        }
    }
}
