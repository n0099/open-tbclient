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
    private ArrayList<a> eSs = new ArrayList<>();
    private BdUniqueId fOA;
    private b fOB;
    private List<com.baidu.tieba.ala.guardclub.model.d> fOC;
    private BaseActivity fOz;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.fOz = baseActivity;
        this.fOA = bdUniqueId;
    }

    public void a(b bVar) {
        this.fOB = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fOC == null) {
            return 0;
        }
        return this.fOC.size();
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
            view = LayoutInflater.from(this.fOz.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.fOF = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fOF.setIsRound(true);
            aVar.fOF.setBorderColor(this.fOz.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.fOF.setAutoChangeStyle(false);
            aVar.avN = (TextView) view.findViewById(a.g.name_textView);
            aVar.fOG = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.fOH = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fOI = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.fOJ = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.fOK = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.eSs.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.fOC.get(i);
        if (dVar != null) {
            aVar.fOF.startLoad(dVar.aSA, 12, false);
            aVar.fOF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.fOG.getWidth();
            if (width <= 0) {
                aVar.fOG.measure(0, 0);
                width = aVar.fOG.getMeasuredWidth();
            }
            String str2 = dVar.aSt;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.avN.setPadding(0, 0, width, 0);
                aVar.fOG.setVisibility(0);
                str = substring;
            } else {
                aVar.avN.setPadding(0, 0, 0, 0);
                aVar.fOG.setVisibility(4);
                str = str2;
            }
            aVar.avN.setText(str);
            aVar.fOH.setText(String.format(this.fOz.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.fOF.setScaleX(1.0f);
            aVar.fOF.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String cD = com.baidu.live.guardclub.g.CJ().cD(dVar.aSy);
            if (!TextUtils.isEmpty(cD)) {
                aVar.fOI.setVisibility(0);
                aVar.fOI.startLoad(cD, 10, false);
            } else {
                aVar.fOI.setVisibility(8);
            }
            aVar.fOK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.fOB != null) {
                        f.this.fOB.a(dVar, i);
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
        aVar.fOJ.setVisibility(0);
        aVar.fOJ.setAnimation("live_anim_guard_join.json");
        aVar.fOJ.setVisibility(0);
        aVar.fOJ.loop(true);
        aVar.fOJ.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.fOF, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.fOF, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.fOL == null) {
            aVar.fOL = new AnimatorSet();
        } else {
            aVar.fOL.cancel();
        }
        aVar.fOL.play(ofFloat).with(ofFloat2);
        aVar.fOL.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.fOJ.setVisibility(8);
        aVar.fOJ.cancelAnimation();
        if (aVar.fOL != null) {
            aVar.fOL.cancel();
        }
        aVar.fOF.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hs().aZn.aBC) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.fOz);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.fOz.getPageContext().getPageActivity(), Long.valueOf(dVar.aEX).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bL(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.fOC = new ArrayList(list);
        } else {
            this.fOC = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bM(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fOC == null) {
                this.fOC = new ArrayList();
            }
            this.fOC.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void rd(int i) {
        if (this.fOC != null && this.fOC.size() > 0 && i >= 0 && i < this.fOC.size()) {
            this.fOC.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bAK() {
        if (this.eSs != null && this.eSs.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eSs.size()) {
                    b(this.eSs.get(i2));
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
        private TextView avN;
        private HeadImageView fOF;
        private TextView fOG;
        private TextView fOH;
        private TbImageView fOI;
        private LottieAnimationView fOJ;
        private TextView fOK;
        private AnimatorSet fOL;

        private a() {
        }
    }
}
