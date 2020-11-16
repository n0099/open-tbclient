package com.baidu.tieba.homepage.gamevideo.b;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private TbPageContext eGu;
    private RelativeLayout fYx;
    private ImageView gQk;
    private RelativeLayout gmc;
    private GameVideoGridView jBe;
    private com.baidu.tieba.homepage.gamevideo.a.b jBf;
    private com.baidu.tieba.homepage.gamevideo.view.a jBi;
    private TextView jBj;
    private a jBk;
    private TranslateAnimation jBl;
    private TranslateAnimation jBm;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean jBn = false;
    private Animation.AnimationListener jBo = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.jBn = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.jBn = false;
            b.this.cJF();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.jBf != null && i < b.this.jBf.getCount() && b.this.jBf.getItem(i) != null && (b.this.jBf.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.jBf.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.jBk != null) {
                        b.this.jBk.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cJF();
                    TiebaStatic.log(new ar("c13489").ak("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cJE();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.jBk != null) {
                b.this.jBk.cJI();
            }
        }
    };
    private a.InterfaceC0744a jBp = new a.InterfaceC0744a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0744a
        public void cJG() {
            b.this.cJD();
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cJH();

        void cJI();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eGu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gmc = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fYx = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gQk = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.jBj = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.jBe = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.jBe.setMaxHeight(l.getEquipmentWidth(this.eGu.getPageActivity()));
        this.jBe.setNumColumns(4);
        this.jBe.setEmptyView(this.fYx);
        this.jBf = new com.baidu.tieba.homepage.gamevideo.a.b(this.eGu, 102, this.mBdUniqueId);
        this.jBe.setAdapter((ListAdapter) this.jBf);
        this.jBe.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cJC();
        onChangeSkinType();
    }

    private void cJC() {
        this.jBl = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.jBl.setDuration(300L);
        this.jBl.setFillAfter(true);
        this.jBl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jBm = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.jBm.setDuration(200L);
        this.jBm.setFillAfter(true);
        this.jBm.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jBm.setAnimationListener(this.jBo);
    }

    public void Cc(int i) {
        if (this.jBf != null) {
            this.jBf.Cc(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gmc != null) {
            ap.setBackgroundResource(this.gmc, R.color.CAM_X0201);
        }
        if (this.jBj != null) {
            ap.setViewTextColor(this.jBj, R.color.CAM_X0109);
        }
        if (this.gQk != null) {
            ap.setImageResource(this.gQk, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.jBf.setData(list);
    }

    public void cP(View view) {
        if (view != null) {
            this.jBf.notifyDataSetChanged();
            if (this.jBi == null) {
                this.jBi = new com.baidu.tieba.homepage.gamevideo.view.a(this.eGu, this.mRootView, -1, -1);
                this.jBi.setBackgroundDrawable(new ColorDrawable(this.eGu.getResources().getColor(R.color.black_alpha66)));
                this.jBi.setAnimationStyle(0);
                this.jBi.a(this.jBp);
                this.jBi.setFocusable(true);
                this.jBi.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.jBi.isShowing()) {
                this.jBi.dismiss();
            }
            this.jBi.showAsDropDown(view, 0, 0);
            this.jBe.cJP();
            if (this.gmc != null && this.jBl != null) {
                this.gmc.startAnimation(this.jBl);
            }
            if (this.jBk != null) {
                this.jBk.cJH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJD() {
        if (this.jBm != null && this.gmc != null && !this.jBn) {
            this.gmc.startAnimation(this.jBm);
        }
    }

    public void cJE() {
        if (this.jBi != null) {
            this.jBi.dismiss();
        }
    }

    public void cJF() {
        if (this.jBi != null) {
            this.jBi.Wr();
        }
    }

    public boolean isShowing() {
        if (this.jBi != null) {
            return this.jBi.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.jBk = aVar;
    }

    public void onDestroy() {
        cJF();
        if (this.jBl != null) {
            this.jBl.cancel();
        }
        if (this.jBm != null) {
            this.jBm.cancel();
        }
        if (this.jBe != null) {
            this.jBe.onDestroy();
        }
    }
}
