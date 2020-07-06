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
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private ArrayList<a> eLX = new ArrayList<>();
    private BaseActivity fJe;
    private BdUniqueId fJf;
    private b fJg;
    private List<com.baidu.tieba.ala.guardclub.model.d> fJh;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.fJe = baseActivity;
        this.fJf = bdUniqueId;
    }

    public void a(b bVar) {
        this.fJg = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJh == null) {
            return 0;
        }
        return this.fJh.size();
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
            view = LayoutInflater.from(this.fJe.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.fJk = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fJk.setIsRound(true);
            aVar.fJk.setBorderColor(this.fJe.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.fJk.setAutoChangeStyle(false);
            aVar.aXZ = (TextView) view.findViewById(a.g.name_textView);
            aVar.fJl = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.fJm = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fJn = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.fJo = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.fJp = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.eLX.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.fJh.get(i);
        if (dVar != null) {
            aVar.fJk.startLoad(dVar.aRh, 12, false);
            aVar.fJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.fJl.getWidth();
            if (width <= 0) {
                aVar.fJl.measure(0, 0);
                width = aVar.fJl.getMeasuredWidth();
            }
            String str2 = dVar.aRa;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aXZ.setPadding(0, 0, width, 0);
                aVar.fJl.setVisibility(0);
                str = substring;
            } else {
                aVar.aXZ.setPadding(0, 0, 0, 0);
                aVar.fJl.setVisibility(4);
                str = str2;
            }
            aVar.aXZ.setText(str);
            aVar.fJm.setText(String.format(this.fJe.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.fJk.setScaleX(1.0f);
            aVar.fJk.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String cx = com.baidu.live.guardclub.g.Ch().cx(dVar.aRf);
            if (!TextUtils.isEmpty(cx)) {
                aVar.fJn.setVisibility(0);
                aVar.fJn.startLoad(cx, 10, false);
            } else {
                aVar.fJn.setVisibility(8);
            }
            aVar.fJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.fJg != null) {
                        f.this.fJg.a(dVar, i);
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
        aVar.fJo.setVisibility(0);
        aVar.fJo.setAnimation("live_anim_guard_join.json");
        aVar.fJo.setVisibility(0);
        aVar.fJo.loop(true);
        aVar.fJo.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.fJk, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.fJk, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.fJq == null) {
            aVar.fJq = new AnimatorSet();
        } else {
            aVar.fJq.cancel();
        }
        aVar.fJq.play(ofFloat).with(ofFloat2);
        aVar.fJq.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.fJo.setVisibility(8);
        aVar.fJo.cancelAnimation();
        if (aVar.fJq != null) {
            aVar.fJq.cancel();
        }
        aVar.fJk.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hm().aZp.aAp) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.fJe);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.fJe.getPageContext().getPageActivity(), Long.valueOf(dVar.aDD).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bH(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.fJh = new ArrayList(list);
        } else {
            this.fJh = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bI(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fJh == null) {
                this.fJh = new ArrayList();
            }
            this.fJh.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void qN(int i) {
        if (this.fJh != null && this.fJh.size() > 0 && i >= 0 && i < this.fJh.size()) {
            this.fJh.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bxu() {
        if (this.eLX != null && this.eLX.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eLX.size()) {
                    b(this.eLX.get(i2));
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
        private TextView aXZ;
        private HeadImageView fJk;
        private TextView fJl;
        private TextView fJm;
        private TbImageView fJn;
        private LottieAnimationView fJo;
        private TextView fJp;
        private AnimatorSet fJq;

        private a() {
        }
    }
}
