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
    private TbPageContext cfl;
    private ImageView dRQ;
    private RelativeLayout dyZ;
    private GameVideoGridView giG;
    private com.baidu.tieba.homepage.gamevideo.a.b giH;
    private com.baidu.tieba.homepage.gamevideo.view.a giK;
    private RelativeLayout giL;
    private TextView giM;
    private a giN;
    private TranslateAnimation giO;
    private TranslateAnimation giP;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean giQ = false;
    private Animation.AnimationListener giR = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.giQ = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.giQ = false;
            b.this.bue();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.giH != null && i < b.this.giH.getCount() && b.this.giH.getItem(i) != null && (b.this.giH.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.giH.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.giN != null) {
                        b.this.giN.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bue();
                    TiebaStatic.log(new an("c13489").O("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bud();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.giN != null) {
                b.this.giN.buh();
            }
        }
    };
    private a.InterfaceC0426a giS = new a.InterfaceC0426a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0426a
        public void buf() {
            b.this.buc();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bug();

        void buh();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cfl = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.dyZ = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.giL = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.dRQ = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.giM = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.giG = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.giG.setMaxHeight(l.getEquipmentWidth(this.cfl.getPageActivity()));
        this.giG.setNumColumns(4);
        this.giG.setEmptyView(this.giL);
        this.giH = new com.baidu.tieba.homepage.gamevideo.a.b(this.cfl, 102, this.mBdUniqueId);
        this.giG.setAdapter((ListAdapter) this.giH);
        this.giG.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bub();
        onChangeSkinType();
    }

    private void bub() {
        this.giO = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.giO.setDuration(300L);
        this.giO.setFillAfter(true);
        this.giO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.giP = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.giP.setDuration(200L);
        this.giP.setFillAfter(true);
        this.giP.setInterpolator(new AccelerateDecelerateInterpolator());
        this.giP.setAnimationListener(this.giR);
    }

    public void sZ(int i) {
        if (this.giH != null) {
            this.giH.sZ(i);
        }
    }

    public void onChangeSkinType() {
        if (this.dyZ != null) {
            am.setBackgroundResource(this.dyZ, R.color.cp_bg_line_d);
        }
        if (this.giM != null) {
            am.setViewTextColor(this.giM, (int) R.color.cp_cont_d);
        }
        if (this.dRQ != null) {
            am.setImageResource(this.dRQ, R.drawable.new_pic_emotion_gray_09);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.giH.setData(list);
    }

    public void bY(View view) {
        if (view != null) {
            this.giH.notifyDataSetChanged();
            if (this.giK == null) {
                this.giK = new com.baidu.tieba.homepage.gamevideo.view.a(this.cfl, this.mRootView, -1, -1);
                this.giK.setBackgroundDrawable(new ColorDrawable(this.cfl.getResources().getColor(R.color.black_alpha66)));
                this.giK.setAnimationStyle(0);
                this.giK.a(this.giS);
                this.giK.setFocusable(true);
                this.giK.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.giK.isShowing()) {
                this.giK.dismiss();
            }
            this.giK.showAsDropDown(view, 0, 0);
            this.giG.buo();
            if (this.dyZ != null && this.giO != null) {
                this.dyZ.startAnimation(this.giO);
            }
            if (this.giN != null) {
                this.giN.bug();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buc() {
        if (this.giP != null && this.dyZ != null && !this.giQ) {
            this.dyZ.startAnimation(this.giP);
        }
    }

    public void bud() {
        if (this.giK != null) {
            this.giK.dismiss();
        }
    }

    public void bue() {
        if (this.giK != null) {
            this.giK.aNF();
        }
    }

    public boolean isShowing() {
        if (this.giK != null) {
            return this.giK.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.giN = aVar;
    }

    public void onDestroy() {
        bue();
        if (this.giO != null) {
            this.giO.cancel();
        }
        if (this.giP != null) {
            this.giP.cancel();
        }
        if (this.giG != null) {
            this.giG.onDestroy();
        }
    }
}
