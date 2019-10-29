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
    private BaseActivity dLX;
    private BdUniqueId dLY;
    private b dLZ;
    private ArrayList<a> dMa = new ArrayList<>();
    private List<com.baidu.tieba.ala.guardclub.model.g> dMb;

    /* loaded from: classes6.dex */
    public interface b {
        void a(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public d(@NonNull BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        this.dLX = baseActivity;
        this.dLY = bdUniqueId;
    }

    public void a(b bVar) {
        this.dLZ = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dMb == null) {
            return 0;
        }
        return this.dMb.size();
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
            view = LayoutInflater.from(this.dLX.getPageContext().getPageActivity()).inflate(a.h.item_guard_join_list, viewGroup, false);
            aVar = new a();
            aVar.dMe = (HeadImageView) view.findViewById(a.g.img_guard_club_list_header);
            aVar.dMe.setIsRound(true);
            aVar.dMe.setAutoChangeStyle(false);
            aVar.dMf = (TextView) view.findViewById(a.g.name_textView);
            aVar.dMg = (TextView) view.findViewById(a.g.nameSuffix_textView);
            aVar.dMh = (TextView) view.findViewById(a.g.tv_guard_club_list_num);
            aVar.dMi = (TbImageView) view.findViewById(a.g.guard_club_header_pendent);
            aVar.dMj = (LottieAnimationView) view.findViewById(a.g.live_anim);
            aVar.dMk = (TextView) view.findViewById(a.g.tv_guard_club_list_exit);
            view.setTag(aVar);
            this.dMa.add(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.guardclub.model.g gVar = this.dMb.get(i);
        if (gVar != null) {
            aVar.dMe.startLoad(gVar.dOe, 12, false);
            aVar.dMe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.a(gVar);
                }
            });
            int width = aVar.dMg.getWidth();
            if (width <= 0) {
                aVar.dMg.measure(0, 0);
                width = aVar.dMg.getMeasuredWidth();
            }
            String str2 = gVar.dNX;
            if (str2 != null && str2.endsWith("的真爱团")) {
                String substring = str2.substring(0, str2.lastIndexOf("的真爱团"));
                aVar.dMf.setPadding(0, 0, width, 0);
                aVar.dMg.setVisibility(0);
                str = substring;
            } else {
                aVar.dMf.setPadding(0, 0, 0, 0);
                aVar.dMg.setVisibility(4);
                str = str2;
            }
            aVar.dMf.setText(str);
            aVar.dMh.setText(String.format(this.dLX.getResources().getString(a.i.guard_join_list_contribution), gVar.score));
            aVar.dMe.setScaleX(1.0f);
            aVar.dMe.setScaleY(1.0f);
            if (gVar.liveStatus == 1) {
                a(aVar);
            } else {
                b(aVar);
            }
            String mO = m.aLx().mO(gVar.dOc);
            if (!TextUtils.isEmpty(mO)) {
                aVar.dMi.setVisibility(0);
                aVar.dMi.startLoad(mO, 10, false);
            } else {
                aVar.dMi.setVisibility(8);
            }
            aVar.dMk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dLZ != null) {
                        d.this.dLZ.a(gVar, i);
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
        aVar.dMj.setVisibility(0);
        aVar.dMj.setAnimation("live_anim_guard_join.json");
        aVar.dMj.setVisibility(0);
        aVar.dMj.loop(true);
        aVar.dMj.playAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.dMe, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.dMe, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setDuration(1000);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        if (aVar.dMl == null) {
            aVar.dMl = new AnimatorSet();
        } else {
            aVar.dMl.cancel();
        }
        aVar.dMl.play(ofFloat).with(ofFloat2);
        aVar.dMl.start();
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.dMj.setVisibility(8);
        aVar.dMj.cancelAnimation();
        if (aVar.dMl != null) {
            aVar.dMl.cancel();
        }
        aVar.dMe.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        if (gVar != null) {
            try {
                if (gVar.liveStatus == 1 && !TextUtils.isEmpty(gVar.liveId)) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.dLX);
                    alaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(gVar.liveId).longValue(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                } else {
                    GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.dLX.getPageContext().getPageActivity(), Long.valueOf(gVar.dOu).longValue(), 0L, false, "", true);
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
            this.dMb = new ArrayList(list);
        } else {
            this.dMb = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public void bu(List<com.baidu.tieba.ala.guardclub.model.g> list) {
        if (list != null && !list.isEmpty()) {
            if (this.dMb == null) {
                this.dMb = new ArrayList();
            }
            this.dMb.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void mI(int i) {
        if (this.dMb != null && this.dMb.size() > 0 && i >= 0 && i < this.dMb.size()) {
            this.dMb.remove(i);
            notifyDataSetChanged();
        }
    }

    public void aLp() {
        if (this.dMa != null && this.dMa.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dMa.size()) {
                    b(this.dMa.get(i2));
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
        private HeadImageView dMe;
        private TextView dMf;
        private TextView dMg;
        private TextView dMh;
        private TbImageView dMi;
        private LottieAnimationView dMj;
        private TextView dMk;
        private AnimatorSet dMl;

        private a() {
        }
    }
}
