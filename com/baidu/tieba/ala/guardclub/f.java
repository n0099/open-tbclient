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
    private ArrayList<a> fsk = new ArrayList<>();
    private BaseActivity gqf;
    private BdUniqueId gqg;
    private b gqh;
    private List<com.baidu.tieba.ala.guardclub.model.d> gqi;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.gqf = baseActivity;
        this.gqg = bdUniqueId;
    }

    public void a(b bVar) {
        this.gqh = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gqi == null) {
            return 0;
        }
        return this.gqi.size();
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
            view = LayoutInflater.from(this.gqf.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.gql = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.gql.setIsRound(true);
            aVar.gql.setBorderColor(this.gqf.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.gql.setAutoChangeStyle(false);
            aVar.aEC = (TextView) view.findViewById(a.g.name_textView);
            aVar.gqm = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.gqn = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.gqo = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.gqp = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.gqq = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fsk.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.gqi.get(i);
        if (dVar != null) {
            aVar.gql.startLoad(dVar.bdI, 12, false);
            aVar.gql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.gqm.getWidth();
            if (width <= 0) {
                aVar.gqm.measure(0, 0);
                width = aVar.gqm.getMeasuredWidth();
            }
            String str2 = dVar.bdB;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aEC.setPadding(0, 0, width, 0);
                aVar.gqm.setVisibility(0);
                str = substring;
            } else {
                aVar.aEC.setPadding(0, 0, 0, 0);
                aVar.gqm.setVisibility(4);
                str = str2;
            }
            aVar.aEC.setText(str);
            aVar.gqn.setText(String.format(this.gqf.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.gql.setScaleX(1.0f);
            aVar.gql.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String eC = com.baidu.live.guardclub.g.JM().eC(dVar.bdG);
            if (!TextUtils.isEmpty(eC)) {
                aVar.gqo.setVisibility(0);
                aVar.gqo.startLoad(eC, 10, false);
            } else {
                aVar.gqo.setVisibility(8);
            }
            aVar.gqq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.gqh != null) {
                        f.this.gqh.a(dVar, i);
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
        aVar.gqp.setVisibility(0);
        aVar.gqp.setAnimation("live_anim_guard_join.json");
        aVar.gqp.setVisibility(0);
        aVar.gqp.loop(true);
        aVar.gqp.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.gql, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.gql, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.gqr == null) {
            aVar.gqr = new AnimatorSet();
        } else {
            aVar.gqr.cancel();
        }
        aVar.gqr.play(ofFloat).with(ofFloat2);
        aVar.gqr.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.gqp.setVisibility(8);
        aVar.gqp.cancelAnimation();
        if (aVar.gqr != null) {
            aVar.gqr.cancel();
        }
        aVar.gql.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.OS().blo.aLh) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gqf);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.gqf.getPageContext().getPageActivity(), Long.valueOf(dVar.aOR).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bU(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.gqi = new ArrayList(list);
        } else {
            this.gqi = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bV(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.gqi == null) {
                this.gqi = new ArrayList();
            }
            this.gqi.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ug(int i) {
        if (this.gqi != null && this.gqi.size() > 0 && i >= 0 && i < this.gqi.size()) {
            this.gqi.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bOa() {
        if (this.fsk != null && this.fsk.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fsk.size()) {
                    b(this.fsk.get(i2));
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
        private TextView aEC;
        private HeadImageView gql;
        private TextView gqm;
        private TextView gqn;
        private TbImageView gqo;
        private LottieAnimationView gqp;
        private TextView gqq;
        private AnimatorSet gqr;

        private a() {
        }
    }
}
