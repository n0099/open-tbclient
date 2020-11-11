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
    private ArrayList<a> fGx = new ArrayList<>();
    private BaseActivity gFY;
    private BdUniqueId gFZ;
    private b gGa;
    private List<com.baidu.tieba.ala.guardclub.model.d> gGb;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gFY = baseActivity;
        this.gFZ = bdUniqueId;
    }

    public void a(b bVar) {
        this.gGa = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gGb == null) {
            return 0;
        }
        return this.gGb.size();
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
            view = LayoutInflater.from(this.gFY.getPageContext().getPageActivity()).inflate(a.g.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gGe = (HeadImageView) view.findViewById(a.f.img_guard_club_list_header);
            aVar.gGe.setIsRound(true);
            aVar.gGe.setBorderColor(this.gFY.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar.gGe.setAutoChangeStyle(false);
            aVar.aFA = (TextView) view.findViewById(a.f.name_textView);
            aVar.gGf = (TextView) view.findViewById(a.f.nameSuffix_textView);
            aVar.gGg = (TextView) view.findViewById(a.f.tv_guard_club_list_num);
            aVar.gGh = (TbImageView) view.findViewById(a.f.guard_club_header_pendent);
            aVar.gGi = (LottieAnimationView) view.findViewById(a.f.live_anim);
            aVar.gGj = (TextView) view.findViewById(a.f.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fGx.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gGb.get(i);
        if (dVar != null) {
            aVar.gGe.startLoad(dVar.bgu, 12, false);
            aVar.gGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.gGf.getWidth();
            if (width <= 0) {
                aVar.gGf.measure(0, 0);
                width = aVar.gGf.getMeasuredWidth();
            }
            String str2 = dVar.bgm;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aFA.setPadding(0, 0, width, 0);
                aVar.gGf.setVisibility(0);
                str = substring;
            } else {
                aVar.aFA.setPadding(0, 0, 0, 0);
                aVar.gGf.setVisibility(4);
                str = str2;
            }
            aVar.aFA.setText(str);
            aVar.gGg.setText(String.format(this.gFY.getResources().getString(a.h.guard_join_list_contribution), dVar.score));
            aVar.gGe.setScaleX(1.0f);
            aVar.gGe.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String eD = com.baidu.live.guardclub.g.KF().eD(dVar.bgr);
            if (!TextUtils.isEmpty(eD)) {
                aVar.gGh.setVisibility(0);
                aVar.gGh.startLoad(eD, 10, false);
            } else {
                aVar.gGh.setVisibility(8);
            }
            aVar.gGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.gGa != null) {
                        f.this.gGa.a(dVar, i);
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
        aVar.gGi.setVisibility(0);
        aVar.gGi.setAnimation("live_anim_guard_join.json");
        aVar.gGi.setVisibility(0);
        aVar.gGi.loop(true);
        aVar.gGi.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gGe, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gGe, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gGk == null) {
            aVar.gGk = new AnimatorSet();
        } else {
            aVar.gGk.cancel();
        }
        aVar.gGk.play(ofFloat).with(ofFloat2);
        aVar.gGk.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gGi.setVisibility(8);
        aVar.gGi.cancelAnimation();
        if (aVar.gGk != null) {
            aVar.gGk.cancel();
        }
        aVar.gGe.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.PQ().bod.aML) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gFY);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gFY.getPageContext().getPageActivity(), Long.valueOf(dVar.aQx).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void cl(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gGb = new ArrayList(list);
        } else {
            this.gGb = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void cm(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gGb == null) {
                this.gGb = new ArrayList();
            }
            this.gGb.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void uI(int i) {
        if (this.gGb != null && this.gGb.size() > 0 && i >= 0 && i < this.gGb.size()) {
            this.gGb.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bTf() {
        if (this.fGx != null && this.fGx.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fGx.size()) {
                    b(this.fGx.get(i2));
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
        private TextView aFA;
        private HeadImageView gGe;
        private TextView gGf;
        private TextView gGg;
        private TbImageView gGh;
        private LottieAnimationView gGi;
        private TextView gGj;
        private AnimatorSet gGk;

        private a() {
        }
    }
}
