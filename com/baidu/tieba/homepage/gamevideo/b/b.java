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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext etO;
    private RelativeLayout fKJ;
    private RelativeLayout fWD;
    private ImageView gzd;
    private GameVideoGridView jhN;
    private com.baidu.tieba.homepage.gamevideo.a.b jhO;
    private com.baidu.tieba.homepage.gamevideo.view.a jhR;
    private TextView jhS;
    private a jhT;
    private TranslateAnimation jhU;
    private TranslateAnimation jhV;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean jhW = false;
    private Animation.AnimationListener jhX = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.jhW = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.jhW = false;
            b.this.cEs();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.jhO != null && i < b.this.jhO.getCount() && b.this.jhO.getItem(i) != null && (b.this.jhO.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.jhO.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.jhT != null) {
                        b.this.jhT.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cEs();
                    TiebaStatic.log(new aq("c13489").aj("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cEr();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.jhT != null) {
                b.this.jhT.cEv();
            }
        }
    };
    private a.InterfaceC0711a jhY = new a.InterfaceC0711a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0711a
        public void cEt() {
            b.this.cEq();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cEu();

        void cEv();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.etO = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.fWD = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fKJ = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gzd = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.jhS = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.jhN = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.jhN.setMaxHeight(l.getEquipmentWidth(this.etO.getPageActivity()));
        this.jhN.setNumColumns(4);
        this.jhN.setEmptyView(this.fKJ);
        this.jhO = new com.baidu.tieba.homepage.gamevideo.a.b(this.etO, 102, this.mBdUniqueId);
        this.jhN.setAdapter((ListAdapter) this.jhO);
        this.jhN.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cEp();
        onChangeSkinType();
    }

    private void cEp() {
        this.jhU = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.jhU.setDuration(300L);
        this.jhU.setFillAfter(true);
        this.jhU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jhV = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.jhV.setDuration(200L);
        this.jhV.setFillAfter(true);
        this.jhV.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jhV.setAnimationListener(this.jhX);
    }

    public void AY(int i) {
        if (this.jhO != null) {
            this.jhO.AY(i);
        }
    }

    public void onChangeSkinType() {
        if (this.fWD != null) {
            ap.setBackgroundResource(this.fWD, R.color.cp_bg_line_d);
        }
        if (this.jhS != null) {
            ap.setViewTextColor(this.jhS, R.color.cp_cont_d);
        }
        if (this.gzd != null) {
            ap.setImageResource(this.gzd, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.jhO.setData(list);
    }

    public void cC(View view) {
        if (view != null) {
            this.jhO.notifyDataSetChanged();
            if (this.jhR == null) {
                this.jhR = new com.baidu.tieba.homepage.gamevideo.view.a(this.etO, this.mRootView, -1, -1);
                this.jhR.setBackgroundDrawable(new ColorDrawable(this.etO.getResources().getColor(R.color.black_alpha66)));
                this.jhR.setAnimationStyle(0);
                this.jhR.a(this.jhY);
                this.jhR.setFocusable(true);
                this.jhR.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.jhR.isShowing()) {
                this.jhR.dismiss();
            }
            this.jhR.showAsDropDown(view, 0, 0);
            this.jhN.cEC();
            if (this.fWD != null && this.jhU != null) {
                this.fWD.startAnimation(this.jhU);
            }
            if (this.jhT != null) {
                this.jhT.cEu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEq() {
        if (this.jhV != null && this.fWD != null && !this.jhW) {
            this.fWD.startAnimation(this.jhV);
        }
    }

    public void cEr() {
        if (this.jhR != null) {
            this.jhR.dismiss();
        }
    }

    public void cEs() {
        if (this.jhR != null) {
            this.jhR.TA();
        }
    }

    public boolean isShowing() {
        if (this.jhR != null) {
            return this.jhR.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.jhT = aVar;
    }

    public void onDestroy() {
        cEs();
        if (this.jhU != null) {
            this.jhU.cancel();
        }
        if (this.jhV != null) {
            this.jhV.cancel();
        }
        if (this.jhN != null) {
            this.jhN.onDestroy();
        }
    }
}
