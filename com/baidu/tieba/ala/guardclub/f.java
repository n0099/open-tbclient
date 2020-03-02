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
    private BaseActivity eET;
    private BdUniqueId eEU;
    private b eEV;
    private ArrayList<a> eEW = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.d> eEX;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.eET = baseActivity;
        this.eEU = bdUniqueId;
    }

    public void a(b bVar) {
        this.eEV = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eEX == null) {
            return 0;
        }
        return this.eEX.size();
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
            view = LayoutInflater.from(this.eET.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.eFa = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eFa.setIsRound(true);
            aVar.eFa.setBorderColor(this.eET.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.eFa.setAutoChangeStyle(false);
            aVar.avp = (TextView) view.findViewById(a.g.name_textView);
            aVar.eFb = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.eFc = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eFd = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.eFe = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.eFf = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.eEW.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.eEX.get(i);
        if (dVar != null) {
            aVar.eFa.startLoad(dVar.apS, 12, false);
            aVar.eFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.eFb.getWidth();
            if (width <= 0) {
                aVar.eFb.measure(0, 0);
                width = aVar.eFb.getMeasuredWidth();
            }
            String str2 = dVar.apL;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.avp.setPadding(0, 0, width, 0);
                aVar.eFb.setVisibility(0);
                str = substring;
            } else {
                aVar.avp.setPadding(0, 0, 0, 0);
                aVar.eFb.setVisibility(4);
                str = str2;
            }
            aVar.avp.setText(str);
            aVar.eFc.setText(String.format(this.eET.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.eFa.setScaleX(1.0f);
            aVar.eFa.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String bT = com.baidu.live.guardclub.g.vH().bT(dVar.apQ);
            if (!TextUtils.isEmpty(bT)) {
                aVar.eFd.setVisibility(0);
                aVar.eFd.startLoad(bT, 10, false);
            } else {
                aVar.eFd.setVisibility(8);
            }
            aVar.eFf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.eEV != null) {
                        f.this.eEV.a(dVar, i);
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
        aVar.eFe.setVisibility(0);
        aVar.eFe.setAnimation("live_anim_guard_join.json");
        aVar.eFe.setVisibility(0);
        aVar.eFe.loop(true);
        aVar.eFe.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.eFa, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.eFa, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.eFg == null) {
            aVar.eFg = new AnimatorSet();
        } else {
            aVar.eFg.cancel();
        }
        aVar.eFg.play(ofFloat).with(ofFloat2);
        aVar.eFg.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.eFe.setVisibility(8);
        aVar.eFe.cancelAnimation();
        if (aVar.eFg != null) {
            aVar.eFg.cancel();
        }
        aVar.eFa.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zl().awB.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.eET);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.eET.getPageContext().getPageActivity(), Long.valueOf(dVar.adC).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.eEX = new ArrayList(list);
        } else {
            this.eEX = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eEX == null) {
                this.eEX = new ArrayList();
            }
            this.eEX.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void pp(int i) {
        if (this.eEX != null && this.eEX.size() > 0 && i >= 0 && i < this.eEX.size()) {
            this.eEX.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bfj() {
        if (this.eEW != null && this.eEW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eEW.size()) {
                    b(this.eEW.get(i2));
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
        private TextView avp;
        private HeadImageView eFa;
        private TextView eFb;
        private TextView eFc;
        private TbImageView eFd;
        private LottieAnimationView eFe;
        private TextView eFf;
        private AnimatorSet eFg;

        private a() {
        }
    }
}
