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
    private TbPageContext cVi;
    private ImageView eLY;
    private RelativeLayout ehF;
    private RelativeLayout eox;
    private GameVideoGridView haU;
    private com.baidu.tieba.homepage.gamevideo.a.b haV;
    private com.baidu.tieba.homepage.gamevideo.view.a haY;
    private TextView haZ;
    private a hba;
    private TranslateAnimation hbb;
    private TranslateAnimation hbc;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean hbd = false;
    private Animation.AnimationListener hbe = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.hbd = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.hbd = false;
            b.this.bOd();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.haV != null && i < b.this.haV.getCount() && b.this.haV.getItem(i) != null && (b.this.haV.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.haV.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.hba != null) {
                        b.this.hba.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bOd();
                    TiebaStatic.log(new an("c13489").X("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bOc();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.hba != null) {
                b.this.hba.bOg();
            }
        }
    };
    private a.InterfaceC0518a hbf = new a.InterfaceC0518a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0518a
        public void bOe() {
            b.this.bOb();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bOf();

        void bOg();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVi = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.eox = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ehF = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.eLY = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.haZ = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.haU = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.haU.setMaxHeight(l.getEquipmentWidth(this.cVi.getPageActivity()));
        this.haU.setNumColumns(4);
        this.haU.setEmptyView(this.ehF);
        this.haV = new com.baidu.tieba.homepage.gamevideo.a.b(this.cVi, 102, this.mBdUniqueId);
        this.haU.setAdapter((ListAdapter) this.haV);
        this.haU.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bOa();
        onChangeSkinType();
    }

    private void bOa() {
        this.hbb = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.hbb.setDuration(300L);
        this.hbb.setFillAfter(true);
        this.hbb.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hbc = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.hbc.setDuration(200L);
        this.hbc.setFillAfter(true);
        this.hbc.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hbc.setAnimationListener(this.hbe);
    }

    public void vm(int i) {
        if (this.haV != null) {
            this.haV.vm(i);
        }
    }

    public void onChangeSkinType() {
        if (this.eox != null) {
            am.setBackgroundResource(this.eox, R.color.cp_bg_line_d);
        }
        if (this.haZ != null) {
            am.setViewTextColor(this.haZ, (int) R.color.cp_cont_d);
        }
        if (this.eLY != null) {
            am.setImageResource(this.eLY, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.haV.setData(list);
    }

    public void bY(View view) {
        if (view != null) {
            this.haV.notifyDataSetChanged();
            if (this.haY == null) {
                this.haY = new com.baidu.tieba.homepage.gamevideo.view.a(this.cVi, this.mRootView, -1, -1);
                this.haY.setBackgroundDrawable(new ColorDrawable(this.cVi.getResources().getColor(R.color.black_alpha66)));
                this.haY.setAnimationStyle(0);
                this.haY.a(this.hbf);
                this.haY.setFocusable(true);
                this.haY.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.haY.isShowing()) {
                this.haY.dismiss();
            }
            this.haY.showAsDropDown(view, 0, 0);
            this.haU.bOn();
            if (this.eox != null && this.hbb != null) {
                this.eox.startAnimation(this.hbb);
            }
            if (this.hba != null) {
                this.hba.bOf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOb() {
        if (this.hbc != null && this.eox != null && !this.hbd) {
            this.eox.startAnimation(this.hbc);
        }
    }

    public void bOc() {
        if (this.haY != null) {
            this.haY.dismiss();
        }
    }

    public void bOd() {
        if (this.haY != null) {
            this.haY.bdJ();
        }
    }

    public boolean isShowing() {
        if (this.haY != null) {
            return this.haY.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.hba = aVar;
    }

    public void onDestroy() {
        bOd();
        if (this.hbb != null) {
            this.hbb.cancel();
        }
        if (this.hbc != null) {
            this.hbc.cancel();
        }
        if (this.haU != null) {
            this.haU.onDestroy();
        }
    }
}
