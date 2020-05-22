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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext dIF;
    private RelativeLayout eUq;
    private ImageView fEL;
    private RelativeLayout feY;
    private com.baidu.tieba.homepage.gamevideo.a.b iaA;
    private com.baidu.tieba.homepage.gamevideo.view.a iaD;
    private TextView iaE;
    private a iaF;
    private TranslateAnimation iaG;
    private TranslateAnimation iaH;
    private GameVideoGridView iaz;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean iaI = false;
    private Animation.AnimationListener iaJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.iaI = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.iaI = false;
            b.this.cfm();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.iaA != null && i < b.this.iaA.getCount() && b.this.iaA.getItem(i) != null && (b.this.iaA.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.iaA.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.iaF != null) {
                        b.this.iaF.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cfm();
                    TiebaStatic.log(new an("c13489").ag("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cfl();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.iaF != null) {
                b.this.iaF.cfp();
            }
        }
    };
    private a.InterfaceC0626a iaK = new a.InterfaceC0626a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0626a
        public void cfn() {
            b.this.cfk();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cfo();

        void cfp();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dIF = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.feY = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.eUq = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.fEL = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.iaE = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.iaz = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.iaz.setMaxHeight(l.getEquipmentWidth(this.dIF.getPageActivity()));
        this.iaz.setNumColumns(4);
        this.iaz.setEmptyView(this.eUq);
        this.iaA = new com.baidu.tieba.homepage.gamevideo.a.b(this.dIF, 102, this.mBdUniqueId);
        this.iaz.setAdapter((ListAdapter) this.iaA);
        this.iaz.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cfj();
        onChangeSkinType();
    }

    private void cfj() {
        this.iaG = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.iaG.setDuration(300L);
        this.iaG.setFillAfter(true);
        this.iaG.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iaH = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.iaH.setDuration(200L);
        this.iaH.setFillAfter(true);
        this.iaH.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iaH.setAnimationListener(this.iaJ);
    }

    public void wx(int i) {
        if (this.iaA != null) {
            this.iaA.wx(i);
        }
    }

    public void onChangeSkinType() {
        if (this.feY != null) {
            am.setBackgroundResource(this.feY, R.color.cp_bg_line_d);
        }
        if (this.iaE != null) {
            am.setViewTextColor(this.iaE, (int) R.color.cp_cont_d);
        }
        if (this.fEL != null) {
            am.setImageResource(this.fEL, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.iaA.setData(list);
    }

    public void cg(View view) {
        if (view != null) {
            this.iaA.notifyDataSetChanged();
            if (this.iaD == null) {
                this.iaD = new com.baidu.tieba.homepage.gamevideo.view.a(this.dIF, this.mRootView, -1, -1);
                this.iaD.setBackgroundDrawable(new ColorDrawable(this.dIF.getResources().getColor(R.color.black_alpha66)));
                this.iaD.setAnimationStyle(0);
                this.iaD.a(this.iaK);
                this.iaD.setFocusable(true);
                this.iaD.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.iaD.isShowing()) {
                this.iaD.dismiss();
            }
            this.iaD.showAsDropDown(view, 0, 0);
            this.iaz.cfw();
            if (this.feY != null && this.iaG != null) {
                this.feY.startAnimation(this.iaG);
            }
            if (this.iaF != null) {
                this.iaF.cfo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfk() {
        if (this.iaH != null && this.feY != null && !this.iaI) {
            this.feY.startAnimation(this.iaH);
        }
    }

    public void cfl() {
        if (this.iaD != null) {
            this.iaD.dismiss();
        }
    }

    public void cfm() {
        if (this.iaD != null) {
            this.iaD.bsb();
        }
    }

    public boolean isShowing() {
        if (this.iaD != null) {
            return this.iaD.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.iaF = aVar;
    }

    public void onDestroy() {
        cfm();
        if (this.iaG != null) {
            this.iaG.cancel();
        }
        if (this.iaH != null) {
            this.iaH.cancel();
        }
        if (this.iaz != null) {
            this.iaz.onDestroy();
        }
    }
}
