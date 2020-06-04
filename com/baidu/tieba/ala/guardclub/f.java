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
    private BaseActivity fxT;
    private BdUniqueId fxU;
    private b fxV;
    private ArrayList<a> fxW = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.d> fxX;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.fxT = baseActivity;
        this.fxU = bdUniqueId;
    }

    public void a(b bVar) {
        this.fxV = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxX == null) {
            return 0;
        }
        return this.fxX.size();
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
            view = LayoutInflater.from(this.fxT.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.fya = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fya.setIsRound(true);
            aVar.fya.setBorderColor(this.fxT.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.fya.setAutoChangeStyle(false);
            aVar.aVs = (TextView) view.findViewById(a.g.name_textView);
            aVar.fyb = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.fyc = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fyd = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.fye = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.fyf = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fxW.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.fxX.get(i);
        if (dVar != null) {
            aVar.fya.startLoad(dVar.aOB, 12, false);
            aVar.fya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.fyb.getWidth();
            if (width <= 0) {
                aVar.fyb.measure(0, 0);
                width = aVar.fyb.getMeasuredWidth();
            }
            String str2 = dVar.aOu;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aVs.setPadding(0, 0, width, 0);
                aVar.fyb.setVisibility(0);
                str = substring;
            } else {
                aVar.aVs.setPadding(0, 0, 0, 0);
                aVar.fyb.setVisibility(4);
                str = str2;
            }
            aVar.aVs.setText(str);
            aVar.fyc.setText(String.format(this.fxT.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.fya.setScaleX(1.0f);
            aVar.fya.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String cr = com.baidu.live.guardclub.g.BH().cr(dVar.aOz);
            if (!TextUtils.isEmpty(cr)) {
                aVar.fyd.setVisibility(0);
                aVar.fyd.startLoad(cr, 10, false);
            } else {
                aVar.fyd.setVisibility(8);
            }
            aVar.fyf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.fxV != null) {
                        f.this.fxV.a(dVar, i);
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
        aVar.fye.setVisibility(0);
        aVar.fye.setAnimation("live_anim_guard_join.json");
        aVar.fye.setVisibility(0);
        aVar.fye.loop(true);
        aVar.fye.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.fya, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.fya, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.fyg == null) {
            aVar.fyg = new AnimatorSet();
        } else {
            aVar.fyg.cancel();
        }
        aVar.fyg.play(ofFloat).with(ofFloat2);
        aVar.fyg.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.fye.setVisibility(8);
        aVar.fye.cancelAnimation();
        if (aVar.fyg != null) {
            aVar.fyg.cancel();
        }
        aVar.fya.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Ge().aWF.aya) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.fxT);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.fxT.getPageContext().getPageActivity(), Long.valueOf(dVar.aBs).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void by(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.fxX = new ArrayList(list);
        } else {
            this.fxX = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bz(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fxX == null) {
                this.fxX = new ArrayList();
            }
            this.fxX.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void qo(int i) {
        if (this.fxX != null && this.fxX.size() > 0 && i >= 0 && i < this.fxX.size()) {
            this.fxX.remove(i);
            notifyDataSetChanged();
        }
    }

    public void buy() {
        if (this.fxW != null && this.fxW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fxW.size()) {
                    b(this.fxW.get(i2));
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
        private TextView aVs;
        private HeadImageView fya;
        private TextView fyb;
        private TextView fyc;
        private TbImageView fyd;
        private LottieAnimationView fye;
        private TextView fyf;
        private AnimatorSet fyg;

        private a() {
        }
    }
}
