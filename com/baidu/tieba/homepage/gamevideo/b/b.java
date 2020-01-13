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
/* loaded from: classes7.dex */
public class b {
    private TbPageContext cRe;
    private ImageView eHQ;
    private RelativeLayout edo;
    private RelativeLayout ejY;
    private GameVideoGridView gYG;
    private com.baidu.tieba.homepage.gamevideo.a.b gYH;
    private com.baidu.tieba.homepage.gamevideo.view.a gYK;
    private TextView gYL;
    private a gYM;
    private TranslateAnimation gYN;
    private TranslateAnimation gYO;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean gYP = false;
    private Animation.AnimationListener gYQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.gYP = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.gYP = false;
            b.this.bMy();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.gYH != null && i < b.this.gYH.getCount() && b.this.gYH.getItem(i) != null && (b.this.gYH.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.gYH.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.gYM != null) {
                        b.this.gYM.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bMy();
                    TiebaStatic.log(new an("c13489").Z("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bMx();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.gYM != null) {
                b.this.gYM.bMB();
            }
        }
    };
    private a.InterfaceC0511a gYR = new a.InterfaceC0511a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0511a
        public void bMz() {
            b.this.bMw();
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bMA();

        void bMB();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cRe = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.ejY = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.edo = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.eHQ = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.gYL = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.gYG = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.gYG.setMaxHeight(l.getEquipmentWidth(this.cRe.getPageActivity()));
        this.gYG.setNumColumns(4);
        this.gYG.setEmptyView(this.edo);
        this.gYH = new com.baidu.tieba.homepage.gamevideo.a.b(this.cRe, 102, this.mBdUniqueId);
        this.gYG.setAdapter((ListAdapter) this.gYH);
        this.gYG.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bMv();
        onChangeSkinType();
    }

    private void bMv() {
        this.gYN = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.gYN.setDuration(300L);
        this.gYN.setFillAfter(true);
        this.gYN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gYO = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.gYO.setDuration(200L);
        this.gYO.setFillAfter(true);
        this.gYO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gYO.setAnimationListener(this.gYQ);
    }

    public void vg(int i) {
        if (this.gYH != null) {
            this.gYH.vg(i);
        }
    }

    public void onChangeSkinType() {
        if (this.ejY != null) {
            am.setBackgroundResource(this.ejY, R.color.cp_bg_line_d);
        }
        if (this.gYL != null) {
            am.setViewTextColor(this.gYL, (int) R.color.cp_cont_d);
        }
        if (this.eHQ != null) {
            am.setImageResource(this.eHQ, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.gYH.setData(list);
    }

    public void bY(View view) {
        if (view != null) {
            this.gYH.notifyDataSetChanged();
            if (this.gYK == null) {
                this.gYK = new com.baidu.tieba.homepage.gamevideo.view.a(this.cRe, this.mRootView, -1, -1);
                this.gYK.setBackgroundDrawable(new ColorDrawable(this.cRe.getResources().getColor(R.color.black_alpha66)));
                this.gYK.setAnimationStyle(0);
                this.gYK.a(this.gYR);
                this.gYK.setFocusable(true);
                this.gYK.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.gYK.isShowing()) {
                this.gYK.dismiss();
            }
            this.gYK.showAsDropDown(view, 0, 0);
            this.gYG.bMI();
            if (this.ejY != null && this.gYN != null) {
                this.ejY.startAnimation(this.gYN);
            }
            if (this.gYM != null) {
                this.gYM.bMA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMw() {
        if (this.gYO != null && this.ejY != null && !this.gYP) {
            this.ejY.startAnimation(this.gYO);
        }
    }

    public void bMx() {
        if (this.gYK != null) {
            this.gYK.dismiss();
        }
    }

    public void bMy() {
        if (this.gYK != null) {
            this.gYK.bbr();
        }
    }

    public boolean isShowing() {
        if (this.gYK != null) {
            return this.gYK.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.gYM = aVar;
    }

    public void onDestroy() {
        bMy();
        if (this.gYN != null) {
            this.gYN.cancel();
        }
        if (this.gYO != null) {
            this.gYO.cancel();
        }
        if (this.gYG != null) {
            this.gYG.onDestroy();
        }
    }
}
