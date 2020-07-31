package com.baidu.tieba.ala.guardclub;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class m extends BaseAdapter {
    private String fEQ;
    private a fPU;
    private List<com.baidu.tieba.ala.guardclub.model.k> fPV;
    private int fPW;
    private float fPX;
    private float fPY;
    private int fPZ;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.fPX = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.fPY = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.fPZ = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.fPZ = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void CZ(String str) {
        this.fEQ = str;
    }

    public void a(a aVar) {
        this.fPU = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.fPV;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fPV == null) {
            this.fPV = new ArrayList();
        }
        this.fPV.clear();
        bP(list);
    }

    public void bP(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fPV == null) {
            this.fPV = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.fPV.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fPV != null) {
            return this.fPV.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rg */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.fPV.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.live_guard_club_rank_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.fGw = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.fQc = view.findViewById(a.g.layout_avatar);
            bVar2.fGy = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.fQd = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fGy, bVar2.fQd);
            bVar2.fQe = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.avN = (TextView) view.findViewById(a.g.tv_name);
            bVar2.fOG = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fGE = (TextView) view.findViewById(a.g.tv_content);
            bVar2.fQg = view.findViewById(a.g.layout_action);
            bVar2.fQh = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.fQi = (TextView) view.findViewById(a.g.tv_joined);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.ala.guardclub.model.k item = getItem(i);
        if (item != null) {
            a(bVar, i);
            a(bVar, item);
            a(bVar, viewGroup.getContext(), item);
            b(bVar, item);
        }
        return view;
    }

    private void a(HeadImageView headImageView, TbImageView tbImageView) {
        headImageView.setIsRound(true);
        headImageView.setDrawBorder(false);
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.setAutoChangeStyle(false);
        headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
        tbImageView.setDefaultBgResource(a.d.sdk_transparent);
        tbImageView.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void a(b bVar, int i) {
        if (i + 4 >= 100) {
            bVar.fGw.setText("99+");
            bVar.fGw.setTextSize(0, this.fPY);
            return;
        }
        bVar.fGw.setText(String.valueOf(i + 4));
        bVar.fGw.setTextSize(0, this.fPX);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fGy.stopLoad();
        bVar.fGy.startLoad(kVar.avatar, 12, false, false);
        bVar.fQd.stopLoad();
        b(bVar);
        bVar.fGy.setScaleX(1.0f);
        bVar.fGy.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.fQe.setVisibility(8);
        } else {
            bVar.fQe.setVisibility(0);
            a(bVar);
        }
        String cD = com.baidu.live.guardclub.g.CJ().cD(kVar.level);
        if (!TextUtils.isEmpty(cD)) {
            bVar.fQd.startLoad(cD, 10, false);
            bVar.fQd.setVisibility(0);
        } else {
            bVar.fQd.setVisibility(8);
        }
        bVar.fQc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fPU != null) {
                    m.this.fPU.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.fPW <= 0) {
            this.fPW = bVar.fOG.getWidth();
            if (this.fPW <= 0) {
                bVar.fOG.measure(0, 0);
                this.fPW = bVar.fOG.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.avN.setPadding(0, 0, this.fPW, 0);
            bVar.fOG.setVisibility(0);
        } else {
            bVar.avN.setPadding(0, 0, 0, 0);
            bVar.fOG.setVisibility(4);
        }
        bVar.avN.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.fQG;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fGE.setText(String.format(context.getResources().getString(this.fPZ), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.fEQ) || TextUtils.isEmpty(kVar.aEX) || !this.fEQ.equals(kVar.aEX)) {
            bVar.fQg.setVisibility(0);
            if (kVar.fQH) {
                bVar.fQi.setVisibility(0);
                bVar.fQh.setVisibility(8);
                return;
            }
            bVar.fQi.setVisibility(8);
            bVar.fQh.setVisibility(0);
            bVar.fQh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.fPU != null) {
                        m.this.fPU.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.fQg.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.fQf == null) {
            bVar.fQf = new AnimatorSet();
        }
        bVar.fQe.setAnimation("live_anim_guard_join.json");
        bVar.fQe.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fGy, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fGy, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.fQf.setDuration(1000L);
        bVar.fQf.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.fQf.play(ofFloat).with(ofFloat2);
        bVar.fQe.playAnimation();
        bVar.fQf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.fQe.cancelAnimation();
        if (bVar.fQf == null) {
            return;
        }
        bVar.fQf.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView avN;
        private TextView fGE;
        private TextView fGw;
        private HeadImageView fGy;
        private TextView fOG;
        private View fQc;
        private TbImageView fQd;
        private LottieAnimationView fQe;
        private AnimatorSet fQf;
        private View fQg;
        private TextView fQh;
        private TextView fQi;

        public b() {
        }

        public void recycle() {
            bAQ();
        }

        public void bAQ() {
            m.this.b(this);
        }
    }
}
