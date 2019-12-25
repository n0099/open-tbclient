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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardclub.model.p;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private a eAP;
    private String eAQ;
    private List<p> eAR;
    private int eAS;
    private float eAT;
    private float eAU;
    private int eAV;
    private int mType;

    /* loaded from: classes2.dex */
    public interface a {
        void a(p pVar);

        void b(p pVar);
    }

    public k(Context context) {
        this.eAT = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.eAU = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.eAV = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.eAV = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void xV(String str) {
        this.eAQ = str;
    }

    public void a(a aVar) {
        this.eAP = aVar;
    }

    public List<p> getDatas() {
        return this.eAR;
    }

    public void setData(List<p> list) {
        if (this.eAR == null) {
            this.eAR = new ArrayList();
        }
        this.eAR.clear();
        bw(list);
    }

    public void bw(List<p> list) {
        if (this.eAR == null) {
            this.eAR = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.eAR.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAR != null) {
            return this.eAR.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pa */
    public p getItem(int i) {
        if (getCount() > i) {
            return this.eAR.get(i);
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
            bVar2.eAY = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.eAZ = view.findViewById(a.g.layout_avatar);
            bVar2.eBa = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.eBb = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.eBa, bVar2.eBb);
            bVar2.eBc = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aqC = (TextView) view.findViewById(a.g.tv_name);
            bVar2.ezB = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.eBe = (TextView) view.findViewById(a.g.tv_content);
            bVar2.eBf = view.findViewById(a.g.layout_action);
            bVar2.eBg = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.eBh = (TextView) view.findViewById(a.g.tv_joined);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        p item = getItem(i);
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
            bVar.eAY.setText("99+");
            bVar.eAY.setTextSize(0, this.eAU);
            return;
        }
        bVar.eAY.setText(String.valueOf(i + 4));
        bVar.eAY.setTextSize(0, this.eAT);
    }

    private void a(b bVar, final p pVar) {
        bVar.eBa.stopLoad();
        bVar.eBa.startLoad(pVar.avatar, 12, false, false);
        bVar.eBb.stopLoad();
        b(bVar);
        bVar.eBa.setScaleX(1.0f);
        bVar.eBa.setScaleY(1.0f);
        if (pVar.liveStatus != 1 || TextUtils.isEmpty(pVar.liveId)) {
            bVar.eBc.setVisibility(8);
        } else {
            bVar.eBc.setVisibility(0);
            a(bVar);
        }
        String pd = l.bcE().pd(pVar.level);
        if (!TextUtils.isEmpty(pd)) {
            bVar.eBb.startLoad(pd, 10, false);
            bVar.eBb.setVisibility(0);
        } else {
            bVar.eBb.setVisibility(8);
        }
        bVar.eAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.eAP != null) {
                    k.this.eAP.a(pVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, p pVar) {
        if (this.eAS <= 0) {
            this.eAS = bVar.ezB.getWidth();
            if (this.eAS <= 0) {
                bVar.ezB.measure(0, 0);
                this.eAS = bVar.ezB.getMeasuredWidth();
            }
        }
        String str = pVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aqC.setPadding(0, 0, this.eAS, 0);
            bVar.ezB.setVisibility(0);
        } else {
            bVar.aqC.setPadding(0, 0, 0, 0);
            bVar.ezB.setVisibility(4);
        }
        bVar.aqC.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = pVar.eCk;
                break;
            case 1:
                str2 = pVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.eBe.setText(String.format(context.getResources().getString(this.eAV), str2));
    }

    private void b(b bVar, final p pVar) {
        if (TextUtils.isEmpty(this.eAQ) || TextUtils.isEmpty(pVar.abl) || !this.eAQ.equals(pVar.abl)) {
            bVar.eBf.setVisibility(0);
            if (pVar.eCl) {
                bVar.eBh.setVisibility(0);
                bVar.eBg.setVisibility(8);
                return;
            }
            bVar.eBh.setVisibility(8);
            bVar.eBg.setVisibility(0);
            bVar.eBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.eAP != null) {
                        k.this.eAP.b(pVar);
                    }
                }
            });
            return;
        }
        bVar.eBf.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.eBd == null) {
            bVar.eBd = new AnimatorSet();
        }
        bVar.eBc.setAnimation("live_anim_guard_join.json");
        bVar.eBc.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.eBa, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.eBa, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.eBd.setDuration(1000L);
        bVar.eBd.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.eBd.play(ofFloat).with(ofFloat2);
        bVar.eBc.playAnimation();
        bVar.eBd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.eBc.cancelAnimation();
        if (bVar.eBd == null) {
            return;
        }
        bVar.eBd.cancel();
    }

    /* loaded from: classes2.dex */
    public class b {
        private TextView aqC;
        private TextView eAY;
        private View eAZ;
        private HeadImageView eBa;
        private TbImageView eBb;
        private LottieAnimationView eBc;
        private AnimatorSet eBd;
        private TextView eBe;
        private View eBf;
        private TextView eBg;
        private TextView eBh;
        private TextView ezB;

        public b() {
        }

        public void recycle() {
            bcD();
        }

        public void bcD() {
            k.this.b(this);
        }
    }
}
