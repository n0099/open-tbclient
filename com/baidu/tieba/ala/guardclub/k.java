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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardclub.model.p;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private a eCa;
    private String eCb;
    private List<p> eCc;
    private int eCd;
    private float eCe;
    private float eCf;
    private int eCg;
    private int mType;

    /* loaded from: classes2.dex */
    public interface a {
        void a(p pVar);

        void b(p pVar);
    }

    public k(Context context) {
        this.eCe = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.eCf = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.eCg = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.eCg = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void ya(String str) {
        this.eCb = str;
    }

    public void a(a aVar) {
        this.eCa = aVar;
    }

    public List<p> getDatas() {
        return this.eCc;
    }

    public void setData(List<p> list) {
        if (this.eCc == null) {
            this.eCc = new ArrayList();
        }
        this.eCc.clear();
        bw(list);
    }

    public void bw(List<p> list) {
        if (this.eCc == null) {
            this.eCc = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.eCc.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCc != null) {
            return this.eCc.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pb */
    public p getItem(int i) {
        if (getCount() > i) {
            return this.eCc.get(i);
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
            bVar2.eCj = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.eCk = view.findViewById(a.g.layout_avatar);
            bVar2.eCl = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.eCm = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.eCl, bVar2.eCm);
            bVar2.eCn = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aro = (TextView) view.findViewById(a.g.tv_name);
            bVar2.eAM = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.eCp = (TextView) view.findViewById(a.g.tv_content);
            bVar2.eCq = view.findViewById(a.g.layout_action);
            bVar2.eCr = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.eCs = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.eCj.setText("99+");
            bVar.eCj.setTextSize(0, this.eCf);
            return;
        }
        bVar.eCj.setText(String.valueOf(i + 4));
        bVar.eCj.setTextSize(0, this.eCe);
    }

    private void a(b bVar, final p pVar) {
        bVar.eCl.stopLoad();
        bVar.eCl.startLoad(pVar.avatar, 12, false, false);
        bVar.eCm.stopLoad();
        b(bVar);
        bVar.eCl.setScaleX(1.0f);
        bVar.eCl.setScaleY(1.0f);
        if (pVar.liveStatus != 1 || TextUtils.isEmpty(pVar.liveId)) {
            bVar.eCn.setVisibility(8);
        } else {
            bVar.eCn.setVisibility(0);
            a(bVar);
        }
        String pe = l.bcZ().pe(pVar.level);
        if (!TextUtils.isEmpty(pe)) {
            bVar.eCm.startLoad(pe, 10, false);
            bVar.eCm.setVisibility(0);
        } else {
            bVar.eCm.setVisibility(8);
        }
        bVar.eCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.eCa != null) {
                    k.this.eCa.a(pVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, p pVar) {
        if (this.eCd <= 0) {
            this.eCd = bVar.eAM.getWidth();
            if (this.eCd <= 0) {
                bVar.eAM.measure(0, 0);
                this.eCd = bVar.eAM.getMeasuredWidth();
            }
        }
        String str = pVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aro.setPadding(0, 0, this.eCd, 0);
            bVar.eAM.setVisibility(0);
        } else {
            bVar.aro.setPadding(0, 0, 0, 0);
            bVar.eAM.setVisibility(4);
        }
        bVar.aro.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = pVar.eDv;
                break;
            case 1:
                str2 = pVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.eCp.setText(String.format(context.getResources().getString(this.eCg), str2));
    }

    private void b(b bVar, final p pVar) {
        if (TextUtils.isEmpty(this.eCb) || TextUtils.isEmpty(pVar.abx) || !this.eCb.equals(pVar.abx)) {
            bVar.eCq.setVisibility(0);
            if (pVar.eDw) {
                bVar.eCs.setVisibility(0);
                bVar.eCr.setVisibility(8);
                return;
            }
            bVar.eCs.setVisibility(8);
            bVar.eCr.setVisibility(0);
            bVar.eCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.eCa != null) {
                        k.this.eCa.b(pVar);
                    }
                }
            });
            return;
        }
        bVar.eCq.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.eCo == null) {
            bVar.eCo = new AnimatorSet();
        }
        bVar.eCn.setAnimation("live_anim_guard_join.json");
        bVar.eCn.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.eCl, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.eCl, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.eCo.setDuration(1000L);
        bVar.eCo.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.eCo.play(ofFloat).with(ofFloat2);
        bVar.eCn.playAnimation();
        bVar.eCo.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.eCn.cancelAnimation();
        if (bVar.eCo == null) {
            return;
        }
        bVar.eCo.cancel();
    }

    /* loaded from: classes2.dex */
    public class b {
        private TextView aro;
        private TextView eAM;
        private TextView eCj;
        private View eCk;
        private HeadImageView eCl;
        private TbImageView eCm;
        private LottieAnimationView eCn;
        private AnimatorSet eCo;
        private TextView eCp;
        private View eCq;
        private TextView eCr;
        private TextView eCs;

        public b() {
        }

        public void recycle() {
            bcY();
        }

        public void bcY() {
            k.this.b(this);
        }
    }
}
