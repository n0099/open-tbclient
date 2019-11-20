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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
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
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private BaseActivity dLg;
    private BdUniqueId dLh;
    private b dLi;
    private ArrayList<a> dLj = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.g> dLk;

    /* loaded from: classes6.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public d(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.dLg = baseActivity;
        this.dLh = bdUniqueId;
    }

    public void a(b bVar) {
        this.dLi = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dLk == null) {
            return 0;
        }
        return this.dLk.size();
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
            view = LayoutInflater.from(this.dLg.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.dLn = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.dLn.setIsRound(true);
            aVar.dLn.setAutoChangeStyle(false);
            aVar.dLo = (TextView) view.findViewById(a.g.name_textView);
            aVar.dLp = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.dLq = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.dLr = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.dLs = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.dLt = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.dLj.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.g gVar = this.dLk.get(i);
        if (gVar != null) {
            aVar.dLn.startLoad(gVar.dNn, 12, false);
            aVar.dLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.a(gVar);
                }
            });
            int width = aVar.dLp.getWidth();
            if (width <= 0) {
                aVar.dLp.measure(0, 0);
                width = aVar.dLp.getMeasuredWidth();
            }
            String str2 = gVar.dNg;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.dLo.setPadding(0, 0, width, 0);
                aVar.dLp.setVisibility(0);
                str = substring;
            } else {
                aVar.dLo.setPadding(0, 0, 0, 0);
                aVar.dLp.setVisibility(4);
                str = str2;
            }
            aVar.dLo.setText(str);
            aVar.dLq.setText(String.format(this.dLg.getResources().getString(a.i.guard_join_list_contribution), gVar.score));
            aVar.dLn.setScaleX(1.0f);
            aVar.dLn.setScaleY(1.0f);
            if (gVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String mN = m.aLv().mN(gVar.dNl);
            if (!TextUtils.isEmpty(mN)) {
                aVar.dLr.setVisibility(0);
                aVar.dLr.startLoad(mN, 10, false);
            } else {
                aVar.dLr.setVisibility(8);
            }
            aVar.dLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dLi != null) {
                        d.this.dLi.a(gVar, i);
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
        aVar.dLs.setVisibility(0);
        aVar.dLs.setAnimation("live_anim_guard_join.json");
        aVar.dLs.setVisibility(0);
        aVar.dLs.loop(true);
        aVar.dLs.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.dLn, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.dLn, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.dLu == null) {
            aVar.dLu = new AnimatorSet();
        } else {
            aVar.dLu.cancel();
        }
        aVar.dLu.play(ofFloat).with(ofFloat2);
        aVar.dLu.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.dLs.setVisibility(8);
        aVar.dLs.cancelAnimation();
        if (aVar.dLu != null) {
            aVar.dLu.cancel();
        }
        aVar.dLn.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        if (gVar != null) {
            try {
                if (gVar.liveStatus == 1 && !TextUtils.isEmpty(gVar.liveId)) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.dLg);
                    alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(gVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.dLg.getPageContext().getPageActivity(), Long.valueOf(gVar.dND).longValue(), 0L, false, "", true);
                    guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
                    guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.g> list) {
        if (list != null && !list.isEmpty()) {
            this.dLk = new ArrayList(list);
        } else {
            this.dLk = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bu(List<com.baidu.tieba.ala.guardclub.model.g> list) {
        if (list != null && !list.isEmpty()) {
            if (this.dLk == null) {
                this.dLk = new ArrayList();
            }
            this.dLk.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void mH(int i) {
        if (this.dLk != null && this.dLk.size() > 0 && i >= 0 && i < this.dLk.size()) {
            this.dLk.remove(i);
            notifyDataSetChanged();
        }
    }

    public void aLn() {
        if (this.dLj != null && this.dLj.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dLj.size()) {
                    b(this.dLj.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        private HeadImageView dLn;
        private TextView dLo;
        private TextView dLp;
        private TextView dLq;
        private TbImageView dLr;
        private LottieAnimationView dLs;
        private TextView dLt;
        private AnimatorSet dLu;

        private a() {
        }
    }
}
