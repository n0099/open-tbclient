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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardclub.model.p;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends BaseAdapter {
    private a dMH;
    private String dMI;
    private List<p> dMJ;
    private int dMK;
    private float dML;
    private float dMM;
    private int dMN;
    private int mType;

    /* loaded from: classes6.dex */
    public interface a {
        void a(p pVar);

        void b(p pVar);
    }

    public l(Context context) {
        this.dML = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.dMM = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.dMN = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.dMN = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void tk(String str) {
        this.dMI = str;
    }

    public void a(a aVar) {
        this.dMH = aVar;
    }

    public List<p> getDatas() {
        return this.dMJ;
    }

    public void setData(List<p> list) {
        if (this.dMJ == null) {
            this.dMJ = new ArrayList();
        }
        this.dMJ.clear();
        bx(list);
    }

    public void bx(List<p> list) {
        if (this.dMJ == null) {
            this.dMJ = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.dMJ.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dMJ != null) {
            return this.dMJ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mK */
    public p getItem(int i) {
        if (getCount() > i) {
            return this.dMJ.get(i);
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
            bVar2.dMQ = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.dMR = view.findViewById(a.g.layout_avatar);
            bVar2.dMS = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.dMT = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.dMS, bVar2.dMT);
            bVar2.dMU = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.dLo = (TextView) view.findViewById(a.g.tv_name);
            bVar2.dLp = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.dMW = (TextView) view.findViewById(a.g.tv_content);
            bVar2.dMX = view.findViewById(a.g.layout_action);
            bVar2.dMY = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.dMZ = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.dMQ.setText("99+");
            bVar.dMQ.setTextSize(0, this.dMM);
            return;
        }
        bVar.dMQ.setText(String.valueOf(i + 4));
        bVar.dMQ.setTextSize(0, this.dML);
    }

    private void a(b bVar, final p pVar) {
        bVar.dMS.stopLoad();
        bVar.dMS.startLoad(pVar.avatar, 12, false, false);
        bVar.dMT.stopLoad();
        b(bVar);
        bVar.dMS.setScaleX(1.0f);
        bVar.dMS.setScaleY(1.0f);
        if (pVar.liveStatus != 1 || TextUtils.isEmpty(pVar.liveId)) {
            bVar.dMU.setVisibility(8);
        } else {
            bVar.dMU.setVisibility(0);
            a(bVar);
        }
        String mN = m.aLv().mN(pVar.level);
        if (!TextUtils.isEmpty(mN)) {
            bVar.dMT.startLoad(mN, 10, false);
            bVar.dMT.setVisibility(0);
        } else {
            bVar.dMT.setVisibility(8);
        }
        bVar.dMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.dMH != null) {
                    l.this.dMH.a(pVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, p pVar) {
        if (this.dMK <= 0) {
            this.dMK = bVar.dLp.getWidth();
            if (this.dMK <= 0) {
                bVar.dLp.measure(0, 0);
                this.dMK = bVar.dLp.getMeasuredWidth();
            }
        }
        String str = pVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.dLo.setPadding(0, 0, this.dMK, 0);
            bVar.dLp.setVisibility(0);
        } else {
            bVar.dLo.setPadding(0, 0, 0, 0);
            bVar.dLp.setVisibility(4);
        }
        bVar.dLo.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = pVar.dOd;
                break;
            case 1:
                str2 = pVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.dMW.setText(String.format(context.getResources().getString(this.dMN), str2));
    }

    private void b(b bVar, final p pVar) {
        if (TextUtils.isEmpty(this.dMI) || TextUtils.isEmpty(pVar.dND) || !this.dMI.equals(pVar.dND)) {
            bVar.dMX.setVisibility(0);
            if (pVar.dOe) {
                bVar.dMZ.setVisibility(0);
                bVar.dMY.setVisibility(8);
                return;
            }
            bVar.dMZ.setVisibility(8);
            bVar.dMY.setVisibility(0);
            bVar.dMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (l.this.dMH != null) {
                        l.this.dMH.b(pVar);
                    }
                }
            });
            return;
        }
        bVar.dMX.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.dMV == null) {
            bVar.dMV = new AnimatorSet();
        }
        bVar.dMU.setAnimation("live_anim_guard_join.json");
        bVar.dMU.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.dMS, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.dMS, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.dMV.setDuration(1000L);
        bVar.dMV.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.dMV.play(ofFloat).with(ofFloat2);
        bVar.dMU.playAnimation();
        bVar.dMV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.dMU.cancelAnimation();
        if (bVar.dMV == null) {
            return;
        }
        bVar.dMV.cancel();
    }

    /* loaded from: classes6.dex */
    public class b {
        private TextView dLo;
        private TextView dLp;
        private TextView dMQ;
        private View dMR;
        private HeadImageView dMS;
        private TbImageView dMT;
        private LottieAnimationView dMU;
        private AnimatorSet dMV;
        private TextView dMW;
        private View dMX;
        private TextView dMY;
        private TextView dMZ;

        public b() {
        }

        public void recycle() {
            aLu();
        }

        public void aLu() {
            l.this.b(this);
        }
    }
}
