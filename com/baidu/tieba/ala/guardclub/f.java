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
    private BaseActivity fkc;
    private BdUniqueId fkd;
    private b fke;
    private ArrayList<a> fkf = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.d> fkg;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.fkc = baseActivity;
        this.fkd = bdUniqueId;
    }

    public void a(b bVar) {
        this.fke = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkg == null) {
            return 0;
        }
        return this.fkg.size();
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
            view = LayoutInflater.from(this.fkc.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.fkj = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fkj.setIsRound(true);
            aVar.fkj.setBorderColor(this.fkc.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.fkj.setAutoChangeStyle(false);
            aVar.aPj = (TextView) view.findViewById(a.g.name_textView);
            aVar.fkk = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.fkl = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fkm = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.fkn = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.fko = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fkf.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.fkg.get(i);
        if (dVar != null) {
            aVar.fkj.startLoad(dVar.aIS, 12, false);
            aVar.fkj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.fkk.getWidth();
            if (width <= 0) {
                aVar.fkk.measure(0, 0);
                width = aVar.fkk.getMeasuredWidth();
            }
            String str2 = dVar.aIL;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aPj.setPadding(0, 0, width, 0);
                aVar.fkk.setVisibility(0);
                str = substring;
            } else {
                aVar.aPj.setPadding(0, 0, 0, 0);
                aVar.fkk.setVisibility(4);
                str = str2;
            }
            aVar.aPj.setText(str);
            aVar.fkl.setText(String.format(this.fkc.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.fkj.setScaleX(1.0f);
            aVar.fkj.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String ci = com.baidu.live.guardclub.g.Ar().ci(dVar.aIQ);
            if (!TextUtils.isEmpty(ci)) {
                aVar.fkm.setVisibility(0);
                aVar.fkm.startLoad(ci, 10, false);
            } else {
                aVar.fkm.setVisibility(8);
            }
            aVar.fko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.fke != null) {
                        f.this.fke.a(dVar, i);
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
        aVar.fkn.setVisibility(0);
        aVar.fkn.setAnimation("live_anim_guard_join.json");
        aVar.fkn.setVisibility(0);
        aVar.fkn.loop(true);
        aVar.fkn.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.fkj, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.fkj, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.fkp == null) {
            aVar.fkp = new AnimatorSet();
        } else {
            aVar.fkp.cancel();
        }
        aVar.fkp.play(ofFloat).with(ofFloat2);
        aVar.fkp.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.fkn.setVisibility(8);
        aVar.fkn.cancelAnimation();
        if (aVar.fkp != null) {
            aVar.fkp.cancel();
        }
        aVar.fkj.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.En().aQu.ata) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.fkc);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.fkc.getPageContext().getPageActivity(), Long.valueOf(dVar.awj).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bB(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            this.fkg = new ArrayList(list);
        } else {
            this.fkg = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bC(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fkg == null) {
                this.fkg = new ArrayList();
            }
            this.fkg.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void pL(int i) {
        if (this.fkg != null && this.fkg.size() > 0 && i >= 0 && i < this.fkg.size()) {
            this.fkg.remove(i);
            notifyDataSetChanged();
        }
    }

    public void boE() {
        if (this.fkf != null && this.fkf.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fkf.size()) {
                    b(this.fkf.get(i2));
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
        private TextView aPj;
        private HeadImageView fkj;
        private TextView fkk;
        private TextView fkl;
        private TbImageView fkm;
        private LottieAnimationView fkn;
        private TextView fko;
        private AnimatorSet fkp;

        private a() {
        }
    }
}
