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
    private BdUniqueId aTP;
    private ArrayList<a> fSI = new ArrayList<>();
    private BaseActivity gVW;
    private b gVX;
    private List<com.baidu.tieba.ala.guardclub.model.d> gVY;

    /* loaded from: classes10.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public g(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gVW = baseActivity;
        this.aTP = bdUniqueId;
    }

    public void a(b bVar) {
        this.gVX = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gVY == null) {
            return 0;
        }
        return this.gVY.size();
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
            view = LayoutInflater.from(this.gVW.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gWb = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gWb.setIsRound(true);
            aVar.gWb.setBorderColor(this.gVW.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.gWb.setAutoChangeStyle(false);
            aVar.aBZ = (TextView) view.findViewById(a.f.name_textView);
            aVar.gWc = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.gWd = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gWe = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.gWf = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.gWg = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fSI.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gVY.get(i);
        if (dVar != null) {
            aVar.gWb.startLoad(dVar.bfI, 12, false);
            aVar.gWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    g.this.a(dVar);
                }
            });
            int width = aVar.gWc.getWidth();
            if (width <= 0) {
                aVar.gWc.measure(0, 0);
                width = aVar.gWc.getMeasuredWidth();
            }
            String str2 = dVar.bfC;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aBZ.setPadding(0, 0, width, 0);
                aVar.gWc.setVisibility(0);
                str = substring;
            } else {
                aVar.aBZ.setPadding(0, 0, 0, 0);
                aVar.gWc.setVisibility(4);
                str = str2;
            }
            aVar.aBZ.setText(str);
            aVar.gWd.setText(String.format(this.gVW.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.gWb.setScaleX(1.0f);
            aVar.gWb.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String dn = com.baidu.live.guardclub.g.HD().dn(dVar.guardLevel);
            if (!TextUtils.isEmpty(dn)) {
                aVar.gWe.setVisibility(0);
                aVar.gWe.startLoad(dn, 10, false);
            } else {
                aVar.gWe.setVisibility(8);
            }
            aVar.gWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.this.gVX != null) {
                        g.this.gVX.a(dVar, i);
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
        aVar.gWf.setVisibility(0);
        aVar.gWf.setAnimation("live_anim_guard_join.json");
        aVar.gWf.setVisibility(0);
        aVar.gWf.loop(true);
        aVar.gWf.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gWb, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gWb, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gWh == null) {
            aVar.gWh = new AnimatorSet();
        } else {
            aVar.gWh.cancel();
        }
        aVar.gWh.play(ofFloat).with(ofFloat2);
        aVar.gWh.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gWf.setVisibility(8);
        aVar.gWf.cancelAnimation();
        if (aVar.gWh != null) {
            aVar.gWh.cancel();
        }
        aVar.gWb.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.OJ().bru.aJM) {
                        com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(dVar.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gVW);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gVW.getPageContext().getPageActivity(), Long.valueOf(dVar.aHi).longValue(), 0L, false, "", true);
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
            this.gVY = new ArrayList(list);
        } else {
            this.gVY = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cx(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gVY == null) {
                this.gVY = new ArrayList();
            }
            this.gVY.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void us(int i) {
        if (this.gVY != null && this.gVY.size() > 0 && i >= 0 && i < this.gVY.size()) {
            this.gVY.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bUX() {
        if (this.fSI != null && this.fSI.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fSI.size()) {
                    b(this.fSI.get(i2));
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
        private TextView aBZ;
        private HeadImageView gWb;
        private TextView gWc;
        private TextView gWd;
        private TbImageView gWe;
        private LottieAnimationView gWf;
        private TextView gWg;
        private AnimatorSet gWh;

        private a() {
        }
    }
}
