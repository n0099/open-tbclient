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
    private List<p> dNA;
    private int dNB;
    private float dNC;
    private float dND;
    private int dNE;
    private a dNy;
    private String dNz;
    private int mType;

    /* loaded from: classes6.dex */
    public interface a {
        void a(p pVar);

        void b(p pVar);
    }

    public l(Context context) {
        this.dNC = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.dND = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.dNE = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.dNE = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void tk(String str) {
        this.dNz = str;
    }

    public void a(a aVar) {
        this.dNy = aVar;
    }

    public List<p> getDatas() {
        return this.dNA;
    }

    public void setData(List<p> list) {
        if (this.dNA == null) {
            this.dNA = new ArrayList();
        }
        this.dNA.clear();
        bx(list);
    }

    public void bx(List<p> list) {
        if (this.dNA == null) {
            this.dNA = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.dNA.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dNA != null) {
            return this.dNA.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mL */
    public p getItem(int i) {
        if (getCount() > i) {
            return this.dNA.get(i);
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
            bVar2.dNH = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.dNI = view.findViewById(a.g.layout_avatar);
            bVar2.dNJ = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.dNK = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.dNJ, bVar2.dNK);
            bVar2.dNL = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.dMf = (TextView) view.findViewById(a.g.tv_name);
            bVar2.dMg = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.dNN = (TextView) view.findViewById(a.g.tv_content);
            bVar2.dNO = view.findViewById(a.g.layout_action);
            bVar2.dNP = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.dNQ = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.dNH.setText("99+");
            bVar.dNH.setTextSize(0, this.dND);
            return;
        }
        bVar.dNH.setText(String.valueOf(i + 4));
        bVar.dNH.setTextSize(0, this.dNC);
    }

    private void a(b bVar, final p pVar) {
        bVar.dNJ.stopLoad();
        bVar.dNJ.startLoad(pVar.avatar, 12, false, false);
        bVar.dNK.stopLoad();
        b(bVar);
        bVar.dNJ.setScaleX(1.0f);
        bVar.dNJ.setScaleY(1.0f);
        if (pVar.liveStatus != 1 || TextUtils.isEmpty(pVar.liveId)) {
            bVar.dNL.setVisibility(8);
        } else {
            bVar.dNL.setVisibility(0);
            a(bVar);
        }
        String mO = m.aLx().mO(pVar.level);
        if (!TextUtils.isEmpty(mO)) {
            bVar.dNK.startLoad(mO, 10, false);
            bVar.dNK.setVisibility(0);
        } else {
            bVar.dNK.setVisibility(8);
        }
        bVar.dNI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.dNy != null) {
                    l.this.dNy.a(pVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, p pVar) {
        if (this.dNB <= 0) {
            this.dNB = bVar.dMg.getWidth();
            if (this.dNB <= 0) {
                bVar.dMg.measure(0, 0);
                this.dNB = bVar.dMg.getMeasuredWidth();
            }
        }
        String str = pVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.dMf.setPadding(0, 0, this.dNB, 0);
            bVar.dMg.setVisibility(0);
        } else {
            bVar.dMf.setPadding(0, 0, 0, 0);
            bVar.dMg.setVisibility(4);
        }
        bVar.dMf.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = pVar.dOU;
                break;
            case 1:
                str2 = pVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.dNN.setText(String.format(context.getResources().getString(this.dNE), str2));
    }

    private void b(b bVar, final p pVar) {
        if (TextUtils.isEmpty(this.dNz) || TextUtils.isEmpty(pVar.dOu) || !this.dNz.equals(pVar.dOu)) {
            bVar.dNO.setVisibility(0);
            if (pVar.dOV) {
                bVar.dNQ.setVisibility(0);
                bVar.dNP.setVisibility(8);
                return;
            }
            bVar.dNQ.setVisibility(8);
            bVar.dNP.setVisibility(0);
            bVar.dNP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (l.this.dNy != null) {
                        l.this.dNy.b(pVar);
                    }
                }
            });
            return;
        }
        bVar.dNO.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.dNM == null) {
            bVar.dNM = new AnimatorSet();
        }
        bVar.dNL.setAnimation("live_anim_guard_join.json");
        bVar.dNL.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.dNJ, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.dNJ, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.dNM.setDuration(1000L);
        bVar.dNM.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.dNM.play(ofFloat).with(ofFloat2);
        bVar.dNL.playAnimation();
        bVar.dNM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.dNL.cancelAnimation();
        if (bVar.dNM == null) {
            return;
        }
        bVar.dNM.cancel();
    }

    /* loaded from: classes6.dex */
    public class b {
        private TextView dMf;
        private TextView dMg;
        private TextView dNH;
        private View dNI;
        private HeadImageView dNJ;
        private TbImageView dNK;
        private LottieAnimationView dNL;
        private AnimatorSet dNM;
        private TextView dNN;
        private View dNO;
        private TextView dNP;
        private TextView dNQ;

        public b() {
        }

        public void recycle() {
            aLw();
        }

        public void aLw() {
            l.this.b(this);
        }
    }
}
