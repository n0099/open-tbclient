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
    private ArrayList<a> ffV = new ArrayList<>();
    private BaseActivity gdP;
    private BdUniqueId gdQ;
    private b gdR;
    private List<com.baidu.tieba.ala.guardclub.model.d> gdS;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gdP = baseActivity;
        this.gdQ = bdUniqueId;
    }

    public void a(b bVar) {
        this.gdR = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gdS == null) {
            return 0;
        }
        return this.gdS.size();
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
            view = LayoutInflater.from(this.gdP.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gdV = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gdV.setIsRound(true);
            aVar.gdV.setBorderColor(this.gdP.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.gdV.setAutoChangeStyle(false);
            aVar.aBx = (TextView) view.findViewById(a.g.name_textView);
            aVar.gdW = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.gdX = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gdY = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.gdZ = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.gea = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.ffV.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gdS.get(i);
        if (dVar != null) {
            aVar.gdV.startLoad(dVar.ban, 12, false);
            aVar.gdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.gdW.getWidth();
            if (width <= 0) {
                aVar.gdW.measure(0, 0);
                width = aVar.gdW.getMeasuredWidth();
            }
            String str2 = dVar.bag;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aBx.setPadding(0, 0, width, 0);
                aVar.gdW.setVisibility(0);
                str = substring;
            } else {
                aVar.aBx.setPadding(0, 0, 0, 0);
                aVar.gdW.setVisibility(4);
                str = str2;
            }
            aVar.aBx.setText(str);
            aVar.gdX.setText(String.format(this.gdP.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.gdV.setScaleX(1.0f);
            aVar.gdV.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String ex = com.baidu.live.guardclub.g.IP().ex(dVar.bal);
            if (!TextUtils.isEmpty(ex)) {
                aVar.gdY.setVisibility(0);
                aVar.gdY.startLoad(ex, 10, false);
            } else {
                aVar.gdY.setVisibility(8);
            }
            aVar.gea.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.gdR != null) {
                        f.this.gdR.a(dVar, i);
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
        aVar.gdZ.setVisibility(0);
        aVar.gdZ.setAnimation("live_anim_guard_join.json");
        aVar.gdZ.setVisibility(0);
        aVar.gdZ.loop(true);
        aVar.gdZ.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gdV, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gdV, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.geb == null) {
            aVar.geb = new AnimatorSet();
        } else {
            aVar.geb.cancel();
        }
        aVar.geb.play(ofFloat).with(ofFloat2);
        aVar.geb.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gdZ.setVisibility(8);
        aVar.gdZ.cancelAnimation();
        if (aVar.geb != null) {
            aVar.geb.cancel();
        }
        aVar.gdV.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.NN().bhy.aId) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gdP);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gdP.getPageContext().getPageActivity(), Long.valueOf(dVar.aLM).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bR(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gdS = new ArrayList(list);
        } else {
            this.gdS = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bS(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gdS == null) {
                this.gdS = new ArrayList();
            }
            this.gdS.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void tI(int i) {
        if (this.gdS != null && this.gdS.size() > 0 && i >= 0 && i < this.gdS.size()) {
            this.gdS.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bLq() {
        if (this.ffV != null && this.ffV.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ffV.size()) {
                    b(this.ffV.get(i2));
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
        private TextView aBx;
        private HeadImageView gdV;
        private TextView gdW;
        private TextView gdX;
        private TbImageView gdY;
        private LottieAnimationView gdZ;
        private TextView gea;
        private AnimatorSet geb;

        private a() {
        }
    }
}
