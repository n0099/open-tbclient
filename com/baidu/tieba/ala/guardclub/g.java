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
    private BaseActivity gON;
    private b gOO;
    private List<com.baidu.tieba.ala.guardclub.model.d> gOP;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gON = baseActivity;
        this.aWW = bdUniqueId;
    }

    public void a(b bVar) {
        this.gOO = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gOP == null) {
            return 0;
        }
        return this.gOP.size();
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
            view = LayoutInflater.from(this.gON.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gOS = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gOS.setIsRound(true);
            aVar.gOS.setBorderColor(this.gON.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.gOS.setAutoChangeStyle(false);
            aVar.aGv = (TextView) view.findViewById(a.f.name_textView);
            aVar.gOT = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.gOU = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gOV = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.gOW = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.gOX = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fNL.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gOP.get(i);
        if (dVar != null) {
            aVar.gOS.startLoad(dVar.biT, 12, false);
            aVar.gOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.a(dVar);
                }
            });
            int width = aVar.gOT.getWidth();
            if (width <= 0) {
                aVar.gOT.measure(0, 0);
                width = aVar.gOT.getMeasuredWidth();
            }
            String str2 = dVar.biN;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aGv.setPadding(0, 0, width, 0);
                aVar.gOT.setVisibility(0);
                str = substring;
            } else {
                aVar.aGv.setPadding(0, 0, 0, 0);
                aVar.gOT.setVisibility(4);
                str = str2;
            }
            aVar.aGv.setText(str);
            aVar.gOU.setText(String.format(this.gON.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.gOS.setScaleX(1.0f);
            aVar.gOS.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String eV = com.baidu.live.guardclub.g.LZ().eV(dVar.guardLevel);
            if (!TextUtils.isEmpty(eV)) {
                aVar.gOV.setVisibility(0);
                aVar.gOV.startLoad(eV, 10, false);
            } else {
                aVar.gOV.setVisibility(8);
            }
            aVar.gOX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.this.gOO != null) {
                        g.this.gOO.a(dVar, i);
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
        aVar.gOW.setVisibility(0);
        aVar.gOW.setAnimation("live_anim_guard_join.json");
        aVar.gOW.setVisibility(0);
        aVar.gOW.loop(true);
        aVar.gOW.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gOS, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gOS, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gOY == null) {
            aVar.gOY = new AnimatorSet();
        } else {
            aVar.gOY.cancel();
        }
        aVar.gOY.play(ofFloat).with(ofFloat2);
        aVar.gOY.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gOW.setVisibility(8);
        aVar.gOW.cancelAnimation();
        if (aVar.gOY != null) {
            aVar.gOY.cancel();
        }
        aVar.gOS.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.RB().brA.aNV) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gON);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gON.getPageContext().getPageActivity(), Long.valueOf(dVar.aRO).longValue(), 0L, false, "", true);
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
            this.gOP = new ArrayList(list);
        } else {
            this.gOP = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cq(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gOP == null) {
                this.gOP = new ArrayList();
            }
            this.gOP.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void vN(int i) {
        if (this.gOP != null && this.gOP.size() > 0 && i >= 0 && i < this.gOP.size()) {
            this.gOP.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bWi() {
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
        private HeadImageView gOS;
        private TextView gOT;
        private TextView gOU;
        private TbImageView gOV;
        private LottieAnimationView gOW;
        private TextView gOX;
        private AnimatorSet gOY;

        private a() {
        }
    }
}
