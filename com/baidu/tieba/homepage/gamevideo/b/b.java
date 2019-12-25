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
/* loaded from: classes6.dex */
public class b {
    private TbPageContext cQU;
    private ImageView eGG;
    private RelativeLayout edg;
    private RelativeLayout ejk;
    private GameVideoGridView gVi;
    private com.baidu.tieba.homepage.gamevideo.a.b gVj;
    private com.baidu.tieba.homepage.gamevideo.view.a gVm;
    private TextView gVn;
    private a gVo;
    private TranslateAnimation gVp;
    private TranslateAnimation gVq;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean gVr = false;
    private Animation.AnimationListener gVs = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.gVr = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.gVr = false;
            b.this.bLq();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.gVj != null && i < b.this.gVj.getCount() && b.this.gVj.getItem(i) != null && (b.this.gVj.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.gVj.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.gVo != null) {
                        b.this.gVo.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bLq();
                    TiebaStatic.log(new an("c13489").Z("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bLp();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.gVo != null) {
                b.this.gVo.bLt();
            }
        }
    };
    private a.InterfaceC0507a gVt = new a.InterfaceC0507a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0507a
        public void bLr() {
            b.this.bLo();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bLs();

        void bLt();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cQU = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.ejk = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.edg = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.eGG = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.gVn = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.gVi = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.gVi.setMaxHeight(l.getEquipmentWidth(this.cQU.getPageActivity()));
        this.gVi.setNumColumns(4);
        this.gVi.setEmptyView(this.edg);
        this.gVj = new com.baidu.tieba.homepage.gamevideo.a.b(this.cQU, 102, this.mBdUniqueId);
        this.gVi.setAdapter((ListAdapter) this.gVj);
        this.gVi.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bLn();
        onChangeSkinType();
    }

    private void bLn() {
        this.gVp = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.gVp.setDuration(300L);
        this.gVp.setFillAfter(true);
        this.gVp.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gVq = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.gVq.setDuration(200L);
        this.gVq.setFillAfter(true);
        this.gVq.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gVq.setAnimationListener(this.gVs);
    }

    public void vb(int i) {
        if (this.gVj != null) {
            this.gVj.vb(i);
        }
    }

    public void onChangeSkinType() {
        if (this.ejk != null) {
            am.setBackgroundResource(this.ejk, R.color.cp_bg_line_d);
        }
        if (this.gVn != null) {
            am.setViewTextColor(this.gVn, (int) R.color.cp_cont_d);
        }
        if (this.eGG != null) {
            am.setImageResource(this.eGG, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.gVj.setData(list);
    }

    public void bT(View view) {
        if (view != null) {
            this.gVj.notifyDataSetChanged();
            if (this.gVm == null) {
                this.gVm = new com.baidu.tieba.homepage.gamevideo.view.a(this.cQU, this.mRootView, -1, -1);
                this.gVm.setBackgroundDrawable(new ColorDrawable(this.cQU.getResources().getColor(R.color.black_alpha66)));
                this.gVm.setAnimationStyle(0);
                this.gVm.a(this.gVt);
                this.gVm.setFocusable(true);
                this.gVm.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.gVm.isShowing()) {
                this.gVm.dismiss();
            }
            this.gVm.showAsDropDown(view, 0, 0);
            this.gVi.bLA();
            if (this.ejk != null && this.gVp != null) {
                this.ejk.startAnimation(this.gVp);
            }
            if (this.gVo != null) {
                this.gVo.bLs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLo() {
        if (this.gVq != null && this.ejk != null && !this.gVr) {
            this.ejk.startAnimation(this.gVq);
        }
    }

    public void bLp() {
        if (this.gVm != null) {
            this.gVm.dismiss();
        }
    }

    public void bLq() {
        if (this.gVm != null) {
            this.gVm.baW();
        }
    }

    public boolean isShowing() {
        if (this.gVm != null) {
            return this.gVm.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.gVo = aVar;
    }

    public void onDestroy() {
        bLq();
        if (this.gVp != null) {
            this.gVp.cancel();
        }
        if (this.gVq != null) {
            this.gVq.cancel();
        }
        if (this.gVi != null) {
            this.gVi.onDestroy();
        }
    }
}
