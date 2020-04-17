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
    private BaseActivity fjX;
    private BdUniqueId fjY;
    private b fjZ;
    private ArrayList<a> fka = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.d> fkb;

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public f(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.fjX = baseActivity;
        this.fjY = bdUniqueId;
    }

    public void a(b bVar) {
        this.fjZ = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkb == null) {
            return 0;
        }
        return this.fkb.size();
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
            view = LayoutInflater.from(this.fjX.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.fke = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.fke.setIsRound(true);
            aVar.fke.setBorderColor(this.fjX.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.fke.setAutoChangeStyle(false);
            aVar.aPd = (TextView) view.findViewById(a.g.name_textView);
            aVar.fkf = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.fkg = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.fkh = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.fki = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.fkj = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.fka.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.d dVar = this.fkb.get(i);
        if (dVar != null) {
            aVar.fke.startLoad(dVar.aIM, 12, false);
            aVar.fke.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    f.this.a(dVar);
                }
            });
            int width = aVar.fkf.getWidth();
            if (width <= 0) {
                aVar.fkf.measure(0, 0);
                width = aVar.fkf.getMeasuredWidth();
            }
            String str2 = dVar.aIF;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aPd.setPadding(0, 0, width, 0);
                aVar.fkf.setVisibility(0);
                str = substring;
            } else {
                aVar.aPd.setPadding(0, 0, 0, 0);
                aVar.fkf.setVisibility(4);
                str = str2;
            }
            aVar.aPd.setText(str);
            aVar.fkg.setText(String.format(this.fjX.getResources().getString(a.i.guard_join_list_contribution), dVar.score));
            aVar.fke.setScaleX(1.0f);
            aVar.fke.setScaleY(1.0f);
            if (dVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String ci = com.baidu.live.guardclub.g.As().ci(dVar.aIK);
            if (!TextUtils.isEmpty(ci)) {
                aVar.fkh.setVisibility(0);
                aVar.fkh.startLoad(ci, 10, false);
            } else {
                aVar.fkh.setVisibility(8);
            }
            aVar.fkj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.fjZ != null) {
                        f.this.fjZ.a(dVar, i);
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
        aVar.fki.setVisibility(0);
        aVar.fki.setAnimation("live_anim_guard_join.json");
        aVar.fki.setVisibility(0);
        aVar.fki.loop(true);
        aVar.fki.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.fke, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.fke, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.fkk == null) {
            aVar.fkk = new AnimatorSet();
        } else {
            aVar.fkk.cancel();
        }
        aVar.fkk.play(ofFloat).with(ofFloat2);
        aVar.fkk.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.fki.setVisibility(8);
        aVar.fki.cancelAnimation();
        if (aVar.fkk != null) {
            aVar.fkk.cancel();
        }
        aVar.fke.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.d dVar) {
        if (dVar != null) {
            try {
                if (dVar.liveStatus == 1 && !TextUtils.isEmpty(dVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Eo().aQp.asU) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.fjX);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(dVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.fjX.getPageContext().getPageActivity(), Long.valueOf(dVar.awd).longValue(), 0L, false, "", true);
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
            this.fkb = new ArrayList(list);
        } else {
            this.fkb = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bC(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.fkb == null) {
                this.fkb = new ArrayList();
            }
            this.fkb.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void pL(int i) {
        if (this.fkb != null && this.fkb.size() > 0 && i >= 0 && i < this.fkb.size()) {
            this.fkb.remove(i);
            notifyDataSetChanged();
        }
    }

    public void boG() {
        if (this.fka != null && this.fka.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fka.size()) {
                    b(this.fka.get(i2));
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
        private TextView aPd;
        private HeadImageView fke;
        private TextView fkf;
        private TextView fkg;
        private TbImageView fkh;
        private LottieAnimationView fki;
        private TextView fkj;
        private AnimatorSet fkk;

        private a() {
        }
    }
}
