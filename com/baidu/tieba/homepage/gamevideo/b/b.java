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
/* loaded from: classes4.dex */
public class b {
    private TbPageContext ceu;
    private ImageView dQZ;
    private RelativeLayout dyi;
    private GameVideoGridView ghO;
    private com.baidu.tieba.homepage.gamevideo.a.b ghP;
    private com.baidu.tieba.homepage.gamevideo.view.a ghS;
    private RelativeLayout ghT;
    private TextView ghU;
    private a ghV;
    private TranslateAnimation ghW;
    private TranslateAnimation ghX;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean ghY = false;
    private Animation.AnimationListener ghZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.ghY = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.ghY = false;
            b.this.buc();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.ghP != null && i < b.this.ghP.getCount() && b.this.ghP.getItem(i) != null && (b.this.ghP.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.ghP.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.ghV != null) {
                        b.this.ghV.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.buc();
                    TiebaStatic.log(new an("c13489").O("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bub();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.ghV != null) {
                b.this.ghV.buf();
            }
        }
    };
    private a.InterfaceC0421a gia = new a.InterfaceC0421a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0421a
        public void bud() {
            b.this.bua();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bue();

        void buf();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ceu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.dyi = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ghT = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.dQZ = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.ghU = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.ghO = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.ghO.setMaxHeight(l.getEquipmentWidth(this.ceu.getPageActivity()));
        this.ghO.setNumColumns(4);
        this.ghO.setEmptyView(this.ghT);
        this.ghP = new com.baidu.tieba.homepage.gamevideo.a.b(this.ceu, 102, this.mBdUniqueId);
        this.ghO.setAdapter((ListAdapter) this.ghP);
        this.ghO.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        btZ();
        onChangeSkinType();
    }

    private void btZ() {
        this.ghW = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.ghW.setDuration(300L);
        this.ghW.setFillAfter(true);
        this.ghW.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ghX = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.ghX.setDuration(200L);
        this.ghX.setFillAfter(true);
        this.ghX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ghX.setAnimationListener(this.ghZ);
    }

    public void sY(int i) {
        if (this.ghP != null) {
            this.ghP.sY(i);
        }
    }

    public void onChangeSkinType() {
        if (this.dyi != null) {
            am.setBackgroundResource(this.dyi, R.color.cp_bg_line_d);
        }
        if (this.ghU != null) {
            am.setViewTextColor(this.ghU, (int) R.color.cp_cont_d);
        }
        if (this.dQZ != null) {
            am.setImageResource(this.dQZ, R.drawable.new_pic_emotion_gray_09);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.ghP.setData(list);
    }

    public void bY(View view) {
        if (view != null) {
            this.ghP.notifyDataSetChanged();
            if (this.ghS == null) {
                this.ghS = new com.baidu.tieba.homepage.gamevideo.view.a(this.ceu, this.mRootView, -1, -1);
                this.ghS.setBackgroundDrawable(new ColorDrawable(this.ceu.getResources().getColor(R.color.black_alpha66)));
                this.ghS.setAnimationStyle(0);
                this.ghS.a(this.gia);
                this.ghS.setFocusable(true);
                this.ghS.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.ghS.isShowing()) {
                this.ghS.dismiss();
            }
            this.ghS.showAsDropDown(view, 0, 0);
            this.ghO.bum();
            if (this.dyi != null && this.ghW != null) {
                this.dyi.startAnimation(this.ghW);
            }
            if (this.ghV != null) {
                this.ghV.bue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bua() {
        if (this.ghX != null && this.dyi != null && !this.ghY) {
            this.dyi.startAnimation(this.ghX);
        }
    }

    public void bub() {
        if (this.ghS != null) {
            this.ghS.dismiss();
        }
    }

    public void buc() {
        if (this.ghS != null) {
            this.ghS.aND();
        }
    }

    public boolean isShowing() {
        if (this.ghS != null) {
            return this.ghS.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.ghV = aVar;
    }

    public void onDestroy() {
        buc();
        if (this.ghW != null) {
            this.ghW.cancel();
        }
        if (this.ghX != null) {
            this.ghX.cancel();
        }
        if (this.ghO != null) {
            this.ghO.onDestroy();
        }
    }
}
