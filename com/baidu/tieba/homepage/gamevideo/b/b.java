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
    private TbPageContext duG;
    private RelativeLayout eHL;
    private RelativeLayout eSl;
    private ImageView fqM;
    private GameVideoGridView hLS;
    private com.baidu.tieba.homepage.gamevideo.a.b hLT;
    private com.baidu.tieba.homepage.gamevideo.view.a hLW;
    private TextView hLX;
    private a hLY;
    private TranslateAnimation hLZ;
    private TranslateAnimation hMa;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean hMb = false;
    private Animation.AnimationListener hMc = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.hMb = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.hMb = false;
            b.this.bYS();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.hLT != null && i < b.this.hLT.getCount() && b.this.hLT.getItem(i) != null && (b.this.hLT.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.hLT.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.hLY != null) {
                        b.this.hLY.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bYS();
                    TiebaStatic.log(new an("c13489").af("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bYR();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.hLY != null) {
                b.this.hLY.bYV();
            }
        }
    };
    private a.InterfaceC0555a hMd = new a.InterfaceC0555a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0555a
        public void bYT() {
            b.this.bYQ();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bYU();

        void bYV();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.duG = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.duG.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.eSl = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.eHL = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.fqM = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.hLX = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.hLS = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.hLS.setMaxHeight(l.getEquipmentWidth(this.duG.getPageActivity()));
        this.hLS.setNumColumns(4);
        this.hLS.setEmptyView(this.eHL);
        this.hLT = new com.baidu.tieba.homepage.gamevideo.a.b(this.duG, 102, this.mBdUniqueId);
        this.hLS.setAdapter((ListAdapter) this.hLT);
        this.hLS.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bYP();
        onChangeSkinType();
    }

    private void bYP() {
        this.hLZ = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.hLZ.setDuration(300L);
        this.hLZ.setFillAfter(true);
        this.hLZ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hMa = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.hMa.setDuration(200L);
        this.hMa.setFillAfter(true);
        this.hMa.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hMa.setAnimationListener(this.hMc);
    }

    public void vR(int i) {
        if (this.hLT != null) {
            this.hLT.vR(i);
        }
    }

    public void onChangeSkinType() {
        if (this.eSl != null) {
            am.setBackgroundResource(this.eSl, R.color.cp_bg_line_d);
        }
        if (this.hLX != null) {
            am.setViewTextColor(this.hLX, (int) R.color.cp_cont_d);
        }
        if (this.fqM != null) {
            am.setImageResource(this.fqM, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.hLT.setData(list);
    }

    public void cg(View view) {
        if (view != null) {
            this.hLT.notifyDataSetChanged();
            if (this.hLW == null) {
                this.hLW = new com.baidu.tieba.homepage.gamevideo.view.a(this.duG, this.mRootView, -1, -1);
                this.hLW.setBackgroundDrawable(new ColorDrawable(this.duG.getResources().getColor(R.color.black_alpha66)));
                this.hLW.setAnimationStyle(0);
                this.hLW.a(this.hMd);
                this.hLW.setFocusable(true);
                this.hLW.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.hLW.isShowing()) {
                this.hLW.dismiss();
            }
            this.hLW.showAsDropDown(view, 0, 0);
            this.hLS.bZc();
            if (this.eSl != null && this.hLZ != null) {
                this.eSl.startAnimation(this.hLZ);
            }
            if (this.hLY != null) {
                this.hLY.bYU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYQ() {
        if (this.hMa != null && this.eSl != null && !this.hMb) {
            this.eSl.startAnimation(this.hMa);
        }
    }

    public void bYR() {
        if (this.hLW != null) {
            this.hLW.dismiss();
        }
    }

    public void bYS() {
        if (this.hLW != null) {
            this.hLW.bmF();
        }
    }

    public boolean isShowing() {
        if (this.hLW != null) {
            return this.hLW.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.hLY = aVar;
    }

    public void onDestroy() {
        bYS();
        if (this.hLZ != null) {
            this.hLZ.cancel();
        }
        if (this.hMa != null) {
            this.hMa.cancel();
        }
        if (this.hLS != null) {
            this.hLS.onDestroy();
        }
    }
}
