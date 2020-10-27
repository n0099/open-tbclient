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
    private ArrayList<a> fAH = new ArrayList<>();
    private BaseActivity gAk;
    private BdUniqueId gAl;
    private b gAm;
    private List<com.baidu.tieba.ala.guardclub.model.d> gAn;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gAk = baseActivity;
        this.gAl = bdUniqueId;
    }

    public void a(b bVar) {
        this.gAm = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gAn == null) {
            return 0;
        }
        return this.gAn.size();
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
            view = LayoutInflater.from(this.gAk.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gAq = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gAq.setIsRound(true);
            aVar.gAq.setBorderColor(this.gAk.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.gAq.setAutoChangeStyle(false);
            aVar.aEK = (TextView) view.findViewById(a.g.name_textView);
            aVar.gAr = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.gAs = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gAt = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.gAu = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.gAv = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fAH.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gAn.get(i);
        if (dVar != null) {
            aVar.gAq.startLoad(dVar.beY, 12, false);
            aVar.gAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.gAr.getWidth();
            if (width <= 0) {
                aVar.gAr.measure(0, 0);
                width = aVar.gAr.getMeasuredWidth();
            }
            String str2 = dVar.beR;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aEK.setPadding(0, 0, width, 0);
                aVar.gAr.setVisibility(0);
                str = substring;
            } else {
                aVar.aEK.setPadding(0, 0, 0, 0);
                aVar.gAr.setVisibility(4);
                str = str2;
            }
            aVar.aEK.setText(str);
            aVar.gAs.setText(String.format(this.gAk.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.gAq.setScaleX(1.0f);
            aVar.gAq.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String eD = com.baidu.live.guardclub.g.Kf().eD(dVar.beW);
            if (!TextUtils.isEmpty(eD)) {
                aVar.gAt.setVisibility(0);
                aVar.gAt.startLoad(eD, 10, false);
            } else {
                aVar.gAt.setVisibility(8);
            }
            aVar.gAv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.gAm != null) {
                        f.this.gAm.a(dVar, i);
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
        aVar.gAu.setVisibility(0);
        aVar.gAu.setAnimation("live_anim_guard_join.json");
        aVar.gAu.setVisibility(0);
        aVar.gAu.loop(true);
        aVar.gAu.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gAq, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gAq, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gAw == null) {
            aVar.gAw = new AnimatorSet();
        } else {
            aVar.gAw.cancel();
        }
        aVar.gAw.play(ofFloat).with(ofFloat2);
        aVar.gAw.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gAu.setVisibility(8);
        aVar.gAu.cancelAnimation();
        if (aVar.gAw != null) {
            aVar.gAw.cancel();
        }
        aVar.gAq.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.z.a.Pq().bmJ.aLL) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gAk);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gAk.getPageContext().getPageActivity(), Long.valueOf(dVar.aPA).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void ce(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gAn = new ArrayList(list);
        } else {
            this.gAn = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cf(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gAn == null) {
                this.gAn = new ArrayList();
            }
            this.gAn.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void uy(int i) {
        if (this.gAn != null && this.gAn.size() > 0 && i >= 0 && i < this.gAn.size()) {
            this.gAn.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bQF() {
        if (this.fAH != null && this.fAH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fAH.size()) {
                    b(this.fAH.get(i2));
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
        private TextView aEK;
        private HeadImageView gAq;
        private TextView gAr;
        private TextView gAs;
        private TbImageView gAt;
        private LottieAnimationView gAu;
        private TextView gAv;
        private AnimatorSet gAw;

        private a() {
        }
    }
}
