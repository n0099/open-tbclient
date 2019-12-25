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
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private BaseActivity ezt;
    private BdUniqueId ezu;
    private b ezv;
    private ArrayList<a> ezw = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.g> ezx;

    /* loaded from: classes2.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public d(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.ezt = baseActivity;
        this.ezu = bdUniqueId;
    }

    public void a(b bVar) {
        this.ezv = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ezx == null) {
            return 0;
        }
        return this.ezx.size();
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
            view = LayoutInflater.from(this.ezt.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.ezA = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.ezA.setIsRound(true);
            aVar.ezA.setBorderColor(this.ezt.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar.ezA.setAutoChangeStyle(false);
            aVar.aqC = (TextView) view.findViewById(a.g.name_textView);
            aVar.ezB = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.ezC = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.ezD = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.ezE = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.ezF = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.ezw.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.g gVar = this.ezx.get(i);
        if (gVar != null) {
            aVar.ezA.startLoad(gVar.eBv, 12, false);
            aVar.ezA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.a(gVar);
                }
            });
            int width = aVar.ezB.getWidth();
            if (width <= 0) {
                aVar.ezB.measure(0, 0);
                width = aVar.ezB.getMeasuredWidth();
            }
            String str2 = gVar.eBo;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.aqC.setPadding(0, 0, width, 0);
                aVar.ezB.setVisibility(0);
                str = substring;
            } else {
                aVar.aqC.setPadding(0, 0, 0, 0);
                aVar.ezB.setVisibility(4);
                str = str2;
            }
            aVar.aqC.setText(str);
            aVar.ezC.setText(String.format(this.ezt.getResources().getString(a.i.guard_join_list_contribution), gVar.score));
            aVar.ezA.setScaleX(1.0f);
            aVar.ezA.setScaleY(1.0f);
            if (gVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String pd = l.bcE().pd(gVar.eBt);
            if (!TextUtils.isEmpty(pd)) {
                aVar.ezD.setVisibility(0);
                aVar.ezD.startLoad(pd, 10, false);
            } else {
                aVar.ezD.setVisibility(8);
            }
            aVar.ezF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ezv != null) {
                        d.this.ezv.a(gVar, i);
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
        aVar.ezE.setVisibility(0);
        aVar.ezE.setAnimation("live_anim_guard_join.json");
        aVar.ezE.setVisibility(0);
        aVar.ezE.loop(true);
        aVar.ezE.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.ezA, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.ezA, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.ezG == null) {
            aVar.ezG = new AnimatorSet();
        } else {
            aVar.ezG.cancel();
        }
        aVar.ezG.play(ofFloat).with(ofFloat2);
        aVar.ezG.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.ezE.setVisibility(8);
        aVar.ezE.cancelAnimation();
        if (aVar.ezG != null) {
            aVar.ezG.cancel();
        }
        aVar.ezA.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        if (gVar != null) {
            try {
                if (gVar.liveStatus == 1 && !TextUtils.isEmpty(gVar.liveId)) {
                    if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.r.a.wA().arE.Yr) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.ezt);
                        alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(gVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.ezt.getPageContext().getPageActivity(), Long.valueOf(gVar.abl).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.g> list) {
        if (list != null && !list.isEmpty()) {
            this.ezx = new ArrayList(list);
        } else {
            this.ezx = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.g> list) {
        if (list != null && !list.isEmpty()) {
            if (this.ezx == null) {
                this.ezx = new ArrayList();
            }
            this.ezx.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void oX(int i) {
        if (this.ezx != null && this.ezx.size() > 0 && i >= 0 && i < this.ezx.size()) {
            this.ezx.remove(i);
            notifyDataSetChanged();
        }
    }

    public void bcx() {
        if (this.ezw != null && this.ezw.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ezw.size()) {
                    b(this.ezw.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private TextView aqC;
        private HeadImageView ezA;
        private TextView ezB;
        private TextView ezC;
        private TbImageView ezD;
        private LottieAnimationView ezE;
        private TextView ezF;
        private AnimatorSet ezG;

        private a() {
        }
    }
}
