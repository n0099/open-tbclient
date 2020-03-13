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
    private BaseActivity eFg;
    private BdUniqueId eFh;
    private b eFi;
    private ArrayList<a> eFj = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.d> eFk;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.eFg = baseActivity;
        this.eFh = bdUniqueId;
    }

    public void a(b bVar) {
        this.eFi = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eFk == null) {
            return 0;
        }
        return this.eFk.size();
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
            view = LayoutInflater.from(this.eFg.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.eFn = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.eFn.setIsRound(true);
            aVar.eFn.setBorderColor(this.eFg.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.eFn.setAutoChangeStyle(false);
            aVar.avq = (TextView) view.findViewById(a.g.name_textView);
            aVar.eFo = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.eFp = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.eFq = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.eFr = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.eFs = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.eFj.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.eFk.get(i);
        if (dVar != null) {
            aVar.eFn.startLoad(dVar.apT, 12, false);
            aVar.eFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.eFo.getWidth();
            if (width <= 0) {
                aVar.eFo.measure(0, 0);
                width = aVar.eFo.getMeasuredWidth();
            }
            String str2 = dVar.apM;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.avq.setPadding(0, 0, width, 0);
                aVar.eFo.setVisibility(0);
                str = substring;
            } else {
                aVar.avq.setPadding(0, 0, 0, 0);
                aVar.eFo.setVisibility(4);
                str = str2;
            }
            aVar.avq.setText(str);
            aVar.eFp.setText(String.format(this.eFg.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.eFn.setScaleX(1.0f);
            aVar.eFn.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String bT = com.baidu.live.guardclub.g.vH().bT(dVar.apR);
            if (!TextUtils.isEmpty(bT)) {
                aVar.eFq.setVisibility(0);
                aVar.eFq.startLoad(bT, 10, false);
            } else {
                aVar.eFq.setVisibility(8);
            }
            aVar.eFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.eFi != null) {
                        f.this.eFi.a(dVar, i);
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
        aVar.eFr.setVisibility(0);
        aVar.eFr.setAnimation("live_anim_guard_join.json");
        aVar.eFr.setVisibility(0);
        aVar.eFr.loop(true);
        aVar.eFr.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.eFn, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.eFn, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.eFt == null) {
            aVar.eFt = new AnimatorSet();
        } else {
            aVar.eFt.cancel();
        }
        aVar.eFt.play(ofFloat).with(ofFloat2);
        aVar.eFt.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.eFr.setVisibility(8);
        aVar.eFr.cancelAnimation();
        if (aVar.eFt != null) {
            aVar.eFt.cancel();
        }
        aVar.eFn.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zl().awC.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.eFg);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.eFg.getPageContext().getPageActivity(), Long.valueOf(dVar.adC).longValue(), 0L, false, "", true);
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
            this.eFk = new ArrayList(list);
        } else {
            this.eFk = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.eFk == null) {
                this.eFk = new ArrayList();
            }
            this.eFk.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void pp(int i) {
        if (this.eFk != null && this.eFk.size() > 0 && i >= 0 && i < this.eFk.size()) {
            this.eFk.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bfk() {
        if (this.eFj != null && this.eFj.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eFj.size()) {
                    b(this.eFj.get(i2));
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
        private TextView avq;
        private HeadImageView eFn;
        private TextView eFo;
        private TextView eFp;
        private TbImageView eFq;
        private LottieAnimationView eFr;
        private TextView eFs;
        private AnimatorSet eFt;

        private a() {
        }
    }
}
